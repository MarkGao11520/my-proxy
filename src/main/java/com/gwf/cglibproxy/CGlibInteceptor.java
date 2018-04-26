package com.gwf.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaowenfeng
 * @date 2018/4/3
 */
public class CGlibInteceptor implements MethodInterceptor{

    public  Object getInstance(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        Object obj = enhancer.create();
        return obj;
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate  = simpleDateFormat.format(new Date());
        System.out.println("日期【"+currentDate + "】添加了一款产品");
        return methodProxy.invokeSuper(target,args);
    }
}
