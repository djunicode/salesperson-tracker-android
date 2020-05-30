package io.github.djunicode.salespersontracker;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterfaceBill
{
    @Multipart
    @POST("/api/bill/")
    Call<BillResponseModel> billMethod (
            @Part ("Issued_To") RequestBody issuedTo,
            @Part ("Quantity") RequestBody quantity,
            @Part ("Buyer_Contact") RequestBody buyerContact,
            @Part ("Buyer_email") RequestBody buyerEmail,
            @Part ("SofyCopy") RequestBody softCopy,
            @Part ("Target_ref") RequestBody targetRef,
            @Part ("Salesperson_Ref") RequestBody salesperonRef,
            @Part ("item_ref") RequestBody itemRef
    );
}
