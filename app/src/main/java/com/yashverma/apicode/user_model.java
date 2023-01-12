package com.yashverma.apicode;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Map;

public class user_model {
    private String status;
    private String message;
    JSONArray  data ;

    public user_model(String status, String message, JSONArray data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }
}
