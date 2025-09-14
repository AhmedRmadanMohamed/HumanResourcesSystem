package HumanResourcesPackage.Services;

import HumanResourcesPackage.DTOs.SingleDTOs.JobPositionDTO;
import HumanResourcesPackage.Mappers.JobPositionMapper;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericCreate;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericRead;
import HumanResourcesPackage.Repositorys.JobPositionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPositionService implements GenericRead<JobPositionDTO>  , GenericCreate<JobPositionDTO> {
    private final JobPositionRepository jobPositionRepository;
    private final JobPositionMapper jobPositionMapper;

    public JobPositionService(JobPositionRepository jobPositionRepository, JobPositionMapper jobPositionMapper) {
        this.jobPositionRepository = jobPositionRepository;
        this.jobPositionMapper = jobPositionMapper;
    }


    @Override
    public List<JobPositionDTO> GetAll() {
        return jobPositionRepository.findAll().stream().map(jobPositionMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<JobPositionDTO> AddAll(List<JobPositionDTO> jobPositions) {
        return jobPositionRepository.saveAll(jobPositions.stream().map(jobPositionMapper::toEntity)
                .toList()).parallelStream().map(jobPositionMapper::toDTO).collect(Collectors.toList());
    }
}
