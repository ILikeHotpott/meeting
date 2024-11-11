package self.live.entity;

public class SelfConfigPropertiesBean {
    private String ciphertext;
    public SelfConfigPropertiesBean() {
    }

    public SelfConfigPropertiesBean(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    @Override
    public String toString() {
        return "SelfConfigPropertiesBean{" +
                "ciphertext='" + ciphertext + '\'' +
                '}';
    }
}
