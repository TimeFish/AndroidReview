package com.xy.test1;

/**
 * Created by XY on 2016/8/9.
 */
public class AppBean {
    private String name;
    private int version;
    private String type;

    public AppBean(String name, int version, String type) {
        this.name = name;
        this.version = version;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AppBean{" +
                "name='" + name + '\'' +
                ", version=" + version +
                ", type='" + type + '\'' +
                '}';
    }
}
