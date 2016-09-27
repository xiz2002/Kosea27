#include <stdio.h>
#include <stdlib.h>

void main() {
	char chX[] = { 'A', 'B', 'C', 'D' };
	char chY[] = { 'a', 'b', 'c', 'd' };
	char* chpZ;

	chpZ = (char*) malloc((int) (sizeof(chX) + sizeof(chY)) * sizeof(char));

	if (chpZ == NULL) {
		printf("Out of Memory\n");
		exit(0);
	}

	for (int i = 0; i < sizeof(chX) / sizeof(char); i++) {
		chpZ[i] = chX[i];
	}

	for (int i = 0; i < sizeof(chY) / sizeof(char); i++) {
		chpZ[sizeof(chX) + i] = chY[i];
	}

	for (int i = 0; i < sizeof(chpZ) / sizeof(char); i++) {
		printf("%c", chpZ[i]);
	}
	printf("\n");
}
