package br.com.broscoder.hrpayroll.service;

import br.com.broscoder.hrpayroll.client.WorkerFeignClient;
import br.com.broscoder.hrpayroll.model.Payment;
import br.com.broscoder.hrpayroll.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient client;

    public Payment getPayment(long workerId, int days) {
        Worker worker = client.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
