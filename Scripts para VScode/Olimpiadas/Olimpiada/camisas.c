#include<stdio.h>

int main(){

    int N, T[1000], P, M, quant1 = 0, quant2 = 0;
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf(" %d", &T[i]);
        if(T[i] == 1){
            quant1 += 1; 
        }
        else if(T[i] == 2){
            quant2 += 1;
        }
    }

    scanf("%d", &P);
    scanf("%d", &M);

    if(quant1 <= P && quant2 <= M){
        printf("S\n");
    }
    else{
        printf("N\n");
    }

    return 0;
}