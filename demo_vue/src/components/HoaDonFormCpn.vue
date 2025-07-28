<template>
  <form action="">
    <div class="form-group">
      <label for="ma">Mã hóa đơn:</label>
      <input type="text" class="form-control" id="ma" v-model="newHoaDon.ma" />
    </div>
    <div class="form-group">
        <label for="ngayTao">Ngày tạo:</label>
        <input type="date" class="form-control" id="ngayTao" v-model="newHoaDon.ngayTao" />
    </div>
    <div class="form-group">
        <label for="ngayThanhToan">Ngày thanh toán:</label>
        <input type="date" class="form-control" id="ngayThanhToan" v-model="newHoaDon.ngayThanhToan" />
    </div>
    <div class="form-group">
        <label for="ngayShip">Ngày ship:</label>
        <input type="date" class="form-control" id="ngayShip" v-model="newHoaDon.ngayShip" />
    </div>
    <div class="form-group">
        <label for="maNhanVien">Nhân viên:</label>
        <select name="" id="" v-model="newHoaDon.idNV">
            <option value="">Chọn nhân viên</option>
            <option v-for="nv in lstNhanVien" :key="nv.id" :value="nv.id">{{ nv.ten }}</option>
        </select>
    </div>
  </form>
</template>

<script setup>
import { getAllNhanVienService } from '@/service/NhanVienService';
import { onMounted, ref } from 'vue';

defineModel('newHoaDon', {
  type: Object,
  default: () => ({
    ma: '',
    ngayTao: '',
    ngayThanhToan: '',
    ngayShip: '',
    idNV: null,
  })
})
const lstNhanVien = ref([]);
const getAllNhanVien = async () => {
    try {
        const res = await getAllNhanVienService();
        lstNhanVien.value = res.data;
    } catch (error) {
        console.log('getAllNhanVien err' + error);
    }
}
onMounted(getAllNhanVien);
</script>

<style scoped></style>
