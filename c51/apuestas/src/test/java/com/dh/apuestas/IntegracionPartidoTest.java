package com.dh.apuestas;

import com.dh.apuestas.model.Equipo;
import com.dh.apuestas.model.Estado;
import com.dh.apuestas.model.Partido;
import com.dh.apuestas.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionPartidoTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void altaPartido() throws Exception {
        Partido partido = new Partido(1,"0-0", Estado.EN_VIVO,new Equipo(1,"Boca juniors","Argentina"),new Equipo(2,"River","Argentina"));
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/partidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Jsons.asJsonString(partido)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void listarPartidos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/partidos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
