package com.arevalo.paola.netby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class NetbyApplication  {

	/**
	 * INICIA EL DESPLIEGUE DE LOS SERVICIOS
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NetbyApplication.class, args);
	}


}
