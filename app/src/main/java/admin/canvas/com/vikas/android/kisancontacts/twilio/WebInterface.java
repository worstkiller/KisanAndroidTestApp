package admin.canvas.com.vikas.android.kisancontacts.twilio;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by vikas on 5/10/2017.
 */

public interface WebInterface {
    @FormUrlEncoded
    @POST("2010-04-01/Accounts/{ACCOUNT_SID}/SMS/Messages.json")
    Call<JsonObject> sendSms(@Path("ACCOUNT_SID") String ACCOUNT_SID, @Field("From") String From, @Field("To") String To, @Field("Body") String Body);

    @GET("2010-04-01/Accounts/{ACCOUNT_SID}/Messages.json")
    Call<JsonObject> getListOFSmsSent(@Path("ACCOUNT_SID") String ACCOUNT_SID);
}
