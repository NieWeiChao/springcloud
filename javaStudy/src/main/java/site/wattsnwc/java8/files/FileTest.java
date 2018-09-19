package site.wattsnwc.java8.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * 这里需要写注释
 */

public class FileTest {
    public static void main(String[] args) throws IOException {

        //获取
        Path path   = Paths.get("/home/biezhi", "a.txt");
        Path path2   = Paths.get("/home/biezhi/a.txt");
        URI  u       = URI.create("file:////home/biezhi/a.txt");
        Path pathURI = Paths.get(u);

        //转换
        File file  = new File("/home/biezhi/a.txt");
        Path p1    = file.toPath();
        p1.toFile();
        file.toURI();

        //读取
        byte[] data    = Files.readAllBytes(Paths.get("/home/biezhi/a.txt"));
        String content = new String(data, StandardCharsets.UTF_8);
        //逐行
        List<String> lines = Files.readAllLines(Paths.get("/home/biezhi/a.txt"));
        //写入
        Files.write(Paths.get("/home/biezhi/b.txt"), "Hello JDK7!".getBytes());
        Files.write(Paths.get("/home/biezhi/b.txt"), "Hello JDK7!".getBytes(),
                StandardOpenOption.APPEND);
        //转流
        InputStream ins = Files.newInputStream(path);
        OutputStream ops = Files.newOutputStream(path);
        Reader reader = Files.newBufferedReader(path);
        Writer writer = Files.newBufferedWriter(path);
        //临时目录
//        Files.createTempFile(dir, prefix, suffix);
//        Files.createTempFile(prefix, suffix);
//        Files.createTempDirectory(dir, prefix);
//        Files.createTempDirectory(prefix);
        Files.copy(path, path);
        Files.move(path, path);
        Files.delete(path);
    }
}
