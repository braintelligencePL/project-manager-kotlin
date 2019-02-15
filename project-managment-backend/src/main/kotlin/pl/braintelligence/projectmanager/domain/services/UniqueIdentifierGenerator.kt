package pl.braintelligence.projectmanager.domain.services

interface UniqueIdentifierGenerator {
    fun generateUniqueIdentifier(): String
}