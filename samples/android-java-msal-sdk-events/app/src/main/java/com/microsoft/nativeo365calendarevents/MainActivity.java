package com.microsoft.nativeo365calendarevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.microsoft.identity.client.AuthenticationResult;
import com.microsoft.identity.client.MsalException;
import com.microsoft.identity.client.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MSALAuthenticationCallback {

  private final static String TAG = MainActivity.class.getSimpleName();

  private ProgressDialog progress;
  private ListView listEvents;
  private LinearLayout panelSignIn;
  private LinearLayout panelEvents;
  private LinearLayout panelLoadEvent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listEvents = findViewById(R.id.list_events);
    panelSignIn = findViewById(R.id.panel_signIn);
    panelEvents = findViewById(R.id.panel_events);
    panelLoadEvent = findViewById(R.id.panel_loadEvent);

    (findViewById(R.id.btn_signIn)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onSignin();
      }
    });

    (findViewById(R.id.btn_loadEvent)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onLoadEvents();
      }
    });

    setPanelVisibility(true, false, false);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private void onSignin() {
    AuthenticationController authController = AuthenticationController.getInstance(this);
    authController.doAcquireToken(this, this);
  }

  private void onLoadEvents() {
    MSGraphServiceController graphController = new MSGraphServiceController(this);

    progress = ProgressDialog.show(this, "Loading", "Loading first 20 events...");
    SettableFuture<List<String>> events = graphController.getEvents();
    Futures.addCallback(events, new FutureCallback<List<String>>() {
      @Override
      public void onSuccess(final List<String> result) {
        runOnUiThread(new Runnable() {
          @Override
          public void run() {
            Toast.makeText(MainActivity.this    , "Loaded events success!", Toast.LENGTH_LONG).show();
            progress.dismiss();
            bindEvents(result);
          }
        });
      }

      @Override
      public void onFailure(Throwable t) {

      }
    });
  }

  private void bindEvents(List<String> events) {
    setPanelVisibility(false, false, true);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, events);
    listEvents.setAdapter(adapter);
  }

  private void setPanelVisibility(Boolean showSignIn, Boolean showLoadEvents, Boolean showList) {
    panelSignIn.setVisibility(showSignIn ? View.VISIBLE : View.GONE);
    panelLoadEvent.setVisibility(showLoadEvents ? View.VISIBLE : View.GONE);
    panelEvents.setVisibility(showList ? View.VISIBLE : View.GONE);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (AuthenticationController.getInstance(this).getPublicClient() != null) {
      AuthenticationController.getInstance(this).getPublicClient().handleInteractiveRequestRedirect(requestCode, resultCode, data);
    }
  }

  //region MSALAuthenticationCallback() implementation
  // these methods are called by the AuthenticationController
  @Override
  public void onMsalAuthSuccess(AuthenticationResult authenticationResult) {
    User user = authenticationResult.getUser();

    Log.d(TAG, "Successfully authenticated");
    Log.d(TAG, "User logged in: " + user.getDisplayableId());

    Toast.makeText(MainActivity.this, "Hello " + user.getName() + " (" + user.getDisplayableId() + ")!", Toast.LENGTH_LONG).show();

    setPanelVisibility(false, true, false);
  }

  @Override
  public void onMsalAuthError(MsalException exception) {
    Log.e(TAG, "Error authenticated", exception);
  }

  @Override
  public void onMsalAuthError(Exception exception) {
    Log.e(TAG, "Error authenticated", exception);
  }

  @Override
  public void onMsalAuthCancel() {
    Log.d(TAG, "Cancel authenticated");
  }
  //endregion

}
