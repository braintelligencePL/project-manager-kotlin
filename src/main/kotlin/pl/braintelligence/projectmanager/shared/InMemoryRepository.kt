package pl.braintelligence.projectmanager.shared

import java.util.concurrent.ConcurrentHashMap

abstract class InMemoryCrudRepository<ENTITY, ID> : CustomRepository<ENTITY, ID> {

    private val dataStore = ConcurrentHashMap<ID, ENTITY>()

    override fun save(entity: ENTITY, id: ID) {
        dataStore[id] = entity
    }

    override fun contains(id: ID): Boolean = dataStore.containsKey(id)

    override fun findById(id: ID): ENTITY? = dataStore[id]

    override fun findAll(): List<ENTITY> = dataStore.values.toList()

}

interface CustomRepository<ENTITY, ID> {
    fun save(entity: ENTITY, id: ID)
    fun contains(id: ID): Boolean
    fun findById(id: ID): ENTITY?
    fun findAll(): List<ENTITY>
}
