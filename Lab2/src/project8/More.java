package project8;

/*
 *F1.AB只活一次，C里循环产生AB，然后join
 *F2.引入状态对象  class 放两个bool成员对应ab都已完成
 *	J ：拿锁，while(！AB都生成了字母）wait，设置AB状态为未生成操作，放锁notifyall()
 *	A，B:拿锁，while(生成）wait,标记，notifyall()
 *	AB可以在一个work类
 */
public class More {

}
