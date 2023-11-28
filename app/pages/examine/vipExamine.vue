<template>
	<view>
		<view class="item">
			<view class="title">车牌号</view>
			<view class="content">{{examineInfo.carnum}}</view>
		</view>
		<view class="item">
			<view class="title">访问公司</view>
			<view class="content">{{examineInfo.company}}</view>
		</view>
		<view class="item">
			<view class="title">访问的部门</view>
			<view class="content">{{visitDeptInfo.deptName}}</view>
		</view>
		<view class="item">
			<view class="title">访问的人员</view>
			<view class="content">{{employeeInfo.name}}</view>
		</view>
		
		<view class="item">
			<view class="title">预约时间</view>
			<view class="content">{{examineInfo.appointTime}}</view>
		</view>
		
		<view class="bottom" v-if="!isNotExamine()">
			<button type="primary" @click="isagree(0)">同意</button>
			<button type="warn" @click="isagree(1)">拒绝</button>
		</view>
		<view class="bottom" v-else>
			<button type="primary" disabled="true">不需要审批</button>
		</view>
	</view>
</template>

<script>
	import {queryUserById,queryDeptById,vipExamine, ofMe, login} from "../../api/request.js"
	export default {
		onLoad(data) {
			this.examineInfo=JSON.parse(data.data)
			queryUserById(this.examineInfo.visiteEmployeeId).then(resp=>{
				this.employeeInfo=resp.data.data
			})
			queryDeptById(this.examineInfo.visiteDeptId).then(resp=>{
				this.visitDeptInfo=resp.data.data
			})
		},
		onShow() {
			ofMe().then(resp=>{
				this.loginInfo=resp.data.data
			})
		},
		data() {
			return {
				examineInfo:{},
				employeeInfo:{},
				visitDeptInfo:{},
				loginInfo:{}
			}
		},
		methods: {
			isNull(data){
				if(data==null || data==undefined || data==''){
					return true
				}else{
					return false
				}
			},
			isagree(opinion){
				var data={
					id:this.examineInfo.id,
					appointmentId:this.examineInfo.appointmentId,
					visiteDeptOpinion:this.examineInfo.visiteDeptOpinion,
					renshiOpinion:this.examineInfo.renshiOpinion,
					manageOpinion:this.examineInfo.manageOpinion,
					manageId:this.examineInfo.manageId,
					renshiId:this.examineInfo.renshiId,
					deptExamineId:this.examineInfo.deptExamineId,
					visiteEmployeeId:this.examineInfo.visiteEmployeeId,
					visiteDeptId:this.examineInfo.visiteDeptId,
					code:this.examineInfo.code,
					isgo:this.examineInfo.isgo,
				}
				if(this.isNull(this.examineInfo.deptExamineId)){
					//部长
					data.deptExamineId=this.loginInfo.id
					data.visiteDeptOpinion=opinion
					vipExamine(data).then(resp=>{
						if(resp.data.code==200){
							uni.showToast({
								icon:"success",
								title:"审批成功"
							})
						}
					})
				}else if(this.isNull(this.examineInfo.renshiId)){
					data.renshiId=this.loginInfo.id
					data.renshiOpinion=opinion
					vipExamine(data).then(resp=>{
						if(resp.data.code==200){
							uni.showToast({
								icon:"success",
								title:"审批成功"
							})
						}
					})
					
				}else{
				data.manageId=this.loginInfo.id
				data.manageOpinion=opinion
				vipExamine(data).then(resp=>{
					if(resp.data.code==200){
						uni.showToast({
							icon:"success",
							title:"审批成功"
						})
					}
				})
				}
				setTimeout(resp=>{
					this.$router.go(-1)
				},1000)
			},
			/**
			 * 是否不需要审批
			 */
			isNotExamine(){
				//部长
				if(this.loginInfo.deptId!=3 && this.loginInfo.deptId!=1){
					if(this.isNull(this.examineInfo.deptExamineId)){
						return false
					}
					return true
				}else if(this.loginInfo.deptId==3){
					//人事
					if(this.employeeInfo.deptId==3 && (this.isNull(this.examineInfo.deptExamineId) || this.isNull(this.examineInfo.renshiId) )){
						return false
					}else if(this.employeeInfo.deptId!=3 && !this.isNull(this.examineInfo.deptExamineId) && this.isNull(this.examineInfo.renshiId)){
						return false
					}
					return true
					
				}else{
					//经理
					if(this.employeeInfo.deptId==1 && (this.isNull(this.examineInfo.deptExamineId) || this.isNull(this.examineInfo.manageId) )){
						return false
					}else if(this.employeeInfo.deptId!=1 && !this.isNull(this.examineInfo.renshiId) && this.isNull(this.examineInfo.manageId)){
						return false
					}
					return true
					
				}
				
			}
		}
	}
</script>

<style>
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
		margin-top: 20px;
		display: flex;
		justify-content: space-around;
	}

</style>
