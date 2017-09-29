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
import com.upic.service.IActivityAreaService;

import wusc.edu.pay.web.boss.base.BossBaseAction;

public class ActiveAreaAction extends BossBaseAction implements ModelDriven<ActivityArea> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ActiveAreaAction.class);
	private ActivityArea activityArea;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File files;

	// 提交过来的file的名字
	private String fileFileName;

	private String result;
	// 提交过来的file的MIME类型
	private String fileContentType;
	@Autowired
	private IActivityAreaService activityAreaService;

	/**
	 * 查看所有首页四个按钮信息
	 * 
	 * @return
	 */
	public String listActiveArea() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			super.pageBean = activityAreaService.listPage(getPageParam(), paramMap);
			super.putData("activityArea", activityArea);
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
			ActivityArea byId = activityAreaService.getById(activityArea.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			super.putData("activityArea", byId);
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
			ActivityArea byId = activityAreaService.getById(activityArea.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			String oldImgId = byId.getPicUrl();

			String imgId = UUIDUitl.generateMixString(10);
			if (files != null) {
				InputStream is = new FileInputStream(files);
				String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
				if (uploadFile == null) {
					return operateError("添加数据失败");
				}
				activityArea.setPicUrl(
						"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			}
			long result = activityAreaService.update(activityArea);
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
			ActivityArea y = activityAreaService.getById(activityArea.getId());
			y.setStatus(activityArea.getStatus());
			long update = activityAreaService.update(y);
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
			activityArea.setPicUrl(
					"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			long result = activityAreaService.insert(activityArea);
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
			ActivityArea byId = activityAreaService.getById(activityArea.getId());
			if (byId == null) {
				return operateError("数据已删除");
			}
			if(byId.getPicUrl()!=null){
			String[] split = byId.getPicUrl().split(".com/");
			String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, split[1]);
			if (deleteFile == null) {
				return operateError("删除数据失败");
			}
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", activityArea.getId()); //
			activityAreaService.getBy(paramMap, "deleteById");
		} catch (Exception e) {
			log.error("== deleteByMainPicId exception:", e);
			return operateError("删除数据失败");
		}
		return operateSuccess();
	}

	@Override
	public ActivityArea getModel() {
		if (activityArea == null) {
			activityArea = new ActivityArea();
		}
		return activityArea;
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
