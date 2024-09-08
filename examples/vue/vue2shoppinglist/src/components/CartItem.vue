<template>
  <div class="item">
    <img class="item-img" :src="item.thumb">
    <div class="item-info">
      <p class="item-name">
        {{item.name}}
      </p>
      <span class="price">
        ￥{{item.price}}
      </span>
      <div class="item-num">
        <button class="minus" @click="deleteItems">
          -
        </button>
        <span class="item-num-value">{{item.count}}</span>
        <button class="add" @click="buyItems">
          +
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    item: {
      type: Object,
      required: true
    }
  },
  methods: {
    buyItems () {
      console.log(11111)
      this.$emit('alterItems', { id: this.item.id, num: 1 })
    },
    deleteItems () {
      this.$emit('alterItems', { id: this.item.id, num: -1 })
    }
  }
}
</script>

<style scoped>
.item {
  width: 100%;
  height: 200px;
  border: solid 1px black;
}
.item .item-img {
  border : solid 1px black;
  height: 150px;
  width: 150px;
  margin: 25px;
  position: absolute;
  left: 0px;
}

.item .item-info {
  position:absolute;
  right: 0px;
  margin: 25px;
  border : solid 1px black;
  width: calc(100% - 225px);
  height: 150px;
}

.item-info .item-name{
  position: absolute;
  left: 0px;
  top: 0px;
  margin: 25px;
  font-weight: 600;
  font-size: 20px;
}

.item-info .price{
  position: absolute;
  left: 0px;
  bottom: 0px;
  margin: 25px;
  color: red;
  font-weight: 500;
}

.item-info .item-num{
  position: absolute;
  right: 0px;
  bottom: 0px;
  margin: 25px;
  height:max-content;
  width: 100px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

</style>
