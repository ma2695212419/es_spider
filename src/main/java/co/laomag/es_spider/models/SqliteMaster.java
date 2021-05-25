package co.laomag.es_spider.models;

public class SqliteMaster {
    private String type;

    private String name;

    private String tblName;

    private Integer rootpage;

    private String sql;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
    }

    public Integer getRootpage() {
        return rootpage;
    }

    public void setRootpage(Integer rootpage) {
        this.rootpage = rootpage;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}