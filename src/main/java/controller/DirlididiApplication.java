package main.java.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import main.java.Dirlididi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.FileSystemUtils;


@SpringBootApplication
public class DirlididiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Dirlididi.class, args);

	}
}
