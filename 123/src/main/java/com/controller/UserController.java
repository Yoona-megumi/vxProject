package com.controller;

import com.mapper.UserMapper;
import com.pojo.Appointment;
import com.pojo.Result;
import com.pojo.Teacher;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //根据学号查询学生
    @GetMapping("/queryStudentBySno/{sno}")
    public Result queryStudentBySno(@PathVariable("sno") int sno){
        User student = userMapper.queryStudentBySno(sno);
        return new Result<User>(student);
    }

    //根据姓名查询学生
    @GetMapping("/queryStudentBySname/{sname}")
    public  Result queryStudentBySname(@PathVariable("sname") String sname){
        List<User> student = userMapper.queryStudentBySname(sname);
        return new Result<User>(student);
    }

    //根据工号查询老师
    @GetMapping("/queryTeacherByTno/{tno}")
    public  Result queryTeacherByTno(@PathVariable("tno") int tno){
        Teacher teacher = userMapper.queryTeacherByTno(tno);
        return new Result<Teacher>(teacher);
    }

    //根据姓名查询老师
    @GetMapping("/queryTeacherByTname/{tname}")
    public  Result queryTeacherBySname(@PathVariable("tname") String tname){
        List<Teacher> teacher = userMapper.queryTeacherBySname(tname);
        return new Result<Teacher>(teacher);
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
    @GetMapping("/deleteStudentBySno/{sno}")
    public void deleteStudentBySno(@PathVariable("sno") int sno){
        userMapper.deleteStudentBySno(sno);
    }

    //添加用户
    @RequestMapping("/addStudent")
    public void addStudent(HttpServletRequest httpServletRequest){
        String sno1 = httpServletRequest.getParameter("sno");
        int sno = Integer.parseInt(sno1);
        String sname = httpServletRequest.getParameter("sname");
        String sgrade = httpServletRequest.getParameter("sgrade");
        String sphone1 = httpServletRequest.getParameter("sphone");
        int sphone = Integer.parseInt(sphone1);
        String sschool = httpServletRequest.getParameter("sschool");
        String sdept = httpServletRequest.getParameter("sdept");
        String sinfo = httpServletRequest.getParameter("sinfo");
        String steacher1 = httpServletRequest.getParameter("steacher");
        int steacher = Integer.parseInt(steacher1);

        User student = new User(sno,sname,sgrade,sphone,sschool,sdept,sinfo,steacher);
        userMapper.addStudent(student);
    }

    //更新用户信息
    @RequestMapping("/updateStudent")
    public void updateStudent(HttpServletRequest httpServletRequest){
        String sno1 = httpServletRequest.getParameter("sno");
        int sno = Integer.parseInt(sno1);
        String sname = httpServletRequest.getParameter("sname");
        String sgrade = httpServletRequest.getParameter("sgrade");
        String sphone1 = httpServletRequest.getParameter("sphone");
        int sphone = Integer.parseInt(sphone1);
        String sschool = httpServletRequest.getParameter("sschool");
        String sdept = httpServletRequest.getParameter("sdept");
        String sinfo = httpServletRequest.getParameter("sinfo");
        String steacher1 = httpServletRequest.getParameter("steacher");
        int steacher = Integer.parseInt(steacher1);

        User student = new User(sno,sname,sgrade,sphone,sschool,sdept,sinfo,steacher);
        userMapper.updateStudent(student);
    }

    //增加预约
    @RequestMapping("/addAppointment")
    public void addAppointment(HttpServletRequest httpServletRequest){
        String sno1 = httpServletRequest.getParameter("sno");
        int sno = Integer.parseInt(sno1);
        String tno1 = httpServletRequest.getParameter("tno");
        int tno = Integer.parseInt(tno1);
        String info = httpServletRequest.getParameter("info");
        String statu1 = httpServletRequest.getParameter("statu");
        int statu = Integer.parseInt(statu1);

        Appointment appointment = new Appointment(sno,tno,info,statu);
        userMapper.addAppointment(appointment);
    }

    //取消预约
    @RequestMapping("/cancelAppointment")
    public void cancelAppointment(HttpServletRequest httpServletRequest){
        String sno1 = httpServletRequest.getParameter("sno");
        int sno = Integer.parseInt(sno1);
        String tno1 = httpServletRequest.getParameter("tno");
        int tno = Integer.parseInt(tno1);
        String info = httpServletRequest.getParameter("info");
        String statu1 = httpServletRequest.getParameter("statu");
        int statu = Integer.parseInt(statu1);

        Appointment appointment = new Appointment(sno,tno,info,statu);
        userMapper.cancelAppointment(appointment);
    }

    //修改预约
    @RequestMapping("/changeAppointment")
    public void changeAppointment(HttpServletRequest httpServletRequest){
        String sno1 = httpServletRequest.getParameter("sno");
        int sno = Integer.parseInt(sno1);
        String tno1 = httpServletRequest.getParameter("tno");
        int tno = Integer.parseInt(tno1);
        String info = httpServletRequest.getParameter("info");
        String statu1 = httpServletRequest.getParameter("statu");
        int statu = Integer.parseInt(statu1);

        Appointment appointment = new Appointment(sno,tno,info,statu);
        userMapper.changeAppointment(appointment);
    }

    //根据学号查询预约
    @GetMapping("/queryAppointmentBySno/{sno}")
    public Result queryAppointmentBySno(@PathVariable("sno") int sno){
        Appointment appointment = userMapper.queryAppointmentBySno(sno);
        return new Result<Appointment>(appointment);
    }

    //根据工号查询预约
    @GetMapping("/queryAppointmentByTno/{tno}")
    public Result queryAppointmentByTno(@PathVariable("tno") int tno){
        Appointment appointment = userMapper.queryAppointmentByTno(tno);
        return new Result<Appointment>(appointment);
    }

    //完成预约
    @RequestMapping("/finishAppointment")
    public void finishAppointment(HttpServletRequest httpServletRequest){
        String sno1 = httpServletRequest.getParameter("sno");
        int sno = Integer.parseInt(sno1);
        String tno1 = httpServletRequest.getParameter("tno");
        int tno = Integer.parseInt(tno1);
        String info = httpServletRequest.getParameter("info");
        String statu1 = httpServletRequest.getParameter("statu");
        int statu = Integer.parseInt(statu1);

        Appointment appointment = new Appointment(sno,tno,info,statu);
        userMapper.finishAppointment(appointment);
    }





}
