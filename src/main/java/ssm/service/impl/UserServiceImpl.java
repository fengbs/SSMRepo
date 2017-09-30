package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.IUserDao;
import ssm.model.User;
import ssm.service.IUserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
