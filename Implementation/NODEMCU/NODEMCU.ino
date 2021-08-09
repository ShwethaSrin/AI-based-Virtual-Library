#include <ESP8266WiFi.h>
#define NAME "vivo 1724"
#define PASS "shwetha@12"
String data1="";
const char* host = "192.168.43.252";
WiFiClient client;
 String dd="";
void setup() {
  Serial.begin(9600);
  while (!Serial) continue;
  WiFi.mode(WIFI_STA);
  WiFi.begin(NAME, PASS);
  Serial.print("Connecting");
  while(WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println();

  Serial.print("Connected, IP ahddress: ");
  Serial.println(WiFi.localIP());
}
 
void loop() {
Serial.println("Waiting for data");
  if(Serial.available())
 {
  
  while(Serial.available())
  {
   delay(3);
   char data = Serial.read();
   data1 += data; 
  }
 }
 if(data1!=0)
 {
  
  Serial.println(data1);
if (client.connect(host, 8000))
  {
    Serial.print("Connected to: ");
    Serial.println(host);
    Serial.println("sending");
   // Serial.println(data1);
    client.println(data1); 
    delay(1000);
    data1="";
    client.stop();
  }
  }
  client.stop();
  delay(1000);
 }
