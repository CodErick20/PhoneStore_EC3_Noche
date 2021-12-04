package Proyecto.PhoneStore.jpa.modelo;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;







/**
*
* @author man
*/
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
   , @NamedQuery(name = "Categoria.findById_categoria", query = "SELECT c FROM Categoria c WHERE c.id_categoria = :id_categoria")
   , @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.Nombre = :Nombre")
   , @NamedQuery(name = "Categoria.findByEstado", query = "SELECT c FROM Categoria c WHERE c.Estado = :Estado")})

public class Categoria implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer id_categoria;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String Nombre;
    @Basic(optional = false)
    @Column(name = "Estado")
    private String Estado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    @JsonBackReference(value="categoria_Producto")
    private List<Producto> productoList;
    
    public Categoria() {
    }

    public Categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Categoria(Integer id_categoria, String Nombre,String Estado) {
        this.id_categoria = id_categoria;
        this.Nombre = Nombre;
        this.Estado = Estado;
       
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_categoria != null ? id_categoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id_categoria == null && other.id_categoria != null) || (this.id_categoria != null && !this.id_categoria.equals(other.id_categoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proyecto.PhoneStore.jpa.modelo.Categoria[ id_categoria=" + id_categoria + " ]";
    }
	

}
