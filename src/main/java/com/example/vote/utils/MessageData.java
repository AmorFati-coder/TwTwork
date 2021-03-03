package com.example.vote.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageData implements Serializable {
    private String message;
    private String code;
    private Object data;

    public MessageData(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public static MessageData createSuccessMsg(String msg, Object data) {
        return new MessageData(msg, Constant. CODE_SUCCESS, data);
    }

    public static MessageData createSuccessMsg(Object data) {
        return new MessageData(Constant.MSG_SUCCESS, Constant.CODE_SUCCESS, data);
    }

    public static MessageData createErrorMsg() {
        return new MessageData();
    }

    public static MessageData createDefErrorMsg() {
        return new MessageData(Constant.MSG_ERROR, Constant.CODE_ERROR);
    }
}
