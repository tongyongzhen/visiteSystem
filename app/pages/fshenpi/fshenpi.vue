<template>
	<view class="container">
		<view class="a">{{"张三"}}</view>
		<view class="a">{{"123456789"}}</view>
		<view class="a">{{"苏F000001"}}</view>
		<view class="a">{{"百度公司"}}</view>
		<view class="a">{{"普通访客"}}</view>
		<view v-if="loginUser.isEmployee==0">
			<view class="c">拜访时间段</view>
			<view class="item">
				<view class="right">
					<view class="example-body">
								<uni-datetime-picker type="date" :clear-icon="false" v-model="data.visiteStartTime" @maskClick="maskClick" />
							</view>
				</view>
			</view>
			<view class="item">
				<view class="right">
					<view class="example-body">
								<uni-datetime-picker type="date" :clear-icon="false" v-model="data.visiteEndTime" @maskClick="maskClick" />
							</view>
				</view>
			</view>
		</view>
		<view class="b">
			<view>
				<button type="primary" class="button" @click="ty">同意</button>
			</view>
			<view>
				<button type="primary" class="button" @click="jj">拒绝</button>
			</view>
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
				loginUser:{},
				data:{
					visiteEndTime:undefined,
					visiteStartTime:undefined,
				}
			}
		},
		methods: {
			ty(){
				uni.navigateTo({
					url:"/pages/yycg/yycg"
				})
			},
			jj(){
				uni.navigateTo({
					url:"/pages/yysb/yysb"
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
		font-size: 20px;
		text-align: center;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	.b{
		display: flex;
		justify-content: space-between;
	}
	.c{
		font-size: 20px;
		margin-top: 15px;
	}
	.d{
		border: solid;
		color: gray;
		border-width: 1px;
		border-radius: 5px;
		margin-top: 10px;
	}
	.button{
		margin-top: 50px;
		width: 100px;
		height: 50px;
		background-color: lightslategray;
	}
	.right{
		margin-top: 10px;
	}
</style>
