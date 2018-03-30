package com.gwf.custom;

import java.lang.reflect.Method;

/**
 * 自定义InvocationHandler接口
 * @author gaowenfeng
 */
public interface MyInvocationHandler {

    /**
     * 具体的代理方法，增强实现
     * @param proxy 代理类
     * @param method 当前被代理的方法
     * @param args 当前被代理的方法的参数
     * @return 返回被代理方法的返回值
     * @throws Throwable 可能会抛出的异常
     */
    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
