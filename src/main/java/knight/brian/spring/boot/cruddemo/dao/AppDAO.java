package knight.brian.spring.boot.cruddemo.dao;

import knight.brian.spring.boot.cruddemo.entity.Instructor;
import knight.brian.spring.boot.cruddemo.entity.InstructorDetail;


public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
