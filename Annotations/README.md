# Annotations




在运行时，只有 @Retention(RetentionPolicy.RUNTIME) 类型的注解才能获取到，class source 类型的都会为 null。



使用注解：
1. 注解是针对一个类的，当一个类的每个实例都是同样的值的时候，就可以使用注解来编写，例如给事件分配类型，方便使用 map[key] = instance 这种代码存储；
