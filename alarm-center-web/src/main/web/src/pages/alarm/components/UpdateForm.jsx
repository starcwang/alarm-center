import { Form } from '@ant-design/compatible';
import '@ant-design/compatible/assets/index.css';
import { Input, InputNumber, Modal } from 'antd';
import React from 'react';
import styles from '@/pages/alarm/style.less';

const FormItem = Form.Item;

const UpdateForm = props => {
  const { modalVisible, form, onSubmit: handleUpdate, onCancel, values } = props;

  const okHandle = () => {
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      form.resetFields();
      handleUpdate(fieldsValue);
    });
  };

  return (
    <Modal
      destroyOnClose
      title="新建报警规则"
      visible={modalVisible}
      onOk={okHandle}
      onCancel={() => onCancel()}
    >
      <FormItem
        labelCol={{
          span: 5,
        }}
        wrapperCol={{
          span: 15,
        }}
        label="组别"
      >
        {form.getFieldDecorator('groups', {
          initialValue: values.groups,
          rules: [
            {
              required: true,
              message: '请输入组别！',
              min: 1,
            },
          ],
        })(<Input placeholder="组别" />)}
      </FormItem>
      <FormItem
        labelCol={{
          span: 5,
        }}
        wrapperCol={{
          span: 15,
        }}
        label="code"
      >
        {form.getFieldDecorator('code', {
          initialValue: values.code,
          rules: [
            {
              required: true,
              message: '请输入code！',
              min: 1,
            },
          ],
        })(<Input placeholder="code" />)}
      </FormItem>
      <FormItem
        labelCol={{
          span: 5,
        }}
        wrapperCol={{
          span: 15,
        }}
        label="名称"
      >
        {form.getFieldDecorator('name', {
          initialValue: values.name,
          rules: [
            {
              required: true,
              message: '请输入名称！',
              min: 1,
            },
          ],
        })(<Input placeholder="名称" />)}
      </FormItem>
      <FormItem
        labelCol={{
          span: 5,
        }}
        wrapperCol={{
          span: 15,
        }}
        label="描述"
      >
        {form.getFieldDecorator('description', {
          initialValue: values.description,
          rules: [
            {
              required: false,
              message: '请输入描述！',
            },
          ],
        })(<Input.TextArea rows={1} placeholder="描述" />)}
      </FormItem>
      <FormItem
        labelCol={{
          span: 5,
        }}
        wrapperCol={{
          span: 15,
        }}
        label="js表达式"
      >
        {form.getFieldDecorator('expression', {
          initialValue: values.expression,
          rules: [
            {
              required: false,
              message: '请输入表达式！',
            },
          ],
        })(<Input.TextArea rows={1} placeholder="js表达式" />)}
      </FormItem>
      <FormItem
        labelCol={{
          span: 5,
        }}
        wrapperCol={{
          span: 15,
        }}
        label="报警触发规则"
      >
        {form.getFieldDecorator('rule', {
          initialValue: values.rule,
          rules: [
            {
              required: true,
              message: '请输入正确的报警触发规则！',
              pattern: '^[1-9]\\d*->[1-9]\\d*[dhms]$',
            },
          ],
        })(<Input placeholder="报警触发规则" />)}
      </FormItem>
      <FormItem
        labelCol={{
          span: 5,
        }}
        wrapperCol={{
          span: 15,
        }}
        label="报警间隔秒数"
      >
        {form.getFieldDecorator('intervalSeconds', {
          initialValue: values.intervalSeconds,
          rules: [
            {
              required: true,
              message: '请输入报警间隔秒数！',
            },
          ],
        })(<InputNumber className={styles.width100} min={1} placeholder="报警间隔秒数" />)}
      </FormItem>
    </Modal>
  );
};

export default Form.create()(UpdateForm);
