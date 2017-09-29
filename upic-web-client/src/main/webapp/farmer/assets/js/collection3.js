$(function() {
	getByAjax(1, pagePoShop);
//	getByAjax(2, pagePoFarmer);
})
var pagePoShop = {
	pageNumStr : 1,
	numPerPageStr : 10,
	pageCount : 0,
	isFlag : true
};
var pagePoFarmer = {
	pageNumStr : 1,
	numPerPageStr : 10,
	pageCount : 0,
	isFlag : true
};
var isFlagFarmer = true;
var isFlagShop = true;
function getByAjax(typeId, pagePo) {
//	searchParent.t = JSON.stringify(search);
	var datas = JSON.stringify(pagePo);
	$.ajax({
		type : "POST",
		url : ctx + "/collection/searchByType/" + typeId + "/"
				+ pagePo.pageNumStr + "/" + pagePo.numPerPageStr + ".do",
		dataType : "json",// (可以不写,默认)
		beforeSend : function(XMLHttpRequest) {
			progress.inc();
		},
		success : function(datas, textStatus) {
			pagePo.pageCount = datas.pageCount;

			var data = datas.recordList;
			// 如果为空了
			jugeAndDeal(typeId, data);
			pagePo.pageNumStr = pagePo.pageNumStr + 1;
			if (pagePo.pageNumStr > pagePo.pageCount) {
				pagePo.isFlag = false;
			}
		},
		complete : function(XMLHttpRequest, textStatus) {
			progress.done(true);
		},
		error : function() {
			alert("加载失败请重试");
			progress.done(true);
		}
	});
	function jugeAndDeal(type, data) {
		switch (type) {
		case 2:
			var htmls = "";
			for (var i = 0; i < data.length; i++) {
				htmls += "<div class='boxs'><div class='box3'><img src='"
						+ data[i].storeHeadPic + "'/><div class='right'>"
						+ data[i].storeName + "</div></div>";
				htmls += "<div class='box4' style='background-image:url("
						+ data[i].backPic
						+ "); background-size:contain'><span class='tab'>人均:"
						+ data[i].avgCost + "元 </span></div>";
				htmls += "<div class='box5'>"
						+ data[i].title
						+ "<span class='span2' onClick='goStoreByStoreNumber('"
						+ data[i].storeNumber
						+ "')'>进店逛逛<i class='am-icon-chevron-right'></i></span></div></div>";
			}
			if (pagePoShop.pageNumStr == 1) {
				$("#farmers").html(htmls);
			} else {
				$("#farmers").append(htmls);
			}
			break;
		case 1:
			var htmls = "";
			for (var i = 0; i < data.length; i++) {
				htmls += "<div class='bg-wh'><table id='tb-one'><tr><td><img class=''am-radius' alt=''140*140'src='"
						+ data[i].shopHeadPic + "'></td><td class='td-sd'>";
				htmls += "<div class='tt'>" + data[i].shopName
						+ "</div> <span class='place'>" + data[i].city + "·"
						+ data[i].district
						+ "</span><div><span class='people'>"
						+ data[i].shopPrice + "元/" + data[i].peopleNum
						+ "</span>";
				htmls += "</div> <span class='bord'>" + data[i].themetz
						+ "</span> <span class='bord'>" + data[i].project
						+ "</span></td></tr></table></div>";
			}

			if (pagePoShop.pageNumStr == 1) {
				$("#farmers").html(htmls);
			} else {
				$("#farmers").append(htmls);
			}
			break;
		default:
			break;
		}

	}

	/** 滚动条* */
	var totalheight = 0;// 定义一个总的高度变量
	$(window)
			.scroll(
					function() {
						totalheight = parseFloat($(window).height())
								+ parseFloat($(window).scrollTop());// 浏览器的高度加上滚动条的高度
						if ($(document).height() <= totalheight) // 当文档的高度小于或者等于总的高度的时候，开始动态加载数据
						{

							if ($(".am-tab-panel.am-active").attr("id") === "farmers") {
								// 如果已经加载完毕
								if (!pagePoFarmer.isFlag) {
									$("#notAnyMoreFarmer").show();
									return;
								}
								getByAjax(1, pagePoShop);
							} else if ($(".am-tab-panel.am-active").attr("id") === "shop") {
								if (!pagePoShop.isFlag) {
									$("#notAnyMoreShop").show();
									return;
								}
								getByAjax(2, pagePoFarmer);
							}
						}
					});
}