package HumanResourcesPackage.OperationsImplementation.ImplementCRUD;

import java.util.List;


public interface GenericReadBy<DTO, Key> {
    List<DTO> GetBy(Key value);

}
