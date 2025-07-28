package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagingResponse<T> {
    List<T> data;
    Integer currentPage;
    Integer totalPage;
    Long totalItem;

    public PagingResponse(Page<T> data, Integer currentPage) {
        this.data = data.getContent();
        this.currentPage = currentPage;
        this.totalPage = data.getTotalPages();
        this.totalItem = data.getTotalElements();
    }
}
