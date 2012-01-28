package com.stone.javacore;

public class HideVariable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**test1 start**/
		/*
		Son son=new Son();
		System.out.println("son.i="+son.i);
		son.setI(100);
		System.out.println("After setI(100) : son.i="+son.i);
		
		Parent parent=son;
		System.out.println("See son as Parent : son.i="+parent.i);
		*/
		/**test1 end**/
		

		/**test2 start**/
        Parent p=new Child();
        System.out.println(p.x);
		/**test2 end**/
	}

	
}

/**test2 start**/
class Parent{
	 
    int x=10;
    public Parent(){
         add(2);
    }
    void add(int y){
         x+=y;
    }
}

class Child extends Parent{
   int x=9;
   void add(int y){
        x+=y;
   }
}
/**test2 end**/


/**test1 start**/
/*
class Parent{	
	int i=10;// �������
	
	public void setI(int i){
		this.i=i;
	}
}

class Son extends Parent{
	int i=10;// �����븸��ͬ��ı���	
}
*/
/**test1 end**/