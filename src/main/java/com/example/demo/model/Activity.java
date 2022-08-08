package com.example.demo.model;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name="Activity_Table")
@Data
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int difficulty;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    @OneToMany(mappedBy = "activity")
    private List<Signup> signupsList = new ArrayList<Signup>();


}
