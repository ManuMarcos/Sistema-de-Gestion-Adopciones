package modelo;

import java.util.Date;
import java.util.List;

import modelo.dao.AnimalDao;
import modelo.dao.InMemoryAnimalDao;
import modelo.dto.AnimalDto;
import modelo.enumeraciones.EstadoAnimal;
import modelo.enumeraciones.TipoAnimal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Animal {

	private int nroIngreso;
	private int altura;
	private int peso;
	private LocalDate fecha_nac;
	private String especie;
	private EstadoAnimal estado;
	private TipoAnimal tipo;
	private Adopcion adopcion;
	private FichaMedica fichaMedica;
	
	public Animal() {}
	
	public Animal(int nroIngreso, int altura, int peso, LocalDate fecha_nac, String especie, EstadoAnimal estado, TipoAnimal tipo) {
		this.nroIngreso = nroIngreso;
		this.altura = altura;
		this.peso = peso;
		this.fecha_nac = fecha_nac;
		this.especie = especie;
		this.estado = estado;
		this.tipo = tipo;
		this.fichaMedica = new FichaMedica(this);
	}
	
	public Animal(int altura, int peso, LocalDate fecha_nac, String especie, EstadoAnimal estado, TipoAnimal tipo) {
		this.altura = altura;
		this.peso = peso;
		this.fecha_nac = fecha_nac;
		this.especie = especie;
		this.estado = estado;
		this.tipo = tipo;
		this.fichaMedica = new FichaMedica(this);
	}
	
	
	public void registrarAnimal(Animal animal) {
		AnimalDao animalDao = new InMemoryAnimalDao();
		animalDao.add(animal);
	}
	
	
	public void agregarAlarma(Alarma alarma) {
		this.fichaMedica.agregarAlarma(alarma);
	}
	
	public List<Alarma> obtenerAlarmas(){
		return this.fichaMedica.getAlarmas();
	}
	
	public Animal buscarAnimal(int nroIngreso) {
		AnimalDao animalDao = new InMemoryAnimalDao();
		return animalDao.getByNroIngreso(nroIngreso);
	}
	
	public boolean updateAnimal(Animal animal) {
		AnimalDao animalDao = new InMemoryAnimalDao();
		return animalDao.update(animal);
	}
	
	public void deleteAnimal(int nroIngreso) {
		AnimalDao animalDao = new InMemoryAnimalDao();
		animalDao.delete(nroIngreso);
	}
	
	public List<Animal> getAll(){
		AnimalDao animalDao = new InMemoryAnimalDao();
		return animalDao.getAll();
	}
	
	public int getNroIngreso() {
		return this.nroIngreso;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public LocalDate getFecha_nac() {
		return fecha_nac;
	}


	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public EstadoAnimal getEstado() {
		return estado;
	}


	public void setEstado(EstadoAnimal estado) {
		this.estado = estado;
	}


	public TipoAnimal getTipo() {
		return tipo;
	}


	public void setTipo(TipoAnimal tipo) {
		this.tipo = tipo;
	}


	public Adopcion getAdopcion() {
		return adopcion;
	}


	public void setAdopcion(Adopcion adopcion) {
		this.adopcion = adopcion;
	}

	public FichaMedica getFichaMedica() {
		return fichaMedica;
	}
	

	public void setNroIngreso(int nroIngreso) {
		this.nroIngreso = nroIngreso;
	}
	
	public boolean esAdoptable() {
		return this.estado == EstadoAnimal.SALUDABLE && this.tipo == TipoAnimal.DOMESTICO && adopcion == null;
	}
	
	public AnimalDto toDto() {
		return new AnimalDto(this.nroIngreso, this.altura, this.peso, this.fecha_nac, this.especie, this.estado, this.tipo);
				
	}
	
	public boolean agregarVisitaAFicha(Visita v) {
		return this.fichaMedica.agregarVisita(v);
	}
	
	public List<Visita> getVisitasDeFicha(){
		return this.fichaMedica.getVisitas();
	}
		
}
