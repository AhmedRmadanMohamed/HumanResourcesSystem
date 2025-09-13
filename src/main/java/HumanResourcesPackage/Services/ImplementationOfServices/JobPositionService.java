package HumanResourcesPackage.Services.ImplementationOfServices;

import HumanResourcesPackage.DTOs.JobPositionDTO;
import HumanResourcesPackage.OperationsImplementation.Functional.GetAll;
import HumanResourcesPackage.Services.BusinessImplementation.JobPositionImplementationCRUD;
import org.springframework.stereotype.Service;

@Service
public class JobPositionService {

    public JobPositionImplementationCRUD jobPositionImplementationCRUD;

    public JobPositionService(JobPositionImplementationCRUD jobPositionImplementationCRUD) {
        this.jobPositionImplementationCRUD = jobPositionImplementationCRUD;
    }
    public GetAll<JobPositionDTO> GetAll = () -> jobPositionImplementationCRUD.getJobPositions();


}
