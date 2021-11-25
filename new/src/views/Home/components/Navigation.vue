<template>
  <div class="navigation">
    <div class="title"><span>营销活动管理</span></div>
    <ul>
      <li>
        <div class="icon">
          <Icon type="ios-bookmarks" size="32" />
        </div>
        <p>任务分配</p>
      </li>
      <li>
        <div class="icon">
          <Icon type="md-calendar" size="32" />
        </div>
        <p>活动进展</p>
      </li>
      <li>
        <div class="icon">
          <Icon type="md-people" size="32" />
        </div>
        <p>活动排名</p>
      </li>
      <li>
        <div class="icon">
          <Icon type="md-contacts" size="32" />
        </div>
        <p>精准营销</p>
      </li>
      <li>
        <div class="icon">
          <Icon type="ios-chatbubbles" size="32" />
        </div>
        <p>营销经验</p>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'Navigation'
}
</script>

<style lang="scss" scoped>
.navigation {
  .title {
    padding: 10px 20px;
    font-size: 18px;
    font-weight: 500;
    border-bottom: 1px solid #ddd;
  }
  ul {
    display: table;
    width: 100%;
    padding-top: 20px;
    padding-bottom: 20px;
    li {
      display: table-cell;
      text-align: center;
      &:hover {
        cursor: pointer;
        .icon {
          background-color: #eee;
        }
      }
      .icon {
        display: inline-block;
        width: 48px;
        height: 48px;
        margin-bottom: 10px;
        text-align: center;
        line-height: 48px;
        border: 1px solid #ddd;
        border-radius: 50%;
      }
    }
  }
}
</style>
