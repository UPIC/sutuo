
//首页头像异步加载
$(function(){
	 $.ajax({
			type : 'POST',
			url : 'InterfaceWeb/QuanZi.asmx/GetUserInfo',
			dataType : 'json',// (可以不写,默认)
		
			beforeSend : function(XMLHttpRequest) {
				
			},
			data:{
				Token:'cc1777e2-2e24-4ece-aeaa-74e44f2e9b48'
			},
			success : function(datas, textStatus) {
				$("#headPic").attr('src',datas.userheader); 
				$("#names").attr('src',datas.nicheng); 
				$("#lastLoginTime").attr('src',datas.regtime); 
			},
			complete : function(XMLHttpRequest, textStatus) {
				
			},
			error : function() {
			}
		}); 
});
