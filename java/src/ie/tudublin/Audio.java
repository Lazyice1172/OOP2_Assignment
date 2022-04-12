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

    float sAmp = 0; // for smoothedAmplitude();

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
<<<<<<< HEAD
    }

    public float smoothedAmplitude(){
        float average = 0, sum = 0;
        // Calculate sum and average of the samples
=======

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];

        // Not Work
        // fl = new Flame(height, width, minim, ap, ab, this);

        for (int i = 0; i < sq.length; i++) {
            sq[i] = new Square(width / 10 * i, height, 20, this);
        }
        for (int i = 0; i < sqt.length; i++) {

            sqt[i] = new SquareTrain(width / 10 * i, height, 30, this);

        }

    }

    public void draw() {
        background(0);

        // Flame

        float halfH = height / 2;
        float sum = 0;

>>>>>>> 05bfb7131eb7e1711866b75cfd33031fadcd3a57
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
        }
<<<<<<< HEAD
        average = sum / (float) ab.size();
        //lerp the value
        sAmp = lerp(sAmp, average, 0.1f);
        return sAmp;
    }

    public void draw() {
        background(0);
        v.render(smoothedAmplitude());
=======

        for (int i = 0; i < ab.size(); i++) {
            // float c = map(ab.get(i), -1, 1, 0, 255);
            float c = map(i, 0, ab.size(), 0, 255);
            stroke(c, 255, 255);
            float f = lerpedBuffer[i] * halfH * 4.0f;
            line(i, height, i, height - f);

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

>>>>>>> 05bfb7131eb7e1711866b75cfd33031fadcd3a57
    }
}
