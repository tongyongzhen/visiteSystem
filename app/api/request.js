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
})




//注册
export function register(data){
	return axios({
		url:"/web/login_register/register",
		method:"post",
		data:data
	})
}



