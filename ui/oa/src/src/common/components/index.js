import Vue from 'vue'
import Header from './header';
import LeftMenu from './leftMenu';
import Portal from './portal';



const install = function (Vue){
	if (install.installed) {
		console.log('true');
		return;
	}
	
	Vue.component(Header.name, Header); //标题头
	Vue.component(LeftMenu.name, LeftMenu); //左边菜单
	Vue.component(Portal.name, Portal); //Portal
	
	if (typeof window !== 'undefined' && window.Vue) {
	  install(window.Vue);
	}
};

Vue.component(Header.name, Header); //标题头
Vue.component(LeftMenu.name, LeftMenu); //左边菜单
Vue.component(Portal.name, Portal); //左边菜单

/* istanbul ignore if */
if (typeof window !== 'undefined' && window.Vue) {
  install(window.Vue);
}

export default {
	Header,
	LeftMenu,
	Portal
}
