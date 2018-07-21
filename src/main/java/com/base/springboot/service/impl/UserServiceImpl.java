package com.base.springboot.service.impl;

import com.base.springboot.mapper.UserDao;
import com.base.springboot.model.UserVO;
import com.base.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 对方法进行缓存，每个缓存需要配置缓存名称cacheNames。支持SpEL表达式
     * key：缓存使用的key，默认是方法参数，会根据key到这个缓存管理器中找缓存是否存在
     * condition:条件
     * 默认使用CurrentMapCacheManager
     * @return
     */
    @Cacheable(cacheNames = "userCache")
    @Override
    public List<UserVO> getList() {
        return userDao.getList();
    }
}
