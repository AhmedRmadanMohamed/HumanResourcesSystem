package HumanResourcesPackage.Services;

import HumanResourcesPackage.DTOs.SingleDTOs.EmployersDTO;

import HumanResourcesPackage.Mappers.EmployersMapper;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import HumanResourcesPackage.Repositorys.EmployersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Provides access to employer data.
 */
@Service
@RequiredArgsConstructor
public class EmployersService implements GetAll<EmployersDTO> {
    
    private final EmployersRepository employersRepository;
    private final EmployersMapper employersMapper;

    /**
     * Retrieves all employers.
     *
     * @return all employers as DTOs
     */
    @Override
    public List<EmployersDTO> GetAll() {
        return employersRepository.findAll().stream().map(employersMapper::mapEmployersDTO).toList();
    }


}
