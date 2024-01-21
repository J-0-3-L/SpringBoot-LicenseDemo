package com.joel.manejo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="licenses")
@Getter
@Setter
@NoArgsConstructor
public class License extends ModelBase {
    
    @NotNull
    @NotBlank
    @Size(min = 6 , max = 6)
    private String number;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 2)
    private String state;


    @NotNull
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;

    public Long getPersonId() {
        return person.getId();
    }
    
}