// 应用全局配置
module.exports = {
	devServer: {
	    proxy: {
	      '/web': {
	        target: 'http://localhost:90',
	        changeOrigin: true,
	        pathRewrite: {
	          '^/web': ''
	        }
	      }
	    }
	  },
	// 宽带
  // baseUrl: 'http://ylgcxyzhglxt.szai.edu.cn:8000/prod-api',
  // PICTURE_PATH:"http://ylgcxyzhglxt.szai.edu.cn:8000/prod-api/profile/upload/",
  // 服务器
  // baseUrl: 'http://81.68.251.228:8080',
  // 应用信息

}