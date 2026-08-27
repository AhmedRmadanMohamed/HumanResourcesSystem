package HumanResourcesPackage.OperationsImplementation.ImplementCRUD;

import java.util.List;

public interface GetAll<DTO> {
    /**
     * Retrieves all available records.
     *
     * @return all records
     */
    List<DTO> GetAll();

}
