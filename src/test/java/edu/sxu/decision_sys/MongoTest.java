package edu.sxu.decision_sys;

import edu.osg.framework.mongodb.EmongoTemplate;
import edu.sxu.decision_sys.entity.Settle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

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
    private EmongoTemplate mongoTemplate;

    @Test
    public void saveTest() {

//        Settle settle = new Settle();
//        settle.set_id("141181234");
//        settle.setName("wuzhenwang");
//        settle.setPrice(new BigDecimal("12.6"));
//        mongoTemplate.save(settle);
        System.out.println(SpringBootVersion.getVersion());
//        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is("141181234")), Update.update("title","wzw"), Settle.class);
//        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is("141181234")), Update.update("exts.title","wzw"), Settle.class);

        Update update = new Update();
//        update.set("title", "wuzhenwang");
        update.set("maps.wzw", "wuzhenw");
        mongoTemplate.updateMulti(Query.query(Criteria.where("_id").is("141181234")), update, Settle.class);

//        List<Settle> nodeList = mongoTemplate.findWithFields(true, new String[]{"exts"}, Query.query(Criteria.where("_id").is("141181234")), Settle.class);
//        System.out.println(nodeList);
    }

//    @Test
    public void findTest() {
        Settle settle = mongoTemplate.findById("141181234", Settle.class);
        System.out.println(settle);
    }
}
