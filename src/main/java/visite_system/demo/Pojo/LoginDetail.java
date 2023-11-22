package visite_system.demo.Pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDetail {
    @NotBlank
    private String phone;
    @NotBlank
    private String password;
}
