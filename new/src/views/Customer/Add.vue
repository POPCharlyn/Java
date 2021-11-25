<template>
  <div class="form">
    <Form :model="form" :rules="ruleValidate" label-position="top">
      <Row>
        <Col span="8">
          <FormItem label="姓名" prop="residentName">
            <Input v-model="form.residentName" placeholder="请输入姓名"></Input>
          </FormItem>
        </Col>
        <Col span="8">
          <FormItem label="民族" prop="nation">
            <Input v-model="form.nation" placeholder="请输入民族"></Input>
          </FormItem>
        </Col>
        <Col span="8">
          <FormItem label="性别" prop="sex">
            <RadioGroup v-model="form.sex">
              <Radio label="男">男</Radio>
              <Radio label="女">女</Radio>
            </RadioGroup>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="8">
          <FormItem label="出生日期">
            <DatePicker type="date" prop="birthdate" placeholder="请输入出生日期" v-model="form.birthdate"></DatePicker>
          </FormItem>
        </Col>
        <Col span="8">
          <FormItem label="证件号码" prop="idNumber">
            <Input v-model="form.idNumber" placeholder="请输入证件号码"></Input>
          </FormItem>
        </Col>
        <Col span="8">
          <FormItem label="联系方式" prop="contact">
            <Input v-model="form.contact" placeholder="请输入联系方式"></Input>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="8">
          <FormItem label="户别" prop="householdType">
            <Input v-model="form.householdType" placeholder="请输入出生户别"></Input>
          </FormItem>
        </Col>
        <Col span="8">
          <FormItem label="户号" prop="householdId">
            <Input v-model="form.householdId" placeholder="请输入户号"></Input>
          </FormItem>
        </Col>
        <Col span="8">
          <FormItem label="户主关系" prop="relationship">
            <Input v-model="form.relationship" placeholder="请输入户主关系"></Input>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="8">
          <FormItem label="纳入库名单" prop="isInList">
            <RadioGroup v-model="form.isInList">
              <Radio label="是">是</Radio>
              <Radio label="否">否</Radio>
            </RadioGroup>
          </FormItem>
        </Col>
        <Col span="8">
          <FormItem label="地址" prop="address">
            <Input v-model="form.address" placeholder="请输入地址"></Input>
          </FormItem>
        </Col>
      </Row>
      <Row>
        <Col span="8">
          <FormItem label="备注">
            <Input v-model="form.remark" type="textarea" :rows="2" placeholder="请输入备注..." />
          </FormItem>
        </Col>
      </Row>
      <FormItem>
        <Button type="primary" @click="handleSubmit('form')">提交</Button>
        <Button to="/customer" style="margin-left: 8px">取消</Button>
      </FormItem>
    </Form>
  </div>
</template>

<script>
import actions from '@/store/action-types'

export default {
  data () {
    return {
      form: {},
      ruleValidate: {
        residentName: [
          { required: true, message: '姓名不能为空', trigger: 'blur' }
        ],
        nation: [
          { required: true, message: '民族不能为空', trigger: 'blur' }
        ],
        sex: [
          { required: true, message: '性别不能为空', trigger: 'blur' }
        ],
        birthdate: [
          { required: true, message: '出生日期不能为空', trigger: 'blur' }
        ],
        idNumber: [
          { required: true, message: '证件号码不能为空', trigger: 'blur' }
        ],
        contact: [
          { required: true, message: '联系方式不能为空', trigger: 'blur' }
        ],
        householdType: [
          { required: true, message: '户别不能为空', trigger: 'blur' }
        ],
        householdId: [
          { required: true, message: '户号不能为空', trigger: 'blur' }
        ],
        relationship: [
          { required: true, message: '户主关系不能为空', trigger: 'blur' }
        ],
        isInList: [
          { required: true, message: '纳入库名单不能为空', trigger: 'blur' }
        ],
        address: [
          { required: true, message: '地址不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    handleSubmit (name) {
      const payload = { ...this[name] }
      const date = new Date(payload.birthdate)
      const month = date.getMonth() + 1
      const day = date.getDate()
      payload.birthdate = `${date.getFullYear()}-${month >= 10 ? month : '0' + month}-${day >= 10 ? day : '0' + day}`
      this.$store.dispatch(actions.post.RESIDENT_PERSON, payload)
    }
  }
}
</script>

<style lang="scss">
.form {
  margin: 20px;
  padding: 20px;
  background-color: #fff;
  Input {
    width: 320px;
  }
  .ivu-form-item-label {
    font-size: 16px;
  }
  .ivu-radio-group-item {
    font-size: 16px;
  }
}
</style>
