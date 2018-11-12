package com.example.ben.cs2340;

import android.app.Activity;
import android.drm.DrmStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.ben.cs2340.controllers.RegisterActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Before;
import org.junit.Test;
import android.view.View;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.concurrent.Executor;

public class ExampleUnitTest {

    String badEmail;
    String badPass;
    RegisterActivity mRegister;

    @Before
    public void initialize() {
        badEmail = "aBadEmailLol";
        badPass = "k";

        mRegister = mock(RegisterActivity.class);
    }

    @Test
    public void testInvalidEmail() {
        assertEquals(false, mRegister.verifyEmailAndPass(badEmail, badPass));
    }

}