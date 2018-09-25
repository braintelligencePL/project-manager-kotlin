package pl.braintelligence.projectmanager.infrastructure.services

import org.springframework.stereotype.Service
import pl.braintelligence.projectmanager.domain.services.UniqueIdentifierGenerator
import java.util.UUID.randomUUID

@Service
internal class UuidIdentifierGenerator : UniqueIdentifierGenerator {

    override fun generateUniqueIdentifier(): String {
        return randomUUID().toString()
    }
}
