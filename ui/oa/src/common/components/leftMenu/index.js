import LeftMenu from './left-menu.vue';

LeftMenu.install = function (Vue) {
  Vue.component(LeftMenu.name, LeftMenu);
};

export default LeftMenu;