<template>
  <div class="box">
    <h1>Son1</h1>
    从vuex中获取的值:<label>{{this.$store.state.count}}</label>
    <br>
    <button @click="add(5)">+1</button>
    <button @click="addAsync(5)">一秒后+1</button>
    getters:<span>{{ double }}</span>
    <br>
    <div>{{ user.userInfo.name }}</div>
    <br>
    <div>{{doubleAge}}</div>
    <!-- <div>{{ $store.getters['user/doubleAge'] }}</div> -->
  </div>
</template>

<script>
import { mapMutations, mapState, mapActions, mapGetters } from 'vuex'
export default {
  name: 'Son1Component',
  computed: {
    ...mapState(['count', 'user']),
    ...mapGetters(['double']),
    ...mapGetters('user', ['doubleAge'])
  },
  methods: {
    ...mapMutations(['add']),
    ...mapActions(['addAsync'])
  }
}
</script>

<style scpoed>
.box{
  border: 3px solid #ccc;
  width: 400px;
  padding: 10px;
  margin: 20px;
}
h2{
  margin-top: 10px;
}
</style>
