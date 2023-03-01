<template>
  <div id="frame">
    <h1>发起众筹</h1>
    <form @submit.prevent="submitData">
      <span>发起人：</span
      ><input
        type="text"
        v-model="initiatorName"
        maxlength="4"
        id="name"
        placeholder="不填则为匿名"
      />
      <br /><br />
      <span>所属学校：{{ school }}</span> <br /><br />
      <span>项目名称</span><br />
      <input
        type="text"
        maxlength="20"
        placeholder="2到20个字符"
        v-model="fundName"
        autofocus
      /><br /><br />
      <span>众筹目标</span><br /><input
        type="number"
        min="1"
        max="100000000"
        placeholder="支持金额范围1-1亿"
        v-model="aimFund"
      />
      <span>￥</span><br /><br />
      <span>发起方电话</span><br /><input
        type="text"
        v-model="phoneNumber"
        placeholder="必须为11位纯数字"
        maxlength="11"
      />
      <br /><br />
      <span>项目介绍</span><br />
      <textarea
        v-model="introduction"
        placeholder="描述不得少于10个字.."
      ></textarea
      ><br /><br />
      <input
        type="file"
        style="display: none"
        ref="file"
        accept="image/jpeg,image/jpg,image/png"
        @change="afterRead"
        @click="
          (e) => {
            e.target.value = '';
          }
        "
      />
      <input
        v-if="this.counter == 4"
        type="submit"
        value="提交审核"
        class="btn btnBase"
      />
      <input
        v-else
        type="submit"
        value="提交审核"
        class="inactiveBtn btnBase"
      />
    </form>
    <img :src="src" @click="uploadMaterial" class="uploadImg" />
    <span class="underImg">点击选中框更换众筹图片（仅支持图片格式）</span>
    <span v-if="this.counter != 4" class="underImg noticeInfo"
      >*请确认众筹所有信息符合要求，方可提交</span
    >
  </div>
</template>

<script>
export default {
  data() {
    return {
      initiatorName: "",
      school: "fzu",
      src: "",
      fundName: "",
      aimFund: 1,
      phoneNumber: "",
      introduction: "",
      counter: 0,
    };
  },
  methods: {
    uploadMaterial() {
      this.$refs.file.dispatchEvent(new MouseEvent("click"));
    },
    afterRead() {
      let that = this;
      let file = this.$refs.file.files[0];
      var reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = function () {
        that.src = this.result;
      };
    },
    submitData() {
      this.$axios
        .post("/student/addfund", {
          userName: this.initiatorName,
          userSchool: this.school,
          goal: this.fundName,
          money: this.aimFund,
          phone: this.phoneNumber,
          instroduce: this.introduction,
          Fundstate: 1,
          ps: this.src,
          moneystate: 0,
        })
        .then(
          (res) => {
            alert("提交审核成功");
            this.$router.replace({ name: "home" });
            return res.data;
          },
          (error) => {
            alert("错误");
            return error;
          }
        );
    },
  },
  watch: {
    fundName(newValue, oldValue) {
      let format = new RegExp(/^\w{2,20}$/);
      if (format.test(newValue) && !format.test(oldValue)) {
        this.counter++;
      } else if (!format.test(newValue) && format.test(oldValue)) {
        this.counter--;
      }
    },
    phoneNumber(newValue, oldValue) {
      let format = new RegExp(/^[0-9]{11}$/);
      if (format.test(newValue) && !format.test(oldValue)) {
        this.counter++;
      } else if (!format.test(newValue) && format.test(oldValue)) {
        this.counter--;
      }
    },
    introduction(newValue, oldValue) {
      let format = new RegExp(/^\w{10,}$/);
      if (format.test(newValue) && !format.test(oldValue)) {
        this.counter++;
      } else if (!format.test(newValue) && format.test(oldValue)) {
        this.counter--;
      }
    },
    src(newValue, oldValue) {
      if (oldValue == "") {
        this.counter++;
      } else if (newValue == "" && oldValue != "") {
        this.counter--;
      }
    },
  },
};
</script>

<style scoped>
#frame {
  height: 100%;
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
  position: relative;
  left: 6%;
  top: 12%;
  width: 576px;
  height: 324px;
  border: 3px dashed gray;
  cursor: pointer;
}
form {
  position: absolute;
  right: 22%;
  top: 15%;
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
}
#name {
  width: 150px;
}
textarea {
  padding: 2px 5px;
  margin: 5% 0%;
  width: 100%;
  height: 120px;
  border: 3px solid#009688;
  border-radius: 5px;
  font-size: 20px;
  resize: none;
  font-weight: bold;
  font-family: "楷体";
  box-sizing: border-box;
}
.underImg {
  position: relative;
  right: 25%;
  top: 20%;
  color: #46504f;
  font-family: "FZXiaoBiaoSong";
}
.noticeInfo {
  right: 44%;
  top: 38%;
  color: red;
  font-size: 12px;
}
.btnBase {
  position: relative;
  width: 60%;
  height: 45px;
  right: 590px;
  bottom: 100px;
  color: azure;
  border-radius: 5px;
}
.inactiveBtn {
  background: #46504f;
  filter: opacity(20%);
}
.btn {
  background: #009688;
  border: 2px solid darkgreen;
  cursor: pointer;
}
.btn:hover {
  filter: opacity(80%);
}
</style>