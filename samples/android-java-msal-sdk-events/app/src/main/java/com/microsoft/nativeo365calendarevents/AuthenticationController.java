package com.microsoft.nativeo365calendarevents;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.AuthenticationResult;
import com.microsoft.identity.client.MsalException;
import com.microsoft.identity.client.PublicClientApplication;

public class AuthenticationController {
  private final String TAG = AuthenticationController.class.getSimpleName();
  private static AuthenticationController INSTANCE;
  private static PublicClientApplication mApplication;
  private AuthenticationResult mAuthResult;
  private static Context context;

  private MSALAuthenticationCallback mActivityCallback;

  private AuthenticationController() {
  }

  public static synchronized AuthenticationController getInstance(Context ctx) {
    context = ctx;

    if (INSTANCE == null) {
      INSTANCE = new AuthenticationController();
      if (mApplication == null) {
        mApplication = new PublicClientApplication(context, Constants.CLIENT_ID);
      }
    }
    return INSTANCE;
  }

  public String getAccessToken() {
    return mAuthResult.getAccessToken();
  }

  public PublicClientApplication getPublicClient() {
    return mApplication;
  }

  public void doAcquireToken(Activity activity, final MSALAuthenticationCallback msalCallback) {
    mActivityCallback = msalCallback;
    mApplication.acquireToken(activity, Constants.SCOPES, getAuthInteractiveCallback());
  }

  private AuthenticationCallback getAuthInteractiveCallback() {
    return new AuthenticationCallback() {
      @Override
      public void onSuccess(AuthenticationResult authenticationResult) {
        Log.d(TAG, "Successfully authenticated");
        Log.d(TAG, "ID Token: " + authenticationResult.getIdToken());
        Log.d(TAG, "Access Token: " + authenticationResult.getAccessToken());

        mAuthResult = authenticationResult;
        if (mActivityCallback != null) {
          mActivityCallback.onMsalAuthSuccess(mAuthResult);
        }
      }

      @Override
      public void onError(MsalException exception) {
        if (mActivityCallback != null) {
          mActivityCallback.onMsalAuthError(exception);
        }
      }

      @Override
      public void onCancel() {
        if (mActivityCallback != null) {
          mActivityCallback.onMsalAuthCancel();
        }
      }
    };
  }

}
