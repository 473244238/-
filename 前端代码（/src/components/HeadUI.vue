<template>
  <div id="all">
    <h1>校 友 之 家</h1>
    <h2>-万千校友的聚集地-</h2>
    <div id="personalInfo">
      <div>
        <span>欢迎，{{ userData.name }}校友！</span><br />
        ID:{{ userData.ID }}<br />
        学校：{{ userData.school }}<br />
        账户余额：{{ userData.money }}<br />
      </div>
    </div>
  </div>
</template>

<script>
import pubsub from "pubsub-js";
export default {
  data() {
    return {
      userData: {
        ID: this.$route.params.id,
        name: "",
        school: "",
        money: 0,
        admin: 0,
      },
    };
  },
  mounted() {
    pubsub.subscribe("aaa", () => {
      this.$axios({
        url: "/student/update",
        params: { usercode: this.userData.ID },
      }).then(
        (res) => {
          this.userData.money = res.data;
          return res;
        },
        (error) => {
          alert("未知错误，充值失败");
          return error;
        }
      );
    });

    this.$axios({
      url: "/student/Test",
      params: { useCode: this.userData.ID },
    }).then(
      (res) => {
        let objData = JSON.parse(JSON.stringify(res.data));
        //alert(JSON.stringify(res.data));
        this.userData.name = objData.userName;
        this.userData.school = objData.userSchool;
        this.userData.money = objData.banlance;
        this.userData.admin = objData.administrator;
        return res;
      },
      (error) => {
        alert("草拟吗");
        return error;
      }
    );
  },
};
</script>


<style scoped>
* {
  margin: 0;
  padding: 0;
}
#all {
  width: 100%;
  height: 70%;
  background-image: url("../assets/HeadBackground.png");
  background-size: cover;
  background-repeat: no-repeat;
}
h1 {
  color: hsl(0, 100%, 98%);
  font-family: "FZXiaoBiaoSong-B05S";
  font-size: 120px;
  height: 140px;
  position: absolute;
  text-align: center;
  left: 4%;
  top: 20%;
  width: 40%;
  animation: move linear 2000ms infinite;
}
h2 {
  color: hsl(0, 100%, 98%);
  font-family: "楷体";
  font-size: 35px;
  height: 140px;
  position: absolute;
  text-align: center;
  left: 3%;
  top: 43%;
  width: 40%;
  text-shadow: 0 0 15px #000000;
}
#personalInfo {
  width: auto;
  height: auto;
  border: 6px solid rgb(3, 104, 79);
  font-family: "FZXiaoBiaoSong-B05S";
  border-radius: 10px;
  background-color: aliceblue;
  filter: opacity(50%);
  float: right;
}
#personalInfo div {
  margin-left: 16%;
}
#personalInfo div span {
  font-size: 24px;
}
#personalInfo span {
  font-size: 16px;
}
@keyframes move {
  0% {
    text-shadow: 4px -4px 0 rgb(17, 103, 98), 3px -3px 0 rgb(17, 103, 98),
      2px -2px 0 rgb(17, 103, 98), 1px -1px 0 rgb(17, 103, 98),
      -4px 4px 0 rgb(0, 5, 5), -3px 3px 0 rgb(0, 5, 5), -2px 2px 0 rgb(0, 5, 5),
      -1px 1px 0 rgb(0, 5, 5);
  }
  25% {
    text-shadow: -4px -4px 0 rgb(0, 5, 5), -3px -3px 0 rgb(0, 5, 5),
      -2px -2px 0 rgb(0, 5, 5), -1px -1px 0 rgb(0, 5, 5),
      4px 4px 0 rgb(17, 103, 98), 3px 3px 0 rgb(17, 103, 98),
      2px 2px 0 rgb(17, 103, 98), 1px 1px 0 rgb(17, 103, 98);
  }
  50% {
    text-shadow: -4px 4px 0 rgb(17, 103, 98), -3px 3px 0 rgb(17, 103, 98),
      -2px 2px 0 rgb(17, 103, 98), -1px 1px 0 rgb(17, 103, 98),
      4px -4px 0 rgb(0, 5, 5), 3px -3px 0 rgb(0, 5, 5), 2px -2px 0 rgb(0, 5, 5),
      1px -1px 0 rgb(0, 5, 5);
  }
  75% {
    text-shadow: 4px 4px 0 rgb(0, 5, 5), 3px 3px 0 rgb(0, 5, 5),
      2px 2px 0 rgb(0, 5, 5), 1px 1px 0 rgb(0, 5, 5),
      -4px -4px 0 rgb(17, 103, 98), -3px -3px 0 rgb(17, 103, 98),
      -2px -2px 0 rgb(17, 103, 98), -1px -1px 0 rgb(17, 103, 98);
  }
  100% {
    text-shadow: 4px -4px 0 rgb(17, 103, 98), 3px -3px 0 rgb(17, 103, 98),
      2px -2px 0 rgb(17, 103, 98), 1px -1px 0 rgb(17, 103, 98),
      -4px 4px 0 rgb(0, 5, 5), -3px 3px 0 rgb(0, 5, 5), -2px 2px 0 rgb(0, 5, 5),
      -1px 1px 0 rgb(0, 5, 5);
  }
}
</style>