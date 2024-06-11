package com.amar.SpringBoot.entity;

import lombok.Data;

@Data
public class ExceptionResposeEntity {

    String httpResponse;

    String message;

    Long timeStamp;

}
