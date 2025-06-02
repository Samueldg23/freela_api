package br.com.unisales.freela.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;
    @Column(name = "fotoPerfil", nullable = false, length = 255)
    private String fotoPerfil;
    @Column(name = "cpf", nullable = false, unique = true, length = 14)
    private String cpf;
    @Column(name = "senha", nullable = false, length = 255)
    private String senha;
    @Column(name= "endereco", nullable = false, length = 255)
    private String endereco;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoUsuario", nullable = false)
    private TipoUsuario tipoUsuario;
    public enum TipoUsuario {
        CLIENTE,
        PRESTADOR
    }
}
