package mapping;


import mapping.dto.CategoriaDto;
import models.Categoria;
import models.Producto;

public class CategoriaMapper {
    public static <CategoriaDto> CategoriaDto mapFrom(Categoria categoria){
        return new CategoriaDto(categoria.getId(),categoria.getNombre());
    }
    public static Producto mapFromDto(CategoriaDto categoriaDto) {
        return Producto.builder()
                .id(categoriaDto.id())
                .nombre(categoriaDto.nombre())
                .build();
    }
}
