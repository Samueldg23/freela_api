package br.com.unisales.freela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisales.freela.model.Usuario;
import br.com.unisales.freela.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repo.save(usuario);
    }

    public Usuario buscarPorEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public Usuario buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public Usuario atualizarUsuario(Usuario usuarioAtualizado) {
        Usuario usuario = repo.findById(usuarioAtualizado.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setTelefone(usuarioAtualizado.getTelefone());
        usuario.setFotoPerfil(usuarioAtualizado.getFotoPerfil());
        usuario.setCpf(usuarioAtualizado.getCpf());
        usuario.setTipoUsuario(usuarioAtualizado.getTipoUsuario());

        return repo.save(usuario);
    }

    public void deletarUsuario(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        repo.deleteById(id);
    }

    public List<Usuario> listarUsuarios() {
        return repo.findAll();
    }
}
