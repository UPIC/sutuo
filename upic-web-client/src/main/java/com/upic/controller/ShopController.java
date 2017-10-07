package com.upic.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.upic.po.*;
import com.upic.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.upic.common.page.PageBean;
import com.upic.common.page.PageParam;
import com.upic.common.web.exception.WebException;
import com.upic.shop.dto.TypeFarmShopDto;
import com.upic.shop.enums.ShopClassEnum;

@Controller
@RequestMapping("/shop")
public class ShopController {
    private static Log log = LogFactory.getLog(ShopController.class);

    @Autowired(required = false)
    private IShopService shopService;

    @Autowired(required = false)
    private IShopTicketService shopTicketService;

    @Autowired(required = false)
    private IShopFarmService shopFarmService;

    @Autowired(required = false)
    private IStoreService storeService;

    @Autowired(required = false)
    private IShopCollectionService myCollectionService;

    @Autowired(required = false)
    private IStoreOwnRecommendService storeOwnRecommendService;

    @Autowired(required = false)
    private IShopPicService shopPicService;

    @Autowired(required = false)
    private IProjectShopService shopProjectService;

    @Autowired(required = false)
    private ILogService logService;

    @Autowired(required = false)
    private ICommentService comentService;

    @Autowired(required = false)
    private IShopCollectionService shopCollectionService;

    @Autowired(required = false)
    private ITypeShopFarmService typeShopFarmService;

    @Autowired(required = false)
    private ITypeFarmShopService typeFarmShopService;

    @Autowired(required = false)
    private IStoreFarmService storeFarmService;

    @Autowired(required = false)
    private IShopFarmTypeService shopFarmTypeService;

    /**
     * 根据shopNumber找出商品信息
     *
     * @param model
     * @param shopNumber
     * @param session
     * @return
     */
    @RequestMapping(value = "searchBySN")
    public String searchSMByKywordAndType(Model model, @RequestParam("shopNumber") String shopNumber,
                                          HttpSession session) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("shopNumber", shopNumber);
            paramMap.put("status", 100);
            Shop s = (Shop) shopService.getBy(paramMap, "getByShopNumber");
            if (s == null) {
                // 异常处理，商品下线
            }
            paramMap.clear();
            paramMap.put("storeNumber", s.getStoreNumber());
            Store store = (Store) storeService.getBy(paramMap, "getByStoreNumber");

            // 查询收藏数据
            paramMap.clear();
            paramMap.put("shopId", s.getId());
            // paramMap.put("type", "shop");
            long collectionNum = (Long) myCollectionService.getBy(paramMap, "listPageCount");

            model.addAttribute("collectionNum", collectionNum);
            model.addAttribute("shopDetials", s);
            model.addAttribute("allNum", collectionNum);
            // model.addAttribute("store", store);
            // model.addAttribute("allNum", allCollectionNum);
            model.addAttribute("storeDetials", store);
            model.addAttribute("storeNumber", s.getStoreNumber());
            // 查找所有与此商品有关的标签
            paramMap.clear();
            paramMap.put("shopId", s.getId());
            List<Object> listBy2 = shopProjectService.listBy(paramMap, "listAll");
            model.addAttribute("projects", listBy2);
            // 查出所有相关图片
            paramMap.put("shopId", s.getId());
            List<ShopPic> listBy = shopPicService.listBy(paramMap);
            Collections.sort(listBy);
            model.addAttribute("shopPic", listBy);

            // 查出最新的一条日志
            if (store != null) {
                paramMap.clear();
                paramMap.put("storeId", store.getId());
                Object by = logService.getBy(paramMap, "getByOnlyOne");
                model.addAttribute("lastLog", by);
            }
            // 查找出最新两条评论
            paramMap.clear();
            paramMap.put("shopId", s.getId());
            List<Object> comments = comentService.listBy(paramMap, "getByTwoComment");
            model.addAttribute("comment", comments);
            long allComment = (Long) comentService.getBy(paramMap, "listPageCount");
            model.addAttribute("allComment", allComment);

            // 查询是否关注
            User user = (User) session.getAttribute("user");
            if (user != null) {
                paramMap.put("userId", user.getId());
                long num = (Long) shopCollectionService.getBy(paramMap, "listPageCount");
                if (num != 0) {
                    model.addAttribute("isCollection", num);
                }
            }
            // 虚拟商品
            if (s.getShopClass().equals(ShopClassEnum.TICKET.name())) {
                paramMap.clear();
                paramMap.put("shopId", s.getId());
                ShopTicket by = (ShopTicket) shopTicketService.getBy(paramMap, "getByShopId");
                model.addAttribute("shopTicket", by);

                return "farmer/shop/shopDetials";
            }
            // 实体商品
            if (s.getShopClass().equals(ShopClassEnum.FARM.name())) {
                paramMap.clear();
                paramMap.put("shopId", s.getId());
                ShopFarm by = (ShopFarm) shopFarmService.getBy(paramMap, "getByShopId");
                model.addAttribute("shopFarmer", by);
                return "";
            }
        } catch (WebException e) {
            log.error("== searchSMByKywordAndType exception:", e);
            throw new WebException("1003", "请求有误");
        }
        return "";
    }

    /**
     * 查看ticket详情
     *
     * @param model
     * @param ticketId
     * @param shopNumber
     * @return
     */
    @RequestMapping(value = "shopTicketDetils")
    public String searchTickdetilsById(Model model, @RequestParam("id") Long ticketId,
                                       @RequestParam("shopNumber") String shopNumber) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("shopNumber", shopNumber);
            Shop s = (Shop) shopService.getBy(paramMap, "getByShopNumber");
            if (s == null) {
                // 异常处理，商品下线
                throw new WebException("1003", "对不起，此商品不存在");
            }
            ShopTicket byId = shopTicketService.getById(ticketId);
            model.addAttribute("shopTicket", byId);
        } catch (WebException e) {
            log.error("== searchSMByKywordAndType exception:", e);
            throw new WebException("1003", e.getMessage());
        }
        return "farmer/shop/shopTicketContent";
    }

    /**
     *
     */
    @ResponseBody
    @RequestMapping(value = "searchYouLike")
    public PageBean searchYouLikeByCityAndTheme(@RequestParam("city") String city, @RequestParam("theme") String theme,
                                                Integer currentPage, Integer numPerPage) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("city", city);
            paramMap.put("theme", theme);
            paramMap.put("status", 100);
            PageBean listPage = shopService.listPage(new PageParam(currentPage, numPerPage), paramMap,
                    "listbycityandtheme");
            return listPage;
        } catch (WebException e) {
            log.error("== searchYouLikeByCityAndTheme exception:", e);
            throw new WebException("1003", e.getMessage());
        }
    }

    /**
     * 根据商家获取所推介的商品
     *
     * @param storeNumber
     * @return
     */
    @RequestMapping(value = "{storeNumber}/searchGoodShopByThemAndStoreNumber")
    public String readyGetGoodThing(@PathVariable("storeNumber") String storeNumber, Model model) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("storeNumber", storeNumber);
            paramMap.put("status", 100);
            List<Object> listBy = storeOwnRecommendService.listBy(paramMap, "listAll");
            model.addAttribute("listBy", listBy);
        } catch (WebException e) {
            log.error("== searchYouLikeByCityAndTheme exception:", e);
            throw new WebException("1003", e.getMessage());
        }
        return null;
    }

    /**
     * 根据吃、住、游、购、娱不同主题不同storeNumber查询出相应商品
     *
     * @param theme
     * @param storeNumber
     * @param currentPage
     * @param numPerPage
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "{theme}/{storeNumber}/searchShopByThemAndStoreNumber/{currentPage}/{numPerPage}")
    public PageBean searchShopByThemAndStoreNumber(@PathVariable("theme") String theme,
                                                   @PathVariable("storeNumber") String storeNumber, @PathVariable("currentPage") Integer currentPage,
                                                   @PathVariable("numPerPage") Integer numPerPage) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("storeNumber", storeNumber);
            paramMap.put("themeName", theme);
            paramMap.put("status", 100);
            PageBean listPage = shopService.listPage(new PageParam(currentPage, numPerPage), paramMap, "listAll");
            return listPage;
        } catch (WebException e) {
            log.error("== searchYouLikeByCityAndTheme exception:", e);
            throw new WebException("1003", e.getMessage());
        }
    }

    /************************************************************************************/

    /**
     * 就查看商品详情根据shopNumber
     */
    @RequestMapping("searchShopDetials/{shopNumber}")
    public String searchShopDetials(Model model, @PathVariable("shopNumber") String shopNumber) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("shopNumber", shopNumber);
            paramMap.put("status", 100);
            Shop s = (Shop) shopService.getBy(paramMap, "getByShopNumber");
            if (s == null) {
                // 异常处理，商品下线
            }
            model.addAttribute("shop", s);
        } catch (WebException e) {
            log.error("== searchShopDetials exception:", e);
            throw new WebException("1003", e.getMessage());
        }
        return "farmer/shop/searchShopDetials";
    }

    /**
     * 根据storeNumber获取相关信息
     *
     * @param storeNumber
     * @return
     */
    @ResponseBody
    @RequestMapping("searchShopFarmTypeDetails/{storeNumber}")
    public List<TypeShopFarm> searchShopFarmTypeAll(@PathVariable("storeNumber") String storeNumber) {
        List<TypeShopFarm> listBy = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("storeNumber", storeNumber);
            listBy = typeShopFarmService.listBy(paramMap);
            Collections.sort(listBy);
        } catch (WebException e) {
            log.error("== searchShopFarmTypeAll exception:", e);
        }
        return listBy;
    }

    /**
     * 根据storeNumber获取商家销售的相关信息
     *
     * @param storeNumber
     * @return
     */
    @ResponseBody
    @RequestMapping("getStoreFarm/{storeNumber}")
    public StoreFarm getStoreFarm(@PathVariable("storeNumber") String storeNumber) {
        StoreFarm s = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("storeNumber", storeNumber);
            s = (StoreFarm) storeFarmService.getBy(paramMap, "listAll");
        } catch (Exception e) {
            log.error("== getStoreFarm exception:", e);
            s = null;
        }
        return s;
    }

    /**
     * 根据typeId获取TypeFarmShopDto
     *
     * @param typeId
     * @return
     */
    @ResponseBody
    @RequestMapping("getAllFarmShopByTypeId/{typeId}")
    public List<TypeFarmShopDto> getAllFarmShopByTypeId(@PathVariable("typeId") String typeId) {
        List<TypeFarmShopDto> listBy = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("typeId", typeId);
            listBy = (List) typeFarmShopService.listBy(paramMap, "listAllByTypeFarm");
        } catch (Exception e) {
            log.error("== getStoreFarm exception:", e);
            listBy = null;
        }
        return listBy;
    }

    /**********************************************20171001之后添加**********************************************/

    /**
     * 根据shopClass查询对应的商品
     *
     * @param shopClass
     * @return
     */
    @GetMapping("/getShopByShopClass")
    public List<Shop> getShopByShopClass(String shopClass) {
        List<Shop> shopList = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("shopClass", shopClass);
            shopList = (List) shopService.listBy(paramMap);
        } catch (Exception e) {
            log.error("== getShopByShopClass exception:", e);
            shopList = null;
        }
        return shopList;
    }

    /**
     * 根据storeNumber加载ShopFarmType
     *
     * @param storeNumber
     * @return
     */
    @GetMapping("/getShopFarmTypeByStoreNumber")
    public List<ShopFarmType> getShopFarmTypeByStoreNumber(String storeNumber) {
        List<ShopFarmType> shopFarmTypeList = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("storeNumber", storeNumber);
            shopFarmTypeList = (List) shopFarmTypeService.listBy(paramMap);
        } catch (Exception e) {
            log.error("== getShopFarmTypeByStoreNumber exception:", e);
            shopFarmTypeList = null;
        }
        return shopFarmTypeList;
    }

    /**
     * 根据shopFarmTypeId加载Shop（Shop和ShopFarm联合查询，Shop中的status）
     *
     * @param shopFarmTypeId
     * @return
     */
    @GetMapping("/getShopByShopFarmTypeId")
    public List<Shop> getShopByShopFarmTypeId(@PathVariable("shopFarmTypeId") long shopFarmTypeId) {
        List<Shop> shopList = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("shopFarmTypeId", shopFarmTypeId);
            shopList = (List) shopService.listBy(paramMap, "getShopByShopFarmTypeId");
        } catch (Exception e) {
            log.error("== getShopByShopFarmTypeId exception:", e);
            shopList = null;
        }
        return shopList;
    }
}
