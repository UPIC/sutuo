package com.upic.web.boss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.po.HotThemePn;
import com.upic.po.HotThemePnLink;
import com.upic.po.ShopTheme;
import com.upic.po.ShopType;
import com.upic.po.SignPn;
import com.upic.po.SignPnLink;
import com.upic.po.TypePn;
import com.upic.service.IHotThemePnLinkService;
import com.upic.service.IHotThemePnService;
import com.upic.service.IShopThemeService;
import com.upic.service.ISignPnLinkService;
import com.upic.service.ISignPnService;
import com.upic.service.ITypePnService;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class HotThemePnLinkAction extends BossBaseAction implements ModelDriven<HotThemePnLink> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(HotThemePnLinkAction.class);
	private HotThemePnLink hotThemePnLink;
	@Autowired
	private IHotThemePnService hotThemePnService;

	@Autowired
	private IHotThemePnLinkService hotThemePnLinkService;

	@Autowired
	private ITypePnService typePnService;
	// /**
	// * 查看所有标签
	// *
	// * @return
	// */
	// public String listSignPnLink() {
	// try {
	// Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
	// paramMap.put("signPn", signPnLink.getSignPn()); // sign名称（模糊查询）
	// super.pageBean = signPnService.listPage(getPageParam(), paramMap);
	// PmsOperator operator = this.getLoginedOperator();
	// super.pushData(operator);
	// super.pushData(pageBean);
	// // 回显查询条件值
	// super.pushData(paramMap);
	//
	// return "shopThemeActionList";
	// } catch (Exception e) {
	// log.error("== listShop exception:", e);
	// return operateError("获取数据失败");
	// }
	// }

	/**
	 * 
	 * 查看某一个标签下所有内容
	 *
	 */
	public String seeHotThemePnLinkDetials() {
		try {
			HotThemePnLink s = hotThemePnLinkService.getById(hotThemePnLink.getId());
			if (s == null) {
				return operateError("获取数据失败");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("status", 100); // sign名称（模糊查询）
			List<Object> by = typePnService.listBy(paramMap, "listAll");
			super.putData("typePn", by);
			super.putData("signLink", s);
			return "hotThemePnLinkDetials";
		} catch (Exception e) {
			log.error("== seeShopDetials exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 删除sinPnLink类型
	 */
	@Transactional(rollbackFor = Exception.class)
	public String deleteHotThemePnLink() {
		try {
			HotThemePnLink s = hotThemePnLinkService.getById(hotThemePnLink.getId());
			int id = getInteger("id");
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", id);
			hotThemePnLinkService.getBy(paramMap, "deleteById");
			super.logEdit("删除signPnLink类型序号编号[" + s.getId() + "类型名:" + s.getHotThemePn() + "]");
		} catch (Exception e) {
			log.error("== deleteHotThemePnLink exception:", e);
			return operateError("删除数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 准备添加
	 */
	public String readyInsert() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("status", 100); // sign名称（模糊查询）
			List<Object> by = typePnService.listBy(paramMap, "listAll");
			super.putData("typePn", by);
		} catch (Exception e) {
			log.error("== readyInsert exception:", e);
			return operateError("准备数据失败");
		}
		return "readyInsert";
	}

	/**
	 * 新增一条记录
	 */
	public String insertData() {
		try {
			if (hotThemePnLink == null) {
				operateError("获取数据失败");
			}
			Integer integer = getInteger("typePnId");
			TypePn byId = typePnService.getById(integer);
			if(byId==null){
				return operateError("对不起，此文章已下线");
			}
			HttpSession session = super.getHttpSession();
			Long id=(Long) session.getAttribute("signId");
			if(id==0){
				return operateError("已超时，请重新入信息");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
//			paramMap.put("signPnId", id);
			paramMap.put("typePnId", byId.getId()); 
			if(hotThemePnLinkService.getBy(paramMap, "getByTwoId")!=null){
				return operateError("此文章已添加，无需再添加");
			}
			
			HotThemePn byId2 = hotThemePnService.getById(id);
			if(byId2==null){
				return operateError("获取信息有误，请重试！");
			}
			hotThemePnLink.setArticalPnName(byId.getArticName());
			hotThemePnLink.setPic(byId.getPicUrl());
			hotThemePnLink.setTitle(byId.getTitle());
			hotThemePnLink.setTypePnId(byId.getId());
			hotThemePnLink.setHotThemePnId(id);
			hotThemePnLink.setHotThemePn(byId2.getHotThemePn());
			long result = hotThemePnLinkService.insert(hotThemePnLink);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("添加类型：[类型名:" + hotThemePnLink.getHotThemePn() + "]");
		} catch (Exception e) {
			log.error("== insertData exception:", e);
			return operateError("添加数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 准备更新
	 * 
	 * @return
	 */
	public String readyUpdate() {
		try {
			HotThemePnLink byId = hotThemePnLinkService.getById(hotThemePnLink.getId());
			if (byId == null) {
				return operateError("获取对象不存在");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("status", 100); // sign名称（模糊查询）
			List<Object> by = typePnService.listBy(paramMap, "listAll");
			super.putData("typePn", by);
			super.putData("hotThemePnLink", byId);
		} catch (Exception e) {
			log.error("== insertData exception:", e);
			return operateError("添加数据失败");
		}
		return "readyUpdate";
	}

	/**
	 * 更新数据
	 */
	public String updateSignLink() {
		try {
			if (hotThemePnLink == null) {
				operateError("获取数据失败");
			}
			if (hotThemePnLink == null) {
				operateError("获取数据失败");
			}
			Integer integer = getInteger("typePnId");
			TypePn byId = typePnService.getById(integer);
			if(byId==null){
				return operateError("对不起，此文章已下线");
			}
			HttpSession session = super.getHttpSession();
			long id=(Long) session.getAttribute("signId");
			if(id==0){
				return operateError("已超时，请重新入信息");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("hotThemePnId", id);
			paramMap.put("typePnId", byId); 
			if(hotThemePnLinkService.getBy(paramMap, "getByTwoId")!=null){
				return operateError("此文章已添加，无需再添加");
			}
			
			HotThemePn byId2 = hotThemePnService.getById(id);
			if(byId2==null){
				return operateError("获取信息有误，请重试！");
			}
			hotThemePnLink.setArticalPnName(byId.getArticName());
			hotThemePnLink.setPic(byId.getPicUrl());
			hotThemePnLink.setTitle(byId.getTitle());
			hotThemePnLink.setTypePnId(byId.getId());
			hotThemePnLink.setHotThemePnId(id);
			hotThemePnLink.setHotThemePn(byId2.getHotThemePn());
			long result = hotThemePnLinkService.update(hotThemePnLink);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("更新类型：[类型名:" + hotThemePnLink.getHotThemePn() + "]");
		} catch (Exception e) {
			log.error("== updateShopType exception:", e);
			return operateError("获取数据失败");
		}
		return operateSuccess();
	}

	@Override
	public HotThemePnLink getModel() {
		if (hotThemePnLink == null) {
			hotThemePnLink = new HotThemePnLink();
		}
		return hotThemePnLink;
	}

}
