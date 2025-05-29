package br.com.treinaweb.twjobs.testUtils.factories;

import java.util.List;

import br.com.treinaweb.twjobs.api.skills.dtos.SkillResponse;

public class SkillResponseFactory {
    public static SkillResponse createJavaResponse() {
        return new SkillResponse(1L, "Java");
    }

    public static SkillResponse createJavaScriptResponse() {
        return new SkillResponse(2L, "JavaScript");
    }
    public static List<SkillResponse> createSkillsResponses() {
        return List.of(createJavaResponse(), createJavaScriptResponse());
    }
}
