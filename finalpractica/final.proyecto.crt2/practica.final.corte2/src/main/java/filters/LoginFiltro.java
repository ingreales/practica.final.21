package filters;

import services.LoginService;
import services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Filter;

public class LoginFiltro {
    import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Optional;

    @WebFilter({"/ver-carro","/agregar-carro","/actualizar-carro","/productos/form/*","/productos/eliminar/*"})
    public class LoginFiltro implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            LoginService service = new LoginServiceSessionImpl();
            Optional<String> username = service.getUsername((HttpServletRequest) request);
            if (username.isPresent()){
                chain.doFilter(request, response);
            }
            else {
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        "Lo sentimos bro no estas autorizado para ingresar a esta pagina ;(");
            }
        }
    }
}
