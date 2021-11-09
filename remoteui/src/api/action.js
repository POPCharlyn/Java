import request from '@/libs/request'

/**
 * 获取菜单下操作列表
 * @param menuId
 */
export const getActionsByMenu = (menuId) => {
  const params = { menuId: menuId }
  return request({
    url: 'menu/action',
    params,
    method: 'get'
  })
}

/**
 * 添加操作
 * @param actionCode
 * @param actionName
 * @param menuId
 * @param apiId
 * @param status
 * @param priority
 * @param actionDesc
 */
export const addAction = ({ actionCode, actionName, menuId, status, priority, actionDesc }) => {
  const data = {
    actionCode: actionCode,
    actionName: actionName,
    menuId: menuId,
    status: status,
    priority: priority,
    actionDesc: actionDesc
  }
  return request({
    url: 'action/add',
    data,
    method: 'post'
  })
}

/**
 * 更新操作
 * @param actionId
 * @param actionCode
 * @param actionName
 * @param menuId
 * @param apiId
 * @param status
 * @param priority
 * @param actionDesc
 */
export const updateAction = ({ actionId, actionCode, actionName, menuId, status, priority, actionDesc }) => {
  const data = {
    actionId: actionId,
    actionCode: actionCode,
    actionName: actionName,
    menuId: menuId,
    status: status,
    priority: priority,
    actionDesc: actionDesc
  }
  return request({
    url: 'action/update',
    data,
    method: 'post'
  })
}

/**
 * 删除操作
 * @param actionId
 */
export const removeAction = (actionId) => {
  const data = {
    appId: actionId
  }
  return request({
    url: 'app/remove',
    data,
    method: 'post'
  })
}
