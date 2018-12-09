<template>
	<div>
		<h1 style="color: #0082E6;">员工考勤表</h1>
		<div style="width: 80%;height: 45px;margin: 0 auto;line-height: 45px;">
			<span style="float: left;">部门：</span>
			<el-select v-model="value" placeholder="请选择" style="float: left;">
			    <el-option
			      v-for="item in options"
			      :key="item.value"
			      :label="item.label"
			      :value="item.value">
			    </el-option>
			</el-select>
		</div>
		<div style="width: 80%;height: auto;margin: 0 auto;min-height: 60px;border: 2px solid #0082E6;">
			<table>
				<tr>
					<th style="width: 101px;text-align: center;border: 1px solid #000000;box-sizing: border-box;text-align: center;vertical-align: middle;">
			            <div style="width: 0px; height: 0px; border-top: 60px #e4e2e2 solid; border-left: 100px #BDBABD solid; position: relative;">
			              <b style="font-style: normal;display: block; position: relative; top: -35px; left: -35px; width: 35px; z-index:222;">日期</b>
			              <b style="font-style: normal; display: block; position: absolute; top: -30px; left: -90px; width: 55px; z-index:222;">姓名</b>
			            </div>
			        </th>
			        <th style="width: 35px;border: 1px solid #000000;box-sizing: border-box;text-align: center;vertical-align: middle;margin-left: 0px;" v-for="(item,index) in allData.date">
			            {{item.date}}
			        </th>
			        <th style="width: 35px;border: 1px solid #000000;box-sizing: border-box;text-align: center;vertical-align: middle;" v-for="i in arrIndex"></th>
		          	<th style="width: 100px;border: 1px solid #000000;box-sizing: border-box;text-align: center;vertical-align: middle;">
		            考勤员
		          	</th>
		            <th style="width: 100px;border: 1px solid #000000;box-sizing: border-box;text-align: center;vertical-align: middle;">
		            员工签字
		          	</th>
				</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default{
		data(){
			return {
				options:[],
				allData:{
					date:[]
				},
				arrIndex:[],
				value:''
			}
		},
		methods:{
			getDay (value) {
		        if (value != null) {
		          let date = new Date(value);
		          return date.getDate();
		        } else {
		          return value;
		        }
		      }
		},
		mounted(){
			for(let i=0;i<30;i++){
				let obj = {};
				obj.date = i + 1;
				this.allData.date.push(obj);
			}
		}
	}
</script>

<style>
</style>