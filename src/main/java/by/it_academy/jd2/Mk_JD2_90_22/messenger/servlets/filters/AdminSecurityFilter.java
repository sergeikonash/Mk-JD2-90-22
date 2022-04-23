package by.it_academy.jd2.Mk_JD2_90_22.messenger.servlets.filters;

import by.it_academy.jd2.Mk_JD2_90_22.messenger.core.dto.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if ((session != null) && (session.getAttribute("user") != null)) {
            User user = (User) session.getAttribute("user");
            if (Objects.equals(user.getLogin(), "admin")) {
                chain.doFilter(request, response);
            }
        }else {
            resp.sendRedirect(req.getContextPath() + "/ui/signIn");
        }
    }

    @Override
    public void destroy() {
    }

}