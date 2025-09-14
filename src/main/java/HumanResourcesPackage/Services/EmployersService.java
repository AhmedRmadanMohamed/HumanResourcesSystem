package HumanResourcesPackage.Services;

import HumanResourcesPackage.DTOs.SingleDTOs.EmployersDTO;

import HumanResourcesPackage.Mappers.EmployersMapper;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import HumanResourcesPackage.Repositorys.EmployersRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployersService implements GetAll<EmployersDTO> {
    
    private final EmployersRepository employersRepository;
    private final EmployersMapper employersMapper;


    public EmployersService(EmployersRepository employersRepository, EmployersMapper employersMapper) {
        this.employersRepository = employersRepository;


        this.employersMapper = employersMapper;
    }

    @Override
    public List<EmployersDTO> GetAll() {
        return employersRepository.findAll().stream().map(employersMapper::mapEmployersDTO).toList();
    }


}
