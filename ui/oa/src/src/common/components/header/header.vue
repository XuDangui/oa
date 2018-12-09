<template>
	<div style="height: 100px;">
		<ul class="header-box-ul">
			<li>
				<img style="margin-top: 10px;" src="http://www.gdut.edu.cn/images/logo-2.png" />
			</li>
			<li class="header-title">
				OA管理系统
			</li>
			<li style="float: right;">
				<ul class="header-user-ul">
					<li>
						<img src="../../../../static/images/2portal.png" style="border-radius: 50%;height: 40px;margin-top: 30px;"/>
					</li>
					<li>
						<span style="line-height: 50px;margin-left: 10px;color: #FFFFFF;">{{user.userName}}</span>
						<span style="line-height: 50px;margin-left: 10px;color: #FFFFFF;font-size: 18px;">退出</span>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</template>

<script>
	import config from '../config';
	export default{
		name: config.prefix + 'Header',
		data(){
			return{
				user:{
					userName:'许伟珊'
				}
			}
		}
	}
</script>

<style>
	.header-box-ul{list-style: none;float: left;width: 100%;height: 100px;background: #0082E6;margin-top: 0px !important;padding-top: 0px !important;}
	.header-box-ul li{float: left;line-height: 100px;height: 100%;}
	.header-title{width: 200px;border-left: 1px solid #FFFFFF;margin-left: 10px;font-weight: bold;color: #FFFFFF;font-size: 18px;}
	.header-user-ul{width: 200px;height: 100px;list-style: none;}
	.header-user-ul li{float: left;line-height: 100px;height: 100%;}
</style>