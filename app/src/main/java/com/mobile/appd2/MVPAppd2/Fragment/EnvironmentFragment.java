package com.mobile.appd2.MVPAppd2.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.appd2.MVPAppd2.App;
import com.mobile.appd2.MVPAppd2.Presenter.EnvironmentPresenter;
import com.mobile.appd2.MVPAppd2.Presenter.EnvironmentPresenterImpl;
import com.mobile.appd2.MVPAppd2.R;

import com.mobile.appd2.MVPAppd2.UI.EnvironmentActivity;
import com.mobile.appd2.MVPAppd2.UI.FeelingsActivity;
import com.mobile.appd2.MVPAppd2.View.EnvironmentStateView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EnvironmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EnvironmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnvironmentFragment extends Fragment implements EnvironmentStateView {
    private Context mContext;
    private FragmentActivity myContext;
    public Button btnNature;
    public Button btnUrban;

    private int environment;

    private OnFragmentInteractionListener mListener;

    private EnvironmentPresenter environmentPresenter;


    public static EnvironmentFragment newInstance() {
        EnvironmentFragment fragment = new EnvironmentFragment();
        return fragment;
    }

    public EnvironmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        environmentPresenter = new EnvironmentPresenterImpl(this);
        SharedPreferences preference = getActivity().getPreferences(App.getStaticContext().MODE_PRIVATE);
        environmentPresenter.getPreference(preference);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_environment, container, false);

        btnNature = (Button)rootView.findViewById(R.id.buttonNature);
        btnNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                environment =1;
                environmentPresenter.saveEnvironment(environment);
            }
        });

        btnUrban = (Button)rootView.findViewById(R.id.buttonUrban);
        btnUrban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                environment =2;
                environmentPresenter.saveEnvironment(environment);
            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
        mContext = activity.getApplicationContext();

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

    @Override
    public void goNextStep() {
            ((EnvironmentActivity)getActivity()).gotoFeelings();

    }

    @Override
    public void onError(String msg) {
        Toast.makeText(
                mContext,
                msg,
                Toast.LENGTH_LONG).show();
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


