function getContent() {
		if (pageCount == -1) {
			return;
		}
		if (pageCount != 0) {
			if (pageNumStrs + 1 > pageCount) {
				return;
			}
		}

		var urls = '';
		var obj = '';
		if (linksId != '' || linksId != "") {
			urls = ctx+"/pin/getByLinkId.do";
			obj = themesName;
		} else if (themesName != '' || themesName != "") {
			urls = ctx+"/pin/getByThemeName.do";
			obj = linksId;
		}else if (hotThemes != '' || hotThemes != "") {
			urls = ctx+"/pin/getByHotName.do";
			obj = hotThemes;
			}
		$.ajax({
			type : "POST",
			url : urls,
			dataType : "json",// (可以不写,默认)
			data : {
				data : obj,
				pageNumStr : pageNumStrs,
				numPerPageStr : numPerPageStrs
			},
			beforeSend : function(XMLHttpRequest) {
				progress.inc();
			},
			success : function(datas, textStatus) {
				pageCount = datas.pageCount;
				if (pageCount == 0) {
					pageCount = -1;
				}
				var data = datas.recordList;
				addHtml(data);
				pageNumStrs++;
			},
			complete : function(XMLHttpRequest, textStatus) {
				progress.done(true);
			},
			error : function() {
				alert("加载失败请重试");
				progress.done(true);
			}
		});

	}
	function addHtml(data) {
		if (themesName != '' || themesName != "") {
			var htmls = '';
			for (var i = 0; i < data.length; i+=2) {
				var date = new Date(data[i].createTime);
				var dateStr = date.pattern("yyyy-MM-dd");
				
				htmls+="<a href='"+ctx+"/pin/getByNumber/"+data[i].id+".do'><div class='";
				htmls+="lineone'>";
				htmls+="<div class='partone'>";
				htmls+="<div class='running-box'>";
				htmls+="<img src='"+data[i].picUrl+"' class='long'/></div>"    
				htmls+="<div class='img-tit'>"+dateStr+"</div>";
				htmls+="<div class='text'>"+data[i].articName+"</div>";
				htmls+="<div class='line'></div>"
				htmls+="<div class='am-sans-serif'>"+data[i].title+"</div></div></a>";
				if(i+1<data.length){
				htmls+="<a href='"+ctx+"/pin/getByNumber/"+data[i].typePnId+".do'><div class='";
				if(i==0){
					htmls+="part'>";
					htmls+="<div class='running-box2'>";
					htmls+="<img src='"+data[i+1].picUrl+"' class='long'/></div>"    
					htmls+="<div class='img-tit2'>"+dateStr+"</div>";
				}else{
					var date = new Date(data[i].createTime);
					var dateStr2 = date.pattern("yyyy-MM-dd");
					htmls+="parttwo'>";
					htmls+="<div class='running-box'>";
					htmls+="<img src='"+data[i+1].picUrl+"' class='long'/></div>"    
					htmls+="<div class='img-tit'>"+dateStr2+"</div>";
				}
				htmls+="<div class='text'>"+data[i+1].articName+"</div><div class='line'></div>";
				htmls+="<div class='am-sans-serif'>"+data[i+1].title+"</div></div></a>";
				}
				htmls+="</div>";
			}
			$("#content").append(htmls);
		} else if (linksId != '' || linksId != "") {
			var htmls = '';
			for (var i = 0; i < data.length; i+=2) {
				var date = new Date(data[i].createTime);
				var dateStr = date.pattern("yyyy-MM-dd");
				
				htmls+="<a href='"+ctx+"/pin/getByNumber/"+data[i].typePnId+".do'><div class='";
				htmls+="lineone'>";
				htmls+="<div class='partone'>";
				htmls+="<div class='running-box'>";
				htmls+="<img src='"+data[i].pic+"' class='long'/></div>"    
				htmls+="<div class='img-tit'>"+dateStr+"</div>";
				htmls+="<div class='text'>"+data[i].articalName+"</div>";
				htmls+="<div class='line'></div>"
				htmls+="<div class='am-sans-serif'>"+data[i].title+"</div></div></a>";
				if(i+1<data.length){
				htmls+="<a href='"+ctx+"/pin/getByNumber/"+data[i+1].typePnId+".do'><div class='";
				var date = new Date(data[i+1].createTime);
				var dateStr2 = date.pattern("yyyy-MM-dd");
				if(i==0){
					htmls+="part'>";
					htmls+="<div class='running-box2'>";
					htmls+="<img src='"+data[i+1].pic+"' class='long'/></div>"    
					htmls+="<div class='img-tit2'>"+dateStr2+"</div>";
				}else{
					
					htmls+="parttwo'>";
					htmls+="<div class='running-box'>";
					htmls+="<img src='"+data[i+1].pic+"' class='long'/></div>"    
					htmls+="<div class='img-tit'>"+dateStr2+"</div>";
				}
				htmls+="<div class='text'>"+data[i+1].articalName+"</div><div class='line'></div>";
				htmls+="<div class='am-sans-serif'>"+data[i+1].title+"</div></div></a>";
				}
				htmls+="</div>";
			}
			$("#content").append(htmls);
		}
		else if (hotThemes != '' || hotThemes != "") {
			var htmls = '';
			for (var i = 0; i < data.length; i+=2) {
				var date = new Date(data[i].createTime);
				var dateStr = date.pattern("yyyy-MM-dd");
				
				htmls+="<a href='"+ctx+"/pin/getByNumber/"+data[i].typePnId+".do'><div class='";
				htmls+="lineone'>";
				htmls+="<div class='partone'>";
				htmls+="<div class='running-box'>";
				htmls+="<img src='"+data[i].pic+"' class='long'/></div>"    
				htmls+="<div class='img-tit'>"+dateStr+"</div>";
				htmls+="<div class='text'>"+data[i].articalPnName+"</div>";
				htmls+="<div class='line'></div>"
				htmls+="<div class='am-sans-serif'>"+data[i].title+"</div></div></a>";
				if(i+1<data.length){
				htmls+="<a href='"+ctx+"/pin/getByNumber/"+data[i+1].typePnId+".do'><div class='";
				var date = new Date(data[i+1].createTime);
				var dateStr2 = date.pattern("yyyy-MM-dd");
				if(i==0){
					htmls+="part'>";
					htmls+="<div class='running-box2'>";
					htmls+="<img src='"+data[i+1].pic+"' class='long'/></div>"    
					htmls+="<div class='img-tit2'>"+dateStr2+"</div>";
				}else{
					
					htmls+="parttwo'>";
					htmls+="<div class='running-box'>";
					htmls+="<img src='"+data[i+1].pic+"' class='long'/></div>"    
					htmls+="<div class='img-tit'>"+dateStr2+"</div>";
				}
				htmls+="<div class='text'>"+data[i+1].articalPnName+"</div><div class='line'></div>";
				htmls+="<div class='am-sans-serif'>"+data[i+1].title+"</div></div></a>";
				}
				htmls+="</div>";
			}
			$("#content").append(htmls);
		}
	}
	$(function() {
		getContent();
	})
	$(window).scroll(
			function() {
				totalheight = parseFloat($(window).height())
						+ parseFloat($(window).scrollTop());// 浏览器的高度加上滚动条的高度
				if ($(document).height() <= totalheight) // 当文档的高度小于或者等于总的高度的时候，开始动态加载数据
				{
					getContent();
				}
			});

	
	
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