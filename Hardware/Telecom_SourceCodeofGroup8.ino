#include <dht11.h>
#include <IRremote.h> 
#include <LiquidCrystal.h>
#include "voice.c"
void down();
void up();
void right();
void left();
void zuozhuan90();
void youzhuan90();
void zuozhuan45();
void youzhuan45();
void zuozhuanN(int n);
void youzhuanN(int n);
void stopping();
void mode1();
void mode2();
const int Pin0 = 4;
const int Pin1 = 5;
const int Pin2 = 6;
const int Pin3 = 7;
const int Pin20 =8;
const int Pin21 =9;
const int Pin22 =10;
const int Pin23 =11;
//电机
int _step =0 ;
boolean dir; //= -1;正反转
int stepperSpeed = 5;//电机转速,1ms一步
//电机
const int RECV_PIN = 13;    
//遥控器
const int trig=2;
const int echo=3;
const int trig2=32;
const int echo2=33;
const int trig3=34;
const int echo3=35;
//超声波
IRrecv irrecv(RECV_PIN);  
decode_results results; 
int a=2;
//遥控器
unsigned char i,j;
long Time=0;
float S=100.0;
double Sleft,Sright,S0;
double S1=100.0,S2=100.0;
double Sbefore;
double Sk1[100];
double Sk2[100];
int Timerk1[100];
int Timerk2[100];
int timer;
int lefttimer;
int righttimer;
int ran;
//超声波
int angle;
double leftangle;
double rightangle;
//避障转角
String comdata;
LiquidCrystal lcd(43,42,41,40,39,38);
String firstline;
String secondline;
int modes=0;
String content[10];
//lcd显示屏
int m;
const int CLOCK=248;//??????转向的时间所产生的角度
int CLOCK0=0;
//左右转向操作
const int buzzer = 46;
//蜂鸣器
const int potpin=A0;
const int white=48;
int val=0;
int valbefore;
//亮度传感器
const int rentiinpin=50;
const int red=51;
int buttonState;
String a0="zhouweiyouren";
String a1="zhouweimeiren";
String wenben0;
//人体红外识别
const int xiedu=52;
const int green=53;
int iAA;
String b0="shangpo";
String b1="xiapo";
String wenben1;
int iAAbefore;
//斜度传感器
const int crash1=22;
const int crash2=23;
const int crash3=24;
const int crash4=25;
const int yellow=28;
int SAA1;
int SAA2;
int SAA3;
int SAA4;
String c0="pengzhuang";
String c1="meiyoupengzhuang";
String wenben2;
//四个碰撞传感器模块
int b=0;
//模式的切换
String lanya="";
char lanyadata;
//蓝牙部分
int k=0;
int k0=0;
//k值

dht11 DHT11;
const int tempera=29;
int humi;
int temp;
//温湿度传感器
const int fengshan=45;
int FS=0;
//风扇
void setup() {
  irrecv.enableIRIn();
  pinMode(Pin0, OUTPUT);
  pinMode(Pin1, OUTPUT);
  pinMode(Pin2, OUTPUT);
  pinMode(Pin3, OUTPUT);
  pinMode(Pin20, OUTPUT);
  pinMode(Pin21, OUTPUT);
  pinMode(Pin22, OUTPUT);
  pinMode(Pin23, OUTPUT);
  pinMode(echo,INPUT);
  pinMode(trig,OUTPUT);
  pinMode(echo2,INPUT);
  pinMode(trig2,OUTPUT);
  pinMode(echo3,INPUT);
  pinMode(trig3,OUTPUT);
  pinMode(white,OUTPUT);
  //pinMode(buzzer,OUTPUT);
  //digitalWrite(buzzer,HIGH);
  pinMode(fengshan,OUTPUT);
  lcd.begin(16, 2);
  lcd.print("Welcome!");
  Serial.begin(9600);
  Serial1.begin(9600);
  for(int i;i<100;i++)
  {
    Sk1[i]=100;
    Sk2[i]=100;
  }
}

void loop() {
  while(Serial.available()>0)
  {
    lanya+=char(Serial.read());
    delay(2);
  }
  if(lanya.length()>0)
  {
    if(lanya=="STOP")
    {
      a=2;
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[3]);
      Serial1.print('$');
    }else if(lanya=="GO AHEAD")
    {
      a=0;
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[0]);
      Serial1.print('$');
    }else if(lanya=="GO BACK")
    {
      a=1;
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[4]);
      Serial1.print('$');
    }else if(lanya=="TURN LEFT")
    {
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[1]);
      Serial1.print('$');
      a=3;
    }else if(lanya=="TURN RIGHT")
    {
       Serial1.print("@TextToSpeech#");
      Serial1.print(move[2]);
      Serial1.print('$');
      a=4;
    }else if(lanya=="TO")
    {
      b=1;
    }else if(lanya=="ONE")
    {
      b=0;
    }
    lanya="";
  }
  //蓝牙
  // put your main code here, to run repeatedly:
if (irrecv.decode(&results))//解码成功，收到一组红外讯号   
    {  
    // Serial.println(results.value);//以16进制换行输出接收代码 
    // delay(5000);
     if(results.value==16761405){
      b=3;
     }else if(results.value==16753245){
      b=0;
      Serial1.print("@TextToSpeech#");
      Serial1.print(avoid[0]);
      Serial1.print(avoid[1]);  
      Serial1.print('$');
      ////添加语音 避障模式1
     }else if(results.value==16736925){
      b=1;
      Serial1.print("@TextToSpeech#");
      Serial1.print(avoid[0]);
      Serial1.print(avoid[2]);  
      Serial1.print('$');
      ////添加语音 避障模式2
     }else if(results.value==16769565){
      b=2;
       Serial1.print("@TextToSpeech#");
      Serial1.print(avoid[0]);
      Serial1.print(avoid[3]);  
      Serial1.print('$');
      ////添加语音 避障模式3
     }else if(results.value==16754775){
      a=1;//down
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[4]);
      Serial1.print('$');
      ////添加语音 后退
     }else if(results.value==16769055){
      a=0;//up
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[0]);
      Serial1.print('$');
      ////添加语音 前进
     }else if(results.value==16748655){
      a=2;
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[3]);
      Serial1.print('$');
      ////添加语音 停止
     }else if(results.value==16738455){
      a=3;//左转
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[1]);
      Serial1.print('$');
      ////添加语音 左转
     }else if(results.value==16750695){
      a=4;//右转
       Serial1.print("@TextToSpeech#");
      Serial1.print(move[2]);
      Serial1.print('$');
      ////添加语音 右转
     }else if(results.value==16724175){
      a=5;//左转90度
     }else if(results.value==16718055){
      a=6;//右转90度
     }else if(results.value==16720605){
      lcd.clear();
      lcd.print("13888888888");//右转90度
     }else if(results.value==16732845){
      if(FS==0)
      {
        digitalWrite(fengshan,HIGH);
        FS++;
      }else{
        digitalWrite(fengshan,LOW);
        FS--;
      }
     }
      irrecv.resume(); // 接收下一个值  
    }
    if(a==1){
      down();
    }else if(a==0){
      up();
    }else if(a==3){
      left();
    }else if(a==4){
      right();
    }else if(a==2){
      stopping();
    }else if(a==5){
      zuozhuan90();
    }else if(a==6){
      youzhuan90();
    }
 if((k-1)%3000==0)
 {
  lcd.clear();
  if(modes==0){
    firstline="Temp=27C";
    secondline=content[1];
    modes++;
  }else if(modes==1){
    firstline=content[2];
    secondline=content[3];
    modes++;
  }else if(modes==2){
    firstline=content[4];
    secondline=content[5];
    modes++;
  }else if(modes==3){
    firstline=content[6];
    secondline=content[7];
    modes++;
  }else if(modes==4){
    firstline=content[8];
    secondline=content[9];
    modes=0;
  }
    lcd.begin(16, 2);
    lcd.print(firstline);
    lcd.setCursor(0, 1);
    lcd.print(secondline);
 }
 if(k%10000==0)
   {
    if (DHTLIB_OK == DHT11.read(tempera))
      {
          humi=DHT11.humidity;
          temp=DHT11.temperature;
          content[0]="HUMI IS "+humi;
          content[1]="TEMP IS "+temp;
      }
   }
   if(k%113==0)
   {
    digitalWrite(trig,1);
    digitalWrite(trig,0);
    Time=pulseIn(echo,HIGH);
    S=Time/58.00;
    content[2]="DISTAN= "+(String)S;
    content[3]="WORKING";
    Serial.println(S);
   }
   if(k%97==0)
  {
    int xyz=digitalRead(xiedu);
  }
  //斜度传感器
  if(k%37==0)
  {
    val=analogRead(potpin);//读取传感器的模拟值并赋值给val
 //Serial.println(val);//显示val 变量数值
 //comdata="the light is"+val;
 if(val<180){
  analogWrite(white,255);// 打开LED 并设置亮度（PWM 输出最大值255）
  content[4]="CAREFUL,NIGHT";
  content[5]="LIGHT IS"+val;
   // delay(1000);
 }else{
   analogWrite(white,0);
   content[4]="NOW IS DAY";
  content[5]="LIGHT IS"+val;
 }
 //光敏电阻
  }
  if(k%223==0)
  {
    buttonState=digitalRead(rentiinpin);
  if(buttonState==HIGH){
    content[6]="SOMEBODY HERE";
    content[7]="CAREFUL";
  analogWrite(red,255);
  wenben0=a0;
  }else{
    content[6]="NOBODY HERE";
    content[7]="......";
  digitalWrite(red,LOW);
  wenben0=a1;
  }
 // Serial.println(buttonState);
 //人体人射电模块
  }
  if(k%23==0)
    SAA1=digitalRead(crash1);
  if(k%29==0)
    SAA2=digitalRead(crash2);
  if(k%31==0)
    SAA3=digitalRead(crash3);
  if(k%37==0)
    SAA4=digitalRead(crash4);
  //delay(1000);
  if((SAA4==0)||(SAA3==0)||(SAA2==0)||(SAA1==0)){
    content[8]="CRASH!";
    content[9]="STOP!STOP!STOP!";
    a=2;
    Serial1.print("@TextToSpeech#");
    Serial1.print(crash[0]);
    Serial1.print('$');
    ////添加语音 遭遇碰撞，请小心
    analogWrite(yellow,255);
  }else{
    content[8]="SAFE";
    content[9]="......";
    digitalWrite(yellow,LOW);
  }
  //碰撞传感器
   //
   k++;
   //
   //
   if((b==0)&&(a!=2))
   {
     while(S<35)
     {
     //  digitalWrite(buzzer,LOW);
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[5]);
      Serial1.print('$');
      delay(5000);
      stopping();
      digitalWrite(trig,1);
    digitalWrite(trig,0);
    Time=pulseIn(echo,HIGH);
    S=Time/58.00;
    if(S>35)
    {
      a=0;
      break;
    }
     //  digitalWrite(buzzer,HIGH);
      ////添加延迟100的语音 前方有障碍，请小心
    //  digitalWrite(buzzer,HIGH);
     }
   }else if((b==1)&&(a!=2)){
    if(S<35)
    {
    //  digitalWrite(buzzer,LOW);
      Serial1.print("@TextToSpeech#");
      Serial1.print(move[5]);
      Serial1.print('$');
      delay(1000);
    //   digitalWrite(buzzer,HIGH);
      ////添加延迟100的语音 前方有障碍，请小心
     mode1();
    }
   }else if((b==2)&&(a!=2))
   {
   // digitalWrite(buzzer,LOW);
    //  digitalWrite(buzzer,HIGH);
    ////添加延迟100的语音 前方有障碍，请小心
     if(S<35){
       Serial1.print("@TextToSpeech#");
      Serial1.print(move[5]);
      Serial1.print('$');
      delay(3000);
       mode2();
    }
   }
   //避障部分
}
void mode1()
{
      a=2;
   //   digitalWrite(buzzer,HIGH);
      delay(2000);
      stopping();
      zuozhuan90();
      for(int j=0;j<100;j++)
      digitalWrite(trig, 1);//置高电平
      delayMicroseconds(15);//延时15us
      digitalWrite(trig, 0);//设为低电平
      Time=pulseIn(echo, HIGH);//用自带的函数采样反馈的高电平的宽度，单位us
      S=Time/58.00;
      a=0;
      if(S>50)
      {
        Serial1.print("@TextToSpeech#");
        Serial1.print(safe[0]);
        Serial1.print('$');
        ////添加延迟100的语音 左前方没有障碍物，即将左转
        return;
      }
      ////////
      youzhuan90();
      youzhuan90();
      digitalWrite(trig, 1);//置高电平
      delayMicroseconds(15);//延时15us
      digitalWrite(trig, 0);//设为低电平
      Time=pulseIn(echo, HIGH);//用自带的函数采样反馈的高电平的宽度，单位us
      S=Time/58.00;
      a=0;
      if(S>50)
      {
        Serial1.print("@TextToSpeech#");
        Serial1.print(safe[1]);
        Serial1.print('$');
        ////添加延迟为100的语音 右前方没有障碍物，即将右转
        return;
      }
      houtui90();
}
void mode2()
{
  k0=0;
  timer=0;

  do
  {
    left();
      Sbefore=S;
      if(k0%11==0)
      {
      digitalWrite(trig,1);
      digitalWrite(trig,0);
      Time=pulseIn(echo,HIGH);
      S=Time/58.00;
      Sk1[k0]=S;
      Timerk1[k0]=timer;
      }
      k0++;
    if(timer>=248)
    {
      a=0;
      return;
    }
  }while((S-Sbefore<=20));
  lefttimer=timer;
  k0=0;
  youzhuanN(lefttimer);
  timer=0;
  i=0;
  do
  {
    right();
      Sbefore=S;
      if(k0%11==0)
      {
      digitalWrite(trig,1);
      digitalWrite(trig,0);
      Time=pulseIn(echo,HIGH);
      S=Time/58.00;
      Sk2[i]=S;
      Timerk2[i]=timer;
      }
      k0++;
    if(timer>=248)
    {
      a=0;
      return;
    }
  }while((S-Sbefore<=20));
  righttimer=timer;
  zuozhuanN(righttimer);
  k0=0;
  timer=0;
  i=0;
  double Smin1,Smin2;
  double Timermin;
  Smin1=Sk1[0];
  for(int i=0;i<100;i++)
  {
    if(Smin1>Sk1[i])Smin1=Sk1[i];
  }
  Smin2=Sk2[0];
  for(int i=0;i<100;i++)
  {
    if(Smin2>Sk2[i])Smin2=Sk2[i];
  }
  if(Smin2<Smin1)
  {
    for(int i=0;i<100;i++)
    {
      if(Sk2[i]==Smin2)Timermin=Timerk2[i];
    }
    zuozhuanN(248-Timermin);
  }else{
    for(int i=0;i<100;i++)
    {
      if(Sk1[i]==Smin1)Timermin=Timerk1[i];
    }
    youzhuanN(248-Timermin);
  }
  a=0;
 
}
void down()
{
  //kaiguan2=1;
    switch(_step){
    case 0:
      //stepperSpeed++;
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);//32A
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
    case 1:
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);//10B
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);//10B
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 2:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 3:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 4:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
    case 5:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
      case 6:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    case 7:
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    default:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
  }
   _step++;
 
  if(_step>7){  _step=0;  }

  delay(stepperSpeed);
} 
    


  void up()
{ 
 // kaiguan2=0;
  switch(_step){
    case 0:
      //stepperSpeed++;
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);//32A
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
    case 1:
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);//10B
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);//10B
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 2:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 3:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 4:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
    case 5:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
      case 6:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    case 7:
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    default:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
  }
    _step--;
 
  if(_step<0){ _step=7;  }
 
  delay(stepperSpeed);

}

void left(){
 // kaiguan2=0;
 timer++;
  switch(_step){
    case 0:
     // stepperSpeed++;
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);//32A
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    case 1:
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);//10B
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);//10B
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    case 2:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    case 3:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
    case 4:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 5:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
      case 6:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 7:
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
    default:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
  }
   _step++;
 
  if(_step>7){  _step=0;  }

  delay(stepperSpeed);
}

void right(){
  timer++;
 //kaiguan2=0;
  switch(_step){
    case 0:
     // stepperSpeed++;
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);//32A
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    case 1:
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);//10B
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);//10B
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    case 2:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, HIGH);
    break;
    case 3:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, HIGH);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
    case 4:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, HIGH);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 5:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, HIGH);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
      case 6:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, HIGH);
      digitalWrite(Pin23, LOW);
    break;
    case 7:
      digitalWrite(Pin0, HIGH);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, HIGH);
      digitalWrite(Pin20, HIGH);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
    default:
      digitalWrite(Pin0, LOW);
      digitalWrite(Pin1, LOW);
      digitalWrite(Pin2, LOW);
      digitalWrite(Pin3, LOW);
      digitalWrite(Pin20, LOW);
      digitalWrite(Pin21, LOW);
      digitalWrite(Pin22, LOW);
      digitalWrite(Pin23, LOW);
    break;
  }
    _step--;
 
  if(_step<0){ _step=7;  }
 
  delay(stepperSpeed);

}
void stopping()
{
  //kaiguan2=0;
   digitalWrite(Pin0, LOW);
   digitalWrite(Pin1, LOW);
   digitalWrite(Pin2, LOW);
   digitalWrite(Pin3, LOW);
   digitalWrite(Pin20, LOW);
   digitalWrite(Pin21, LOW);
   digitalWrite(Pin22, LOW);
   digitalWrite(Pin23, LOW);
}
void zuozhuan45()
{
  for(m=0;m<CLOCK/2;m++)
  {
    left();
  }
  a=2;
}
void zuozhuan90()
{
  for(m=0;m<CLOCK;m++)
  {
    left();
  }
  a=2;
}
void youzhuan45()
{
  for(m=0;m<CLOCK/2;m++)
  {
    right();
  }
  a=2;
}

void youzhuan90()
{
  for(m=0;m<CLOCK;m++)
  {
    right();
  }
  a=2;
}
void zuozhuanN(int n)
{
  for(m=0;m<n;m++)
  {
    left();
  }
}
void youzhuanN(int n)
{
  for(m=0;m<n;m++)
  {
    right();
  }
}
void houtui90()
{
  for(m=0;m<CLOCK/10;m++)
  {
    down();
  }
  a=2;
}

void qianjin90()
{
  for(m=0;m<CLOCK/10;m++)
  {
    up();
  }
  a=2;
}
