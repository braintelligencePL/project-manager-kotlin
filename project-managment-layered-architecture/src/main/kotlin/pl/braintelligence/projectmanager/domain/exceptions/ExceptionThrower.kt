package pl.braintelligence.projectmanager.domain.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Team already exists.")
internal class TeamAlreadyExistException
    : RuntimeException()

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
internal class EntityAlreadyExistsException(message: String)
    : RuntimeException(message)

