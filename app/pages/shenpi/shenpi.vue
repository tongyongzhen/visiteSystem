<template>
	<view class="container">
		<view class="a"><h1>审批</h1></view>
		<view v-for="(list,type) in ExamineInfo">
			<view class="item" v-for="item in list" @click="toExamine(type,item)">
				<view class="title">
					<view class="content">{{visitType(type)}}</view>
				</view>
				<view class="time">{{item.appointTime}}</view>
			</view>
		</view>
		  
		 
	</view>
</template>

<script>
	import {cxwdsp,queryUserById} from '../../api/request.js'
	export default {
		onShow() {
			cxwdsp().then(resp=>{
				if(resp.data.code==200){
					this.ExamineInfo=resp.data.data
				}
			})
		},
	data() {
      return {
		  ExamineInfo:{}
	
      };
    },
    methods: {
	  shenpi(){
		  uni.navigateTo({
		  	url:"/pages/fshenpi/fshenpi"
		  })
	  },
	  /**
	   * 判断是什么访客类型
	   */
	  
	  visitType(type){
		  switch(type){
			  case "0":
				return "普通"
				break;
			  case "1":
				return "vip"
				break;
			  case "2":
				return "长期"
				break;
			  case "3":
				return "临时"
				break;
			  case "4":
				return "建筑"
				break;
		  }
	  },
	  toExamine(type,data){
		  switch(type){
			  case "0":
				uni.navigateTo({
					url:"/pages/examine/commonExamine?data="+JSON.stringify(data)
				})
				break;
			  case "1":
				uni.navigateTo({
					url:"/pages/examine/vipExamine?data="+JSON.stringify(data)
				})
				break;
			  case "2":
				uni.navigateTo({
					url:"/pages/examine/carLongExamine?data="+JSON.stringify(data)
				})
				break;
			  case "3":
				uni.navigateTo({
					url:"/pages/examine/carShortExamine?data="+JSON.stringify(data)
				})
				break;
			  case "4":
				uni.navigateTo({
					url:"/pages/examine/buildExamine?data="+JSON.stringify(data)
				})
				break;
		  }
	  }
	
    },
  };
</script>

<style lang="scss" scoped>
	.container {
		padding: 20px;
		font-size: 14px;
		line-height: 24px;
	}
	.a{
		color: seagreen;
		text-align: center;
		
	}
	/* .b{
		margin-top: 20px;
	} */
	.c{
		display: flex;
		justify-content: space-between;
		font-size: 20px;
		margin-top: 10px;
		box-shadow:0 0 2rpx #000000;
	}
	/* .button{
		margin-top: 20px;
		background-color: white;
		color: black;
	} */
	
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
