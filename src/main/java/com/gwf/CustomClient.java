package com.gwf;

import com.gwf.custom.CustomInvocationHandler;
import com.gwf.jdkproxy.JdkInvocationHandler;
import com.gwf.service.ProductService;
import com.gwf.service.ProductServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author gaowenfeng
 * @date 2018/3/30
 */
public class CustomClient {
    public static void main(String[] args){
        ProductService productService = new ProductServiceImpl();
        ProductService proxy = (ProductService) new CustomInvocationHandler().getInstance(productService);
        proxy.addProduct();
    }
}
