// Not work

package ie.tudublin;


public class Flame {

    Audio audio;


    float[] lerpedBuffer;
    float height, width;

    public Flame(float height, float width, Audio audio) {
        this.audio = audio;

        this.height = height;
        this.width = width;

    }

    public void setup() {
        lerpedBuffer = new float[audio.width];
    }

    public void render(int i, float f) {

        float c = audio.map(i, 0, audio.width, 0, 255);
        audio.stroke(c, 255, 255);

        audio.line(i, height, i, height - f);

    }
}
