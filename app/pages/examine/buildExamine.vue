<template>
	<view>
		<view class="item">
			<view class="title">姓名</view>
			<view class="content">{{userInfo.name}}</view>
		</view>
		<view class="item">
			<view class="title">所属公司</view>
			<view class="content">{{userInfo.company}}</view>
		</view>
		<view class="item">
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
		<view class="item">
			<view class="title">预约时间</view>
			<view class="content">{{examineInfo.appointTime}}</view>
		</view>
		
		<view class="bottom"  v-if="examineInfo.isagree==-1">
			<button type="primary" @click="isagree(0)">同意</button>
			<button type="warn" @click="isagree(1)">拒绝</button>
		</view>
		<view class="bottom">
			<button type="primary" v-if="examineInfo.isagree==0">已同意</button>
			<button type="warn" v-if="examineInfo.isagree==1">已拒绝</button>
		</view>
	</view>
</template>

<script>
	import {queryDeptById,queryUserById,buildExamine} from "../../api/request.js"
	export default {
		onLoad(data) {
			this.examineInfo=JSON.parse(data.data)
			queryUserById(this.examineInfo.userId).then(resp=>{
				this.userInfo=resp.data.data
			})
			queryUserById(this.examineInfo.visiteEmployeeId).then(resp=>{
				this.employeeInfo=resp.data.data
			})
			queryDeptById(this.examineInfo.visiteDeptId).then(resp=>{
				this.visitDeptInfo=resp.data.data
			})
		},
		data() {
			return {
				examineInfo:{},
				userInfo:{},
				employeeInfo:{},
				visitDeptInfo:{}
			}
		},
		methods: {
			isagree(opinion){
				this.examineInfo.isagree=opinion
				buildExamine(this.examineInfo).then(resp=>{
					if(resp.data.code==200){
						uni.showToast({
							icon:"success",
							title:"审批成功"
						})
						setTimeout(resp=>{
							this.$router.go(-1)
						},1000)
						
					}
				})
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
		margin-top: 20px;
		display: flex;
		justify-content: space-around;
	}

</style>
