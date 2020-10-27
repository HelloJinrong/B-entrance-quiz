package com.thoughtworks.capability.gtb.entrancequiz.api;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_get_students_() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(status().isOk());
    }
}
