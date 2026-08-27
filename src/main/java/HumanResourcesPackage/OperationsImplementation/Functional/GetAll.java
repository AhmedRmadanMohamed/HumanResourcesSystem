package HumanResourcesPackage.OperationsImplementation.Functional;

import java.util.List;

@FunctionalInterface
public interface GetAll <D>  {
  /**
   * Retrieves all available records.
   *
   * @return all records
   */
  List<D> getAll();}
