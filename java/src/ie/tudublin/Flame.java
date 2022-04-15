package ie.tudublin;

import processing.core.PApplet;

public class Flame {

    PApplet pa;
    float c; //colour of the strokes

    public Flame(PApplet pa) {
        this.pa = pa;
    }

    public void render(int i, float f) {

        c = PApplet.map(i, 0, pa.width, 0, 255); //colour of the lines
        pa.stroke(c, 255, 255);

        pa.line(i, pa.height, i, pa.height - f);

    }
}