<template>
	<view>
		<view class="a"><h1>恭喜你预约成功</h1></view>
		<view class="item">
			<view class="left">请在</view>
			<view class="right">
				<view class="example-body">
							<uni-datetime-picker type="date" :clear-icon="false" v-model="single" @maskClick="maskClick" />
						</view>
			</view>
		</view>
		<view class="item">
			<view class="left">到</view>
			<view class="right">
				<view class="example-body">
							<uni-datetime-picker type="date" :clear-icon="false" v-model="single" @maskClick="maskClick" />
						</view>
			</view>
		</view>
		<view class="item">时间内到场</view>
		<view class="b">入场二维码</view>
		<view class="c">
			<image class="image2" src="../../static/ewm.png">
		</view>
	</view>
</template>

<script>
	export default {
		mounted() {
		},
		data() {
			return {
				isSame:true,
				passwordRepeat:undefined,
				data:{
					username:undefined,
					password:undefined,
					phone:undefined,
					name:undefined
					
				}
				
			}
		},
		methods: {
			register(){
				register(this.data).then(resp=>{
					if(resp.data.code==200){
						uni.showToast({
							icon:"success",
							title:"注册成功"
						})
						setTimeout(x=>{
							uni.navigateTo({
								url:"/pages/login/login"
							})
						},1500)
					}else{
						uni.showToast({
							icon:"error",
							title:`${resp.data.msg}`
						})
					}
				})
			},
			check(){
				if(this.data.password==this.passwordRepeat){
					this.isSame=true
				}else{
					this.isSame=false
				}
			},
			maskClick(e){
				console.log('maskClick事件:', e);
			}
		}
	}
</script>

<style>
	.a{
		text-align: center;
		margin-top: 30px;
		margin-bottom: 40px;
	}
	.b{
		text-align: center;
		margin-top: 30px;
		font-size: 20px;
		color: red;
	}
	.c{
		text-align: center;
	}
	.image2{
		width: 200px;
		height: 200px;
		margin-top: 10px;
	}
	.example-body {
			background-color: white;
			padding: 5px;
			width: 200px;
		}
</style>
<style lang="scss" scoped>
	.item{
		font-size: 20px;
		margin: 20px 30px;
		margin-top: 10px;
		display: flex;
		
		.left{
			width: 80px;
		}
		.right{
			margin-left: 10px;
			display: flex;
			flex: 1;
			}
		}	
</style>
