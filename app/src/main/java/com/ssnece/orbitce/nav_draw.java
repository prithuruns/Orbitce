package com.ssnece.orbitce;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class nav_draw extends AppCompatActivity
        implements
        NavigationDrawerFragment.NavigationDrawerCallbacks,
        Events.OnFragmentInteractionListener,
        Home.OnFragmentInteractionListener,
        help.OnFragmentInteractionListener,
        register.OnFragmentInteractionListener,
        tech_ev.OnFragmentInteractionListener,
        Scribblers.OnFragmentInteractionListener,
        Circuitrix.OnFragmentInteractionListener,
        ClashOfCircuits.OnFragmentInteractionListener,
        Electropati.OnFragmentInteractionListener,
        DomainMasters.OnFragmentInteractionListener,
        ProjectDisplay.OnFragmentInteractionListener,
        Riscit.OnFragmentInteractionListener,
        Solderit.OnFragmentInteractionListener,
        Pumpkin.OnFragmentInteractionListener,
        non_tech_ev.OnFragmentInteractionListener,
        Mock.OnFragmentInteractionListener,
        Mguru.OnFragmentInteractionListener,
        Wizard.OnFragmentInteractionListener,
        ethicalHacking.OnFragmentInteractionListener,
        Robotics.OnFragmentInteractionListener,
        Wired.OnFragmentInteractionListener,
        freeze.OnFragmentInteractionListener,
        silico.OnFragmentInteractionListener,
        panto.OnFragmentInteractionListener,
        onlinePhoto.OnFragmentInteractionListener,
        onlQuz.OnFragmentInteractionListener,
        treas.OnFragmentInteractionListener,
        map.OnFragmentInteractionListener,
        workshop.OnFragmentInteractionListener,
        View.OnClickListener {

    TextView textView;
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private boolean doubleBackToExitPressedOnce = false;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1344);
    public static int container = generateViewId();


    RelativeLayout rl;
    FrameLayout fl;
    GameAnime surface;
    int heights, widths;
    MediaPlayer bgm;
    ImageButton fb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_draw);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_draw);
        mTitle = getTitle();

        bgm = MediaPlayer.create(this, R.raw.orbitce);
        bgm.setLooping(true);

        fb = (ImageButton) findViewById(R.id.fb);
        fb.setOnClickListener(this);


        rl = (RelativeLayout) findViewById(R.id.rlmajor);
        fl = new FrameLayout(this);
        ViewGroup.LayoutParams layoutparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        fl.setLayoutParams(layoutparams);
        fl.setId(container);//generateViewId());
        // container=fl.getId();
        Log.i("container", Integer.toString(container));

        surface = new GameAnime(this);
        DisplayMetrics ds = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(ds);
        heights = ds.heightPixels;
        widths = ds.widthPixels;

        Log.i("work", "before adding views");
        rl.addView(surface);
        rl.addView(fl);


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(container, Home.newInstance())
                        //  .add(container,Home.newInstance("para" ,"sa"))
                .addToBackStack(null).commit();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


        Log.i("work", "end of create");
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (position) {
            case 0:
                while (fragmentManager.getBackStackEntryCount() > 0) {
                    fragmentManager.popBackStackImmediate();
                }
                fragmentManager.beginTransaction()
                        .replace(container, Home.newInstance())
                        .addToBackStack(null).commit();

                Log.i("work", "after first transaction");
                getSupportActionBar().setTitle(R.string.app_name);
                break;
            case 1:
                while (fragmentManager.getBackStackEntryCount() > 0) {
                    fragmentManager.popBackStackImmediate();
                }
                fragmentManager.beginTransaction()
                        .replace(container, Events.newInstance())
                        .addToBackStack(null).commit();

                getSupportActionBar().setTitle(R.string.app_name);

                break;
            case 2:
                while (fragmentManager.getBackStackEntryCount() > 0) {
                    fragmentManager.popBackStackImmediate();
                }
                fragmentManager.beginTransaction()
                        .replace(container, register.newInstance())
                        .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);

                break;
            case 3:

                while (fragmentManager.getBackStackEntryCount() > 0) {
                    fragmentManager.popBackStackImmediate();
                }
                fragmentManager.beginTransaction()
                        .replace(container, help.newInstance())
                        .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);

                break;
            case 4:

                while (fragmentManager.getBackStackEntryCount() > 0) {
                    fragmentManager.popBackStackImmediate();
                }
                fragmentManager.beginTransaction()
                        .replace(container, map.newInstance())
                        .addToBackStack(null).commit();
                getSupportActionBar().setTitle(R.string.app_name);

                break;
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(R.string.app_name);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStackImmediate();
        } else {
            this.moveTaskToBack(true);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            //   getMenuInflater().inflate(R.menu.nav_draw, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            getSupportActionBar().setTitle(R.string.app_name);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        if (v == fb) {
            Intent i = getOpenFacebookIntent(this);
            startActivity(i);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_nav_draw, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((nav_draw) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    public class GameAnime extends SurfaceView implements Runnable {
        SurfaceHolder holder;
        Thread thre;
        Random rand;
        boolean running, initialize;
        LinkedList<Bitmap> pumpkin, summa;
        LinkedList<Paint> paint;
        LinkedList<Integer> speed_alpha;
        int count_x, count_y;
        Paint summa_p;

        public GameAnime(Context context) {
            // TODO Auto-generated constructor stub
            super(context);
            holder = getHolder();
            // if(holder!=null)
            //     Log.i("holder null","false");
            pumpkin = new LinkedList<Bitmap>();
            summa = new LinkedList<Bitmap>();
            rand = new Random();
            paint = new LinkedList<Paint>();
            speed_alpha = new LinkedList<Integer>();

            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_1));
            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_2));
            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_3));
            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_4));
            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_5));
            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_6));
            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_7));
            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_8));
            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_9));
            summa.add(BitmapFactory.decodeResource(getResources(),
                    R.mipmap.pump_10));

            running = true;
            initialize = false;
            thre = new Thread(this);
            rand = new Random();
            thre.start();
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (running) {
                if (!holder.getSurface().isValid())
                    continue;
                Canvas canvas;

                canvas = holder.lockCanvas();

                //     if(canvas!=null)
                //       Log.i("canvas null","false");


                int k = 0;

                if (!initialize) {
                    count_x = widths / summa.get(0).getWidth() + 1;
                    count_y = heights / summa.get(0).getHeight() + 1;

                    for (int i = 0; i <= count_x; i++) {
                        for (int j = 0; j <= count_y; j++) {
                            pumpkin.add(summa.get(rand.nextInt(10)));
                            summa_p = new Paint();
                            if (rand.nextInt(2) < 1) {
                                summa_p.setAlpha(0);
                                speed_alpha.add(rand.nextInt(4) + 1);
                            } else {
                                summa_p.setAlpha(255);
                                speed_alpha.add((-1) * (rand.nextInt(4) + 1));
                            }
                            paint.add(summa_p);
                        }
                    }
                    initialize = true;
                }

                try {
                    canvas.drawColor(Color.BLACK);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                for (int i = 0; i <= count_x; i++) {
                    for (int j = 0; j < count_y; j++) {
                        try {
                            canvas.drawBitmap(pumpkin.get(k), i * 200, j * 200,
                                    paint.get(k));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (paint.get(k).getAlpha() + speed_alpha.get(k) > 249) {
                            speed_alpha.set(k, (-1) * (rand.nextInt(4) + 1));
                        } else if (paint.get(k).getAlpha() + speed_alpha.get(k) < 6) {
                            speed_alpha.set(k, rand.nextInt(4) + 1);
                            pumpkin.set(k, summa.get(rand.nextInt(10)));
                        }
                        paint.get(k).setAlpha(
                                paint.get(k).getAlpha() + speed_alpha.get(k));
                        k++;
                    }
                }

                try {
                    holder.unlockCanvasAndPost(canvas);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        public void pause() {
            running = false;
            while (true) {
                try {
                    thre.join();
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            thre = null;
        }

        public void resume() {

            running = true;
            initialize = false;
            thre = new Thread(this);
            rand = new Random();
            thre.start();

        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        surface.pause();
        bgm.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        surface.resume();
        bgm.start();
    }

    public static int generateViewId() {
        for (; ; ) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/538926402803697"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Orbitce?fref=ts"));
        }
    }
}
