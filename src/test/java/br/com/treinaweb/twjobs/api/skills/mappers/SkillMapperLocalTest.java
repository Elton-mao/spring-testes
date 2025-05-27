package br.com.treinaweb.twjobs.api.skills.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import br.com.treinaweb.twjobs.api.skills.dtos.SkillResponse;
import br.com.treinaweb.twjobs.core.models.Skill;
import br.com.treinaweb.twjobs.testUtils.factories.SkillResponseFactory;
import br.com.treinaweb.twjobs.testUtils.factories.SkillFactory;

public class SkillMapperLocalTest {
    private SkillMapperLocal skillMapper;

    @BeforeEach
    void setUp() {
        skillMapper = new SkillMapperLocal();
    }

    // Testes unitários para o SkillMapper
    @Test
    @Tags({@Tag("mapper"), @Tag("fast")})
    @DisplayName("Deve mapear uma Skill para SkillResponse corretamente")
    public void deveMapearUmaSkillParaSkillResponseCorretamente() {
        //Arrange
        var skill = SkillFactory.createJava(); 
        var esperado = SkillResponseFactory.createJavaResponse();;
        //ACT 
        var actual = skillMapper.toResponse(skill);

        //ASSERT
        assertNotNull(actual);
        assertEquals(esperado.getId(),actual.getId());
        assertNotNull(esperado.getName(),actual.getName());
    }

    @Test
    @Tags({@Tag("mapper"), @Tag("fast")})
    @DisplayName("Deve mapear uma Skill para SkillResponse corretamente")
    public void deveTratarErroCasoNull() {
    

        //ACT // ASSERT
        var exception = assertThrows(IllegalArgumentException.class, () -> skillMapper.toResponse(null));
        assertEquals("skill cannot be null", exception.getMessage());
    }

}
