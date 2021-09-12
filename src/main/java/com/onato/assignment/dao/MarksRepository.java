package com.onato.assignment.dao;

import com.onato.assignment.dto.Percentage;
import com.onato.assignment.dto.StudentDao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.onato.assignment.entity.Marks;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MarksRepository extends CrudRepository<Marks, Integer> {

  List<Marks> findByStudentId (Integer studentId);

  Marks findByStudentIdAndSubject(Integer studentId, String subject);

  void deleteByStudentIdAndSubject(Integer studentId, String subject);


  @Query(value =
      " SELECT ma.student_id,st.roll_number,st.name,st.standard,AVG(marks) as aggregate FROM marks ma "
          + " INNER JOIN student st ON ma.student_id = st.id "
          + " GROUP BY ma.student_id"
          + " HAVING AVG(marks) > ?1",
      nativeQuery = true)
  List<Percentage> findPercentage(Integer marks);


  @Query(value =
      " SELECT ma.student_id,ma.marks,ma.subject,st.roll_number,st.name,st.standard FROM marks ma "
          + " INNER JOIN student st ON ma.student_id = st.id "
          + " WHERE st.standard = ?1 AND ma.marks = (SELECT max(marks) FROM marks ma WHERE ma.subject = ?2 ) ",
      nativeQuery = true)
  List<StudentDao> findToppers(String standard, String subject);


}
