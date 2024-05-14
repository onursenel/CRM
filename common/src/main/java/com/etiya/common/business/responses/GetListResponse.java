package com.etiya.common.business.responses;

import com.etiya.common.business.paging.BasePagingModel;

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
