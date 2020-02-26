import request from '@/utils/request';

export async function queryRule(params) {
  return new Promise((resolve, reject) => {
    request('/alarm/query', {
      method: 'POST',
      data: { ...params, pageNum: params.current },
    })
      .then(data => {
        resolve(parsePagedData(data));
      })
      .catch(err => {
        reject(err);
      });
  });
}

function parsePagedData(data) {
  const pagedData = {};
  pagedData.current = data.data.pageNum;
  pagedData.pageSize = data.data.pageSize;
  pagedData.total = data.data.total;
  pagedData.success = data.success;
  pagedData.data = data.data.data;
  return pagedData;
}

export async function addRule(params) {
  return request('/alarm/insert', {
    method: 'POST',
    data: { ...params },
  });
}

export async function updateRule(params) {
  return request(`/alarm/${params.id}`, {
    method: 'PUT',
    data: { ...params },
  });
}

export async function deleteAlarm(id) {
  return request(`/alarm/${id}`, {
    method: 'DELETE',
  });
}

export async function changeStatus(id, status) {
  return request(`/alarm/${id}`, {
    method: 'PUT',
    data: { status },
  });
}
