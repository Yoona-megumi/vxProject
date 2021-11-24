package com.mapper;

import com.pojo.Appointment;
import com.pojo.Relation;
import com.pojo.Teacher;
import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是个mybatis的mapper类  Dao
@Mapper
@Repository
public interface UserMapper {

    User queryStudentBySno(int sno);

    List<Teacher> queryTeacherList();

    List<User> queryStudentList();

    int addStudent(User user);

    int updateStudent(User user);

    int deleteStudentBySno(int sno);

    List<User> queryStudentBySname(String sname);

    Teacher queryTeacherByTno(int tno);

    List<Teacher> queryTeacherBySname(String tname);

    int addAppointment(Appointment appointment);

    int cancelAppointment(Appointment appointment);

    int changeAppointment(Appointment appointment);

    Appointment queryAppointmentBySno(int sno);

    Appointment queryAppointmentByTno(int tno);

    int finishAppointment(Appointment appointment);

    int stUDentAddTeacher(Relation relation);

    int teacherAddStudent(Relation relation);


}
