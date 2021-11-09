package ru.zakharovre.petclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.zakharovre.petclinic.models.Speciality;
import ru.zakharovre.petclinic.services.SpecialityService;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality entity) {
        super.delete(entity);
    }

    @Override
    public Speciality save(Speciality entity) {
        return super.save(entity);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findByID(id);
    }
}
