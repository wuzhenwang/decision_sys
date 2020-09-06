package edu.osg.framework.mongodb;


import org.bson.types.Decimal128;
import org.springframework.core.convert.converter.Converter;
import java.math.BigDecimal;



/**
 * 自定义类型转换器BigDecimalToDecimal128
 */
public class BigDecimalToDecimal128Converter implements Converter<BigDecimal, Decimal128> {

    public Decimal128 convert(BigDecimal bigDecimal) {
        return new Decimal128(bigDecimal);
    }

}