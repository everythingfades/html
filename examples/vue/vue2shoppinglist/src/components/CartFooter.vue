<template>
  <div class="footer">
    <div class="checkout">
      <span>共{{totalNum}}件商品,合计:</span>
      <span class="total-price-value">￥{{totalPrice}}</span>
      <button class="checkout-button">
        结算
      </button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    totalNum: Number,
    totalPrice: Number
  }
}
</script>

<style scoped>
.footer{
  position: fixed;
  height: 100px;
  width: 100%;
  bottom: 0px;
  left: 0px;
  border: solid 1px black;
  vertical-align: middle;
  line-height: 100px;
}

.checkout .total-price-value{
  font-weight: 600;
  color: red;
}

.checkout {
  position: absolute;
  right: 0px;
  margin: 10px;
  display: block;
}

.checkout .checkout-button {
  height: 40px;
  width: 100px;
  text-align: center;
  background-color: rgb(107,142,35);
  color: white;
  border-radius: 10px;
  margin: 10px;
}
</style>
