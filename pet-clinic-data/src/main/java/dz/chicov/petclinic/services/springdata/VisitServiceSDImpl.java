package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.Visit;
import dz.chicov.petclinic.repositories.VisitRepository;
import dz.chicov.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdata")
public class VisitServiceSDImpl extends AbstractServiceSDImpl<Visit, Long, VisitRepository> implements VisitService {

    public VisitServiceSDImpl(VisitRepository visitRepository) {
        super(visitRepository);
    }

}
