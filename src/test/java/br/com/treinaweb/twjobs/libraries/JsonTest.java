package br.com.treinaweb.twjobs.libraries;

import org.junit.jupiter.api.Test;

public class JsonTest {
    @Test
    void testSomeJsonFunctionality() { 
        var actualJson = simulaAPICALL();
        var expectedJson = """
            [
                {
                    "id": 1,
                    "name": "Alice"
                },
                {
                    "id": 2,
                    "name": "Bob"
                }
            ]
            """;
       
    }

    private String simulaAPICALL() {
        // Simula uma chamada de API que retorna um JSON
        return """
            [
        {
            "id": 1,
            "name": "Alice "
        },
        {
            "id": 2,
            "name": "Bob "
        }
        ]       
                """;
    }
}