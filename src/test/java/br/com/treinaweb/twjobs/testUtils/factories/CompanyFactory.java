package br.com.treinaweb.twjobs.testUtils.factories;

import br.com.treinaweb.twjobs.core.models.Company;

public class CompanyFactory {
    

    public static Company createCompanyTreinaWeb() {
        return Company.builder()
                .id(java.util.UUID.fromString("8f3a6d40-3c7b-4e1b-9b52-92f06e1c9a4e"))
                .name("TreinaWeb")
                .website("https://treinaweb.com.br")
                .description("empresa de cursos online")
                .email("contato@treinaweb.com.br")
                .password("senha@123")
                .build();
    }

    public static Company createCompanyAVMaers() {
        return Company.builder()
                .id(java.util.UUID.fromString("8f3a6d40-3c7b-4e1b-9b52-92f06e1c9a4e"))
                .name("AVM")
                .website("https://avm.com.br")
                .description("empresa de transporte e logística")
                .email("contato@avm.com.br")
                .password("senha@123")
                .build();
    }

}
