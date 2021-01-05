package br.com.broscoder.hrworker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_worker")
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "daily_Income")
    private Double dailyIncome;
}
