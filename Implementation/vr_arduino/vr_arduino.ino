

const int buttonPin1 = 2;  
const int buttonPin2 = 3;
const int buttonPin3 = 4;
const int buttonPin4 = 5;
const int buttonPin5 = 6;
const int buttonPin6 = 7;
boolean buttonState1 = 0;
boolean buttonState2 = 0;
boolean buttonState3 = 0;
boolean buttonState4 = 0;
boolean buttonState5 = 0;
boolean buttonState6 = 0;

void setup()
{

 pinMode(buttonPin1, INPUT_PULLUP);
 pinMode(buttonPin2, INPUT_PULLUP);
 pinMode(buttonPin3, INPUT_PULLUP);
 pinMode(buttonPin4, INPUT_PULLUP);
  pinMode(buttonPin5, INPUT_PULLUP);
   pinMode(buttonPin6, INPUT_PULLUP);
 Serial.begin(9600);

}
void loop()
{
  buttonState1 = digitalRead(buttonPin1);
  buttonState2 = digitalRead(buttonPin2);
  buttonState3 = digitalRead(buttonPin3);
  buttonState4 = digitalRead(buttonPin4);
  buttonState5 = digitalRead(buttonPin5); 
  buttonState6 = digitalRead(buttonPin6);   

if(buttonState1==0)
{
  Serial.println("a");
}
if(buttonState2==0)
{
  Serial.println("d");
}
if(buttonState3==0)
{
  Serial.println("w");
}
if(buttonState4==0)
{
  Serial.println("s");
}
if(buttonState5==0)
{
  Serial.println("l");
}
if(buttonState6==0)
{
  Serial.println("r");
}
 delay(1000);
 }
 
