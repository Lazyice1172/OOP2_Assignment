// Not work


package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Flame extends PApplet{

    Audio audio;

    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    float[] lerpedBuffer;
    float height, width;

    public Flame(float height, float width, Minim minim, AudioPlayer ap, AudioBuffer ab, Audio audio) {
        audio = this.audio;
        minim = this.minim;
        ap = this.ap;
        ab = this.ab;
        height = this.height;
        width = this.width;

    }

    public void setup() {
        lerpedBuffer = new float[audio.width];
    }

    public void render() {
        float sum = 0;
        float halfH = height / 2;

        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }

        
        for (int i = 0; i < ab.size(); i++) {
            // float c = map(ab.get(i), -1, 1, 0, 255);
            float c = map(i, 0, ab.size(), 0, 255);
            stroke(c, 255, 255);
            float f = lerpedBuffer[i] * halfH * 4.0f;
            line(i, height, i, height - f);

        }
    }
}
