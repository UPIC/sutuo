$(function() {
	getByAjax(4, page,'4');
})
var page = {
	pageNumStr : 1,
	numPerPageStr : 10,
	pageCount : 0,
	isFlag : true,
	pageType : ''
};

function getByAjax(typeId, pagePo,divId) {
	$.ajax({
		type : "POST",
		url : ctx + "/order/searchByType/" + typeId + "/" + pagePo.pageNumStr
				+ "/" + pagePo.numPerPageStr + ".do",
		dataType : "json",// (可以不写,默认)
		beforeSend : function(XMLHttpRequest) {
			progress.inc();
		},
		success : function(datas, textStatus) {
			pagePo.pageCount = datas.pageCount;

			var data = datas.recordList;
			// 如果为空了
			jugeAndDeal(divId, data);
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
	function jugeAndDeal(divId,data) {
		var htmls = "";
		for (var i = 0; i < data.length; i++) {
			htmls += "<div class='box1'><div class='boxleft'>"
					+ obj[data[i].status]
					+ "</div><div class='boxright'>"
					+ FormatDate(data[i].createTime)
					+ "</div><hr data-am-widget='divider' style='' class='am-divider am-divider-default' />";
			htmls += "<div class='box2'><div class='img'><img class='am-radius' alt='140*140' src='"
					+ data[i].pic + "'width='150' height='100' /></div>";
			htmls += "<div class='txt'>[预约";
			htmls += "]" + data[i].shopName + "<p><span>份数："
					+ data[i].shopCount + "份</span><br /> <span>总价："
					+ data[i].price + "元</span></p></div></div>";
			htmls+="<div class='anniu'><a href='javascript:void(0);' onclick='searchDetials("+data[i].orderId+")' ><button type='button'class='am-btn am-btn-default am-radius  am-btn-xs'>预约详情</button></a>";
			htmls+="<a><button type='button'class='am-btn am-btn-default am-radius  am-btn-xs'>删除订单</button></a></div></div>";
		}

		if (page.pageNumStr == 1) {
			$("#"+divId).html(htmls);
		} else {
			$("#"+divId).append(htmls);
		}

	}
	function FormatDate(strTime) {
		var date = new Date(strTime);
		return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
				+ date.getDate();
	}

	function searchDetials(obj){
		location.href = ctx + '/order/' + obj + '/searchByorderId.do';
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
								// 如果已经加载完毕
								if (!page.isFlag) {
									$("#notAnyMore"+divIds).show();
									return;
								}
								getByAjax(4, page,"4");
						}
					});
}