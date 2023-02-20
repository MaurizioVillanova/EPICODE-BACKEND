package com.mauriziovillanova.W6D5.progettosettimanalespringboot.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.enums.StatoDispositivo;
import com.mauriziovillanova.W6D5.progettosettimanalespringboot.models.enums.TipoDispositivo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name =  "dispositivi")
public class Dispositivo {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
private int id;
private String nome;
@Enumerated(EnumType.STRING)
private TipoDispositivo tipo;
@Enumerated(EnumType.STRING)
private StatoDispositivo stato;
}
