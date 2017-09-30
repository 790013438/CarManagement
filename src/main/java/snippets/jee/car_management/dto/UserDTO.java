package snippets.jee.car_management.dto;

import java.math.BigDecimal;

public class UserDTO {

    private int id;

    private String email;

    private BigDecimal username;

    public UserDTO() {
    }

    public UserDTO(int id, String email, BigDecimal username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getUsername() {
        return username;
    }

    public void setUsername(BigDecimal username) {
        this.username = username;
    }

}
