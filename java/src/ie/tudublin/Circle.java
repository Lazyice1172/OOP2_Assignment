package ie.tudublin;

import processing.core.PApplet;

public class Circle {
    
    PApplet pa;
    float cx, cy;
    float c; //colour of the strokes
    
    public Circle(PApplet pa) {
        this.pa = pa;
    }

    public void setup(){
    }
    
    public void render(int i, float f, float au, int sides){
        cy = pa.height/2;
        cx = pa.width/2;
        c = PApplet.map(i, 0, pa.width, 0, 255); //colour of the lines
        pa.stroke(c, 255, 255);
        
        //Changing size
        float radius = PApplet.map(au, 0, 0.05f, pa.height * 0.05f, pa.height * 0.1f);		
        
        float r = radius;
        float theta = PApplet.map(i, 0, sides, 0, PApplet.TWO_PI);
        float x = cx + PApplet.sin(theta) * r;
        float y = cy - PApplet.cos(theta) * r;
        float ex = x + PApplet.abs(f) * PApplet.sin(theta);
        float ey = y - PApplet.abs(f) * PApplet.cos(theta);
        pa.line(x, y, ex, ey);
    }
}
