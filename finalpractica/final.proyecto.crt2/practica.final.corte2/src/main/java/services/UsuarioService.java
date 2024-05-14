package services;
import mapping.dto.UsuarioDto;

import java.util.Optional;

public interface UsuarioService {
    Optional<UsuarioDto> login(String username, String password);
}
