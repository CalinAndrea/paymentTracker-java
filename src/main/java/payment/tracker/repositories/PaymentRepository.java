package payment.tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import payment.tracker.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	public List<Payment> findByName(String name);

}
