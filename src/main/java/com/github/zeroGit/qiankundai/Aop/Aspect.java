package com.github.zeroGit.qiankundai.Aop;

import java.lang.reflect.Method;

// 包含 advice 作用于 哪个方法上
public class Aspect {

    private Advice advice;
    private String method;

    // 作用的类 和 方法，这个方法需要被代理
    private Class<?> proxyClass;
    private Method proxyMethod;

    Aspect(Advice advice, String method) {
        this.advice = advice;
        this.method = method;
    }

    // 返回一个代理，可以直接调用被代理类的方法
    public Object proxy(Object original) throws Exception {
        AopProxy aopProxy = new AopProxy(this, original);
        aopProxy.init();
        return aopProxy.getProxy();
    }

    void init() throws Exception {
        try {

            MethodDesc methodDesc = MethodDesc.analMethodDesc(method);

            proxyClass = methodDesc.getC();
            proxyMethod = methodDesc.getM();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    void invokeBefore(Method method) {
        if (method.equals(this.proxyMethod)) {
            advice.invokeBefore();
        }
    }

    void invokeAfter(Method method) {
        if (method.equals(this.proxyMethod)) {
            advice.invokeAfter();
        }
    }

    Advice getAdvice() {
        return advice;
    }

    Class<?> getProxyClass() {
        return proxyClass;
    }

}

