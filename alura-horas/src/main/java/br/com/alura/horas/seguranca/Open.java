package br.com.alura.horas.seguranca;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
// para anotacao nao ser descartada na compilacao do java
// RUNTIME vai durar ate executar o codigo
@Retention(RetentionPolicy.RUNTIME)

// anotacao para fala, que pode usar so em metodos
@Target(ElementType.METHOD)
public @interface Open {

}
