package com.quaz.mycontactsdemo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {

    @GET("Contacts")
    Call<List<Contact>> getContacts();
}
