package visite_system.demo.Pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDetail {
    @NotBlank(message = "手机号不能为空",groups = LoginValid.class)
    private String phone;
    @NotBlank(message = "密码不能为空",groups = LoginValid.class)
    private String password;
}
