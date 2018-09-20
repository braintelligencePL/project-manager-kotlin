package pl.braintelligence.projectmanager

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.repository.CrudRepository
import org.springframework.scheduling.annotation.EnableAsync
import java.io.Serializable
import java.util.Objects.requireNonNull
import java.util.Optional
import java.util.concurrent.ConcurrentHashMap
import java.util.function.Consumer

@Configuration
@EnableAutoConfiguration
@ComponentScan
class Application {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}
