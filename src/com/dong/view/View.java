package com.dong.view;

import java.util.Scanner;

import com.dong.control.UserAction;
import com.dong.model.User;

public class View {
	private static final String MAIN="MAIN";
	private static final String QUERY="QUERY";
	private static final String GET="GET";
	private static final String ADD="ADD";
	private static final String UPDATE="UPDATE";
	private static final String DELETE="DELETE";
	private static final String EXIT="EXIT";
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		User u = new User();
		UserAction action = new UserAction();
		String prenious=null;//���ִ��ģ��
		int step = 1;//��ǲ���
		while(scan.hasNext()){
			String in = scan.next().toString();
			if(EXIT.equals(in.toUpperCase()) || EXIT.substring(0, 1).equals(in.toUpperCase())){
				System.out.println("�ɹ��˳�");
				break;
			}else if(ADD.equals(in.toUpperCase()) 
					|| ADD.substring(0, 1).equals(in.toUpperCase())
					|| ADD.equals(prenious)){
				prenious=ADD;
				if(step == 1){
					System.out.println("�����û�id");
				}else if(step == 2){
					u.setUser_id(Integer.valueOf(in));
					System.out.println("�����û���");
				}else if(step == 3){
					u.setUsername(in);
					System.out.println("��������");
				}else if(step == 4){
					u.setPassword(in);
					try {
						action.add(u);
						prenious=null;
						step = 1;
						System.out.println("��ӳɹ�");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("���ʧ��");
					}
				}
				if(ADD.equals(prenious)){
					step++;
				}
			}else{
			System.out.println("����ֵ" + in);
			}
		}
	}
}
