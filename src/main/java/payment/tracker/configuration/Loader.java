package payment.tracker.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import payment.tracker.domain.Payment;
import payment.tracker.repositories.PaymentRepository;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		Payment payment = new Payment("gaz", 100);
		paymentRepository.save(payment);

		Payment payment2 = new Payment("curent", 200);
		paymentRepository.save(payment2);
	}

}
