package ru.zakharovre.petclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.zakharovre.petclinic.models.PetType;
import ru.zakharovre.petclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType entity) {
        super.delete(entity);
    }

    @Override
    public PetType save(PetType entity) {
        return super.save(entity);
    }

    @Override
    public PetType findById(Long id) {
        return super.findByID(id);
    }
}
