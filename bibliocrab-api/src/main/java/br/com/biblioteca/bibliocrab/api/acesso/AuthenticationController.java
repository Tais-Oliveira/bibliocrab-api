package br.com.biblioteca.bibliocrab.api.acesso;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.bibliocrab.modelo.acesso.Usuario;
import br.com.biblioteca.bibliocrab.modelo.acesso.UsuarioService;
import br.com.biblioteca.bibliocrab.security.jwt.JwtTokenProvider;


@RestController
@RequestMapping("/login")
public class AuthenticationController  {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public Map<Object, Object> signin(@RequestBody AuthenticationRequest data) {

        try {

            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));

            Usuario usuario = this.usuarioService.findByUsername(data.getUsername());
            String token = jwtTokenProvider.createToken(usuario.getUsername(), usuario.getRoles());
            String refreshToken = jwtTokenProvider.createRefreshToken(usuario.getUsername());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", usuario.getUsername());
            model.put("token", token);
            model.put("refresh", refreshToken);

            return model;

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

}