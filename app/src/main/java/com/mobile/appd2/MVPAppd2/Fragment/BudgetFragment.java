package com.mobile.appd2.MVPAppd2.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.mobile.appd2.MVPAppd2.App;
import com.mobile.appd2.MVPAppd2.Presenter.BudgetPresenter;
import com.mobile.appd2.MVPAppd2.Presenter.BudgetPresenterImpl;
import com.mobile.appd2.MVPAppd2.R;
import com.mobile.appd2.MVPAppd2.UI.BudgetActivity;
import com.mobile.appd2.MVPAppd2.UI.FacebookLoginActivity;
import com.mobile.appd2.MVPAppd2.View.BudgetStateView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BudgetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BudgetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BudgetFragment extends Fragment implements BudgetStateView {

    public Button btnNext;

    public TextView seekValue;

    private Context mContext;

    private OnFragmentInteractionListener mListener;

    private BudgetPresenter budgetPresenter;

    private int budget;


    public static BudgetFragment newInstance() {
        BudgetFragment fragment = new BudgetFragment();
        return fragment;
    }

    public BudgetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
       budgetPresenter = new BudgetPresenterImpl(this);
        SharedPreferences preference = getActivity().getPreferences(App.getStaticContext().MODE_PRIVATE);
        budgetPresenter.generateVoID(preference);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_budget, container, false);

        btnNext = (Button)rootView.findViewById(R.id.buttonNext);
        final SeekBar seekBar = (SeekBar)rootView.findViewById(R.id.seekBudget);
        seekValue = (TextView)rootView.findViewById(R.id.seekValue);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                budgetPresenter.saveBudget(budget);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekValue.setText(String.valueOf(progress));
                budget = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
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
        ((BudgetActivity)getActivity()).gotoAvailability();
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


