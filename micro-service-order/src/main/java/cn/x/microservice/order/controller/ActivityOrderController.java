package cn.x.microservice.order.controller;


import cn.x.microservice.common.bean.PageResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author x
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/order/activity-order")
@Slf4j
public class ActivityOrderController {
    private List<Object> list = new ArrayList<>();


    @RequestMapping("/test")
    public void test() {
//        List<Object> list = new ArrayList<>();
        Lock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                PageResponseResult result = new PageResponseResult();
                result.setTotal(new Random().nextLong());
                lock.lock();
                list.add(result);
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                PageResponseResult result = new PageResponseResult();
                result.setTotal(new Random().nextLong());
                lock.lock();
                list.add(result);
                lock.unlock();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                PageResponseResult result = new PageResponseResult();
                result.setTotal(new Random().nextLong());
                lock.lock();
                list.add(result);
                lock.unlock();
            }
        });
        thread.start();
        thread2.start();
        thread3.start();

        while (list.size() < 300000) {
            try {
                Thread.sleep(10);
                log.info("创建的对象数量：{}", list.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("创建的对象数量：{}", list.size());
    }

    public static void main(String[] args) {
        Object o = new Object();
    }

    public void main2(String[] args) {
        Object o = new Object();
    }

}
