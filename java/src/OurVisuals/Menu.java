package OurVisuals;

import ie.tudublin.Visual;
import ddf.minim.*;
import processing.core.*;

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

    //click
    boolean clicked = false;

    //timer variables
    int last = 0;
    int m = 0;

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

    public void mouseClicked()
    {
        // User Presses Start
        if (mouseX < width/2 + gap2 +2.5f && mouseX > width/2 - gap2 -2.5f && mouseY < border * 5
                && mouseY > border * 2 - 20) {

           stage();

        }
    }

    public void mousePressed() {

        // right arrow to change music
        if (mouseX > middleW + border && mouseX < middleW + border + gap2 && mouseY > border * 2 + 35
                && mouseY < border * 2 + 35 + gap2 / 2) {

            song_index += 1;
            println(song_index);
            println(songs.length);

            if (song_index > songs.length - 1) {
                song_index = 0;
            }

            play_music();

        }

        // left arrow to change music
        if (mouseX > border * 3 - 15 && mouseX < border * 3 - 10 + gap2 && mouseY > border * 2 + gap2
                && mouseY < border * 2 + 20 + gap2 + gap2 / 2) {

            song_index -= 1;
            if (song_index < 0) {
                song_index = 2;
            }

            play_music();

        }
        
        // User Presses Start
        if (mouseX < width/2 + gap2 +2.5f && mouseX > width/2 - gap2 -2.5f && mouseY < border * 5
                && mouseY > border * 2 - 20) {

           clicked = true;

        }
        


    }

    //draw stage
    void stage()
    {
        colorMode(HSB);
        background(0);
        float halfH = height / 2;
        int m = millis();
        m = millis()-last;

        float secondsToY = map(m/10, 0, ab.size(),0,465);
        
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }

        float cx = width / 2;
        float cy = height / 2;
        float stageEdgeLeft = cx/2;
        float stageEdgeRight = cx*1.5f;


            background(0);
            stroke(255);

            //rectangle stage 
            rectMode(CENTER);
            rect(cx, cy-100,cx+10, cx/4); 
            //robots
            //robot 1
            textMode(CENTER);
            textSize(25); 
            text("NO",(cx/1.5f-16), cy/2+5);
            rect(cx/1.5f, cy/2, cx/7, cx/8);
            rect(cx/1.5f, cy/2, cx/9, cx/10);
            arc(cx/1.5f, cy/2-32, cx/8, cx/6, PI, TWO_PI); 
            arc(cx/1.5f-15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
            arc(cx/1.5f+15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
            arc(cx/1.5f-15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
            arc(cx/1.5f+15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
            //LEGS + SHOES  
            line(cx/1.5f-20, cy/2+32, cx/1.5f-20 , cy/2+32+40 );
            line(cx/1.5f-10, cy/2+32, cx/1.5f-10 , cy/2+32+53 );
            line(cx/1.5f+20, cy/2+32, cx/1.5f+20 , cy/2+32+40 );
            line(cx/1.5f+10, cy/2+32, cx/1.5f+10 , cy/2+32+53 ); 
            arc(cx/1.5f-10, cy/2+32+53 , cx/8, cx/20, PI, PI+HALF_PI); 
            arc(cx/1.5f+10, cy/2+32+53 , cx/8, cx/20, PI+HALF_PI, TWO_PI);   
             
             //Arm
             arc(cx/1.5f-((cx/7)/2), cy/2+20 , cx/6, cx/6, PI, PI+HALF_PI); 
             arc(cx/1.5f-((cx/7)/2), cy/2+20 , cx/7, cx/7, PI, PI+HALF_PI); 
             arc(cx/1.5f+((cx/7)/2), cy/2+20-80 , cx/6, cx/6, 0, HALF_PI); 
             arc(cx/1.5f+ ((cx/7)/2), cy/2+20-80 , cx/7, cx/7, 0, HALF_PI ); 
             //Hands
             arc(cx/1.5f-((cx/7+cx/6)/2)+2,cx/2+28, cx/20, cx/20, PI, TWO_PI );
             arc(cx/1.5f+((cx/7+cx/6)/2)-2,cx/2-80, cx/20, cx/20, 0, PI ); 

            /* Attempting to do timing for it to dance
            //Arm
            arc((cx/1.5f)-((cx/7)/2), cy/2+20-80 , cx/6, cx/6, HALF_PI, PI); 
            arc((cx/1.5f)-((cx/7)/2), cy/2+20-80 , cx/7, cx/7, HALF_PI, PI); 
            arc((cx/1.5f)+((cx/7)/2), cy/2+20 , cx/6, cx/6, PI+HALF_PI, TWO_PI);  
            arc((cx/1.5f)+((cx/7)/2), cy/2+20 , cx/7, cx/7, PI+HALF_PI, TWO_PI); 
            //Hands
            arc((cx/1.5f)+((cx/7+cx/6)/2)-2,cx/2+28, cx/20, cx/20, PI, TWO_PI );
            arc((cx/1.5f)-((cx/7+cx/6)/2)+2,cx/2-80, cx/20, cx/20, 0, PI );
            */
            

            //robot 2
            text("JAZZ",(cx/1.5f*2-27), cy/2+5);
            rect((cx/1.5f*2), cy/2, cx/7, cx/8);
            rect((cx/1.5f*2), cy/2, cx/9, cx/10);
            arc(cx/1.5f*2, cy/2-32, cx/8, cx/6, PI, TWO_PI);
            arc(cx/1.5f*2-15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
            arc(cx/1.5f*2+15, cy/2-50, cx/30, cx/30, 0, TWO_PI);
            arc(cx/1.5f*2-15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
            arc(cx/1.5f*2+15, cy/2-50, cx/50, cx/50, 0, TWO_PI);
            //LEGS + SHOES   
            line((cx/1.5f*2)-20, cy/2+32, (cx/1.5f*2)-20, cy/2+32+40 );
            line((cx/1.5f*2)-10, cy/2+32, (cx/1.5f*2)-10, cy/2+32+53 );
            line((cx/1.5f*2)+20, cy/2+32, (cx/1.5f*2)+20, cy/2+32+40 );
            line((cx/1.5f*2)+10, cy/2+32, (cx/1.5f*2)+10, cy/2+32+53 );
            arc((cx/1.5f*2)-10, cy/2+32+53 , cx/8, cx/20, PI, PI+HALF_PI); 
            arc((cx/1.5f*2)+10, cy/2+32+53 , cx/8, cx/20, PI+HALF_PI, TWO_PI); 
            //ARMS
            arc((cx/1.5f*2)-((cx/7)/2), cy/2+20-80 , cx/6, cx/6, HALF_PI, PI); 
            arc((cx/1.5f*2)-((cx/7)/2), cy/2+20-80 , cx/7, cx/7, HALF_PI, PI); 
            arc((cx/1.5f*2)+((cx/7)/2), cy/2+20 , cx/6, cx/6, PI+HALF_PI, TWO_PI); 
            arc((cx/1.5f*2)+ ((cx/7)/2), cy/2+20 , cx/7, cx/7, PI+HALF_PI, TWO_PI); 
            //Hands
            arc((cx/1.5f*2)+((cx/7+cx/6)/2)-2,cx/2+28, cx/20, cx/20, PI, TWO_PI );
            arc((cx/1.5f*2)-((cx/7+cx/6)/2)+2,cx/2-80, cx/20, cx/20, 0, PI );


            //triangle eye
            triangle(cx,cy/3,cx+50,cy/2,cx-50,cy/2);
            line(cx,cy/3+24,cx,cy/3+32);
            line(cx-8,cy/3+32 ,cx-10,cy/3+26);
            line(cx+8,cy/3+32 ,cx+10,cy/3+26);
            arc(cx, cy/3+45, cx/12, cx/20, 0, TWO_PI); 
            arc(cx, cy/3+45, cx/60, cx/36, 0, TWO_PI); 
            //bowtie
            triangle(cx,cy/3+65,cx+15,cy/2-15,cx+15,cy/2-25);
            triangle(cx,cy/3+65,cx-15,cy/2-15,cx-15,cy/2-25);
            //legs
            line(cx-20, cy/2, cx-20, cy/2 +30);
            line(cx-20, cy/2+30, cx-12, cy/2 +15);
            line(cx-12, cy/2+15, cx-12, cy/2 +35);
            //right leg
            line(cx+20, cy/2, cx+20, cy/2 +30);
            line(cx+20, cy/2+30, cx+12, cy/2 +15);
            line(cx+12, cy/2+15, cx+12, cy/2 +35);
            //arms
            //left
            arc(cx-40, cy/3+35, cx/12, cx/8, HALF_PI, PI); 
            arc(cx+40, cy/3+35, cx/12, cx/8, 0, HALF_PI); 
            //hat
            beginShape();
            vertex(cx-20, cy/3);
            vertex(cx-20, cy/3-5);
            vertex(cx-10, cy/3-5);
            vertex(cx-10, cy/3-40);
            vertex(cx+10, cy/3-40);
            vertex(cx+10, cy/3-5);
            vertex(cx+20, cy/3-5);
            vertex(cx+20, cy/3);
            vertex(cx-20, cy/3);
            endShape();
            
            
            textSize(20);
            text(m, cx,cy+100);
            //speakers
            //speaker left
            rectMode(CORNER);
            rect(10, cy/5, 120, 365);
            rect(130, cy/2+35, 120, 180);

            rect(30, cy/2, 80, 180);

            //speaker circle left
            arc(68, cy/3, cx/15, cx/15, 0, TWO_PI); 
            arc(68, cy/3, cx/10, cx/10, 0, TWO_PI);   
            arc(68, cy/3, cx/8, cx/8, 0, TWO_PI);  
            //speaker smaller circles left
            //top
            arc(68, cy/2+30+10, cx/20, cx/20, 0, TWO_PI); 
            arc(68, cy/2+30+10, cx/15, cx/15, 0, TWO_PI);   
            arc(68, cy/2+30+10, cx/12, cx/12, 0, TWO_PI);  
            //middle    
            arc(68, cy/2+30+50+10, cx/20, cx/20, 0, TWO_PI); 
            arc(68, cy/2+30+50+10, cx/15, cx/15, 0, TWO_PI);   
            arc(68, cy/2+30+50+10, cx/12, cx/12, 0, TWO_PI);    
            //bottom
            arc(68, cy/2+30+50+50+10, cx/20, cx/20, 0, TWO_PI); 
            arc(68, cy/2+30+50+50+10, cx/15, cx/15, 0, TWO_PI);   
            arc(68, cy/2+30+50+50+10, cx/12, cx/12, 0, TWO_PI); 
            //left small speaker circle   

            arc(190, cy/2+120, cx/15, cx/10, 0, TWO_PI); 
            arc(190, cy/2+120, cx/10, cx/8, 0, TWO_PI);  
            arc(190, cy/2+120, cx/8, cx/4, 0, TWO_PI);      

            //speaker right
            rect(width-130, cy/5, 120, 365);
            rect(width-250, cy/2+35, 120, 180); 
            rect(width-110, cy/2, 80, 180);

            //speaker circle right
            arc(930, cy/3, cx/15, cx/15, 0, TWO_PI); 
            arc(930, cy/3, cx/10, cx/10, 0, TWO_PI);   
            arc(930, cy/3, cx/8, cx/8, 0, TWO_PI); 
            //speaker smaller circles right
            //top
            arc(930, cy/2+30+10, cx/20, cx/20, 0, TWO_PI); 
            arc(930, cy/2+30+10, cx/15, cx/15, 0, TWO_PI);   
            arc(930, cy/2+30+10, cx/12, cx/12, 0, TWO_PI);  
            //middle    
            arc(930, cy/2+30+50+10, cx/20, cx/20, 0, TWO_PI); 
            arc(930, cy/2+30+50+10, cx/15, cx/15, 0, TWO_PI);   
            arc(930, cy/2+30+50+10, cx/12, cx/12, 0, TWO_PI);    
            //bottom
            arc(930, cy/2+30+50+50+10, cx/20, cx/20, 0, TWO_PI); 
            arc(930, cy/2+30+50+50+10, cx/15, cx/15, 0, TWO_PI);   
            arc(930, cy/2+30+50+50+10, cx/12, cx/12, 0, TWO_PI);  
            //right small speaker circle 
            arc(width-190, cy/2+120, cx/15, cx/10, 0, TWO_PI); 
            arc(width-190, cy/2+120, cx/10, cx/8, 0, TWO_PI);  
            arc(width-190, cy/2+120, cx/8, cx/4, 0, TWO_PI);   
             
            //speaker effects
            //left 
            for(int i = 0 ; i < ab.size() ; i +=20)
            {
                noFill();
                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH * 3.0f;
                arc(68, cy/3, f, f, 0, TWO_PI);     

            }
            //right 
            for(int i = 0 ; i < ab.size() ; i +=20)
            {
                noFill();
                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH * 3.0f;
                arc(930, cy/3, f, f, 0, TWO_PI);     

            }
            
            //small speaker effect left
            for(int i = 0 ; i < ab.size() ; i += 30)
            {
                noFill();
                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH * 3.0f;
                arc(190, cy/2+120, f, f, 0, TWO_PI);     

            } 
            //small speaker effect right
            for(int i = 0 ; i < ab.size() ; i += 30)
            {
                noFill();
                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH * 3.0f;
                arc(width-190, cy/2+120, f, f, 0, TWO_PI);     
            } 


            //waves
            for(int i = (int)stageEdgeLeft ; i < stageEdgeRight ; i +=8)
            {
                //float c = map(ab.get(i), -1, 1, 0, 255);
                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH/3;
                constrain(f,0,cx/2);
                line(i, halfH-100+ f, i, halfH-100 - f);                    
            }


            //lasers
            for(int i = 0; i<ab.size();i+=120)
            { 
                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH * 4.0f;
                line((cx/1.5f+((cx/7+cx/6)/2)-2),cx/2-80,random(0, cx),random(0 ,f-200));
                line(((cx/1.5f*2)-((cx/7+cx/6)/2)+2),cx/2-80,random(cx, width),random(0 ,f-200));
            }

            //scanning eye
            //timer every 10 second interval
            if(millis() > last+20400){
                last = millis();
            }
                if(m < 10200)
                {
                    for(int i = 0; i<ab.size();i+=20)
                    { 
                        stroke(255, 255, 255);
                        line(cx,cy/3+45,i,secondsToY);
                    }
                }
                else
                {   
                }
            
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

       // User Presses Start
       if (clicked == true)
       {
            stage();
       }
    }

}