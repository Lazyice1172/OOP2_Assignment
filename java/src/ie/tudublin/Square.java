package ie.tudublin;

public class Square {
    float x, y;
    float fx, fy;
    float w;
    float halfW;

    Audio audio;

    float rotation;

    public Square(float x, float y, float w, Audio audio) {
        this.x = audio.random(audio.width);
        this.y = audio.height;
        this.w = w;
        halfW = w / 2.0f;
        this.audio = audio;
        this.rotation = 0;
        fx = 0;
        fy = audio.random(-3, -1);
    }

    public void render() {

        audio.pushMatrix();
        audio.translate(x, y);
        audio.rotate(rotation);

        float halfW = w / 2;
        audio.noFill();
        audio.stroke(255);
        audio.rectMode(audio.CENTER);
        audio.rect(0, 0, w, w);

        audio.popMatrix();
    }

    public void update() {
        x = x + fx;
        y = y + fy;
        rotation = rotation - 0.01f;

        if (y > audio.height) {
            y = audio.height;
            x = audio.random(audio.width);
            fy = audio.random(-3, -1);
        }
        if (y < 0) {
            y = audio.height;
            x = audio.random(audio.width);
            fy = audio.random(-3, -1);
        }
        if (x > audio.width) {
            x = audio.random(audio.width);
        }
        if (x < 0) {
            x = audio.random(audio.width);
        }

    }

}
