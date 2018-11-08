package com.bjgoodwill.isteam.common.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ShiroSessionListener
 * @Description ShiroSession监听，在session生命周期前后可增加业务逻辑
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
public class ShiroSessionListener implements SessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();

    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
    }
}
