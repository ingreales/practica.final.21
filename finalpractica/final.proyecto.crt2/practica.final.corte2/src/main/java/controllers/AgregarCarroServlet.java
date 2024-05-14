package controllers;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapping.dto.ProductoDto;
import models.Carro;
import models.ItemCarro;
import services.ProductoService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {
    @Inject
    private Carro carro; // Inyección de dependencia del objeto Carro
    @Inject
    private ProductoService service; // Inyección de dependencia del servicio de producto

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se obtiene el ID del producto desde los parámetros de la solicitud

        Long id = Long.parseLong(req.getParameter("id"));

        // Se busca el producto por su ID utilizando el servicio de producto
        Optional<ProductoDto> producto = service.porId(id);
        // Si el producto existe
        if (producto.isPresent()) {

            // Se crea un nuevo elemento del carro con una cantidad predeterminada de 1 y el producto encontrado
            ItemCarro item = new ItemCarro(1, producto.get());

            // Se agrega el elemento del carro al carro
            carro.addItemCarro(item);
        }
        // Se redirige al usuario a la página de visualización del carro
        resp.sendRedirect(req.getContextPath() + "/ver-carro");
    }
}
