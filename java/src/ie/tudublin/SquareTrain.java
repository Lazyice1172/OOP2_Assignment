package ie.tudublin;

public class SquareTrain {
    float x, y;
    float fx, fy;
    float w;
    float halfW;

    Audio audio;

    float rotation;

    public SquareTrain(float x, float y, float w, Audio audio) {
        this.x = audio.random(audio.width);
        this.y = audio.random(audio.height, audio.height + 500);
        this.w = w;
        halfW = w / 2.0f;
        this.audio = audio;
        this.rotation = 0;
        fx = 0;
        fy = -w;
    }

    public void render() {
        audio.pushMatrix();
        audio.translate(x, y);

        float halfW = w / 2;
        float c = audio.map(x, 0, audio.width, 0, 255);
        audio.fill(c, 255, 255);
        audio.stroke(255);
        audio.rectMode(audio.CENTER);
        for (int i = 0; i < 5; i++) {
            audio.rect(0, 0 + w * i, w * (5 - i) / 5, w * (5 - i) / 5);
        }

        audio.popMatrix();
    }

    public void update() {
        x = x + fx;
        y = y + fy;

        
        if (y < 0) {
            y = audio.random(audio.height, audio.height + 500);
            x = audio.random(audio.width);

        }
        if (x > audio.width) {
            x = audio.random(audio.width);
        }
        if (x < 0) {
            x = audio.random(audio.width);
        }

    }

}
