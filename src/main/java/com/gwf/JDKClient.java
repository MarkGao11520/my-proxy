package com.gwf;

import com.gwf.jdkproxy.JdkInvocationHandler;
import com.gwf.service.ProductService;
import com.gwf.service.ProductServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author gaowenfeng
 * @date 2018/3/30
 */
public class JDKClient {
    public static void main(String[] args) throws Exception {
        ProductService productService = new ProductServiceImpl();
        ProductService proxy = (ProductService) new JdkInvocationHandler().getInstance(productService);
        proxy.addProduct();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{productService.getClass()});

        FileOutputStream os = new FileOutputStream("Proxy0.class");
        os.write(bytes);
        os.close();
    }
}
