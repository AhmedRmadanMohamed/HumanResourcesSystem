package HumanResourcesPackage.OperationsImplementation.ImplementCRUD;

import java.util.List;

public interface GenericCreate<DTO> {
    List<DTO> AddAll(List<DTO> list);
}
