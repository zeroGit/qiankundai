package com.github.zeroGit.qiankundai.Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// advice 比如 befor after
// advice 放置到 一个方法上，这个方法可以称之为切点
// 切面 ：advice + 切点
public class Aop {

    public static Advice newAdvice() {
        return new Advice();
    }

}















