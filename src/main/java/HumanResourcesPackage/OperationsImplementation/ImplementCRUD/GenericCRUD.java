package HumanResourcesPackage.OperationsImplementation.ImplementCRUD;

import java.util.List;

public interface GenericCRUD<D> {
    List<D> getJobPositions();
    List<D> AddNewPosition(List<D> list);
}
