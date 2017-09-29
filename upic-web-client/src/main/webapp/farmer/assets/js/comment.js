$(function() {
	getByAjax(typeId, pagePoShop);
	// getByAjax(2, pagePoFarmer);
})
var pagePoShop = {
	pageNumStr : 1,
	numPerPageStr : 10,
	pageCount : 0,
	isFlag : true
};
// var pagePoFarmer = {
// pageNumStr : 1,
// numPerPageStr : 10,
// pageCount : 0,
// isFlag : true
// };
// var isFlagFarmer = true;
var isFlagShop = true;
function getByAjax(typeId, pagePo) {
	// searchParent.t = JSON.stringify(search);
	// var datas = JSON.stringify(pagePo);
	$.ajax({
		type : "POST",
		url : ctx + "/comment/listPage/" + typeId + "/" + objId + "/"
				+ pagePo.pageNumStr + "/" + pagePo.numPerPageStr + ".do",
		dataType : "json",// (可以不写,默认)
		beforeSend : function(XMLHttpRequest) {
			progress.inc();
		},
		success : function(datas, textStatus) {
			pagePo.pageCount = datas.pageCount;

			var data = datas.recordList;
			// 如果为空了
			jugeAndDeal(data);
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
	function jugeAndDeal(data) {
		var htmls = "";
		for (var i = 0; i < data.length; i++) {
			var date = new Date(data[i].createTime);
			var dateStr = date.pattern("yyyy-MM-dd hh:mm:ss");
			/*
			 * htmls += "<div class='big-main'><div class='part4-left'><div
			 * class='small-left'>"; htmls += "<img class='am-circle' src=" +
			 * data[i].pic + " width='50' height='50' /></div><div
			 * class='small-right'>"; htmls += "<span class=''>" +
			 * data[i].nickName + "</span><br /> "; htmls += "<span
			 * class='smalldd'>" + data[i].content + "</span>"; htmls += "</div></div><div
			 * class='part4-right'><span class='part4-time'>" + dateStr + "</span></div><div
			 * class='clear'></div></div>";
			 */
			htmls += "<div class='big-main'><div class='part4-left'>"

			htmls += "<img class='am-circle' src=" + data[i].pic
					+ " width='50' height='50' /></div>";
			htmls += "<div class='part4-right'><div class='username'><div class='nameleft'>"
					+ data[i].nickName + "</div>";
			htmls += "<div class='timeright'>" + dateStr + "</div></div>";
			htmls += "<div class='usermessage'>" + data[i].content
					+ "</div></div><div class='clear'></div></div>";

		}
		if (pagePoShop.pageNumStr == 1) {
			$("#comment").html(htmls);
		} else {
			$("#comment").append(htmls);
		}

	}

	/** 滚动条* */
	var totalheight = 0;// 定义一个总的高度变量
	$(window).scroll(
			function() {
				totalheight = parseFloat($(window).height())
						+ parseFloat($(window).scrollTop());// 浏览器的高度加上滚动条的高度
				if ($(document).height() <= totalheight) // 当文档的高度小于或者等于总的高度的时候，开始动态加载数据
				{

					if (!pagePoShop.isFlag) {
						$("#notAnyMoreShop").show();
						return;
					}
					getByAjax(typeIds, pagePoShop);
				}
			});
}

Date.prototype.pattern = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, // 小时
		"H+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	var week = {
		"0" : "/u65e5",
		"1" : "/u4e00",
		"2" : "/u4e8c",
		"3" : "/u4e09",
		"4" : "/u56db",
		"5" : "/u4e94",
		"6" : "/u516d"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt
				.replace(
						RegExp.$1,
						((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
								: "/u5468")
								: "")
								+ week[this.getDay() + ""]);
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}
