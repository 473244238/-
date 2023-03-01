<template>
  <div id="frame">
    <div id="navigation">
      <router-link :to="{ name: 'center' }" class="btn">操作中心</router-link>
      <router-link :to="{ name: 'fundlist' }" class="btn">所有众筹</router-link>
      <router-link to="/home" class="btn">学校信息</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>
    
<script>
</script>
    
<style scoped>
* {
  margin: 0;
  padding: 0;
}
@keyframes sheen {
  0% {
    transform: skewY(-45deg) translateX(0);
  }
  100% {
    transform: skewY(-45deg) translateX(12.5em);
  }
}
#frame {
  height: 100%;
  box-shadow: 0 0 0 10px #009688;
  border: 10px solid #009688;
  outline: dashed 10px white;
}
#navigation {
  margin: 2px 28%;
  height: 12%;
}
.btn {
  padding: 0.75em 2em;
  text-align: center;
  text-decoration: none;
  color: #023049;
  border: 3px solid #065777;
  font-size: 24px;
  display: inline-block;
  border-radius: 0.3em;
  transition: all 0.2s ease-in-out;
  position: relative;
  overflow: hidden;
}

.btn:before {
  content: "";
  background-color: rgba(255, 255, 255, 0.5);
  height: 100%;
  width: 3em;
  display: block;
  position: absolute;
  top: 0;
  left: -4.5em;
  transform: skewX(-45deg) translateX(0);
  transition: none;
}
.btn:hover {
  background-color: #0f6d6f;
  color: #fff;
  border-bottom: 4px solid darken(#2194e0, 10%);
}
.btn:hover:before {
  transform: skewX(-45deg) translateX(13.5em);
  transition: all 0.5s ease-in-out;
}
</style>