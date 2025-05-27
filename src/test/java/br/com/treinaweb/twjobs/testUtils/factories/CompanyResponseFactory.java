package br.com.treinaweb.twjobs.testUtils.factories;

import br.com.treinaweb.twjobs.api.companies.dtos.CompanyResponse;

public class CompanyResponseFactory {
      public static CompanyResponse createCompanyTreinaWeb() {
        return CompanyResponse.builder()
                .id(java.util.UUID.fromString("8f3a6d40-3c7b-4e1b-9b52-92f06e1c9a4e"))
                .name("TreinaWeb")
                .website("https://treinaweb.com.br")
                .description("empresa de cursos online")
                .email("contato@treinaweb.com.br")
                .build();
    }

    public static CompanyResponse createCompanyAVMaers() {
        return CompanyResponse.builder()
                .id(java.util.UUID.fromString("8f3a6d40-3c7b-4e1b-9b52-92f06e1c9a4e"))
                .name("AVM")
                .website("https://avm.com.br")
                .description("empresa de transporte e logística")
                .email("contato@avm.com.br")
                .build();
    }
}
