#include <stdio.h>
#define CLIENTES 10

int main(){

    float  total, media, porcentagemdevedor;
    int devedor = 0, credor = 0;

    for (int i = 1; i <= CLIENTES; i++)
    {
        
        float saldo;
        printf("Digite a saldo do %d membro: ", i);
        scanf("%f", &saldo);

        total += saldo;

        //Testa se o cliente é devedor ou credor
        saldo <= 0.0 ? devedor++ : credor++;

    }

    media = total / CLIENTES;
    porcentagemdevedor = (devedor * 100.0) / CLIENTES;
    
    printf("O saldo medio dos clientes e: %.2f\nClientes com saldo devedor(Em porcentagem): %.2f\n", media, porcentagemdevedor);
    printf("O numero de clientes com saldo credor: %d.\n", credor);

    return 0;

}