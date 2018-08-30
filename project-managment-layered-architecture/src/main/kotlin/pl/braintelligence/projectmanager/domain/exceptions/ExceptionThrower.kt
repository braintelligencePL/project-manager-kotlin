package pl.braintelligence.projectmanager.domain.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
internal class EntityAlreadyExistsException(message: String)
    : RuntimeException(message)

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
internal class InvalidTeamException(message: String)
    : RuntimeException(message)
