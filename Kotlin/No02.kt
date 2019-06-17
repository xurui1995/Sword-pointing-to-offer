/**
 * 设计一个类，我们只能生成该类的一个实例。
 */

object SingletonA

class SingletonB private constructor() {
    companion object {
        @Volatile private var instance: SingletonB? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: SingletonB().also { instance = it }
        }
    }
}