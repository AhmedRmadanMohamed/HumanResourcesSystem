package HumanResourcesPackage.OperationsImplementation.ImplementCRUD;

import java.util.List;


public interface GenericReadBy<DTO, Key> {
    /**
     * Retrieves records that match the specified value.
     *
     * @param value the value used to find records
     * @return the matching records
     */
    List<DTO> GetBy(Key value);

}
