<template>
	<view>
		<view class="scan size">
		        <u-navbar back-text="二维码扫描"></u-navbar>
		        <view class="sectionview"><view id="qr-reader" style="width:100%;height:100%;"></view></view>
		        <view class="footer"><u-button @click="getCameras" color="rgba(249, 185, 73, 1)">扫码</u-button></view>  
		        <u-toast ref="uToast" />
		</view>
		<view>
			<button type="primary" class="button" @click="tc">退出</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				codeUrl:'',
				cameraId:'',
			}
		},
		mounted() {
		        this.current = this.$route.query.current || 0;
		        this.init();
		    },
		    beforeDestroy() {
		        this.stop();
		    },
		methods: {
			tc(){
				uni.switchTab({
					url:"/pages/zhuye/zhuye"
				})
			},	
			getCode(id) {
			    if (!id) return;
			        //跳转页面
			        this.$u.route('/pages/selfInquiry/index', {
			            paraValue: id
			        });
			    },        
			init() {
			    this.AddJs('https://blog.minhazav.dev/assets/research/html5qrcode/html5-qrcode.min.js');
			    //需要加载时间建议延时一点再获取设备列表
			    setTimeout(() => {
			        this.getCameras();
			    }, 1000);
			},        
			stop() {
			    this.html5QrCode
			        .stop()
			        .then(ignore => {
			            // QR Code scanning is stopped.
			            console.log('QR Code scanning stopped.');
			        })
			        .catch(err => {
			            // Stop failed, handle it.
			            console.log('Unable to stop scanning.');
			        });
			},        
			start() {
			    this.html5QrCode = new Html5Qrcode('qr-reader');
			    this.html5QrCode
			        .start(
			            this.cameraId, // retreived in the previous step.
			            {
			                fps: 10, // sets the framerate to 10 frame per second
			                qrbox: 250 // sets only 250 X 250 region of viewfinder to
			                // scannable, rest shaded.
			            },
			            qrCodeMessage => {
			                // do something when code is read. For example:
			                if (qrCodeMessage) {
			                    this.$refs.uToast.show({
			                        title: `扫码成功`,
			                        type: 'success'
			                    });
			                    this.getCode(qrCodeMessage);
			                    this.stop();
			                }
			            },
			            errorMessage => {
			                // parse error, ideally ignore it. For example:
			                // console.log(`QR Code no longer in front of camera.`);
			            }
			        )
			        .catch(err => {
			            // Start failed, handle it. For example,
			            console.log(`Unable to start scanning, error: ${err}`);
			            this.$refs.uToast.show({
			                title: `扫码失败：${err}`,
			                type: 'error'
			            });
			        });
			},        
			getCameras() {
			    Html5Qrcode.getCameras()
			        .then(devices => {
			            /**
			             * devices would be an array of objects of type:
			             * { id: "id", label: "label" }
			             */
			            if (devices && devices.length) {
			                if (devices.length > 1) {
			                    this.cameraId = devices[1].id;
			                } else {
			                    this.cameraId = devices[0].id;
			                }
			                console.log(this.cameraId, 'cameraId');
			                this.start();
			            }
			        })
			        .catch(err => {
			            this.$refs.uToast.show({
			                title: '启用相机失败',
			                type: 'error'
			            });
			        });
			},
			//动态创建script的方法
			AddJs(url) {
			    //console.log( 'url：',url);
			    return new Promise((resolve, reject) => {
			        const script = document.createElement('script');
			        script.src = url;
			        script.type = 'text/javascript';
			        document.body.appendChild(script);
			        script.onload = () => {
			            resolve();
			        };
			    });
			},        
		}
	}
</script>

<style>
	.scan {
	    width: 100%;
	    display: flex;
	    flex-direction: column;
	    height: 100vh;
	    overflow: hidden;
		}
	.footer {
	    position: fixed;
	    bottom: 50rpx;
	    width: 100%;
	    display: flex;
	    justify-content: center;
	}    
	.button{
		
	}
</style>
