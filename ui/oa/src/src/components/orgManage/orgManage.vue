<template>
	<div style="width: 95%;margin: 0 auto;height: 600px;">
		<h3 style="color: #0082E6;">组织管理</h3>
		<el-form :inline="true" :model="formInline" class="demo-form-inline" style="margin-top: 30px;">
		  <el-row style="float: left;margin-left: 20px;width: 100%;">
		  	<el-form-item label="部门名称" class="queryInput">
		    <el-input v-model="formInline.user" placeholder="部门名称"></el-input>
		  </el-form-item>
		  </el-row>
		</el-form>
		<div style="width: 100%;height: 40px;margin-left: 20px;">
			<el-button type="primary" @click="add" class="btn">新增</el-button>
			<el-button type="primary" @click="query" class="btn">查询</el-button>
			<el-button type="primary" @click="edit" class="btn">修改</el-button>
			<el-button type="primary" @click="check" class="btn">查看</el-button>
			<el-button type="primary" @click="del" class="btn">删除</el-button>
		</div>
		<el-table
		    :data="tableData"
		    height="300"
		    border
		    style="width: 100%;margin-top: 80px;">
		    <el-table-column
		      prop="date"
		      label="创建时间"
		      width="180">
		    </el-table-column>
		    <el-table-column
		      prop="name"
		      label="部门名称"
		      width="180">
		    </el-table-column>
		    <el-table-column
		      prop="address"
		      label="地址">
		    </el-table-column>
		  </el-table>
		  
		  <el-dialog :title="optTitle" :visible.sync="dialogFormVisible">
			  <el-form :model="form">
			    <el-form-item label="活动名称" :label-width="formLabelWidth">
			      <el-input v-model="form.name" autocomplete="off"></el-input>
			    </el-form-item>
			    <el-form-item label="活动区域" :label-width="formLabelWidth">
			      <el-select v-model="form.region" placeholder="请选择活动区域">
			        <el-option label="区域一" value="shanghai"></el-option>
			        <el-option label="区域二" value="beijing"></el-option>
			      </el-select>
			    </el-form-item>
			  </el-form>
			  <div slot="footer" class="dialog-footer">
			    <el-button @click="dialogFormVisible = false">取 消</el-button>
			    <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
			  </div>
			</el-dialog>
	</div>
</template>

<script>
	export default{
		data(){
			return {
				formInline:{
					user:'',
					formInline:''
				},
				 tableData: [{
		          date: '2016-05-03',
		          name: '王小虎',
		          address: '上海市普陀区金沙江路 1518 弄'
		        }, {
		          date: '2016-05-02',
		          name: '王小虎',
		          address: '上海市普陀区金沙江路 1518 弄'
		        }, {
		          date: '2016-05-04',
		          name: '王小虎',
		          address: '上海市普陀区金沙江路 1518 弄'
		        }, {
		          date: '2016-05-01',
		          name: '王小虎',
		          address: '上海市普陀区金沙江路 1518 弄'
		        }, {
		          date: '2016-05-08',
		          name: '王小虎',
		          address: '上海市普陀区金沙江路 1518 弄'
		        }, {
		          date: '2016-05-06',
		          name: '王小虎',
		          address: '上海市普陀区金沙江路 1518 弄'
		        }, {
		          date: '2016-05-07',
		          name: '王小虎',
		          address: '上海市普陀区金沙江路 1518 弄'
		        }],
		        dialogFormVisible: false,
		        form: {
		          name: '',
		          region: '',
		          date1: '',
		          date2: '',
		          delivery: false,
		          type: [],
		          resource: '',
		          desc: ''
		        },
		        formLabelWidth: '120px',
		        optTitle:'新增部门'
			}
		},
		methods:{
			add(){
				this.dialogFormVisible = true;
				this.optTitle="新增部门";
			},
			query(){
				
			},
			edit(){
				this.dialogFormVisible = true;
				this.optTitle="修改部门";
			},
			del(){
				
			},
			check(){
				this.dialogFormVisible = true;
				this.optTitle="查看部门";
			}
		}
	}
</script>

<style>
	.btn{
		float: left;
	}
	.queryInput{
		float: left;
	}
</style>