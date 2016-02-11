package com.mobile.appd2.MVPAppd2.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mobile.appd2.MVPAppd2.Adapter.RecyclerViewAdapter;
import com.mobile.appd2.MVPAppd2.Clases.Feeling;
import com.mobile.appd2.MVPAppd2.Presenter.FeelingsPresenter;
import com.mobile.appd2.MVPAppd2.Presenter.FeelingsPresenterImpl;
import com.mobile.appd2.MVPAppd2.R;
import com.mobile.appd2.MVPAppd2.UI.FeelingsActivity;
import com.mobile.appd2.MVPAppd2.View.FeelingsStateView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FeelingsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FeelingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeelingsFragment extends Fragment implements FeelingsStateView {

    private Context mContext;
    private FragmentActivity myContext;
    public Button btnNext;
    private int feeling;
    private OnFragmentInteractionListener mListener;
    private FeelingsPresenter feelingsPresenter;
    private GridLayoutManager lLayout;


    public static FeelingsFragment newInstance() {
        FeelingsFragment fragment = new FeelingsFragment();
        return fragment;
    }

    public FeelingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        feelingsPresenter = new FeelingsPresenterImpl(this);
        SharedPreferences preference = getActivity().getPreferences(mContext.MODE_PRIVATE);
        feelingsPresenter.getPreference(preference);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feelings, container, false);


        btnNext = (Button)rootView.findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feelingsPresenter.saveFeelings(feeling);
            }
        });

        List<Feeling> rowListItem = getAllItemList();
        lLayout = ((FeelingsActivity)getActivity()).createNewGrid();

        RecyclerView rView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);


        RecyclerViewAdapter rcAdapter = ((FeelingsActivity)getActivity()).createAdapter(rowListItem);
        rView.setAdapter(rcAdapter);

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

    private List<Feeling> getAllItemList(){

        List<Feeling> feelingList = new ArrayList<Feeling>();
        feelingList.add(new Feeling("Alternativo", R.drawable.alternativo));
        feelingList.add(new Feeling("Aventurero", R.drawable.alternativo));
        feelingList.add(new Feeling("Romántico", R.drawable.alternativo));
        feelingList.add(new Feeling("Relajado", R.drawable.alternativo));
        feelingList.add(new Feeling("Loco", R.drawable.alternativo));
        feelingList.add(new Feeling("Elegante", R.drawable.alternativo));

        return feelingList;
    }

}


