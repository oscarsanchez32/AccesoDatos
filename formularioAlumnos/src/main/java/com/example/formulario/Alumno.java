/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.formulario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;



/**
 *
 * @author oscar
 */
@Data
@Entity
@Table(name="Alumnos")
public class Alumno {
    //Generamos clave primaria
    @Id
    @Column(length = 10)
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int id;
    
    @Column (name="nombre", length= 100)
    private String nombre;
    
    @Column (name="apellidos", length= 200)
    private String apellidos;
    
    @Column (name="edad", length=2)
    private int edad;
    
    @Column (name="dni", length=10)
    private String dni;
}
