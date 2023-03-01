<template>
  <div>
    <div id="frame">
      <h1>众筹信息</h1>
      <form @submit.prevent="donate">
        <span>项目编号：</span>{{ fundInfo.fundid }} <br /><br />
        <span>发起人：</span>{{ fundInfo.userName }} <br /><br />
        <span>所属学校：{{ fundInfo.userSchool }}</span> <br /><br />
        <span>项目名称</span><br />
        {{ fundInfo.goal }}<br /><br />
        <span>目标金额</span><br />
        <span class="aim">{{ fundInfo.money }}</span> <span>￥</span
        ><br /><br />
        <span>发起方电话</span><br />{{ fundInfo.phone }} <br /><br />
        <span>项目介绍</span><br />
        {{ fundInfo.instroduce }}<br /><br />
        <img :src="fundInfo.ps" class="uploadImg" />
        <div id="money">
          <span>已筹金额</span><br />
          <span class="current">{{ fundInfo.moneystate }}</span
          >￥<br /><br /><br />
          <input
            type="number"
            placeholder="输入想要支持的金额"
            min="1"
            v-model="decrease"
          />
          <input type="submit" value="支持" class="btn btnBase" /><br />
        </div>
        <br />
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      fundInfo: null,
      decrease: 0,
    };
  },
  beforeCreate() {
    this.$axios({
      url: "/student/queryid",
      params: {
        fundid: this.$route.query.id,
      },
    }).then(
      (res) => {
        let objData = JSON.parse(JSON.stringify(res.data));
        this.fundInfo = objData;
        return res;
      },
      (error) => {
        alert("加载失败，请求错误");
        return error;
      }
    );
  },
  methods: {
    donate() {
      this.$axios({
        url: "/student/update22",
        params: {
          usercode: this.$route.query.user,
          banlance: this.decrease,
        },
      }).then(
        (response) => {
          if (response.data == "0") {
            alert("参与失败！账户余额不足");
          } else {
            alert("参与成功");
          }
          return response.data;
        },
        (error) => {
          alert("未知原因");
          return error;
        }
      );
    },
  },
};
</script>

<style scoped>
#frame {
  height: 800px;
  box-sizing: border-box;
  box-shadow: 0 0 0 10px #009688;
  border: 10px solid #009688;
  outline: dashed 10px white;
}
#frame h1 {
  color: #009688;
  font-family: "FZXiaoBiaoSong";
  margin: 1% 45%;
}
.uploadImg {
  position: absolute;
  right: 470px;
  top: 12%;
  width: 576px;
  height: 324px;
  cursor: pointer;
}
#money {
  margin: 5%;
  position: absolute;
  right: 550px;
  top: 77%;
  width: 400px;
  text-align: center;
}
form {
  position: absolute;
  right: 22%;
  top: 15%;
  text-align: center;
}
form span {
  color: cadetblue;
  font-weight: bold;
  font-size: 30px;
  font-family: "楷体";
}

input:focus::-webkit-input-placeholder {
  color: transparent;
}
textarea:focus::-webkit-input-placeholder {
  color: transparent;
}
input[type="text"] {
  text-align: center;
  height: 32px;
  border: none;
  border-bottom: 3px solid cadetblue;
  color: rgb(0, 0, 0);
  font-weight: bold;
  font-family: "楷体";
  font-size: 24px;
  background-color: transparent;
  outline: none;
  width: 100%;
}
input[type="number"] {
  text-align: center;
  height: 32px;
  border: none;
  border-bottom: 3px solid cadetblue;
  color: rgb(0, 0, 0);
  font-weight: bold;
  font-family: "楷体";
  font-size: 24px;
  background-color: transparent;
  outline: none;
  width: 240px;
  display: inline-block;
}
.btnBase {
  width: 100px;
  height: 45px;
  display: inline-block;
  color: azure;
  border-radius: 5px;
  display: inline-block;
}
.btn {
  background: #009688;
  border: 2px solid darkgreen;
  cursor: pointer;
}
.btn:hover {
  filter: opacity(80%);
}
.aim {
  font-size: 28px;
  font-weight: bold;
  color: black;
}
.current {
  font-size: 32px;
  font-weight: bold;
  color: red;
}
</style>