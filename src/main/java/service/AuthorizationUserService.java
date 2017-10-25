package service;

import pojo.User;

public interface AuthorizationUserService {
     User authorization(String login, String password) throws Exception;


}
