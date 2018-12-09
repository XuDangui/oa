<template>
	<div>
		<h1 style="color: #0190FE;">请休假申请表</h1>
		<div style="width: 90%;height: 440px;border: 2px solid #0082E6;margin: 10px auto;">
			<ul class="break-apply-ul-form">
				<li class="row">
					<ul class="row-ul">
						<li class="width-20 h-40" style="border-left: 0px;">姓名</li>
						<li class="width-30 h-40">
							<el-input></el-input>
						</li>
						<li class="width-20 h-40">部门</li>
						<li class="width-30 h-40">
							<el-input></el-input>
						</li>
					</ul>
				</li>
				<li class="row">
					<ul class="row-ul">
						<li class="width-20 h-40" style="border-left: 0px;">事由</li>
						<li class="width-30 h-40">
							<el-input></el-input>
						</li>
						<li class="width-20 h-40">假别</li>
						<li class="width-30 h-40">
							<el-input></el-input>
						</li>
					</ul>
				</li>
				<li class="row">
					<ul class="row-ul">
						<li class="width-20 h-40" style="border-left: 0px;">请假时间</li>
						<li class="width-80 h-40">
							<span style="font-weight: 400;float: left;">&nbsp;&nbsp;自</span>
							<el-date-picker
						      align="right"
						      type="date"
						      placeholder="选择日期"
						      style="float: left;margin-left: 10px;margin-top: 2px;">
						    </el-date-picker>
						    <span style="font-weight: 400;float: left;">&nbsp;&nbsp;休至</span>
						    <el-date-picker
						      align="right"
						      type="date"
						      placeholder="选择日期"
						      style="float: left;margin-left: 10px;margin-top: 2px;">
						    </el-date-picker>
						    <span style="font-weight: 400;float: left;">&nbsp;&nbsp;共    天</span>
						</li>
					</ul>
				</li>
				<li class="row" style="height: 60px;">
					<ul class="row-ul">
						<li class="width-20" style="border-left: 0px;">备注</li>
						<li class="width-80" style="margin-top: 2px;">
							<el-input type="textarea"></el-input>
						</li>
					</ul>
				</li>
				<li class="row">
					<ul class="row-ul">
						<li class="width-25 h-40" style="border-left: 0px;">公司领导审核</li>
						<li class="width-25 h-40">总经理审核</li>
						<li class="width-25 h-40">部门负责人审核</li>
						<li class="width-25 h-40">考勤人员审核</li>
					</ul>
				</li>
				<li class="row" style="height: 200px;">
					<ul class="row-ul" style="height: 200px;">
						<li class="width-25 h-200" style="border-left: 0px;"></li>
						<li class="width-25 h-200"></li>
						<li class="width-25 h-200"></li>
						<li class="width-25 h-200"></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
</script>

<style>
	.break-apply-ul-form{list-style: none;width: 100%;height: 100%;padding: 0px;margin: 0px;}
	.row{width: 100%;height: 45px;}
	.row-ul{width: 100%;height: 100%;list-style: none;padding: 0px;margin: 0px;border-bottom: 2px solid #0082E6;}
	.row-ul li{float: left;border-left: 1px solid #0082E6;height: 100%;padding: 0px;margin: 0px;line-height: 40px;font-family: "微软雅黑";font-size: 18px;font-weight: bold;color: #1D90E6}
	.width-20{width: 20%;}
	.width-30{width: 29.5%;}
	.width-80{width: 79.5%;}
	.width-25{width: 24.5%;}
	.h-40{height: 40px;}
	.h-150{height: 150px;}
	.h-200{height: 200px;}
</style>