package com.aad_team_42.travelmanticsrebranded.utils;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.views.activities.ChooseSignIn;
import com.aad_team_42.travelmanticsrebranded.views.activities.MainActivity;
import com.aad_team_42.travelmanticsrebranded.views.activities.LoginActivity;
import com.aad_team_42.travelmanticsrebranded.views.activities.SignUpActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.auth.GoogleAuthProvider;

import java.lang.ref.WeakReference;


public class FirebaseUtils {
    private static final String TAG = FirebaseUtils.class.getSimpleName();

    private static FirebaseUtils firebaseUtils;
    private static FirebaseAuth mAuth;

    private static FirebaseDatabase mDatabase;
    public static DatabaseReference mRef;

    private static WeakReference<GoogleSignInClient> mClient;

    private FirebaseUtils() {
    }


    public static void initializeFirebase() {
        if (firebaseUtils == null) {
            firebaseUtils = new FirebaseUtils();
            mAuth = FirebaseAuth.getInstance();
            mDatabase = FirebaseDatabase.getInstance();
            mRef = mDatabase.getReference();
        }
    }

    public static void initializeGoogleSignIn(Context context) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.my_default_web_client_id))
                .requestEmail()
                .build();
        mClient = new WeakReference<>(GoogleSignIn.getClient(context, gso));
    }

    public static GoogleSignInClient getGoogleClient(){ return mClient.get(); }

    public static void firebaseAuthWithGoogle(final ChooseSignIn context, GoogleSignInAccount account){
        Log.d(TAG, "Account ID: " + account.getId());
        context.showProgress();
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User successfully logged in");
                            FirebaseUser user = mAuth.getCurrentUser();
                            context.moveToActivity(user, context, MainActivity.class);
                            context.finish();
                        } else {
                            Log.w(TAG, "Sign in failed: ", task.getException());
                        }
                    }
                });
    }

    public static void signInUserWithEmail(final LoginActivity context, String
            email, String password) {
        context.showProgressDialog();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User successfully logged in");
                            FirebaseUser user = mAuth.getCurrentUser();
                            context.moveToActivity(user, context, MainActivity.class);
                            context.finish();
                        } else {
                            Log.w(TAG, "Sign in failed: ", task.getException());
                        }
                    }
                });
    }

    public static void signUpUserWithEmail(final SignUpActivity context, final String name, String email, String password){
        context.showProgressDialog();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User successfully created");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(user != null) {
                                updateDisplayName(name, user);
                                context.moveToActivity(context, LoginActivity.class);
                                context.finish();
                            }
                        } else {
                            Log.w(TAG, "Sign up failed: ", task.getException());
                        }
                    }
                });
    }

    private static void updateDisplayName(String name, FirebaseUser user){
        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build();
        user.updateProfile(request)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "Profile successfully updated");
                        }
                    }
                });
    }


    public static void signOutUser(Activity context) {
        mAuth.signOut();
        mClient.get().signOut()
                .addOnCompleteListener(context, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.d(TAG, "User successfully signed out");
                    }
                });
    }

    public static void revokeAccess(Activity context) {
        mAuth.signOut();
        mClient.get().revokeAccess()
                .addOnCompleteListener(context, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.d(TAG, "User access successfully revoked");
                    }
                });

    }

    public static void attachStateListener(FirebaseAuth.AuthStateListener listener) {
        mAuth.addAuthStateListener(listener);
    }

    public static void detachStateListener(FirebaseAuth.AuthStateListener listener) {
        mAuth.removeAuthStateListener(listener);
    }
}

