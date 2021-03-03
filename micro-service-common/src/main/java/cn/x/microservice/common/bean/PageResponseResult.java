package cn.x.microservice.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xqa
 * @since 2021/3/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseResult<E> extends ResponseResult<E> {

    private static final long serialVersionUID = 8837596669210936097L;

    private Integer code = 0;
    private String message = "success";
    private Object data;
    private long total;

    public static PageResponseResult success(Object data, Long total) {
        return new PageResponseResult(0, "success", data, total);
    }

    public static PageResponseResult paramError() {
        return new PageResponseResult(101, "failed: param error", null, 0);
    }

    public static PageResponseResult flowLimit() {
        return new PageResponseResult(102, "failed: flow limit", null, 0);
    }

    public static PageResponseResult sysError() {
        return new PageResponseResult(500, "failed: sys error", null, 0);
    }

    public static PageResponseResult forbidError() {
        return new PageResponseResult(1001, "failed: forbid error", null, 0);
    }

}
