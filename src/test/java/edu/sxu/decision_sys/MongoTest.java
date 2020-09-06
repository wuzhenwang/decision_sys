package edu.sxu.decision_sys;

import edu.sxu.decision_sys.entity.Settle;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author wzw
 * @version 1.0
 * @description mongo测试
 * @date 2020/9/5 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DecisionSysApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MongoTest {
    @Autowired
    private MongoTemplate mongoTemplate;

//    @Test
    public void saveTest() {
        Settle settle = new Settle();
        settle.set_id("141181234");
        settle.setName("wuzhenwang");
        settle.setPrice(new BigDecimal("12.6"));
        mongoTemplate.save(settle);
    }

//    @Test
    public void findTest() {
        Settle settle = mongoTemplate.findById("141181234", Settle.class);
        System.out.println(settle);
    }
}
