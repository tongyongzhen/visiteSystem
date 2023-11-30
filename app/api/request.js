import axios from "axios"

//添加请求拦截器
axios.interceptors.request.use(function (config){
	//获取token
	let token=sessionStorage.getItem("token")
	//将token添加到请求头
	if(token!=null){
		config.headers["token"]=token
		return config
	}
	return config
})

//添加响应拦截器
axios.interceptors.response.use(resp=>{
	if(resp.data.code!=200){
		uni.showToast({
			icon:"none",
			title:`${resp.data.msg}`
		})
	}
	if(resp.data.code==401){
		setTimeout(x=>{
			uni.navigateTo({
				url:"/pages/login/login"
			})
		},1500)
	}
	
	return resp
},error=>{
	setTimeout(x=>{
		uni.navigateTo({
			url:"/pages/login/login"
		})
	},1500)
})




//注册
export function register(data){
	return axios({
		url:"/web/login_register/register",
		method:"post",
		data:data
	})
}

//登录
export function login(data){
	return axios({
		url:"/web/login_register/login",
		method:"post",
		data:data
	})
}

//长期物流预约
export function cqwlyy(data){
	return axios({
		url:"/web/Appointment/CarLongAppoint",
		method:"post",
		data:data
	})
}

//施工人员预约
export function sgryyy(data){
	return axios({
		url:"/web/Appointment/BuildAppoint",
		method:"post",
		data:data
	})
}

//短期物流预约
export function dqwlyy(data){
	return axios({
		url:"/web/Appointment/CarShortAppoint",
		method:"post",
		data:data
	})
}

//普通访客预约
export function ptfkyy(data){
	return axios({
		url:"/web/Appointment/CommonAppoint",
		method:"post",
		data:data
	})
}

//VIP访客预约
export function vipyy(data){
	return axios({
		url:"/web/Appointment/VIPAppoint",
		method:"post",
		data:data
	})
}

//查询所有部门
export function cxbm(){
	return axios({
		url:"/web/user_Dept/queryAllDept",
		method:"get",
		
	})
}

//根据id查询人员
export function cxry(id){
	return axios({
		url:"/web/user_Dept/queryAllUsersByDeptId/"+id,
		method:"get",
		
	})
}

//查询登录人员信息
export function ofMe(){
	return axios({
		url:"/web/user_Dept/ofMe",
		method:"get"
		
	})
}

//查询我的预约
export function cxyy(){
	return axios({
		url:"/web/Appointment/queryMyAppointment",
		method:"get"
		
	})
}

//施工人员审批
export function sgrysp(){
	return axios({
		url:"/web/Examine/BuildExamine",
		method:"get"
		
	})
}

//查询我的审批
export function cxwdsp(){
	return axios({
		url:"/web/Examine/queryMyExamine",
		method:"get"
		
	})
}

//根据部门id查询部门信息
export function queryDeptById(id){
	return axios({
		url:"/web/user_Dept/queryDeptById/"+id,
		method:"get"
		
	})
}
//根据用户id查询用户信息
export function queryUserById(id){
	return axios({
		url:"/web/user_Dept/queryUserById/"+id,
		method:"get"
		
	})
}

//根据id查询二维码
export function queryCodeById(id){
	return axios({
		url:"/web/Appointment/queryCodeById/"+id,
		method:"get"
		
	})
}
//普通审批
export function commonExamine(data){
	return axios({
		url:"/web/Examine/CommonExamine",
		method:"post",
		data:data
		
	})
}
//建筑工人审批
export function buildExamine(data){
	return axios({
		url:"/web/Examine/BuildExamine",
		method:"post",
		data:data
		
	})
}
//vip审批
export function vipExamine(data){
	return axios({
		url:"/web/Examine/VipExamine",
		method:"post",
		data:data
		
	})
}

//长期建筑工人图片上传
export function carLongPictureUp(data){
	return axios({
		url:"/web/Examine/CarLongPictureUp",
		method:"post",
		data:data
	})
}
//短期建筑工人图片上传
export function carShortPictureUp(data){
	return axios({
		url:"/web/Examine/CarShortPictureUp",
		method:"post",
		data:data
	})
}
//长期建筑工人部门审批
export function carLongPictureExamine(data){
	return axios({
		url:"/web/Examine/carLongPictureExamine",
		method:"post",
		data:data
	})
}
//短期建筑工人部门审批
export function carShortPictureExamine(data){
	return axios({
		url:"/web/Examine/carShortPictureExamine",
		method:"post",
		data:data
	})
}
//短期建筑工人保安审批
export function carShortBaoAnExamine(data){
	return axios({
		url:"/web/Examine/carShortBaoAnExamine",
		method:"post",
		data:data
	})
}
//长期建筑工人保安审批
export function carLongBaoAnExamine(data){
	return axios({
		url:"/web/Examine/carLongBaoAnExamine",
		method:"post",
		data:data
	})
}
//获取长期货物图片
export function queryLongPictureById(id){
	return axios({
		url:"/web/Examine/queryLongPictureById/"+id,
		method:"get"
	})
}
//获取短期货物图片
export function queryShortPictureById(id){
	return axios({
		url:"/web/Examine/queryShortPictureById/"+id,
		method:"get"
	})
}

//查询访问我的
export function queryVisitMe(){
	return axios({
		url:"/web/Appointment/queryVisitMe",
		method:"get"
	})
}
//普通访客结束
export function commonVisiteEnd(id){
	return axios({
		url:"/web/visiteEnd/commonVisiteEnd/"+id,
		method:"get"
	})
}
//vip访客结束
export function vipVisiteEnd(id){
	return axios({
		url:"/web/visiteEnd/vipVisiteEnd/"+id,
		method:"get"
	})
}
//访客扫码进入
export function goin(id){
	return axios({
		url:"/web/visiteEnd/goin/"+id,
		method:"get"
	})
}







