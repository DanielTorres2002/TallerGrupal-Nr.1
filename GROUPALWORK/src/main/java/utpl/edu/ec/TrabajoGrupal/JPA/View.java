package utpl.edu.ec.TrabajoGrupal.JPA;



public class View {
    public static void main(String[] args) {
        VehiculoController database = new VehiculoController();


        for(var register : database.getVehiculos()) {
            System.out.printf("%d - %s %d %s %s %s %s  %f  (%b)%n",
                    register.id(),
                    register.placa(),
                    register.anioFabricacion(),
                    register.chasis(),
                    register.motor(),
                    register.color1(),
                    register.color2(),
                    register.avaluo(),
                    register.prendado());
        }
        database.close();
    }
}

