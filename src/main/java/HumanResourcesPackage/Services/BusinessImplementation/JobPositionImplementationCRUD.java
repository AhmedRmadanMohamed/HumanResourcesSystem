package HumanResourcesPackage.Services.BusinessImplementation;

import HumanResourcesPackage.DTOs.JobPositionDTO;
import HumanResourcesPackage.Mappers.JobPositionMapper;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericCRUD;
import HumanResourcesPackage.Repositorys.JobPositionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobPositionImplementationCRUD implements GenericCRUD<JobPositionDTO> {
    private final JobPositionRepository jobPositionRepository;
    private final JobPositionMapper jobPositionMapper;

    public JobPositionImplementationCRUD(JobPositionRepository jobPositionRepository, JobPositionMapper jobPositionMapper) {
        this.jobPositionRepository = jobPositionRepository;
        this.jobPositionMapper = jobPositionMapper;
    }


    @Override
    public List<JobPositionDTO> getJobPositions() {
        return jobPositionRepository.findAll().stream().map(jobPositionMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<JobPositionDTO> AddNewPosition(List<JobPositionDTO> jobPositions) {
        return jobPositionRepository.saveAll(jobPositions.stream().map(jobPositionMapper::toEntity)
                .toList()).parallelStream().map(jobPositionMapper::toDTO).collect(Collectors.toList());
    }
}
