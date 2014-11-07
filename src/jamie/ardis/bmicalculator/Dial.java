package jamie.ardis.bmicalculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import jamie.ardis.utils.Bmi;
import jamie.ardis.utils.Measurement;

public class Dial extends View {
	
	final float MAXDEGREES = 100;
	Measurement measure;
	Bmi bmi;
	Context context;
	float x = 50;
	float y = 200;
	float width;
	float height;
	Canvas canvas;
	
	public Dial(Context context){
		super(context);
		this.context = context;
	}
	
	private float getDegrees(Bmi bmi, Measurement measure){
		this.bmi=bmi;
		this.measure=measure;
		
		float b = (float) bmi.getBmi(measure);
		b -= 25; //set normal weight to 25
		float max = 25;//upper reach of 50
		
		return (width * (b/max));	
	}
	
	// this method is un-implemented
	private double getRadians(Bmi bmi, Measurement measure){
		return getDegrees(bmi, measure) * Math.PI/180;
	}
	
	Paint paint = new Paint();



    @Override
    public void onDraw(Canvas canvas) {
    	
    	this.canvas=canvas;
        width=canvas.getWidth();
        height=canvas.getHeight();
        
        setBackgroundColor(getResources().getColor(R.color.Grey));
        paint.setColor( Color.CYAN);
        paint.setStrokeWidth(2);
        
        if(bmi!=null)
        	x = getDegrees(bmi, measure);
        else
        	x = 0;
        
        canvas.translate(width/2, height); // set default origin for everything drawn within canvas (to half way along the canvas on bottom)
     	//x1,y1,x2,y2, paint
        canvas.drawLine(0, 0, x, -height, paint); 
        

    }
    public void refresh (Bmi bmi, Measurement measure)
    {
    	this.bmi=bmi;
    	height=canvas.getHeight();
    	width=canvas.getWidth();
    	x = getDegrees(bmi, measure);
    	
    	invalidate();//force repaint
    	
    }

}
