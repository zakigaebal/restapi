package com.example.restapi.service;

import com.example.restapi.dao.FirstDAO;
import com.example.restapi.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestApiServiceImpl implements RestApiService {

    @Autowired
    private FirstDAO dao;

    @Override
    public List<UserVO> helloWorld() {
        return dao.selectMmbrList();
    }

    @Override
    public List<UserVO> selectAllUser(){
        return dao.selectAllUser();
    }

    public List<UserVO> selectUser(String user_id) throws Exception{
        return dao.selectUser(user_id);
    }

    public int insertUser(UserVO vo) throws Exception{
        return dao.insertUser(vo);
    }

    public int updateUser(String user_id, UserVO vo) throws Exception{
        return dao.updateUser(vo);
    }

    public int deleteUser(String user_id) throws Exception{
        return dao.deleteUser(user_id);
    }

}
