#define SAIDA0 10
#define SAIDA1 11
#define SAIDA2 12
#define SAIDA3 13
#define INA0 2
#define INA1 3
#define INA2 4
#define INA3 5
#define INB0 6
#define INB1 7
#define INB2 8
#define INB3 9

int soma(int inputA, int inputB, int valorTS, int saida)
{
  int s, s1, s2, s3, s4, s5, s6; 
  s1 = (digitalRead(inputA) ^ digitalRead(inputB));
  s2 = s1 ^ valorTS;
  s3 = digitalRead(inputB) && valorTS;
  s4 = valorTS && digitalRead(inputA);
  s5 = digitalRead(inputA) && digitalRead(inputB);
  s6 = s3 || s4 || s5;
  s = s2;
  digitalWrite(saida, s);
  return s6;
}

void setup()
{ 
  pinMode(SAIDA0, OUTPUT);
  pinMode(SAIDA1, OUTPUT);
  pinMode(SAIDA2, OUTPUT);
  pinMode(SAIDA3, OUTPUT);
  pinMode(INA0, INPUT);
  pinMode(INA1, INPUT);
  pinMode(INA2, INPUT);
  pinMode(INA3, INPUT);
  pinMode(INB0, INPUT);
  pinMode(INB1, INPUT);
  pinMode(INB2, INPUT);
  pinMode(INB3, INPUT);
}

void loop()
{
  int ts0 = 0, ts1 = 0, ts2 = 0, ts3 = 0;
  
  ts0 = soma(INA0, INB0, 0, SAIDA0);
  ts1 = soma(INA1, INB1, ts0, SAIDA1);
  ts2 = soma(INA2, INB2, ts1, SAIDA2);
  ts3 = soma(INA3, INB3, ts2, SAIDA3);
}