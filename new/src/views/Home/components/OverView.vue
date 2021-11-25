<template>
  <div class="overview">
    <ul>
      <li>
        <Icon class="icon" type="md-contacts" size="32" />
        <p>总户数</p>
        <p class="num">24,418</p>
      </li>
      <li>
        <Icon class="icon" type="ios-people" size="32" />
        <p>总人口数</p>
        <p class="num">324,368</p>
      </li>
      <li>
        <Icon class="icon" type="md-checkmark-circle-outline" size="32" />
        <p>预授信覆盖率</p>
        <p class="num">68%</p>
      </Col>
      <li>
        <Icon class="icon" type="md-card" size="32" />
        <p>用信覆盖率</p>
        <p class="num">47%</p>
      </li>
    </ul>
    <InMap class="map" />
  </div>
</template>

<script>
import InMap from '@/components/InMap'

export default {
  name: 'OverView',
  components: {
    InMap
  }
}
</script>

<style lang="scss" scoped>
.overview {
  ul {
    display: flex;
    width: 100%;
    text-align: center;
    background-color: #fff;
  }
  li {
    flex: 1;
    margin-left: 5px;
    padding-top: 10px;
    padding-bottom: 10px;
    font-size: 14px;
    background-color: #eee;
    list-style: none;
    &:first-child {
      margin-left: 0;
    }
    .icon {
      margin-bottom: 5px;
    }
    .num {
      font-size: 16px;
      font-weight: 500;
    }
  }
  .map {
    height: 342px;
    margin-top: 5px;
  }
}
</style>
