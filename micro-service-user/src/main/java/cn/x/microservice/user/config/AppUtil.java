package cn.x.microservice.user.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author xqa
 * @since 2021/3/26
 */
@Component
public class AppUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppUtil.context = applicationContext;
    }

    public static Object getBean(String name) throws BeansException {
        return context.getBean(name);
    }

    public static Object getBean(Class<Object> requiredType) throws BeansException {
        return context.getBean(requiredType);
    }


    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }


    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return context.isSingleton(name);
    }


    public static Class getType(String name) throws NoSuchBeanDefinitionException {
        return context.getType(name);
    }


    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return context.getAliases(name);
    }
}
