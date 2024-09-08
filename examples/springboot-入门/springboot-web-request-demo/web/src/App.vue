<template>
  <table>
    <tbody>
      <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>种类</td>
      </tr>
      <tr v-for="person in people" :key="person.name">
        <td>{{person.name}}</td>
        <td>{{person.age}}</td>
        <td>{{person.gender}}</td>
        <td>{{person.type}}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import axios from 'axios'
export default {
  name: 'App',
  data(){
    return {
      people: []
    }
  },
  async mounted(){
    await axios({
      url: "http://localhost:8080/ListPerson",
    }).then(res => {
      this.people = res.data.data
    })
  }
}
</script>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
table{
  border: 1px solid black;
}
tr, td{
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
