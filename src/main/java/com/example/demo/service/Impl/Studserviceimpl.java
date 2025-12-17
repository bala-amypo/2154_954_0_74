package com.example.demo.service.impl;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl
implements StudentService{
    private final Map<Long,Student>store=new HashMap<>();
    private long counter=1;

    @Override
    public Student insertStudent(Student st){
        st.setId(counter++);
        store.put(st.getId(),st);
        return st;
    }

    @Override
    public List<Student>getAllStudents()
    {
        return new ArrayList<>(stor.values());
    }

    @Override
    public Optional<Student>getOneStudent(Long id){
        return Optional.ofNullables(store.get(id));
    }

    @Override public void deleteStudent(Long id) {
        store.remove(id);
    }
}