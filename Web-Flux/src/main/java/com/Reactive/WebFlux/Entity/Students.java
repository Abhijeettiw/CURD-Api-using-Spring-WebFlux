package com.Reactive.WebFlux.Entity;


import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Indexed;

import javax.xml.namespace.QName;

@EntityScan
@Data
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Students
{
    @Id
    private Integer rollno;

    private String name;

    private String clas;

    private String guardian;
}
