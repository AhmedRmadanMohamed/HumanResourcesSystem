package HumanResourcesPackage.Services;

import HumanResourcesPackage.DTOs.JobPositionDTO;
import HumanResourcesPackage.Implementation.JobPositionCRUD;
import HumanResourcesPackage.Mappers.JobPositionMapper;
import HumanResourcesPackage.Repositorys.JobPositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionService implements JobPositionCRUD {
    private final JobPositionRepository jobPositionRepository;

    public JobPositionService(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    @Override
    public List<JobPositionDTO> getJobPositions() {
        return jobPositionRepository.findAll().stream().map(JobPositionMapper::toDTO).toList();
    }


}
