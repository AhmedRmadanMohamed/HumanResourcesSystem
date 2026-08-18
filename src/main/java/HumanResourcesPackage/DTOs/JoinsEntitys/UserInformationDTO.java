package HumanResourcesPackage.DTOs.JoinsEntitys;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserInformationDTO(String email,
                                 Boolean status,
                                 Boolean is_activated,
                                 LocalDateTime created_date,
                                 String role_name) {
}
