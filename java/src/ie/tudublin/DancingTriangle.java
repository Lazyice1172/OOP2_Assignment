package ie.tudublin;

import processing.core.PApplet;

public class DancingTriangle{

    PApplet pa;
    float cx, cy;

    
    public DancingTriangle(PApplet pa) {
        this.pa = pa;
    }
    
    public void render(float au){
        cx = pa.width/2;
        cy = pa.height/2;
        //Changing colour
        float c = PApplet.map(au, 0, 0.5f, 0, 255);
        pa.stroke(c, 255, 255);

        //Changing size
        float radius = PApplet.map(au, 0, 0.1f, pa.height * 0.01f, pa.height * 0.02f);		
        int sides = 3; // triangle = 3 sides
        float px = cx; // previous x
        float py = cy - radius; //previous y
        for(int i = 0 ; i <= sides ; i ++)
        {
            float r = radius;
            float theta = PApplet.map(i, 0, sides, 0, PApplet.TWO_PI);
            float x = cx + PApplet.sin(theta) * r;
            float y = cy - PApplet.cos(theta) * r;
            
            pa.line(px, py, x, y);
            px = x;
            py = y;
        }
        /*
        !COMMENT
        if you want to draw a triangle it would look like:
        
        int sides = 3; // triangle = 3 sides
        float x1 = cx;
        float y1 = cy - radius;
        float x2 = cx + sin(TWO_PI/sides) * radius;
        float y2 = cy - cos(TWO_PI/sides) * radius;
        float x3 = cx + sin(2*(TWO_PI/sides)) * radius;
        float y3 = cy - cos(2*(TWO_PI/sides)) * radius;
        
        triangle(x1, y1, x2, y2, x3, y3);
        */
        
    }

}
