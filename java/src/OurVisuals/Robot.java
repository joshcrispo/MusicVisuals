package OurVisuals;

import processing.core.PApplet;

public class Robot {
    Menu menu;

    public Robot(Menu menu) {
        this.menu = menu;
    }

    public void render(float x, float y) {
        float[] lerpedBuffer;
        lerpedBuffer = new float[menu.width];
        float sum = 0;
        double PI = 3.1415927;

        menu.pushMatrix();
        menu.fill(0);
        menu.translate(x, y);
        menu.stroke(255);
        // draw boxes
        menu.rect(0, 0, 80, 75, 2); // draw big box
        menu.circle(15, 70, PApplet.map(menu.getAmplitude(), 0, 1, 1, 6));
        menu.circle(25, 70, PApplet.map(menu.getAmplitude(), 0, 1, 1, 6));
        menu.rect(10, 10, 60, 55, 2); // draw small tv
        menu.rect(23, -30, 35, 20, 2); // draw head

        menu.rect(35, -10, 20 - 10, 10, 2); // draw neck
        // draw face
        menu.fill(PApplet.map(menu.getAmplitude(), 0, 1, 150, 255), 255, 255);
        menu.stroke(255);
        menu.circle(30, -25, 7); // left eye
        menu.circle(52, -25, 7); // right eye
        menu.fill(0);
        menu.line(35, -15, 45, -15); // mouth
        menu.triangle(35, -30, 40, -45, 45, -30); // draw hat
        menu.fill(PApplet.map(menu.getAmplitude(), 0, 1, 0, 255), 255, 255);
        menu.stroke(PApplet.map(menu.getAmplitude(), 0, 1, 0, 255), 255, 255);

        menu.circle(40, -49, PApplet.map(menu.getAmplitude(), 0, 1, 5, 20));
        menu.stroke(255);
        menu.fill(0);

        // make legs
        menu.beginShape();
        menu.curveVertex(20, 75);
        menu.curveVertex(20, 75);
        menu.curveVertex(PApplet.map(menu.getAmplitude(), 0, 1, 0, 20), 105);
        menu.curveVertex(25, 130);
        menu.curveVertex(25, 130);
        menu.endShape();

        menu.beginShape();
        menu.curveVertex(30, 75);
        menu.curveVertex(30, 75);
        menu.curveVertex(PApplet.map(menu.getAmplitude(), 0, 1, 10, 30), 105);
        menu.curveVertex(35, 130);
        menu.curveVertex(35, 130);
        menu.endShape();

        menu.beginShape();
        menu.curveVertex(50, 75);
        menu.curveVertex(50, 75);
        menu.curveVertex(PApplet.map(menu.getAmplitude(), 0, 1, 40, 60), 105);
        menu.curveVertex(55, 130);
        menu.curveVertex(55, 130);
        menu.endShape();

        menu.beginShape();
        menu.curveVertex(60, 75);
        menu.curveVertex(60, 75);
        menu.curveVertex(PApplet.map(menu.getAmplitude(), 0, 1, 50, 70), 105);
        menu.curveVertex(65, 130);
        menu.curveVertex(65, 130);
        menu.endShape();

        // shoes
        menu.scale(1, -1);
        menu.arc(28, -135, 20, 20, 0, (float) PI);
        menu.arc(58, -135, 20, 20, 0, (float) PI);
        menu.line(20, -135, 38, -135);
        menu.line(50, -135, 68, -135);

        // fingers
        menu.strokeWeight(4);
        menu.arc(-28, -65, 15, 20, 0, (float) PI);
        menu.arc(110, -65, 15, 20, 0, (float) PI);
        menu.strokeWeight(2);

        // arms
        menu.scale(1, 1);
        menu.beginShape();
        menu.curveVertex(80, -15);
        menu.curveVertex(80, -15);
        menu.curveVertex(PApplet.map(menu.getAmplitude(), 0, 1, 90, 100), -25);
        menu.curveVertex(115, -57);
        menu.curveVertex(115, -57);
        menu.endShape();

        menu.beginShape();
        menu.curveVertex(80, -25);
        menu.curveVertex(80, -25);
        menu.curveVertex(PApplet.map(menu.getAmplitude(), 0, 1, 90, 100), -35);
        menu.curveVertex(105, -57);
        menu.curveVertex(105, -57);
        menu.endShape();

        menu.beginShape();
        menu.curveVertex(0, -25);
        menu.curveVertex(0, -25);
        menu.curveVertex(PApplet.map(menu.getAmplitude(), 0, 1, -10, -25), -35);
        menu.curveVertex(-23, -57);
        menu.curveVertex(-23, -57);
        menu.endShape();

        menu.beginShape();
        menu.curveVertex(0, -15);
        menu.curveVertex(0, -15);
        menu.curveVertex(PApplet.map(menu.getAmplitude(), 0, 1, -10, -25), -25);
        menu.curveVertex(-33, -57);
        menu.curveVertex(-33, -57);
        menu.endShape();

        for (int i = 0; i < menu.ab.size()/4; i++) {
            sum += PApplet.abs(menu.ab.get(i));
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], menu.ab.get(i), 0.05f);
        }

        for (int i = 200; i < menu.ab.size()/4; i++) {
            // float c = map(ab.get(i), -1, 1, 0, 255);
            float c = PApplet.map(i - 25, 0, menu.ab.size()/4, 0, 255);
            menu.stroke(c, 255, 255);
            float f = lerpedBuffer[i] * 100 * 4.0f;
            menu.line(-i + 268, -40 + f, -i + 268, -40 - f);
        }

        menu.popMatrix();

    }

}
