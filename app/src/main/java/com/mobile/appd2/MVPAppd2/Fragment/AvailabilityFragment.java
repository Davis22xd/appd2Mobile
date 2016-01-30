package com.mobile.appd2.MVPAppd2.Fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.mobile.appd2.MVPAppd2.Presenter.AvailabilityPresenter;
import com.mobile.appd2.MVPAppd2.Presenter.AvailabilityPresenterImpl;
import com.mobile.appd2.MVPAppd2.Presenter.LoginPrenterImpl;
import com.mobile.appd2.MVPAppd2.Presenter.LoginPresenter;
import com.mobile.appd2.MVPAppd2.R;
import com.mobile.appd2.MVPAppd2.UI.AvailabilityActivity;
import com.mobile.appd2.MVPAppd2.UI.BudgetActivity;
import com.mobile.appd2.MVPAppd2.View.AvailabilityStateView;
import com.mobile.appd2.MVPAppd2.View.LoginStateView;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AvailabilityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AvailabilityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AvailabilityFragment extends Fragment implements AvailabilityStateView {
    private Context mContext;
    private FragmentActivity myContext;
    private TextView textViewDate;
    private TextView textViewTime;
    public Button btnNext;

    private int year;
    private int monthOfYear;
    private int dayOfMonth;
    private  int hourOfDay;
    private int minute;


    private OnFragmentInteractionListener mListener;

    private AvailabilityPresenter availabilityPresenter;


    public static AvailabilityFragment newInstance() {
        AvailabilityFragment fragment = new AvailabilityFragment();
        return fragment;
    }

    public AvailabilityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        availabilityPresenter = new AvailabilityPresenterImpl(this);
        SharedPreferences preference = getActivity().getPreferences(mContext.MODE_PRIVATE);
        availabilityPresenter.getPreference(preference);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_availability, container, false);
        textViewDate = (TextView)rootView.findViewById(R.id.textView3);
        textViewTime = (TextView)rootView.findViewById(R.id.textView4);

        btnNext = (Button)rootView.findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                availabilityPresenter.saveAvailability(year, monthOfYear, dayOfMonth, hourOfDay, minute);
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
            ((AvailabilityActivity)getActivity()).gotoFeelings();

    }

    @Override
    public void onError(String msg) {
        Toast.makeText(
                mContext,
                msg,
                Toast.LENGTH_LONG).show();
    }

    public void showDate(int year, int month, int day) {
        textViewDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void saveDate(int year, int month, int day) {
        this.year = year;
        this.monthOfYear = month;
        this.dayOfMonth = day;
    }

    public void showTime(int hour, int minute) {
        textViewTime.setText(new StringBuilder().append(hour).append("/")
                .append(minute));
    }

    public void savetTime(int hour, int minute) {
        this.hourOfDay = hour;
        this.minute = minute;
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


