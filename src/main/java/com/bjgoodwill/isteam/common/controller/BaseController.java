package com.bjgoodwill.isteam.common.controller;

import com.bjgoodwill.isteam.common.domain.QueryRequest;
import com.bjgoodwill.isteam.system.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @ClassName BaseController
 * @Description 控制器基类
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
public class BaseController {

    protected static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    protected User getCurrentUser() {
        return (User) getSubject().getPrincipal();
    }

    protected Session getSession() {
        return getSubject().getSession();
    }

    protected Session getSession(Boolean flag) {
        return getSubject().getSession(flag);
    }

    protected void login(AuthenticationToken token) {
        getSubject().login(token);
    }

    private Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    protected Map<String, Object> selectByPageNumSize(QueryRequest request, Supplier<?> s) {
        // 执行PageHelper.startPage后，下一个Mybatis查询语句执行时会被处理为分页操作，即返回的不是List，而是Page
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        // s.get()方法执行时即进入DAO层执行sql，如果此时打断点，第一次执行s.get()时返回Page,第二次返回List
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        // 以下操作是为了保险起见，避免下一个查询操作受到上一次查询的影响。其实在s.get()执行完毕后，执行了同样的操作
        // 操作方法见PageInterceptor.intercept,在try catch的finally中进行了清除当前线程变量
        PageHelper.clearPage();
        return getDataTable(pageInfo);
    }
}
