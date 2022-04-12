package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio extends PApplet {

    DancingTriangle v = new DancingTriangle(this);
    Minim minim;
    AudioPlayer ap;
    AudioBuffer ab;

    int mode = 0; // for menu usecase{}

    float sAmp = 0; // for smoothedAmplitude();

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
    }
}
