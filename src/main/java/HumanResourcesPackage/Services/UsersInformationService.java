package HumanResourcesPackage.Services;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericRead;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericReadBy;
import HumanResourcesPackage.Repositorys.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
public class UsersInformationService implements GenericRead<UserInformationDTO>, GenericReadBy<UserInformationDTO , String> {
    private final UsersRepository usersRepository;

    UsersInformationService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UserInformationDTO> GetAll() {
        return usersRepository.GetAllUsersInfo().parallelStream().toList();
    }

    @Override
    public CopyOnWriteArrayList<UserInformationDTO> GetBy(String RoleName) {
        return new CopyOnWriteArrayList<>(usersRepository.GetAllUsersInfoByRole(RoleName));

    }
}
