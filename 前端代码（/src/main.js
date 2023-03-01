import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './router/Station'
import axios from 'axios'
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(VueRouter)
axios.defaults.baseURL = '/api'
new Vue({
  render: h => h(App),
  router: router,
}).$mount('#app')
