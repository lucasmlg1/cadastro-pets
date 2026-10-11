package br.com.github.lucasmlg1.cadastro_pets.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "adotante")
public class Adotante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    private String nome;
    private String email;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @Generated(event = EventType.INSERT)
    @Column(name = "data_cadastro", insertable = false, updatable = false)
    private LocalDateTime dataCadastro;


}
