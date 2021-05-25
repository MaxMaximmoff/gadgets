package gadgets;

public class GadgetsRunning {

	public static void main(String[] args) {
		
		// Применение классов Radio
		boolean radioOn = true;
		int radioVolume = 75;
		double radioFrequency = 83.2;
		
		
		Radio radio_1 = new Radio(radioOn, radioVolume, radioFrequency);
		
		System.out.println();
		
		double newRadioFrequency = 90.2;
		radio_1.setRadioFrequency (newRadioFrequency);
		int newRadioVolume = 25;
		radio_1.setDeviseVolume(newRadioVolume);
		System.out.println("Установлена громкость радиоприемника " + radio_1.getDeviseVolume() + " %");
		
		
		// Применение класса TV 
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

		// Применение класса MobilePhone
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
 * Результат работы программы:
 * 
Новый радиоприемник создан
Радио включено - true 
Громкость - 75 
Частота - 83,200000 

Установлена частота радиоприемника 90.2 мГц
Установлена громкость радиоприемника 25 %

Новый TV создан
TV включен - true 
Громкость - 35 
Канал - 5 
Яркость экрана - 55 

Установлен TV канал № 6
Установлена яркость TV экрана 60%

Новый мобильный телефон создан
Мобильный телефон включен - true 
Громкость - 75 
Звоню по номеру 8-903-777-77-77
Трубка положена
*/

// Абстрактный класс Gadget
abstract class Gadget{
	
	   // Поля абстрактного класса
	   private boolean deviseOn = false; // прибор выключен по умолчанию
	   private int deviseVolume = 50; // громкость по умолчанию 50%

	   // Конструктор абстрактного класса
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
	   
	   // Методы абстрактного класса
	   public void setDeviseOn(boolean deviseOn) {
		// реализация включения/выключения прибора
		   this.deviseOn = deviseOn;
		   
	   }
	   public boolean getIsDeviseOn() {
		   return deviseOn;
	   }
	   public void setDeviseVolume (int deviseVolume) {
		// реализация регулировки громкости
		   this.deviseVolume = deviseVolume;
	   }
	   public int getDeviseVolume() {
		   return deviseVolume;
	   }
}


class Radio extends Gadget{
	// Поля класса Radio
	private double radioFrequency;
	
	public Radio(boolean deviseOn, int deviseVolume, double radioFrequency) {
		super(deviseOn, deviseVolume);
		// Реализация включения радио и начальная установка частоты
		this.radioFrequency = radioFrequency;
		System.out.println("Новый радиоприемник создан");
		System.out.printf("Радио включено - %b \n", deviseOn);
		System.out.printf("Громкость - %d \n", deviseVolume);
		System.out.printf("Частота - %f \n", radioFrequency);
		
	}
	
	   public void setRadioFrequency(double radioFrequency) {
		// реализация установки частоты
		   this.radioFrequency = radioFrequency;
		   System.out.println("Установлена частота радиоприемника " + this.radioFrequency + " мГц");
		   
	   }
	   public double getRadioFrequency() {
		   return radioFrequency;
	   }	
}

class TV extends Gadget{
	// Поля класса TV
	private int tvChannel;
	private int tvScreenBrightness;
	
	public TV(boolean deviseOn, int deviseVolume, int tvChannel, int tvScreenBrightness) {
		super(deviseOn, deviseVolume);
		// Реализация включения TV и начальная установка громкости, канала и яркости
		this.tvChannel = tvChannel;
		this.tvChannel = tvScreenBrightness;
		System.out.println("\nНовый TV создан");
		System.out.printf("TV включен - %b \n", deviseOn);
		System.out.printf("Громкость - %d \n", deviseVolume);
		System.out.printf("Канал - %d \n", tvChannel);
		System.out.printf("Яркость экрана - %d \n", tvScreenBrightness);
		
	}
	
	   public void setTvChannel(int tvChannel) {
		// реализация установки канала
		   this.tvChannel = tvChannel;
		   System.out.println("Установлен TV канал № " + this.tvChannel);
		   
	   }
	   public double getTvChannel() {
		   return tvChannel;
	   }	
	   
	   public void setTvScreenBrightness(int tvScreenBrightness) {
		// реализация установки яркости
		   this.tvScreenBrightness = tvScreenBrightness;
		   System.out.println("Установлена яркость TV экрана " + this.tvScreenBrightness + "%");
	   }
	   
	   public double getTvScreenBrightness() {
		   return tvScreenBrightness;
	   }	
}

class MobilePhone extends Gadget{
	
	private boolean handsetStatus = false;
	
	public MobilePhone(boolean deviseOn, int deviseVolume) {
		super(deviseOn, deviseVolume);
		// Реализация включения мобильного и начальная установка громкости
		System.out.println("\nНовый мобильный телефон создан");
		System.out.printf("Мобильный телефон включен - %b \n", deviseOn);
		System.out.printf("Громкость - %d \n", deviseVolume);
	}
	
	public void makeCall(String phoneNumber) {
		// реализация звонка
		   handsetStatus = true;
		   if(handsetStatus) {
			   System.out.println("Звоню по номеру " + phoneNumber);
		   }
	}
	
	public void answerCall() {
		// реализация ответа на звонок
		   handsetStatus = true;
		   if(handsetStatus) {
			   System.out.println("Отвечаю на звонок");
		   }
	}
	
	public void dropHandset() {
		// реализация действия положить трубку
		   handsetStatus = false;
		   System.out.println("Трубка положена");
	}
	
	   public boolean getHandsetStatus() {
		   return handsetStatus;
	   }	
}