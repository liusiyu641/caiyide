package com.caiyide.primary;

import com.caiyide.primary.util.AnsiUtil;
import com.caiyide.primary.common.util.SpringContextUtil;
import org.fusesource.jansi.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableConfigurationProperties
@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);

		Environment environment = SpringContextUtil.getBean(Environment.class);
		logger.info("profileActive = " + environment.getProperty("spring.profiles.active"));
		logger.info("mms service start success...........");

		String startSuccess = " ____    __                    __        ____                                                   \n" +
				"/\\  _`\\ /\\ \\__                /\\ \\__    /\\  _`\\                                                 \n" +
				"\\ \\,\\L\\_\\ \\ ,_\\    __     _ __\\ \\ ,_\\   \\ \\,\\L\\_\\  __  __    ___    ___     __    ____    ____  \n" +
				" \\/_\\__ \\\\ \\ \\/  /'__`\\  /\\`'__\\ \\ \\/    \\/_\\__ \\ /\\ \\/\\ \\  /'___\\ /'___\\ /'__`\\ /',__\\  /',__\\ \n" +
				"   /\\ \\L\\ \\ \\ \\_/\\ \\L\\.\\_\\ \\ \\/ \\ \\ \\_     /\\ \\L\\ \\ \\ \\_\\ \\/\\ \\__//\\ \\__//\\  __//\\__, `\\/\\__, `\\\n" +
				"   \\ `\\____\\ \\__\\ \\__/.\\_\\\\ \\_\\  \\ \\__\\    \\ `\\____\\ \\____/\\ \\____\\ \\____\\ \\____\\/\\____/\\/\\____/\n" +
				"    \\/_____/\\/__/\\/__/\\/_/ \\/_/   \\/__/     \\/_____/\\/___/  \\/____/\\/____/\\/____/\\/___/  \\/___/ \n" +
				"                                                                                                \n" +
				"                                                                                                ";

		System.out.println( AnsiUtil.getAnsi(Ansi.Color.GREEN,startSuccess));

	}
}
