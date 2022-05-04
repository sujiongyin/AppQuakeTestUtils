package com.ooooo.quake.controller;

import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.request.PaymentTradingRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import com.stripe.param.PaymentMethodCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    @PostMapping(path = "/confirmPaymentIntent")
    public JsonData confirmPaymentIntent(@RequestBody PaymentTradingRequest paymentTrading) throws StripeException {
        Stripe.apiKey = "sk_test_51I4SpwGqzU9EAVrtZmpM8jOZjIxYr3psX6hSsmNxJ6x9uJr1rphrLD5P0y9dIM1pI6tBakl1GebuLMERHmX0map5003f4be7Mk";
        PaymentIntent paymentIntent =
                PaymentIntent.retrieve(
                        // 交易id
                        paymentTrading.getTrading()
//                        "pi_1EUn5sJnRDDqOaR75NylFAz3"
                );

        Map<String, Object> params = new HashMap<>();

        PaymentMethodCreateParams paymentMethodCreateParams = PaymentMethodCreateParams.builder().setCard(PaymentMethodCreateParams.CardDetails.builder().setCvc("123").setNumber("411111111111").setExpYear(2021L).setExpMonth(12L).build()).build();

        try {
            PaymentMethod paymentMethod = PaymentMethod.create(paymentMethodCreateParams);
            params.put("payment_method", paymentMethod.getId());
            PaymentIntent updatedPaymentIntent =
                    paymentIntent.confirm(params);
            return JsonData.buildSuccess(updatedPaymentIntent);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return JsonData.buildSuccess();
    }


}
