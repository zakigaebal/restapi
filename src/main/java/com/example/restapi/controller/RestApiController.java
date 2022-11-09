package com.example.restapi.controller;

import com.example.restapi.service.RestApiService;
import com.example.restapi.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/first")
public class RestApiController {
    private final RestApiService service;

    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "page not found2")
    })
    @ApiOperation(value = "회원 목록 조회", notes = "회원 목록 조회 API입니다.")
    @GetMapping("/0001")
    public ResponseEntity<List<UserVO>> getFirst(){
        List<UserVO> result = service.helloWorld();
        return new ResponseEntity<List<UserVO>>(result, HttpStatus.OK);
    }

    @Operation(summary = "유저정보 조회(전체)")
    @GetMapping("")
    public List<UserVO> selectAllUser() throws Exception{
        return service.selectAllUser();
    }

    @Operation(summary = "유저정보 조회")
    @GetMapping("/{user_id}")
    public List<UserVO> selectUser(@PathVariable("user_id") String user_id) throws Exception{
        return service.selectUser(user_id);
    }

    @Operation(summary = "유저정보 등록")
    @PostMapping("")
    public List<UserVO> insertUser(@RequestBody UserVO vo) throws Exception{
        service.insertUser(vo);
        return service.selectUser((String) vo.getMmbrId());
    }

    @Operation(summary = "유저정보 수정")
    @PutMapping("/{user_id}")
    public List<UserVO> updateUser(@PathVariable String user_id, @RequestBody UserVO vo) throws Exception{
        service.updateUser(user_id, vo);
        return service.selectUser(user_id);
    }

    @Operation(summary = "유저정보 삭제")
    @DeleteMapping("/{user_id}")
    public List<UserVO> deleteUser(@PathVariable String user_id) throws Exception{
        service.deleteUser(user_id);
        return service.selectUser(user_id);
    }


}
