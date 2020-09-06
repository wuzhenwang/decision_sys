package edu.sxu.decision_sys.entity;

import java.math.BigDecimal;

/**
 * @author wzw
 * @version 1.0
 * @description 结算
 * @date 2020/9/5 15:52
 */
public class Settle {
    private String _id;
    private String name;
    private BigDecimal price;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
