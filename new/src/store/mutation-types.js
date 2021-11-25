const mutations = {}
const mutationList = ['RESIDENT_LIST', 'RESIDENT_PERSON']

mutationList.forEach(key => {
  mutations[key] = `UPDATE_${key.toUpperCase()}`
})

export default mutations
