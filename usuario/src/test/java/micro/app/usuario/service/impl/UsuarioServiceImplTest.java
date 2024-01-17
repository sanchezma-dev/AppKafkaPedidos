package micro.app.usuario.service.impl;

import micro.app.usuario.convert.IUsuarioConvert;
import micro.app.usuario.dto.UsuarioDto;
import micro.app.usuario.entity.UsuarioEntity;
import micro.app.usuario.exceptions.ApiResponseException;
import micro.app.usuario.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)//Inicializa automaticamente los @Mock y @InjectMocks
public class UsuarioServiceImplTest {

    @Mock
    UsuarioRepository repoMock;

    @Mock
    private IUsuarioConvert convert;

    @InjectMocks
    UsuarioServiceImpl usuMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

   @Test
    void testAltaOK(){
        // Datos para el test
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setEmail("test@email.com");
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setEmail(usuarioDto.getEmail());
        // Mock simulacio
        when(repoMock.existsByEmail(usuarioDto.getEmail())).thenReturn(false);
        when(convert.convertToEntity(usuarioDto)).thenReturn(usuarioEntity);
        when(convert.convertToDto(any(UsuarioEntity.class))).thenReturn(usuarioDto);
        // Mock de simulación del guardado
        when(repoMock.save(any())).thenReturn(new UsuarioEntity());
        // Ejecución del método de la prueba
        UsuarioDto result = usuMock.saveUsuario(usuarioDto);
        // Verificar el resultado
        assertEquals(usuarioDto, result);
        // Verifica que el método se ha llamado una sola vez
        verify(repoMock, times(1)).save(usuarioEntity);
    }

    @Test
    void testAltaError(){
        // Datos para el test
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setEmail("test@email.com");
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setEmail(usuarioDto.getEmail());
        // Mock repo simulado
        when(repoMock.existsByEmail(usuarioDto.getEmail())).thenReturn(true);
        // Ejecución de la prueba con salida de excepción
        assertThrows(ApiResponseException.class, () -> usuMock.saveUsuario(usuarioDto));
        // Verifica que el método se ha llamado una sola vez
        verify(repoMock, times(1)).existsByEmail(usuarioDto.getEmail());
    }

}
