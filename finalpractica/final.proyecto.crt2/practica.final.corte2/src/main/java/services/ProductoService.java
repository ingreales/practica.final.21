package services;

import mapping.dto.CategoriaDto;
import mapping.dto.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<ProductoDto> listar();
    Optional<ProductoDto> porId(Long id);
    void guardar(ProductoDto producto);
    void eliminar(Long id);
    List<CategoriaDto> listarCategoria();
    Optional<CategoriaDto> porIdCategoria(Long id);
}
