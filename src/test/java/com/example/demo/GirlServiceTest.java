package com.example.demo;

import com.example.demo.domain.Girl;
import com.example.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 80657 on 2017/10/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

        @Test
        public void findOneTest(){
          Girl girl= girlService.findOne(20);
            Assert.assertEquals(new Integer(23),girl.getAge());
        }
}
