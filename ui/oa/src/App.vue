<template>
  <div id="app" style="height: 100%;">
		<ul class="home-ul">
			<li style="width: 18%;height: 100%;" v-if="$store.getters.isLogin">
				<div style="width: 100%;min-height: 640px;float: left;background-color: #545c64;">
					<div style="width: 203px;height: 80p$store.getters.isLoginx;background-color: #545c64;">
						<img src="../static/images/2portal.png" style="width: 30px;height: 30px;border-radius: 50%;float: left;margin-left: 10px;margin-top: 25px;" />
						<span style="width:50px;height:100%;color: #FFFFFF;line-height: 80px;">许伟珊</span>
					</div>
					<el-menu
			      @open="handleOpen"
			      @close="handleClose"
			      background-color="#545c64"
			      :default-active="openIndex" :unique-opened="isUniqueOpened"
			      text-color="#fff">
					<pl-left-menu v-for="(subitem,index) in item.childs" :item="subitem" :key="index" ></pl-left-menu>
					</el-menu>
					<el-button type="primary" @click="exit" style="margin-bottom: 10px;margin-top: 100px;">退出</el-button>
				</div>
			</li>
			<li style="height: 100%;" :style="{width:!$store.getters.isLogin?'100%':'82%'}">
				<div>
					<router-view></router-view>
				</div>
			</li>
		</ul>
	</div>
</template>

<script>
import { MsgType } from './common/js/constants.js';
export default {
  name: 'App',
  data(){
  	return{
  		isUniqueOpened: true,
      openIndex: '',
  		item:{
					childs:[
						{name:'首页',code:'portal',id:'1'},
						{name:'领导日程',code:'portal',id:'2'},
						{name:'公文办公',code:'portal',id:'3'},
						{
							name:'考勤管理',code:'portal',id:'4',
							childs:[
								{name:'请休假管理',code:'breakApply',id:'41'},
								{name:'轮休变更',code:'rotateBreak',id:'42'},
								{name:'出差审批',code:'businessTrip',id:'43'},
								{name:'加班申请',code:'workOvertime',id:'44'},
								{name:'考勤管理',code:'attendanceCheck',id:'45'},
								{name:'轮休计划表',code:'portal',id:'6'}
							]
						},
						{name:'组织管理',code:'orgManage',id:'5'},
						{name:'人员管理',code:'employee',id:'6'}
					]
				}
  	}
  },
  methods:{
  	handleOpen(key, keyPath){
				console.log(key);
				console.log(keyPath);
		},
		handleClose(key, keyPath){
				console.log(key);
				console.log(keyPath);
		},
		exit(){
			this.$confirm('确定退出登录吗', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: MsgType.WARING
      }).then(() => {
      	this.$store.getters.isLogin = false;
	      this.$store.getters.user = null;
	      this.$router.push({name: 'Login', params: ""});
      });
		}
  },
  mounted () {
      let vm = this;
      this.$router.beforeEach((to, from, next) => {
        // vm.$refs.topProgress.start();
        console.log('from',from);
        console.log('to',to);
        if(to.name == 'Login'){
        	this.$store.getters.isLogin = false;
        	this.$store.getters.user = null;
        }
        next();
      });
      this.$router.afterEach(() => {
      });
    }
}
</script>

<style>
#app {
  font-family: "微软雅黑" !important;
  text-align: center;
  height: 600px;
}
body{width: 100%;height: 100%;margin: 0px;}
.home-ul{list-style: none;width: 100%;height: 100%;margin: 0px;padding: 0px;}
.home-ul li{float: left;}
.isLogin{width: 100%;}
</style>
