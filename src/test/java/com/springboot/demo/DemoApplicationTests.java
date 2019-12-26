package com.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testLoger(){

//		final Logge logger = Logger.getLogger("TestErrOut");
        final Logger LOG = LoggerFactory.getLogger(DemoApplicationTests.class);

        LOG.debug(" This is debug!!!");
        LOG.info(" This is info!!!");
        LOG.warn(" This is warn!!!");
        LOG.error(" This is error!!!");
//		LOG.fatal(" This is fatal!!!");
    }

}
