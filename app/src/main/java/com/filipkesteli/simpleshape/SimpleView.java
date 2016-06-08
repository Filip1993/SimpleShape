package com.filipkesteli.simpleshape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by programer on 8.6.2016..
 */
public class SimpleView extends View {

    private ShapeDrawable shapeDrawable;

    public SimpleView(Context context) {
        super(context);
        setFocusable(true);
        init();
    }

    private void init() {
        float[] R = new float[]{10, 10, 10, 10, 10, 10, 10, 10};
        RectF inset = new RectF(10, 10, 10, 10);
        //moramo inicijalizirati shapeDrawable
        shapeDrawable = new ShapeDrawable(new RoundRectShape(R, inset, null));
        shapeDrawable.getPaint().setColor(Color.CYAN);
    }

    int x = 30;
    int y = 50;

    @Override
    protected void onDraw(Canvas canvas) {
        //60 puta u sekundi se mora pozvati metoda onDraw()
        //canvas koji uzima neki rectangle
        //odvojen model
        //ajmo napravit nekakav shape, a nek se on nacrta na canvas
        int width = 300;
        int height = 50;
        shapeDrawable.setBounds(x, y, x + width, y + height);
        shapeDrawable.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();
        this.invalidate(); //ponovno pozovi metodu onDraw() -> NAJBITNIJE!!!
        return true;
    }
}
