#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void reverse(char* string)
{
    char* end = string;
    char* str = string;
    char tmp;

    unsigned int length = strlen(string);
    if (string == NULL)
        return;

    while (*end)
        end++;
    end--;

    while(str < end)
    {
        tmp = *str;
        *str = *end;
        *end = tmp;
        str++;
        end--;
    }
    printf("___\n");
}

int main()
{
    char* string = strdup("gigel");
    char* second_s = strdup("1");

    reverse(string);
    printf("%s\n", string);
    reverse(second_s);
    printf("%s\n", second_s);
    return 0;
}

