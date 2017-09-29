package com.upic.web.boss.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ModelDriven;
import com.upic.common.config.PublicConfig;
import com.upic.common.utils.MakeOrderNum;
import com.upic.common.utils.OOSUtils;
import com.upic.common.utils.UUIDUitl;
import com.upic.po.ActivityArea;
import com.upic.po.ArticalPn;
import com.upic.po.MeituPn;
import com.upic.po.TypePn;
import com.upic.service.IActivityAreaService;
import com.upic.service.IArticalPnService;
import com.upic.service.IMeituPnService;
import com.upic.service.ISignPnService;
import com.upic.service.IThemePnService;
import com.upic.service.ITypePnService;
import com.upic.shop.enums.TypeClassEnum;

import wusc.edu.pay.web.boss.base.BossBaseAction;

public class ArticleAction extends BossBaseAction implements ModelDriven<TypePn> {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ArticleAction.class);
	private TypePn typePn;

	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File files;

	// 提交过来的file的名字
	private String fileFileName;

	private String result;
	// 提交过来的file的MIME类型
	private String fileContentType;
	@Autowired
	private IArticalPnService articalPnService;

	@Autowired
	private ITypePnService typePnService;

	@Autowired
	private IMeituPnService meituPnService;

	@Autowired
	private IThemePnService themePnService;

	@Autowired
	private ISignPnService signPnService;

	/**
	 * 查看所有文章、图片、视频等
	 * 
	 * @return
	 */
	public String listTypePn() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("typePnNumberLike", typePn.getTypePnNumber());
			paramMap.put("typePn", typePn.getTypePn());
			paramMap.put("themeName", typePn.getTypePn());
			paramMap.put("title", typePn.getTitle());
			paramMap.put("articName", typePn.getArticName());
			paramMap.put("orderDateBegin", typePn.getOrderDateBegin());
			paramMap.put("orderDateEnd", typePn.getOrderDateEnd());
			// 关于品农的所有主题
			List<Object> listBy = themePnService.listBy(null, "listAll");
			// 关于品农的所有类型
			super.pageBean = typePnService.listPage(getPageParam(), paramMap);
			super.putData("typePn", typePn);
			super.putData("themePns", listBy);
			super.putData("typeClass", TypeClassEnum.toMap());
			super.pushData(pageBean);
		} catch (Exception e) {
			log.error("== listTypePn exception:", e);
			return operateError("获取数据失败");
		}
		return "listTypePn";
	}

	/**
	 * 准备更新
	 */
	public String readyUpdate() {
		try {
			TypePn byId = typePnService.getById(typePn.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			List<Object> listBy = themePnService.listBy(null, "listAll");
			super.putData("themePn", listBy);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("fatherId", byId.getId());
			super.putData("typePn", byId);
			// 文章
			if (byId.getTypePn().equals(TypeClassEnum.ARTICALPN.getDesc())) {
				Object o = articalPnService.getBy(paramMap, "listAll");
				super.putData("articalPn", o);
				return "readyArtic";
				// 图片
			} else if (byId.getTypePn().equals(TypeClassEnum.MEITU.getDesc())) {
				// List<Object> obj = meituPnService.listBy(paramMap,
				// "listAll");
				super.pageBean = meituPnService.listPage(getPageParam(), paramMap);
				// super.putData("meitu", obj);
				super.pushData(pageBean);
				super.putData("fatherId", byId.getId());
				return "seeMeituDetials";
			}
		} catch (Exception e) {
			log.error("== readyUpdate exception:", e);
			return operateError("获取数据失败");
		}
		return "";
	}

	/**
	 * 更新文章
	 */
	@Transactional(rollbackFor = Exception.class)
	public String updateArticOrSeeMeitu() {
		try {
			TypePn byId = typePnService.getById(typePn.getId());
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
				typePn.setPicUrl(
						"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			}
			typePn.setVersion(byId.getVersion());
			long result = typePnService.update(typePn);
			if (result == 0) {
				if (files != null) {
					OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
							PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId);
					// 失败存储日志
					return operateError("添加数据失败");
				}
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("typePnNumber", byId.getTypePnNumber());
			ArticalPn a = new ArticalPn();
			a.setPic("http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			TypePn by = (TypePn) typePnService.getBy(paramMap, "listAll");
			if (by == null) {
				return operateError("获取typn失败");
			}
			a.setVersion(getInteger("version"));
			a.setId(getLong("articId"));
			a.setArticName(typePn.getArticName());
			a.setAuthor(getString("author"));
			a.setContent(getString("content"));
			a.setFatherNumber(byId.getTypePnNumber());
			a.setFatherId(by.getId() + "");
			a.setTitle(getString("title"));
			long insert = articalPnService.update(a);
			if (insert == 0) {
				return operateError("存储文章失败");
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
			TypePn y = typePnService.getById(typePn.getId());
			y.setStatus(typePn.getStatus());
			long update = typePnService.update(y);
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
	 * 准备添加文章
	 * 
	 * @return
	 */
	public String readyInsertArtic() {
		try {
			List<Object> listBy = themePnService.listBy(null, "listAll");
			super.putData("themePn", listBy);
		} catch (Exception e) {
			log.error("准备文章添加失败", e);
			return this.operateError("操作异常，请重试");
		}
		return "addArtic";
	}

	/**
	 * 添加文章
	 */
	@Transactional(rollbackFor = Exception.class)
	public String insertArtic() {
		try {
			String imgId = UUIDUitl.generateMixString(10);
			InputStream is = new FileInputStream(files);
			String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
			if (uploadFile == null) {
				return operateError("上传数据失败");
			}
			// 生成编号 根据时间
			String pnId = MakeOrderNum.makeOrderNum();
			ArticalPn a = new ArticalPn();
			a.setPic("http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			typePn.setPicUrl(a.getPic());
			typePn.setTypePnNumber(pnId);
			typePn.setTypePn(TypeClassEnum.ARTICALPN.getDesc());
			long result = typePnService.insert(typePn);
			if (result == 0) {
				OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId);
				// 存储日志
				throw new Exception("获取typn失败");
				// return operateError("获取typn失败");
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("typePnNumber", pnId);
			TypePn by = (TypePn) typePnService.getBy(paramMap, "listAll");
			if (by == null) {
				throw new Exception("获取typn失败");
				// return operateError("获取typn失败");
			}
			a.setArticName(typePn.getArticName());
			a.setAuthor(getString("author"));
			a.setContent(getString("content"));
			a.setFatherNumber(pnId);
			a.setFatherId(by.getId() + "");
			a.setTitle(getString("title"));
			a.setPic(a.getPic());
			long insert = articalPnService.insert(a);
			if (insert == 0) {
				throw new Exception("存储文章失败");
			}

		} catch (Exception e) {
			log.error("== insert exception:", e);
			return operateError(e.getMessage());
		}
		return operateSuccess();
	}

	/**
	 * 删除文章
	 * 
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public String deleteByActiveAreaId() {
		try {
			TypePn byId = typePnService.getById(typePn.getId());
			if (byId == null) {
				return operateError("数据已删除");
			}
			if (byId.getPicUrl() != null) {
				String[] split = byId.getPicUrl().split(".com/");
				String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, split[1]);
				if (deleteFile == null) {
					return operateError("删除数据失败");
				}
			}
			// 删除typePn中的
			Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("id", typePn.getId());
			typePnService.getBy(paramMap, "deleteById");
			paramMap.clear();
			paramMap.put("fatherId", typePn.getId());
			// 文章
			if (byId.getTypePn().equals(TypeClassEnum.ARTICALPN.getDesc())) {
				articalPnService.getBy(paramMap, "deleteByFatherId");
				return operateSuccess();
				// 图片
			} else if (byId.getTypePn().equals(TypeClassEnum.MEITU.getDesc())) {
				List<MeituPn> listBy = meituPnService.listBy(paramMap);
				// 删除图片
				for (MeituPn m : listBy) {
					if (m.getPic() != null) {
						String[] split = m.getPic().split(".com/");
						String deleteFile = OOSUtils.deleteFile(PublicConfig.ENDPOINT_SHANGHAI,
								PublicConfig.ACCESSKEYID_IMG, PublicConfig.ACCESSKEYSECRET_IMG,
								PublicConfig.BUCKETNAME_IMG, split[1]);
						if (deleteFile == null) {
							return operateError("删除数据失败");
						}
					}
				}
				meituPnService.getBy(paramMap, "deleteByFatherId");
				return operateSuccess();
			}

		} catch (Exception e) {
			log.error("== deleteByMainPicId exception:", e);
			return operateError("删除数据失败");
		}
		return operateError("没有相关删除方法");
	}

	/**
	 * +========================================================================
	 * ==============================
	 */
	/**
	 * 准备创建美图文字模块(typePn)
	 */
	public String readyCreateMeituByTypePn() {
		try {
			List<Object> listBy = themePnService.listBy(null, "listAll");
			super.putData("themePn", listBy);
		} catch (Exception e) {
			log.error("== readyCreateMeituByTypePn exception:", e);
			return operateError("删除数据失败");
		}
		return "readyCreateMeituByTypePn";
	}

	/**
	 * 创建美图模块（typePn）
	 */
	public String createMeituTypePn() {
		try {
			String imgId = UUIDUitl.generateMixString(10);
			InputStream is = new FileInputStream(files);
			String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
			if (uploadFile == null) {
				return operateError("上传数据失败");
			}
			String pnId = MakeOrderNum.makeOrderNum();
			typePn.setPicUrl(
					"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			typePn.setTypePnNumber(pnId);
			typePn.setTypePn(TypeClassEnum.MEITU.getDesc());
			long result = typePnService.insert(typePn);
			if (result == 0) {
				return operateError("添加数据失败");
			}
		} catch (Exception e) {
			log.error("== createMeitu exception:", e);
			return operateError("创建数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 准备创建美图
	 */
	public String readyCreateMeitu() {
		try {
			super.putData("fatherId", getInteger("id"));
		} catch (Exception e) {
			log.error("== createMeitu exception:", e);
			return operateError("准备数据数据失败");
		}
		return "readyCreateMeitu";
	}

	/**
	 * 根据typeId添加相关美图
	 */
	public String getDetialsByTypePnId() {
		try {
			TypePn byId = typePnService.getById(typePn.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			String imgId = UUIDUitl.generateMixString(10);
			InputStream is = new FileInputStream(files);
			String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
					PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
			if (uploadFile == null) {
				return operateError("上传数据失败");
			}

			MeituPn m = new MeituPn();
			m.setFatherNumber(byId.getTypePnNumber());
			m.setFatherId("" + byId.getId());
			m.setContent(getString("content"));
			m.setPic("http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			m.setNum(getInteger("num"));
			long insert = meituPnService.insert(m);
			if (insert == 0) {
				return operateError("添加数据失败");
			}
		} catch (Exception e) {
			log.error("== getDetialsByTypePnId exception:", e);
			return operateError("获取数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 删除其中一条
	 */
	public String deleteByMeiTuId() {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", typePn.getId());
			meituPnService.getBy(paramMap, "deleteById");
		} catch (Exception e) {
			log.error("== deleteByMeiTuId exception:", e);
			return operateError("刪除数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 准备更新美图其中一条记录
	 */
	public String readyUpdateMeitu() {
		try {
			MeituPn byId = meituPnService.getById(typePn.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			super.putData("meitu", byId);
		} catch (Exception e) {
			log.error("== readyUpdateMeitu exception:", e);
			return operateError("刪除数据失败");
		}
		return "readyUpdateMeitu";
	}

	/**
	 * 更新其中一条记录
	 */
	public String updateMeitu() {
		try {
			MeituPn byId = meituPnService.getById(typePn.getId());
			if (byId == null) {
				return operateError("获取数据失败");
			}
			String oldImgId = byId.getPic();
			String imgId = UUIDUitl.generateMixString(10);
			if (files != null) {
				InputStream is = new FileInputStream(files);
				String uploadFile = OOSUtils.uploadFile(PublicConfig.ENDPOINT_SHANGHAI, PublicConfig.ACCESSKEYID_IMG,
						PublicConfig.ACCESSKEYSECRET_IMG, PublicConfig.BUCKETNAME_IMG, imgId, is);
				if (uploadFile == null) {
					return operateError("添加数据失败");
				}
				byId.setPic(
						"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			}
			if (byId.getNum() != getInteger("num")) {
				byId.setNum(getInteger("num"));
			}
			long result = meituPnService.update(byId);
			if (result == 0) {
				return operateError("更新数据失败");
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
			log.error("== updateMeitu exception:", e);
			return operateError("更新数据失败");
		}
		return operateSuccess();
	}

	/**
	 * 准备更新美图中的typePn
	 */
	public String readyUpdateMeituTypePn() {
		try {
			TypePn t = typePnService.getById(typePn.getId());
			if (t == null) {
				return operateError("准备数据失败");
			}
			List<Object> listBy = themePnService.listBy(null, "listAll");
			super.putData("themePn", listBy);
			super.putData("typePn", t);
		} catch (Exception e) {
			log.error("== readyUpdateMeituTypePn exception:", e);
			return operateError("准备数据失败");
		}
		return "readyUpdateMeituTypePn";
	}

	/**
	 * 更新美图中的typePn
	 * 
	 * @return
	 */
	public String updateMeituTypePn() {
		try {
			TypePn byId = typePnService.getById(typePn.getId());
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
				typePn.setPicUrl(
						"http://" + PublicConfig.BUCKETNAME_IMG + "." + PublicConfig.ENDPOINT_SHANGHAI + "/" + imgId);
			}
			typePn.setVersion(byId.getVersion());
			long result = typePnService.update(typePn);
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
			log.error("== updateMeituTypePn exception:", e);
			return operateError("更新数据失败");
		}
		return operateSuccess();
	}

	@Override
	public TypePn getModel() {
		if (typePn == null) {
			typePn = new TypePn();
		}
		return typePn;
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
