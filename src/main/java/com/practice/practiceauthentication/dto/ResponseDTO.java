package com.practice.practiceauthentication.dto;

import com.practice.practiceauthentication.enums.StatusAndMessageEnum;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private int status;
    private String message;
    private Object data;

    public static ResponseDTO success(){
            return ResponseDTO
                    .builder()
                    .status(StatusAndMessageEnum.SUCCESS.getStatus())
                    .message(StatusAndMessageEnum.SUCCESS.getMessage())
                    .build();
    }

    public static ResponseDTO internalServerError(){
            return ResponseDTO
                    .builder()
                    .status(StatusAndMessageEnum.INTERNAL_SERVER_ERROR.getStatus())
                    .message(StatusAndMessageEnum.INTERNAL_SERVER_ERROR.getMessage())
                    .build();
    }

    public static ResponseDTO timeout(){
            return ResponseDTO
                    .builder()
                    .status(StatusAndMessageEnum.TIME_OUT.getStatus())
                    .message(StatusAndMessageEnum.TIME_OUT.getMessage())
                    .build();
    }

    public static ResponseDTO badRequest(){
            return ResponseDTO
                    .builder()
                    .status(StatusAndMessageEnum.BAD_REQUEST.getStatus())
                    .message(StatusAndMessageEnum.BAD_REQUEST.getMessage())
                    .build();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

