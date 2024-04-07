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
	@Column(name = "id_empleado")
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
	
	@Column(name = "numero_documento", nullable = false, unique = true)
	private String numberDocument;

	@Column(name = "activo", columnDefinition = "BOOLEAN DEFAULT true")
	private boolean IsActive;

	@ManyToOne
	@JoinColumn(name = "id_tipo_documento")
	private TypeDocument typeDocument;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}

	public TypeDocument getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}


}
