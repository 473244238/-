<template >
  <div id="background">
    <img src="../assets/logo.png" id="logo" />
    <form @submit.prevent="checkedToSubmit">
      <h2 class="form_title">校友注册</h2>
      <br />

      <div class="input">
        <span class="text">用户名</span><br /><input
          class="_input"
          type="text"
          placeholder="快来取一个好听的用户名吧！"
          v-model="user.ID"
        />
        <br />
        <span v-if="!this.checkedBox.isIDOK" class="wrongMsg"
          >用户名应为长度6到20位之间的字符<br
        /></span>
      </div>

      <div class="input">
        <span class="text">密码</span><br /><input
          class="_input"
          type="password"
          placeholder="请输入自定义密码！"
          v-model="user.password"
        /><br />
        <span v-if="!this.checkedBox.isPassWordOK" class="wrongMsg"
          >密码控制在6-15位，且为字母加数字的组合<br
        /></span>
      </div>

      <div class="input">
        <span class="text">确认密码</span><br /><input
          class="_input"
          type="password"
          placeholder="请再次确认密码！"
          v-model="user.confirmedPassword"
        /><br />
        <span v-if="!this.checkedBox.isConfirmedPasswordOK" class="wrongMsg"
          >两次输入的密码不一致！<br
        /></span>
      </div>

      <div class="input">
        <span class="text">毕业/就读学校</span><br />
        <select v-model="user.school" class="_input">
          <option value="FZU">福州大学</option>
          <option value="PKU">北京大学</option>
          <option value="XYYZ">仙游一中</option>
          <option value="FZYZ">福州一中</option></select
        ><br />
      </div>

      <div class="input">
        <span class="text">姓名</span><br /><input
          class="_input"
          type="text"
          placeholder="登记校友姓名"
          v-model="user.name"
        /><br />
        <span v-if="!this.checkedBox.isNameOK" class="wrongMsg"
          >姓名不能为空！<br
        /></span>
      </div>

      <div class="input">
        <span class="text">性别</span><br /><input
          type="radio"
          id="female"
          value="female"
          v-model="user.sex"
        /><label for="female">女</label>
        <input type="radio" id="male" value="male" v-model="user.sex" /><label
          for="male"
          >男</label
        ><br />
      </div>

      <div class="input">
        <span class="text">(*)管理员序列号</span><br /><input
          class="_input"
          type="text"
          placeholder="管理员注册请输入序列号，不填则默认以普通校友身份注册"
          v-model="user.adminNum"
        /><br />
        <span v-if="!this.checkedBox.isAdiminNumOK" class="wrongMsg"
          >不合理的序列号！<br
        /></span>
      </div>

      <input type="submit" value="提交注册信息" class="btn" />
    </form>
  </div>
</template>
//注册界面
<script>
export default {
  data() {
    return {
      user: {
        ID: "",
        password: "",
        confirmedPassword: "",
        name: "",
        sex: "male",
        school: "FZU",
        adminNum: "",
        isAdimin: false,
        admincode: 0,
      },
      checkedBox: {
        isIDOK: false,
        isPassWordOK: false,
        isConfirmedPasswordOK: false,
        isNameOK: false,
        isAdiminNumOK: true,
      },
    };
  },
  methods: {
    checkedToSubmit() {
      if (
        this.checkedBox.isAdiminNumOK &&
        this.checkedBox.isPassWordOK &&
        this.checkedBox.isConfirmedPasswordOK &&
        this.checkedBox.isIDOK &&
        this.checkedBox.isNameOK
      ) {
        this.submitData();
      } else {
        alert("注册失败！请确认各行信息是否符合要求");
      }
    },
    submitData() {
      this.$axios
        .post("/student/register", {
          userCode: this.user.ID,
          userPassword: this.user.password,
          userSchool: this.user.school,
          userName: this.user.name,
          gender: this.user.sex,
          administrator: this.user.admincode,
          banlance: 0,
        })
        .then(
          (response) => {
            alert("信息提交成功");
            this.$router.replace("/login");
            return response.data;
          },
          (error) => {
            alert("不明原因，提交失败！");
            return error;
          }
        );
    },
  },

  watch: {
    "user.ID": {
      deep: true,
      handler: function (value) {
        let format = new RegExp(/^\w{6,20}$/);
        if (format.test(value) && value != null) {
          this.checkedBox.isIDOK = true;
        } else {
          this.checkedBox.isIDOK = false;
        }
      },
    },
    "user.password": {
      deep: true,
      handler: function (value) {
        let format1 = new RegExp(/^[0-9]{0,}[a-zA-Z]{1,}[0-9]{0,}\w{0,}$/);
        let format2 = new RegExp(/^\w{6,16}$/);
        if (format1.test(value) && value != null && format2.test(value)) {
          this.checkedBox.isPassWordOK = true;
        } else {
          this.checkedBox.isPassWordOK = false;
        }
      },
    },
    "user.confirmedPassword": {
      deep: true,
      handler: function (value) {
        if (value === this.user.password) {
          this.checkedBox.isConfirmedPasswordOK = true;
        } else {
          this.checkedBox.isConfirmedPasswordOK = false;
        }
      },
    },
    "user.adminNum": {
      deep: true,
      handler: function (value) {
        if (value == "尤雨溪懂个锤子Vue") {
          this.checkedBox.isAdiminNumOK = true;
          this.user.isAdimin = true;
          this.user.admincode = 1;
        } else if (value == "") {
          this.checkedBox.isAdiminNumOK = true;
          this.user.isAdimin = false;
          this.user.admincode = 0;
        } else {
          this.checkedBox.isAdiminNumOK = false;
          this.user.admincode = 0;
        }
      },
    },
    "user.name": {
      deep: true,
      handler: function (value) {
        if (value == "") {
          this.checkedBox.isNameOK = false;
        } else {
          this.checkedBox.isNameOK = true;
        }
      },
    },
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}
#logo {
  position: absolute;
  width: 20%;
  height: 25%;
}
#background {
  background: url("../assets/rgs_background.png") no-repeat center center;
  background-size: cover;
  background-attachment: fixed;
  height: 100%;
}
.form_title {
  width: 100%;
  height: 30px;
  line-height: 30px;
  font-size: 36px;
  color: whitesmoke;
}
form {
  width: 500px;
  height: 640px;
  position: relative;
  margin: 0 auto;
  background-color: rgba(0, 0, 0, 0.5);
  margin-top: 6%;
  border-radius: 24px;
  padding: 2% 5%;
  margin-top: 1%;
}
.wrongMsg {
  color: red;
  font-size: 10px;
}
.input {
  width: 100%;
  height: auto;
  box-sizing: border-box;
  margin: 5px 0px;
}
.text {
  color: #cce7f8;
  font-size: 18px;
  -webkit-animation: shining 0.5s alternate infinite;
  animation: shining 0.5s alternate infinite;
  font-family: "FZXiaoBiaoSong-B05S";
}
._input {
  width: 100%;
  animation: animated-border 1.5s infinite;
  font-family: "FZXiaoBiaoSong-B05S";
  font-size: 15px;
  line-height: 28px;
  font-weight: bold;
  color: rgb(0, 0, 0);
  border: 2px solid;
  border-radius: 10px;
  margin: 5px 0px;
}
.btn {
  background-color: rgb(22, 155, 175);
  background-image: linear-gradient(
    90deg,
    rgb(6, 56, 255) 0%,
    rgb(1, 96, 96) 74%
  );
  border-radius: 20px;
  border: 1px solid rgb(38, 54, 179);
  color: rgb(255, 255, 255);
  cursor: pointer;
  font-size: 0.8rem;
  font-weight: bold;
  letter-spacing: 0.1rem;
  padding: 0.9rem 4rem;
  transition: transform 80ms ease-in;
  position: absolute;
  left: 32.5%;
  top: 90%;
}
@keyframes shining {
  from {
    text-shadow: 0 0 10px lightblue, 0 0 20px lightblue, 0 0 30px lightblue,
      0 0 20px skyblue, 0 0 30px skyblue, 0 0 40px skyblue;
  }

  to {
    text-shadow: 0 0 5px lightblue, 0 0 10px lightblue, 0 0 15px lightblue,
      0 0 20px skyblue, 0 0 25px skyblue, 0 0 30px skyblue;
  }
}
@keyframes animated-border {
  0% {
    box-shadow: 0 0 0 0 rgba(255, 255, 255, 0.4);
  }
  100% {
    box-shadow: 0 0 0 7px rgba(255, 255, 255, 0);
  }
}
</style>