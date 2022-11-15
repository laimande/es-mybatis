package com.es.mapper;

import com.es.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    /**
     * 用来保存学生信息的方法
     * @param student
     * @return
     */
    int save(Student student);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    int update(Student student);


    /**
     * 删除一条学生信息
     * @param id
     * @return
     */
    int delete(@Param("id")Integer id);

    /**
     * 根据ID查询学生信息
     * @param id
     * @return
     */
    Student get(@Param("id") Integer id);

    /**
     * @return
     */
    List<Student> list();

    List<Student> listByCondition(@Param("name") String name, @Param("phone") String phone);

}
