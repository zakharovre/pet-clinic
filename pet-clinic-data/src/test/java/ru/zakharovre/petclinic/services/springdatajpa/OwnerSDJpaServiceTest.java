package ru.zakharovre.petclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.zakharovre.petclinic.models.Owner;
import ru.zakharovre.petclinic.repositories.OwnerRepository;

@ExtendWith({MockitoExtension.class})
class OwnerSDJpaServiceTest {

    private final String LAST_NAME = "Test";
    private Owner ownerFromMock;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        ownerFromMock = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwners = new HashSet<>();
        returnedOwners.add(ownerFromMock);
        returnedOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnedOwners);
        assertEquals(2, service.findAll().size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(ownerFromMock));
        assertEquals(1L, service.findById(1L).getId());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(ownerFromMock);
        Owner owner = service.findByLastName(LAST_NAME);
        assertEquals(ownerFromMock.getId(), owner.getId());
        verify(ownerRepository).findByLastName(any());
    }
}
