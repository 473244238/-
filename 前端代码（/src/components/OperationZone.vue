<template>
  <div>
    <router-link :to="{ name: 'form' }" class="btn create"
      ><span>发布众筹</span></router-link
    >
    <router-link :to="{ name: 'fundlist' }" class="btn cooperate"
      ><span>参与众筹</span></router-link
    >
    <input
      class="smallbtn"
      type="button"
      value="点我充值一百"
      @click="addMoney"
    />
    <span class="footer">再次感谢您对母校发展的支持！</span>
  </div>
</template>

<script>
import pubsub from "pubsub-js";
export default {
  methods: {
    addMoney() {
      alert("充值100元成功！");
      pubsub.publish("aaa", 100);
    },
  },
};
</script>

<style scoped>
.btn {
  width: 300px;
  height: 280px;
  position: relative;
  text-align: center;
  text-decoration: none;
  font-size: 32px;
  font-family: "楷体";
  font-weight: bold;
  display: inline-block;
  border-radius: 0.3em;
  overflow: hidden;
  transition: 0.5s;
  background-size: 50%, 200% auto;
  background-repeat: no-repeat;
  background-position: center, left;
}
.btn span {
  position: relative;
  top: 80%;
}
.footer {
  position: absolute;
  top: 155%;
  left: 30%;
  font-family: "楷体";
  font-size: 45px;
  color: cadetblue;
}
.btn:hover {
  background-position: center, right center;
}
.smallbtn {
  position: relative;
  top: 200px;
  right: 1%;
  margin: 20px;
  text-align: center;
  width: 200px;
  height: 85px;
  line-height: 44px;
  border-radius: 4px;
  color: #fff;
  height: 44px;
  line-height: 44px;
  background: #55acee;
  transition: all 0.5s;
  box-shadow: 0px 5px 0px 0px #3486d5;
  border: #55acee;
  cursor: pointer;
}

.smallbtn:hover {
  background-color: #6fc6ff;
}

.create {
  left: 340px;
  top: 100px;
  background-image: url(../assets/create.png),
    linear-gradient(to right, #f6d365 0%, #fda085 51%, #f6d365 100%);
  color: #ffffff;
}
.cooperate {
  left: 470px;
  top: 100px;
  background-image: url(../assets/participate.png),
    linear-gradient(to right, #84fab0 0%, #8fd3f4 51%, #84fab0 100%);
  color: #ffffff;
}
</style>