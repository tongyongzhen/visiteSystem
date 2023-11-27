<template>
	<view class="container">
		<view class="a"><h1>审批</h1></view>
		<!-- <view class="b">
		    <uni-section title="用户" type="line">
		      <uni-data-select
		        v-model="value"
		        :localdata="range1"
		        @change="change"
		      ></uni-data-select>
		    </uni-section>
			<view class="c">
				<view>
				<uni-section
				  title="提示所属公司,
				  车牌号,
				  拜访空间"
				  subTitle=""
				  type="line"
				> 
				</uni-section></view>
				<view ><button type="primary" class="button" @click="">同意</button></view>
				<view ><button type="primary" class="button" @click="">拒绝</button></view>
			</view>
			
		    <uni-section title="提示所属公司,车牌号,拜访空间" type="line">
		      <uni-data-select
		        v-model="value"
		        :localdata="range2"
		        @change="change"
		        :clear="false"
		      ></uni-data-select>
		    </uni-section>
		    <uni-section title="提示所属公司,车牌号,拜访空间" type="line">
		      <uni-data-select
		        v-model="value"
		        :localdata="range3"
		        @change="change"
		        label="应用选择"
		      ></uni-data-select>
		    </uni-section>
		  </view> -->
		  <view class="c" @click="shenpi">
			<view>{{list}}</view>
		  </view>
		 
	</view>
</template>

<script>
	import {cxwdsp} from '../../api/request.js'
	export default {
		onShow() {
			cxwdsp().then(resp=>{
				if(resp.data.code==200){
					this.list=resp.data.data
					var result=[]
					list.forEach(x=>{
						result.push({
							"text":x.appointmentId,
							"value":x.id
						})
					})
					this.range1=result
				}
			})
		},
	data() {
      return {
		  list:[]
	
      };
    },
    methods: {
      // change(e) {
      //   console.log("e:", e);
      // },
	  shenpi(){
		  uni.navigateTo({
		  	url:"/pages/fshenpi/fshenpi"
		  })
	  }
    },
  };
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
</style>
