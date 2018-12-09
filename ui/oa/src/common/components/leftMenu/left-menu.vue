<template>
	<div>
		<!--<ul class="left-menu-ul">-->
			<!--<li>
				<div style="width: 180px;height: 80px;">
					<img src="../../../../static/images/2portal.png" style="width: 30px;height: 30px;border-radius: 50%;float: left;margin-left: 10px;margin-top: 25px;" />
					<span style="width:50px;height:100%;color: #FFFFFF;line-height: 80px;">许伟珊</span>
				</div>
			</li>-->
			<!--<li>-->
				<!--<el-menu
			      default-active="2"
			      class="el-menu-vertical-demo"
			      @open="handleOpen"
			      @close="handleClose"
			      background-color="#545c64"
			      text-color="#fff"
			      active-text-color="#ffd04b">
			      <el-menu-item index="1">
			        <i class="el-icon-location"></i>
			        <span slot="title">首页</span>
			      </el-menu-item>
			      <el-submenu index="2" style="margin-left: 45px;">
			        <template slot="title">
			        	<i class="el-icon-menu"></i>
			        	<span slot="title">领导日程</span>
			        </template>
			        <el-menu-item index="1-1">选项1</el-menu-item>
			          <el-menu-item index="1-2">选项2</el-menu-item>
			      </el-submenu>
			      <el-menu-item index="3" disabled>
			        <i class="el-icon-document"></i>
			        <span slot="title">公文办公</span>
			      </el-menu-item>
			      <el-menu-item index="4">
			        <i class="el-icon-setting"></i>
			        <span slot="title">考勤管理</span>
			      </el-menu-item>
			      <el-menu-item index="5">
			        <i class="el-icon-setting"></i>
			        <span slot="title">组织管理</span>
			      </el-menu-item>
			    </el-menu>-->
			    
			    <el-submenu style="margin-left: 45px;" v-if='item.childs && item.childs.length' :index="item.id">
				    <template slot="title">
				      <i class="el-icon-menu"></i>{{item.name}}
				    </template>
				    <pl-left-menu v-for="(subitem,index) in item.childs" :item="subitem" key="index">
				    </pl-left-menu>
				  </el-submenu>
				  <el-menu-item v-else :index="item.id" @click.native="router(item)">
				    <i class="el-icon-menu"></i>{{item.name}}
				  </el-menu-item>
				  
			<!--</li>
		</ul>-->
	</div>
</template>

<script>
	import config from '../config';
	export default{
		name: config.prefix + 'LeftMenu',
		data(){
			return {
				
			}
		},
		props: {
	      item: {
	        default: {},
	        type: Object
	      }
	    },
		mounted(){
		},
		created(){
			console.log('created')
		},
		methods:{
			handleOpen(){
				
			},
			handleClose(){
				
			},
			router(item){
				this.$router.push({name: item.code, params: {}});
			}
		}
	}
</script>

<style>
	.left-menu-div{width: 180px;height: 100%;float: left;background-color: #545c64;}
	.leftMenu{width: 180px;min-height: 250px;margin-top: 0px;}
	.left-menu-ul{width: 180px;height: 100%;list-style: none;margin: 0px;padding: 0px;}
	.left-menu-ul li{border-right: 0px;}
	.el-menu-item{padding: 0px !important;min-width: 180px !important;}
	.el-submenu__title{padding: 0px !important;}
</style>