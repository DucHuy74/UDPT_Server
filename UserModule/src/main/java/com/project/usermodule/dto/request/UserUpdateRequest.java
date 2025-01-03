package com.project.usermodule.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class UserUpdateRequest {
    @NotBlank(message = "Name is mandatory")
    private String userName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Size(min = 8, message = "Password should be at least 8 characters long")
    private String password;

    private String phone;

    public @NotBlank(message = "Name is mandatory") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "Name is mandatory") String userName) {
        this.userName = userName;
    }

    public @Email(message = "Email should be valid") @NotBlank(message = "Email is mandatory") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid") @NotBlank(message = "Email is mandatory") String email) {
        this.email = email;
    }

    public @Size(min = 6, message = "Password should be at least 6 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 6, message = "Password should be at least 6 characters long") String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
