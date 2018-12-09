// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import 'element-ui/lib/theme-chalk/index.css';
import ElementUI from 'element-ui';
import PlComponents from './common/components/index.js';//自定义组件

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(PlComponents);

console.log('自定义组件',PlComponents);
console.log('饿了吗组件',ElementUI);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
