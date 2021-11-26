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

    List<User> queryStudentBySearchParam(String searchParam);

    List<Teacher> queryTeacherBySearchParam(String searchParam);

    List<Teacher> queryTeacherList();

    List<User> queryStudentList();

    int addStudent(User user);

    int updateStudent(User user);

    int deleteStudentBySno(String sno);

    int addTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    int deleteTeacherByTno(String tno);

    int addAppointment(Appointment appointment);

    int cancelAppointment(Appointment appointment);

    int changeAppointment(Appointment appointment);

    List<Appointment> queryAppointmentBySno(String sno);

    List<Appointment> queryAppointmentByTno(String tno);

    int finishAppointment(Appointment appointment);

    int stUDentAddTeacher(Relation relation);

    int teacherAddStudent(Relation relation);

    List<User> queryMyStudent(String tno);




}
