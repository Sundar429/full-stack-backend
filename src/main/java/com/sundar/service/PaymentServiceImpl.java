package com.sundar.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import com.sundar.model.Order;
import com.sundar.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService{

//    @Value("${stripe.api.key}")
//    private String stripeSecretKey;
    @Override
    public PaymentResponse createPaymentLink(Order order) throws StripeException {


//        Stripe.apiKey=stripeSecretKey;


        String successUrl = "http://localhost:3000/payment/success/" + order.getId();
        String cancelUrl = "http://localhost:3000/payment/fail";

        // Create a dummy payment link (for testing purposes)
//        String paymentLink = "http://localhost:3000/payment/checkout/" + order.getId();

        // Create a PaymentResponse object with the success URL
        PaymentResponse res = new PaymentResponse();
        res.setSuccess_url(successUrl);
//        res.setCancel_url(cancelUrl);
//        res.setPayment_link(paymentLink);

        // Return the response
        return res;
    }


}
