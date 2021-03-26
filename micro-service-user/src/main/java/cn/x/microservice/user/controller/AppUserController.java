package cn.x.microservice.user.controller;


import cn.x.microservice.common.bean.ResponseResult;
import cn.x.microservice.user.entity.AppUser;
import cn.x.microservice.user.service.AppUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/user/app-user")
@AllArgsConstructor
@NoArgsConstructor
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @RequestMapping("{id}")
    public ResponseResult<AppUser> getUserInfo(@PathVariable("id") Integer id) {
        return new ResponseResult<>(appUserService.getUserInfo(id));
    }

}
