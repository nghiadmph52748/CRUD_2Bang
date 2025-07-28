package com.example.demo.controller;

import com.example.demo.model.request.HoaDonRequest;
import com.example.demo.model.response.ResponseObject;
import com.example.demo.service.HoaDonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hoa-don-management")
@CrossOrigin(origins = "*")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;

    @GetMapping("/playlist")
    public ResponseObject<?> get() {
        return new ResponseObject<>(hoaDonService.getAll());
    }

    @GetMapping("/detail/{id}")
    public ResponseObject<?> detail(@PathVariable Long id) {
        return new ResponseObject<>(hoaDonService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseObject<?> delete(@PathVariable Long id) {
        hoaDonService.deleteById(id);
        return new ResponseObject<>(null, "Xóa thành công");
    }

    @PostMapping("/add")
    public ResponseObject<?> add(@RequestBody @Valid HoaDonRequest hoaDonRequest) {
        hoaDonService.add(hoaDonRequest);
        return new ResponseObject<>(null, "Thêm thành công");
    }

    @PutMapping("/update/{id}")
    public ResponseObject<?> update(@RequestBody @Valid HoaDonRequest hoaDonRequest, @PathVariable Long id) {
        hoaDonService.update(id, hoaDonRequest);
        return new ResponseObject<>(null, "Cập nhật thành công");
    }
}
