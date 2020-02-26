import { PlusOutlined } from '@ant-design/icons';
import { Form } from '@ant-design/compatible';
import '@ant-design/compatible/assets/index.css';
import { Button, Divider, message, Popconfirm, Switch } from 'antd';
import React, { useRef, useState } from 'react';
import { PageHeaderWrapper } from '@ant-design/pro-layout';
import ProTable from '@ant-design/pro-table';
import CreateForm from './components/CreateForm';
import UpdateForm from './components/UpdateForm';
import { addRule, changeStatus, deleteAlarm, queryRule, updateRule } from './service';
import styles from './style.less';

/**
 * 添加节点
 * @param fields
 */
const handleAdd = async fields => {
  const hide = message.loading('正在添加');

  try {
    await addRule(fields);
    hide();
    message.success('添加成功');
    return true;
  } catch (error) {
    hide();
    message.error('添加失败请重试！');
    return false;
  }
};

/**
 * 更新节点
 * @param fields
 */
const handleUpdate = async fields => {
  const hide = message.loading('正在修改');

  try {
    await updateRule(fields);
    hide();
    message.success('修改成功');
    return true;
  } catch (error) {
    hide();
    message.error('修改失败请重试！');
    return false;
  }
};

const handleDelete = async id => {
  try {
    await deleteAlarm(id);
    message.success('删除成功');
  } catch (error) {
    message.error('删除失败');
  }
};

const handleChangeStatus = async (id, status) => {
  try {
    await changeStatus(id, status);
  } catch (error) {
    message.error('更新状态失败');
  }
};

const TableList = () => {
  const [createModalVisible, handleModalVisible] = useState(false);
  const [updateModalVisible, handleUpdateModalVisible] = useState(false);
  const [updateFormValues, setUpdateFormValues] = useState({});
  const actionRef = useRef();
  const columns = [
    {
      title: '创建时间',
      dataIndex: 'gmtCreate',
      hideInSearch: true,
    },
    {
      title: '组别',
      dataIndex: 'groups',
    },
    {
      title: 'code',
      dataIndex: 'code',
    },
    {
      title: '名称',
      dataIndex: 'name',
    },
    {
      title: '描述',
      dataIndex: 'description',
      hideInSearch: true,
    },
    {
      title: '表达式',
      dataIndex: 'expression',
      hideInSearch: true,
    },
    {
      title: '规则',
      dataIndex: 'rule',
      hideInSearch: true,
    },
    {
      title: '报警间隔秒数',
      dataIndex: 'intervalSeconds',
      hideInSearch: true,
    },
    {
      title: '状态',
      dataIndex: 'status',
      valueEnum: {
        1: {
          text: '关闭',
          status: 'Default',
        },
        2: {
          text: '开启',
          status: 'Processing',
        },
      },
      render: (_, record) => (
        <Switch
          checked={record.status === 2}
          onChange={checked => {
            handleChangeStatus(record.id, checked ? 2 : 1).then(() => {});
          }}
        />
      ),
    },
    {
      title: '操作',
      dataIndex: 'option',
      valueType: 'option',
      render: (_, record) => (
        <>
          <a
            onClick={() => {
              handleUpdateModalVisible(true);
              setUpdateFormValues(record);
            }}
          >
            修改
          </a>
          <Divider type="vertical" />
          <Popconfirm
            title="确认删除？"
            onConfirm={() => {
              handleDelete(record.id).then(() => {});
            }}
            onCancel={null}
            okText="确认"
            cancelText="取消"
          >
            <a className={styles.redColor}>删除</a>
          </Popconfirm>
        </>
      ),
    },
  ];
  return (
    <PageHeaderWrapper>
      <ProTable
        headerTitle="查询表格"
        actionRef={actionRef}
        rowKey="key"
        toolBarRender={() => [
          <Button icon={<PlusOutlined />} type="primary" onClick={() => handleModalVisible(true)}>
            新建
          </Button>,
        ]}
        tableAlertRender={false}
        request={params => queryRule(params)}
        columns={columns}
      />
      <CreateForm
        onSubmit={async value => {
          const success = await handleAdd(value);

          if (success) {
            handleModalVisible(false);

            if (actionRef.current) {
              actionRef.current.reload();
            }
          }
        }}
        onCancel={() => handleModalVisible(false)}
        modalVisible={createModalVisible}
      />
      {updateFormValues && Object.keys(updateFormValues).length ? (
        <UpdateForm
          onSubmit={async value => {
            const success = await handleUpdate(value);

            if (success) {
              handleModalVisible(false);
              setUpdateFormValues({});

              if (actionRef.current) {
                actionRef.current.reload();
              }
            }
          }}
          onCancel={() => {
            handleUpdateModalVisible(false);
            setUpdateFormValues({});
          }}
          updateModalVisible={updateModalVisible}
          values={updateFormValues}
        />
      ) : null}
    </PageHeaderWrapper>
  );
};

export default Form.create()(TableList);
