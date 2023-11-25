<template>
	<view>
		<view class="a"><h1>访客系统注册</h1></view>
		<view class="item">
			<view class="left">姓名</view>
			<view class="right">
				<input type="text" v-model="data.name" placeholder="请输入姓名"/>
			</view>
		</view>
		<view class="item">
			<view class="left">手机号</view>
			<view class="right">
				<input type="text" v-model="data.phone" placeholder="请输入手机号"/>
			</view>
		</view>
		<view class="item">
			<view class="left">密码</view>
			<view class="right">
				<input type="password" v-model="data.password" placeholder="请输入密码"/>
			</view>
		</view>
		<view class="item">
			<view class="left">重复密码</view>
			<view class="right">
				<input type="password" v-model="passwordRepeat" @blur="check" placeholder="请再次输入密码"/>
			</view>
			<view class="label" :class="isSame?'success':'fail'"></view>
		</view>
		<view class="item">
			<view class="left">车牌号</view>
			<view class="right">
				<input type="text" v-model="data.pai" placeholder="请输入车牌号"/>
			</view>
		</view>
		<view class="item">
			<view class="left">所属公司</view>
			<view class="right">
				<input type="text" v-model="data.company" placeholder="请输入所属公司"/>
			</view>
		</view>
		<view class="bottom">
			<button type="primary" @click="register">注册</button>
		</view>
	</view>
</template>

<script>
	import {register} from "../../api/request.js"
	export default {
		mounted() {
		},
		data() {
			return {
				isSame:true,
				passwordRepeat:undefined,
				data:{
					name:undefined,
					password:undefined,
					phone:undefined,
					carnum:undefined,
					company:undefined
				}
			}
		},
		methods: {
			register(){
				register(this.data).then(resp=>{
					if(resp.data.code==200){
						uni.showToast({
							icon:"success",
							title:"注册成功"
						})
						setTimeout(x=>{
							uni.navigateTo({
								url:"/pages/login/login"
							})
						},1500)
						
					}
						
					
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
		}

</style>
