package com.upic.web.boss.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.common.config.PublicConfig;
import com.upic.common.utils.OOSUtils;
import com.upic.common.utils.UUIDUitl;
import com.upic.po.HotThemePn;
import com.upic.po.HotThemePnLink;
import com.upic.service.IHotThemePnLinkService;
import com.upic.service.IHotThemePnService;

import wusc.edu.pay.web.boss.base.BossBaseAction;
import wusc.edu.pay.web.permission.entity.PmsOperator;

public class HotThemePnAction extends BossBaseAction implements ModelDriven<HotThemePn> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(HotThemePnAction.class);
	private HotThemePn hotThemePn;
	@Autowired
	private IHotThemePnService hotThemePnService;

	@Autowired
	private IHotThemePnLinkService hotThemePnLinkService;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;

	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;

	/**
	 * 查看所有标签
	 * 
	 * @return
	 */
	public String listHotThemePn() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("hotThemePn", hotThemePn.getHotThemePn()); // sign名称（模糊查询）
			super.pageBean = hotThemePnService.listPage(getPageParam(), paramMap);
			PmsOperator operator = this.getLoginedOperator();
			super.pushData(operator);
			super.pushData(pageBean);
			// 回显查询条件值
			super.pushData(paramMap);

			return "listHotThemePn";
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
	public String seeHotThemePnDetials() {
		try {
			HotThemePn s = hotThemePnService.getById(hotThemePn.getId());
			if (s == null) {
				return operateError("获取数据失败");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("signPnId", s.getId());
			super.pageBean = hotThemePnLinkService.listPage(getPageParam(), paramMap);
			HttpSession session = super.getHttpSession();
			session.setAttribute("signId", hotThemePn.getId());
			super.pushData(pageBean);
			return "hotThemePnDetials";
		} catch (Exception e) {
			log.error("== seeShopDetials exception:", e);
			return operateError("获取数据失败");
		}
	}

	/**
	 * 删除HotThemePn类型
	 */
	@Transactional(rollbackFor = Exception.class)
	public String deleteHotThemePn() {
		try {
			HotThemePn s = hotThemePnService.getById(hotThemePn.getId());
			if (s == null) {
				return operateError("数据已删除");
			}
			String[] split = s.getHotThemePnPic().split(".com/");
			String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, split[1]);
			if (deleteFile == null) {
				return operateError("删除数据失败");
			}
			int id = getInteger("id");
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", id);
			hotThemePnService.getBy(paramMap, "deleteById");
			paramMap.clear();
			paramMap.put("hotThemePnId", id);
			hotThemePnLinkService.getBy(paramMap, "deleteByHotThemeId");
			super.logEdit("删除hotThemePn类型序号编号[" + s.getId() + "类型名:" + s.getHotThemePn() + "]");
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
		String imgId = UUIDUitl.generateMixString(10);
		try {
			if (hotThemePn == null) {
				operateError("获取数据失败");
			}
			InputStream is = new FileInputStream(file);
			String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
			if (uploadFile == null) {
				return operateError("添加数据失败");
			}
			hotThemePn.setHotThemePnPic(
					"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			long result = hotThemePnService.insert(hotThemePn);
			if (result == 0) {
				return operateError("添加数据失败");
			}
			super.logEdit("添加类型：[类型名:" + hotThemePn.getHotThemePn() + "]");
		} catch (Exception e) {
			OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId);
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
			HotThemePn byId = hotThemePnService.getById(hotThemePn.getId());
			if (byId == null) {
				return operateError("获取对象不存在");
			}
			super.putData("hotThemePn", byId);
		} catch (Exception e) {
			log.error("== insertData exception:", e);
			return operateError("添加数据失败");
		}
		return "readyUpdate";
	}

	/**
	 * 更新数据
	 */
	public String updateHotThemePn() {
		try {
			if (hotThemePn == null) {
				operateError("获取数据失败");
			}
			HotThemePn byId = hotThemePnService.getById(hotThemePn.getId());
			String oldImgId = byId.getHotThemePnPic();
			String imgId = UUIDUitl.generateMixString(10);
			if (file != null) {
				InputStream is = new FileInputStream(file);
				String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
				if (uploadFile == null) {
					return operateError("添加数据失败");
				}
				hotThemePn.setHotThemePnPic(
						"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			}
			HotThemePn s = hotThemePnService.getById(hotThemePn.getId());
			if (!s.getHotThemePn().equals(hotThemePn.getHotThemePn()) || s.getNum() != hotThemePn.getNum()||file != null) {
				long result = hotThemePnService.update(hotThemePn);
				if (result == 0) {
					return operateError("添加数据失败");
				}
				if (!s.getHotThemePn().equals(hotThemePn.getHotThemePn())) {
					HotThemePnLink shtoThemePnL = new HotThemePnLink();
					shtoThemePnL.setHotThemePnId(s.getId());
					shtoThemePnL.setHotThemePn(hotThemePn.getHotThemePn());
					long update = hotThemePnLinkService.update(shtoThemePnL, "updateByhotThemePnId");
					if (update == 0) {
						return operateError("更新失败");
					}
				}
				super.logEdit("更新类型：[类型名:" + hotThemePn.getHotThemePn() + "]");
				if (file != null) {
					// 删除原来的图片
					String[] split = oldImgId.split(".com/");
					String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI,
							PublicConfig.ACCESSKEYID_IMG, PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG,
							split[1]);
					if (deleteFile == null) {
						return operateError("更新成功，但是云端原来图片未删除。");
					}
				}
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
			HotThemePn y = hotThemePnService.getById(hotThemePn.getId());
			y.setStatus(hotThemePn.getStatus());
			long update = hotThemePnService.update(y);
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
	public HotThemePn getModel() {
		if (hotThemePn == null) {
			hotThemePn = new HotThemePn();
		}
		return hotThemePn;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
