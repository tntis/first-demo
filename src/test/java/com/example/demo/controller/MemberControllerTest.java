package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Fake-double : Mock, Stub

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;

    @ParameterizedTest
    @ValueSource(strings = {"asd","sfs","werw"})
    void pathVariable(String name) throws Exception{ // Java -> Method Signature => 메소드명, 파라미터, 리턴, throws
        // Given
        //String name = "sfsf";

        // When
        ResultActions resultActions =  mvc.perform(get("/demo/path-variable2" + "/"+ name));
        // Then
        resultActions.andDo(print())
                .andExpect(status().isOk()); // Semantic
    }

    @Test
    void servletRequest() throws Exception{
        // Given
        String url = "/demo/servlet-request";
        String name = "sfsf";
        String email = "123@";
        // When
        // ResultActions resultActions =  mvc.perform(get(url + "?name="+ name + "&email=" + email ));
        ResultActions resultActions =  mvc.perform(get(url).queryParam("name", name).queryParam("email",email));
        // Then
        MvcResult mvcResult =  resultActions.andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String comtentAsString = response.getContentAsString();
        Assertions.assertThat(comtentAsString).isEqualTo("OK2");
    }

    @Test
    void requestParams() throws Exception {
        // Given
        String url = "/demo/request-param";
        String name = "wrwr";
        String email = "wrwr@ee";
        // When
        ResultActions resultActions =  mvc.perform(get(url).queryParam("name", name).queryParam("email",email));
        // Then
        resultActions.andDo(print()).andExpect(status().isOk());

    }


    @Test
    @DisplayName("name 파라미터없이 요청하는 일 경우")
    void requestParams2() throws Exception {
        // Given
        String url = "/demo/request-param";
        String email = "wrwr@ee";
        // When
        ResultActions resultActions =  mvc.perform(get(url).queryParam("email",email));

        // Then
        resultActions.andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("모든 파라미터없이 요청하는 경우")
    void requestParams3() throws Exception {
        // Given
        String url = "/demo/request-param";

        // When
        ResultActions resultActions =  mvc.perform(get(url));

        // Then
        resultActions.andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void modelAttribute() throws Exception {
        // Given
        String url = "/demo/model-attribute";
        String name = "wrwr";
        String email = "wrwr@ee";
        // When
        ResultActions resultActions =  mvc.perform(get(url).queryParam("name", name).queryParam("email",email));
        // Then
        resultActions.andDo(print()).andExpect(status().isOk());
    }


    @Test
    void requestBodyString() throws Exception {
        // Given
        String url = "/demo/request-body/string";
        String content = "동해물과 백두산이 마르고 닳도록";
        // When
        ResultActions resultActions =  mvc.perform(post(url).content(content));
        // Then
        resultActions.andDo(print()).andExpect(status().isOk());
    }

    @Test
    void requestBodyObject() throws Exception {
        // Given
        String url = "/demo/request-body/object";
        String name = "wrwr";
        String email = "wrwr@ee";
        MemberDto memberDto = new MemberDto();
        memberDto.setName(name);
        memberDto.setEmail(email);
        String content = objectMapper.writeValueAsString(memberDto);
        // JSON(XML) -> String : Serialize
        // String -> JSON(XML) : Deserialize


        // When
        ResultActions resultActions =  mvc.perform(post(url).content(content).contentType(MediaType.APPLICATION_JSON));
        // Then
        resultActions.andDo(print()).andExpect(status().isOk());
    }

    @Test
    void requestBodyParameter() throws Exception {
        // Given
        String url = "/demo/request-body/parameter";
        String name = "wrwr";
        String email = "wrwr@ee";
        String content = "name=" + name + "&email="+ email;
        // JSON(XML) -> String : Serialize
        // String -> JSON(XML) : Deserialize


        // When
        ResultActions resultActions =  mvc.perform(post(url).content(content).contentType(MediaType.APPLICATION_FORM_URLENCODED));
        // Then
        resultActions.andDo(print()).andExpect(status().isOk());
    }
}