package cn.bulaoerhuoblog.tank.resource;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author makun
 */
public class Audio extends Thread {

    SourceDataLine sourceDataLine;
    AudioFormat format;
    AudioInputStream audioInputStream;

    @Override
    public void run() {
        try {
            byte[] b = new byte[1024];
            int len = 0;
            sourceDataLine.open(format);
            sourceDataLine.start();
            while ((len = audioInputStream.read(b,0,len)) > 0) {
                sourceDataLine.write(b, 0, len);
            }
            audioInputStream.close();
            sourceDataLine.drain();
            sourceDataLine.close();

        } catch (Exception e) {

        }
    }

    public Audio(String fileName) {
        try {
            InputStream inputStream = Audio.class.getClassLoader().getResourceAsStream(fileName);
            audioInputStream = AudioSystem.getAudioInputStream(inputStream);
            format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
