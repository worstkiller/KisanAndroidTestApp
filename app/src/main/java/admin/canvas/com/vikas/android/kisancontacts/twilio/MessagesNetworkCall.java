package admin.canvas.com.vikas.android.kisancontacts.twilio;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import admin.canvas.com.vikas.android.kisancontacts.BuildConfig;
import admin.canvas.com.vikas.android.kisancontacts.model.MessagesModel;
import admin.canvas.com.vikas.android.kisancontacts.twilio.ApiNetwork;
import admin.canvas.com.vikas.android.kisancontacts.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by OFFICE on 5/10/2017.
 */

public class MessagesNetworkCall {
    private final String TAG = MessagesNetworkCall.class.getName();
    private ApiNetwork apiNetwork;
    private OnMessagesReceive onReceiveMessages;

    public MessagesNetworkCall() {
        apiNetwork = new ApiNetwork();
    }

    public void getSentMessages() {
        apiNetwork.getNetworkService(BuildConfig.AUTHORIZATION, Constants.TWILIO_API_END).getListOFSmsSent(BuildConfig.ACCOUNT_SID)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.code() == 200) {
                            try {
                                if (!response.body().get("messages").getAsJsonArray().isJsonNull()) {
                                    Gson gson = new Gson();
                                    TypeToken<List<MessagesModel>> list = new TypeToken<List<MessagesModel>>() {
                                    };
                                    List<MessagesModel> messagesModelList = gson.fromJson(response.body().get("messages"), list.getType());
                                    onReceiveMessages.onReceive(messagesModelList);
                                } else {
                                    onReceiveMessages.onReceiveError();
                                }

                            } catch (NullPointerException | JsonIOException e) {
                                e.printStackTrace();
                                onReceiveMessages.onReceiveError();
                            }

                        } else {
                            onReceiveMessages.onReceiveError();
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        onReceiveMessages.onReceiveError();
                    }
                });
    }

    public void setOnReceiveResponse(OnMessagesReceive onReceiveResponse) {
        this.onReceiveMessages = onReceiveResponse;
    }

    public interface OnMessagesReceive {
        void onReceive(List<MessagesModel> messagesModels);

        void onReceiveError();
    }
}
