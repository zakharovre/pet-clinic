package ru.zakharovre.petclinic.services.map;

import java.util.Set;
import ru.zakharovre.petclinic.models.Visit;
import ru.zakharovre.petclinic.services.VisitService;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit entity) {
        super.delete(entity);
    }

    @Override
    public Visit save(Visit entity) {
        if(entity.getPet() == null || entity.getPet().getOwner() == null || entity.getPet().getId() == null
        || entity.getPet().getOwner().getId() == null) {
            throw  new RuntimeException("Invalid Visit");
        }
        return super.save(entity);
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findByID(aLong);
    }
}
