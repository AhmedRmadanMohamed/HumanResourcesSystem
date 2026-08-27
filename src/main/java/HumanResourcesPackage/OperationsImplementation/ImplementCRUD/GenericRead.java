package HumanResourcesPackage.OperationsImplementation.ImplementCRUD;

import java.util.List;

public interface GenericRead<DTO> {
    /**
     * Retrieves all available records.
     *
     * @return all records
     */
    List<DTO> GetAll();

}
