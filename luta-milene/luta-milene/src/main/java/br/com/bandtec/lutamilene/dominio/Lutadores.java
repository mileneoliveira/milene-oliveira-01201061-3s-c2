package br.com.bandtec.lutamilene.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity

public class Lutadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 12)
    @NotBlank
    private String nome;
    @PositiveOrZero
    private Double golpeForca;

    private Double vida;
    private Integer concentracoesRealizadas;
    private Boolean vivo;

   public Lutadores(){
       this.vida = 100.0;
       this.concentracoesRealizadas = 0;
       this.vivo = true;
   }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getGolpeForca() {
        return golpeForca;
    }

    public void setGolpeForca(Double golpeForca) {
        this.golpeForca = golpeForca;
    }

    public Double getVida() {
        return vida;
    }

    public void setVida(Double vida) {
        this.vida = vida;
    }

    public Integer getConcentracoesRealizadas() {
        return concentracoesRealizadas;
    }

    public void setConcentracoesRealizadas() {
        this.concentracoesRealizadas = concentracoesRealizadas;
    }

    public Boolean getVivo() {
        return vivo;
    }

    public void setVivo(Boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public String toString() {
        return "Lutadores{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", golpeForca=" + golpeForca +
                ", vida=" + vida +
                ", concentracoesRealizadas=" + concentracoesRealizadas +
                ", vivo=" + vivo +
                '}';
    }
}
