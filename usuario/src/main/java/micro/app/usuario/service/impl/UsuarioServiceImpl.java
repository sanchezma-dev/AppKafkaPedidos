package micro.app.usuario.service.impl;

import micro.app.usuario.convert.IUsuarioConvert;
import micro.app.usuario.dto.UsuarioDto;
import micro.app.usuario.entity.UsuarioEntity;
import micro.app.usuario.repository.UsuarioRepository;
import micro.app.usuario.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return convert.convertToDto(repo.save(usuarioEntity));
    }
}
