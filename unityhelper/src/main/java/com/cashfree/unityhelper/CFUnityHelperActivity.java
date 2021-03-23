package com.cashfree.unityhelper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cashfree.pg.CFPaymentService;
import com.unity3d.player.UnityPlayer;

import java.util.HashMap;

import static com.cashfree.pg.CFPaymentService.REQ_CODE;

public class CFUnityHelperActivity extends AppCompatActivity {

    public static final String TAG = "CFUnityHelperActivity";
    public static final String WEB_CHECKOUT = "WebCheckout";
    public static final String UPIINTENT = "UPIIntent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        HashMap<String, String> inputParams = new HashMap<>();
        for (String key :
                extras.keySet()) {
            Log.d(TAG, String.format("%s\t: %s", key, extras.getString(key)));
            inputParams.put(key, extras.getString(key));
        }

        if (inputParams.containsKey(com.cashfree.unityhelper.CFUnityHelperService.FUNCTION)) {
            switch (inputParams.get(com.cashfree.unityhelper.CFUnityHelperService.FUNCTION)) {
                case WEB_CHECKOUT: {
                    CFPaymentService cfPaymentService = CFPaymentService.getCFPaymentServiceInstance();
                    cfPaymentService.doPayment(this, inputParams, extras.getString("TOKEN"), extras.getString("stage"));
                    break;
                }
                case UPIINTENT: {
                    CFPaymentService cfPaymentService = CFPaymentService.getCFPaymentServiceInstance();
                    cfPaymentService.upiPayment(this, inputParams, extras.getString("TOKEN"), extras.getString("stage"));
                    break;
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            //Same request code for all payment APIs.
            Log.d(TAG, "ReqCode : " + CFPaymentService.REQ_CODE);
            Log.d(TAG, "API Response : ");
            //Prints all extras. Replace with app logic.
            if (requestCode == CFPaymentService.REQ_CODE && data != null) {
                Bundle  bundle = data.getExtras();
                if (bundle != null) {
                    for (String key : bundle.keySet()) {
                        if (bundle.getString(key) != null) {
                            Log.d(TAG, key + " : " + bundle.getString(key));
                            if (key.equals("txResult")) {
                                UnityPlayer.UnitySendMessage("CFPaymentResult", "handleResult", bundle.getString("txResult"));
                            }
                        }
                    }
                }
            }
        }
}