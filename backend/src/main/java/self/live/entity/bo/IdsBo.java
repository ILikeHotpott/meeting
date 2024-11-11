package self.live.entity.bo;

import java.util.List;

public class IdsBo {
    private List<String> ids;

    public IdsBo(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "IdsBo{" +
                "ids=" + ids +
                '}';
    }
}
