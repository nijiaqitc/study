package com.njq.study.base;

import java.util.Arrays;
import java.util.Collection;

public class CollectionConvert {

	public interface A{
		String getName();
	}
	
	public class B implements A{
		
		@Override
		public String getName() {
			return "B";
		}
		
		protected void getValue() {}
	}
	
	public class C extends B{
		@Override
		public String getName() {
			return "C";
		}
		
		/**
		 * 重写不能降低包的权限
		 * 会报错
		 */
//		@Override
//		void getValue() {
//			
//		}
		
		/**
		 * 重写可以扩大包的权限
		 */
		@Override
		public void getValue() {
			
		}
		
	}
	
	
	public static void main(String[] args) {
		CollectionConvert covert = new CollectionConvert();
		
		//创建内部类数组
		B[] bx = new B[] {covert.new B(),covert.new C()};
		for(B x :bx) {
			System.out.println(x.getName());
		}
		
		Collection<B> col = Arrays.asList(covert.new B(),covert.new B(),covert.new B());
		for(B b : col) {
			System.out.println(b.getName());
		}
		
		Collection<A> cola = Arrays.asList(covert.new C(),covert.new C(),covert.new B());
		
		for(A a : cola) {
			System.out.println(a.getName());
			
		}
	}
	
}
