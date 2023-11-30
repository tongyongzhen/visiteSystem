<template>
	<view class="container">
		<view class="title"><h1>访问记录</h1></view>
		<view class="no" v-if="have">没有任何访问记录</view>
		<view v-for="(list,type) in visiteList">
			<view class="item" v-for="item in list" @click="toDetail(type,item)">
				<view class="title">
					<view class="content">{{visitType(type)}}</view>
				</view>
				<view class="time">{{item.appointTime}}</view>
			</view>
		</view>
	</view>
</template>

<script>
	import {cxyy,queryVisitMe} from '../../api/request.js'
	export default {
		onShow() {
			queryVisitMe().then(resp=>{
				 this.visiteList=resp.data.data
				 if(this.visiteList["0"].length==0 && this.visiteList["1"].length==0 ){
					 this.have=true
				 }

			})
		},
		data() {
			return {
				visiteList:{},
				have:false
			}
		},
		methods: {
			visitType(type){
					  switch(type){
						  case "0":
							return "普通"
							break;
						  case "1":
							return "vip"
							break;
						  
					  }
			},
			
			toDetail(type,data){
				uni.navigateTo({
					url:"/pages/visitMe/visiteMe?data="+JSON.stringify({
						type:type,
						data:data
					})
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
	
	.item{
		display: flex;
		justify-content: space-between;
		box-shadow:0 0 2rpx #000000;
		align-items: center;
		margin-top: 10px;
		.title{
			width: 50px;
			height: 50px;
			background-color: #00aaff;
			text-align: center;
			display: flex;
			justify-content: center;
			align-items: center;
			.content{
				color: aliceblue;
				font-size: 20px;
			}
		
		}
	}
</style>