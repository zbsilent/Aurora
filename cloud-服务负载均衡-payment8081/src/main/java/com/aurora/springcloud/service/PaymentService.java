package com.aurora.springcloud.service;

import com.aurora.springcloud.mapper.PaymentDao;
import com.aurora.springcloud.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zbsilent
 * @date 2021年06月09日 2:54 上午
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;



    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public int save(Payment payment){
       return paymentDao.create(payment);
    }
    @Transactional(readOnly = true)
    public Payment queryById(long id){
        return paymentDao.retrieve(id);
    }

    @Transactional
    public void deleteByid(long id){
        paymentDao.delete(id);
    }

    @Transactional(propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
    public void update(Payment payment){
        paymentDao.update(payment);
    }
}
