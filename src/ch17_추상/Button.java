package ch17_추상;
// interface는 다 추상 메소드 일반메소드 사용불가
public interface Button {
	public int buttonCount = 4;
	//          스테틱상수  일반변수 사용불가
	public void PowerOn();
	public void PowerOff();
	public void VolumUp();
	public void VolumDown();
	
}
