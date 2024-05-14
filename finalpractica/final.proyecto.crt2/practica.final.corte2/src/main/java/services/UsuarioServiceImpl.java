package services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mapping.dto.UsuarioDto;
import repositories.UsuarioRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{
    @Inject
    UsuarioRepository usuarioRepository;
    @Override
    public Optional<UsuarioDto> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.password().equals(password));
        } catch (SQLException throwables) {
            throw new org.jan.apiservlet.webapp.headers.services.ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}