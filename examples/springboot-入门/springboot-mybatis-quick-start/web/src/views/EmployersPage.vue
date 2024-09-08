<script>
import axios from 'axios'
import jwt from '@/utils/jwt'
export default {
  name: 'EmployersPage',
  data() {
    return {
      employers: [],
      searchParams: {
        name: null,
        gender: -1,
        dateRange: [null, null],
        page: 1,
        pageSize: 50,
        total: 50
      },
      size: 'large',
      dialogFormVisible: false,
      formParams: {
        name: '',
        gender: 0,
        entrydate: '2020-01-01',
        job: 0,
        image: '',
        username: '',
        password: '',
        deptId: 0
      },
      formRules: {
        name: [
          {
            required: true,
            message: '请输入员工名称',
            trigger: 'blur'
          },
          {
            min: 1,
            max: 5,
            message: '长度应该在1到5个字符之间',
            trigger: 'blur'
          }
        ],
        entrydate: [
          {
            required: true,
            message: '请选择员工入职时间',
            trigger: 'change'
          }
        ],
        image: [
          {
            required: true,
            message: '请上传员工头像',
            trigger: 'change'
          },
          {
            validator: (rule, value, callback) => {
              const suffix = value.substring(value.lastIndexOf('.'))
              if (suffix != '.jpg') {
                callback(new Error('只支持.jpg格式'))
              }
              callback()
            },
            trigger: ['blur', 'change']
          }
        ],
        username: [
          {
            required: true,
            message: '请输入员工账号',
            trigger: 'blur'
          },
          {
            min: 1,
            max: 20,
            message: '长度应该在1到20个字符之间',
            trigger: 'blur'
          }
        ],
        password: [
          {
            required: true,
            message: '请输入员工性别',
            trigger: ['blur', 'change']
          },
          {
            min: 1,
            max: 16,
            message: '长度应该在1到16个字符之间'
          }
        ],
        job: [
          {
            required: true,
            message: '请选择岗位',
            trigger: ['blur', 'change']
          }
        ],
        dept_id: [
          {
            required: true,
            message: '请选择部门',
            trigger: ['blur', 'change']
          }
        ],
        gender: [
          {
            required: true,
            message: '请选择性别',
            trigger: ['blur', 'change']
          }
        ]
      }
    }
  },
  methods: {
    async search() {
      // console.log(this.searchParams.page, this.searchParams.pageSize)
      const params = {
        name: this.searchParams.name,
        gender: parseInt(this.searchParams.gender),
        begin: this.searchParams.dateRange[0],
        end: this.searchParams.dateRange[1],
        page: this.searchParams.page,
        pageSize: this.searchParams.pageSize
      }
      for (let i of Object.keys(params)) {
        if (params[i] === null || params[i] === -1) {
          delete params[i]
        }
      }
      console.log(params)
      await axios({
        url: 'http://127.0.0.1:8080/employer/listEmployersConditionalWithPage',
        method: 'get',
        params: params
        // params: {
        //   name: this.name,
        //   gender: parseInt(this.gender),
        //   begin: this.dateRange[0],
        //   end: this.dateRange[1],
        //   page: this.page,
        //   pageSize: this.pageSize
        // }
        // headers: {
        //   'Content-Type': 'application/json'
        // },
        // data: {
        //   begin: '2000-01-01',
        //   end: '2030-01-01'
        // }
      })
        .then((res) => {
          this.employers = res.data.data.rows
          this.searchParams.total = res.data.data.total
        })
        .catch((error) => {
          console.log(error)
          alert('还未登录,被springboot的拦截器拦截')
        })
      console.log(this.employers)
    },
    async handleSizeChange(val) {
      this.searchParams.pageSize = val
      await this.search()
    },
    async handleCurrentChange(val) {
      this.searchParams.page = val
      await this.search()
    },
    async handleDelete(index) {
      await axios({
        url: `http://127.0.0.1:8080/employer/deleteEmployer/${this.employers[index].id}`,
        method: 'delete'
      })
      this.search()
    },
    async newEmployer() {
      await axios({
        url: 'http://127.0.0.1:8080/employer/newEmployer',
        method: 'put',
        data: this.formParams
      })
      this.dialogFormVisible = false
    },
    processGender(row, column, cellValue) {
      if (cellValue == 1) {
        return '男'
      } else {
        return '女'
      }
    },
    processJob(row, column, cellValue) {
      cellValue = parseInt(cellValue)
      // console.log(cellValue)
      if (cellValue == 0) {
        return '数学'
      } else if (cellValue == 1) {
        return '语文'
      } else if (cellValue == 2) {
        return '英语'
      } else if (cellValue == 3) {
        return '物理'
      } else {
        return '化学'
      }
    },
    processDept(row, column, cellValue) {
      cellValue = parseInt(cellValue)
      // console.log(cellValue)
      if (cellValue == 0) {
        return '幼儿园'
      } else if (cellValue == 1) {
        return '小学'
      } else if (cellValue == 2) {
        return '初中'
      } else if (cellValue == 3) {
        return '高中'
      } else {
        return '大学'
      }
    }
  },
  mounted() {
    this.search()
  },
  created() {
    jwt()
  },
  beforeCreate() {
    // beforeCreate 的时候还没有identifyJwt,也没有localStorage
    // this.identifyJwt()
  }
}
</script>

<template>
  <div class="employers-page">
    <el-container direction="vertical">
      <el-form class="header-form">
        <el-row :gutter="24">
          <el-col :span="4">
            <el-form-item label="姓名">
              <el-input
                v-model="searchParams.name"
                placeholder="输入姓名"
                clearable
              />
            </el-form-item>
          </el-col>
          <el-col :span="3">
            <el-form-item label="性别">
              <el-select v-model="searchParams.gender" placeholder="选择性别">
                <el-option label="-" :value="-1" />
                <el-option label="女" :value="0" />
                <el-option label="男" :value="1" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="11">
            <el-form-item label="入职日期">
              <el-date-picker
                type="daterange"
                unlink-panels
                v-model="searchParams.dateRange"
                start-placeholder="Start date"
                end-placeholder="End date"
              />
            </el-form-item>
          </el-col>
          <el-col :span="2">
            <el-form-item>
              <el-button type="primary" @click="search">提交</el-button>
            </el-form-item>
          </el-col>
          <el-col :span="2">
            <el-form-item>
              <el-button type="info">清空</el-button>
            </el-form-item>
          </el-col>
          <el-col :span="2">
            <el-form-item>
              <el-button type="success" @click="dialogFormVisible = true"
                >新增</el-button
              >
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <el-main>
        <el-scrollbar>
          <el-table :data="employers" max-height="880">
            <el-table-column prop="id" label="id" />
            <!-- <el-table-column prop="username" label="用户名" /> -->
            <!-- <el-table-column prop="password" label="密码(默认123456)" /> -->
            <el-table-column prop="name" label="Name" />
            <el-table-column prop="image" label="图片" />
            <el-table-column prop="job" label="职务" :formatter="processJob" />
            <el-table-column
              prop="deptId"
              label="部门"
              :formatter="processDept"
            />
            <el-table-column prop="entrydate" label="入职时间" />
            <el-table-column prop="createdTime" label="创建时间" />
            <el-table-column prop="alteredTime" label="修改时间" />
            <el-table-column
              label="性别"
              prop="gender"
              :formatter="processGender"
            >
            </el-table-column>
            <el-table-column label="Operations">
              <template #default="scope">
                <el-button
                  size="small"
                  @click="handleEdit(scope.$index, scope.row)"
                >
                  Edit
                </el-button>
                <el-popconfirm
                  confirm-button-text="Yes"
                  cancel-button-text="No"
                  icon-color="#626AEF"
                  title="Are you sure to delete this?"
                  @confirm="handleDelete(scope.$index, scope.row)"
                >
                  <template #reference>
                    <el-button size="small" type="danger"> Delete </el-button>
                  </template>
                </el-popconfirm>
              </template>
            </el-table-column>
          </el-table>
        </el-scrollbar>
      </el-main>
    </el-container>
    <div class="pagination">
      <el-pagination
        :page-size="searchParams.pageSize"
        layout="total, sizes, prev, pager, next"
        :total="searchParams.total"
        :page-sizes="[100, 200, 300, 400]"
        v-model:current-page="searchParams.page"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </div>
    <el-dialog v-model="dialogFormVisible" title="Shipping address" width="500">
      <el-form class="header-form" :model="formParams" v-model="formParams">
        <el-form-item label="用户名" :rules="formRules.username">
          <el-input
            v-model="formParams.username"
            placeholder="输入用户名"
            clearable
          />
        </el-form-item>
        <el-form-item label="密码" :rules="formRules.password">
          <el-input
            type="password"
            v-model="formParams.password"
            placeholder="输入密码"
            clearable
          />
        </el-form-item>
        <el-form-item label="姓名" :rules="formRules.name">
          <el-input
            v-model="formParams.name"
            placeholder="输入姓名"
            clearable
          />
        </el-form-item>
        <el-form-item label="性别" :rules="formRules.gender">
          <el-select v-model="formParams.gender" placeholder="选择性别">
            <el-option label="女" :value="0" />
            <el-option label="男" :value="1" />
          </el-select>
        </el-form-item>
        <el-form-item label="职务" :rules="formRules.job">
          <el-select v-model="formParams.job" placeholder="选择职务">
            <el-option label="数学" :value="0" />
            <el-option label="语文" :value="1" />
            <el-option label="英语" :value="2" />
            <el-option label="物理" :value="3" />
            <el-option label="化学" :value="4" />
          </el-select>
        </el-form-item>
        <el-form-item label="部门" :rules="formRules.dept_id">
          <el-select v-model="formParams.dept_id" placeholder="选择部门">
            <el-option label="幼儿园" :value="0" />
            <el-option label="小学" :value="1" />
            <el-option label="初中" :value="2" />
            <el-option label="高中" :value="3" />
            <el-option label="大学" :value="4" />
          </el-select>
        </el-form-item>
        <el-form-item label="入职日期" :rules="formRules.entrydate">
          <el-date-picker
            type="date"
            v-model="formParams.entrydate"
            start-placeholder="Start date"
          />
        </el-form-item>
        <el-form-item label="头像" :rules="formRules.image">
          <el-input
            v-model="formParams.image"
            placeholder="输入图片url\base64"
            clearable
          />
        </el-form-item>
      </el-form>
      <el-row :gutter="20">
        <el-col :span="16"> </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="newEmployer()"> 提交 </el-button>
        </el-col>
        <el-col :span="4">
          <el-button type="info" @click="dialogFormVisible = false">
            取消
          </el-button>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<style lang="scss" scoped>
@import '../assets/base.scss';

.el-row {
  margin-bottom: 20px;
  // border: 1px solid black;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
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
  width: 50%;
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

.pagination {
  position: fixed;
  margin-bottom: 10px;
  left: 50%;
  width: 100%;
}
</style>
