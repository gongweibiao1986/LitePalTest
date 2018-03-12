package database.itheima.com.litepaltest;

/**
 * Created by Ken on 2018/3/11.
 */

public class Category {
    private  int id;
    private String cagegoryName;
    private int categoryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCagegoryName() {
        return cagegoryName;
    }

    public void setCagegoryName(String cagegoryName) {
        this.cagegoryName = cagegoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
}
