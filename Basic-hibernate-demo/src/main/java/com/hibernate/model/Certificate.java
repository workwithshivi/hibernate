package com.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
//use to embed an object to other object's table. Table will have all the variables of this class
public class Certificate {
    private String course;
    private String duration;
}
