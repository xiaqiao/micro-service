package cn.x.microservice.user.mapper;

import cn.x.microservice.user.config.MybatisRedisCache;
import cn.x.microservice.user.entity.AppUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
@CacheNamespace(implementation = MybatisRedisCache.class, flushInterval = 10000)
public interface AppUserMapper extends BaseMapper<AppUser> {

}
