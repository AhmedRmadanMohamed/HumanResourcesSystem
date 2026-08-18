package HumanResourcesPackage.Services;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericReadBy;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import HumanResourcesPackage.Repositorys.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersInformationService implements GetAll<UserInformationDTO>,
        GenericReadBy<UserInformationDTO, String> {
    private final UsersRepository usersRepository;

    public UsersInformationService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UserInformationDTO> GetAll() {
        return usersRepository.GetAllUsersInfo();
    }

    @Override
    public List<UserInformationDTO> GetBy(String roleName) {
        return usersRepository.GetAllUsersInfoByRole(roleName);
    }

}
