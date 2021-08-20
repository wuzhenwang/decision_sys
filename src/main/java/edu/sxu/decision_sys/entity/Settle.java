package edu.sxu.decision_sys.entity;

import java.math.BigDecimal;
import java.util.Map;

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
    private Map<String, Object> exts;
    private Map<String, Object> maps;

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Map<String, Object> getExts() {
        return exts;
    }

    public void setExts(Map<String, Object> exts) {
        this.exts = exts;
    }

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
