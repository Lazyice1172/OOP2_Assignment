package ie.tudublin;

public class Square {
    float x, y;
    float fx, fy;
    float w;
    float halfW;

    Audio audio;

    float rotation;

    public Square(float w, Audio audio) {
        this.x = audio.random(audio.width);
        this.y = audio.random(audio.height, audio.height + 500);
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

        float c = audio.map(x, 0, audio.width, 0, 255);
        audio.noFill();
        audio.stroke(c, 255, 255);
        audio.rectMode(audio.CENTER);
        audio.rect(0, 0, w, w);

        audio.popMatrix();
    }

    public void update(float au) {
        x = x + fx;
        y = y + fy - (au*20);
        rotation = rotation - 0.01f;

        
        if (y < 0) {
            y = audio.height;
            x = audio.random(audio.width);
            fy = audio.random(-3, -1);
        }
        else if (x > audio.width) {
            x = audio.random(audio.width);
        }
        else if (x < 0) {
            x = audio.random(audio.width);
        }

    }

}