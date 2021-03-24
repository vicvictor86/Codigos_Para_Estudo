#include <stdio.h>
#include <time.h>

struct Date
{
    int dia;
    int mes;
    int ano;
};
//Faz com que n precisa escrever toda vez struct Date podendo ser subtituido apenas por Date
typedef struct Date Date;

Date dataataual()
{
    Date datadeagora;
    //Pegar a data atual
    time_t mytime;
    mytime = time(NULL);
    struct tm tm = *localtime(&mytime);
    //Preenchimento dos campos da struct date
    datadeagora.dia = tm.tm_mday;
    datadeagora.mes = tm.tm_mon + 1;
    datadeagora.ano = tm.tm_year + 1900;

    return datadeagora;
}

int diasnomes(int mes, int ano)
{
    //Meses com 31 dias
    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
    {
        return 31;
    }
    //Meses com 30 dias
    else if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
    {
        return 30;
    }
    else
    {
        //Testa se o ano é bissexto
        if (ano % 4 == 0 || ano % 100 == 0 || ano % 400 == 0)
        {
            return 29;
        }
        else
        {
            return 28;
        }
    }
}

Date adicionardias(int diasadicionais, struct Date dataatual)
{
    dataatual.dia += diasadicionais;
    //verificar a quantidade de dias no mes
    while(dataatual.dia > diasnomes(dataatual.mes, dataatual.ano)) 
    {
        //Enquanto a quantidade de dias for maior que 31 ele vai subtrair os dias para tentar 
        //Chegar na data real e vai entender que se passou um mes
        dataatual.dia -= diasnomes(dataatual.mes, dataatual.ano);
        dataatual.mes++;
    }

    while(dataatual.mes > 12)
    {
        //A cada vez que precisar subtrair 12 meses quer dizer que se passou um ano
        dataatual.mes -= 12;
        dataatual.ano++;
    }
    
    //Retorna a struct com dia mes e ano
    return dataatual;
}

int main()
{
    Date dataatual = dataataual();
    dataatual = adicionardias(45, dataatual);
    printf("Data: %d/%d/%d\n", dataatual.dia, dataatual.mes, dataatual.ano);

    return 0;
}