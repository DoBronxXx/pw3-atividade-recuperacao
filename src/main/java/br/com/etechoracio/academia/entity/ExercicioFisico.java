package br.com.etechoracio.academia.entity;

import br.com.etechoracio.academia.enums.NivelDificuldadeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_EXERCICIO_FISICO")
public class ExercicioFisico {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_EXERCICIO_FISICO")
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_GRUPO_MUSCULAR")
    private String grupoMuscular;

    @Column(name = "TX_IMAGEM")
    private String imagem;

    @Column(name = "TX_DESCRICAO")
    private String descricao;

    @Column(name = "NR_SERIES")
    private Integer series;

    @Column(name = "NR_REPETICOES")
    private int repeticoes;

    @Column(name = "NR_CARGA_SUGERIDA")
    private double cargaSugerida;

    @Column(name = "TP_DIFICULDADE")
    private NivelDificuldadeEnum nivelDificuldade;

    @Column(name = "CK_APROVADO")
    private boolean aprovado;

}
