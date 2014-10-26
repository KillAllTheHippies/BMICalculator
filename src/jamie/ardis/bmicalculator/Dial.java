package jamie.ardis.bmicalculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import jamie.ardis.utils.Bmi;
import jamie.ardis.utils.Measurement;

public class Dial extends View {
	
	final double MAXDEGREES = 30;
	Measurement measure;
	Bmi bmi;
	Context context;
	
	public Dial(Context context){
		super(context);
		this.context = context;
	}
	
	private double getDegrees(Bmi bmi, Measurement measure){
		this.bmi=bmi;
		this.measure=measure;
		
		double b = bmi.getBmi(measure);
		b -= 25; //set normal weight to 25
		double max = 25;//upper reach of 50
		
		return MAXDEGREES * (b/max);	
	}
	
	private double getRadians(Bmi bmi, Measurement measure){
		return getDegrees(bmi, measure) * Math.PI/180;
	}
	
	Paint paint = new Paint();



    @Override
    public void onDraw(Canvas canvas) {
        //if(bmi == null)return;
        
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(3);
        //x1,y1,x2,y2, paint
        canvas.drawLine(50, 50, 50, 100, paint);

    }

}
