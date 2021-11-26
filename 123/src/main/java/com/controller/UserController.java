package com.controller;

import com.mapper.UserMapper;
import com.pojo.Appointment;
import com.pojo.Result;
import com.pojo.Teacher;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //根据条件查询学生
    @RequestMapping("/queryStudentBySearchParam")
    public Result queryStudentBySearchParam(String searchParam){
        List<User> student = userMapper.queryStudentBySearchParam(searchParam);
        return new Result<User>(student);
    }

    //根据条件查询老师
    @RequestMapping("/queryTeacherBySearchParam")
    public Result queryTeacherBySearchParam(String searchParam){
        List<Teacher> teachers = userMapper.queryTeacherBySearchParam(searchParam);
        return new Result<Teacher>(teachers);
    }

    //查询所有学生
    @GetMapping("/queryStudentList")
    public Result queryStudentList(){
        List<User> studentList = userMapper.queryStudentList();
        return new Result<User>(studentList);
    }

    //查询所有辅导员
    @GetMapping("/queryTeacherList")
    public Result queryTeacherList(){
        List<Teacher> teacherList = userMapper.queryTeacherList();
        return new Result<Teacher>(teacherList);
    }

    //根据学号删除学生
    @RequestMapping("/deleteStudentBySno")
    public void deleteStudentBySno(String sno){
        userMapper.deleteStudentBySno(sno);
    }

    //添加学生
    @RequestMapping("/addStudent")
    public void addStudent(HttpServletRequest httpServletRequest){
        String sno = httpServletRequest.getParameter("sno");
        String sname = httpServletRequest.getParameter("sname");
        String sgrade = httpServletRequest.getParameter("sgrade");
        String sphone = httpServletRequest.getParameter("sphone");
        String sschool = httpServletRequest.getParameter("sschool");
        String sdept = httpServletRequest.getParameter("sdept");
        String sinfo = httpServletRequest.getParameter("sinfo");
        String steacher = httpServletRequest.getParameter("steacher");

        User student = new User(sno,sname,sgrade,sphone,sschool,sdept,sinfo,steacher);
        userMapper.addStudent(student);
    }

    //更新学生信息
    @RequestMapping("/updateStudent")
    public void updateStudent(HttpServletRequest httpServletRequest){
        String sno = httpServletRequest.getParameter("sno");
        String sname = httpServletRequest.getParameter("sname");
        String sgrade = httpServletRequest.getParameter("sgrade");
        String sphone = httpServletRequest.getParameter("sphone");
        String sschool = httpServletRequest.getParameter("sschool");
        String sdept = httpServletRequest.getParameter("sdept");
        String sinfo = httpServletRequest.getParameter("sinfo");
        String steacher = httpServletRequest.getParameter("steacher");

        User student = new User(sno,sname,sgrade,sphone,sschool,sdept,sinfo,steacher);
        userMapper.updateStudent(student);
    }

    //根据工号删除老师
    @RequestMapping("/deleteTeacherByTno")
    public void deleteTeacherByTno( String tno){
        userMapper.deleteTeacherByTno(tno);
    }

    //添加老师
    @RequestMapping("/addTeacher")
    public void addTeacher(HttpServletRequest httpServletRequest){
        String tno = httpServletRequest.getParameter("tno");
        String tname = httpServletRequest.getParameter("tname");
        String tgrade = httpServletRequest.getParameter("tgrade");
        String tphone = httpServletRequest.getParameter("tphone");
        String tschool = httpServletRequest.getParameter("tschool");
        String tdept = httpServletRequest.getParameter("tdept");
        String tinfo = httpServletRequest.getParameter("tinfo");

        Teacher teacher = new Teacher(tno,tname,tphone,tgrade,tschool,tdept,tinfo);
        userMapper.addTeacher(teacher);
    }

    //更新老师信息
    @RequestMapping("/updateTeacher")
    public void updateTeacher(HttpServletRequest httpServletRequest){
        String tno = httpServletRequest.getParameter("tno");
        String tname = httpServletRequest.getParameter("tname");
        String tgrade = httpServletRequest.getParameter("tgrade");
        String tphone = httpServletRequest.getParameter("tphone");
        String tschool = httpServletRequest.getParameter("tschool");
        String tdept = httpServletRequest.getParameter("tdept");
        String tinfo = httpServletRequest.getParameter("tinfo");

        Teacher teacher = new Teacher(tno,tname,tphone,tgrade,tschool,tdept,tinfo);
        userMapper.updateTeacher(teacher);
    }

    //增加预约
    @RequestMapping("/addAppointment")
    public void addAppointment(HttpServletRequest httpServletRequest){
        int statu = 0;
        String tno = httpServletRequest.getParameter("tno");
        String sno = httpServletRequest.getParameter("sno");
        String info = httpServletRequest.getParameter("info");
        int dangerlevel = Integer.parseInt(httpServletRequest.getParameter("dangerlevel"));

        Appointment appointment = new Appointment(sno,tno,info,dangerlevel,statu);
        userMapper.addAppointment(appointment);
    }

    //取消预约
    @RequestMapping("/cancelAppointment")
    public void cancelAppointment(HttpServletRequest httpServletRequest){
        String tno = httpServletRequest.getParameter("tno");
        String sno = httpServletRequest.getParameter("sno");
        String info = httpServletRequest.getParameter("info");
        int dangerlevel = Integer.parseInt(httpServletRequest.getParameter("dangerlevel"));

        Appointment appointment = new Appointment(sno,tno,info,dangerlevel);
        userMapper.cancelAppointment(appointment);
    }

    //修改预约
    @RequestMapping("/changeAppointment")
    public void changeAppointment(HttpServletRequest httpServletRequest){
        String tno = httpServletRequest.getParameter("tno");
        String sno = httpServletRequest.getParameter("sno");
        String info = httpServletRequest.getParameter("info");
        int dangerlevel = Integer.parseInt(httpServletRequest.getParameter("dangerlevel"));

        Appointment appointment = new Appointment(sno,tno,info,dangerlevel);
        userMapper.changeAppointment(appointment);
    }

    //完成预约
    @RequestMapping("/finishAppointment")
    public void finishAppointment(HttpServletRequest httpServletRequest){
        int statu = 1;
        String tno = httpServletRequest.getParameter("tno");
        String sno = httpServletRequest.getParameter("sno");
        String info = httpServletRequest.getParameter("info");
        int dangerlevel = Integer.parseInt(httpServletRequest.getParameter("dangerlevel"));

        Appointment appointment = new Appointment(sno,tno,info,dangerlevel,statu);
        userMapper.finishAppointment(appointment);
    }

    //根据学号查询预约
    @RequestMapping("/queryAppointmentBySno")
    public Result queryAppointmentBySno(String sno){
        List<Appointment> appointmentList = userMapper.queryAppointmentBySno(sno);
        return new Result<Appointment>(appointmentList);
    }

    //根据工号查询预约
    @RequestMapping("/queryAppointmentByTno")
    public Result queryAppointmentByTno(String tno){
        List<Appointment> appointmentList = userMapper.queryAppointmentByTno(tno);
        return new Result<Appointment>(appointmentList);
    }

    //查询我的学生
    @RequestMapping("/queryMyStudent")
    public Result queryMyStudent(String tno){
        List<User> students = userMapper.queryMyStudent(tno);
        return new Result<User>(students);
    }



}
