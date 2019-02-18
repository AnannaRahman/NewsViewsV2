package com.appwiz.newsviews.Activity;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.appwiz.newsviews.R;
import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SocialLogInActivity extends AppCompatActivity {
    Toolbar toolbar;
    private LoginButton logInBtn;
    private CallbackManager callbackManager;
    private GraphRequest request;
    private ImageView imagePP;
    private TextInputEditText tvName, tvEmail, tvGender;
    private AccessTokenTracker accessTokenTracker;
    private RelativeLayout rlProfileDetails;

    private static final String EMAIL = "email";
    private static final String USER_POSTS = "user_posts";
    private static final String PUBLIC_PROFILE = "public_profile";
    private static final String AUTH_TYPE = "rerequest";

    private CallbackManager mCallbackManager;
    private RelativeLayout rlprofileDetails;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_log_in);
        imagePP = (ImageView) findViewById(R.id.imagePP);
        tvName = findViewById(R.id.tvName);
        rlprofileDetails = findViewById(R.id.rlprofileDetails);
        tvEmail = findViewById(R.id.tvEmail);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Social Log In");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mCallbackManager = CallbackManager.Factory.create();

        LoginButton mLoginButton = findViewById(R.id.btnFacebookLogin);

        // Set the initial permissions to request from the user while logging in
        //mLoginButton.setReadPermissions(Arrays.asList(EMAIL, PUBLIC_PROFILE));
        mLoginButton.setReadPermissions(Arrays.asList("public_profile", "email", "user_birthday", "user_friends", "user_likes", "user_posts"));

        mLoginButton.setAuthType(AUTH_TYPE);

        // Register a callback to respond to the user
        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                AccessToken aToken = loginResult.getAccessToken();

                request= GraphRequest.newMeRequest(aToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.v("AccessToken", request.getAccessToken().toString());
                        Log.v("LoginActivity", response.toString());
                        String id = object.optString("id", "");
                        String name = object.optString("name", "");
                        String email = object.optString("email", "");
                        String image_url = "http://graph.facebook.com/" + id + "/picture?type=large";
                        String user_birthday = object.optString("user_birthday", "");
                        String gender = object.optString("gender", "");
                        Log.v("LoginActivity", response.toString());
                        Glide.with(getBaseContext()).load(image_url).into(imagePP);
                        tvName.setText(name);
                        tvEmail.setText(email);
                        //tvGender.setText(gender);

                        //setResult(RESULT_OK);
                        //finish();

                    }
                });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,link,email,birthday,gender,location");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                setResult(RESULT_CANCELED);
                finish();
            }

            @Override
            public void onError(FacebookException e) {
                // Handle exception
                e.printStackTrace();
            }
        });


        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,
                                                       AccessToken currentAccessToken) {

                    /*FragmentManager manager = getSupportFragmentManager();
                    int backStackSize = manager.getBackStackEntryCount();
                    for (int i = 0; i < backStackSize; i++) {
                        manager.popBackStack();
                    }*/
                if (currentAccessToken != null) {
                    //showFragment(SELECTION, false);
                    rlprofileDetails.setVisibility(View.VISIBLE);
                    Log.v("Success", currentAccessToken.toString());
                } else {
                    //showFragment(SPLASH, false);
                    //rlprofileDetails.setVisibility(View.INVISIBLE);
                    Log.v("Logout", "No Token");

                    tvName.setText("");
                    tvEmail.setText("");
                    //tvGender.setText("");
                    Glide.with(getBaseContext()).load(R.drawable.com_facebook_profile_picture_blank_square).into(imagePP);
                }

            }
        };

    }
}
