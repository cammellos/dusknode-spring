package com.dusknode.web.controllers.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;



public class DocumentsTestController {

    private static final String RESPONSE_BODY = "Yummy Noodles,Special Yummy Noodles,Low cal Yummy Noodles";

    MockMvc mockMvc;

    @InjectMocks
    DocumentsController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void indexShouldReturnOkIfNoParams() throws Exception {
        mockMvc.perform(get("/documents")).andExpect(status().isOk());
    }

    @Test
    public void createShouldNotReturnOkIfNoParams() throws Exception {
        mockMvc.perform(post("/documents")).andExpect(status().isBadRequest());
    }

    @Test
    public void createShouldNotReturnOkIfMalformedUrl() throws Exception {
        mockMvc.perform(post("/documents").param("url","malformedUrl")).andExpect(status().isBadRequest());
    }

    @Test
    public void createShouldNotReturnOkIfUrlTooLong() throws Exception {
        mockMvc.perform(post("/documents").param("url","http://www.verylongurllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll.com")).andExpect(status().isBadRequest());
    }

    @Test
    public void createShouldReturnOkIfUrlCorrectlyFormatted() throws Exception {
        mockMvc.perform(post("/documents").param("url","http://www.test.com")).andExpect(status().isOk());
    }

}
