// Not work

package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Flame extends PApplet {

    Audio audio;

    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    float[] lerpedBuffer;
    float height, width;

    public Flame(float height, float width, Minim minim, AudioPlayer ap, AudioBuffer ab, Audio audio) {
        this.audio = audio;
        this.minim = minim;
        this.ap = ap;
        this.ab = ab;
        this.height = height;
        this.width = width;

    }

    public void setup() {
        lerpedBuffer = new float[audio.width];
    }

    public void render(int i, float f) {

        float c = audio.map(i, 0, ab.size(), 0, 255);
        stroke(c, 255, 255);

        line(i, height, i, height - f);

    }
}
