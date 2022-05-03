package OurVisuals;

import ie.tudublin.Visual;
import ddf.minim.*;

public class Menu extends Visual {

    // array to store song names
    String[] display_names = { "Homies In Paris", "Hero Planet", "Masquerade" };
    // array to store file names
    // WINDOWS
    // String[] songs = { "HomiesInParis2.mp3", "heroplanet.mp3", "Masquerade.mp3"
    // };
    // MAC
    String[] songs = { "java/data/HomiesInParis2.mp3","java/data/heroplanet.mp3", "java/data/Masquerade.mp3"};
    // array to store number of playes
    String[] players = { "1 player", "2 players" };

    Spiral spirals;
    AudioPlayer ap;
    AudioBuffer ab;
    Minim minim;

    Lines lines;
    Robot robots;

    int border = 120;
    int gap = 50;
    int gap2 = 30;
    int middleW;
    float[] lerpedBuffer;
    // index of the song selected
    int song_index = 0;

    public void settings() {

        size(1000, 1024);

    }

    public void setup() {

        colorMode(HSB);
        setFrameSize(256);
        startMinim();
        loadAudio(songs[song_index]);
        minim = new Minim(this);
        ap = getAudioPlayer();
        ap.play();
        ab = ap.mix;
        lines = new Lines(this);
        robots = new Robot(this);
        spirals = new Spiral(this);
        lerpedBuffer = new float[width];
        middleW = width / 2;

    }

    public void play_music() {

        getAudioPlayer().close();
        loadAudio(songs[song_index]);
        ap = getAudioPlayer();
        ap.play();
        ab = ap.mix;

    }

    public void mousePressed() {

        // right arrow to change music
        if (mouseX > middleW + border && mouseX < middleW + border + gap2 && mouseY > border * 2 + 35
                && mouseY < border * 2 + 35 + gap2 / 2) {

            song_index += 1;
            println(song_index);
            println(songs.length);

            if (song_index > songs.length - 1) {
                song_index -= 1;
            }

            play_music();

        }

        // left arrow to change music
        if (mouseX > border * 3 - 15 && mouseX < border * 3 - 10 + gap2 && mouseY > border * 2 + gap2
                && mouseY < border * 2 + 20 + gap2 + gap2 / 2) {

            song_index -= 1;
            if (song_index < 0) {
                song_index += 1;
            }

            play_music();

        }

        // User Presses Start

    }

    // draw arrows
    void drawArrow(int x, int y, int size, float angle) {

        pushMatrix();
        translate(x, y);
        rotate(radians(angle));
        line(0, 0, size, 0);
        line(size, 0, size - 8, -8);
        line(size, 0, size - 8, 8);
        popMatrix();

    }

    void drawMainScreen() {

        textAlign(CENTER);
        textSize(40);
        fill(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        text("Game of Notes", middleW, border);
        fill(255);
        textSize(30);
        text("Choose Song", middleW, border * 2);
        text("Number of Players", middleW, border * 3);
        fill(0);
        rectMode(CENTER);
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        rect(middleW - 2, border * 5 - 10, map(getSmoothedAmplitude(), 0, 1, 90, 150),
                map(getSmoothedAmplitude(), 0, 1, 40, 80));
        fill(255);
        text("Start", middleW, border * 5);
        textSize(25);
        rectMode(CORNER);
        // display song name here
        text(display_names[song_index], middleW, border * 2 + gap);
        // display number of player here
        text(players[0], middleW, border * 3 + gap);

    }

    public void draw() {

        background(0);
        calculateAverageAmplitude();
        calculateFrequencyBands();
        drawMainScreen();
        // change text colour with amplitude
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        // change this after
        drawArrow(middleW + border, border * 2 + gap - 8, gap2, 0);
        drawArrow(border * 3 + 20, border * 2 + gap - 8, gap2, 179);
        drawArrow(middleW + border, border * 3 + gap - 8, gap2, 0);
        drawArrow(border * 3 + 20, border * 3 + gap - 8, gap2, 179);
        lines.draw_lines();
        robots.render(100, middleW + border / 2);
        robots.render(800, middleW + border / 2);
        spirals.draw_spirals();

        fill(255);

    }

}