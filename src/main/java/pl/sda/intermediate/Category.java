package pl.sda.intermediate;

import lombok.Builder;

@Builder
public class Category {

    private Integer id;
    private String name;
    private  Integer parentId;
    private Integer deepth;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Integer getDeepth() {
        return deepth;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", deepth=" + deepth +
                '}';
    }
}
