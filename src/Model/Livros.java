
package Model;

public class Livros {
    
    private int ISBN;
    private String titulo;
    private String genero;
    private String autor;
    private boolean disponivel;
    
    public Livros(int ISBN, String titulo, String genero, String autor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.disponivel = true;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
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
