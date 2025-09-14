package HumanResourcesPackage.OperationsImplementation.Functional;

import java.util.List;

@FunctionalInterface
public interface GetAll<D> {
    List<D> getAll();
}
