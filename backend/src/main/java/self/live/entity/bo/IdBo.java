package self.live.entity.bo;

import java.util.List;

public class IdBo {
    /**
     * id
     */
    private String id;

    public IdBo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdBo{" +
                "id='" + id + '\'' +
                '}';
    }
}
