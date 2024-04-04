package com.etiya.customerservice.core.business.paging;

import lombok.Data;

@Data
public abstract class BasePagingModel {
    private  int totalPages;
    private long totalElements;
    private boolean hasNext;
    private boolean hasPrevious;
    private int size;
}
