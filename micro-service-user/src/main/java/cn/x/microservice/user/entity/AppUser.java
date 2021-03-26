package cn.x.microservice.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
@Data
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String nickName;

    private String avatar;

    private String phone;

    private LocalDateTime cTime;

    private LocalDateTime mTime;


}
