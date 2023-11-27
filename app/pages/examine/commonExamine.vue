<template>
	<view>
		<view class="item">
			<view class="title">姓名</view>
			<view class="content">{{}}</view>
		</view>
		<view class="item">
			<view class="title">所属公司</view>
			<view class="content">{{}}</view>
		</view>
		<view class="item">
			<view class="title">手机号</view>
			<view class="content">{{}}</view>
		</view>
		<view class="item">
			<view class="title">访问的部门</view>
			<view class="content">{{}}</view>
		</view>
		<view class="item">
			<view class="title">访问的人</view>
			<view class="content">{{}}</view>
		</view>
		<view class="item">
			<view class="title">访问开始时间</view>
			<view class="content">{{}}</view>
		</view>
		<view class="item">
			<view class="title">访问结束时间</view>
			<view class="content">{{}}</view>
		</view>
		<view class="item">
			<view class="title">预约时间</view>
			<view class="content">{{}}</view>
		</view>
		
		<view>
			
		</view>
		
	</view>
</template>

<script>
	import {queryDeptById,queryUserById} from "../../api/request.js"
	export default {
		onLoad(data) {
			this.examineInfo=JSON.parse(data.data)
		},
		data() {
			return {
				examineInfo:{},
				
			}
		},
		methods: {
			
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
