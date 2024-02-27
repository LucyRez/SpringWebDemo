package cs.hse.springWebDemo.features.users.dto

data class UserDto (
    private val username: String,
    private val password: String,
    private val favoritesId: List<String>
)

