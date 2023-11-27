<template>
	<view>
		<view class="container">
			<button type="primary" class="button1" @click="yuyue">预约</button>
		</view>
		<view class="container" v-if="loginUser.isEmployee==0">
			<button type="primary"  class="button2" @click="shenpi">审批</button>
		</view>
		<view class="container">
			<button type="primary" class="button3" @click="lichang">离场</button>
		</view>
	</view>
</template>

<script>
	import {ofMe} from "../../api/request.js"
	
	export default {
		onShow() {
			ofMe().then(resp=>{
				this.loginUser=resp.data.data
			})
		},
		data() {
			return {
				loginUser:{}	
			}
		},
		methods:{
			yuyue(){
				if(this.loginUser.isEmployee==0){
						uni.navigateTo({
						url:"/pages/vip/vip",
					})		
				}
				let type=this.loginUser.type
				switch(type){
					case 0:
					uni.navigateTo({
					url:"/pages/ptfk/ptfk",
				})
					break;
					case 2:
						uni.navigateTo({
						url:"/pages/cqwl/cqwl",
					})
						break;	
					case 3:
						uni.navigateTo({
						url:"/pages/dqwl/dqwl",
					})
						break;
					case 4:
						uni.navigateTo({
						url:"/pages/sgry/sgry",
					})
						break;
				}
					
			},
			shenpi(){
				uni.navigateTo({
					url:"/pages/shenpi/shenpi"
				})
			},
			lichang(){
				uni.navigateTo({
					url:"/pages/lichang/lichang"
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
	.container {
		padding: 20px;
		font-size: 14px;
		line-height: 24px;
		display: flex;
	}
	.button1{
		color: red;
		background-color: white;
		width: 100px;
		height: 100px;
		border-radius: 50%;
		border: solid;
		line-height: 5;
	}
	.button2{
		color: green;
		background-color: white;
		width: 100px;
		height: 100px;
		border-radius: 50%;
		border: solid;
		line-height: 5;
	}
	.button3{
		color: blue;
		background-color: white;
		width: 100px;
		height: 100px;
		border-radius: 50%;
		border: solid;
		line-height: 5;
	}
	.building{
		background: url(../../static/tx.jpg);
		background-size: 100;
	}
</style>
