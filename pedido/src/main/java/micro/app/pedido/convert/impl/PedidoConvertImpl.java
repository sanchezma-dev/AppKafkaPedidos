package micro.app.pedido.convert.impl;

import micro.app.pedido.convert.IPedidoConvert;
import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.entity.PedidoEntity;
import org.springframework.stereotype.Component;

@Component
public class PedidoConvertImpl implements IPedidoConvert {

    @Override
    public PedidoEntity convertToEntity(PedidoDto source) {
        final PedidoEntity target = new PedidoEntity();
        target.setId(source.getId());
        target.setIdUsuario(source.getIdUsuario());
        target.setFecha(source.getFecha());
        target.setEstado(source.getEstado());
        target.
        return null;
    }

    @Override
    public PedidoDto convertToDto(PedidoDto source) {
        return null;
    }
}
