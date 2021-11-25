<template>
  <div class="ranking">
    <Tabs value="branch">
      <TabPane label="支行业务排名" name="branch">
        <div class="subtabs">
          <ul>
            <li class="current">存款排名</li>
            <li>贷款排名</li>
            <li>授信率排名</li>
            <li>用信率排名</li>
            <li>用信提升率</li>
          </ul>
        </div>
        <div class="tabpane">
          <Table :columns="columns" :data="data"></Table>
        </div>
      </TabPane>
      <TabPane label="客户经理业务排名" name="salesperson">客户经理业务排名</TabPane>
    </Tabs>
  </div>
</template>

<script>
export default {
  data () {
    return {
      columns: [
        {
          title: 'Name',
          key: 'name',
          width: 150
        },
        {
          title: 'Age',
          key: 'age',
          sortable: true,
          width: 100
        },
        {
          title: 'Address',
          key: 'address'
        }
      ],
      data: [
        {
          name: 'John Brown',
          age: 18,
          address: 'New York No. 1 Lake Park',
          date: '2016-10-03'
        },
        {
          name: 'Jim Green',
          age: 24,
          address: 'London No. 1 Lake Park',
          date: '2016-10-01'
        },
        {
          name: 'Joe Black',
          age: 30,
          address: 'Sydney No. 1 Lake Park',
          date: '2016-10-02'
        },
        {
          name: 'Jon Snow',
          age: 26,
          address: 'Ottawa No. 2 Lake Park',
          date: '2016-10-04'
        },
        {
          name: 'Jim Green',
          age: 24,
          address: 'London No. 1 Lake Park',
          date: '2016-10-01'
        },
        {
          name: 'Joe Black',
          age: 30,
          address: 'Sydney No. 1 Lake Park',
          date: '2016-10-02'
        },
        {
          name: 'Jim Green',
          age: 24,
          address: 'London No. 1 Lake Park',
          date: '2016-10-01'
        },
        {
          name: 'Joe Black',
          age: 30,
          address: 'Sydney No. 1 Lake Park',
          date: '2016-10-02'
        }
      ]
    }
  }
}
</script>

<style lang="scss">
.ranking {
  height: 510px;
  .ivu-tabs-bar {
    margin-bottom: 0;
  }
  .ivu-tabs-tab {
    height: 36px;
    line-height: 36px;
  }
  .subtabs {
    ul {
      display: flex;
      width: 100%;
      border-bottom: 1px solid #ddd;
      li {
        flex: 1;
        list-style: none;
        line-height: 36px;
        text-align: center;
        border-left: 1px solid #ddd;
        &:first-child {
          border-left-width: 0;
        }
        &:hover,
        &.current {
          background-color: #eee;
          cursor: pointer;
        }
      }
    }
  }
}
</style>
