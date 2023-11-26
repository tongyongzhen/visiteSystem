<template>
	<view class="container">
		<view class="a">VIP与行政访客预约填写</view>
		<view class="item">
			<view class="c">车牌号</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入车牌号"/>
			</view>
		</view>
		<view class="item">
			<view class="c">来访单位</view>
			<view class="d">
				<uni-data-select
				  v-model="data.visiteDeptId"
				  :localdata="range1"
				  @change="change"
				  :clear="false"
				></uni-data-select>
			</view>
		</view>
		<view class="c">被访问人</view>
		<view class="d">
			<uni-data-select
			  v-model="data.visiteEmployeeId"
			  :localdata="range2"
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
					carnum:undefined,
					company:undefined,
					id:undefined,
					visiteEmployeeId:undefined
				},
				value: 0,
				range1: [
					{ value: 0, text: "请选择"},
				    { value: 1, text: "1" },
				    { value: 2, text: "2" },
				    { value: 3, text: "3" },
				  ],
				range2: [
					{ value: 0, text: "请选择"},
				    { value: 1, text: "1" },
				    { value: 2, text: "2" },
				    { value: 3, text: "3" },
				  ],
				
			}
		},
		methods: {
			
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
		margin-bottom: 30px;
	}
	.item{
		margin-top: 10px;
	}
	.c{
		font-size: 20px;
		margin-top: 20px;
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
