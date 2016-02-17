package com.mobile.appd2.MVPAppd2.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mobile.appd2.MVPAppd2.Clases.PlanVo;
import com.mobile.appd2.MVPAppd2.CustomViews.CustomDialog;
import com.mobile.appd2.MVPAppd2.CustomViews.RecyclerViewAdapter;
import com.mobile.appd2.MVPAppd2.App;
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
    private PlanVo planVo;


    public static FeelingsFragment newInstance() {
        return new FeelingsFragment();
    }

    public FeelingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        feelingsPresenter = new FeelingsPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feelings, container, false);


//        btnNext = (Button)rootView.findViewById(R.id.buttonNext);
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                feelingsPresenter.saveFeelings(feeling);
//            }
//        });

        List<Feeling> rowListItem = getAllItemList();
        lLayout  =new GridLayoutManager(App.getStaticContext(), 2);

//        lLayout = ((FeelingsActivity)getActivity()).createNewGrid();

        RecyclerView rView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);
        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(App.getStaticContext(), rowListItem, this);

//        RecyclerViewAdapter rcAdapter = ((FeelingsActivity)getActivity()).createAdapter(rowListItem);
//        rcAdapter.setOnClickListener(new View.OnClickListener() {
//            @Override
//          public void onItemClick(View v) {
//                feelingsPresenter.saveFeelings(feeling);
//            }});

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

    @Override
    public void recyclerViewListClicked(View v, int position) {
        Toast.makeText(v.getContext(), "Clicked feeling Position = " + position, Toast.LENGTH_SHORT).show();
        feelingsPresenter.saveFeelings(position);

    }

    @Override
    public void showConfirmationPlan(String feeling) {
        planVo = ((FeelingsActivity)getActivity()).createPlan(feeling);
        CustomDialog cdd=new CustomDialog(myContext,planVo);
        cdd.show();
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
        void onFragmentInteraction(Uri uri);
    }

    private List<Feeling> getAllItemList(){

        List<Feeling> feelingList = new ArrayList<>();
        feelingList.add(new Feeling("Alternativo", R.drawable.alternativo));
        feelingList.add(new Feeling("Aventurero", R.drawable.aventurero));
        feelingList.add(new Feeling("Romántico", R.drawable.romantico));
        feelingList.add(new Feeling("Relajado", R.drawable.relajado));
        feelingList.add(new Feeling("Loco", R.drawable.loco));
        feelingList.add(new Feeling("Elegante", R.drawable.elegante));

        return feelingList;
    }

}


