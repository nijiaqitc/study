package com.njq.study.base;

import com.njq.study.model.Children;
import com.njq.study.model.XiaoMing;

/**
 * 转型问题
 * 向上转型一般都是安全的，
 * 但向下转型的前提是转型的对象必须是向下的对象实例化的
 */
public class UpConvert {

    /**
     * 针对向下转型的前提是被转型的对象必须已经向上转型过了 ， 否则无法转型会报错。
     * 能否向下转型 用 a instanceof ClassA 判断
     *
     * @param args
     */
    public static void main(String[] args) {
        Children ren = new Children();
        //此种情况是未向上转型过的， 会报错----此处报错
        XiaoMing ming = (XiaoMing) ren;
        ming.getName();
        //此种情况是已经向上转型过了，则向下转型不会有错
        Children r = new XiaoMing();
        XiaoMing ming1 = (XiaoMing) r;
        ming1.go();
    }
}
