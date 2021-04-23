package br.edu.ifma.travis.controller;

import br.edu.ifma.travis.mapper.VeiculoMapper;
import br.edu.ifma.travis.model.Veiculo;
import br.edu.ifma.travis.service.VeiculoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VeiculoControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private VeiculoService veiculoService;
    private VeiculoMapper veiculoMapper;

    @BeforeEach
    void setUp() {
        veiculoMapper = mock(VeiculoMapper.class);
        veiculoService = new VeiculoService(veiculoMapper);
        
        mockMvc = MockMvcBuilders
                .standaloneSetup(new VeiculoController(veiculoService))
                .build();
        
        objectMapper = new ObjectMapper();
    }

    @Test
    void deveCadastrarVeiculoComSucesso() throws Exception {
        doNothing().when(veiculoMapper).insert(any(Veiculo.class), anyInt());
        Veiculo veiculo = new Veiculo();
        veiculo.setId(1);

        mockMvc.perform(post("/usuarios/1/veiculos")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(veiculo)))
                .andExpect(status().is2xxSuccessful());

        verify(veiculoMapper, times(1)).insert(any(Veiculo.class), anyInt());
    }

    @Test
    void deveCadastrarVeiculoDuplicadoComErro() throws Exception {
        doThrow(new RuntimeException("Veículo duplicado")).when(veiculoMapper).insert(any(Veiculo.class), anyInt());
        Veiculo veiculo = new Veiculo();
        veiculo.setId(1);

        mockMvc.perform(post("/usuarios/1/veiculos")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(veiculo)))
                .andExpect(status().is5xxServerError());

        verify(veiculoMapper, times(1)).insert(any(Veiculo.class), anyInt());
    }

    @Test
    void deveConsultarVeiculoPorPlaca() throws Exception {
        when(veiculoMapper.findBySelo(anyInt())).thenReturn(new Veiculo());
        mockMvc.perform(get("/usuarios/1/veiculos/placa/ppp0000"))
                .andExpect(status().isOk());
        verify(veiculoMapper, times(1)).findByPlaca(anyString());
        verify(veiculoMapper, times(0)).findBySelo(anyInt());
        verify(veiculoMapper, times(0)).findAllByUsuario(anyInt());
    }

    @Test
    void deveConsultarVeiculoPorSelo() throws Exception {
        when(veiculoMapper.findBySelo(anyInt())).thenReturn(new Veiculo());
        mockMvc.perform(get("/usuarios/1/veiculos/selo/1"))
                .andExpect(status().isOk());
        verify(veiculoMapper, times(1)).findBySelo(anyInt());
        verify(veiculoMapper, times(0)).findByPlaca(anyString());
        verify(veiculoMapper, times(0)).findAllByUsuario(anyInt());
    }

    @Test
    void deveExcluirVeiculoComSucesso() throws Exception {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(1);
        doNothing().when(veiculoMapper).delete(anyInt());
        when(veiculoMapper.findByUsuarioAndId(anyInt(), anyInt()))
                .thenReturn(veiculo);
        mockMvc.perform(delete("/usuarios/1/veiculos/1"))
                .andExpect(status().is2xxSuccessful());

        verify(veiculoMapper, times(1)).delete(anyInt());
        verify(veiculoMapper, times(0)).findAllByUsuario(anyInt());
    }
}