<template>
	<view>
		<view class="item" v-if="loginUser.type==0 || loginUser.type==4">
			<view class="title">访问的部门</view>
			<view class="content">{{deptName}}</view>
		</view>
		<view class="item" v-if="loginUser.type==0 || loginUser.type==4">
			<view class="title">访问的人员</view>
			<view class="content">{{name}}</view>
		</view>
		<view class="item" v-if="loginUser.type==0">
			<view class="title">访问开始时间</view>
			<view class="content">{{appointmentData.visiteStartTime}}</view>
		</view>
		<view class="item" v-if="loginUser.type==0">
			<view class="title">访问结束时间</view>
			<view class="content">{{appointmentData.visiteEndTime}}</view>
		</view>
		<view class="item" v-if="loginUser.isEmployee==0">
			<view class="title">车牌号</view>
			<view class="content">{{appointmentData.carnum}}</view>
		</view>
		<view class="item" v-if="loginUser.isEmployee==0">
			<view class="title">来访单位</view>
			<view class="content">{{appointmentData.company}}</view>
		</view>
		<view class="item">
			<view class="title">预约时间</view>
			<view class="content">{{appointmentData.appointTime}}</view>
		</view>
		
		<view class="result">
			<view class="wait" v-if="isWait()">审核中</view>
			<view class="fail" v-if="isFail()">预约失败</view>
			<view class="success" v-if="appointmentData.code!=null">预约成功</view>
			<view class="success" v-if="appointmentData.code!=null" @click="Qrcode">查看二维码</view>
		</view>
		
		<view class="code" v-if="isShow">
			<image :src="code" style="height: 100%;width: 100%;" ></image>
		</view>
	</view>
</template>

<script>
	import {ofMe,queryDeptById,queryUserById,queryCodeById} from "../../api/request.js"
	export default {
		onLoad(options) {
			this.appointmentData=JSON.parse(options.details)
			ofMe().then(resp=>{
				this.loginUser=resp.data.data
				if(resp.data.data.type==0||resp.data.data.type==4){
					this.queryDeptById(this.appointmentData.visiteDeptId)
					this.queryUserById(this.appointmentData.visiteEmployeeId)
				}
			})
			
		},
		data() {
			return {
				appointmentData:{},
				loginUser:{},
				deptName:'',
				userName:"",
				code:'',
				isShow:false
			}
		},
		methods: {
			queryDeptById(id) {
				queryDeptById(id).then(resp=>{
					this.deptName=resp.data.data.deptName
				})
			},
			queryUserById(id) {
				queryUserById(id).then(resp=>{
					this.userName=resp.data.data.name
				})
			},
			/**
			 * 审核是否失败
			 */
			isFail(){
				//不是内部人员
				if(this.loginUser.isEmployee==1 && this.appointmentData.isagree==1 && this.loginUser.type!=2 && this.loginUser.type!=3){
					return true
				}
				if(this.appointmentData.visiteDeptOpinion==1 || this.appointmentData.renshiOpinion==1||this.appointmentData.manageOpinion==1){
					return true
				}else{
					return false
				}
			},
			/**
			 * 是否在审核中
			 */
			isWait(){
				//不是内部人员
				if(this.loginUser.isEmployee==1 && this.appointmentData.isagree==-1 && this.loginUser.type!=2 && this.loginUser.type!=3){
					return true
				}
				//为内部人员
				if(this.loginUser.isEmployee==0){
					if(this.appointmentData.visiteDeptOpinion==null || this.appointmentData.renshiOpinion==null ||this.appointmentData.manageOpinion==null){
						return true
					}else{
						return false
					}
				}
				
				
			},
			Qrcode(){
				queryCodeById(this.appointmentData.id).then(resp=>{
					this.code=resp.data.data
				})
				this.isShow=true
			}
		}
	}
</script>

<style scoped lang="scss">
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
	
	.result{
		display: flex;
		justify-content: space-around;
		align-items: center;
		font-size: 18px;
		margin-top: 50px;
		.wait{
			color: blue;
		}
		.fail{
			color: red;
		}
		.success{
			color: green;
		}
	}
	
	.code{
		margin: 20px auto;
		width: 200px;
		height: 200px;
	}
	
</style>
