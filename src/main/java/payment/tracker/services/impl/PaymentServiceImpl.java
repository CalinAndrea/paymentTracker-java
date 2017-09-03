package payment.tracker.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import payment.tracker.domain.Payment;
import payment.tracker.repositories.PaymentRepository;
import payment.tracker.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<Payment> listAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getById(Integer id) {
		return paymentRepository.findOne(id);
	}

	@Override
	public Payment saveOrUpdate(Payment domainObject) {
		return paymentRepository.save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		paymentRepository.delete(id);
	}

	@Override
	public List<Payment> findByName(String name) {
		return paymentRepository.findByName(name);
	}

}
