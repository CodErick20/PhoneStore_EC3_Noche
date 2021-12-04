package Proyecto.PhoneStore.jpa.modelo;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;







/**
 *
 * @author man
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findById_producto", query = "SELECT p FROM Producto p WHERE p.id_producto = :id_producto")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.Nombre = :Nombre")
    , @NamedQuery(name = "Producto.findByUrl_imagen", query = "SELECT p FROM Producto p WHERE p.Url_imagen = :Url_imagen")
    , @NamedQuery(name = "Producto.findByFecha_Ingreso", query = "SELECT p FROM Producto p WHERE p.Fecha_Ingreso = :Fecha_Ingreso")
    , @NamedQuery(name = "Producto.findByPrecio_Compra", query = "SELECT p FROM Producto p WHERE p.Precio_Compra = :Precio_Compra")
    , @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.Stock = :Stock")
    , @NamedQuery(name = "Producto.findByEstado", query = "SELECT p FROM Producto p WHERE p.Estado = :Estado")
})

public class Producto implements Serializable  {
	

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer id_producto;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String Nombre;
    @Basic(optional = false)
    @Column(name = "Url_imagen")
    private String Url_imagen;
    @Column(name = "Fecha_Ingreso")
    private String Fecha_Ingreso; 
    @Column(name = "Precio_Compra")
    private Double Precio_Compra; 
    @Column(name = "Stock")
    private Integer Stock; 
    @Column(name = "Estado")
    private String Estado; 
    
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "",fetch=FetchType.LAZY)
    @JsonBackReference(value="estudiante_notas")
    private List<Ventas> notasList;*/
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria categoria;
    
   

    public Producto() {
    }

    public Producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Producto(Integer id_producto, String Nombre) {
        this.id_producto = id_producto;
        this.Nombre = Nombre;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getUrl_imagen() {
        return Url_imagen;
    }

    public void setUrl_imagen(String Url_imagen) {
        this.Url_imagen =Url_imagen;
    }
    

    public String getFecha_Ingreso() {
        return Fecha_Ingreso;
    }

    public void setFecha_Ingreso(String Fecha_Ingreso) {
        this.Fecha_Ingreso = Fecha_Ingreso;
    }
    
    public Double getPrecio_Compra() {
        return Precio_Compra;
    }

    public void setPrecio_Compra(Double Precio_Compra) {
        this.Precio_Compra = Precio_Compra;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer Stock) {
        this.Stock = Stock;
    }
    
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    /*----------------------------------------------------------------
    @XmlTransient
    public List<Notas> getNotasList() {
        return notasList;
    }

    public void setNotasList(List<Notas> notasList) {
        this.notasList = notasList;
    }---------------------------------------------------------------*/

    public Categoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_producto != null ? id_producto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id_producto == null && other.id_producto != null) || (this.id_producto != null && !this.id_producto.equals(other.id_producto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proyecto.PhoneStore.jpa.modelo.Producto[ id_producto=" + id_producto + " ]";
    }
    public Producto buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
    }
    
    
    
    
    
    
    
}
