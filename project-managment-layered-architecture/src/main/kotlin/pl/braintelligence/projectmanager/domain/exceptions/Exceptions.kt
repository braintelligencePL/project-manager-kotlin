package pl.braintelligence.projectmanager.domain.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
internal class EntityAlreadyExistsException(message: ErrorCode)
    : RuntimeException(message.toString())

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
internal class InvalidTeamException(message: ErrorCode)
    : RuntimeException(message.toString())

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
internal class MissingEntityException(message: ErrorCode)
    : RuntimeException(message.toString())