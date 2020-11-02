package com.thoughtworks.capability.gtb.entrancequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO GTB-知识点: * 需要了解下三层架构
// TODO GTB-知识点: * 了解下lombok的使用
// TODO GTB-知识点: * 需要了解Java8 Stream的使用
// TODO GTB-完成度: * 没有获取分组接口
// TODO GTB-工程实践: * 注意单一职责，group和student应该有单独的Controller和Service
// TODO GTB-测试: * 有Controller层测试，但只有一个测试
@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}

}
