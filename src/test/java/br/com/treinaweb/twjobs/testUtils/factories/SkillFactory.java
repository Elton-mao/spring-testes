package br.com.treinaweb.twjobs.testUtils.factories;

import java.util.List;

import br.com.treinaweb.twjobs.core.models.Skill;

public class SkillFactory {
    public static Skill createJava(){
        return new Skill(1L, "Java");
    }
    
    public static Skill createJavaScript(){
        return new Skill(2L, "JavaScript");
    }

    public static List<Skill> createSkills() {
        return List.of(createJava(), createJavaScript());
    }
}
