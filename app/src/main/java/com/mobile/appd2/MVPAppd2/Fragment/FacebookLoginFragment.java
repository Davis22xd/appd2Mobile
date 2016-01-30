package com.mobile.appd2.MVPAppd2.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.widget.LoginButton;

import com.mobile.appd2.MVPAppd2.Presenter.FacebookLoginPresenter;
import com.mobile.appd2.MVPAppd2.Presenter.FacebookLoginPresenterImpl;
import com.mobile.appd2.MVPAppd2.R;
import com.mobile.appd2.MVPAppd2.UI.FacebookLoginActivity;
import com.mobile.appd2.MVPAppd2.View.LoginStateView;

/**
 * Created by david on 9/12/15.
 */
public class FacebookLoginFragment extends Fragment implements LoginStateView {

    private TextView textView;
    private FacebookLoginPresenter presenter;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    private Context mContext;

    private OnFragmentInteractionListener mListener;

    public FacebookLoginFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        presenter = new FacebookLoginPresenterImpl(this);
        presenter.createNewFacebookInstance();
        ((FacebookLoginActivity)getActivity()).updateWithToken(AccessToken.getCurrentAccessToken());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_facebook_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        textView = (TextView) view.findViewById(R.id.info);
        //profilePictureView = (ProfilePictureView) view.findViewById(R.id.friendProfilePicture);

        loginButton.setReadPermissions("user_friends");
        loginButton.setFragment(this);
        loginButton.setBackgroundResource(R.drawable.facebook_icon);
        loginButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        loginButton.setCompoundDrawablePadding(0);
        loginButton.setPadding(0, 0, 0, 0);
        loginButton.setText("");
        presenter.callFacebook(loginButton);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_CANCELED) {
            presenter.setResult(requestCode,resultCode,data);
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
    public void displayUserInfo(Profile profile){
        if(profile != null){
            textView.setText(profile.getName());
            setUserId(profile.getId());
            setUserName(profile.getName());
        }
        else{
            //textView.setText(null);
        }
    }

    @Override
    public void onSuccees(String msg) {
        Toast.makeText(
                mContext,
                msg,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(
                mContext,
                msg,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void checkLogin(AccessToken accessToken) {
        if(accessToken !=null)
        {
            getProfile();
            ((FacebookLoginActivity)getActivity()).updateWithToken(accessToken);
        }

    }

    @Override
    public boolean checkInternetStatus() {
        ConnectivityManager conMgr
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null)
            return false;
        if (!i.isConnected())
            return false;
        if (!i.isAvailable())
            return false;
        return true;
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stopTracking();
    }

    @Override
    public void onResume() {
        super.onResume();
        getProfile();
    }

    public void getProfile(){
        Profile profile = Profile.getCurrentProfile();
        displayUserInfo(profile);
        ((FacebookLoginActivity)getActivity()).setUserId(userId);
        ((FacebookLoginActivity)getActivity()).setUserName(userName);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}
