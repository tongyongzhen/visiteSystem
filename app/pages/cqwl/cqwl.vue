<template>
	<view class="container">
		<view class="a">登记界面</view>
		<!-- <view class="item">
			<view class="c">姓名</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入姓名"/>
			</view>
		</view>
		<view class="item">
			<view class="c">车牌号</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入车牌号"/>
			</view>
		</view>
		<view class="item">
			<view class="c">电话号码</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入电话号码"/>
			</view>
		</view> -->
		<view>
			<button type="primary" class="button" @click="yuyue">登记</button>
		</view>
	</view>
</template>

<script>
import { cqwlyy } from '../../api/request'
	export default {
		data() {
			return {
				isSame:true,
				passwordRepeat:undefined,
				data:{
					// username:undefined,
					// password:undefined,
					// phone:undefined,
					// name:undefined
				}
				
			}
		},
		methods: {
			yuyue(){
				cqwlyy(this.data).then(resp=>{
					if(resp.data.code==200){
						
						uni.showToast({
							icon:"success",
							title:"预约成功"
						})
						
						setTimeout(x=>{
							uni.switchTab({
								url:"/pages/zhuye/zhuye"
							})
						},1500)
					}
				})
			}
		}
	}
</script>

<style>
	.container {
		padding: 20px;
		font-size: 14px;
		line-height: 24px;
		display: flex;
		flex-direction: column;
	}
	.a{
		font-size: 25px;
		text-align: center;
		margin-top: 10px;
	}
	.item{
		margin-top: 10px;
	}
	.c{
		font-size: 20px;
		margin-top: 20px;
	}
	.d{
		border: solid;
		color: gray;
		border-width: 1px;
		border-radius: 5px;
		margin-top: 10px;
	}
	.button{
		margin-top: 200px;
		width: 100px;
		height: 50px;
		background-color: lightslategray;
	}
</style>
