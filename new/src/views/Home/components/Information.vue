<template>
  <div class="information">
    <div class="title"><p>{{ title }}</p></div>
    <ul>
      <li v-for="item in list" :key="item.id">
        <p>* {{ item.title }}<span>{{ item.date }}</span></p>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'Information',
  props: ['title', 'list']
}
</script>

<style lang="scss" scoped>
.information {
  .title {
    padding: 10px 20px;
    font-size: 18px;
    font-weight: 500;
    border-bottom: 1px solid #ddd;
  }
  ul {
    padding: 10px 20px;
  }
  li {
    font-size: 14px;
    line-height: 32px;
    list-style: none;
    span {
      float: right;
    }
  }
}
</style>
