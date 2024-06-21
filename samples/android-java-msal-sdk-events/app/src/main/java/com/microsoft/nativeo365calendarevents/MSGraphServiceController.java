package com.microsoft.nativeo365calendarevents;

import android.content.Context;
import android.util.Log;
import com.google.common.util.concurrent.SettableFuture;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.Event;
import com.microsoft.graph.extensions.IEventCollectionPage;
import com.microsoft.graph.extensions.IEventCollectionRequest;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.options.Option;
import com.microsoft.graph.options.QueryOption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MSGraphServiceController {
  private final static String TAG = MSGraphServiceController.class.getSimpleName();
  private final IGraphServiceClient graphClient;
  final List<String> events = new ArrayList<>();

  public MSGraphServiceController(Context context) {
    graphClient = MSGraphServiceClientManager.getInstance(context).getGraphServiceClient();
  }

  public SettableFuture<List<String>> getEvents() {
    final SettableFuture<List<String>> result = SettableFuture.create();

    IEventCollectionRequest request = graphClient.getMe().getEvents().buildRequest(
      Arrays.asList(new Option[]{
        new QueryOption("$select", "subject,start,end"),
        new QueryOption("$top", "20"),
        new QueryOption("$skip", "0")
      })
    );
    
    Log.d(TAG, "Request object: " + request.toString());

    request.get(new ICallback<IEventCollectionPage>() {
      @Override
      public void success(IEventCollectionPage page) {
        List<Event> listOfEvents = page.getCurrentPage();
        for (Event item : listOfEvents) {
          events.add(item.subject);
        }
        result.set(events);
      }

      @Override
      public void failure(ClientException ex) {
        ex.printStackTrace();
      }
    });

    return result;
  }
}