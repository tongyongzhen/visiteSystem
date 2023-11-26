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
			<view>张三</view>
		  	<view>12345678</view>
		  	<view>></view>
		  </view>
		  <view class="c">
		  			<view>张三</view>
		  	<view>12345678</view>
		  	<view>></view>
		  </view>
		  <view class="c">
		  			<view>张三</view>
		  	<view>12345678</view>
		  	<view>></view>
		  </view>
		  <view class="c">
		  			<view>张三</view>
		  	<view>12345678</view>
		  	<view>></view>
		  </view>
		  <view class="c">
		  			<view>张三</view>
		  	<view>12345678</view>
		  	<view>></view>
		  </view>
	</view>
</template>

<script>
	export default {
    data() {
      return {
  //       value: 0,
  //       range1: [
		//   { value: 0, text: "请选择"},
  //         { value: 1, text: "篮球" },
  //         { value: 2, text: "足球" },
  //         { value: 3, text: "游泳" },
  //       ],
		// range2: [
		//   { value: 0, text: "请选择"},
		//   { value: 1, text: "篮球" },
		//   { value: 2, text: "足球" },
		//   { value: 3, text: "游泳" },
		// ],
		// range3: [
		//   { value: 0, text: "请选择"},
		//   { value: 1, text: "篮球" },
		//   { value: 2, text: "足球" },
		//   { value: 3, text: "游泳" },
		// ],
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
