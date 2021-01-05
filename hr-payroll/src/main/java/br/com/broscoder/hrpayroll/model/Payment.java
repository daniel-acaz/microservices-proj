package br.com.broscoder.hrpayroll.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Payment implements Serializable {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getTotal() {
        return days * dailyIncome;
    }

}
