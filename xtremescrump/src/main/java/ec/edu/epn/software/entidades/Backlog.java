package ec.edu.epn.software.entidades;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Index
public class Backlog implements Serializable {

    @Id
    private Long id;

    private List<Ref<HistoriaUsuario>> historiasUsuario = new ArrayList<>();

    /**
     * Constructor vacio.
     */
    public Backlog() {
    }
}
