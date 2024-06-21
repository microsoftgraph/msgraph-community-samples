package com.microsoft.nativeo365calendarevents;

import com.microsoft.identity.client.AuthenticationResult;
import com.microsoft.identity.client.MsalException;

public interface MSALAuthenticationCallback {
    void onMsalAuthSuccess(AuthenticationResult authenticationResult);

    void onMsalAuthError(MsalException exception);

    void onMsalAuthError(Exception exception);

    void onMsalAuthCancel();
}
