package micro.app.pedido.service.impl;

import micro.app.pedido.convert.IPedidoConvert;
import micro.app.pedido.dto.Solicitud;
import micro.app.pedido.entity.PedidoEntity;
import micro.app.pedido.exceptions.ApiResponseException;
import micro.app.pedido.repository.IPedidoRepository;
import micro.app.pedido.utils.EstadoConstantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PedidoServiceImplTest {

    @Mock
    IPedidoRepository repoMock;

    @Mock
    IPedidoConvert convertMock;

    @InjectMocks
    PedidoServiceImpl serviceMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testModificarNoExistePedido(){
        // Datos para el test
        Long idPedido = 1L;
        Solicitud solicitud = null;
        // Mock simulacion
        when(repoMock.findById(anyLong())).thenReturn(Optional.empty());
        // Prueba y verificacion de la excepcion
        assertThrows(ApiResponseException.class, () -> {
            serviceMock.modificaPedido(idPedido, solicitud);
        });
    }

    @Test
    void testModificarPedidoFinalizado(){
        // Datos para el test
        final PedidoEntity pedido = new PedidoEntity();
        pedido.setId(1L);
        pedido.setEstado(EstadoConstantes.FINALIZADO);
        Solicitud solicitud = null;
        // Mock simulacion
        when(repoMock.findById(anyLong())).thenReturn(Optional.of(pedido));
        // Prueba y verificación de la excepción
        final ApiResponseException exception = assertThrows(ApiResponseException.class, () -> {
            serviceMock.modificaPedido(pedido.getId(), solicitud);
        });
        // Verificacion resultados
        assertEquals("El pedido a modificar ya se encuentra FINALIZADO", exception.getMessage());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getHttpStatus());
    }


}
