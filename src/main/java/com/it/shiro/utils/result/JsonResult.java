package com.it.shiro.utils.result;

import java.io.Serializable;

/**
 * <P>
 *     自定义返回结果
 * </P>
 * @Author 王文龙
 * @Date 2019-11-27 17:10
 */
public class JsonResult<T> implements Serializable {

    private int code;//状态码
    private String msg;//状态信息
    private T data;//相应具体的数据类型
    private int size;//条数

    public JsonResult() {
    }

    public JsonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(int code, String msg, T data, int size) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.size = size;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", size=" + size +
                '}';
    }
}
