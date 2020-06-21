package com.thoughtworks.capacity.gtb.mvc.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer id;

    @NotBlank
    @Size(min = 5, max = 12, message = "Invalid Username")
    private String userName;

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z_]{5,12}$", message = "Invalid Password")
    private String userPassword;

    @NotBlank
//    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message = "Invalid Email Address")
    private String userEmail;

}
