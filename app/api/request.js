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




