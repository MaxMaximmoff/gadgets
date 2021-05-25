package gadgets;

public class GadgetsRunning {

	public static void main(String[] args) {
		
		// ���������� ������� Radio
		boolean radioOn = true;
		int radioVolume = 75;
		double radioFrequency = 83.2;
		
		
		Radio radio_1 = new Radio(radioOn, radioVolume, radioFrequency);
		
		System.out.println();
		
		double newRadioFrequency = 90.2;
		radio_1.setRadioFrequency (newRadioFrequency);
		int newRadioVolume = 25;
		radio_1.setDeviseVolume(newRadioVolume);
		System.out.println("����������� ��������� �������������� " + radio_1.getDeviseVolume() + " %");
		
		
		// ���������� ������ TV 
		boolean tvOn = true;
		int tvVolume = 35;
		int tvChannel = 5;
		int tvScreenBrightness = 55;
		
		TV tv_1 = new TV(tvOn, tvVolume, tvChannel, tvScreenBrightness);
		
		System.out.println();
		
		int newTvChannel = 6;
		tv_1.setTvChannel (newTvChannel);
		int newTvScreenBrightness = 60;
		tv_1.setTvScreenBrightness(newTvScreenBrightness);

		// ���������� ������ MobilePhone
		boolean mobilePhoneOn = true;
		int mobilePhoneVolume = 75;
		String phoneNumber = "8-903-777-77-77";
		
		MobilePhone mobilePhone_1 = new MobilePhone(mobilePhoneOn, mobilePhoneVolume);
		
		if(!mobilePhone_1.getHandsetStatus()) {
			mobilePhone_1.makeCall(phoneNumber);
		}
		mobilePhone_1.dropHandset();
	}

}

/*
 * ��������� ������ ���������:
 * 
����� ������������� ������
����� �������� - true 
��������� - 75 
������� - 83,200000 

����������� ������� �������������� 90.2 ���
����������� ��������� �������������� 25 %

����� TV ������
TV ������� - true 
��������� - 35 
����� - 5 
������� ������ - 55 

���������� TV ����� � 6
����������� ������� TV ������ 60%

����� ��������� ������� ������
��������� ������� ������� - true 
��������� - 75 
����� �� ������ 8-903-777-77-77
������ ��������
*/

// ����������� ����� Gadget
abstract class Gadget{
	
	   // ���� ������������ ������
	   private boolean deviseOn = false; // ������ �������� �� ���������
	   private int deviseVolume = 50; // ��������� �� ��������� 50%

	   // ����������� ������������ ������
	   public Gadget( boolean deviseOn, int deviseVolume )
	   {
	      this.deviseOn = deviseOn;
	      if(deviseVolume<0)
	    	  this.deviseVolume = 0;
	      else if (deviseVolume>100)
	    	  this.deviseVolume = 100;
	      else
	      this.deviseVolume = deviseVolume;
	   }
	   
	   // ������ ������������ ������
	   public void setDeviseOn(boolean deviseOn) {
		// ���������� ���������/���������� �������
		   this.deviseOn = deviseOn;
		   
	   }
	   public boolean getIsDeviseOn() {
		   return deviseOn;
	   }
	   public void setDeviseVolume (int deviseVolume) {
		// ���������� ����������� ���������
		   this.deviseVolume = deviseVolume;
	   }
	   public int getDeviseVolume() {
		   return deviseVolume;
	   }
}


class Radio extends Gadget{
	// ���� ������ Radio
	private double radioFrequency;
	
	public Radio(boolean deviseOn, int deviseVolume, double radioFrequency) {
		super(deviseOn, deviseVolume);
		// ���������� ��������� ����� � ��������� ��������� �������
		this.radioFrequency = radioFrequency;
		System.out.println("����� ������������� ������");
		System.out.printf("����� �������� - %b \n", deviseOn);
		System.out.printf("��������� - %d \n", deviseVolume);
		System.out.printf("������� - %f \n", radioFrequency);
		
	}
	
	   public void setRadioFrequency(double radioFrequency) {
		// ���������� ��������� �������
		   this.radioFrequency = radioFrequency;
		   System.out.println("����������� ������� �������������� " + this.radioFrequency + " ���");
		   
	   }
	   public double getRadioFrequency() {
		   return radioFrequency;
	   }	
}

class TV extends Gadget{
	// ���� ������ TV
	private int tvChannel;
	private int tvScreenBrightness;
	
	public TV(boolean deviseOn, int deviseVolume, int tvChannel, int tvScreenBrightness) {
		super(deviseOn, deviseVolume);
		// ���������� ��������� TV � ��������� ��������� ���������, ������ � �������
		this.tvChannel = tvChannel;
		this.tvChannel = tvScreenBrightness;
		System.out.println("\n����� TV ������");
		System.out.printf("TV ������� - %b \n", deviseOn);
		System.out.printf("��������� - %d \n", deviseVolume);
		System.out.printf("����� - %d \n", tvChannel);
		System.out.printf("������� ������ - %d \n", tvScreenBrightness);
		
	}
	
	   public void setTvChannel(int tvChannel) {
		// ���������� ��������� ������
		   this.tvChannel = tvChannel;
		   System.out.println("���������� TV ����� � " + this.tvChannel);
		   
	   }
	   public double getTvChannel() {
		   return tvChannel;
	   }	
	   
	   public void setTvScreenBrightness(int tvScreenBrightness) {
		// ���������� ��������� �������
		   this.tvScreenBrightness = tvScreenBrightness;
		   System.out.println("����������� ������� TV ������ " + this.tvScreenBrightness + "%");
	   }
	   
	   public double getTvScreenBrightness() {
		   return tvScreenBrightness;
	   }	
}

class MobilePhone extends Gadget{
	
	private boolean handsetStatus = false;
	
	public MobilePhone(boolean deviseOn, int deviseVolume) {
		super(deviseOn, deviseVolume);
		// ���������� ��������� ���������� � ��������� ��������� ���������
		System.out.println("\n����� ��������� ������� ������");
		System.out.printf("��������� ������� ������� - %b \n", deviseOn);
		System.out.printf("��������� - %d \n", deviseVolume);
	}
	
	public void makeCall(String phoneNumber) {
		// ���������� ������
		   handsetStatus = true;
		   if(handsetStatus) {
			   System.out.println("����� �� ������ " + phoneNumber);
		   }
	}
	
	public void answerCall() {
		// ���������� ������ �� ������
		   handsetStatus = true;
		   if(handsetStatus) {
			   System.out.println("������� �� ������");
		   }
	}
	
	public void dropHandset() {
		// ���������� �������� �������� ������
		   handsetStatus = false;
		   System.out.println("������ ��������");
	}
	
	   public boolean getHandsetStatus() {
		   return handsetStatus;
	   }	
}