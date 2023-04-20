package utpl.edu.ec.TrabajoGrupal.JPA;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class VehiculoController {
    private static EntityManager em = null;

    public VehiculoController() {
        getEm("pu-pa");
    }

    private void getEm(String puName) {
        if(em == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(puName);
            em = emf.createEntityManager();
        }
    }

    public boolean addEntidad(VehiculoDTO register) {

        Vehiculo newRegistration = new Vehiculo(register.id(), register.placa(), register.anioFabricacion(),
                register.chasis(), register.motor(), register.color1(), register.color2(), register.avaluo(),
                register.prendado());
        em.getTransaction().begin();
        em.persist(newRegistration);
        em.flush();
        em.getTransaction().commit();

        return true;
    }

    public List<VehiculoDTO> getVehiculos() {
        TypedQuery<VehiculoDTO> qryAll = em.createQuery("""
                SELECT new utpl.edu.ec.TrabajoGrupal.JPA.VehiculoDTO(e.id, e.placa, e.anioFabricacion, e.chasis,
                e.motor, e.color1, e.color2, e.avaluo, e.prendado)
                FROM Vehiculo e
                """, VehiculoDTO.class);

        return qryAll.getResultList();

    }

    public void close() {
        em.close();
    }
}
