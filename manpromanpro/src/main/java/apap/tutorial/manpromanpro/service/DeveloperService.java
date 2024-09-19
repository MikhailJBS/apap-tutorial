package apap.tutorial.manpromanpro.service;
import apap.tutorial.manpromanpro.model.Developer;
import java.util.List;

public interface DeveloperService {
    Developer addDeveloper(Developer developer);
    Developer getDeveloperById(Long idDeveloper);
    List<Developer> getAllDeveloper();
    Developer updateDeveloper(Developer developer);
}
