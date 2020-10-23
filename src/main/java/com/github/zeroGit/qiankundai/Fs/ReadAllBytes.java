
package com.github.zeroGit.qiankundai.Fs;

import com.github.zeroGit.qiankundai.Base.Out;

import java.io.*;
import java.nio.file.Files;

public class ReadAllBytes {

    public static Out<byte[]> go(String fpath) {
        try {
            Out<byte[]> out = new Out<byte[]>();

            File f = new File(fpath);
            out.v = Files.readAllBytes(f.toPath());

            return out;
        } catch (IOException e) {
            Out<byte[]> out = new Out<>();
            out.e = e;
            return out;
        }
    }
}
