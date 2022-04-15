package ie.tudublin;

public class Ending {

    Audio audio;
    float x, y;
    float fy;

    public Ending(Audio audio) {
        this.audio = audio;
        this.x = audio.width / 2;
        this.y = audio.height + 400;
        this.fy = -5;
    }

    public void render() {
        audio.textAlign(audio.CENTER);
        audio.textSize(24);

        // Ending
        audio.pushMatrix();
        audio.translate(x, y - 300);
        audio.text("Thank You for Listening", 0, 0);
        audio.popMatrix();

        // Team Member
        audio.pushMatrix();
        audio.translate(x, y);
        audio.text("Created by : ", 0, 0);
        audio.popMatrix();

        audio.pushMatrix();
        audio.translate(x, y + 30);
        audio.text("Christina Vargka (C20737009)", 0, 0);
        audio.popMatrix();

        audio.pushMatrix();
        audio.translate(x, y + 60);
        audio.text("Anis Dizdarevic (C20345816)", 0, 0);
        audio.popMatrix();

        audio.pushMatrix();
        audio.translate(x, y + 90);
        audio.text("Ho Chung (C20348256)", 0, 0);
        audio.popMatrix();

    }

    public void update() {
        if (y > audio.height / 2 + 100) {
            y = y + fy;
        }

    }
}
