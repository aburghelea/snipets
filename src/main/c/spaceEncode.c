#include <stdlib.h>
#include <string.h>
#include <stdio.h>

void encode(char ** sentence)
{
    int length = strlen(*sentence);
    int i, spaces = 0;
    for(i = 0; i < length; i++)
    {
        if ((*sentence)[i] == ' ')
            spaces++;
    }

    int newEnd = length + spaces * 2 ;
    *sentence = realloc (*sentence, sizeof(char) * (newEnd+ 1));
    (*sentence)[newEnd] = 0;
    printf("%d spaces\n", spaces);
    for (i = length - 1; i >= 0 ; i--) {
        if ((*sentence)[i] == ' '){
            (*sentence)[newEnd-1]='0';
            (*sentence)[newEnd-2]='2';
            (*sentence)[newEnd-3]='%';
            newEnd -= 3;
        } else {
            (*sentence)[newEnd-1]=(*sentence)[i];
            newEnd -= 1;
        }
    }

}
int main()
{
    char* sentence = strdup("Aceasta propozitie va fi mai aproape de HTML");
    encode(&sentence);
    printf("%s\n",sentence);
}
