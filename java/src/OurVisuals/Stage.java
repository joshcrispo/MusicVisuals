package OurVisuals;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Stage extends PApplet{

    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int last = 0;
    int m = 0;
    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    
    public void keyPressed() 
    {
        if (keyCode == ' ') 
        {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 

        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;

        lerpedBuffer = new float[width];
    }


    public void draw()
    {
        background(0);
        float halfH = height / 2;
        int m = millis();
        m = millis()-last;

        float secondsToY = map(m/10, 0, ab.size(),0,465);
        
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }

        float cx = width / 2;
        float cy = height / 2;
        float stageEdgeLeft = cx/2;
        float stageEdgeRight = cx*1.5f;

 
        switch (mode) {
			
        case 0: 
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
            arc(954, cy/3, cx/15, cx/15, 0, TWO_PI); 
            arc(954, cy/3, cx/10, cx/10, 0, TWO_PI);   
            arc(954, cy/3, cx/8, cx/8, 0, TWO_PI); 
            //speaker smaller circles left
            //top
            arc(954, cy/2+30+10, cx/20, cx/20, 0, TWO_PI); 
            arc(954, cy/2+30+10, cx/15, cx/15, 0, TWO_PI);   
            arc(954, cy/2+30+10, cx/12, cx/12, 0, TWO_PI);  
            //middle    
            arc(954, cy/2+30+50+10, cx/20, cx/20, 0, TWO_PI); 
            arc(954, cy/2+30+50+10, cx/15, cx/15, 0, TWO_PI);   
            arc(954, cy/2+30+50+10, cx/12, cx/12, 0, TWO_PI);    
            //bottom
            arc(954, cy/2+30+50+50+10, cx/20, cx/20, 0, TWO_PI); 
            arc(954, cy/2+30+50+50+10, cx/15, cx/15, 0, TWO_PI);   
            arc(954, cy/2+30+50+50+10, cx/12, cx/12, 0, TWO_PI);  
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
                arc(954, cy/3, f, f, 0, TWO_PI);     

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

    }        
}

