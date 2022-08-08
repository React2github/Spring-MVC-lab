package com.example.demo.model;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Table(name="Signup_Table")
@Data
@Entity
public class Signup {
    @Id
    @GeneratedValue
    private int id;

    @Min(value = 0)
    @Max(23)
    private int time;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    @ManyToOne
    private Activity activity;

    @ManyToOne
    private Camper camper;


}
