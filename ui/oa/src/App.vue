<template>
  <div id="app" style="height: 100%;">
		<ul class="home-ul">
			<li style="width: 18%;height: 100%;">
				<div style="width: 100%;height: 700px;float: left;background-color: #545c64;">
					<div style="width: 203px;height: 80px;background-color: #545c64;">
						<img src="../static/images/2portal.png" style="width: 30px;height: 30px;border-radius: 50%;float: left;margin-left: 10px;margin-top: 25px;" />
						<span style="width:50px;height:100%;color: #FFFFFF;line-height: 80px;">许伟珊</span>
					</div>
					<el-menu
			      @open="handleOpen"
			      @close="handleClose"
			      background-color="#545c64"
			      :default-active="openIndex" :unique-opened="isUniqueOpened"
			      text-color="#fff">
					<pl-left-menu v-for="(subitem,index) in item.childs" :item="subitem" key="index"></pl-left-menu>
					</el-menu>
				</div>
			</li>
			<li style="width: 82%;height: 100%;">
				<div>
					<router-view></router-view>
				</div>
			</li>
		</ul>
	</div>
</template>

<script>
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
						{name:'组织管理',code:'portal',id:'5'}
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
  },
  mounted () {
      let vm = this;
      this.$router.beforeEach((to, from, next) => {
        // vm.$refs.topProgress.start();
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
</style>
