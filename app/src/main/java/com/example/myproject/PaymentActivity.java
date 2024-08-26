package com.example.myproject;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.Model.AccessToken;
import com.example.myproject.Model.STKPush;
import com.example.myproject.databinding.ActivityPaymentBinding;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    private DarajaApiClient mApiClient;
    private ProgressDialog mProgressDialog;
    private ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mProgressDialog = new ProgressDialog(this);
        mApiClient = new DarajaApiClient();
        mApiClient.setIsDebug(true); // Set True to enable logging, false to disable.

        binding.btnPay.setOnClickListener(this);

        getAccessToken();
    }

    public void getAccessToken() {
        mApiClient.setGetAccessToken(true);
        mApiClient.mpesaService().getAccessToken().enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(@NonNull Call<AccessToken> call, @NonNull Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    mApiClient.setAuthToken(response.body().accessToken);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AccessToken> call, @NonNull Throwable t) {
                // Handle failure
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == binding.btnPay) {
            String phone_number = binding.etPhone.getText().toString();
            String amount = binding.etAmount.getText().toString();
            performSTKPush(phone_number, amount);
        }
    }

    public void performSTKPush(String phone_number, String amount) {
        mProgressDialog.setMessage("Processing your request");
        mProgressDialog.setTitle("Please Wait...");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
        String timestamp = Utils.getTimestamp();
        String toEncode =  "business short code"+ "passkey" + timestamp;

        // Step 2: Convert the concatenated string to a byte array
        byte[] byteArray = toEncode.getBytes(StandardCharsets.UTF_8);

        // Step 3: Encode the byte array using Base64
        String encodedPassword;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encodedPassword = Base64.getEncoder().encodeToString(byteArray);
        } else {
            encodedPassword = android.util.Base64.encodeToString(byteArray, android.util.Base64.NO_WRAP);
        }
        STKPush stkPush = new STKPush(
                "174379",  // BusinessShortCode
                encodedPassword,  // Password
                timestamp,  // Timestamp
                "CustomerPayBillOnline",  // TransactionType
                Integer.parseInt(amount),  // Amount
                "0743411856",  // PartyA
                "174379",  // PartyB
                Utils.sanitizePhoneNumber(phone_number) ,  // PhoneNumber
                "https://mydomain.com/path",  // CallBackURL
                "CompanyXLTD",  // AccountReference
                "Payment of X"  // TransactionDesc
        );

        mApiClient.setGetAccessToken(false);

        mApiClient.mpesaService().sendPush(stkPush).enqueue(new Callback<STKPush>() {
            @Override
            public void onResponse(@NonNull Call<STKPush> call, @NonNull Response<STKPush> response) {
                mProgressDialog.dismiss();
                try {
                    if (response.isSuccessful()) {
                        Timber.d("post submitted to API. %s", response.body());
                    } else {
                        Timber.e("Response %s", response.errorBody().string());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void
            onFailure(@NonNull Call<STKPush> call, @NonNull Throwable t) {
                mProgressDialog.dismiss();
                Timber.e(t);
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}