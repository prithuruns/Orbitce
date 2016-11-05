package com.ssnece.orbitce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.LinkedList;
import java.util.Random;

public class startScreen extends Activity implements View.OnTouchListener {

    GameAnime surface;
    int heights, widths;
    boolean running;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        surface = new GameAnime(this);
        setContentView(surface);
        DisplayMetrics ds = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(ds);
        heights = ds.heightPixels;
        widths = ds.widthPixels;

        surface.setOnTouchListener(this);
    }



    @Override
    protected void onPause() {
        super.onPause();
        surface.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        surface.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(surface.logo)
        {
            Intent intent = new Intent("com.ssnece.orbitce.nav_draw");
            startActivity(intent);

        }
        return true;


    }

    public class GameAnime extends SurfaceView implements Runnable {
        SurfaceHolder holder;
        Thread thre;
        Random rand;
        boolean  initialize, logo;
        Bitmap space, log, logo_name;
        LinkedList<Float> start_x, starts_y;
        LinkedList<Float> speed_x, speed_y;
        float logo_y;
        boolean walk=true;

        public GameAnime(Context context) {
            // TODO Auto-generated constructor stub
            super(context);
            holder = getHolder();
            running = initialize = true;
            logo = false;
            thre = new Thread(this);
            rand = new Random();
            thre.start();
            space = BitmapFactory.decodeResource(getResources(),
                    R.drawable.starts);
            log = BitmapFactory.decodeResource(getResources(),
                    R.drawable.summa_orbitce);
            logo_name = BitmapFactory.decodeResource(getResources(),
                    R.drawable.summa_name);
        }

        public void resume()
        {
            walk=true;
//                running=true;
//            logo = false;
//            running = initialize = true;;
//            rand = new Random();
//            thre = new Thread(this);
//            thre.start();
        }

        public void pause()
        {

            walk=false;
            //running=false;
       /*     while(true)
            {
                try {
                    thre.join();
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            thre=null;
       */ }


        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (running) {
                if (walk) {
                if (!holder.getSurface().isValid())
                    continue;
                Canvas canvas;

                canvas = holder.lockCanvas();

                canvas.drawColor(Color.BLACK);
                if (initialize) {
                    start_x = new LinkedList<Float>();
                    starts_y = new LinkedList<Float>();
                    speed_x = new LinkedList<Float>();
                    speed_y = new LinkedList<Float>();
                    // starts_1();
                    // starts_2();
                    start_3();
                    logo_y = heights / 2 - log.getHeight() / 2;
                    initialize = false;
                }
                // start_1_x += .5;
                // starts_1_y += .5;
                // if (starts_1_y > heights && start_1_x > widths) {
                // start_1_x = widths / 2;
                // starts_1_y = heights / 2;
                // }
                // start_1_x += 5;
                // starts_1_y += 5;
                // canvas.drawBitmap(space, widths / 2, heights / 2, null);
                // canvas.drawBitmap(space, start_1_x, starts_1_y, null);

                for (int i = 0; i < 40; i++) {
                    canvas.drawBitmap(space, start_x.get(i), starts_y.get(i),
                            null);
                    start_x.set(i, start_x.get(i) + speed_x.get(i));
                    starts_y.set(i, starts_y.get(i) + speed_y.get(i));


                    if ((start_x.get(i) > widths - widths / 10) || (start_x.get(i) < widths / 10)         //change the /10  to get faster logo start up.
                            || (starts_y.get(i) > heights - heights / 10)
                            || (starts_y.get(i) < heights / 10)) {
                        logo = true;

                    }
                    if ((start_x.get(i) > widths) || (start_x.get(i) < 0)
                            || (starts_y.get(i) > heights)
                            || (starts_y.get(i) < 0)) {
                        start_x.set(i, (float) (widths / 2));
                        starts_y.set(i, (float) (heights / 2));
                        logo = true;


                        if (speed_x.get(i) > 0)
                            speed_x.add((float) (rand.nextInt(50) + 1) / 15);
                        else
                            speed_x.add((float) (-1) * (rand.nextInt(50) + 1)
                                    / 15);
                        if (speed_y.get(i) > 0)
                            speed_y.add((float) (rand.nextInt(50) + 1) / 15);
                        else
                            speed_y.add((float) (-1) * (rand.nextInt(50) + 1)
                                    / 15);
                        // if (speed_x.get(i) < 0)
                        // speed_x.add((float) ((10 - rand.nextInt(10)) / 40));
                        // else
                        // speed_x.add((float) (-1)
                        // * ((10 - rand.nextInt(10)) / 40));
                        // if (speed_y.get(i) > heights)
                        // speed_y.add((float) (rand.nextInt(10) / 10));
                        // else
                        // speed_y.add((float) (-1) * (rand.nextInt(10) / 40));
                    }
                    // if ((starts_y.get(i) > heights) || (starts_y.get(i) < 0))
                    // {
                    // }
                }

                if (logo)
                    canvas.drawBitmap(log, widths / 2 - log.getWidth() / 2,
                            logo_y, null);
                if ((logo_y > heights / 6) && logo) {
                    logo_y += (heights / 6 - logo_y) / 50;
                }
                if (logo && ((heights / 6 - logo_y) / 50) < .5) {
                    canvas.drawBitmap(logo_name,
                            widths / 2 - logo_name.getWidth() / 2, heights / 2
                                    + heights / 6, null);
                }

                holder.unlockCanvasAndPost(canvas);

            }
            }
        }

        private void start_3() {
            // TODO Auto-generated method stub
            for (int i = 0; i < 10; i++) {
                start_x.add((float) (widths / 2));
                starts_y.add((float) (heights / 2));
                speed_x.add((float) (rand.nextInt(50) + 1) / 15);
                speed_y.add((float) (rand.nextInt(50) + 1) / 15);
            }
            for (int i = 0; i < 10; i++) {
                start_x.add((float) (widths / 2));
                starts_y.add((float) (heights / 2));
                speed_x.add((float) (-1) * (rand.nextInt(50) + 1) / 15);
                speed_y.add((float) (rand.nextInt(50) + 1) / 15);
            }
            for (int i = 0; i < 10; i++) {
                start_x.add((float) (widths / 2));
                starts_y.add((float) (heights / 2));
                speed_x.add((float) (rand.nextInt(50) + 1) / 15);
                speed_y.add((float) (-1) * (rand.nextInt(50) + 1) / 15);
            }
            for (int i = 0; i < 10; i++) {
                start_x.add((float) (widths / 2));
                starts_y.add((float) (heights / 2));
                speed_x.add((float) (-1) * (rand.nextInt(50) + 1) / 15);
                speed_y.add((float) (-1) * (rand.nextInt(50) + 1) / 15);
            }
        }

    }
}
