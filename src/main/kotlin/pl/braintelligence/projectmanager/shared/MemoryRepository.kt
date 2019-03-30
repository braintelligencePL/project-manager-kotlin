package pl.braintelligence.projectmanager.shared

import kotlin.reflect.KClass

abstract class MemoryRepository<Entity : Identifiable<Id>, Id> : Repository<Entity, Id> {
    protected val entities = HashMap<Id, Entity>()

    override fun save(entity: Entity) {
        // fancy way to do precondition check
        val id = entity.id ?: throw InvalidEntityIdException(entity::class)
        // setting map using [] operator
        entities[id] = entity
    }

    // getting from map through get operator
    override fun findById(id: Id): Entity? = entities[id]

    override fun findAll(): List<Entity> = entities.values.toList()

    // in operator for checking if map contains key
    override fun contains(id: Id): Boolean = id in entities
}

class InvalidEntityIdException(entityClass: KClass<*>) : RuntimeException("Entity of type ${entityClass.simpleName} has no id.")

interface Identifiable<out T> {
    val id: T?
}

interface Repository<Entity : Identifiable<Id>, Id> {
    fun save(entity: Entity)
    fun findById(id: Id): Entity?
    fun findAll(): List<Entity>
    operator fun contains(id: Id): Boolean
}
