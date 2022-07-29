package in.ac.charusat.studentmgmtsystem.repository;


import in.ac.charusat.studentmgmtsystem.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository <Result, Integer> {
}