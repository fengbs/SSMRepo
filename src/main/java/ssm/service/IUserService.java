package ssm.service;


import ssm.model.User;

public interface IUserService {

    public User selectUser(long userId);

}
