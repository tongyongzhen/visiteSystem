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
		<view>
			<uni-file-picker @select="upload" file-mediatype="image" limit="3" title="最多选择3张图片"></uni-file-picker>
		</view>
		
	</view>
</template>

<script>
	import {queryUserById,commonExamine} from "../../api/request.js"
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
				console.log(img)
			}
		}
	}
</script>

<style>

</style>
