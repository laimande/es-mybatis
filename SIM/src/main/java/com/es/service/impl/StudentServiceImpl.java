package com.es.service.impl;

import com.es.commons.ResponseResult;
import com.es.entity.Student;
import com.es.mapper.StudentMapper;
import com.es.service.StudentService;
import com.es.util.SqlSessionUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class StudentServiceImpl implements StudentService {

    //
    StudentMapper mapper = SqlSessionUtils.openSession().getMapper(StudentMapper.class);

    @Override
    public ResponseResult<Student> list(Integer pageNum, Integer pageSize, Student student) {

        Page<Student> page = PageHelper.startPage(pageNum,pageSize);
        mapper.list(student);
        ResponseResult<Student> responseResult = new ResponseResult<>();
        responseResult.setCode(100);
        responseResult.setMsg("查询成功");
        responseResult.setPageNum(pageNum);
        responseResult.setPageSize(pageSize);
        responseResult.setCount(page.getPages());
        responseResult.setTotal((int)page.getTotal());
        responseResult.setData(page.getResult());
        return responseResult;
    }

    @Override
    public Student get(Integer id) {
        return mapper.get(id);
    }

    @Override
    public boolean delete(Integer id) {
        int i = mapper.delete(id);
        return i>0;
    }

    @Override
    public boolean update(Student student) {
        return mapper.update(student)>0;
    }

    @Override
    public boolean save(Student student) {
        return mapper.save(student)>0;
    }
}
