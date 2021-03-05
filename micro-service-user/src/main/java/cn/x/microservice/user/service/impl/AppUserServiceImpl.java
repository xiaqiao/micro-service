package cn.x.microservice.user.service.impl;

import cn.x.microservice.user.entity.AppUser;
import cn.x.microservice.user.mapper.AppUserMapper;
import cn.x.microservice.user.service.AppUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
@Service
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements AppUserService {

}
