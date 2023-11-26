<template>
	<view>
		<view class="yonghu">
			<view style="display: flex;justify-content: center;align-items: center;">
				<view style="width: 80px;height: 80px;display: flex;justify-content: center;align-items: center;">
					<image class="image1" src="../../static/tx.jpg"></image></view>
				<view style="margin-left: 20px;">{{loginUser.name}}</view>
				
				</view>
			<view><image class="image2" src="../../static/ewm.png"></image></view>
		</view>
		<view class="item">
			<view @click="yyxx">
				<image class="image3" src="../../static/xiaoxi.png"></image>预约信息
			</view>
			<view>></view>
		</view>
		<view class="item">
			<view>
				<image class="image3" src="../../static/yjfk.png"></image>意见反馈
			</view>
			<view>></view>
		</view>
		<view class="item">
			<view>
				<image class="image3" src="../../static/jcgx.png"></image>检查更新
			</view>
			<view>></view>
		</view>
		<view class="item">
			<view>
				<image class="image3" src="../../static/grxx.png"></image>个人信息
			</view>
			<view>></view>
		</view>
		<view class="item">
			<view>
				<image class="image3" src="../../static/yhk.png"></image>我的银行卡
			</view>
			<view>></view>
		</view>
		<view class="item">
			<view>
				<image class="image3" src="../../static/gywm.png"></image>关于我们
			</view>
			<view>></view>
		</view>
		<view class="item">
			<view>
				<image class="image3" src="../../static/fwjl.png"></image>访问记录
			</view>
			<view>></view>
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
			};
		},
		methods:{
			yyxx(){
				uni.navigateTo({
					url:"/pages/wdyy/wdyy"
				})
			}
		}
		
	}
</script>

<style lang="scss" scoped>
	.yonghu{
		display: flex;
		justify-content: space-between;
		font-size: 20px;
		margin-top: 10px;
		border-radius: 10rpx;
		box-shadow:0 0 2rpx #000000;
	}
	.image1{
		width: 90%;
		height: 90%;
		border-radius: 10rpx;
		box-shadow:0 0 2rpx #000000;
	}
	.image2{
		width: 70px;
		height: 70px;
		margin-top: 10px;
	}
	.image3{
		width: 20px;
		height: 18px;
	}
	.item{
		font-size: 20px;
		margin: 20px 30px;
		margin-top: 10px;
		display: flex;
		justify-content: space-between;
		border-radius: 10rpx;
		box-shadow:0 0 2rpx #000000;
		
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
</style>
