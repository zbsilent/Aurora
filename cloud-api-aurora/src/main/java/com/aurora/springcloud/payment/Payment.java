package com.aurora.springcloud.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zbsilent
 * @date 2021年06月09日 2:14 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
