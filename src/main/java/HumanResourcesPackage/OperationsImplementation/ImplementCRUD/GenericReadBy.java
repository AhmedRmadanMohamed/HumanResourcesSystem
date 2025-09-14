package HumanResourcesPackage.OperationsImplementation.ImplementCRUD;

import java.util.concurrent.CopyOnWriteArrayList;


public interface GenericReadBy<DTO, Kay> {
    CopyOnWriteArrayList<DTO> GetBy(Kay Value);

}
