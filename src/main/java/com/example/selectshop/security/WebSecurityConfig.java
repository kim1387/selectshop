package com.example.selectshop.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

//        http.authorizeRequests()
//                .anyRequest().authenticated()   // 어느 요청이던지 로그인이 필요로한다.
//                .and()                          // 또한
//                .formLogin()                    // 다만 로그인 페이지에 대해 해서는 허용
//                .loginPage("/user/login")       // 로그인 페이지 위치 지정
//                .failureUrl("/user/login/error")// 로그인 실패시 이동
//                .defaultSuccessUrl("/")         // 로그인 완료시 / 주소로 이동
//                .permitAll()                    //
//                .and()
//                .logout()
//                .permitAll();
        http.authorizeRequests()
                // image 폴더를 login 없이 허용
                .antMatchers("/images/**").permitAll()
                // css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()
                // 그 외 모든 요청은 인증과정 필요
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
//    authenticated() 메소드는 애플리케이션에 로그인된 사용자가 요청을 수행할 떄 필요하다.
//    만약 사용자가 인증되지 않았다면, 스프링 시큐리티 필터는 요청을 잡아내고
//    사용자를 로그인 페이지로 리다이렉션 해준다.
//    permitAll() 메소드는 어떠한 보안 요구 없이 요청을 허용해준다.