qiankundai

尝试下函数式编程

去掉 catch catch catch ...

```
import com.github.zeroGit.qiankundai.Base.Out;
import com.github.zeroGit.qiankundai.Fs.ReadAllBytes;

public class Abc {
    public static void main(String[] args) {

        Out<byte[]> out;
        if ((out = ReadAllBytes
                .go("./abc.txt"))
                .err(() -> {
                    out.e.printStackTrace();
                })
                .ret()) return;

        System.out.println("abc : " + new String(out.v));
    }
}
```