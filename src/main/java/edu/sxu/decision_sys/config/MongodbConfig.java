package edu.sxu.decision_sys.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.lang.NonNull;
import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongodbConfig extends AbstractMongoClientConfiguration {
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private Integer port;
    @Value("${spring.data.mongodb.username}")
    private String userName;
    @Value("${spring.data.mongodb.password}")
    private char[] password;
    @Value("${spring.data.mongodb.authentication-database}")
    private String authentication;

    @Override
    public MongoClient mongoClient() {
        // 连接认证，如果设置了用户名和密码的话,  3.0版本Sha1，4.0版本Sha256
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(userName, authentication, password);
//        MongoCredential mongoCredential = MongoCredential.createScramSha256Credential(userName, authentication, password);

        // MongoDB地址列表,如果有多个ip地址，那么配置文件里面可以用逗号分隔ip地址，这里再把每一个ip地址和端口号添加进list里面
        List<ServerAddress> serverAddresses = new ArrayList<>();
        ServerAddress serverAddress = new ServerAddress(host, port);
        serverAddresses.add(serverAddress);

        // 第二种方案，直接uri连接指定
        ConnectionString connectionString = new ConnectionString("mongodb://root:root@127.0.0.1:27017/?authSource=admin");

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.hosts(serverAddresses))
                .credential(mongoCredential)
//                .applyToSslSettings(builder -> builder.enabled(true))
//                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient;
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(this.mongoDbFactory());
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, this.mongoMappingContext());
        List<Object> list = new ArrayList<>();
        list.add(new BigDecimalToDecimal128Converter());//自定义的类型转换器  写
        list.add(new Decimal128ToBigDecimalConverter());//自定义的类型转换器  读
        converter.setCustomConversions(new MongoCustomConversions(list));
        return converter;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(this.mongoDbFactory(), this.mappingMongoConverter());
    }

    @Bean(name = "mongoDbFactory")
    public MongoDbFactory mongoDbFactory() {
        // 创建MongoDbFactory
        MongoDbFactory mongoDbFactory = new SimpleMongoClientDbFactory(mongoClient(), database);
        return mongoDbFactory;
    }

    @WritingConverter
    private static class BigDecimalToDecimal128Converter implements Converter<BigDecimal, Decimal128> {
        @Override
        public Decimal128 convert(@NonNull BigDecimal source) {
            return new Decimal128(source);
        }
    }

    @ReadingConverter
    private static class Decimal128ToBigDecimalConverter implements Converter<Decimal128, BigDecimal> {
        @Override
        public BigDecimal convert(@NonNull Decimal128 source) {
            return source.bigDecimalValue();
        }

    }
}