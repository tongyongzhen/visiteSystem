<template>
	<view >
		<view class="container">
			<button type="primary" class="button1" @click="yuyue">预约</button>
		</view>
		<view class="container">
			<button type="primary"  class="button2" @click="shenpi">审批</button>
		</view>
		<view class="container">
			<button type="primary" class="button3" @click="lichang">离场</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods:{
			yuyue(){
				uni.switchTab({
					url:"/pages/ptfk/ptfk"
				})		
			},
			shenpi(){
				uni.switchTab({
					url:"/pages/shenpi/shenpi"
				})
			},
			lichang(){
				uni.switchTab({
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
</style>
