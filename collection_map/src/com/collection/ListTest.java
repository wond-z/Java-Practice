package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	// 存放所选课程
	public List courseToSelect;

	public ListTest() {
		this.courseToSelect = new ArrayList();
	}
	
	public void testAdd() {
		Course cr1 = new Course("1", "数据结构");
		courseToSelect.add(cr1);
		Course temp = (Course) courseToSelect.get(0);
		System.out.println("选择了课程：" + temp.id + "." + temp.name);

		Course cr2 = new Course("2", "汇编语言");
		courseToSelect.add(cr2);
		Course temp1 = (Course) courseToSelect.get(0);
		System.out.println("选择了课程：" + temp1.id + "." + temp1.name);
		
		// 以下方法会抛出数组下标越界异常
//		Course cr3 = new Course("4", "test语言");
//		courseToSelect.add(cr3);
		
		// 数组中一次添加多个元素
		Course[] course = {new Course("2", "计算机原理"), new Course("3", "高等数学")};
		courseToSelect.addAll(Arrays.asList(course));
		Course temp2 = (Course) courseToSelect.get(2);
		Course temp3 = (Course) courseToSelect.get(3);
		System.out.println("选择了课程：" + temp2.id + "." + temp2.name +
			" " + temp3.id + "." + temp3.name);
		
		// 添加元素到数组指定位置
		Course[] course1 = {new Course("2", "Java程序设计"), new Course("3", "离散数学")};
		courseToSelect.addAll(2, Arrays.asList(course1));
		Course temp4 = (Course) courseToSelect.get(2);
		Course temp5 = (Course) courseToSelect.get(3);
		System.out.println("选择了课程：" + temp4.id + "." + temp4.name +
			" " + temp5.id + "." + temp5.name);
//		System.out.println(courseToSelect.size());
	}
	
	public void testGet() {
		System.out.println("使用for：");
		int size = courseToSelect.size();
		for(int i = 0; i < size; i ++) {
			Course cr = (Course) courseToSelect.get(i);
			System.out.println("id:" + cr.id + " " + "name:" + cr.name);
		}
	}
	
	// 使用迭代器遍历数组
	public void testInterator() {
		System.out.println("使用迭代器（iterator）：");
		Iterator it = courseToSelect.iterator();
		while (it.hasNext()) {
			Course cr = (Course) it.next();
			System.out.println("id:" + cr.id + " " + "name:" + cr.name);
		}
	}
	
	// 使用for each遍历数组
	public void testForEach() {
		System.out.println("使用for each：");
		for (Object obj : courseToSelect) {
			Course cr = (Course) obj;
			System.out.println("id:" + cr.id + " " + "name:" + cr.name);
		}
	}

	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testAdd();
		lt.testGet();
		lt.testInterator();
		lt.testForEach();
	}
}
