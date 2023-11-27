<template>
	<view class="container">
		<view class="a">预约登记</view>
		<!-- <view class="item">
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
		</view> -->
		<!-- <view class="item">
			<view class="c">所属公司</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入"/>
			</view>
		</view> -->
		<view class="item">
			<view class="c">拜访部门</view>
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
		<!-- <view class="item">
			<view class="c">车牌号（可选填）</view>
			<view class="d">
				<input type="text" v-model="data.name" placeholder="请输入"/>
			</view>
		</view> -->
		<view class="c">拜访时间段</view>
		<view class="item">
			<view class="right">
				<view class="example-body">
					<uni-datetime-picker v-model="data.visiteStartTime" />
							
						</view>
			</view>
		</view>
		<view class="item">
			<view class="right">
				<view class="example-body">
					<uni-datetime-picker v-model="data.visiteEndTime" />
							
						</view>
			</view>
		</view>
		<view>
			<button type="primary" class="button" @click="yuyue">提交</button>
		</view>
		
	</view>
</template>

<script>
	import {ptfkyy,cxbm,cxry} from '../../api/request.js'
	export default {
		onShow() {
			cxbm().then(resp=>{
				var list=resp.data.data
				var result=[]
				list.forEach(x=>{
					result.push({
						"text":x.deptName,
						"value":x.deptId
					})
				})
				this.range1=result
			})
		},
		data() {
			return {
				isSame:true,
				passwordRepeat:undefined,
				data:{
					code:undefined,
					isagree:undefined,
					isgo:undefined,
					isvisite:undefined,
					userId:undefined,
					visiteDeptId:undefined,
					visiteEmployeeId:undefined,
					visiteEndTime:undefined,
					visiteStartTime:undefined
				},
				value: 0,
				range1: [
				  ],
				range2:[
				],
			}
		},
		methods: {
			change(e) {
			  cxry(e).then(resp=>{
				  var list=resp.data.data
				  var result=[]
				  list.forEach(x=>{
				  	result.push({
				  		"text":x.name,
				  		"value":x.id
				  	})
				  })
				  this.range2=result
			  })
			},
			yuyue(){
				ptfkyy(this.data).then(resp=>{
					if(resp.data.code==200){
						
						uni.showToast({
							icon:"success",
							title:"预约成功"
						})
						
						setTimeout(x=>{
							uni.navigateTo({
								url:"/pages/yycg/yycg"
							})
						},1500)
					}
				},
				)
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
		margin-top: 50px;
		width: 100px;
		height: 50px;
		background-color: lightslategray;
	}
	.right{
		margin-top: 10px;
	}
</style>