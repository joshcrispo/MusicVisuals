package OurVisuals;

import processing.core.PApplet;
import processing.core.PConstants;
import ie.tudublin.Visual;

public class Stage 
{
    Visual visual;
    Menu menu;

    public Stage(Menu menu) {
        this.menu = menu;
    }
    
    
    int last = 0;
    int m = 0;
    int mode = 0;
    
    public void keyPressed() {
		if (menu.key >= '0' && menu.key <= '9') {
			mode = menu.key - '0';
		}
		if (menu.keyCode == ' ') {
            if (menu.ap.isPlaying()) {
                menu.ap.pause();
            } else {
                menu.ap.rewind();
                menu.ap.play();
            }
        }
	}

    public void render()
    { 
        float[] lerpedBuffer;
        lerpedBuffer = new float[menu.width];
        for(int i = 0 ; i < menu.ab.size() ; i ++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], menu.ab.get(i), 0.05f);
        }
        menu.background(0);
        menu.noFill();
        float halfH = menu.height / 2;
        int m = menu.millis();
        m = menu.millis()-last;

        float secondsToY = PApplet.map(m/10, 0, menu.ab.size(),0,465);
        
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;

        float cx = menu.width / 2;
        float cy = menu.height / 2;
        float stageEdgeLeft = cx/2;
        float stageEdgeRight = cx*1.5f;

        menu.stroke(255);

        //rectangle stage 
        menu.rectMode(PConstants.CENTER);
        menu.rect(cx, cy-100,cx+10, cx/4); 
        //robots
        //robot 1
        menu.textMode(PConstants.CENTER);
        menu.textSize(25); 
        menu.text("NO",(cx/1.5f-16), cy/2+5);
        menu.rect(cx/1.5f, cy/2, cx/7, cx/8);
        menu.rect(cx/1.5f, cy/2, cx/9, cx/10);
        menu.arc(cx/1.5f, cy/2-32, cx/8, cx/6,PConstants.PI, PConstants.TWO_PI); 
        menu.arc(cx/1.5f-15, cy/2-50, cx/30, cx/30, 0, PConstants.TWO_PI);
        menu.arc(cx/1.5f+15, cy/2-50, cx/30, cx/30, 0, PConstants.TWO_PI);
        menu.arc(cx/1.5f-15, cy/2-50, cx/50, cx/50, 0, PConstants.TWO_PI);
        menu.arc(cx/1.5f+15, cy/2-50, cx/50, cx/50, 0, PConstants.TWO_PI);
        //LEGS + SHOES  
        menu.line(cx/1.5f-20, cy/2+32, cx/1.5f-20 , cy/2+32+40 );
        menu.line(cx/1.5f-10, cy/2+32, cx/1.5f-10 , cy/2+32+53 );
        menu.line(cx/1.5f+20, cy/2+32, cx/1.5f+20 , cy/2+32+40 );
        menu.line(cx/1.5f+10, cy/2+32, cx/1.5f+10 , cy/2+32+53 ); 
        menu.arc(cx/1.5f-10, cy/2+32+53 , cx/8, cx/20,PConstants.PI,PConstants.PI+PConstants.HALF_PI); 
        menu.arc(cx/1.5f+10, cy/2+32+53 , cx/8, cx/20,PConstants.PI+PConstants.HALF_PI, PConstants.TWO_PI);   
            
        //Arm
        menu.arc(cx/1.5f-((cx/7)/2), cy/2+20 , cx/6, cx/6,PConstants.PI,PConstants.PI+PConstants.HALF_PI); 
        menu.arc(cx/1.5f-((cx/7)/2), cy/2+20 , cx/7, cx/7,PConstants.PI,PConstants.PI+PConstants.HALF_PI); 
        menu.arc(cx/1.5f+((cx/7)/2), cy/2+20-80 , cx/6, cx/6, 0, PConstants.HALF_PI); 
        menu.arc(cx/1.5f+ ((cx/7)/2), cy/2+20-80 , cx/7, cx/7, 0, PConstants.HALF_PI ); 
        //Hands
        menu.arc(cx/1.5f-((cx/7+cx/6)/2)+2,cx/2+38, cx/20, cx/20,PConstants.PI, PConstants.TWO_PI );
        menu.arc(cx/1.5f+((cx/7+cx/6)/2)-2,cx/2-70, cx/20, cx/20, 0,PConstants.PI ); 

        /* Attempting to do timing for it to dance
        //Arm
        arc((cx/1.5f)-((cx/7)/2), cy/2+20-80 , cx/6, cx/6, HALF_PI, PI); 
        arc((cx/1.5f)-((cx/7)/2), cy/2+20-80 , cx/7, cx/7, HALF_PI, PI); 
        arc((cx/1.5f)+((cx/7)/2), cy/2+20 , cx/6, cx/6, PI+HALFPConstants.TWO_PI);  
        arc((cx/1.5f)+((cx/7)/2), cy/2+20 , cx/7, cx/7, PI+HALFPConstants.TWO_PI); 
        //Hands
        arc((cx/1.5f)+((cx/7+cx/6)/2)-2,cx/2+28, cx/20, cx/20,PConstants.TWO_PI );
        arc((cx/1.5f)-((cx/7+cx/6)/2)+2,cx/2-80, cx/20, cx/20, 0, PI );
        */
        

        //robot 2
        menu.text("JAZZ",(cx/1.5f*2-27), cy/2+5);
        menu.rect((cx/1.5f*2), cy/2, cx/7, cx/8);
        menu.rect((cx/1.5f*2), cy/2, cx/9, cx/10);
        menu.arc(cx/1.5f*2, cy/2-32, cx/8, cx/6,PConstants.PI, PConstants.TWO_PI);
        menu.arc(cx/1.5f*2-15, cy/2-50, cx/30, cx/30, 0, PConstants.TWO_PI);
        menu.arc(cx/1.5f*2+15, cy/2-50, cx/30, cx/30, 0, PConstants.TWO_PI);
        menu.arc(cx/1.5f*2-15, cy/2-50, cx/50, cx/50, 0, PConstants.TWO_PI);
        menu.arc(cx/1.5f*2+15, cy/2-50, cx/50, cx/50, 0, PConstants.TWO_PI);
        //LEGS + SHOES   
        menu.line((cx/1.5f*2)-20, cy/2+32, (cx/1.5f*2)-20, cy/2+32+40 );
        menu.line((cx/1.5f*2)-10, cy/2+32, (cx/1.5f*2)-10, cy/2+32+53 );
        menu.line((cx/1.5f*2)+20, cy/2+32, (cx/1.5f*2)+20, cy/2+32+40 );
        menu.line((cx/1.5f*2)+10, cy/2+32, (cx/1.5f*2)+10, cy/2+32+53 );
        menu.arc((cx/1.5f*2)-10, cy/2+32+53 , cx/8, cx/20,PConstants.PI,PConstants.PI+PConstants.HALF_PI); 
        menu.arc((cx/1.5f*2)+10, cy/2+32+53 , cx/8, cx/20,PConstants.PI+PConstants.HALF_PI, PConstants.TWO_PI); 
        //ARMS
        menu.arc((cx/1.5f*2)-((cx/7)/2), cy/2+20-80 , cx/6, cx/6, PConstants.HALF_PI,PConstants.PI); 
        menu.arc((cx/1.5f*2)-((cx/7)/2), cy/2+20-80 , cx/7, cx/7, PConstants.HALF_PI,PConstants.PI); 
        menu.arc((cx/1.5f*2)+((cx/7)/2), cy/2+20 , cx/6, cx/6,PConstants.PI+PConstants.HALF_PI, PConstants.TWO_PI); 
        menu.arc((cx/1.5f*2)+ ((cx/7)/2), cy/2+20 , cx/7, cx/7,PConstants.PI+PConstants.HALF_PI, PConstants.TWO_PI); 
        //Hands
        menu.arc((cx/1.5f*2)+((cx/7+cx/6)/2)-2,cx/2+38, cx/20, cx/20,PConstants.PI, PConstants.TWO_PI );
        menu.arc((cx/1.5f*2)-((cx/7+cx/6)/2)+2,cx/2-70, cx/20, cx/20, 0,PConstants.PI );


        //triangle eye
        menu.triangle(cx,cy/3,cx+50,cy/2,cx-50,cy/2);
        menu.line(cx,cy/3+24,cx,cy/3+32);
        menu.line(cx-8,cy/3+32 ,cx-10,cy/3+26);
        menu.line(cx+8,cy/3+32 ,cx+10,cy/3+26);
        menu.arc(cx, cy/3+45, cx/12, cx/20, 0, PConstants.TWO_PI); 
        menu.arc(cx, cy/3+45, cx/60, cx/36, 0, PConstants.TWO_PI); 
        //bowtie
        menu.triangle(cx,cy/3+65,cx+15,cy/2-15,cx+15,cy/2-25);
        menu.triangle(cx,cy/3+65,cx-15,cy/2-15,cx-15,cy/2-25);
        //legs
        menu.line(cx-20, cy/2, cx-20, cy/2 +30);
        menu.line(cx-20, cy/2+30, cx-12, cy/2 +15);
        menu.line(cx-12, cy/2+15, cx-12, cy/2 +35);
        //right leg
        menu.line(cx+20, cy/2, cx+20, cy/2 +30);
        menu.line(cx+20, cy/2+30, cx+12, cy/2 +15);
        menu.line(cx+12, cy/2+15, cx+12, cy/2 +35);
        //arms
        //left
        menu.arc(cx-40, cy/3+35, cx/12, cx/8, PConstants.HALF_PI,PConstants.PI); 
        menu.arc(cx+40, cy/3+35, cx/12, cx/8, 0, PConstants.HALF_PI); 
        //hat
        menu.beginShape();
        menu.vertex(cx-20, cy/3);
        menu.vertex(cx-20, cy/3-5);
        menu.vertex(cx-10, cy/3-5);
        menu.vertex(cx-10, cy/3-40);
        menu.vertex(cx+10, cy/3-40);
        menu.vertex(cx+10, cy/3-5);
        menu.vertex(cx+20, cy/3-5);
        menu.vertex(cx+20, cy/3);
        menu.vertex(cx-20, cy/3);
        menu.endShape();
        
        
        menu.textSize(20);
        menu.text(m, cx,cy+100);
        //speakers
        //speaker left
        menu.rectMode(PConstants.CENTER);
        menu.rect(10, cy/5, 120, 365);
        menu.rect(130, cy/2+35, 120, 180);

        menu.rect(30, cy/2, 80, 180);

        //speaker circle left
        menu.arc(68, cy/3, cx/15, cx/15, 0, PConstants.TWO_PI); 
        menu.arc(68, cy/3, cx/10, cx/10, 0, PConstants.TWO_PI);   
        menu.arc(68, cy/3, cx/8, cx/8, 0, PConstants.TWO_PI);  
        //speaker smaller circles left
        //top
        menu.arc(68, cy/2+30+10, cx/20, cx/20, 0, PConstants.TWO_PI); 
        menu.arc(68, cy/2+30+10, cx/15, cx/15, 0, PConstants.TWO_PI);   
        menu.arc(68, cy/2+30+10, cx/12, cx/12, 0, PConstants.TWO_PI);  
        //middle    
        menu.arc(68, cy/2+30+50+10, cx/20, cx/20, 0, PConstants.TWO_PI); 
        menu.arc(68, cy/2+30+50+10, cx/15, cx/15, 0, PConstants.TWO_PI);   
        menu.arc(68, cy/2+30+50+10, cx/12, cx/12, 0, PConstants.TWO_PI);    
        //bottom
        menu.arc(68, cy/2+30+50+50+10, cx/20, cx/20, 0, PConstants.TWO_PI); 
        menu.arc(68, cy/2+30+50+50+10, cx/15, cx/15, 0, PConstants.TWO_PI);   
        menu.arc(68, cy/2+30+50+50+10, cx/12, cx/12, 0, PConstants.TWO_PI); 
        //left small speaker circle   

        menu.arc(190, cy/2+120, cx/15, cx/10, 0, PConstants.TWO_PI); 
        menu.arc(190, cy/2+120, cx/10, cx/8, 0, PConstants.TWO_PI);  
        menu.arc(190, cy/2+120, cx/8, cx/4, 0, PConstants.TWO_PI);      

        //speaker right
        menu.rect(menu.width-130, cy/5, 120, 365);
        menu.rect(menu.width-250, cy/2+35, 120, 180); 
        menu.rect(menu.width-110, cy/2, 80, 180);

        //speaker circle right
        menu.arc(954, cy/3, cx/15, cx/15, 0, PConstants.TWO_PI); 
        menu.arc(954, cy/3, cx/10, cx/10, 0, PConstants.TWO_PI);   
        menu.arc(954, cy/3, cx/8, cx/8, 0, PConstants.TWO_PI); 
        //speaker smaller circles left
        //top
        menu.arc(954, cy/2+30+10, cx/20, cx/20, 0, PConstants.TWO_PI); 
        menu.arc(954, cy/2+30+10, cx/15, cx/15, 0, PConstants.TWO_PI);   
        menu.arc(954, cy/2+30+10, cx/12, cx/12, 0, PConstants.TWO_PI);  
        //middle    
        menu.arc(954, cy/2+30+50+10, cx/20, cx/20, 0, PConstants.TWO_PI); 
        menu.arc(954, cy/2+30+50+10, cx/15, cx/15, 0, PConstants.TWO_PI);   
        menu.arc(954, cy/2+30+50+10, cx/12, cx/12, 0, PConstants.TWO_PI);    
        //bottom
        menu.arc(954, cy/2+30+50+50+10, cx/20, cx/20, 0, PConstants.TWO_PI); 
        menu.arc(954, cy/2+30+50+50+10, cx/15, cx/15, 0, PConstants.TWO_PI);   
        menu.arc(954, cy/2+30+50+50+10, cx/12, cx/12, 0, PConstants.TWO_PI);  
        //right small speaker circle
        menu.stroke(255); 
        menu.arc(menu.width-190, cy/2+120, cx/15, cx/10, 0, PConstants.TWO_PI); 
        menu.stroke(255);
        menu.arc(menu.width-190, cy/2+120, cx/10, cx/8, 0, PConstants.TWO_PI);  
        menu.stroke(255);
        menu.arc(menu.width-190, cy/2+120, cx/8, cx/4, 0, PConstants.TWO_PI);   
            
        //speaker effects
        //left 
        for(int i = 0 ; i < menu.ab.size() ; i +=20)
        {
            menu.noFill();
            float c = PApplet.map(i, 0, menu.ab.size(), 0, 255);
            menu.stroke(c, 255, 255);
            float f = menu.getAmplitude() * halfH * 3.0f;
            menu.arc(68, cy/3, f, f, 0, PConstants.TWO_PI);     

        }
        //right 
        for(int i = 0 ; i < menu.ab.size() ; i +=20)
        {
            menu.noFill();
            float c = PApplet.map(i, 0, menu.ab.size(), 0, 255);
            menu.stroke(c, 255, 255);
            float f = menu.getAmplitude() * halfH * 3.0f;
            menu.arc(954, cy/3, f, f, 0, PConstants.TWO_PI);     

        }
        
        //small speaker effect left
        for(int i = 0 ; i < menu.ab.size() ; i += 30)
        {
            menu.noFill();
            float c = PApplet.map(i, 0, menu.ab.size(), 0, 255);
            menu.stroke(c, 255, 255);
            float f = menu.getAmplitude() * halfH * 3.0f;
            menu.arc(190, cy/2+120, f, f, 0, PConstants.TWO_PI);     

        } 
        //small speaker effect right
        for(int i = 0 ; i < menu.ab.size() ; i += 30)
        {
            menu.noFill();
            float c = PApplet.map(i, 0, menu.ab.size(), 0, 255);
            menu.stroke(c, 255, 255);
            float f = menu.getAmplitude() * halfH * 3.0f;
            menu.arc(menu.width-190, cy/2+120, f, f, 0, PConstants.TWO_PI);     
        } 


        //waves
        for(int i = (int)stageEdgeLeft ; i < stageEdgeRight ; i ++)
            {
                // float c = map(ab.get(i), -1, 1, 0, 255);
                float c = PApplet.map(i - 25, 0, menu.ab.size(), 0, 255);
                menu.stroke(c, 255, 255);
                float f = lerpedBuffer[i] * 100/3.0f;
                menu.line(i, halfH-100 + f, i, halfH-100 - f);
                
                      
            }


        //lasers
        for(int i = 0; i<menu.ab.size();i+=120)
        { 
            float c = PApplet.map(i, 0, menu.ab.size(), 0, 255);
            menu.stroke(c, 255, 255);
            float f = menu.getAmplitude() * halfH * 4.0f;
            menu.line((cx/1.5f+((cx/7+cx/6)/2)-2),cx/2-70, menu.random(0, cx), menu.random(0 ,f-200));
            menu.line(((cx/1.5f*2)-((cx/7+cx/6)/2)+2),cx/2-70, menu.random(cx, menu.width), menu.random(0 ,f-200));
        }

        //scanning eye
        //timer every 10 second interval
        if(menu.millis() > last+20400){
            last = menu.millis();
        }
            if(m < 10200)
            {
                for(int i = 0; i<menu.ab.size();i+=20)
                { 
                    menu.stroke(255, 255, 255);
                    menu.line(cx,cy/3+45,i,secondsToY);
                }
            }
            else
            {   
            }
        
    } 
}        

