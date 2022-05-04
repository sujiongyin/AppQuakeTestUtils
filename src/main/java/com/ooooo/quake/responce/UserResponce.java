package com.ooooo.quake.responce;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponce implements Serializable {

    private static final long serialVersionUID = -9050306418687722406L;
    /**
     * 用户Id
     */
    @JsonProperty("userId")
    private String id;
}
