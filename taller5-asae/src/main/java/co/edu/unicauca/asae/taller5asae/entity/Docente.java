package co.edu.unicauca.asae.taller5asae.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="Docente")
@Data
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{docente.tipoIdentificacion.notNull}")
	@Size(min = 2, max = 20, message="{docente.tipoIdentificacion.size}")
	private String tipoIdentificacion;

    @NotNull(message = "{docente.identificacion.notNull}")
	@Size(min = 8, max = 12, message="{docente.identificacion.size}")
	private String identificacion;

    @NotNull(message = "{docente.nombres.notNull}")
	@Size(min = 2, max = 45, message="{docente.nombres.size}")
	private String nombres;	

    @NotNull(message = "{docente.apellidos.notNull}")
	@Size(min = 2, max = 45, message="{docente.apellidos.size}")
	private String apellidos;

	@Size(min = 7, max = 12, message="{docente.telefono.size}")
	private String telefono;

    @NotNull(message = "{docente.correo.notNull}")
    @Email(message = "{docente.correo.notNull}")
	private String correo;

    @NotNull(message = "{docente.genero.notNull}")
	@Size(min = 2, max = 45, message="{docente.genero.size}")
	private String genero;

    @NotNull(message = "{docente.titulo.notNull}")
	@Size(min = 2, max = 45, message="{docente.titulo.size}")
	private String titulo;

    @NotNull(message = "{docente.universidadTitulo.notNull}")
	@Size(min = 2, max = 45, message="{docente.universidadTitulo.size}")
    private String universidadTitulo;

	@Size(min = 2, max = 45, message="{docente.categoriaMic.size}")
    private String categoriaMic;

	@Size(min = 2, max = 100, message="{docente.linkCvLac.size}")
    private String linkCvLac;

    @Size(min = 2, max = 45, message="{docente.facultad.size}")
    private String facultad;

    @Size(min = 2, max = 45, message="{docente.departamento.size}")
    private String departamento;

    @Size(min = 2, max = 45, message="{docente.grupoInv.size}")
    private String grupoInv;

    @Size(min = 2, max = 45, message="{docente.lineaInv.size}")
    private String lineaInv;

    @Size(min = 2, max = 45, message="{docente.tipoVinculacion.size}")
    private String tipoVinculacion;

    @Size(min = 4, max = 45, message="{docente.escalafon.size}")
    private String escalafon;

    @Size(min = 0, max = 200, message="{docente.observacion.size}")
    private String observacion;
    
}
