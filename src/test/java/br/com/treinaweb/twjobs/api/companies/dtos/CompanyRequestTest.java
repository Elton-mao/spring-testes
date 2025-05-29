package br.com.treinaweb.twjobs.api.companies.dtos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.treinaweb.twjobs.testUtils.factories.CompanyRequestFactory;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class CompanyRequestTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        var factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @Tags({ @Tag("validate"), @Tag("fast") })
    @DisplayName("Deve validar uma CompanyRequest com sucesso")
    void deveValidarUmaCompanyRequestComSucesso() {

        // Arrange
        var CompanyRequest = CompanyRequestFactory.createTreinaweb();

        // ACT
        var actual = validator.validate(CompanyRequest);

        // assert
        assertTrue(actual.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
        "",                // Menor que o mínimo (2 chars)
        " ",                 // Menor que o mínimo (1 char)
        "ABC",               // Exatamente no mínimo (3 chars)
        "Empresa Teste",     // Valor válido (dentro do range)
        "Empresa Muito Muito Muito Longa", // Maior que o máximo (31 chars)
        "1234567890123456789012345", // Exatamente no máximo (25 chars)
        "12345678901234567890123456" // Maior que o máximo (26 chars)
    })
    @MethodSource("moreThan255Chars")
    @Tags({ @Tag("validate"), @Tag("fast") })
    @DisplayName("Deve validar uma CompanyRequest verificar se o nome atende os requisitos de tamanho maximo e minimo")
    void deveValidarUmaCompanyRequestVerificarTamanhoNome(String nome) {

    }

    static Stream<String> moreThan255Chars(){
        return Stream.of(
            "a".repeat(300) /// Exatamente 300 caracteres
        );
    }



}