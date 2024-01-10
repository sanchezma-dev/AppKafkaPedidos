package micro.app.usuario.service.impl;

import lombok.extern.slf4j.Slf4j;
import micro.app.usuario.convert.IUsuarioConvert;
import micro.app.usuario.dto.UsuarioDto;
import micro.app.usuario.entity.UsuarioEntity;
import micro.app.usuario.exceptions.ApiResponseException;
import micro.app.usuario.repository.UsuarioRepository;
import micro.app.usuario.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    /** Repository */
    @Autowired
    private UsuarioRepository repo;

    /** Coonvert */
    @Autowired
    private IUsuarioConvert convert;

    @Override
    public UsuarioDto saveUsuario(UsuarioDto usuarioDto) {
        final UsuarioEntity usuarioEntity = convert.convertToEntity(usuarioDto);
        try{
            return convert.convertToDto(repo.save(usuarioEntity));
        } catch (Exception e) {
            log.error("Error en la creación de usuario: ", e.getMessage());
            throw ApiResponseException.of("Error en la creación de usuario: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
