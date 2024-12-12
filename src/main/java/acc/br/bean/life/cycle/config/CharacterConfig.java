package acc.br.bean.life.cycle.config;

import acc.br.bean.life.cycle.beans.Character;
import acc.br.bean.life.cycle.beans.Item;
import acc.br.bean.life.cycle.beans.Weapon;
import acc.br.bean.life.cycle.processor.MagicBeanPostProcessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CharacterConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public Character character() {
        Character character = new Character();
        return character;
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public Weapon sword() {
        return new Weapon("Sword");
    }

    @Bean
    public Item potion() {
        return new Item("Health Potion");
    }

    @Bean
    public MagicBeanPostProcessor magicBeanPostProcessor() {
        return new MagicBeanPostProcessor();
    }
}
