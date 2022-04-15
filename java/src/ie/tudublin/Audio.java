package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

import java.util.Timer;
import java.util.TimerTask;

public class Audio extends PApplet {

    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;

    int mode = 0; // for menu usecase{}
    float[] lerpedBuffer;
    float sAmp = 0; // for smoothedAmplitude();

    // Function
    Flame fl;
    Square sq[] = new Square[50];
    SquareTrain sqt[] = new SquareTrain[20];
    DancingTriangle v = new DancingTriangle(this);
    Ending ed;
    // Function

    // Timer
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            // System.out.println("Task is complete :)");
            mode = mode + 1;
        }
    };

    // Timer

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
        // size(960, 720, P3D);
        fullScreen(P3D, SPAN);
    }

    public void setup() {
        minim = new Minim(this);

        ap = minim.loadFile("Kubbi_Cascade .mp3", width);

        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        lerpedBuffer = new float[width];

        // Timer every 10 second
        timer.scheduleAtFixedRate(task, 30000, 30000);
        ;
        // Timer

        // Create Flame
        fl = new Flame(height, width, this);
        // Create Flame

        // Create Square

        for (int i = 0; i < sq.length; i++) {
            sq[i] = new Square(20, this);
        }
        // Create Square

        // Create SquareTrain
        for (int i = 0; i < sqt.length; i++) {

            sqt[i] = new SquareTrain(30, this);

        }
        // Create SquareTrain

        ed = new Ending(this);

    }

    public void draw() {
        background(0);

        if (mode >= 0) {
            // DancingTriangle

            v.render(smoothedAmplitude());

            // DancingTriangle

        }

        if (mode >= 1) {
            // Flame

            float halfH = height / 2;
            float sum = 0;

            for (int i = 0; i < ab.size(); i++) {
                sum += abs(ab.get(i));
                lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
                float f = lerpedBuffer[i] * halfH * 4.0f;
                fl.render(i, f);
            }

            // Flame
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
        // System.out.println(ab.get(0));
        if (ab.get(0) == 0) {
            ed.render();
            ed.update();

        }
    }
}