<script>
import axios from 'axios'
import { ElMessage, ElMessageBox } from 'element-plus'
import jwt from '@/utils/jwt'
export default {
  name: 'DepartmentPage',
  data() {
    return {
      depts: [],
      name: null
    }
  },
  methods: {
    async search() {
      const res = await axios({
        url: 'http://127.0.0.1:8080/dept/listDept',
        method: 'get'
      })
      this.depts = res.data.data
      console.log(this.depts)
    },
    newDept() {
      ElMessageBox.prompt('请输入部门名称', 'Tip', {
        confirmButtonText: 'OK',
        cancelButtonText: 'Cancel',
        inputPattern: /^[\u4e00-\u9fa5]{1,4}部/,
        inputErrorMessage: '部门名称不符合规范'
      }).then(({ value }) => {
        console.log(value)
        axios({
          url: 'http://127.0.0.1:8080/dept/newDept',
          method: 'post',
          data: {
            name: value
          }
        })
          .then(() => {
            ElMessage({
              type: 'success',
              message: '新建成功'
            })
            this.search()
          })
          .catch((error) => {
            console.log(error)
            alert(`新增数据失败,原因: ${error.message}`)
          })
      })
    },
    handleDelete(id) {
      ElMessageBox.confirm('是否确认删除?', 'Warning', {
        confirmButtonText: '是',
        cancelButtonText: '否',
        type: 'warning'
      })
        .then(() =>
          axios({
            url: `http://127.0.0.1:8080/dept/deleteDept/${this.depts[id].id}`,
            method: 'delete'
          })
            .then(() => {
              ElMessage({
                type: 'success',
                message: '删除成功'
              })
              this.search()
            })
            .catch((error) => {
              console.log(error)
              alert(`删除数据失败,原因: ${error.message}`)
            })
        )
        .catch((error) => {
          console.log(error)
          alert(`删除数据失败,原因: ${error.message}`)
        })
    },
    handleEdit(id) {
      ElMessageBox.prompt('请输入部门的全新名称', 'Tip', {
        confirmButtonText: 'OK',
        cancelButtonText: 'Cancel',
        inputPattern: /^[\u4e00-\u9fa5]{1,100}部/,
        inputErrorMessage: '部门名称不符合规范'
      })
        .then(({ value }) =>
          axios({
            url: `http://127.0.0.1:8080/dept/editDept/${this.depts[id].id}`,
            method: 'put',
            params: {
              name: value
            }
          })
            .then(() => {
              ElMessage({
                type: 'success',
                message: '编辑成功'
              })
              this.search()
            })
            .catch((error) => {
              console.log(error)
              alert(`编辑数据失败,原因: ${error.message}`)
            })
        )
        .catch((error) => {
          console.log(error)
          alert(`编辑数据失败,原因: ${error.message}`)
        })
    }
  },
  mounted() {
    this.search()
  },
  created() {
    jwt()
  }
}
</script>

<template>
  <div class="employers-page">
    <el-container direction="vertical">
      <el-button size="large" type="primary" @click="newDept()"
        >新增部门</el-button
      >
      <el-main>
        <el-scrollbar>
          <el-table :data="depts" max-height="880">
            <el-table-column prop="id" label="id" />
            <el-table-column prop="name" label="Name" />
            <el-table-column prop="createdTime" label="创建时间" />
            <el-table-column label="Operations">
              <template #default="scope">
                <el-button size="small" @click="handleEdit(scope.$index)">
                  Edit
                </el-button>
                <el-button
                  size="small"
                  type="danger"
                  @click="handleDelete(scope.$index)"
                >
                  Delete
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-scrollbar>
      </el-main>
    </el-container>
  </div>
</template>

<style lang="scss" scoped>
@import '../assets/base.scss';

.el-row {
  margin-bottom: 20px;
  border: 1px solid black;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
  border: 1px solid black;
}

.el-input .el-select {
  height: 100%;
}

.input-name {
  width: 20%;
  height: 100%;
  display: flex;
  flex-direction: row;
}

.input-gender {
  width: 20%;
  height: 100%;
  display: flex;
  flex-direction: row;
}

.header {
  display: flex;
  flex-direction: row;
}

.el-header {
  margin-top: 10px;
  border: 1px solid black;
}

.header-form {
  margin: 20px;
}
</style>
