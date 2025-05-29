package br.com.treinaweb.twjobs.api.skills.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import br.com.treinaweb.twjobs.api.skills.mappers.SkillMapper;
import br.com.treinaweb.twjobs.core.exceptions.skill.SkillNotFoundException;
import br.com.treinaweb.twjobs.core.repositories.SkillRepository;
import br.com.treinaweb.twjobs.testUtils.factories.SkillFactory;
import br.com.treinaweb.twjobs.testUtils.factories.SkillResponseFactory;


@ExtendWith(MockitoExtension.class)
public class SkillServiceTest {
    @Mock
    private SkillMapper skillMapper;

    @Mock
    private SkillRepository skillRepository;

    @InjectMocks
    private SkillService skillService;

    @Test
    @Tags({@Tag("service"),@Tag("fast")})
    @DisplayName("findById" + " should return a skill when it exists")
    void findById_ShouldReturnSkill_WhenExists() {
        //Arrange 
        var skill = SkillFactory.createJava(); 
        var expected = SkillResponseFactory.createJavaResponse();
        when(skillRepository.findById(1L)).thenReturn(Optional.of(skill));
        when(skillMapper.toResponse(skill)).thenReturn(expected);
        var actual = skillService.findById(1L); 
        //act
        assertNotNull(actual);
        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getName(), actual.getName());

    }

    @Test
    @Tags({@Tag("service"),@Tag("fast")})
    @DisplayName("findById" + " should return a skill when it exists and not found")
    void findById_ShouldReturnSkill_NotFound() {
        //Arrange 
        when(skillRepository.findById(1L)).thenReturn(Optional.empty());
        //act
        assertThrows(SkillNotFoundException.class, () -> skillService.findById(1L));

    }

    @Test
    @Tags({@Tag("service"),@Tag("fast")})
    @DisplayName("findAll" + " should return a list of skills")
    void findAll_ShouldReturnSkillResponse() {
        //Arrange 
        var skills = SkillFactory.createSkills(); 
        var expected = SkillResponseFactory.createSkillsResponses();
        var sort = org.springframework.data.domain.Sort.by(Sort.Direction.ASC, "name");
        when(skillRepository.findAll(sort)).thenReturn(skills);
        // Mock the mapping for each skill to its response
        for (int i = 0; i < skills.size(); i++) {
            when(skillMapper.toResponse(skills.get(i))).thenReturn(expected.get(i));
        }

        //act
        var actual = skillService.findAll(sort);
        //assert
        assertNotNull(actual);
        assertEquals(2, actual.size()); 
        assertEquals(expected.get(0).getId(), actual.get(0).getId());
        assertEquals(expected.get(0).getName(), actual.get(0).getName());
    }


}
