package com.upic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.common.web.exception.WebException;
import com.upic.po.Comment;
import com.upic.po.LeaveMessage;
import com.upic.po.LogComment;
import com.upic.po.Shop;
import com.upic.po.StatusClass;
import com.upic.po.User;
import com.upic.service.ICommentService;
import com.upic.service.ILeaveMessageService;
import com.upic.service.ILogCommentService;
import com.upic.service.ILogService;
import com.upic.service.IShopService;

@Controller
@RequestMapping("/comment")
public class CommentController {
    private static Log log = LogFactory.getLog(CommentController.class);

    @Autowired(required = false)
    private ICommentService shopComment;

    @Autowired(required = false)
    private ILogCommentService logCommentService;

    @Autowired(required = false)
    private IShopService shopService;

    @Autowired(required = false)
    private ILogService logService;

    @Autowired(required = false)
    private ILeaveMessageService leaveMessageService;

    /**
     * 根据不同类型加载不同的评论
     *
     * @param typeId
     * @param objId
     * @param pageNumStr
     * @param numPerPageStr
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("listPage/{typeId}/{id}/{pageNumStr}/{numPerPageStr}")
    public PageBean listPage(@PathVariable("typeId") int typeId, @PathVariable("id") int objId,
                             @PathVariable("pageNumStr") String pageNumStr, @PathVariable("numPerPageStr") String numPerPageStr,
                             HttpSession session) {
        try {

            int numPerPage = 10;
            int pageNum = 1;
            if (StringUtils.isNotBlank(numPerPageStr)) {
                numPerPage = Integer.parseInt(numPerPageStr);
            }
            if (StringUtils.isNotBlank(pageNumStr)) {
                pageNum = Integer.valueOf(pageNumStr);
            }
            Map<String, Object> paramMap = new HashMap<String, Object>();
            PageBean listPage = null;
            switch (typeId) {
                // 商品评论
                case 1:
                    paramMap.put("shopId", objId);
                    listPage = shopComment.listPage(new PageParam(pageNum, numPerPage), paramMap);
                    break;
                // 日志评论
                case 2:
                    paramMap.put("logId", objId);
                    listPage = logCommentService.listPage(new PageParam(pageNum, numPerPage), paramMap);
                    break;
                default:
                    break;
            }
            return listPage;
        } catch (WebException e) {
            log.error("== searchCollectionByType exception:", e);
            throw new WebException("1003", e.getMessage());
        }
    }

    /**
     * 根据不同类型添加不同的评论
     *
     * @param typeId
     * @param objId
     * @param content
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("addComment/{typeId}/{id}")
    public StatusClass addComment(@PathVariable("typeId") int typeId, @PathVariable("id") int objId,
                                  @RequestParam("content") String content, HttpSession session) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            StatusClass s = new StatusClass();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                s.setStatus("error");
                s.setContent("获取用户失败，请重新刷新页面");
                return s;
            }
            switch (typeId) {
                // 添加商品评论
                case 1:
                    Shop byId = shopService.getById(objId);
                    if (byId.getStatus() != 100) {
                        s.setStatus("error");
                        s.setContent("商品已下线");
                        return s;
                    }
                    Comment c = new Comment();
                    c.setContent(content);
                    c.setNickName(user.getNickName());
                    c.setPhoneNum(user.getPhoneNum());
                    c.setOpenId(user.getOpenId());
                    c.setPic(user.getHeadImagUrl());
                    c.setShopId(Integer.parseInt(byId.getId() + ""));
                    long insert = shopComment.insert(c);
                    if (insert <= 0) {
                        s.setStatus("error");
                        s.setContent("评论失败，请重试");
                        return s;
                    }

                    break;
                // 添加日志评论
                case 2:
                    paramMap.put("logId", objId);
                    com.upic.po.Log byId2 = logService.getById(objId);
                    if (byId2 == null) {
                        s.setStatus("error");
                        s.setContent("日志已删除");
                        return s;
                    }
                    LogComment logCpment = new LogComment();
                    logCpment.setContent(content);
                    logCpment.setNickName(user.getNickName());
                    logCpment.setPhoneNum(user.getPhoneNum());
                    logCpment.setOpenId(user.getOpenId());
                    logCpment.setPic(user.getHeadImagUrl());
                    logCpment.setLogId(Integer.parseInt(byId2.getId() + ""));
                    long commentInsert = logCommentService.insert(logCpment);
                    if (commentInsert <= 0) {
                        s.setStatus("error");
                        s.setContent("评论失败，请重试");
                        return s;
                    }
                    break;
                default:
                    break;
            }
            s.setStatus("success");
            s.setContent("评论成功");
            return s;
        } catch (WebException e) {
            log.error("== addComment exception:", e);
            throw new WebException("1003", e.getMessage());
        }
    }

    /**
     * 根据类型准备不同参数(跳转到添加页面)
     *
     * @param model
     * @param typeId
     * @param objId
     * @return
     */
    @RequestMapping("forwordPage/{typeId}/{objId}")
    public String forwordPage(Model model, @PathVariable("typeId") int typeId, @PathVariable("objId") int objId) {
        // String url = "";
        try {
            model.addAttribute("typeId", typeId);
            model.addAttribute("objId", objId);
            switch (typeId) {
                // 商品评论
                case 1:
                    Shop shop = shopService.getById(objId);
                    model.addAttribute("shop", shop);
                    // url="";
                    break;
                // 日志评论
                case 2:
                    com.upic.po.Log byId = logService.getById(objId);
                    model.addAttribute("log", byId);
                    // url="";
                    break;
                default:
                    break;
            }
        } catch (WebException e) {
            log.error("== forwordPage exception:", e);
            throw new WebException("1003", e.getMessage());
        }
        return "farmer/comment/addComment";
    }

    /**
     * 跳转到准备加载评论页面
     *
     * @param model
     * @param typeId
     * @param objId
     * @return
     */
    @RequestMapping("forwordPageToGetComment/{typeId}/{objId}")
    public String forwordPageToGetComment(Model model, @PathVariable("typeId") int typeId,
                                          @PathVariable("objId") int objId) {
        // String url = "";
        try {
            model.addAttribute("typeId", typeId);
            model.addAttribute("objId", objId);
            switch (typeId) {
                // 商品评论
                case 1:
                    Shop shop = shopService.getById(objId);
                    model.addAttribute("title", shop.getShopTitle());
                    model.addAttribute("shop", shop);
                    // url="";
                    break;
                // 日志评论
                case 2:
                    com.upic.po.Log byId = logService.getById(objId);
                    model.addAttribute("log", byId);
                    // url="";
                    break;
                default:
                    break;
            }
        } catch (WebException e) {
            log.error("== forwordPage exception:", e);
            throw new WebException("1003", e.getMessage());
        }
        return "farmer/comment/shopCommentList";
    }

    /**
     * =========================================================================
     * ============================
     **/
    //用户反馈
    @ResponseBody
    @RequestMapping("userReflect")
    public StatusClass userReflect(Model model, @RequestParam("content") String content) {
        StatusClass s = new StatusClass();
        try {
            LeaveMessage l = new LeaveMessage();
            l.setContent(content);
            long insert = leaveMessageService.insert(l);
            if (insert == 0) {
                s.setStatus("ERROR");
                s.setContent("对不起，系统错误，请重新上传！");
                return s;
            }
            s.setContent("非常感谢您的宝贵意见，我们会根据您的意见做出及时调整！");
            s.setStatus("SUCCESS");
            return s;
        } catch (WebException e) {
            s.setStatus("ERROR");
            s.setContent("对不起，系统错误，请重新上传！");
            return s;
        }
    }

    /**********************************************20171001之后添加**********************************************/

    /**
     * 根据shopNumber获取评论
     *
     * @param shopId
     * @return
     */
    @GetMapping("getCommentByShopId")
    public List<Comment> getCommentByShopId(long shopId) {
        List<Comment> commentList = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("shopId", shopId);
            commentList = shopComment.listBy(paramMap);
        } catch (Exception e) {
            log.error("== getCommentByShopId：" + e.getMessage());
        }
        return commentList;
    }
}
