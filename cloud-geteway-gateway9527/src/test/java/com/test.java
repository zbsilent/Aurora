package com;

import com.aurora.gateway.Apps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @author zbsilent
 * @date 2021年06月11日 12:26 上午
 */
@SpringBootTest(classes = Apps.class)
public class test {

    @Test
    void loadContext(){
        ZonedDateTime now = ZonedDateTime.now();
        System.err.println(now);
    }
}
