package mapping;


import mapping.dto.UsuarioDto;
import models.Usuario;

public class UsuarioMapper {
    public static UsuarioDto mapFrom(Usuario usuario){
        return new UsuarioDto(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getEmail());
    }
    public static Usuario mapFromDto(UsuarioDto usuarioDto){
        return Usuario.builder()
                .id(usuarioDto.id())
                .username(usuarioDto.username())
                .password(usuarioDto.password())
                .email(usuarioDto.email())
                .build();
    }
}
