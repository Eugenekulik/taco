package by.eugenekulik.taco.domain;


import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "`order`")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Date placedAt;

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    @ManyToOne
    private User user;

    public void addDesign(Taco taco){
        tacos.add(taco);
    }
}
