<template>
	<view>
		<view class="a"><h1>很抱歉，预约失败</h1></view>
		<view class="b">
			<view class="c">点击下方按钮返回预约界面</view>
			<button type="primary" @click="fanhui">返回</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	.a{
		color: red;
		margin-top: 100px;
		text-align: center;
	}
	.b{
		margin-top: 150px;
		text-align: center;
		display: flex;
		flex-direction: column;
	}
	.c{
		font-size: 20px;
		margin-bottom: 20px;
	}
</style>
