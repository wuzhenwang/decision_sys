package edu.sxu.decision_sys.entity;

import java.util.Map;

/**
 * @author wzw
 * @version 1.0
 * @description
 * @date 2021/3/27 22:45
 */
public class TenantLog {
    private String _id;
    private Map exts;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Map getExts() {
        return exts;
    }

    public void setExts(Map exts) {
        this.exts = exts;
    }
}
