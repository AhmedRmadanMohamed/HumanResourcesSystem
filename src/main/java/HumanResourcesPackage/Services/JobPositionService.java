package HumanResourcesPackage.Services;

import HumanResourcesPackage.DTOs.SingleDTOs.JobPositionDTO;
import HumanResourcesPackage.Mappers.JobPositionMapper;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericCreate;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import HumanResourcesPackage.Repositorys.JobPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Manages job position data.
 */
@Service
@RequiredArgsConstructor
public class JobPositionService implements GetAll<JobPositionDTO>, GenericCreate<JobPositionDTO> {
    private final JobPositionRepository jobPositionRepository;
    private final JobPositionMapper jobPositionMapper;

    /**
     * Retrieves all job positions.
     *
     * @return all job positions as DTOs
     */
    @Override
    public List<JobPositionDTO> GetAll() {
        return jobPositionRepository.findAll().stream()
                .map(jobPositionMapper::toDTO)
                .toList();
    }

    /**
     * Creates multiple job positions in a single transaction.
     *
     * @param jobPositions job positions to create
     * @return the saved job positions
     */
    @Transactional
    @Override
    public List<JobPositionDTO> AddAll(List<JobPositionDTO> jobPositions) {
        return jobPositionRepository.saveAll(jobPositions.stream()
                        .map(jobPositionMapper::toEntity)
                        .toList()).stream()
                .map(jobPositionMapper::toDTO)
                .toList();
    }
}
