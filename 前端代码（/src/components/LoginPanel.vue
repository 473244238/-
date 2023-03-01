<template>
  <div id="background">
    <form @submit.prevent="submitToLogin">
      <img src="../assets/LoginCat.png" id="cat" />
      <h2 class="form_title">欢迎回来，校友！</h2>
      <div class="input">
        <input
          class="_input"
          type="text"
          placeholder="用户名"
          id="id"
          v-model="account"
        />
        <input
          class="_input"
          type="password"
          placeholder="密码"
          id="password"
          v-model="password"
        />
        <input type="submit" value="登录" class="btn" />
        <br />
      </div>
    </form>
  </div>
</template>
//登录界面
<script>
export default {
  data() {
    return {
      account: "",
      password: "",
    };
  },
  methods: {
    submitData() {
      this.$axios({
        url: "/student/login",
        params: {
          userCode: this.account,
          userPassword: this.password,
        },
      }).then(
        (response) => {
          if (response.data == "1") {
            alert("登录成功！即将跳转至校友之家主页");
            let id = this.account;
            this.$router.replace({ path: "/home/" + id });
          } else {
            alert("登录失败！账号名或密码不匹配");
          }
          return response.data;
        },
        (error) => {
          alert("登录失败！未知原因");
          return error;
        }
      );
    },
    submitToLogin() {
      alert(this.password);
      this.submitData();
    },
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}
#background {
  background: url("../assets/log_background.jpg") no-repeat center center;
  background-size: cover;
  background-attachment: fixed;
  height: 100%;
}
#cat {
  width: 40%;
  height: 30%;
  margin: 5% 28%;
  filter: opacity(70%);
}
form {
  width: 500px;
  height: 600px;
  position: relative;
  top: 4%;
  margin: 0 auto;
  background-color: rgba(255, 255, 255, 0.4);
  border: 2px solid rgb(255, 255, 255);
  margin-top: 6%;
  border-radius: 24px;
  padding: 2% 5%;
  margin-top: 1%;
}
.form_title {
  text-align: center;
  width: 100%;
  height: 30px;
  line-height: 30px;
  font-size: 36px;
  color: rgb(5, 1, 1);
  font-family: "楷体";
  margin-bottom: 7%;
}
._input {
  width: 100%;
  animation: animated-border 1.5s infinite;
  font-family: "FZXiaoBiaoSong-B05S";
  font-size: 24px;
  line-height: 60px;
  font-weight: bold;
  color: rgb(0, 0, 0);
  border: 2px solid rgba(255, 255, 255, 1);
  border-radius: 5px;
  margin: 15px 0px;
  text-align: justify;
  filter: opacity(70%);
  text-indent: 60px;
  box-shadow: 0 0 15px black;
}
#id {
  background-image: url("../assets/loginUser.png");
  background-repeat: no-repeat;
  display: inline-block;
  background-size: contain;
  fill-opacity: 50%;
}
#password {
  background-image: url("../assets/loginLock.png");
  background-repeat: no-repeat;
  display: inline-block;
  background-size: contain;
  fill-opacity: 50%;
}
.btn {
  background-color: rgb(70, 255, 255);
  background-image: linear-gradient(
    90deg,
    rgb(37, 130, 206) 0%,
    rgb(47, 186, 255) 74%
  );
  border-radius: 10px;
  border: 1px solid rgb(37, 130, 206);
  color: rgb(255, 255, 255);
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
  letter-spacing: 0.1rem;
  padding: 0.9rem 4rem;
  transition: transform 80ms ease-in;
  position: absolute;
  left: 37%;
  top: 90%;
  box-shadow: 0 0 7px black;
}
</style>