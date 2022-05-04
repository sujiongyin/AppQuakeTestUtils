package com.ooooo.quake.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenRequest {
    String email;
    String token;
    String userId;
}
