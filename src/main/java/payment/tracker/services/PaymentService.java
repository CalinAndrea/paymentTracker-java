package payment.tracker.services;

import java.util.List;

import payment.tracker.domain.Payment;

public interface PaymentService extends CRUDService<Payment> {
	List<Payment> findByName(String name);

}
