package com.store.SportswearStore;

import com.store.SportswearStore.DTO.SportswearDtoAdmin;
import com.store.SportswearStore.model.SportswearEntityAdmin;
import com.store.SportswearStore.repository.SportswearRepositoryAdmin;
import com.store.SportswearStore.service.AdminCrudService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdminCrudServiceTest {
    @InjectMocks
    private AdminCrudService adminCrudService;
    @Mock
    private SportswearRepositoryAdmin repositoryAdmin;

    @Test
    @DisplayName("test getById Admin")
    public void testGetByIdAdmin() {
        Long adminId = 1L;
        SportswearEntityAdmin entityAdmin = new SportswearEntityAdmin();
        entityAdmin.setId(adminId);
        when(repositoryAdmin.findById((Long) adminId)).thenReturn(Optional.of(entityAdmin));
        SportswearDtoAdmin sportswearDtoAdmin = adminCrudService.getById((Long) adminId);
        assertEquals(adminId, sportswearDtoAdmin.getId());
        verify(repositoryAdmin, times(1)).findById((Long) adminId);
    }
}