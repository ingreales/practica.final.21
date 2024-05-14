package mapping.dto;

import models.Categoria;

import java.time.LocalDate;

public record ProductoDto(Long id, String nombre, Categoria categoria, int precio, String sku, LocalDate fechaRegistro) {
}
