package com.gwf;

import com.gwf.cglibproxy.CGlibInteceptor;
import com.gwf.service.ProductServiceImpl;

/**
 * @author gaowenfeng
 * @date 2018/4/3
 */
public class CGlibClient {

    public static void main(String[] args) {
        ProductServiceImpl productService = (ProductServiceImpl) new CGlibInteceptor().getInstance(ProductServiceImpl.class);
        productService.addProduct();
    }
}
