package io.github.djunicode.salespersontracker;
import java.util.List;
import java.util.Map;

//ERROR: a type with the same simple name is already defined by the single-type-import of Call
//import retrofit2.Call;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;

public interface TaskRetriever {
    String BASE_URL = "http://jash271.pythonanywhere.com/Operations/";
    @GET("daily_target")
    Call<List<DailyTask>> getDailyTasks(@HeaderMap Map<String,String> header) ;
}
