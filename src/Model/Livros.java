
package Model;

public class Livros {
    
    private String ISBN;
    private String titulo;
    private String genero;
    private String autor;
    private boolean disponivel;
    
    public Livros(String ISBN, String titulo, String genero, String autor, boolean disponivel) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    
    
    
    
}
