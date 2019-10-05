**1.字符串的创建**
~~~java

/*
 * java.lang.String类代表字符串
 * API中显示，Java程序中的所有字符串字面值(如“abc")，都作为此类的实例实现
 *  其实就是说，程序当中的双引号字符串，都是String类的对象(就算没有new，照样是)
 */
/*
 * 字符串的特点：
 * 	1.字符串的内容不可变
 * 	2.字符串可以共享使用
 * 	3.字符串效果相当于是char[]字符数组，但底层原理是byte[]字节数组
 */
/*
 * 创建字符串的3+1种方式
 * 三种构造方法：
 * public String();	创建一个空白字符串，不含有任何内容
 * public String(char[] array);	根据字符数组的内容，来创建相应的字符串
 * public String(byte[] array); 根据字符数组的内容，来创建相应的字符串
 * 一种基本实现：
 * String str="hello";
 */

public class Demo {
	public static void main(String[] args) {
		String str=new String();
		System.out.println(str);
		
		char[] array= {'a','b','c'};
		String str2=new String(array);
		System.out.println(str2);
		
		byte[] array2= {97,98};
		String str3=new String(array2);
		System.out.println(str3);
		
		String str4="hello";
		System.out.println(str4);
	}
}
~~~
运行结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191005105439394.png)
**2.字符串的获取**
~~~java

/*
 * String当中与获取相关的常用方法有：
 * 1.public int length():获取字符串当中含有的字符个数，得到字符串的长度
 * 2.public String concat(String str):将当前字符串和参数字符串拼接成为返回新的字符串
 * 3.public char charAt(int index):获取指定索引位置的单个字符
 * 4.public int inedxOf(String str):查找参数字符串在本字符串当中首次出现的索引位置
 */
public class Demo {
	public static void main(String[] args) {
		// 获取字符串的长度
		int length = "avkfkdkdjsji".length();
		System.out.println("字符串的长度为" + length);
		System.out.println("======");
		// 拼接字符串
		String str1 = "hello";
		String str2 = "world";
		String str3 = str1.concat(str2);
		System.out.println(str1);//原封不动
		System.out.println(str2);//原封不动
		System.out.println(str3);
		System.out.println("======");
		//获取指定索引位置的单个字符
		char ch="hello".charAt(1);
		System.out.println("在1号索引位置的字符是："+ch);
		System.out.println("======");
		//查找参数字符串在本来在字符串当中出现的第一次索引的位置
		//如果没有，返回-1
		int m="hello".indexOf('e');
		System.out.println("第一次出现的索引值为"+m);
		String original="hehehee";
		int index=original.indexOf("he");
		System.out.println("第一次出现的索引值为"+index);
	}
}

~~~
运行结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019100510580530.png)
**3.字符串的截取**
~~~java

/*
 * 字符串的截取方法：
 * public String substring(int index):截取从参数位置一直到字符串结尾
 * public String substring(int begin,int end):截取从begin开始，一直到end结束，其中[begin,end):左开右闭
 */
public class Demo {
	public static void main(String[] args) {
		String str1 = "helloworld";
		String str2 = str1.substring(1);
		System.out.println(str2);
		System.out.println("======");
		String str3 = str1.substring(1, 3);
		System.out.println(str3);
		System.out.println("======");
		/*
		 * 下面的写法，字符串的内容仍然没有改变
		 * str4当中保存的是地址值
		 * 本身是一个地址值
		 * 后来变成了另外一个地址值
		 */
		String str4="hello";
		System.out.println(str4);
	    str4="world";
		System.out.println(str4);
	}
}

~~~
运行结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191005110007625.png)
**4.字符串的转换**
~~~java

/*
 * String当中与转换相关的常用方法
 * 1.public char[] toCharArray();//将当前字符串拆分成为字符数组作为返回值
 * 2.public char[] getBytes();//获得当前字符串底层的字符数组
 * 3.public String replace(charSequence oldString,charSquence newString):
 * 将所有出现的老字符串替换成为新字符串，返回替换后的新字符串
 * 备注：charSequence意思是说可以接收字符串类型
 *  */
public class Demo {
	public static void main(String[] args) {
		char[] chars="hello".toCharArray();
		System.out.println(chars[0]);
		System.out.println(chars.length);
		System.out.println(chars);
		System.out.println("======");
		byte[] bytes="abc".getBytes();
		for(int i=0;i<bytes.length;i++) {
			System.out.println(bytes[i]);
		}
		System.out.println("======");
		String str1="how do you do";
		String str2=str1.replace("o", "*");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("=======");
		String lang1="你好，你大爷的";
		String lang2=lang1.replace("你大爷的", "****");
		System.out.println(lang2);
	}
}

~~~
运行结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191005110135136.png)
**5.字符串的分割**
~~~java

/*
 * 字符串的分割方法：
 * public String[] split(String regex):按照参数的规则，将字符串均分为若干部分
 * 注意：
 * split方法参数其实是一个“正则表达式”，如果按照英文句点进行切割，必须格式为.split("\\.")
 */
public class Demo {
	public static void main(String[] args) {
		String str1 = "aaa,bbb,ccc";
		String[] array1 = str1.split(",");
		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}
		System.out.println("======");
		String str2 = "aaa bbb ccc";
		String[] array2 = str2.split(" ");
		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
		System.out.println("======");
		String str3 = "aaa.bbb.ccc";
		String[] array3 = str3.split("\\.");
		for (int i = 0; i < array3.length; i++) {
			System.out.println(array1[i]);
		}
	}
}

~~~
运行结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191005110333430.png)
**6.字符串的字母大小写转换**
~~~java

/*
 * 字符串的字母大小写转换：
 * 1.toLowerCase()方法
 * 2.toUpperCase()方法
 */
public class Demo {
	public static void main(String[] args) {
		String str = "abc DEF";
		String newStr1 = str.toLowerCase();
		String newStr2 = str.toUpperCase();
		System.out.println(newStr1);
		System.out.println(newStr2);
	}
}

~~~
运行结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191005110523920.png)
**7.字符串的字典顺序比较**
~~~java

/*
 * 按照字典顺序比较字符串：compareTo()
 * String对象位于参数字符串之前，返回一个负整数
 * String对象位于参数字符串之后，返回一个正整数
 */
public class Demo {
	public static void main(String[] args) {
		String str = "b";
		String str2 = "a";
		String str3 = "c";
		System.out.println(str + " compareTo " + str2 + ":" + str.compareTo(str2));
		System.out.println(str + " compareTo " + str3 + ":" + str.compareTo(str3));
	}
}

~~~
运行结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191005110737885.png)
**8.字符串的分割(含转义字符)**
~~~java

/*
 * 字符串分割：
 * 1.split(String sign):根据给定的分割符对字符串进行拆分
 * 2.split(String sign,int limit):根据给定的分割符对字符串进行拆分,并限定拆分的次数
 */
public class Demo {
	public static void main(String[] args) {
		// 创建字符串
		String str = "192.168.0.1";
		// 按照“.”进行分割，使用转义字符“\\.”
		String[] arr1 = str.split("\\.");
		// 按照“.”进行两次分割，使用转义字符“\\.”
		String[] arr2 = str.split("\\.", 2);

		// 输出str原值
		System.out.println("str的原值为：" + "[" + str + "]");
		// 输出全部分割的结果
		System.out.print("全部分割的结果:");
		for (String a : arr1) {
			System.out.print("[" + a + "]");
		}
		System.out.println();

		// 输出两次分割的结果
		System.out.print("两次分割的结果:");
		for (String a : arr2) {
			System.out.print("[" + a + "]");
		}
	}
}

~~~
运行结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191005110925721.png)
