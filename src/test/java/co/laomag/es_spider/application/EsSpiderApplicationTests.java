package co.laomag.es_spider.application;

import org.bytedeco.ffmpeg.ffmpeg;
import org.bytedeco.javacpp.Loader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;

@SpringBootTest
class EsSpiderApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }


    @Test
    void FFmpegTest(){
        String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);
        ProcessBuilder h264 = new ProcessBuilder(ffmpeg.toString(), "-i", "C:\\Users\\mzp\\IdeaProjects\\es_spider\\src\\main\\resources\\vide\\test.flv", "-vcodec", "h264", "C:\\Users\\mzp\\IdeaProjects\\es_spider\\src\\main\\resources\\vide\\test1.flv");
        try {
            h264.inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
