package com.github.zeroGit.qiankundai.AopTest;

import com.github.zeroGit.qiankundai.Aop.*;

public class Main {
    public static void main(String[] args) {

        try {

            Original original = new Original();

            FuncA funcA = (FuncA) Aop.newAdvice()
                    // 创建通知，说明要在某个方法上添加哪些方法处理
                    .before("com.github.zeroGit.qiankundai.AopTest.AdviceMethod.beforeFuncA()")
                    .before("com.github.zeroGit.qiankundai.AopTest.AdviceMethod.beforeFuncB()")
                    .after("com.github.zeroGit.qiankundai.AopTest.AdviceMethod.afterFuncA()")
                    .after("com.github.zeroGit.qiankundai.AopTest.AdviceMethod.afterFuncA()")
                    // 返回一个切面，指明了要在这个方法上 添加上述的通知
                    .onMethod("com.github.zeroGit.qiankundai.AopTest.FuncA.func2String(java.lang.String , java.lang.String )")
                    // 返回一个代理，指明上述切面作用于这个对象上
                    // spring 的切面也只能作用于 Bean上
                    .proxy(original);

            funcA.func();
            System.out.println("-----------");
            funcA.func2String("abc", "123");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
