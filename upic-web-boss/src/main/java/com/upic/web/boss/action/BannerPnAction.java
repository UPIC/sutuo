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
import com.upic.po.BannarPn;
import com.upic.po.MainPic;
import com.upic.service.IBannarPnService;
import com.upic.service.IMainPicService;

import wusc.edu.pay.web.boss.base.BossBaseAction;

/**
 * 品农banner管理
 * @author Administrator
 *
 */
public class BannerPnAction extends BossBaseAction implements ModelDriven<BannarPn> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(BannerPnAction.class);
	private BannarPn bannarPn;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;

	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;
	@Autowired
	private IBannarPnService bannarPnService;

	/**
	 * 查看所有优选商品
	 * 
	 * @return
	 */
	public String listMainPic() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			super.pageBean = bannarPnService.listPage(getPageParam(), paramMap);
			super.putData("mainPic", bannarPn);
			super.pushData(pageBean);
		} catch (Exception e) {
			log.error("== listYouXuan exception:", e);
			return operateError("获取数据失败");
		}
		return "listMainPic";
	}

	/**
	 * 准备更新
	 */
	public String readyUpdate() {
		try {
			BannarPn byId = bannarPnService.getById(bannarPn.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			super.putData("mainPic", byId);
		} catch (Exception e) {
			log.error("== readyUpdate exception:", e);
			return operateError("获取数据失败");
		}
		return "updateDetials";
	}

	/**
	 * 更新
	 */
	public String updateMainImg() {
		try {
			BannarPn byId = bannarPnService.getById(bannarPn.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			String oldImgId = byId.getUrl();
			String imgId = UUIDUitl.generateMixString(10);
			if (file != null) {
				InputStream is = new FileInputStream(file);
				String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
				if (uploadFile == null) {
					return operateError("添加数据失败");
				}
				bannarPn.setUrl(
						"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			}
			long result = bannarPnService.update(bannarPn);
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
			BannarPn y = bannarPnService.getById(bannarPn.getId());
			y.setStatus(bannarPn.getStatus());
			long update = bannarPnService.update(y);
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
			InputStream is = new FileInputStream(file);
			String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
			if (uploadFile == null) {
				return operateError("添加数据失败");
			}
			bannarPn.setUrl(
					"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			long result = bannarPnService.insert(bannarPn);
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
	public String deleteByMainPicId() {
		try {
			BannarPn byId = bannarPnService.getById(bannarPn.getId());
			if (byId == null) {
				return operateError("数据已删除");
			}
			String[] split = byId.getUrl().split(".com/");
			String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, split[1]);
			if (deleteFile == null) {
				return operateError("删除数据失败");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", bannarPn.getId()); //
			bannarPnService.getBy(paramMap, "deleteById");
		} catch (Exception e) {
			log.error("== deleteByMainPicId exception:", e);
			return operateError("删除数据失败");
		}
		return operateSuccess();
	}

	@Override
	public BannarPn getModel() {
		if (bannarPn == null) {
			bannarPn = new BannarPn();
		}
		return bannarPn;
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
