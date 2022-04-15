package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

import java.util.Timer;
import java.util.TimerTask;

import com.jogamp.common.util.TaskBase;

public class Audio extends PApplet {

    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;

    int mode = 0; // for menu usecase{}
    float[] lerpedBuffer;
    float sAmp = 0; // for smoothedAmplitude();

    // Function
    Flame fl = new Flame(this);
    DancingTriangle v = new DancingTriangle(this);
    Circle circle = new Circle(this);
    Square sq[] = new Square[50];
    SquareTrain sqt[] = new SquareTrain[20];
    // Function

    // Timer
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            mode = mode + 1;
        }
    };
    // Timer

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

    public float smoothedAmplitude() {
        float average = 0, sum = 0;
        // Calculate sum and average of the samples
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
        }
        average = sum / (float) ab.size();
        // lerp the value
        sAmp = lerp(sAmp, average, 0.1f);
        return sAmp;
    }

    public void settings() {
        size(960, 720, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup() {
        minim = new Minim(this);

        ap = minim.loadFile("Kubbi_Cascade .mp3", width);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        lerpedBuffer = new float[width];

        // Timer every 10 second
        timer.scheduleAtFixedRate(task, 5000, 10000);
        ;

        // Create Square
        for (int i = 0; i < sq.length; i++) {
            sq[i] = new Square(20, this);
        }

        // Create SquareTrain
        for (int i = 0; i < sqt.length; i++) {
            float c = map(i, 1, sqt.length, width*0.03f, width*0.09f);
            sqt[i] = new SquareTrain(c, this);
        }

    }

    public void draw() {
        background(0);
        float smoothed = smoothedAmplitude();

        // DancingTriangle
        if (mode >= 0) {
            v.render(smoothed);
        }

        // Flame
        if (mode >= 1) {
            float halfH = height / 2;

            for (int i = 0; i < ab.size(); i++) {
                lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
                float f = lerpedBuffer[i] * halfH * 4.0f;
                fl.render(i, f);
                circle.render(i, f, smoothed, ab.size());

            }
        }

        if (mode >= 2) {
            // Square
            for (int j = 0; j < sq.length; j++) {
                sq[j].render();
                sq[j].update();
            }
            // Square
        }

        if (mode >= 3) {
            // SquareTrain
            for (int j = 0; j < sqt.length; j++) {

                sqt[j].render();

                if (frameCount % 30 == 0) {
                    sqt[j].update();
                }
            }

            // SquareTrain
        }

    }
}
