package repositories;

import mapping.dto.UsuarioDto;

import java.sql.SQLException;

public interface UsuarioRepository extends Repository<UsuarioDto>{
    UsuarioDto porUsername(String username) throws SQLException;
}