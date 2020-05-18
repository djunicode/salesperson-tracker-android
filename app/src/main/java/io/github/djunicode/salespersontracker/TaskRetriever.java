package io.github.djunicode.salespersontracker;
import java.util.List;

import okhttp3.Call;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface TaskRetriever {
    String BASE_URL = "http://127.0.0.1:8000/Operations/";
    //@Headers("Authorization: Token e0b7118f129d7f81bf440df8846d6d1d979c8709")
  //  @GET("daily_target")
    // Call<List<DailyTask>> getDailyTasks();
}
