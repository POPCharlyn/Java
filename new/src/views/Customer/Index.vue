<template>
  <div class="page">
    <div class="search">
      <Input v-model="search.keyword">
        <Select v-model="search.type" slot="prepend" style="width: 80px">
          <Option value="householdId">户号</Option>
          <Option value="name">姓名</Option>
          <Option value="idNumber">证件号</Option>
        </Select>
      </Input>
      <Button type="primary" icon="ios-search">查询</Button>
    </div>
    <div class="button-group">
      <Button class="create" to="/customer/add" type="primary" icon="ios-add">新建</Button>
    </div>
    <div class="table">
      <Table :columns="columns" :data="list"></Table>
    </div>
    <div class="pagination">
      <div class="text">共{{ total }}条记录 第 {{ pageNum }} / {{ Math.ceil(total / pageSize) }} 页</div>
      <Page class="pager" :current="pageNum" :page-size="pageSize" :total="total" @on-change="changePage" show-elevator />
    </div>
    <Modal
      v-model="model.show"
      width="320">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="ios-information-circle"></Icon>
        <span>你确定要删除这行内容么？</span>
      </p>
      <div style="text-align:center">
        <p>{{ model.content }}</p>
      </div>
      <div slot="footer">
        <Button type="error" size="large" long :loading="model.loading" @click="deleteUser">删除</Button>
      </div>
    </Modal>
    <Modal
      width="50%"
      v-model="detail.show"
      :footer-hide="true"
      title="客户详情">
      <table class="detail-table">
        <tr>
          <td width="15%">姓名：</td>
          <td width="35%">{{ person.residentName }}</td>
          <td width="18%">名族：</td>
          <td width="32%">{{ person.nation }}</td>
        </tr>
        <tr>
          <td>性别：</td>
          <td>{{ person.sex }}</td>
          <td>出生日期：</td>
          <td>{{ person.birthdate }}</td>
        </tr>
        <tr>
          <td>联系方式：</td>
          <td>{{ person.contact }}</td>
          <td>证件号码：</td>
          <td>{{ person.idNumber }}</td>
        </tr>
        <tr>
          <td>户别：</td>
          <td>{{ person.householdType }}</td>
          <td>户号：</td>
          <td>{{ person.householdId }}</td>
        </tr>
        <tr>
          <td>户主关系：</td>
          <td>{{ person.relationship }}</td>
          <td>纳入库名单：</td>
          <td>{{ person.isInList }}</td>
        </tr>
        <tr>
          <td>地址：</td>
          <td>{{ person.address }}</td>
          <td>备注：</td>
          <td>{{ person.remark }}</td>
        </tr>
      </table>
    </Modal>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import actions from '@/store/action-types'

export default {
  data () {
    return {
      pageNum: 1,
      pageSize: 5,
      model: {
        show: false,
        title: '你确定要删除这行内容么？',
        id: null,
        content: '',
        loading: false
      },
      detail: {
        show: false
      },
      search: {
        type: 'householdId',
        keyword: ''
      },
      columns: [
        {
          title: '姓名',
          key: 'residentName'
        },
        {
          title: '性别',
          key: 'sex'
        },
        {
          title: '民族',
          key: 'nation'
        },
        {
          title: '出生日期',
          key: 'birthdate'
        },
        {
          title: '联系方式',
          key: 'contact'
        },
        {
          title: '证件号',
          key: 'idNumber'
        },
        {
          title: '户号',
          key: 'householdId'
        },
        {
          title: '纳入库名单',
          key: 'isInList',
          align: 'center'
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          width: 200,
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'text',
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.show(params.row)
                  }
                }
              }, '查看'),
              /* h('Button', {
                props: {
                  type: 'text',
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.edit(params.row)
                  }
                }
              }, '编辑'), */
              h('Button', {
                props: {
                  type: 'text',
                  size: 'small'
                },
                on: {
                  click: () => {
                    this.delete(params.row)
                  }
                }
              }, '删除')
            ])
          }
        }
      ]
    }
  },
  computed: {
    ...mapState({
      list: state => state.customer.list,
      person: state => state.customer.person,
      total: state => state.customer.total
    })
  },
  mounted () {
    // 获取列表
    this.fetchList()
  },
  methods: {
    fetchList () {
      return this.$store.dispatch(actions.get.RESIDENT_LIST, {
        pageNum: this.pageNum,
        pageSize: this.pageSize
      })
    },
    changePage (num) {
      console.log(num)
      this.pageNum = num
      this.fetchList()
    },
    show (row) {
      this.$store.dispatch(actions.get.RESIDENT_PERSON, row.residentId)
      this.detail.show = true
    },
    edit () {
      console.log('edit')
    },
    delete (row) {
      this.model.data = row
      this.model.content = row.residentName
      this.model.id = row.residentId
      this.model.show = true
    },
    deleteUser () {
      this.model.loading = true
      setTimeout(() => {
        this.model.loading = false
        this.model.show = false
        console.log(this.model.id)
        this.$store.dispatch(actions.delete.RESIDENT_PERSON, this.model.id)
        this.$Message.success('删除成功')
      }, 2000)
    }
  }
}
</script>

<style lang="scss">
.page {
  margin: 20px;
  padding: 20px;
  background-color: #fff;
  border: 1px solid #eee;
  border-radius: 4px;
  .search {
    display: none;
    width: 500px;
    Button {
      margin-left: 10px;
    }
  }
  .button-group {
    margin-top: 20px;
    margin-bottom: 20px;
  }
  .table {
    margin-bottom: 20px;
    Button {
      color: cornflowerblue;
    }
  }
  .pagination {
    width: 100%;
    height: 32px;
    .text {
      float: left;
      line-height: 32px;
    }
    .pager {
      float: right;
    }
  }
}
.detail-table {
  width: 100%;
  font-size: 16px;
  line-height: 32px;
}
</style>
