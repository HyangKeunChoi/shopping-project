package mymind.mymind.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Human extends BaseAbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "human_id")
    private Long id;

    private int age;

    private String userName;

    @OneToMany(mappedBy = "human")
    private List<Company> appliedCompanys = new ArrayList<>();

    @Embedded
    AdditionalInfo additionalInfo;
}
