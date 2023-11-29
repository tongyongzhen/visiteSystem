<template>
	<view class="container">
		<view class="title"><h1>访问记录</h1></view>
		<view class="no" v-if="list.length==0">没有任何访问记录</view>
		<view class="c" v-for="(p,index) in list" :key="index">
			<view @click="yy(p)" class="a">
				<view>{{"访问"}}{{index+1}}</view>
				<view>{{p.appointTime}}</view>
			
			</view>
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
				list:[]
			}
		},
		methods: {
			yy(details){
				uni.navigateTo({
					url:"/pages/fyyxx/fyyxx?details="+JSON.stringify(details)+"&code="+details.code
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
	.title{
		color: seagreen;
		text-align: center;
	}
	.a{
		display: flex;
		justify-content: space-between;
		color: seagreen;
		text-align: center;
		margin-top: 20px;
	}
	.c{
		font-size: 20px;
		margin-top: 10px;
		box-shadow:0 0 2rpx #000000;
	}
	
	.no{
		display: flex;justify-content: center;
		margin-top: 50px;
		padding-bottom: 10px;
		border-bottom: 1px solid #c6c6c6;
	}
</style>