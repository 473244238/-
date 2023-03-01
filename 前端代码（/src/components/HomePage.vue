<template>
  <div id="background">
    <HeadUI></HeadUI>
    <DisplayZone></DisplayZone>
  </div>
</template>

<script>
import HeadUI from "./HeadUI.vue";
import DisplayZone from "./DisplayZone.vue";
export default {
  components: {
    HeadUI,
    DisplayZone,
  },
  mounted() {
    this.$router.push({ name: "center" });
  },
};
</script>


<style>
* {
  margin: 0;
  padding: 0;
}
#background {
  height: 100%;
}
</style>