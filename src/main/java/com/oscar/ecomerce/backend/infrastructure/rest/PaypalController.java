package com.oscar.ecomerce.backend.infrastructure.rest;

import com.oscar.ecomerce.backend.domain.model.DataPayment;
import com.oscar.ecomerce.backend.domain.model.UrlPaypalResponse;
import com.oscar.ecomerce.backend.infrastructure.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/payments")
public class PaypalController {
    private final PaypalService paypalService;
    private final String URL_PAYPAL_SUCCESS = "http://localhost:8080/api/v1/payments/success";
    private final String URL_PAYPAL_CANCEL = "http://localhost:8080/api/v1/payments/cancel";

    @PostMapping
    public UrlPaypalResponse createPayment(@RequestBody DataPayment dataPayment) throws PayPalRESTException {
        Payment payment = paypalService.createPayment(
                Double.valueOf(dataPayment.getAmount()),
                dataPayment.getCurrency(),
                dataPayment.getMethod(),
                "SALE",
                dataPayment.getDescription(),
                URL_PAYPAL_CANCEL,
                URL_PAYPAL_SUCCESS
        );
        for (Links links : payment.getLinks()) {
            if (links.getRel().equals("approval_url")) {
                return new UrlPaypalResponse(links.getHref());
            }
        }
        return new UrlPaypalResponse("http://localhost:4200");
    }

    @GetMapping("/success")
    public RedirectView successPay(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("PayerID") String payerId
    ) throws PayPalRESTException {
        Payment payment = paypalService.executePayment(paymentId, payerId);
        if (payment.getState().equals("approved")) {
            return new RedirectView("http://localhost:4200/payment/success");
        }
//        return new RedirectView("http://localhost:4200/error");
        return new RedirectView("http://localhost:4200");
    }

    @GetMapping("/cancel")
    public RedirectView cancelPay() {
//        return new RedirectView("http://localhost:4200/cancel");
        return new RedirectView("http://localhost:4200");
    }
}
