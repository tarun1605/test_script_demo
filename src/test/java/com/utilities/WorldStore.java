package com.utilities;

import java.util.List;

public class WorldStore {

    private List<String> productName;

    public void setProductNames(List<String> productName) {
        this.productName=productName;
    }

    public List<String> getProductNames() {
        return this.productName;
    }
}
