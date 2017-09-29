package com.upic.web.boss.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.common.config.PublicConfig;
import com.upic.common.utils.OOSUtils;
import com.upic.common.utils.UUIDUitl;
import com.upic.po.ActivityArea;
import com.upic.po.ThemePn;
import com.upic.service.IActivityAreaService;
import com.upic.service.IThemePnService;

import wusc.edu.pay.web.boss.base.BossBaseAction;

public class ThemePnAction extends BossBaseAction implements ModelDriven<ThemePn> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ThemePnAction.class);
	private ThemePn themePn;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File files;

	// 提交过来的file的名字
	private String fileFileName;

	private String result;
	// 提交过来的file的MIME类型
	private String fileContentType;
	@Autowired
	private IThemePnService themePnService;

	/**
	 * 查看所有品农主题按钮按钮信息
	 * 
	 * @return
	 */
	public String listActiveArea() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			super.pageBean = themePnService.listPage(getPageParam(), paramMap);
			super.putData("activityArea", themePn);
			super.pushData(pageBean);
		} catch (Exception e) {
			log.error("== listYouXuan exception:", e);
			return operateError("获取数据失败");
		}
		return "listActiveArea";
	}

	/**
	 * 准备更新
	 */
	public String readyUpdate() {
		try {
			ThemePn byId = themePnService.getById(themePn.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			super.putData("themePn", byId);
		} catch (Exception e) {
			log.error("== readyUpdate exception:", e);
			return operateError("获取数据失败");
		}
		return "updateDetials";
	}

	/**
	 * 更新
	 */
	public String updateActiveArea() {
		try {
			ThemePn byId = themePnService.getById(themePn.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			String oldImgId = byId.getThemePnPic();

			String imgId = UUIDUitl.generateMixString(10);
			if (files != null) {
				InputStream is = new FileInputStream(files);
				String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
				if (uploadFile == null) {
					return operateError("添加数据失败");
				}
				themePn.setThemePnPic(
						"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			}
			long result = themePnService.update(themePn);
			if (result == 0) {
				if (files != null) {
					OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
							PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId);
					// 失败存储日志
					return operateError("添加数据失败");
				}
			}
			// 删除原来的图片
			if (files != null) {
				String[] split = oldImgId.split(".com/");
				String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, split[1]);
				if (deleteFile == null) {
					return operateError("更新成功，但是云端原来图片未删除。");
					// 失败存储日志
				}
			}
		} catch (Exception e) {
			log.error("== updateMainImg exception:", e);
			return operateError("更新数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 上下架
	 */
	public String changeStatus() {
		try {
			ThemePn y = themePnService.getById(themePn.getId());
//			y.setStatus(themePn.getStatus());
			long update = themePnService.update(y);
			if (update == 0) {
				return this.operateError("更新失败，请重试");
			}
		} catch (Exception e) {
			log.error("上架或下架操作异常", e);
			return this.operateError("操作异常，请重试");
		}
		return operateSuccess();
	}

	/**
	 * 准备添加
	 * 
	 * @return
	 */
	public String readyInsert() {
		return "addBanner";
	}

	/**
	 * 添加
	 */
	public String insert() {
		try {
			String imgId = UUIDUitl.generateMixString(10);
			InputStream is = new FileInputStream(files);
			String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
			if (uploadFile == null) {
				return operateError("添加数据失败");
			}
			themePn.setThemePnPic(
					"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			long result = themePnService.insert(themePn);
			if (result == 0) {
				OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId);
				// 存储日志
				return operateError("添加数据失败");
			}
		} catch (Exception e) {
			log.error("== insert exception:", e);
			return operateError("添加数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteByActiveAreaId() {
		try {
			ThemePn byId = themePnService.getById(themePn.getId());
			if (byId == null) {
				return operateError("数据已删除");
			}
			if(byId.getThemePnPic()!=null){
			String[] split = byId.getThemePnPic().split(".com/");
			String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, split[1]);
			if (deleteFile == null) {
				return operateError("删除数据失败");
			}
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", themePn.getId()); //
			themePnService.getBy(paramMap, "deleteById");
		} catch (Exception e) {
			log.error("== deleteByMainPicId exception:", e);
			return operateError("删除数据失败");
		}
		return operateSuccess();
	}

	@Override
	public ThemePn getModel() {
		if (themePn == null) {
			themePn = new ThemePn();
		}
		return themePn;
	}

	public File getFiles() {
		return files;
	}

	public void setFiles(File files) {
		this.files = files;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
