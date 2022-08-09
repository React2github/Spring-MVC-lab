package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name="Camper_Table")

@Data
@Entity
public class Camper {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotBlank
    private String name;

    @Min(value = 8)
    @Max(18)
    private int age;

    @Temporal(TemporalType.DATE)
    private Date created_at = new Date();

    @Temporal(TemporalType.DATE)
    private Date updated_at = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "camper")
    private List<Signup> signupList = new ArrayList<Signup>();
}
