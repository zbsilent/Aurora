package com.aurora.spingcloud.payment;

import com.aurora.springcloud.PaymentApplication;
 import com.aurora.springcloud.mapper.PaymentDao;
import com.aurora.springcloud.payment.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zbsilent
 * @date 2021年06月09日 1:39 上午
 */
@SpringBootTest(classes = PaymentApplication.class)
public class PaymentTestApplication {

  @Autowired
  private PaymentDao paymentDao;

  @Test
  void Load() {
    Payment payment = new Payment();
    payment.setSerial("1023");
    int i = paymentDao.create(payment);
    System.err.println(i);
  }
}
