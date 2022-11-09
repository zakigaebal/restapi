package com.example.restapi.dao;

import com.example.restapi.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FirstDAO {
    List<UserVO> selectMmbrList();

    public List<UserVO> selectAllUser();

    public List<UserVO> selectUser(String user_id);

    public int insertUser(UserVO vo);

    public int updateUser(UserVO vo);

    public int deleteUser(String user_id);
}
