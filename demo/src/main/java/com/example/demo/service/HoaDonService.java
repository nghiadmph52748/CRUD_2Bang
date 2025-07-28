package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.exception.ApiException;
import com.example.demo.model.request.HoaDonRequest;
import com.example.demo.model.response.HoaDonResponse;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private NhanVienService nhanVienService;

    public List<HoaDonResponse> getAll() {
        return hoaDonRepository.findAll().stream().map(HoaDonResponse::new).toList();
    }

    public HoaDonResponse getById(Long id) {
        return hoaDonRepository.findById(id).map(HoaDonResponse::new).orElseThrow(()-> new ApiException("HoaDon not found with id: " + id,"HOA_DON_NOT_FOUND"));
    }

    public void deleteById(Long id){
        if (!hoaDonRepository.existsById(id)){
            throw new ApiException("HoaDon not found with id: " + id, "HOA_DON_NOT_FOUND");
        }
        hoaDonRepository.deleteById(id);
    }

    public void add(HoaDonRequest hoaDonRequest){
        HoaDon hoaDon = MapperUtils.map(hoaDonRequest, HoaDon.class);
        hoaDon.setIdNV(nhanVienService.getNhanVienById(hoaDonRequest.getIdNV()));
        hoaDonRepository.save(hoaDon);
    }

    public void update(Long id, HoaDonRequest hoaDonRequest) {
        if (!hoaDonRepository.existsById(id)) {
            throw new ApiException("HoaDon not found with id: " + id, "HOA_DON_NOT_FOUND");
        }
        HoaDon hoaDon = MapperUtils.map(hoaDonRequest, HoaDon.class);
        hoaDon.setId(id);
        hoaDon.setIdNV(nhanVienService.getNhanVienById(hoaDonRequest.getIdNV()));
        hoaDonRepository.save(hoaDon);
    }
}
