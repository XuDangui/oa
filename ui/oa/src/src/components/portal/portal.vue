<template>
	<div style="width: 100%;height: 100%;">
		<ul class="portal-ul-1">
			<li style="width: 50%;">
				<div style="width: 100%;height: 80px;">
					<div style="width: 98%;height: 80px;border: 1px solid #2E90FE;border-radius: 6px;">
						<img src="../../../static/images/1portal.png" style="width: 50px;height: 50px;margin-top: 15px;float: left;margin-left: 10px;" />
						<span style="height: 80px;line-height: 80px;width: 100px;font-size: 20px;font-family: '微软雅黑';font-weight: bold;color: #0082E6;">员工考勤表</span>
					</div>
				</div>
			</li>
			<li style="width: 50%;">
				<div style="width: 100%;height: 80px;">
					<div style="width: 96%;height: 80px;border: 1px solid #2E90FE;border-radius: 6px;">
						<img src="../../../static/images/1portal.png" style="width: 50px;height: 50px;margin-top: 15px;float: left;margin-left: 10px;" />
						<span style="height: 80px;line-height: 80px;width: 100px;font-size: 20px;font-family: '微软雅黑';font-weight: bold;color: #0082E6;">填报1月份轮休计划表</span>
					</div>
				</div>
			</li>
			<div style="margin-top: 100px;border: 1px solid #0082E6;border-radius: 6px;width: 98%;height: 400px;">
				<div style="width: 100%;height: 50px;">
					<ul class="todo-ul">
						<li>待办</li>
						<li>待阅</li>
						<li>已办</li>
						<li>已阅</li>
						<li>我的关注</li>
						<li style="float: right;font-size: 30px;margin-bottom: 20px;">
							...
						</li>
					</ul>
				</div>
				<div style="width: 100%;height: 300px;">
					<table style="width:100%;table-layout: fixed;" border="0" cellspacing="0" cellpadding="0">
						<tr style="border-bottom: 1px solid #50BFFF;">
							<th>标题</th>
							<th>创建人</th>
							<th>当前处理人</th>
							<th>停留时间</th>
						</tr>
						<tr>
							
						</tr>
					</table>
				</div>
			</div>
		</ul>
		
	</div>
</template>

<script>
</script>

<style>
	.portal-ul-1{list-style: none;float: left;width: 100%;height: 80px;padding: 10px;}
	.portal-ul-1 li{width: 50%;float: left;}
	.todo-ul{list-style: none;padding: 0px;width: 100%;border-bottom: 1px solid #0190FE;height: 50px;}
	.todo-ul li{float: left;width: 12%;font-size: 20px;font-family: "微软雅黑";font-weight: bold;color: #1D8CE0;height: 50px;line-height: 50px;}
</style>