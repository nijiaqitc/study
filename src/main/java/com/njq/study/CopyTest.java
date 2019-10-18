package com.njq.study;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: nijiaqi
 * @date: 2019/10/18
 */
public class CopyTest {


    public static void main(String[] args) {
        Cla c1 = new Cla();
        c1.setName("123");
        c1.setVale("234");
        c1.setAa("aaaaa");
        Cc cc = (Cc)c1;
        Clb c2 = new Clb();
        BeanUtils.copyProperties(cc, c2);
        System.out.println(c2.getName());
        System.out.println(c2.getVale());
        System.out.println(c2.getAa());

    }
    public interface Cc {
        public String getName();

        public void setName(String name);

        public String getVale();

        public void setVale(String vale);

    }

    public static class Cla implements Cc{
        private String name;
        private String vale;
        private String aa;
        @Override
        public String getName() {
            return name;
        }
        @Override
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String getVale() {
            return vale;
        }
        @Override
        public void setVale(String vale) {
            this.vale = vale;
        }

        public String getAa() {
            return aa;
        }

        public void setAa(String aa) {
            this.aa = aa;
        }
    }


    public static class Clb {
        private String name;
        private String vale;
        private String aa;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVale() {
            return vale;
        }

        public void setVale(String vale) {
            this.vale = vale;
        }

        public String getAa() {
            return aa;
        }

        public void setAa(String aa) {
            this.aa = aa;
        }
    }
}
