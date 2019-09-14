package cn.myfreecloud.shop.config;


import cn.myfreecloud.shop.component.LoginHandlerInterceptor;
import cn.myfreecloud.shop.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc   不要接管SpringMVC 接管后所有的SpringMVC的配置就全部失效了
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    //将组件注册在容器
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                /**防止表单重复提交的中转页面**/
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器,进行登录检查
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射

                //没有登录的时候就拦截跳转到登录页面
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/uploadFile","/user/login");
            }
        };
        return adapter;
    }

    /**
     * 注入我们的区域信息解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }

}
