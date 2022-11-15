package com.es.service;

import com.es.commons.ResponseResult;
import com.es.entity.Student;

public interface StudentService {
    /**
     * @return
     */
    ResponseResult<Student> list(Integer PageNum, Integer PageSize, Student student);

    /**
     * @param id
     * @return
     */
    Student get(Integer id);

    /**
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * @param student
     * @return
     */
    boolean update(Student student);

    /**
     * @param student
     * @return
     */
    boolean save(Student student);
}
