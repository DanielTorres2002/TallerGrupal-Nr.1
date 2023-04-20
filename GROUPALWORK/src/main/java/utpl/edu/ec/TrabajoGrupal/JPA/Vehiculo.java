package utpl.edu.ec.TrabajoGrupal.JPA;

import javax.persistence.*;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PLACA")
    private String placa;

    @Column(name = "ANIO_FABRICACION")
    private Integer anioFabricacion;

    @Column(name = "NRO_CHASIS")
    private String chasis;

    @Column(name = "NRO_MOTOR")
    private String motor;

    @Column(name = "COLOR1")
    private String color1;

    @Column(name = "COLOR2")
    private String color2;

    @Column(name = "AVALUO")
    private double avaluo;

    @Column(name = "PRENDADO")
    private Boolean prendado;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, String PLACA, Integer anofabricacion, String chasis, String motor, String color1, String color2, double avaluo, Boolean prendado) {
        this.id = id;
        this.placa = PLACA;
        this.anioFabricacion = anofabricacion;
        this.chasis = chasis;
        this.motor = motor;
        this.color1 = color1;
        this.color2 = color2;
        this.avaluo = avaluo;
        this.prendado = prendado;
    }
}
