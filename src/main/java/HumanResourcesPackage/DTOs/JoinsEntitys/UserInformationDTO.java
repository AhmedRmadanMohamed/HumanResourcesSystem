package HumanResourcesPackage.DTOs.JoinsEntitys;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public record UserInformationDTO(String email,
                                 Boolean status,
                                 String password,
                                 Boolean is_activated,
                                 Timestamp created_date,
                                 String role_name) {
}
