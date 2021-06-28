#define INA0 2
#define INA1 3
#define INA2 4
#define INA3 5
#define INB0 6
#define INB1 7
#define INB2 8
#define INB3 9
#define LATCHPIN 11     
#define CLOCKPIN 12      
#define DATAPIN 10
#define DATAPIN2 13

void updateShiftRegister(int DATAPIN, int valor)
{
   digitalWrite(LATCHPIN, LOW);
   shiftOut(DATAPIN, CLOCKPIN, LSBFIRST, valor); 
   digitalWrite(LATCHPIN, HIGH);
}

int converterBinDec(int *saidaHX) {
  int num = 0;
  for(int i = 0; i < 7; i++) {
    if(saidaHX[i] == 1) {
      int p = 1;
      for(int j = 1; j <= i; j++) {
        p *= 2;
      }
      num += p;
    }
  }
  return num;
}

void soma(int inputA, int inputB, int valorTS, int bitAtual, int* carryover, int* saidasomador)
{
  int s, s1, s2, s3, s4, s5, s6; 
  
  s1 = (digitalRead(inputA) ^ digitalRead(inputB));
  s2 = s1 ^ valorTS;
  s3 = digitalRead(inputB) && valorTS;
  s4 = valorTS && digitalRead(inputA);
  s5 = digitalRead(inputA) && digitalRead(inputB);
  s6 = s3 || s4 || s5;
  s = s2;
  
  saidasomador[bitAtual] = s;
  carryover[bitAtual] = s6;
  
}

void decodificar(int *inputs, int *saidaHx)
{ 
  	saidaHx[0] = (!inputs[0] && !inputs[2]) || (inputs[2] && inputs[1]) || (!inputs[3] && inputs[1]) || (inputs[3] && !inputs[0]) || (!inputs[3] && inputs[2] && inputs[0]) || (inputs[3] && !inputs[2] && !inputs[1]);
  	saidaHx[1] = (!inputs[2] && !inputs[1]) || (!inputs[2] && !inputs[0]) || (!inputs[3] && !inputs[2]) || (!inputs[3] && !inputs[1] && !inputs[0]) || (inputs[3] && !inputs[1] && inputs[0]) || (!inputs[3] && inputs[1] && inputs[0]);
    saidaHx[2] = (!inputs[3] && !inputs[1]) || (!inputs[3] && inputs[0]) || (!inputs[3] && inputs[2]) || (!inputs[1] && inputs[0]) || (inputs[3] && !inputs[2]);
    saidaHx[3] = (inputs[3] && !inputs[1]) || (!inputs[3] && !inputs[2] && !inputs[0]) || (inputs[2] && !inputs[1] && inputs[0]) || (!inputs[2] && inputs[1] && inputs[0]) || (inputs[2] && inputs[1] && !inputs[0]);  
    saidaHx[4] = (!inputs[2] && !inputs[0]) || (inputs[3] && inputs[1]) || (inputs[3] && inputs[2]) || (inputs[1] && !inputs[0]);
    saidaHx[5] = (inputs[3] && !inputs[2]) || (!inputs[1] && !inputs[0]) || (inputs[2] && !inputs[0]) || (inputs[3] && inputs[1]) || (!inputs[3] && inputs[2] && !inputs[1]);
    saidaHx[6] = (inputs[3] && !inputs[2]) || (inputs[3] && inputs[0]) || (!inputs[2] && inputs[1]) || (inputs[1] && !inputs[0]) || (!inputs[3] && inputs[2] && !inputs[1]);
}

int carryOverCalculo(int* carryOver){
  if(carryOver[2] == 1){
  	return 6;
  }
  return 63;
}

void setup()
{ 
  Serial.begin(9600);
  pinMode(LATCHPIN, OUTPUT);
  pinMode(CLOCKPIN, OUTPUT);
  pinMode(DATAPIN, OUTPUT);
  pinMode(DATAPIN2, OUTPUT);
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
  int saidaSomador[4];
  int carryOver[3];
  int saidaHx[7];
  
  soma(INA0, INB0, 0, 0, carryOver, saidaSomador);
  soma(INA1, INB1, carryOver[0], 1, carryOver, saidaSomador);
  soma(INA2, INB2, carryOver[1], 2, carryOver, saidaSomador);
  soma(INA3, INB3, carryOver[2], 3, carryOver, saidaSomador);
 
  decodificar(saidaSomador, saidaHx);
  int answer = converterBinDec(saidaHx);
  int answer2 = carryOverCalculo(carryOver);
 
  updateShiftRegister(DATAPIN, answer);
  updateShiftRegister(DATAPIN2, answer2);
  
}