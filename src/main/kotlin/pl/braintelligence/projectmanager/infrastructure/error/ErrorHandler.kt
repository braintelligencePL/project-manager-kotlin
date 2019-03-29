package pl.braintelligence.projectmanager.infrastructure.error

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import pl.braintelligence.projectmanager.core.team.exception.EntityAlreadyExistsException
import pl.braintelligence.projectmanager.shared.DomainException
import java.lang.invoke.MethodHandles
import java.time.Instant
import javax.servlet.http.HttpServletRequest


@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(EntityAlreadyExistsException::class)
    fun handleEntityAlreadyExistsException(exception: DomainException, request: HttpServletRequest)
            : ResponseEntity<ErrorMessage> {
        return mapToResponse(exception, request, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    private fun mapToResponse(ex: DomainException, request: HttpServletRequest, httpStatus: HttpStatus): ResponseEntity<ErrorMessage> {
        val errorMessage = ex.message?.let { ErrorMessage(it, Instant.now()) }
        log.error(createLog(request, httpStatus, ex.message))
        return status(httpStatus)
                .body(errorMessage)
    }

    private fun createLog(request: HttpServletRequest, status: HttpStatus, message: String?): String {
        return "${request.method} on \"${request.requestURI}\" with status \"${status.value()}\" and message = \"$message\" "
    }

    companion object {
        private val log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }
}

data class ErrorMessage(val message: String, val timestamp: Instant)
