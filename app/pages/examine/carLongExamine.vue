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
		<uni-file-picker @select="upload" file-mediatype="image" limit="3"></uni-file-picker>
		
	</view>
</template>

<script>
	import {queryUserById,commonExamine,carLongPictureUp,uploadFile} from "../../api/request.js"
	export default {
		onLoad(data) {
			this.examineInfo=JSON.parse(data.data)
			queryUserById(this.examineInfo.userId).then(resp=>{
				this.userInfo=resp.data.data
			})
		},
		data() {
			return {
				examineInfo:{},
				userInfo:{}
			}
		},
		methods: {
			upload(img){
				const tempFilePaths = img.tempFilePaths;//e是获取的图片源
				uploadFile(tempFilePaths)
				// carLongPictureUp(file).then(resp=>{
					
				// })
				
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

</style>
