/*
package traintickets.mappers;

import org.mapstruct.*;
import traintickets.dto.SignUpDto;
import traintickets.dto.UserDto;
import traintickets.model.User;

@Mapper(componentModel = "spring",  unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    UserDto toUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    String test(String test);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User signUpTOUser(SignUpDto signUpDto);
}
*/
