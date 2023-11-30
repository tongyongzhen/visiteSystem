<template>
	<view>
		<view class="item" v-if="type=='0'">
			<view class="title">姓名</view>
			<view class="content">{{userInfo.name}}</view>
		</view>
		<view class="item">
			<view class="title">所属公司</view>
			<view class="content"  v-if="type=='0'">{{userInfo.company}}</view>
			<view class="content"  v-else>{{visitData.company}}</view>
		</view>
		<view class="item" v-if="type=='0'">
			<view class="title">手机号</view>
			<view class="content">{{userInfo.phone}}</view>
		</view>
		<view class="item">
			<view class="title">访问的部门</view>
			<view class="content">{{visitDeptInfo.deptName}}</view>
		</view>
		<view class="item">
			<view class="title">访问的人</view>
			<view class="content">{{employeeInfo.name}}</view>
		</view>
		<view class="item" v-if="type=='0'">
			<view class="title">访问开始时间</view>
			<view class="content">{{visitData.visiteStartTime}}</view>
		</view>
		<view class="item"  v-if="type=='0'">
			<view class="title">访问结束时间</view>
			<view class="content">{{visitData.visiteEndTime}}</view>
		</view>
		<view class="item">
			<view class="title">预约时间</view>
			<view class="content">{{visitData.appointTime}}</view>
		</view>
		<view class="bottom">
			<button type="primary" @click="end">访问结束</button>
		</view>
	</view>
</template>

<script>
	import {queryUserById,queryDeptById,vipVisiteEnd,commonVisiteEnd} from "../../api/request.js"
	export default {
		onLoad(option) {
			var data=JSON.parse(option.data)
			this.visitData=data.data
			this.type=data.type
			this.init()
		},
		data() {
			return {
				visitData:{},
				type:'',
				userInfo:{},
				employeeInfo:{},
				visitDeptInfo:{}
			}
		},
		methods: {
			init(){
				queryUserById(this.visitData.visiteEmployeeId).then(resp=>{
					this.employeeInfo=resp.data.data
				})
				queryDeptById(this.visitData.visiteDeptId).then(resp=>{
					this.visitDeptInfo=resp.data.data
				})
				if(this.type=="0"){
					queryUserById(this.visitData.userId).then(resp=>{
						this.userInfo=resp.data.data
					})
					
				}
			},
			end(){
				if(this.type=="0"){
					//普通访客
					commonVisiteEnd(this.visitData.id).then(resp=>{
						uni.showToast({
							title:"访问已结束"
						})
					})
				}else{
					//vip
					vipVisiteEnd(this.visitData.id).then(resp=>{
						uni.showToast({
							title:"访问已结束"
						})
					})
					
				}
				let that=this
				setTimeout(resp=>{
					uni.navigateBack()
				},1000)
				
				
				
			}
			
			
		}
	}
</script>

<style lang="scss" scoped>
	
	.item{
		display: flex;
		justify-content: space-between;
		margin-top: 10px;
		font-size: 18px;
		.title{
			margin-left: 5px;
		}
		.content{
			margin-right: 5px;
		}
		
	}
	
	.bottom{
		display: flex;
		justify-content: center;
		margin-top: 20px;
	}

</style>
