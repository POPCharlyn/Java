<template>
  <div class="layout">
    <Row :gutter="10">
      <Col span="8">
        <Card class="card" :bordered="false" :padding="0">
          <OverView />
        </Card>
        <Card class="card" :bordered="false" :padding="0">
          <Information :title="deposit.title" :list="deposit.list" />
        </Card>
      </Col>
      <Col span="8">
        <Card class="card" :bordered="false" :padding="0">
          <LineChart />
        </Card>
        <Card class="card" :bordered="false" :padding="0">
          <HistogramChart />
        </Card>
      </Col>
      <Col span="8">
        <Card class="card" :bordered="false" :padding="0">
          <Navigation />
        </Card>
        <Card class="card" :bordered="false" :padding="0">
          <Ranking />
        </Card>
      </Col>
    </Row>
  </div>
</template>

<script>
import OverView from './components/OverView'
import Information from './components/Information'
import LineChart from './components/LineChart'
import HistogramChart from './components/HistogramChart'
import Navigation from './components/Navigation'
import Ranking from './components/Ranking'

export default {
  name: 'Home',
  data () {
    return {
      deposit: {
        title: '全行存款重点客户异动提示',
        list: [
          {
            id: 123,
            title: '客户张铁林，在瑞泉阳光支行取出200万元。',
            date: '2018-8-14'
          },
          {
            id: 124,
            title: '客户张铁林，在瑞泉阳光支行取出200万元。',
            date: '2018-8-14'
          },
          {
            id: 125,
            title: '客户张铁林，在瑞泉阳光支行取出200万元。',
            date: '2018-8-14'
          },
          {
            id: 126,
            title: '客户张铁林，在瑞泉阳光支行取出200万元。',
            date: '2018-8-14'
          },
          {
            id: 127,
            title: '客户张铁林，在瑞泉阳光支行取出200万元。',
            date: '2018-8-14'
          }
        ]
      }
    }
  },
  components: {
    OverView,
    Information,
    LineChart,
    HistogramChart,
    Navigation,
    Ranking
  }
}
</script>

<style lang="scss" scoped>
.layout {
  padding: 20px;
  .card {
    margin-top: 15px;
    border-radius: 0;
    &:first-child {
      margin-top: 0;
    }
  }
}
</style>
