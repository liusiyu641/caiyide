package com.caiyide.primary;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
    public static void main(String[] args) {
        System.out.println("{\"inputs\": [{\"image\":{\"dataType\": 50,\"dataValue\":\"" + 1+ "\"},\"configure\":{\"dataType\": 50,\"dataValue\": \"{\\\"side\\\":\\\"face\\\"}\"}}]}");

        String bodys="{\"inputs\" :" +
                "[{\"image\" :" +
                "{\"dataType\" : 50," +
                "\"dataValue\" :\"" + 1 + "\"" +
                "}";

                bodys += ",\"configure\" :" +
                        "{\"dataType\" : 50," +
                        "\"dataValue\" : \"{\\\"side\\\":\\\"face\\\"}\"}" +
                        "}]}";

        System.out.println(bodys);

    }
}

