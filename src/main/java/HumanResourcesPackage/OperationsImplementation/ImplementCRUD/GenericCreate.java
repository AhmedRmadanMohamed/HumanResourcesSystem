package HumanResourcesPackage.OperationsImplementation.ImplementCRUD;

import java.util.List;

public interface GenericCreate<DTO> {
    /**
     * Creates all records provided in the list.
     *
     * @param list the records to create
     * @return the created records
     */
    List<DTO> AddAll(List<DTO> list);
}
