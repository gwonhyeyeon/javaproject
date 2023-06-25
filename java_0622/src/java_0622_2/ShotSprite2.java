package java_0622_2;

import java.awt.Image;

//탄환 클래스
public class ShotSprite2 extends Sprite {
	private GalagaGame game;

//생성자 : 게임판, 이미지 파일명, 이미지 x, y 좌표 받아서 멤버 초기화
	public ShotSprite2(GalagaGame game, Image image, int x, int y) {
//이미지 파일명, 이미지 x, y 좌표는 부모 클래스 생성자에서 초기화
		super(image, x, y);
		this.game = game;
//y축 이동량 -3으로 초기화
		dy = -3;
	}
//탄환 이미지 움직임 오버라이딩
	@Override
	public void move() {
//부모 클래스의 move 실행
		x += dx;
		y += dy;
//y값이 -100보다 작으면 (탄환이 프레임 위쪽 밖으로 벗어나면)
	
	}
}