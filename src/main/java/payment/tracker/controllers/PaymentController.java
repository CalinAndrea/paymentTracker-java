package payment.tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import payment.tracker.domain.Payment;
import payment.tracker.services.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/payments", method = RequestMethod.GET)
	public List<Payment> getPayments() {
		return paymentService.listAll();
	}
}
