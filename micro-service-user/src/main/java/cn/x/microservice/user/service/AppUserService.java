package cn.x.microservice.user.service;

import cn.x.microservice.user.entity.AppUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
public interface AppUserService extends IService<AppUser> {

    AppUser getUserInfo(Integer id);
}
