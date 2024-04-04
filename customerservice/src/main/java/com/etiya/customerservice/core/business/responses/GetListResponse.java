package com.etiya.customerservice.core.business.responses;

import com.etiya.customerservice.core.business.paging.BasePagingModel;

import java.util.ArrayList;
import java.util.List;

public class GetListResponse<T> extends BasePagingModel {
    private List<T> _items;

    public List<T> getItems() {
        if (_items == null) {
            _items = new ArrayList<>();
        }
        return _items;
    }

    public void setItems(List<T> items) {
        _items = items;
    }

}
