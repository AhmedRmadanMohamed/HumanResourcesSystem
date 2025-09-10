package HumanResourcesPackage.Implementation;

import HumanResourcesPackage.DTOs.JobPositionDTO;
import java.util.List;
public interface JobPositionCRUD {
    List<JobPositionDTO> getJobPositions();
}
