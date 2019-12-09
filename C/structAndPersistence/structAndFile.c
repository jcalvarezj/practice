#include <stdlib.h>
#include <stdio.h>

struct Persona {
	char nombre[50];
	int edad;
};

int main(int argc, char ** args) {
	struct Persona registro;

	printf("Ingrese nombre de la persona:\n");
	gets(registro.nombre);

	printf("Ingrese edad: ");
	scanf("%i",&registro.edad);

	printf("\nLa persona es %s de %i años\n",registro.nombre,registro.edad);

	FILE * archivo = fopen("datos1.dat","wb");

	if(archivo != NULL)
		fwrite(&registro,sizeof(registro),1,archivo);
	else
		printf("El archivo no se pudo crear\n");

	fclose(archivo);

	printf("Ahora se intenta leer de otro ejemplo...\n");

	archivo = fopen("datos2.dat","rb");

	if(archivo != NULL) {
		fread(&registro,sizeof(registro),1,archivo);
		printf("Se ha leido a %s de %i años\n",registro.nombre,registro.edad);
	}
	else
		printf("El archivo no se pudo abrir\n");

	fclose(archivo);

	return 0;
}

