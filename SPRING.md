# SpringIOC

Spring提供了很多轻量级应用开发实践的工具集合，这些工具集以接口、抽象类、或工具类的形式存在于Spring中。通过使用这些工具集，可以实现应用程序与各种开源技术及框架间的友好整合。比如有关jdbc封装的数据访问工具Spring JDBC，有关编写单元测试的spring test包以及spring-mock，有关访问动态脚本语言的Spring Script，另外还有发送邮件的工具Spring Mail、日程及任务处理工具Spring scheduling等。 可以这么说，大多数企业级应用开发中经常涉及到的一些通用的问题，都可以通过Spring提供的一些实用工具包轻松解决

### 依赖注入
依赖注入的三种方式：
 * 接口注入
 * Construct注入 
 * Setter注入 
 > Ioc—Inversion of Control，即“控制反转”，不是什么技术，而是一种设计思想。在Java开发中，Ioc意味着将你设计好的对象交给容器控制，而不是传统的在你的对象内部直接控制。如何理解好Ioc呢？理解好Ioc的关键是要明确“谁控制谁，控制什么，为何是反转（有反转就应该有正转了），哪些方面反转了”，那我们来深入分析一下：
   
 > 谁控制谁，控制什么：传统Java SE程序设计，我们直接在对象内部通过new进行创建对象，是程序主动去创建依赖对象；而IoC是有专门一个容器来创建这些对象，即由Ioc容器来控制对 象的创建；谁控制谁？当然是IoC 容器控制了对象；控制什么？那就是主要控制了外部资源获取（不只是对象包括比如文件等）。
   
 > 为何是反转，哪些方面反转了：有反转就有正转，传统应用程序是由我们自己在对象中主动控制去直接获取依赖对象，也就是正转；而反转则是由容器来帮忙创建及注入依赖对象；为何是反转？因为由容器帮我们查找及注入依赖对象，对象只是被动的接受依赖对象，所以是反转；哪些方面反转了？依赖对象的获取被反转了。
### 具体做法
 1. 将bean之间的依赖关系尽可能地转换为关联关系；
 1. 将对具体类的关联尽可能地转换为对Java interface的关联，而不是与具体的服务对象相关联；
 1. Bean实例具体关联相关java interface的哪个实现类的实例，在配置信息的元数据中描述；
 1. 由IoC组件（或称容器）根据配置信息，实例化具体bean类、将bean之间的依赖关系注入进来。
 
### IOC 能做什么
> IoC 不是一种技术，只是一种思想，一个重要的面向对象编程的法则，它能指导我们如何设计出松耦合、更优良的程序。传统应用程序都是由我们在类内部主动创建依赖对象，从而导致类与类之间高耦合，难于测试；有了IoC容器后，把创建和查找依赖对象的控制权交给了容器，由容器进行注入组合对象，所以对象与对象之间是 松散耦合，这样也方便测试，利于功能复用，更重要的是使得程序的整个体系结构变得非常灵活。
  
> 其实IoC对编程带来的最大改变不是从代码上，而是从思想上，发生了“主从换位”的变化。应用程序原本是老大，要获取什么资源都是主动出击，但是在IoC/DI思想中，应用程序就变成被动的了，被动的等待IoC容器来创建并注入它所需要的资源了。
  
> IoC很好的体现了面向对象设计法则之一—— 好莱坞法则：“别找我们，我们找你”；即由IoC容器帮对象找相应的依赖对象并注入，而不是由对象主动去找。

### IOC 和 DI

> DI—Dependency Injection，即“依赖注入”：组件之间依赖关系由容器在运行期决定，形象的说，即由容器动态的将某个依赖关系注入到组件之中。依赖注入的目的并非为软件系统带来更多功能，而是为了提升组件重用的频率，并为系统搭建一个灵活、可扩展的平台。通过依赖注入机制，我们只需要通过简单的配置，而无需任何代码就可指定目标需要的资源，完成自身的业务逻辑，而不需要关心具体的资源来自何处，由谁实现。
  
> 理解DI的关键是：“谁依赖谁，为什么需要依赖，谁注入谁，注入了什么”，那我们来深入分析一下：
  
> 　　●谁依赖于谁：当然是应用程序依赖于IoC容器；
  
> 　　●为什么需要依赖：应用程序需要IoC容器来提供对象需要的外部资源；
  
> 　　●谁注入谁：很明显是IoC容器注入应用程序某个对象，应用程序依赖的对象；
  
> 　　●注入了什么：就是注入某个对象所需要的外部资源（包括对象、资源、常量数据）。
  
> IoC和DI由什么关系呢？其实它们是同一个概念的不同角度描述，由于控制反转概念比较含糊（可能只是理解为容器控制对象这一个层面，很难让人想到谁来维护对象关系），所以2004年大师级人物Martin Fowler又给出了一个新的名字：“依赖注入”，相对IoC 而言，“依赖注入”明确描述了“被注入对象依赖IoC容器配置依赖对象”。
### BeanFactory和FactoryBean的区别
简而言之，BeanFactory是加载的容器，加载一切的BEAN，而FactoryBean用于创建代理类
> BeanFactory: BeanFactory它的职责包括：实例化、定位、配置应用程序中的对象及建立这些对象间的依赖 
> FactoryBean: (通常情况下，bean无须自己实现工厂模式，Spring容器担任工厂角色；但少数情况下，容器中的bean本身就是工厂，其作用是产生其它bean实例),作用是产生其他bean实例。通常情况下，这种bean没有什么特别的要求，仅需要提供一个工厂方法，该方法用来返回其他bean实例。由工厂bean产生的其他bean实例，不再由Spring容器产生，因此与普通bean的配置不同，不再需要提供class元素。

> ProxyFactoryBean用于创建代理(根据Advisor生成的Bean，也就是TargetBean的代理)

# SpringAOP

### 核心概念

 1、横切关注点
  
  对哪些方法进行拦截，拦截后怎么处理，这些关注点称之为横切关注点
  
  2、切面（aspect）
  
  类是对物体特征的抽象，切面就是对横切关注点的抽象
  
  3、连接点（joinpoint）
  
  被拦截到的点，因为Spring只支持方法类型的连接点，所以在Spring中连接点指的就是被拦截到的方法，实际上连接点还可以是字段或者构造器
  
  4、切入点（pointcut）
  
  对连接点进行拦截的定义
  
  5、通知（advice）
  
  所谓通知指的就是指拦截到连接点之后要执行的代码，通知分为前置、后置、异常、最终、环绕通知五类
  
  6、目标对象
  
  代理的目标对象
  
  7、织入（weave）
  
  将切面应用到目标对象并导致代理对象创建的过程
  
  8、引入（introduction）
  
  在不修改代码的前提下，引入可以在运行期为类动态地添加一些方法或字段

AOP全名Aspect-Oriented Programming，中文直译为面向切面(方面)编程，当前已经成为一种比较成熟的编程思想，可以用来很好的解决应用系统中分布于各个模块的交叉关注点问题。在轻量级的J2EE中应用开发中，使用AOP来灵活处理一些具有横切性质的系统级服务，如
 * 事务处理、
 * 安全检查、
 * 缓存、
 * 对象池管理等
 
> Spring提供了两种方式来生成代理对象: JDKProxy和Cglib，具体使用哪种方式生成由AopProxyFactory根据AdvisedSupport对象的配置来决定。默认的策略是如果目标类是接口，则使用JDK动态代理技术，否则使用Cglib来生成代理。下面我们来研究一下Spring如何使用JDK来生成代理对象，具体的生成代码放在JdkDynamicAopProxy这个类中，直接上相关代码：
```
/** 
    * <ol> 
    * <li>获取代理类要实现的接口,除了Advised对象中配置的,还会加上SpringProxy, Advised(opaque=false) 
    * <li>检查上面得到的接口中有没有定义 equals或者hashcode的接口 
    * <li>调用Proxy.newProxyInstance创建代理对象 
    * </ol> 
    */  
   public Object getProxy(ClassLoader classLoader) {  
       if (logger.isDebugEnabled()) {  
           logger.debug("Creating JDK dynamic proxy: target source is " +this.advised.getTargetSource());  
       }  
       Class[] proxiedInterfaces =AopProxyUtils.completeProxiedInterfaces(this.advised);  
       findDefinedEqualsAndHashCodeMethods(proxiedInterfaces);  
       return Proxy.newProxyInstance(classLoader, proxiedInterfaces, this);  
}
```
> 下面的问题是，代理对象生成了，那切面是如何织入的？
> 我们知道InvocationHandler是JDK动态代理的核心，生成的代理对象的方法调用都会委托到InvocationHandler.invoke()方法。而通过JdkDynamicAopProxy的签名我们可以看到这个类其实也实现了InvocationHandler，下面我们就通过分析这个类中实现的invoke()方法来具体看下Spring AOP是如何织入切面的。
