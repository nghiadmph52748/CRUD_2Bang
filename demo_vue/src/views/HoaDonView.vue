<template>
  <HoaDonFormCpn v-model:newHoaDon="newHoaDon" />
  <router-link :to="{ name: 'add' }" v-if="!id">
    <button class="btn btn-success" @click="addHoaDon()">Add</button>
  </router-link>
  <router-link :to="{ name: 'update', params: { id: id } }" v-else>
    <button class="btn btn-primary" @click="updateHoaDon()">Update</button>
  </router-link>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>#</th>
        <th>Mã hóa đơn</th>
        <th>Ngày tạo</th>
        <th>Ngày thanh toán</th>
        <th>Ngày ship</th>
        <th>Ngày nhận</th>
        <th>Mã nhân viên</th>
        <th>Tên nhân viên</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(item, index) in lstHoaDon" :key="index">
        <td>{{ index + 1 }}</td>
        <td>{{ item.ma }}</td>
        <td>{{ item.ngayTao }}</td>
        <td>{{ item.ngayThanhToan }}</td>
        <td>{{ item.ngayShip }}</td>
        <td>{{ item.ngayNhan }}</td>
        <td>{{ item.maNhanVien }}</td>
        <td>{{ item.tenNhanVien }}</td>
        <td>
          <router-link :to="{ name: 'detail', params: { id: item.id } }">
            <button class="btn btn-primary" @click="detailHoaDon(item)">Detail</button>
          </router-link>
          <router-link :to="{ name: 'delete', params: { id: item.id } }">
            <button class="btn btn-danger" @click="deleteHoaDon(item)">Delete</button>
          </router-link>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script setup>
import HoaDonFormCpn from '@/components/HoaDonFormCpn.vue'
import {
  addHoaDonService,
  deleteHoaDonByIdService,
  getAllHoaDonService,
  getHoaDonByIdService,
  updateHoaDonService,
} from '@/service/HoaDonService'
import {  onMounted, ref } from 'vue'

const lstHoaDon = ref([])
const newHoaDon = ref({})
const id = ref(null)
const getAllHoaDon = async () => {
  try {
    const res = await getAllHoaDonService()
    lstHoaDon.value = res.data
  } catch (error) {
    console.log('getAll err' + error)
  }
}
const detailHoaDon = async (item) => {
  try {
    const res = await getHoaDonByIdService(item.id)
    newHoaDon.value = res.data
    id.value = item.id
    console.log('newHoaDon: ' + newHoaDon.value)
    console.log('i: ' + i.value)
  } catch (error) {
    console.log('getHoaDonById err' + error)
  }
}
const deleteHoaDon = async (item) => {
  try {
    await deleteHoaDonByIdService(item.id)
  } catch (error) {
    console.log('deleteHoaDon err' + error)
  }
}
const addHoaDon = async () => {
  try {
    await addHoaDonService(newHoaDon.value)
  } catch (error) {
    console.log('addHoaDon err' + error)
  }
}
const updateHoaDon = async () => {
  try {
    await updateHoaDonService(newHoaDon.value.id, newHoaDon.value)
  } catch (error) {
    console.log('updateHoaDon err' + error)
  }
}
onMounted(getAllHoaDon);
</script>

<style scoped></style>
