<template>
	<view>
		<view v-if="loginUser.deptId==5">
			<button type="primary" class="button4" @click="scan">扫一扫</button>
		</view>
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
	import {cxwdsp, ofMe,} from "../../api/request.js"
	
	export default {
		onShow() {
			ofMe().then(resp=>{
				this.loginUser=resp.data.data
			})
		},
		data() {
			return {
				loginUser:{},
				deptById:{}
				
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
			},
			scan(){
				uni.navigateTo({
					url:"/pages/scan/scan"
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
		background-color: #fdd5d5;
		width: 100px;
		height: 100px;
		border-radius: 50%;
		border: solid;
		border-width: 1px;
		line-height: 5;
		margin-top: 20px;
		border-color: white;
	}
	.button2{
		color: green;
		background-color: #fddbd9;
		width: 100px;
		height: 100px;
		border-radius: 50%;
		border: solid;
		border-width: 1px;
		line-height: 5;
		margin-top: 20px;
		border-color: white;
	}
	.button3{
		color: cornflowerblue;
		background-color: #fddfdd;
		width: 100px;
		height: 100px;
		border-radius: 50%;
		border: solid;
		border-width: 1px;
		line-height: 5;
		margin-top: 20px;
		border-color: white;
	}
	.button4{
		margin-left: 450px;
		color: hotpink;
		background-color: white;
		width: 100px;
		height: 50px;
		border: soild;
		
	}
	.building{
		background: url(../../static/tx.jpg);
		background-size: 100;
	}
	
</style>
<style>
	page{
		background:url("../../static/zy.jpg")
	}
</style>
