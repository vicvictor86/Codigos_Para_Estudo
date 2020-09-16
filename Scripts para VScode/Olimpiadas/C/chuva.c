#include <stdio.h>

int main()
{
    int n, m;
    char simbolo;
    char simbolos[505][505];

    scanf("%d%d", &n, &m);

    //entrada
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            scanf(" %c", &simbolos[i][j]);           
        }
        
    }

    

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){

            
                //if(i > 0){
                    if(simbolos[i][j] == '.' && simbolos[i - 1][j] == 'o'){
                    simbolos[i][j] = 'o';
                    }
                //}
                
                //if(j > 0){
                    if(simbolos[i][j] == '.' && simbolos[i][j-1] == 'o' && simbolos[i+1][j-1] == '#'){
                    simbolos[i][j] = 'o';
                    }
               // }
                //if(j > 0 && i + 1 != n){
                    if(simbolos[i][j] == '.' && simbolos[i][j+1] == 'o' && simbolos[i+1][j-1] == '#'){
                    simbolos[i][j] = 'o';
                    }
                //}
                
               // if(j + 1 != m && i + 1 != n){
                    if(simbolos[i][j] == '.' && simbolos[i][j+1] == 'o' && simbolos[i+1][j+1] == '#'){
                        simbolos[i][j] = 'o';
                    }
                //}
                
            
            

            printf("%c", simbolos[i][j]);
            if(j == m - 1){
                printf("\n");
            }
            
        }
        
    }
    

}

/*
    # -> prateleira apenas números pares e nunca encosta nas bordas
    . -> parede
    o -> agua e só poder ter um na primeira linha

    se c(i,j) = . ele deve virar 'o' sempre que
    c(i-1, j) = '0'ou 
    c(i,j-1)= "o" e c(i+1,j-1)= "#" ou
    c(i,j+1)= "o" e c(i+1,j+1)= "#".
*/