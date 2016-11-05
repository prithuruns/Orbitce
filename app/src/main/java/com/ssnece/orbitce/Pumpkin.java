package com.ssnece.orbitce;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.LinkedList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Pumpkin.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Pumpkin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pumpkin extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    GameAnime surface;
    int heights, widths;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pumpkin.
     */
    // TODO: Rename and change types and number of parameters
    public static Pumpkin newInstance(String param1, String param2) {
        Pumpkin fragment = new Pumpkin();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Pumpkin() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        surface = new GameAnime(this.getActivity());
        this.getActivity().setContentView(surface);

        DisplayMetrics ds = null;
       // ViewGroup.LayoutParams layoutParams= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
       // this.getActivity().addContentView(surface,layoutParams);
        ds = new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(ds);
        heights = ds.heightPixels;
        widths = ds.widthPixels;

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
         /*   try {
                FrameLayout frameLayout=new FrameLayout(getActivity());
                FrameLayout.LayoutParams ppar= new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                frameLayout.setLayoutParams(ppar);
                frameLayout.setId(R.id.container);
                Log.i("FL","got run");
            } catch (Exception e) {
                e.printStackTrace();
            }
           */ thre = new Thread(this);
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
                            canvas.drawBitmap(pumpkin.get(k), i * 200 , j * 200,
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

                holder.unlockCanvasAndPost(canvas);

            }
        }
    }

 /*   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containerina,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("Pumpkin layout ","Instantiated");
            return inflater.inflate(R.layout.fragment_pumpkin, containerina,false);



    }
*/
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
