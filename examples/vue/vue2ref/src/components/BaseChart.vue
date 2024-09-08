<template>
  <div ref="myChart" class="base-chart-box">
    
  </div>
</template>

<script>
import * as echarts from 'echarts';
export default {
  mounted(){
      // console.log(this.graphData)
      // this.myChart = echarts.init(document.querySelector(".base-chart-box"));4
      this.myChart = echarts.init(this.$refs.myChart)
      this.option = {
          tooltip: {
              trigger: 'item'
          },
          legend: {
              top: '5%',
              left: 'center'
          },
          series: [{
              name: 'Access From',
              type: 'pie',
              radius: ['40%', '70%'],
              avoidLabelOverlap: false,
              itemStyle: {
                  borderRadius: 10,
                  borderColor: '#fff',
                  borderWidth: 2
              },
              label: {
                  show: false,
                  position: 'center'
              },
              emphasis: {
                  label: {
                      show: true,
                      fontSize: 40,
                      fontWeight: 'bold'
                  }
              },
              labelLine: {
                  show: false
              },
              data: [
                  { value: 1048, name: 'Search Engine' },
                  { value: 735, name: 'Direct' },
                  { value: 580, name: 'Email' },
                  { value: 484, name: 'Union Ads' },
                  { value: 300, name: 'Video Ads' }
              ]
          }]
      }
      // console.log(this.myChart)
      this.myChart.setOption(this.option)
  },
}
</script>

<style>
.base-chart-box{
  height: 400px;
  width: 600px;
}
</style>