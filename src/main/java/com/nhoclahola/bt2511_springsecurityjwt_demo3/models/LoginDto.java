package com.nhoclahola.bt2511_springsecurityjwt_demo3.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto
{
    private String username;
    private String password;
}
