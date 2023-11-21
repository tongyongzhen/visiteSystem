<template>
	<view class="container">
		<view class="a">预约登记</view>
		<view class="item">
			<view class="c">姓名</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入"/>
			</view>
		</view>
		<view class="item">
			<view class="c">电话号码</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入"/>
			</view>
		</view>
		<view class="item">
			<view class="c">所属公司</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入"/>
			</view>
		</view>
		<view class="item">
			<view class="c">车牌号</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入"/>
			</view>
		</view>
		<view class="c">当日进出次数</view>
		<view>
			<uni-data-select
			  v-model="value"
			  :localdata="range"
			  @change="change"
			  :clear="false"
			></uni-data-select>
		</view>
		<view>
			<button type="primary" class="button" @click="">申报</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				isSame:true,
				passwordRepeat:undefined,
				data:{
					username:undefined,
					password:undefined,
					phone:undefined,
					name:undefined
				},
				value: 0,
				range: [
					{ value: 0, text: "请选择"},
				    { value: 1, text: "1" },
				    { value: 2, text: "2" },
				    { value: 3, text: "3" },
				  ],
			}
		},
		methods: {
			change(e) {
			  console.log("e:", e);
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
		font-size: 25px;
		text-align: center;
		margin-top: 10px;
		margin-bottom: 10px;
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
		margin-top: 70px;
		width: 100px;
		height: 50px;
		background-color: lightslategray;
	}
</style>
