<template>
	<view class="container">
		<view class="a"><h1>我的预约</h1></view>
		<view class="c" v-for="(p,index) in list" :key="index">
			<view @click="yy" class="a">{{"预约"}}{{index+1}}</view>
		</view>
	</view>
</template>

<script>
	import {cxyy} from '../../api/request.js'
	export default {
		onShow() {
			cxyy().then(resp=>{
				 this.list=resp.data.data
			})
		},
		data() {
			return {
				list:[],
				data:{
					
				}
			}
		},
		methods: {
			yy(){
				uni.navigateTo({
					url:"/pages/fshenpi/fshenpi"
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
	}
	.a{
		color: seagreen;
		text-align: center;
		margin-top: 20px;
	}
	.c{
		font-size: 20px;
		margin-top: 10px;
		box-shadow:0 0 2rpx #000000;
	}
</style>
