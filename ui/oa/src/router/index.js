import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/login/login'

Vue.use(Router)


export default new Router({
  routes: [
  	{
      desc:'登录页',
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/header-model',
      name: 'header-model',
      component (resolve) {
	      require(['@/components/header-model.vue'], resolve);
	    }
    },
    {
      path: '/left-menu',
      name: 'left-menu',
      component (resolve) {
	      require(['@/components/model/left-menu.vue'], resolve);
	    }
    },
    {
      path: '/header',
      name: 'Header',
      component (resolve) {
	      require(['@/common/components/header/header.vue'], resolve);
	    }
    },
    {
      path: '/homePage',
      name: 'homePage',
      component (resolve) {
	      require(['@/components/homePage/homePage.vue'], resolve);
	    }
    },
    {
      path: '/portal',
      name: 'portal',
      component (resolve) {
	      require(['@/components/portal/portal.vue'], resolve);
	    }
    },
    {
      path: '/breakApply',
      name: 'breakApply',
      component (resolve) {
	      require(['@/components/breakApply/breakApply.vue'], resolve);
	    }
    },
    {
      path: '/businessTrip',
      name: 'businessTrip',
      component (resolve) {
	      require(['@/components/businessTrip/businessTrip.vue'], resolve);
	    }
    },
    {
      path: '/rotateBreak',
      name: 'rotateBreak',
      component (resolve) {
	      require(['@/components/rotateBreak/rotateBreak.vue'], resolve);
	    }
    },
    {
      path: '/workOvertime',
      name: 'workOvertime',
      component (resolve) {
	      require(['@/components/workOvertime/workOvertime.vue'], resolve);
	    }
    },
    {
      path: '/attendanceCheck',
      name: 'attendanceCheck',
      component (resolve) {
	      require(['@/components/attendanceCheck/attendanceCheck.vue'], resolve);
	    }
    }
  ]
})
