#错误一、:nested exception is org.apache.ibatis.binding.BindingException: Parameter 'idList' not found. Available parameters are [collection, list]","request_id":"fe7f7f815c1995a6015c1a22c2540234"

代码报错行一般指的是client 层的feign找不达到路其根本原因是在 mybatis层 参数绑定不成功导致；最后一句话解释就是mapper接口和xml中的参数不对应


###注:sql语句后面不能使用分号


###拦截器无法正常使用，（拦截器没有配置成功） 解决方法在webMvc的配置类上加上一个注解 ：@EnableWebMvc


1.@EnableWebMvc的javaDoc注释有点长。  从下图得到的几个信息： href="mailto:1.@EnableWebMvc">1.@EnableWebMvc没有任何属性，只是@Import了一个类叫DelegatingWebMvcConfiguration

2. 注释中说明：将@EnableWebMvc添加给@Configuration类来导入SpringMvc的配置；3.自定义MVC配置，实现接口WebMvcConfigurer或更可能继承WebMvcConfigurerAdapter,并且使用@EnableWebMvc;

4.如果还想要自定义配置，移除@EnableWebMvc,并且继承WebMvcConfigurationSupport或DelegatingWebMvcConfiguration。

5.@EnableWebMvc出现自Spring3.1的版本

注：当使用两个的配置类的时候需要EnbaleWebMvc








