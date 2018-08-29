package pl.braintelligence.projectmanager.domain.exceptions



abstract class DomainException (message: String, val code: ErrorCode)
    : RuntimeException(message)

enum class ErrorCode {
    UNEXPECTED_ERROR,
    EMPTY_TEAM_NAME,
    TEAM_ALREADY_EXISTS,
    NONEXISTENT_TEAM,
    EMPTY_MEMBER,
    EMPTY_MEMBER_FIRST_NAME,
    EMPTY_MEMBER_LAST_NAME,
    EMPTY_MEMBER_JOB_POSITION,
    INVALID_MEMBER_JOB_POSITION
}
