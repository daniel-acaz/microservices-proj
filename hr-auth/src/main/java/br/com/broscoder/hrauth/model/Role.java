package br.com.broscoder.hrauth.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Role implements Serializable {

    private Long id;
    private String roleName;
}
