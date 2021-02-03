package com.njq.study;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyApplicationTests {

    @Test
    public void contextLoads1() {
        System.out.println("1212");
    }

    @Test
    public void contextLoads2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(list.stream().sorted(Comparator.comparing(n -> false))
                .collect(Collectors.toList()));
        System.out.println("1212");

        List<Integer> l1 = Collections.emptyList();
        l1.stream().collect(Collectors.toList());
    }

    @Test
    public void contextLoads3() {
        new ImmutableMap.Builder<String, Object>()
                .put("activityCode", null).build();
        System.out.println("1212");
    }


}
