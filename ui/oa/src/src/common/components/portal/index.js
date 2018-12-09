import Portal from './Portal.vue';

Portal.install = function (Vue) {
  Vue.component(Portal.name, Portal);
};

export default Portal;