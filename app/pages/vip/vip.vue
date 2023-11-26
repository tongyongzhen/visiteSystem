<template>
	<view class="container">
		<view class="a">VIP与行政访客预约填写</view>
		<view class="item">
			<view class="c">车牌号</view>
			<view class="d">
				<input type="text" v-model="data.carnum" placeholder="请输入车牌号"/>
			</view>
		</view>
		
		<view class="item">
			<view class="c">来访单位</view>
			<view class="d">
				<input type="text" v-model="data.company" placeholder="请输入来访单位"/>
			</view>
		</view>
		<view class="item">
			<view class="c">访问部门</view>
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
			<button type="primary" class="button" @click="yuyue">申报</button>
		</view>
	</view>
</template>

<script>
import { vipyy,cxbm,cxry } from '../../api/request'
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
					carnum:undefined,
					company:undefined,
					id:undefined,
					visiteDeptId:undefined,
					visiteEmployeeId:undefined
				},
				value: 0,
				range1: [
				  ],
				range2: [
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
				vipyy(this.data).then(resp=>{
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
