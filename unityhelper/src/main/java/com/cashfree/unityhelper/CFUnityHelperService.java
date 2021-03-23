package com.cashfree.unityhelper;

import android.app.Activity;
import android.content.Intent;


import com.cashfree.pg.CFPaymentService;

import static com.cashfree.pg.CFPaymentService.PARAM_APP_ID;
import static com.cashfree.pg.CFPaymentService.PARAM_BANK_CODE;
import static com.cashfree.pg.CFPaymentService.PARAM_CARD_CVV;
import static com.cashfree.pg.CFPaymentService.PARAM_CARD_HOLDER;
import static com.cashfree.pg.CFPaymentService.PARAM_CARD_MM;
import static com.cashfree.pg.CFPaymentService.PARAM_CARD_NUMBER;
import static com.cashfree.pg.CFPaymentService.PARAM_CARD_YYYY;
import static com.cashfree.pg.CFPaymentService.PARAM_CUSTOMER_EMAIL;
import static com.cashfree.pg.CFPaymentService.PARAM_CUSTOMER_NAME;
import static com.cashfree.pg.CFPaymentService.PARAM_CUSTOMER_PHONE;
import static com.cashfree.pg.CFPaymentService.PARAM_NOTIFY_URL;
import static com.cashfree.pg.CFPaymentService.PARAM_ORDER_AMOUNT;
import static com.cashfree.pg.CFPaymentService.PARAM_ORDER_CURRENCY;
import static com.cashfree.pg.CFPaymentService.PARAM_ORDER_ID;
import static com.cashfree.pg.CFPaymentService.PARAM_ORDER_NOTE;
import static com.cashfree.pg.CFPaymentService.PARAM_PAYMENT_OPTION;
import static com.cashfree.pg.CFPaymentService.PARAM_UPI_VPA;
import static com.cashfree.pg.CFPaymentService.PARAM_WALLET_CODE;

public class CFUnityHelperService {

    public static final String TOKEN = "TOKEN";
    public static final String FUNCTION = "function";

    public static void startUPIIntentPayment(
            Activity activity,
            String appId,
            String token,
            String orderId,
            String orderAmount,
            String orderCurrency,
            String customerPhoneNumber,
            String customerEmailId,
            String orderNote,
            String customerName,
            String notifyUrl
    ) {
        Intent unityHelperIntent = new Intent(activity, CFUnityHelperActivity.class);
        unityHelperIntent.putExtra(FUNCTION, CFUnityHelperActivity.UPIINTENT);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_APP_ID, appId);
        unityHelperIntent.putExtra(TOKEN, token);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_ID, orderId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_AMOUNT, orderAmount);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, orderCurrency);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_PHONE, customerPhoneNumber);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_EMAIL, customerEmailId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_NOTIFY_URL, notifyUrl);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, "INR");
        if (customerName != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_NAME, customerName);
        if (orderNote != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_NOTE, orderNote);
        activity.startActivityForResult(unityHelperIntent, 1011);
    }
    public static void startWebCheckout(
            Activity activity,
            String appId,
            String token,
            String orderId,
            String orderAmount,
            String orderCurrency,
            String customerPhoneNumber,
            String customerEmailId,
            String orderNote,
            String customerName,
            String notifyUrl
    ) {
        Intent unityHelperIntent = new Intent(activity, CFUnityHelperActivity.class);
        unityHelperIntent.putExtra(FUNCTION, CFUnityHelperActivity.WEB_CHECKOUT);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_APP_ID, appId);
        unityHelperIntent.putExtra(TOKEN, token);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_ID, orderId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_AMOUNT, orderAmount);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, orderCurrency);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_PHONE, customerPhoneNumber);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_EMAIL, customerEmailId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_NOTIFY_URL, notifyUrl);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, "INR");
        if (customerName != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_NAME, customerName);
        if (orderNote != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_NOTE, orderNote);
        activity.startActivityForResult(unityHelperIntent, 1011);
    }
    public static void startSeamlessUPICollectPayment(
            Activity activity,
            String appId,
            String token,
            String orderId,
            String orderAmount,
            String orderCurrency,
            String customerPhoneNumber,
            String customerEmailId,
            String orderNote,
            String customerName,
            String customerVPA,
            String notifyUrl
    ) {
        Intent unityHelperIntent = new Intent(activity, CFUnityHelperActivity.class);
        unityHelperIntent.putExtra(FUNCTION, CFUnityHelperActivity.WEB_CHECKOUT);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_APP_ID, appId);
        unityHelperIntent.putExtra(TOKEN, token);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_ID, orderId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_AMOUNT, orderAmount);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, orderCurrency);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_PHONE, customerPhoneNumber);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_EMAIL, customerEmailId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_NOTIFY_URL, notifyUrl);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, "INR");
        unityHelperIntent.putExtra(CFPaymentService.PARAM_PAYMENT_OPTION, "upi");
        unityHelperIntent.putExtra(CFPaymentService.PARAM_UPI_VPA, customerVPA);// Put correct upi vpa here
        if (customerName != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_NAME, customerName);
        if (orderNote != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_NOTE, orderNote);
        activity.startActivityForResult(unityHelperIntent, 1011);
    }
    public static void startSeamlessWalletPayment(
            Activity activity,
            String appId,
            String token,
            String orderId,
            String orderAmount,
            String orderCurrency,
            String customerPhoneNumber,
            String customerEmailId,
            String orderNote,
            String customerName,
            String walletCode,
            String notifyUrl
    ) {
        Intent unityHelperIntent = new Intent(activity, CFUnityHelperActivity.class);
        unityHelperIntent.putExtra(FUNCTION, CFUnityHelperActivity.WEB_CHECKOUT);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_APP_ID, appId);
        unityHelperIntent.putExtra(TOKEN, token);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_ID, orderId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_AMOUNT, orderAmount);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, orderCurrency);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_PHONE, customerPhoneNumber);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_EMAIL, customerEmailId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_NOTIFY_URL, notifyUrl);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, "INR");
        unityHelperIntent.putExtra(CFPaymentService.PARAM_PAYMENT_OPTION, "wallet");
        unityHelperIntent.putExtra(CFPaymentService.PARAM_WALLET_CODE, walletCode); // Put correct wallet code https://dev.cashfree.com/payment-gateway/payments/wallets
        if (customerName != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_NAME, customerName);
        if (orderNote != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_NOTE, orderNote);
        activity.startActivityForResult(unityHelperIntent, 1011);
    }
    public static void startSeamlessNetBankingPayment(
            Activity activity,
            String appId,
            String token,
            String orderId,
            String orderAmount,
            String orderCurrency,
            String customerPhoneNumber,
            String customerEmailId,
            String orderNote,
            String customerName,
            String bankCode,
            String notifyUrl
    ) {
        Intent unityHelperIntent = new Intent(activity, CFUnityHelperActivity.class);
        unityHelperIntent.putExtra(FUNCTION, CFUnityHelperActivity.WEB_CHECKOUT);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_APP_ID, appId);
        unityHelperIntent.putExtra(TOKEN, token);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_ID, orderId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_AMOUNT, orderAmount);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, orderCurrency);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_PHONE, customerPhoneNumber);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_EMAIL, customerEmailId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_NOTIFY_URL, notifyUrl);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, "INR");
        unityHelperIntent.putExtra(CFPaymentService.PARAM_PAYMENT_OPTION, "nb");
        unityHelperIntent.putExtra(CFPaymentService.PARAM_BANK_CODE, bankCode); // Put correct bank code from https://dev.cashfree.com/payment-gateway/payments/netbanking
        if (customerName != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_NAME, customerName);
        if (orderNote != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_NOTE, orderNote);
        activity.startActivityForResult(unityHelperIntent, 1011);
    }

    public static void startSeamlessCardPayment(
            Activity activity,
            String appId,
            String token,
            String orderId,
            String orderAmount,
            String orderCurrency,
            String customerPhoneNumber,
            String customerEmailId,
            String orderNote,
            String customerName,
            String cardNo,
            String cardExpiryMonth,
            String cardExpiryYear,
            String cardHolderName,
            String cardCVV,
            String notifyUrl
    ) {
        Intent unityHelperIntent = new Intent(activity, CFUnityHelperActivity.class);
        unityHelperIntent.putExtra(FUNCTION, CFUnityHelperActivity.WEB_CHECKOUT);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_APP_ID, appId);
        unityHelperIntent.putExtra(TOKEN, token);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_ID, orderId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_AMOUNT, orderAmount);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, orderCurrency);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_PHONE, customerPhoneNumber);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_EMAIL, customerEmailId);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_NOTIFY_URL, notifyUrl);
        unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_CURRENCY, "INR");
        unityHelperIntent.putExtra(CFPaymentService.PARAM_PAYMENT_OPTION, "card");
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CARD_NUMBER, cardNo);// Card number
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CARD_MM, cardExpiryMonth); // Card Expiry Month in MM
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CARD_YYYY, cardExpiryYear); // Card Expiry Year in YYYY
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CARD_HOLDER, cardHolderName); // Card Holder name
        unityHelperIntent.putExtra(CFPaymentService.PARAM_CARD_CVV, cardCVV); // Card CVV
        if (customerName != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_CUSTOMER_NAME, customerName);
        if (orderNote != null)
            unityHelperIntent.putExtra(CFPaymentService.PARAM_ORDER_NOTE, orderNote);
        activity.startActivityForResult(unityHelperIntent, 1011);
    }
}