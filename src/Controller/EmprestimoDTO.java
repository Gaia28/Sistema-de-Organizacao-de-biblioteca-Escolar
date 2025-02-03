package Controller;

import java.util.Date;

public class EmprestimoDTO {
    private int id;
    private String alunoNome;
    private String alunoTurma;
    private String livroTitulo;
    private String livroISBN;
    private String dataEmprestimo;
    private String dataDevolucao;
    private boolean devolvido;

    public EmprestimoDTO(int id, String alunoNome, String alunoTurma, String livroTitulo,String ISBNLivro, String dataEmprestimo, String dataDevolucao, boolean devolvido) {
        this.id = id;
        this.alunoNome = alunoNome;
        this.alunoTurma = alunoTurma;
        this.livroTitulo = livroTitulo;
        this.livroISBN = ISBNLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
    }

    public int getId() { return id; }
    public String getAlunoNome() { return alunoNome; }
    public String getAlunoTurma() { return alunoTurma; }
    public String getLivroTitulo() { return livroTitulo; }
    public String getLivroISBN(){return livroISBN;}
    public String getDataEmprestimo() { return dataEmprestimo; }
    public String getDataDevolucao() { return dataDevolucao; }
    public boolean isDevolvido() { return devolvido; }
}
