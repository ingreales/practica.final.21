package controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/actualizar-carro")
public class ActualizarCarrosServlet extends HttpServlet {
    @Inject
    private Carro carro; // Inyección de dependencia del objeto Carro

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateProductos(req, carro); // Actualiza los productos del carro
        updateCantidades(req, carro); // Actualiza las cantidades de los productos en el carro

        resp.sendRedirect(req.getConte
