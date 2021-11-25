const actions = {}
const actionList = {
  get: ['RESIDENT_LIST', 'RESIDENT_PERSON'],
  post: ['RESIDENT_PERSON'],
  put: ['RESIDENT_PERSON'],
  delete: ['RESIDENT_PERSON']
}

Object.keys(actionList).forEach(method => {
  actionList[method].forEach(key => {
    if (!(method in actions)) {
      actions[method] = {}
    }
    actions[method][key] = `${method.toUpperCase()}_${key.toUpperCase()}`
  })
})

export default actions
