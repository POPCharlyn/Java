<template>
  <div class="chart">
    <div class="title">
      <span>全行存贷款客户数</span>
      <div class="tabs">
        <span class="selected">月</span>
        <span>季</span>
        <span>年</span>
      </div>
    </div>
    <ve-histogram
      height="270px"
      :data="chartData"
      :settings="chartSettings"
      :grid="grid"
    ></ve-histogram>
  </div>
</template>

<script>
export default {
  name: 'HistogramChart',
  data () {
    return {
      chartSettings: {
        metrics: ['访问用户', '下单用户'],
        dimension: ['日期']
      },
      grid: {
        top: 40,
        bottom: 15
      },
      chartData: {
        columns: ['日期', '访问用户', '下单用户', '下单率'],
        rows: [
          { '日期': '1/1', '访问用户': 1393, '下单用户': 1093, '下单率': 0.32 },
          { '日期': '1/2', '访问用户': 3530, '下单用户': 3230, '下单率': 0.26 },
          { '日期': '1/3', '访问用户': 2923, '下单用户': 2623, '下单率': 0.76 },
          { '日期': '1/4', '访问用户': 1723, '下单用户': 1423, '下单率': 0.49 },
          { '日期': '1/5', '访问用户': 3792, '下单用户': 3492, '下单率': 0.323 },
          { '日期': '1/6', '访问用户': 4593, '下单用户': 4293, '下单率': 0.78 }
        ]
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.chart {
  .title {
    padding: 10px 20px;
    margin-bottom: 20px;
    font-size: 18px;
    font-weight: 500;
    border-bottom: 1px solid #ddd;
  }
  .tabs {
    float: right;
    display: table;
    width: 150px;
    height: 24px;
    font-size: 14px;
    font-weight: normal;
    line-height: 24px;
    text-align: center;
    border: 1px solid #ddd;
    border-radius: 4px;
    & > span {
      display: table-cell;
      border-right: 1px solid #ddd;
      &:last-child {
        border-right-width: 0;
      }
      &:hover {
        background-color: #eee;
        cursor: pointer;
      }
      &.selected {
        background-color: #eee;
      }
    }
  }
}
</style>
