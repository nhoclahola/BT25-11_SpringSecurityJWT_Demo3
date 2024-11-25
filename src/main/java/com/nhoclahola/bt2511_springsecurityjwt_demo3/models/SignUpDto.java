package com.nhoclahola.bt2511_springsecurityjwt_demo3.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto
{
    private String name;
    private String username;
    private String email;
    private String password;
    private boolean enabled;
}
