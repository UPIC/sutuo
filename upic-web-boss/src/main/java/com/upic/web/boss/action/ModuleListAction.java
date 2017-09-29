package com.upic.web.boss.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.common.config.PublicConfig;
import com.upic.common.utils.OOSUtils;
import com.upic.common.utils.UUIDUitl;
import com.upic.po.MainPic;
import com.upic.po.ModuleList;
import com.upic.service.IMainPicService;
import com.upic.service.IModuleListService;

import wusc.edu.pay.web.boss.base.BossBaseAction;
/**
 * 分管优选模块
 * @author Administrator
 *
 */
public class ModuleListAction extends BossBaseAction implements ModelDriven<ModuleList> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ModuleListAction.class);
	private ModuleList moduleList;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;

	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;
	@Autowired
	private IModuleListService moduleListService;

	/**
	 * 查看所有优选分类
	 * 
	 * @return
	 */
	public String listModuleList() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			super.pageBean = moduleListService.listPage(getPageParam(), paramMap);
			super.putData("moduleList", moduleList);
			super.pushData(pageBean);
		} catch (Exception e) {
			log.error("== listYouXuan exception:", e);
			return operateError("获取数据失败");
		}
		return "listModuleList";
	}

	/**
	 * 准备更新
	 */
	public String readyUpdate() {
		try {
			ModuleList byId = moduleListService.getById(moduleList.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			super.putData("moduleList", byId);
		} catch (Exception e) {
			log.error("== readyUpdate exception:", e);
			return operateError("获取数据失败");
		}
		return "updateDetials";
	}

	/**
	 * 更新
	 */
	public String updateModuleList() {
		try {
			ModuleList byId = moduleListService.getById(moduleList.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			String oldImgId = byId.getPic();
			String imgId = UUIDUitl.generateMixString(10);
			if (file != null) {
				InputStream is = new FileInputStream(file);
				String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
				if (uploadFile == null) {
					return operateError("添加数据失败");
				}
				moduleList.setPic(
						"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			}
			long result = moduleListService.update(moduleList);
			if (result == 0) {
				OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId);
				return operateError("添加数据失败");
			}
			if (file != null) {
				// 删除原来的图片
				String[] split = oldImgId.split(".com/");
				String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, split[1]);
				if (deleteFile == null) {
					return operateError("更新成功，但是云端原来图片未删除。");
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
			ModuleList y = moduleListService.getById(moduleList.getId());
			y.setStatus(moduleList.getStatus());
			long update = moduleListService.update(y);
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
		return "addModuleList";
	}

	/**
	 * 添加
	 */
	public String insert() {
		try {
			String imgId = UUIDUitl.generateMixString(10);
			if (file != null) {
				InputStream is = new FileInputStream(file);
				String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
				moduleList.setPic(
						"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
				if (uploadFile == null) {
					return operateError("添加数据图片失败");
				}
			}
			long result = moduleListService.insert(moduleList);
			if (result == 0) {
				OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId);
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
	@Transactional(rollbackFor=Exception.class)
	public String deleteByModuleListId() {
		try {
			ModuleList byId = moduleListService.getById(moduleList.getId());
			if (byId == null) {
				return operateError("数据已删除");
			}
			String[] split = byId.getPic().split(".com/");
			String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, split[1]);
			if (deleteFile == null) {
				return operateError("删除数据失败");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", moduleList.getId()); //
			moduleListService.getBy(paramMap, "deleteById");
		} catch (Exception e) {
			log.error("== deleteByMainPicId exception:", e);
			return operateError("删除数据失败");
		}
		return operateSuccess();
	}

	@Override
	public ModuleList getModel() {
		if (moduleList == null) {
			moduleList = new ModuleList();
		}
		return moduleList;
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
