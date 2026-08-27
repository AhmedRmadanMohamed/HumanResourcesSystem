package HumanResourcesPackage.Services;

import HumanResourcesPackage.DTOs.JoinsEntitys.UserInformationDTO;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GenericReadBy;
import HumanResourcesPackage.OperationsImplementation.ImplementCRUD.GetAll;
import HumanResourcesPackage.Repositorys.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Provides read-only access to user information.
 */
@Service
@RequiredArgsConstructor
public class UsersInformationService implements GetAll<UserInformationDTO>,
        GenericReadBy<UserInformationDTO, String> {
    private final UsersRepository usersRepository;


    /**
     * Retrieves information for all users.
     *
     * @return all available user information
     */
    @Override
    public List<UserInformationDTO> GetAll() {
        return usersRepository.GetAllUsersInfo();
    }

    /**
     * Retrieves user information filtered by role name.
     *
     * @param roleName role used to filter users
     * @return user information matching the specified role
     */
    @Override
    public List<UserInformationDTO> GetBy(String roleName) {
        return usersRepository.GetAllUsersInfoByRole(roleName);
    }

}
