package com.litografiaartesplanchas.employeesservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", nullable = false , length = 100)
    private String name;

    @Column(name = "apellido", nullable = false , length = 100)
    private String lastname;
	
	@Column(name = "correo", nullable = false , length = 255, unique = true)
	private String email;
	
	@Column(name = "contrasena", nullable = false , length = 255)
	private String password;
	
	@Column(name = "telefono", nullable = true , length = 30)
	private String phone;
	
	@Column(name = "foto", nullable = true , length = 255)
	private String photo;
	
	@Column(name = "numero_documento", nullable = false , length = 45)
	private String numberDocument;

    @ManyToOne
	@JoinColumn(name = "id_tipo_documento")
	private TypeDocument typeDocument;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Role role;



}
