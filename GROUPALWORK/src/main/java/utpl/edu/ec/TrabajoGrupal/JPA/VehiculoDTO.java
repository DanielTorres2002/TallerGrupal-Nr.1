package utpl.edu.ec.TrabajoGrupal.JPA;

public record VehiculoDTO(int id, String placa, int anioFabricacion, String chasis, String motor,
                          String color1, String color2, double avaluo, Boolean prendado) {
}
