package com.es.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.es.commons.ResponseResult;
import com.es.entity.Student;
import com.es.enums.OptionsType;
import com.es.service.StudentService;
import com.es.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/student")
public class StudentController extends HttpServlet {

    SimpleDateFormat dateFormat;

    @Override
    public void init() throws ServletException {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private StudentService service = new StudentServiceImpl();

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OptionsType ot = OptionsType.getInstance(request.getParameter("op"));
        switch (ot){
            case GET: get(request, response);break;
            case LIST: list(request, response);break;
            case SAVE: save(request, response);break;
            case UPDATE: update(request, response);break;
            case DELETE: delete(request, response);break;
            default: response.sendRedirect("fail.html");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDelete = service.delete(id);
        response.setContentType("text/plain;charset=utf-8");
        if(isDelete){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
        response.getWriter().flush();
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Integer id = Integer.valueOf(request.getParameter("id"));
        Student student = new Student();
        try {
            Date birthday = dateFormat.parse(request.getParameter("birthday"));
            student.setBirthday(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setPhone(phone);
        student.setName(name);
        student.setAddress(address);
        student.setId(id);
        response.setContentType("text/plain;charset=utf-8");
        if(service.update(student)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
        response.getWriter().flush();
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Student student = new Student();
        try {
            Date birthday = dateFormat.parse(request.getParameter("birthday"));
            student.setBirthday(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setPhone(phone);
        student.setName(name);
        student.setAddress(address);
        response.setContentType("text/plain;charset=utf-8");
        if(service.save(student)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
        response.getWriter().flush();

    }

    private void list(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setAddress(request.getParameter("address"));
        student.setPhone(request.getParameter("phone"));
        System.out.println(student);

        String startD = request.getParameter("birthdayStart");
        String startE = request.getParameter("birthdayEnd");
        if(startD !=null && startD.trim().length()!=0 && startE !=null && startE.trim().length()!=0){
            try {
                Date start = dateFormat.parse(startD);
                Date end = dateFormat.parse(startE);
                student.setBirthdayEnd(end);
                student.setBirthdayStart(start);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        Integer pageNum = Integer.valueOf(request.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));

        ResponseResult<Student> result = service.list(pageNum,pageSize,student);
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(result));
        response.getWriter().flush();

    }

    private void get(ServletRequest request, ServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = service.get(id);
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().print(JSON.toJSONString(student));
        response.getWriter().flush();
    }
}
