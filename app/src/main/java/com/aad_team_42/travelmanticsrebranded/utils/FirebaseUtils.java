package com.aad_team_42.travelmanticsrebranded.utils;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.aad_team_42.travelmanticsrebranded.BaseApplication;
import com.aad_team_42.travelmanticsrebranded.views.activities.MainActivity;
import com.aad_team_42.travelmanticsrebranded.views.activities.RegisterActivity;
import com.aad_team_42.travelmanticsrebranded.views.activities.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseUtils {
    private static final String TAG = FirebaseUtils.class.getSimpleName();

    private static FirebaseUtils firebaseUtils;
    private static FirebaseAuth mAuth;
    public static FirebaseDatabase mDatabase;
    public static DatabaseReference mRef;


    private FirebaseUtils() {
    }

    public static void initializeFirebase() {
        if (firebaseUtils == null) {
            firebaseUtils = new FirebaseUtils();
            mAuth = FirebaseAuth.getInstance();
            mDatabase = FirebaseDatabase.getInstance();
            mRef = mDatabase.getReference().child("explore");
        }
    }

    public static void signIn(final LoginActivity context, String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User successfully logged in");
                            FirebaseUser user = mAuth.getCurrentUser();
                            context.moveToActivity(user, context, MainActivity.class);
                        }
                    }
                });
    }

    public static void signUpUser(final RegisterActivity context, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "User successfully created");
                            FirebaseUser user = mAuth.getCurrentUser();
                            context.moveToActivity(user, context, LoginActivity.class);
                        }
                    }
                });
    }

    public static void signOutUser() {
        mAuth.signOut();
    }

    public static void attachStateListener(FirebaseAuth.AuthStateListener listener) {
        mAuth.addAuthStateListener(listener);
    }

    public static void detachStateListener(FirebaseAuth.AuthStateListener listener) {
        mAuth.removeAuthStateListener(listener);
    }
}
