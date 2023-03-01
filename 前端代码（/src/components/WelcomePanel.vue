<template>
  <div id="backGround">
    <img src="../assets/logo.png" class="titleMeg" />
    <br />
    <h1 class="titleMeg" id="mainTitle">{{ MainTitle }}</h1>
    <br /><br />
    <h3 class="titleMeg" id="DirectedMeg">{{ DirectedMeg }}</h3>
    <router-link to="/login">登录</router-link>
    <router-link to="/register">注册</router-link>
  </div>
</template>
//欢迎界面
<script>
export default {
  data() {
    return {
      MainTitle: "欢迎访问校友之家!",
      DirectedMeg: "点击登录或注册参与众筹/校园建设",
    };
  },
};
</script>

<style scoped>
* {
  font-family: "楷体";
}

#backGround {
  width: 100%;
  height: 100%;
  background: linear-gradient(
    -45deg,
    #e6f490,
    #ffffff,
    #e9ffdb,
    rgb(177, 255, 255)
  );
  background-size: 600% 600%;
  animation: gradientBG 5s ease infinite;
  text-align: center;
}

/* 动画，控制背景 background-position */
@keyframes gradientBG {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}
</style>


