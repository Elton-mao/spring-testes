package br.com.treinaweb.twjobs.api.companies.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import br.com.treinaweb.twjobs.core.models.Company;
import br.com.treinaweb.twjobs.testUtils.factories.CompanyFactory;
import br.com.treinaweb.twjobs.testUtils.factories.CompanyResponseFactory;

public class CompanyMapperLocalTest {
    private CompanyMapperLocal companyMapper; 

    @BeforeEach
    public void setUp() {
        companyMapper = new CompanyMapperLocal();
    }

    @Test
    @Tags({@Tag("mapper"), @Tag("fast")})
    @DisplayName("to response() should converto Company to CompanyResponse")
    public void testToResponseWithValidCompanyRequest() {
        // Arrange
        Company company = CompanyFactory.createCompanyTreinaWeb();
        var expeted = CompanyResponseFactory.createCompanyTreinaWeb(); 
          // ACT
          var actual = companyMapper.toResponse(company);

        // Assert
        assertNotNull(actual);
        assertEquals(expeted.getId(), actual.getId());
        assertEquals(expeted.getName(), actual.getName());
        assertEquals(expeted.getWebsite(), actual.getWebsite());
        assertEquals(expeted.getDescription(), actual.getDescription());
        assertEquals(expeted.getEmail(), actual.getEmail());
    }

     @Test
    @Tags({@Tag("mapper"), @Tag("fast")})
    @DisplayName("to response() should converto Company to CompanyResponse throw error when company is null")
    public void testToResponseWithValidCompanyThrowError() {
               // Arrange //act 
               assertThrows(IllegalArgumentException.class, () -> {
                   companyMapper.toResponse(null);
               });
    }
}
