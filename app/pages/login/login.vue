<template>
	<view>
		<view class="a"><h1>访客系统</h1></view>
		<view class="item">
			<view class="left">手机号</view>
			<view class="right">
				<input type="text" v-model="data.phone" placeholder="请输入手机号" @input="change"/>
			</view>
		</view>
		<view class="item">
			<view class="left">密码</view>
			<view class="right">
				<input type="password" v-model="data.password" placeholder="请输入密码" @input="change"/>
			</view>
		</view>
		<view >
			<button class="bottom" type="primary" @click="login">登录</button>
		</view>
		<view class="b">
			<view @click="zhuce">立即注册</view>
			<view>忘记密码</view>
		</view>
		
	</view>
</template>

<script>
	import {login} from "../../api/request.js"
	export default {
		mounted() {
		},
		data() {
			return {
				isSame:true,
				passwordRepeat:undefined,
				data:{
					password:undefined,
					phone:undefined
				}
				
			}
		},
		methods: {
			login(){
				const v=uni.createInnerAudioContext();
				v.autoplay=true
				v.src="../../static/gm.mp3"
				v.onError(resp=>{
					console.log(resp)
				})

				login(this.data).then(resp=>{
					if(resp.data.code==200){				
						sessionStorage.setItem("token",resp.data.data)
						uni.showToast({
							icon:"success",
							title:"登录成功"
						})
						
						setTimeout(x=>{
							uni.switchTab({
								url:"/pages/zhuye/zhuye"
							})
						},1500)
					}
				})
			},
			change(){
				const v=uni.createInnerAudioContext();
				v.autoplay=true
				v.src="../../static/j.mp3"
				v.onError(resp=>{
					console.log(resp)
				})
			},
			zhuce(){
					uni.navigateTo({
						url:"/pages/register/register"
					})
			},
			check(){
				if(this.data.password==this.passwordRepeat){
					this.isSame=true
				}else{
					this.isSame=false
				}
			},
		}
	}
</script>
<style>
	page{
		background: url("../../static/dl.png");
	}
</style>

<style>
	input {
		width: 200px;
		border-radius: 5rpx;
		box-shadow:0 0 2rpx #000;
		height: 100%;
	}
</style>
<style>
	.a{
		text-align: center;
		margin-top: 30px;
		margin-bottom: 40px;
	}
	
</style>

<style lang="scss" scoped>
	.item{
		font-size: 20px;
		margin: 20px 30px;
		margin-top: 10px;
		display: flex;
		
		.left{
			width: 80px;
		}
		.right{
			margin-left: 10px;
			display: flex;
			flex: 1;
			}
			
			.label{
				width: 10px;
				height: 10px;
				border-radius: 50%;
				margin: auto 0;
				
			}
			.fail{
				background-color: red;
			}
			.success{
				background-color: green;
			}
		}
		
		.bottom{
			margin-top: 40px;
			background:linear-gradient(white, pink, grey);
		}
		
		.b{
			display: flex;
			justify-content: space-between;
		}

</style>

