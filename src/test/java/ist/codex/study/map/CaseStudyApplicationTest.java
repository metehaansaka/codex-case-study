package ist.codex.study.map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CaseStudyApplicationTest {

    @InjectMocks
    private CaseStudyApplication caseStudyApplication;

    @Test
    public void testModelMapperBeanCreation() {
        ModelMapper result = caseStudyApplication.getModelMapper();
        assertNotNull(result);
    }
}