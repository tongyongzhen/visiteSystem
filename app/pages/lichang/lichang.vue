<template>
	<view>
		<view class="b">离场二维码</view>
		<view class="c">
			<image class="image2" src="../../static/ewm.png">
		</view>
		<view class="b">欢迎您的下次访问</view>
		<view>
			<button type="primary" class="button" @click="tuichu">退出</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			tuichu(){
				uni.navigateTo({
					url:"/pages/login/login"
				})
			}
		}
	}
</script>

<style>
	.b{
		text-align: center;
		margin-top: 70px;
		font-size: 22px;
		
	}
	.c{
		text-align: center;
		margin-top: 10px;
	}
	.image2{
		width: 200px;
		height: 200px;
		margin-top: 10px;
	}
	.button{
		margin-top: 100px;
		width: 100px;
		height: 50px;
		background-color: lightslategray;
	}
</style>
