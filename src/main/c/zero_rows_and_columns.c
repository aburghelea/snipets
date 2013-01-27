#include <stdlib.h>
#include <stdio.h>

#define N 5
#define M 10
void print(int ** matrix)
{
    int i,j;
    for (i = 0; i < N; i++)
    {
        for (j = 0; j < M; j++)
            if (matrix[i][j]== 0)
                printf(" * |");
            else
                printf("   |");
        printf("\n");
    }
}

void create(int ** matrix)
{
    int i, j;

    for (i = 0; i < N; i++)
        for (j = 0; j < M; j++)
        {
            if (i % 2)
                matrix[i][j] = i*j;
            if (j % 2 == 0)
                matrix[i][j] = j+3;
        }
}

void normalize(int ** matrix)
{
    char * rowMark = calloc(N, sizeof(char));
    char * columnMark = calloc(M, sizeof(char));
    int i, j;
    //checking witch rows and columns to zerolize
    for (i = 0; i < N ; i ++)
        for (j = 0 ; j < M; j++)
            if (matrix[i][j] == 0)
            {
                rowMark[i] = 1;
                columnMark[j] = 1;
            }

    //zerolize rows
    for (i = 0; i < N ; i ++)
        if (rowMark[i] == 1)
            for (j = 0 ; j < M; j++)
                matrix[i][j] = 0;
    //zerolize columns
    for (j = 0 ; j < M; j++)
        if (columnMark[j] == 1)
            for (i = 0; i < N ; i ++)
                matrix[i][j] = 0;


}
int main()
{
    int ** matrix, i, j;
    matrix = (int **) calloc(N, sizeof(int*));
    for (i = 0; i < N; i++)
        matrix[i] = (int *) calloc(M, sizeof(int));
    create(matrix);
    print(matrix);
    printf("------------\n");
    normalize(matrix);
    print(matrix);
}
