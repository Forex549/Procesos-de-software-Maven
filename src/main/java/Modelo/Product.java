package Modelo;

public class Product {
    private String nombre;
    private String descripcion;
    private String imagenPath;
    private double precio;
    public Product(String nombre, String descripcion, String imagenPath, double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenPath = imagenPath;
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public double getPrecio() {
        return precio;
    }
}
