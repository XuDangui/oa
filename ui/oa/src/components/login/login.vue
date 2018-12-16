<template>
  <div class="login-context">
      <div class="login-theme-title">OA管理系统</div>
        <!--登录-->
        <div class="login-container">
          <div class="login-panel">
            <el-form ref="form" :model="form" label-width="80px" class="loginFormCss">
              <el-form-item prop="account" :rules="[
                    { required: true, message: '请输入登录账号', trigger: 'change' }
                  ]">
                <i class="login-form-user"></i>
                <el-input v-model="form.account"></el-input>
                <!-- id="form-input" -->
              </el-form-item>
              <el-form-item prop="password" :rules="[
                    { required: true, message: '请输入密码', trigger: 'change' }
                  ]">
                <i class="login-form-pw"></i>
                <el-input v-model="form.password" type="password"></el-input>
              </el-form-item>
              <el-button  type="primary" class="login-button" @click="login">登录</el-button>
            </el-form>
            <div v-show="iserr" class="login-err">帐号或密码错误，请重新输入！</div>
          </div>
        </div>
    </div>
</template>

<script>
	import {HttpPrefix} from '../../common/js/constants.js';
	import { MsgType } from '../../common/js/constants.js';
  export default {
    data () {
      return {
        // disable: true,
        src: '',
        applause: '',
        dateNow: '',
        isAutoLogin: true,
        iserr: false,
        form: {
          value: '',
          account: '',
          password: '',
          rememberMe: true
        }
      };
    },
    methods: {
    	login(){
    		let url = HttpPrefix.OA + 'user/login';
    		let params = {
    			account:this.form.account,
    			password:this.form.password
    		};
    		let msg = MsgType;
    		this.$http.post(url,JSON.stringify(params)).then(res=>{
    			console.log(res);
    			debugger;
    			if(res.body && res.body.type == MsgType.ERROR){
    				this.$notify({
		             type:"error",
		             message: res.body.msg
		        });
    			}else{
    				this.$store.getters.user = res.body.data;
    				this.$store.getters.isLogin = true;
    				console.log('登录用户实体',this.$store.getters.user);
    				this.$router.push({name: 'homePage', params: res.body.data});
    			}
    		});
    	}
    },
    mounted () {
      this.$nextTick(function(){
      	let height = window.screen.height;
      	$('.login-context').css('height',height);
      });
      this.isAutoLogin = false;
    }
  };
</script>

<style >
	.login-context{
		width: 100%;
		height: 100%;
		background: url(../../../static/testImgs/bg.jpg) no-repeat;
		overflow: hidden;
	}
	.login-container{
		width: 800px;
		height: 100%;
		margin: 0px auto;
	}
  .login-panel{
  	width: 50%;
  	height: 200px;
  	margin: 0px auto;
  }
  .login-form-user{
  	width: 40px;
    height: 40px;
    border-right: 1px solid #ccc;
    position: absolute;
    left: -51px;
    top: 2px;
  	background: url(img/ico_usr.png)no-repeat 0 5px;
  }
  .login-form-pw{
  	width: 40px;
    height: 40px;
    border-right: 1px solid #ccc;
    position: absolute;
    left: -51px;
    top: 2px;
  	background:url(img/ico_pw.png)no-repeat 0 5px;
  }
  .login-button{
  	width: 94%;
  	margin: 0 auto;
  	margin-left: 26px;
  }
  .loginFormCss{
  	position: relative;
  	top: 200px;
  }
  .login-theme-title{
  	position: relative;
  	top: 180px;
  	margin: 0px auto;
  	width: 100%;
  	height: 60px;
  	font-family: "微软雅黑";
  	font-size: 25px;
  	font-weight: bold;
  	color: #0190FE;
  }
</style>


