package com.github.zeroGit.qiankundai.Base;


public class Out<T> {
    public Throwable e;
    public T v;

    public Out<T> err(EHandle0 h) {
        if (e != null && h != null) {
            h.handle();
        }
        return this;
    }

    public boolean ret() {
        return e != null;
    }
}

