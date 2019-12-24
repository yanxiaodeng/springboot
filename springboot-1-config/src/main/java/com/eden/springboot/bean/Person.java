package com.eden.springboot.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
* 1.将配置文件中配置的每一个属性的值，映射到这个组件
* 本类中的值和配置文件里面的值来绑定
* prefix = "person" 配置文件的那个文件中的属性进行映射
* 只有组件是容器里面的组件@Component，
* 容器才能够提供@ConfigurationProperties的功能
*
* 2.@value和@ConfigurationProperties(prefix = "person" )的区别
 一般来说@ConfigurationProperties(prefix = "person" )支持的是数据的校验和复杂的数据封装
 而@Value()是不支持的
 * 3.@PropertySource(value={"classpath:person.properties"}）记载指定路径下的配置文件
 *
 * 4.
* */
@PropertySource(value={"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person" ) //默认是从全局文件里面获取值
@Validated
public class Person {
   // @Value("${person.last-name}")
    //@Email 这里实现校验lastName是一个邮箱地址 属于JSR303的数据校验
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birthday;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birthday=" + birthday +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
