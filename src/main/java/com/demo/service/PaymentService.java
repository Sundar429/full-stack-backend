package com.sundar.service;

import com.stripe.exception.StripeException;
import com.sundar.model.Order;
import com.sundar.response.PaymentResponse;




public interface PaymentService {

    public PaymentResponse createPaymentLink(Order order) throws StripeException;
}
