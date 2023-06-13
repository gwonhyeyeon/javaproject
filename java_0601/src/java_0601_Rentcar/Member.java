package java_0601_Rentcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Member {
    Scanner sc = new Scanner(System.in);
    private ArrayList<ArrayList<String>> members = new ArrayList<>();

    // 회원정보 등록
    public void setMember() {
        boolean again = true;
        while (again) {

            String[] text = { "아이디", "비밀번호", "이름", "전화번호" };
            ArrayList<String> member = new ArrayList<>();
            for (int i = 0; i < text.length; i++) {
                System.out.printf("%s (을/를) 등록하세요 : ", text[i]);
                member.add(sc.next());
            }
            members.add(member);
            System.out.print("등록되었습니다...\n회원 정보 등록에서 나가시겠어요? y/n : ");
            char a = sc.next().charAt(0);
            if (a == 'y' || a == 'Y') {
                again = false;
            }
        }
    }

    // 회원정보 조회
    public void getMember() {
        boolean again = true;
        while (again) {
            System.out.print("회원님의 아이디를 입력하세요 : ");
            String id = sc.next();
            for (ArrayList<String> a : members) {
                if (a.get(0).contains(id)) {
                    System.out.println("[" + "아이디, " + "비밀번호, " + "이름, " + "전화번호" + "]");
                    System.out.println(a);
                }
            }
            System.out.print("조회 되었습니다...\n회원 정보 조회에서 나가시겠어요? y/n : ");
            char a = sc.next().charAt(0);
            if (a == 'y' || a == 'Y') {
                again = false;
            }
        }
    }

    // 회원정보 수정
    public void modifyMember() {
        boolean again = true;
        while (again) {
            System.out.print("회원님의 아이디를 입력하세요 : ");
            String id = sc.next();
            for (ArrayList<String> member : members) {
                if (member.get(0).contains(id)) {
                    ArrayList<String> a = new ArrayList<>();
                    System.out.println("[" + "아이디, " + "비밀번호, " + "이름, " + "전화번호" + "]");
                    System.out.print(member);
                    System.out.println("[" + "아이디, " + "비밀번호, " + "이름, " + "전화번호" + "]" + " 순으로 입력하세요");
                    for (int i = 0; i < member.size(); i++) {

                        a.add(sc.next());
                    }
                    System.out.printf("변경 전 : %s || 변경 후 : %s", member, a);
                    System.out.print("수정하시겠어요?");
                    char change = sc.next().charAt(0);
                    if (change == 'y' || change == 'Y') {
                        // 변경하는 코드
                        Collections.replaceAll(members, null, null);
                        System.out.print("수정되었습니다...\n회원 정보 수정에서 나가시겠어요? y/n : ");

                    }
                }
            }
            char a = sc.next().charAt(0);
            if (a == 'y' || a == 'Y') {
                again = false;
            }
        }

    }

    // 회원정보 삭제
    public void deleteMember() {
        boolean again = true;
        while (again) {
            System.out.print("회원님의 아이디를 입력하세요 : ");
            String id = sc.next();

            for (ArrayList<String> member : members) {
                if (member.get(0).contains(id)) {
                    System.out.println("회원님의 정보입니다..");
                    System.out.println("[" + "아이디, " + "비밀번호, " + "이름, " + "전화번호" + "]" + " 순으로 입력하세요");
                    System.out.println(member);
                    System.out.print("삭제 하시겠어요? y/n : ");
                    char delete = sc.next().charAt(0);

                    if (delete == 'Y' || delete == 'y') {
                        // 삭제하는 코드
                        System.out.println("삭제되었습니다.");
                        break;
                    }
                }
            }

            System.out.print("회원 정보 삭제에서 나가시겠어요? y/n : ");
            char a = sc.next().charAt(0);
            if (a == 'y' || a == 'Y') {
                again = false;
            }
        }
    }

    public void member_main() {

        Member m = new Member();
        boolean again = true;
        while (again) {
        	System.out.println("차량 렌트하시는 방법");
        	System.out.println("*회원이시라면, 바로 5.차종 선택하기를 누르고 진행하세요. 회원이 아니시라면, 2. 회원 등록하기를 누르세요.");
        	System.out.println("회원등록이 끝나시면, 5.차종선택하기를 누르고 예약을 진행하세요.");
            System.out.println("메뉴를 선택하세요...\n1. 회원 정보 조회 / 2. 회원 등록하기 / 3. 회원정보 수정하기 / 4. 회원정보 삭제하기 / 5. 차종선택하기");
            String mode = sc.next();
            switch (mode) {
                case "1":
                    m.getMember();
                    break;

                case "2":
                    m.setMember();
                    break;

                case "3":
                    m.modifyMember();
                    break;

                case "4":
                    m.deleteMember();
                    break;

                case "5":
                    System.out.print("종료 합니다..");
                    again = false;
                    break;

            }
        }
    }
}
