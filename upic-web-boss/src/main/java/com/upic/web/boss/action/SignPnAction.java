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
import com.upic.po.ShopTheme;
import com.upic.po.ShopType;
import com.upic.po.SignPn;
import com.upic.po.SignPnLink;
import com.upic.po.TypePn;
import com.upic.service.IShopThemeService;
import com.upic.service.ISignPnLinkService;
import com.upic.service.ISignPnService;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;
import wusc.edu.pay.web.permission.enums.OperatorTypeEnum;
import wusc.edu.pay.web.permission.enums.RoleTypeEnum;

public class SignPnAction extends BossBaseAction implements ModelDriven<SignPn> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(SignPnAction.class);
	private SignPn signPn;
	@Autowired
	private ISignPnService signPnService;

	@Autowired
	private ISignPnLinkService signPnLinkService;

	/**
	 * 查看所有标签
	 * 
	 * @return
	 */
	public String listSignPn() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("signPn", signPn.getSignPn()); // sign名称（模糊查询）
			super.pageBean = signPnService.listPage(getPageParam(), paramMap);
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);

			return "listSignPn";
		} catch (Exception e) {
			log.error("== listShop exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 
	 * 查看某一个标签下所有内容
	 *
	 */
	public String seeSinPnDetials() {
		try {
			SignPn s = signPnService.getById(signPn.getId());
			if (s == null) {
				return operateError("获取数据失败");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("signPnId", s.getId());
			super.pageBean = signPnLinkService.listPage(getPageParam(), paramMap);
			HttpSession session = super.getHttpSession();
			session.setAttribute("signId", signPn.getId());
			super.pushData(pageBean);
			return "sinPnDetials";
		} catch (Exception e) {
			log.error("== seeShopDetials exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 删除sinPn类型
	 */
	@Transactional(rollbackFor = Exception.class)
	public String deleteSign() {
		try {
			SignPn s = signPnService.getById(signPn.getId());
			int id = getInteger("id");
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", id);
			signPnService.getBy(paramMap, "deleteById");
			paramMap.clear();
			paramMap.put("sinPnId", id);
			signPnLinkService.getBy(paramMap, "deleteBySinPnId");
			super.logEdit("删除signPn类型序号编号[" + s.getId() + "类型名:" + s.getSignPn() + "]");
		} catch (Exception e) {
			log.error("== deleteShopType exception:", e);
			return operateError("删除数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 准备添加
	 */
	public String readyInsert() {
		return "readyInsert";
	}

	/**
	 * 新增一条记录
	 */
	public String insertData() {
		try {
			if (signPn == null) {
				operateError("获取数据失败");
			}
				
			long result = signPnService.insert(signPn);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("添加类型：[类型名:" + signPn.getSignPn() + "]");
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
			SignPn byId = signPnService.getById(signPn.getId());
			if (byId == null) {
				return operateError("获取对象不存在");
			}
			super.putData("signPn", byId);
		} catch (Exception e) {
			log.error("== insertData exception:", e);
			return operateError("添加数据失败");
		}
		return "readyUpdate";
	}

	/**
	 * 更新数据
	 */
	public String updateSignPn() {
		try {
			if (signPn == null) {
				operateError("获取数据失败");
			}
			SignPn s = signPnService.getById(signPn.getId());
			if (!s.getSignPn().equals(signPn.getSignPn()) || s.getNum() != signPn.getNum()) {
				long result = signPnService.update(signPn);
				if (result == 0) {
					return operateError("添加数据失败");
				}
				if (!s.getSignPn().equals(signPn.getSignPn())) {
					SignPnLink signPnL = new SignPnLink();
					signPnL.setSignPnId(s.getId());
					signPnL.setSignPn(signPn.getSignPn());
					long update = signPnLinkService.update(signPnL, "updateBySignPnId");
					if (update == 0) {
						return operateError("更新失败");
					}
				}
				super.logEdit("更新类型：[类型名:" + signPn.getSignPn() + "]");

			}
		} catch (Exception e) {
			log.error("== updateShopType exception:", e);
			return operateError("获取数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 上下架
	 */
	public String changeStatus() {
		try {
			SignPn y = signPnService.getById(signPn.getId());
			y.setStatus(signPn.getStatus());
			long update = signPnService.update(y);
			if (update == 0) {
				return this.operateError("更新失败，请重试");
			}
		} catch (Exception e) {
			log.error("上架或下架操作异常", e);
			return this.operateError("操作异常，请重试");
		}
		return operateSuccess();
	}

	@Override
	public SignPn getModel() {
		if (signPn == null) {
			signPn = new SignPn();
		}
		return signPn;
	}

}
