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

    int mode = 0;
    float[] lerpedBuffer;
    float sAmp = 0; // for smoothedAmplitude();

    // Function
    Flame fl = new Flame(this);
    DancingTriangle v = new DancingTriangle(this);
    Circle circle = new Circle(this);
    Square sq[] = new Square[50];
    SquareTrain sqt[] = new SquareTrain[20];
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

    //lerps the amplitude
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
        //size(960, 720, P3D); //tester code
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

        // Create Square
        for (int i = 0; i < sq.length; i++) {
            sq[i] = new Square(20, this);
        }

        // Create SquareTrain
        for (int i = 0; i < sqt.length; i++) {
            float c = map(i, 1, sqt.length, width*0.01f, width*0.03f);
            sqt[i] = new SquareTrain(c, this);
        }
        
        //Create Ending
        ed = new Ending(this); 
    }

    public void draw() {

        background(0);
        float smoothed = smoothedAmplitude();

        // DancingTriangle
        if (mode >= 0) {
            v.render(smoothed);
        }

        // Flame + circle
        if (mode >= 1) {
            float halfH = height / 2;

            for (int i = 0; i < ab.size(); i++) {
                lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
                float f = lerpedBuffer[i] * halfH * 2.0f;
                
                circle.render(i, f, smoothed, ab.size());
                
                if( mode >= 2){
                    fl.render(i, f);
                }

            }
        }

        if (mode >= 3) {
            // Square
            for (int j = 0; j < sq.length; j++) {
                sq[j].render();
                sq[j].update(smoothed);
                //System.out.println(smoothed);
            }
            // Square
        }

        if (mode >= 4) {
            // SquareTrain
            for (int j = 0; j < sqt.length; j++) {

                sqt[j].render();

                if (frameCount % 30 == 0) {
                    sqt[j].update();
                }
            }
            // SquareTrain
        }

        // Ending
        if (ab.get(0) == 0) {
            ed.render();
            ed.update();

        }
        // Ending
    }
}
