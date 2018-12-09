<template>
	<div style="height: 100%;">
		<pl-portal></pl-portal>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				item:{
					childs:[
						{name:'首页',code:'portal',id:'1'},
						{name:'领导日程',code:'portal',id:'2'},
						{name:'公文办公',code:'portal',id:'3'},
						{
							name:'考勤管理',code:'portal',id:'4',
							childs:[
								{name:'请休假管理',code:'breakApply',id:'1'},
								{name:'轮休变更',code:'rotateBreakApply',id:'2'},
								{name:'出差审批',code:'businessTrip',id:'3'},
								{name:'加班申请',code:'workOvertime',id:'4'},
								{name:'考勤管理',code:'attendanceCheck',id:'5'},
								{name:'轮休计划表',code:'portal',id:'6'}
							]
						},
						{name:'组织管理',code:'portal',id:'5'}
					]
				}
			}
		}
	}
</script>

<style>
	.home-ul{list-style: none;width: 100%;height: 100%;margin: 0px;padding: 0px;}
	.home-ul li{float: left;}
</style>