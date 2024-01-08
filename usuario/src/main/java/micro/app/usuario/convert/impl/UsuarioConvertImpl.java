package micro.app.usuario.convert.impl;

import micro.app.usuario.convert.IUsuarioConvert;
import micro.app.usuario.dto.UsuarioDto;
import micro.app.usuario.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConvertImpl implements IUsuarioConvert {

    @Override
    public UsuarioEntity convertToEntity(UsuarioDto source) {
        final UsuarioEntity target = new UsuarioEntity();
        target.setNombre(source.getNombre());
        target.setApellido1(source.getApellido1());
        target.setApellido2(source.getApellido2());
        target.setEmail(source.getEmail());
        target.setTelefono(source.getTelefono());

        return target;
    }

    @Override
    public UsuarioDto convertToDto(UsuarioEntity source) {
        final UsuarioDto target = new UsuarioDto();
        target.setNombre(source.getNombre());
        target.setApellido1(source.getApellido1());
        target.setApellido2(source.getApellido2());
        target.setEmail(source.getEmail());
        target.setTelefono(source.getTelefono());

        return target;
    }
}
