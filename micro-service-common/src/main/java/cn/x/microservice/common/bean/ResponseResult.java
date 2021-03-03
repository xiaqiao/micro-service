package cn.x.microservice.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xqa
 * @since 2021/2/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 8463545112277030013L;
    private Integer code = 0;
    private String message = "success";
    private T data;

    public static ResponseResult success(Object data) {
        return new ResponseResult<>(0, "success", data);
    }

    public static ResponseResult success() {
        return new ResponseResult<>(0, "success", null);
    }

    public static ResponseResult paramError() {
        return new ResponseResult<>(101, "failed: param error", null);
    }

    public static ResponseResult flowLimit() {
        return new ResponseResult<>(102, "failed: flow limit", null);
    }

    public static ResponseResult sysError() {
        return new ResponseResult<>(500, "failed: sys error", null);
    }

    public static ResponseResult forbidError() {
        return new ResponseResult<>(1001, "failed: forbid error", null);
    }

}
