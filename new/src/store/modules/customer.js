import axios from '../axios'
import actions from '../action-types'
import mutations from '../mutation-types'

export default {
  state: {
    total: 0,
    list: [],
    person: {}
  },
  mutations: {
    [ mutations.RESIDENT_PERSON ] (state, payload) {
      state.person = payload.data
    },
    [ mutations.RESIDENT_LIST ] (state, payload) {
      state.total = payload.count
      state.list = payload.data
    }
  },
  actions: {
    [ actions.get.RESIDENT_LIST ] ({ commit }, payload) {
      return axios.get(`/resident/list?pageNum=${payload.pageNum}&pageSize=${payload.pageSize}`).then(({ data }) => {
        commit(mutations.RESIDENT_LIST, data)
      })
    },
    [ actions.get.RESIDENT_PERSON ] ({ commit }, id) {
      return axios.get('/resident/' + id).then(({ data }) => {
        commit(mutations.RESIDENT_PERSON, data)
      })
    },
    [ actions.post.RESIDENT_PERSON ] (context, payload) {
      return axios.post('/resident', payload)
    },
    [ actions.put.RESIDENT_PERSON ] (context, payload) {
      return axios.put('/resident/' + payload.residentId, payload)
    },
    [ actions.delete.RESIDENT_PERSON ] (context, id) {
      return axios.delete('/resident/' + id)
    }
  }
}
