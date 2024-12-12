package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Weapon implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Weapon(String name) {
        System.out.println("1. Instantiation: Nova weapon foi criada.");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. ApplicationContextAware: Setting application context.");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. BeanFactoryAware: Setting bean factory for " + getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. Initialization: " + getName() + " unsheathed.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: " + getName() + " is being cleaned and prepared to be encased.");
        restAndRecover();
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Executing custom init for " + getName());
    }

    public void customDestroy() {
        System.out.println("13. Custom Destruction: " + getName() + " sheathed.");

    }

    private void restAndRecover() {
        System.out.println("12. DisposableBean: " + getName() + " is clean and can be put away or used again.");
    }

    @PostConstruct
    public void init() {
        System.out.println("6. @PostConstruct: " + getName() + " is preparing for action.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy: " + getName() + " was used and now is being prepared to be cleaned.");
    }
}
