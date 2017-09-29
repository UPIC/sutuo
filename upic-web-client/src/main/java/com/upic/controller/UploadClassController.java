//package com.upic.controller;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.commons.net.util.Base64;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSONObject;
//import com.upic.common.page.PageBean;
//import com.upic.common.web.exception.WebException;
//import com.upic.controller.emun.OperDataEnum;
//import com.upic.controller.emun.OperEnstructInfoStatusEnum;
//import com.upic.controller.emun.OperPageAndUserEnum;
//import com.upic.pay.common.web.springmvc.SpringMvcControllerSupport;
//import com.upic.po.ClassUpload;
//import com.upic.po.Classess;
//import com.upic.po.StatusClass;
//import com.upic.po.Teacher;
//import com.upic.po.Training;
//import com.upic.po.TrainingTeacher;
//import com.upic.service.IApplyService;
//import com.upic.service.IClassService;
//import com.upic.service.IClassUploadService;
//import com.upic.service.ICommentService;
//import com.upic.service.IKeywordSecondService;
//import com.upic.service.ITeacherService;
//import com.upic.service.ITrainingService;
//import com.upic.service.ITrainingTeacherService;
//
//@Controller
//@RequestMapping("/classUpload")
//public class UploadClassController extends SpringMvcControllerSupport {
//	private static Log log = LogFactory.getLog(UploadClassController.class);
//	@Autowired
//	private IClassUploadService classUploadService;
//	@Autowired
//	private ITeacherService teacherService;
//	@Autowired
//	private ITrainingTeacherService trainingTeacherService;
//	@Autowired
//	private ICommentService commentService;
//	@Autowired
//	private IApplyService applyService;
//	@Autowired
//	private IKeywordSecondService keyWordSeervice;
//	@Autowired
//	private IClassService classService;
//	
//	private Training train;
//	private Teacher teacher;
//
//	
//	/**
//	 * 对于机构的课程上架以及下架操作
//	 * 
//	 * @param id
//	 * @param statusOnline
//	 * @return
//	 */
//	@RequestMapping(value = "{id}/{statusOnline}/downClass")
//	public String downClassByClassUploadId(@PathVariable("id") String id,
//			@PathVariable("statusOnline") Integer statusOnline) {
//		try {
//			long parseLong = Long.parseLong(id);
//			if (parseLong == 0) {
//				throw new WebException("1003", "请求有误,请重试");
//			}
//			ClassUpload upload = classUploadService.getById(parseLong);
//			if (upload == null) {
//				throw new WebException("1003", "获取信息有误，请重试");
//			}
//			statusOnline = statusOnline == 101 ? OperEnstructInfoStatusEnum.SUCCESS.getValue()
//					: OperEnstructInfoStatusEnum.FAIL.getValue();
//			upload.setStatusOnline(statusOnline);
//			long update = classUploadService.update(upload);
//			if (update == 0) {
//				throw new WebException("1003", "更新失败请重试，请重试");
//			}
//		} catch (WebException e) {
//			log.error("== downClassByClassUploadId exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//		return "redirect:/classUpload/teacher/list.do";
//	}
//
//	/**
//	 * 根据教师点击课程找出详细信息
//	 * 
//	 * @param model
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping(value = "teacher/{id}/classDetials")
//	public String teacherGetClassUploadDetials(Model model, @PathVariable("id") long id) {
//		try {
//			if (id == 0) {
//				throw new WebException("1003", "请求参数有误");
//			}
//			ClassUpload classupload = classUploadService.getById(id);
//			if (classupload == null) {
//				throw new WebException("1003", "获取信息失败请重试");
//			}
//			model.addAttribute(OperDataEnum.CLASSONE.getLabel(), classupload);
//		} catch (WebException e) {
//			log.error("== getClassUploadDetials exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//		return "vyyx/training/trainingCourseDetails";
//	}
//
//	/**
//	 * 准备更新数据
//	 * 
//	 * @param id
//	 *            ：加密后的课程id
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "{id}/readyClassUpload")
//	public String readyClassUpload(@PathVariable("id") String id, Model model) {
//
//		try {
//			long parseLong = Long.parseLong(id);
//			if (parseLong == 0) {
//				throw new WebException("1003", "请求有误,请重试");
//			}
//			ClassUpload classUpload = classUploadService.getById(parseLong);
//			if (classUpload == null) {
//				throw new WebException("1003", "获取信息为空");
//			}
//			model.addAttribute(OperDataEnum.CLASSONE.getLabel(), classUpload);
//		} catch (WebException e) {
//			log.error("== readyClassUpload exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//		return "vyyx/training/trainingUpdateCourse";
//	}
//
//	/**
//	 * 更新课程
//	 * (更新失败  需要改)
//	 * @param classupload
//	 * @return
//	 */
//	@RequestMapping(value = "classUpload/update",method=RequestMethod.POST)
//	public String updateClassUpload(ClassUpload classupload,HttpSession session,long classesId) {
//		try {
//			if (classupload == null) {
//				throw new WebException("1003", "获取信息有误");
//			}
//			if (classupload.getStatus() == OperPageAndUserEnum.FAIL.getValue()) {
//				classupload.setStatus(OperPageAndUserEnum.WAIT.getValue());
//			}
//			Classess c=new Classess();
//			c.setId(classesId);
//			classupload.setClasses(c);
//			long result = classUploadService.update(classupload);
//			if (result == 0) {
//				throw new WebException("1003", "更新失败请重试");
//			}
//			classupload=classUploadService.getById(classupload.getId());
//			session.setAttribute(OperPageAndUserEnum.USER.getLabel(), classupload);
//		} catch (WebException e) {
//			log.error("== updateClassUpload exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//		return "redirect:/classUpload/training/trainingTeacher/list.do";
//	}
//
//	
//
//	/**
//	 * 培训机构发布课程
//	 * 
//	 * @param session
//	 * @param classUpload
//	 * @return
//	 */
//	@RequestMapping(value = "training/classUpload", method = RequestMethod.POST)
//	public String uploadClassByTrain(HttpSession session, ClassUpload classUpload,Long classesId) {
//		try {
//			Training train = (Training) session.getAttribute(OperPageAndUserEnum.USER.getLabel());
//			if (train == null) {
//				throw new WebException("1003", "获取用户信息失败");
//			}
//			if (classUpload == null) {
//				throw new WebException("1003", "获取信息失败");
//			}
//			Classess c=new Classess();
//			c.setId(classesId);
//			classUpload.setStatus(OperPageAndUserEnum.WAIT.getValue());
//			classUpload.setStatusOnline(OperPageAndUserEnum.FAIL.getValue());
//			classUpload.setUserId(train.getUserId());
//			classUpload.setClasses(c);
//			long result = classUploadService.insert(classUpload);
//			if (result == 0) {
//				throw new WebException("1003", "添加失败请重试");
//			}
//		} catch (Exception e) {
//			log.error("== uploadClassByTrain exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//		return "redirect:/classUpload/training/trainingTeacher/list.do";
//	}
//
//	/**
//	 * 教师发布课程
//	 * 
//	 * @param session
//	 * @param classUpload
//	 * @return
//	 */
//	@RequestMapping(value = "teacher/classUpload", method = RequestMethod.POST)
//	public String uploadClassByTeacher(HttpSession session, ClassUpload classUpload,Long classesId) {
//		try {
//			Teacher teacher = (Teacher) session.getAttribute("user");
//			if (teacher == null) {
//				throw new WebException("1003", "获取用户信息失败");
//			}
//			if (classUpload == null) {
//				throw new WebException("1003", "获取信息失败");
//			}
//			Classess c=new Classess();
//			c.setId(classesId);
//			classUpload.setStatus(OperPageAndUserEnum.WAIT.getValue());
//			classUpload.setStatusOnline(OperPageAndUserEnum.FAIL.getValue());
//			classUpload.setUserId(teacher.getUserId());
//			classUpload.setClasses(c);
//			long result = classUploadService.insert(classUpload);
//			if (result == 0) {
//				throw new WebException("1003", "添加失败请重试");
//			}
//		} catch (Exception e) {
//			log.error("== uploadClassByTeacher exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//		return "redirect:/classUpload/teacher/list.do";
//	}
//
//	
//	
//	
//	/**
//	 * 培训机构删除课程
//	 * @param id
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping(value = "training/{id}/delete")
//	public String deleteClass(@PathVariable("id") long id, HttpSession session) {
//		try {
//			Object attribute = session.getAttribute("user");
//			
//			if (attribute instanceof Training) {
//				train = (Training) attribute;
//			} else if (attribute instanceof Teacher) {
//				teacher = (Teacher) attribute;
//			} else {
//				throw new WebException("1003", "请求有误");
//			}
//			ClassUpload classuplod = classUploadService.getById(id);
//			if(classuplod.getStatus()==OperPageAndUserEnum.SUCCESS.getValue()){
//				throw new WebException("1003", "请求参数有误");
//			}
//			long delete = classUploadService.delete(classuplod.getId());
//			if(delete==0){
//				throw new WebException("1003", "删除失败");
//			}
//		} catch (WebException e) {
//			log.error("== deleteClass exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//		return "redirect:/classUpload/training/trainingTeacher/list.do";
//	}
//	
//	
//	/****************************************移动端****************************************************/
//	/**
//	 * 移动端根据用户点击课程找出详细信息 包括此课程信息 教师信息 评论信息
//	 * 
//	 * @param model
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping(value = "{id}/classDetials")
//	public String getClassUploadMobileDetials(Model model, @PathVariable("id") long id, String pageNumStr,
//			String numPerPageStr) {
//		try {
//			if (id == 0) {
//				throw new WebException("1003", "请求参数有误");
//			}
//			ClassUpload classupload = classUploadService.getById(id);
//			if (classupload == null) {
//				throw new WebException("1003", "获取信息失败请重试");
//			}
//			Teacher teacher;
//			TrainingTeacher trainingTeacher;
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//
//			if (classupload.getTrainingTeacherId() == null || classupload.getTrainingTeacherId() == 0) {
//				paramMap.put("userId", classupload.getUserId());
//				teacher = (Teacher) teacherService.getBy(paramMap, "getTeacherByUserId");
//				if (teacher == null) {
//					throw new WebException("1003", "获取教师信息异常");
//				}
//				model.addAttribute("teacher", teacher);
//			} else {
//				paramMap.put("trainingTeacherId", classupload.getTrainingTeacherId());
//				trainingTeacher = (TrainingTeacher) trainingTeacherService.getBy(paramMap, "getTeacherById");
//				if (trainingTeacher == null) {
//					throw new WebException("1003", "获取机构教师信息异常");
//				}
//				model.addAttribute("teacher", trainingTeacher);
//			}
//			paramMap.clear();
//			paramMap.put("classId", classupload.getId());
//			PageBean p = commentService.listPage(getPageParam(pageNumStr, numPerPageStr), paramMap);
//			long num=(Long) applyService.getBy(paramMap, "listPageCount");
//			paramMap.clear();
//			paramMap.put("classessId", classupload.getClasses().getId());
//			List<Object> listBy = classUploadService.listBy(paramMap, "correlationClass");
//			model.addAttribute(OperPageAndUserEnum.PAGELIST.getLabel(), p);
//			model.addAttribute("classupload", classupload);
//			model.addAttribute("applyCount", num);
//			model.addAttribute("correlationClass", listBy);
//		} catch (WebException e) {
//			log.error("== getClassUploadDetials exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//		return "weixinApp/threeLevelPage/threeLevelPage";
//	}
//	/**
//	 * 移动端对于机构或个人教师的课程上架以及下架操作
//	 * 
//	 * @param id
//	 * @param statusOnline
//	 * @return
//	 * @throws IOException 
//	 */
//	@ResponseBody
//	@RequestMapping(value = "mobile/downClass",method=RequestMethod.POST)
//	public void downClassByClassUploadIdMobile( String classes,Integer status,HttpServletResponse response,HttpSession session) throws IOException {
//		try {
//			response.setCharacterEncoding("utf-8");
//			Object obj = session.getAttribute(OperPageAndUserEnum.USER.getLabel());
//			StatusClass statusClass=new StatusClass();
//			if(obj==null ||(!(obj instanceof Training) &&!(obj instanceof Teacher))){
//				statusClass.setStatus("error");
//				response.getWriter().println(JSONObject.toJSON(statusClass));
//				return;
//			}
//			long parseLong = Long.parseLong(classes);
//			if (parseLong == 0) {
//				statusClass.setStatus("error1");
//				response.getWriter().println(JSONObject.toJSON(statusClass));
//				return;
//			}
//			ClassUpload upload = classUploadService.getById(parseLong);
//			if (upload == null) {
//				statusClass.setStatus("none");
//				response.getWriter().println(JSONObject.toJSON(statusClass));
//				return;
//			}
//			status = status == 101 ? OperEnstructInfoStatusEnum.SUCCESS.getValue()
//					: OperEnstructInfoStatusEnum.FAIL.getValue();
//			upload.setStatusOnline(status);
//			if(upload.getStatus()!=OperEnstructInfoStatusEnum.SUCCESS.getValue()){
//				upload.setStatus(OperPageAndUserEnum.WAIT.getValue());
//			}
//			long update = classUploadService.update(upload);
//			if (update == 0) {
//				statusClass.setStatus("updateError");
//				response.getWriter().println(JSONObject.toJSON(statusClass));
//				return;
//			}
//			statusClass.setStatus("success");
//			response.getWriter().println(JSONObject.toJSON(statusClass));
//			return;
//		} catch (WebException e) {
//			log.error("== downClassByClassUploadId exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//	}
//	
//	@RequestMapping(value="{classId}/seeAllStudent")
//	public String seeAllStudentByClassId(@PathVariable("classId")Integer classId,Model model,HttpSession session){
//		try {
//			Object obj = session.getAttribute(OperPageAndUserEnum.USER.getLabel());
//			if(obj==null ||(!(obj instanceof Training) &&!(obj instanceof Teacher))){
//				throw new WebException("1003", "请重新登入");
//			}
//			if(classId==0){
//				throw new WebException("1003", "获取失败，请重试");
//			}
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			paramMap.put("classId", classId);
//			List<Object> listBy = applyService.listBy(paramMap, "listPageById");
//			model.addAttribute("list",listBy);
//		} catch (WebException e) {
//			log.error("== seeAllStudentByClassId exception:", e);
//			throw new WebException("1003", "错误信息:"+e.getMessage());
//		}
//		return "weixinApp/trainingPage/viewAllStudents";
//		}
//	/**
//	 * 委培接受操作
//	 * 
//	 * @param id:课程ID
//	 * @param status:当前状态
//	 * @return
//	 * @throws IOException 
//	 */
//	@RequestMapping(value = "mobile/changeEntrustStatus",method=RequestMethod.POST)
//	public void changeEntrustStatus(String classes, Integer status,HttpSession session,HttpServletResponse response) throws IOException {
//		try {
//			response.setCharacterEncoding("utf-8");
//			Object obj = session.getAttribute(OperPageAndUserEnum.USER.getLabel());
//			StatusClass statusClass=new StatusClass();
//			if(obj==null &&!(obj instanceof Training) &&!(obj instanceof Teacher)){
//				statusClass.setStatus("error");
//				response.getWriter().println(JSONObject.toJSON(statusClass));
//				return;
//			}
//			
//			long parseLong = Long.parseLong(classes);
//			if (parseLong == 0) {
//				statusClass.setStatus("error1");
//				response.getWriter().println(JSONObject.toJSON(statusClass));
//				return;
//			}
//			if (status != OperPageAndUserEnum.WAIT.getValue() && status != OperPageAndUserEnum.SUCCESS.getValue()
//					&& status != OperPageAndUserEnum.FAIL.getValue()) {
//				statusClass.setStatus("error1");
//				response.getWriter().println(JSONObject.toJSON(statusClass));
//				return;
//			}
//			ClassUpload classUpload = classUploadService.getById(parseLong);
//			if (classUpload == null) {
//				statusClass.setStatus("none");
//				response.getWriter().println(JSONObject.toJSON(statusClass));
//				return;
//			}
//			
//			status=status==OperPageAndUserEnum.FAIL.getValue()?OperPageAndUserEnum.FAIL.getValue():OperPageAndUserEnum.SUCCESS.getValue();
//			classUpload.setStatusEntrustTrain(status);
//			long update = classUploadService.update(classUpload);
//			if (update == 0) {
//				statusClass.setStatus("updateError");
//				response.getWriter().println(JSONObject.toJSON(statusClass));
//				return;
//			}
//			statusClass.setStatus("success");
//			response.getWriter().println(JSONObject.toJSON(statusClass));
//			return;
//		} catch (WebException e) {
//			log.error("== changeEntrustStatus exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//	}
//	
//	/**
//	 * 移动端获取相关机构发布课程表并且做分页 发布课程记录
//	 * 
//	 * 						(测试通过  点击下一页 没起作用 还要修改)
//	 * @param view
//	 * @param session
//	 * @param pageNumStr
//	 * @param numPerPageStr
//	 * @return
//	 */
//	@RequestMapping(value = "training/trainingTeacher/list")
//	public String listByClassUploda(Model view, HttpSession session, String pageNumStr, String numPerPageStr) {
//		try {
//			Training train = (Training) session.getAttribute(OperPageAndUserEnum.USER.getLabel());
//			if (train == null) {
//				throw new WebException("1003", "获取信息失败，请重试");
//			}
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			paramMap.put("status", "");
//			paramMap.put("userId", train.getUserId());
//			List<Object> listBy = classUploadService.listBy(paramMap, "listPageById");
//			view.addAttribute(OperPageAndUserEnum.PAGELIST.getLabel(), listBy);
//		} catch (WebException e) {
//			log.error("== listByClassUploda exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//
//		return "weixinApp/trainingPage/totalCourse";
//	}
//
//	/**
//	 * 获取老师发布课程表并且做分页 发布课程记录
//	 * 
//	 * @param view
//	 * @param session
//	 * @param pageNumStr
//	 * @param numPerPageStr
//	 * @return
//	 */
//	@RequestMapping(value = "teacher/list")
//	public String listByClassUploadByTecaher(Model view, HttpSession session, String pageNumStr, String numPerPageStr) {
//		try {
//			Teacher teacher = (Teacher) session.getAttribute(OperPageAndUserEnum.USER.getLabel());
//			if (teacher == null) {
//				throw new WebException("1003", "获取信息失败，请重试");
//			}
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			paramMap.put("userId", teacher.getUserId());
//			PageBean p = classUploadService.listPage(getPageParam(pageNumStr, numPerPageStr), paramMap, "listPageById");
//			view.addAttribute(OperPageAndUserEnum.PAGELIST.getLabel(), p);
//		} catch (WebException e) {
//			log.error("== listByClassUploadByTecaher exception:", e);
//			throw new WebException("1003", "请求有误");
//		}
//
//		return "vyyx/selection.vyyx/personCourseManagent";
//	}
//	/**
//	 * 通过课程的标签搜索分页
//	 * @param classId
//	 * @param pageNumStr
//	 * @param numPerPageStr
//	 * @return
//	 */
//	@RequestMapping(value="{classesId}/classes")
//	public String getListClassUploadByClassesId(Model model,@PathVariable("classesId")Integer classId,String pageNumStr,
//			String numPerPageStr){
//		try {
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			paramMap.put("classessId", classId);
//			PageBean p = classUploadService.listPage(getPageParam(pageNumStr, numPerPageStr), paramMap);
//			paramMap.clear();
//			paramMap.put("firstId", 1);
//			List<Object> classes = classService.listBy(null, "listAll");
//			List<Object> keyWord = keyWordSeervice.listBy(paramMap, "randomByKeyWord");
//			model.addAttribute("classes",classes);
//			model.addAttribute("keyWord", keyWord);
//			model.addAttribute(OperPageAndUserEnum.PAGELIST.getLabel(), p);
//			model.addAttribute("keyId", classId);
//		} catch (Exception e) {
//			log.error("== getListClassUploadByClassesId exception:", e);
//			throw new WebException("1003", "错误信息:"+e.getMessage());
//		}
//		return "weixinApp/twoLevelPage/training";
//		}
//	
//	/**
//	 * 通过课程的标签ajax搜索下滑分页
//	 * @param classId
//	 * @param pageNumStr
//	 * @param numPerPageStr
//	 * @return
//	 */
//	@RequestMapping(value="getClassesBean")
//	public void getListClassUploadByClassesIdAjax(Model model,HttpServletResponse response ,String pageNumStr,
//			String numPerPageStr,String zone,String aim,String brand){
//		try {
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			if(!zone.isEmpty()){
//				paramMap.put("zone", zone);
//			}
//			if(!aim.isEmpty()){
//				paramMap.put("aim", aim);
//			}
//			if(!brand.isEmpty()){
//				paramMap.put("classessId", brand);
//			}
//			PageBean p = classUploadService.listPage(getPageParam(pageNumStr, numPerPageStr), paramMap);
//			response.setHeader("Content-Type", "text/html");
//			response.setCharacterEncoding("utf-8");
//			response.getWriter().println(JSONObject.toJSONString(p));
//		} catch (Exception e) {
//			log.error("== getListClassUploadByClassesId exception:", e);
//			throw new WebException("1003", "错误信息:"+e.getMessage());
//		}
//		}
//}
