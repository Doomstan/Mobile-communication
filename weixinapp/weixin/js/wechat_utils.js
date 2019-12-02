//设置 路由ip地址
window.ip = {
	serverip: "http://10.20.151.27:9999"
} 

window.url = {
	upload_head_url: ip.serverip + "/res/uploadFile",
	getuserbyusername_url:ip.serverip+"/user/getUserByUsername",
	friendapply_add_url: ip.serverip+"/friendApply/addFriendApply", 
	getMyFriendApplyList_url: ip.serverip+"/friendApply/getMyFriendApplyList",
}

//设置公共方法
/**
 *  utik
 */
window.util = {
	
	
	//设置ajax
	/**
	 * 
	 * 异步请求
	 * @param {Object} param : 数据
	 */
	ajax: function(param) {
	plus.nativeUI.showWaiting(); // 显示等待的圈
		mui.ajax(
			param.url, //请求地址
			{
				data: param.data, //请求头中的数据
				dataType: 'json', //服务器返回json格式数据
				type: 'post', //HTTP请求类型
				timeout: 10000, //超时时间设置为10秒；
				success: function(data) {
					plus.nativeUI.closeWaiting();
					//服务器返回响应，根据响应结果，
					param.success(data); //页面调用 过后的success 函数
				},
				error: function(xhr, type, errorThrown) {
					//异常处理；
					console.log("网络异常,请稍后");
					plus.nativeUI.toast("网络异常");
					plus.nativeUI.closeWaiting();
				}
			});
	},
	//存储到数据库中  key - value 形式    value 字符串 所以要处理一下
	setUser: function(user) {
		plus.storage.setItem("login_user",JSON.stringify(user));
	},
	//获取用户  且转为json 对象
	getUser: function() {
		return JSON.parse(plus.storage.getItem("login_user"));
	}

}
