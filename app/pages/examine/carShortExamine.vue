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
			<view class="title">车牌号</view>
			<view class="content">{{userInfo.carnum}}</view>
		</view>
		<view class="item">
			<view class="title">进入时间</view>
			<view class="content">{{examineInfo.enterTime}}</view>
		</view>
		<view class="item">
			<view class="title">货物照片</view>
		</view>
		<uni-file-picker  v-model="picture" @select="select"  file-mediatype="image" limit="1" v-if="examineInfo.picture==null"></uni-file-picker>
		<view class="image" v-else>
			<image style="height: 100%;width: 100%;" :src="picture"></image>
		</view>
		<view class="bottom"  v-if="examineInfo.examineResult==null && loginUser.deptId==6">
			<button type="primary" @click="isagree(0)">放行</button>
		</view>
		<view class="bottom"  v-if="examineInfo.picture!=null && examineInfo.baoanResult==null && loginUser.deptId==5">
			<button type="primary" @click="isagree(0)">放行</button>
		</view>
		
	</view>
</template>

<script>
	import {queryUserById,commonExamine,carShortPictureUp,carShortPictureExamine,queryShortPictureById,carShortBaoAnExamine,ofMe} from "../../api/request.js"
	export default {
		onLoad(data) {
			this.examineInfo=JSON.parse(data.data)
			queryUserById(this.examineInfo.userId).then(resp=>{
				this.userInfo=resp.data.data
			})
			this.queryShortPictureById(this.examineInfo.id)
			ofMe().then(resp=>{
				this.loginUser=resp.data.data
			})
		},
		data() {
			return {
				examineInfo:{},
				userInfo:{},
				picture:null,
				loginUser:{}
			}
		},
		methods: {
			queryShortPictureById(id){
				queryShortPictureById(id).then(resp=>{
					this.picture=resp.data.data
				})
			},
			upload(img){
				const tempFilePaths = img.tempFiles[0].file;//e是获取的图片源
				this.convertImageToBase64(tempFilePaths,resp=>{
					//resp为base64编码
					carShortPictureUp({
						id:this.examineInfo.id,
						image:resp
					})
				})

				
			},
			convertImageToBase64(file, callback) {
			  var reader = new FileReader();
			  reader.onload = function() {
			    var base64 = reader.result.split(',')[1];
			    callback(base64);
			  };
			  reader.readAsDataURL(file);
			},
			
			isagree(opinion){
				if(this.loginUser.deptId==6){
					if(this.picture==null || this.picture==''){
						uni.showToast({
							icon:"none",
							title:"请先上传图片"
						})
						return
					}
					this.upload(this.picture)
					this.examineInfo.examineResult=opinion
					carShortPictureExamine(this.examineInfo).then(resp=>{
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
				}else{
					//baoan
					this.examineInfo.baoanResult=opinion
					carShortBaoAnExamine(this.examineInfo).then(resp=>{
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
			},
			select(img){
				this.picture=img
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
	
	.image{
		width: 100px;
		height: 100px;
		margin-top: 10px;
		margin-left: 5px;
	}

</style>
