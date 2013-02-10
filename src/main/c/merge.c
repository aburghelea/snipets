#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define N 10
#define M 7

void gen(int **array, int size, int buffer)
{
    *array = malloc( (size + buffer) * sizeof(int) );
    int i;
    int prev = 0;
    for(i = 0; i < size; i++)
    {
        (*array)[i] = prev + (rand() % 3 + 1);
        prev = (*array)[i];

    }
}

void print(int *array, int size)
{
    int i;

    for(i = 0; i<size; i++)
    {
        printf("%d ",array[i]);
    }
    printf("\n");

}

void merge(int *A, int n, int *B, int m)
{
    int i = N+M-1;
    n--;
    m--;
    while(n > 0 && m > 0)
    {
        if (A[n] > B[m])
        {
            A[i--] = A[n--];
            printf("A %d\n", n);
        }
        else
        {
            A[i--] = B[m--];
            printf("B %d\n", n);
        }
    }

    while (n > 0)
        A[i--] = A[n--];

    while (m > 0)
        A[i--] = B[m--];

}

int main()
{

    srand( time (NULL) );
    int *A, *B;
    gen(&A, N, M);
    gen(&B, M, 0);

    print(A, N);


    print(B, M);

    merge(A, N, B, M);

    print(A, N + M);
}

