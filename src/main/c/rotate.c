#include <stdio.h>
#include <stdlib.h>

#define N 5
int ** create()
{
    int ** matrix;
    int i, j;
    matrix = (int **) malloc (sizeof(int *) * N);
    for (i = 0; i < N; i++)
    {
        matrix[i] = (int *) malloc (sizeof(int) * N);
    }

    for (i = 0; i < N; i++)
        for(j = 0; j < N; j++)
        {
            if ( i < j && j < N - i - 1)
                matrix[i][j] = 1;
            else if ( N - i <= j && j < i)
                matrix[i][j] = 3;
            else if ( j < i && i < N - j - 1)
                matrix[i][j] = 2;
            else if ( N - j <= i && i < j)
                matrix[i][j] = 4;
            else matrix[i][j] = 0;
        }

    return matrix;
}
void print(int ** matrix)
{
    int i,j;
    for (i = 0; i < N; i++)
    {
        for(j = 0; j < N; j++)
            printf("%d ", matrix[i][j]);
        printf("\n");
    }
}

void rotate(int **matrix)
{
    int j,i, first, last, offset;
    int tmp;

    for (j = 0; j < N/2; j++){
        first = j;
        last = N - 1 - j;
        for (i = first; i < last; i++) {
            offset = i - first;
            tmp = matrix[first][i];
            matrix[first][i] = matrix[last-offset][first];
            matrix[last-offset][first] = matrix[last][last-offset];
            matrix[last][last-offset] = matrix[i][last];
            matrix[i][last] = tmp;
        }
    }
}
int main()
{
    int ** matrix = create();
    print(matrix);
    rotate(matrix);
    printf("_________\n");
    print(matrix);
    return 0;
}
