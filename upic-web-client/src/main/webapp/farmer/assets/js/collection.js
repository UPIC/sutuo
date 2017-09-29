$(function() {
	getByAjax(1, pagePoShop);
	// getByAjax(2, pagePoFarmer);
})
var pagePoShop = {
	pageNumStr : 1,
	numPerPageStr : 10,
	pageCount : 0,
	isFlag : true
};
var isFlagShop = true;
function getByAjax(typeId, pagePo) {
	// searchParent.t = JSON.stringify(search);
	if (isFlagShop == false) {
		return;
	}
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
				isFlagShop = false;
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
		var htmls = "";
		for (var i = 0; i < data.length; i++) {
			htmls += "<div class='main'><div class='left'><img class='am-radius' alt='140*140' src='"
					+ data[i].pic + "' height='100' width='160'/>";
			htmls += "</div><div class='right'><div class='name'>"
					+ data[i].shopName + "</div>";
			htmls += "<div class='address'>" + data[i].city + "·"
					+ data[i].district + "</div>";
			if(data[i].price==0){
				htmls += "<div class='price'>询价</div></div></div>";	
			}else{
					htmls += "<div class='price'>"+data[i].price + "元/"  +"人</div></div></div>";	
			}
			
//			else{
//				if(data[i].peopleNum==1){
//					htmls += "<div class='price'>"+data[i].price + "元/"  +"人</div></div></div>";	
//				}else{
//					htmls += "<div class='price'>"+data[i].price + "元/"+ data[i].peopleNum +"人</div></div></div>";
//				}
//			}
		}
		if (pagePoShop.pageNumStr == 1) {
			$("#collection").html(htmls);
		} else {
			$("#collection").append(htmls);
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
					// 如果已经加载完毕
					if (!isFlagShop) {
						$("#notAnyMoreShop").show();
						return;
					}
					getByAjax(1, pagePoShop);
				}
			});
}