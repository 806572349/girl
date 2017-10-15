package com.example.demo.repository;

import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 80657 on 2017/10/15.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过年龄来查询
    public List<Girl> findByAge(int id);
}
