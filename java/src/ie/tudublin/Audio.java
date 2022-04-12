package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

import java.util.Timer;
import java.util.TimerTask;

import com.jogamp.common.util.TaskBase;

public class Audio extends PApplet {

    DancingTriangle v = new DancingTriangle(this);
    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;

    int mode = 0; // for menu usecase{}
    float[] lerpedBuffer;
<<<<<<< HEAD
=======
    float sAmp = 0; // for smoothedAmplitude();
>>>>>>> d85fc01757e03759af68cd1c7748bd229d0cd825

    Flame fl;
    Square sq[] = new Square[20];
    SquareTrain sqt[] = new SquareTrain[10];

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    public void settings() {
        size(960, 720, P3D);
        // fullScreen(P3D, SPAN);
    }

    public void setup() {
        minim = new Minim(this);

        ap = minim.loadFile("Kubbi_Cascade .mp3", width);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        lerpedBuffer = new float[width];

        // Not Work
        fl = new Flame(height, width, minim, ap, ab, this);

        for (int i = 0; i < sq.length; i++) {
            sq[i] = new Square(width / 10 * i, height, 20, this);
        }
        for (int i = 0; i < sqt.length; i++) {

            sqt[i] = new SquareTrain(width / 10 * i, height, 30, this);

        }

    }

    public float smoothedAmplitude(){
        float average = 0, sum = 0;
        // Calculate sum and average of the samples
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
        }
        average = sum / (float) ab.size();
        //lerp the value
        sAmp = lerp(sAmp, average, 0.1f);
        return sAmp;
    }




    public void draw() {
        background(0);
        
        v.render(smoothedAmplitude());

        
        // Flame

        float halfH = height / 2;
        float sum = 0;

        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }

        for (int i = 0; i < ab.size(); i++) {
            float f = lerpedBuffer[i] * halfH * 4.0f;
            fl.render(i, f);
        }

        // Flame

        // SquareTrain

        for (int j = 0; j < sq.length; j++) {
            sq[j].render();
            sq[j].update();
        }
        for (int j = 0; j < sqt.length; j++) {

            sqt[j].render();

            if (frameCount % 30 == 0) {
                sqt[j].update();
            }
        }

        // SquareTrain

    }
}
