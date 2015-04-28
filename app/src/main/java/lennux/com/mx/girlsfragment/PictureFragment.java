package lennux.com.mx.girlsfragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PictureFragment.OnPictureCallbacks interface
 * to handle interaction events.
 * Use the {@link PictureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PictureFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private int position;

    private ImageView pictureGirl;
    private Button buttonGirl;

    private Intent intent;
    private String url;

    private OnPictureCallbacks mCallbacks;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position Parameter 1.
     * @return A new instance of fragment PictureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PictureFragment newInstance(int position) {
        PictureFragment fragment = new PictureFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    public PictureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_picture, container, false);
        pictureGirl = (ImageView) rootView.findViewById(R.id.im_fragmentPicture);
        buttonGirl = (Button) rootView.findViewById(R.id.bt_go);

        buttonGirl.setOnClickListener(this);

        lookGirl(position);

        return rootView;
    }

    public void lookGirl (int position){
        switch (position) {
            case 0:
                pictureGirl.setImageDrawable(getResources().getDrawable(R.mipmap.emma));
                url = "emmawatson?fref=ts";
                buttonGirl.setText("Ir al sitio de Emma Watson");
                break;
            case 1:
                pictureGirl.setImageDrawable(getResources().getDrawable(R.mipmap.katy));
                url = "katyperry?fref=ts";
                buttonGirl.setText("Ir al sitio de Katy Perry");
                break;
            case 2:
                pictureGirl.setImageDrawable(getResources().getDrawable(R.mipmap.maribel));
                url = "pages/Maribel-Guardia/111415578911214?fref=ts";
                buttonGirl.setText("Ir al sitio de Maribel Guardia");
                break;
            case 3:
                pictureGirl.setImageDrawable(getResources().getDrawable(R.mipmap.megan));
                url = "MeganFox?fref=ts";
                buttonGirl.setText("Ir al sitio de Megan Fox");
                break;
            case 4:
                pictureGirl.setImageDrawable(getResources().getDrawable(R.mipmap.jennifer));
                url = "JenniferLawrence?fref=ts";
                buttonGirl.setText("Ir al sitio de Jennifer");
                break;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
   /* public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (OnPictureCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                "http://www.facebook.com/"+ url));
        startActivity(intent);
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
    public interface OnPictureCallbacks {
        // TODO: Update argument type and name
        public void onGirlSelected(int position);
    }

}
