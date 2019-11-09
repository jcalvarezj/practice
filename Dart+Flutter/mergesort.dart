/*
 * Ejemplo de implementación de Merge Sort
 * @author J. Alvarez
 */

void main() {
  var ages = [33, 15, 27, 40, 22];
  var total = 0;
  ordenar(ages,0,ages.length-1);
  print("Ordenado queda: $ages");
  print("La edad menor es: ${ages[0]}; la edad mayor es: ${ages[ages.length-1]}");

  ages.forEach((age) => total+=age);
  print("La edad promedio es: ${total/ages.length}");
}

void ordenar(var arreglo, var i, var j) {
  var n = j-i+1;
  if (n > 1) {
    print("Resolviendo para el ambiente: ${arreglo.sublist(i,j+1)} porque i: $i y j: $j");
    if (n == 2) {
      if (arreglo[j] < arreglo[i]) {
        var auxiliar = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = auxiliar;
      }
      print("Se ha ordenado la porción: ${arreglo.sublist(i,j+1)}");
    }
    else {
      var inicioIzq = i;
      var inicioDer = i+(n~/2);

      ordenar(arreglo, i, inicioDer-1);
      ordenar(arreglo, inicioDer, j);

      mezcla(arreglo, inicioIzq, inicioDer, j);

      print("Se ha mezclado la porción: ${arreglo.sublist(i,j+1)}");
    }
  }
}

void mezcla(var arreglo, var inicioIzq, var inicioDer, var fin) {
  var i = inicioIzq;
  var j = inicioDer;
  var k = inicioIzq;

  var mezclado = [];

  while(k <= fin) {
    if (i < inicioDer && (j > fin || arreglo[i] <= arreglo[j])) {
      mezclado.add(arreglo[i]);
      i++;
    }
    else {
      mezclado.add(arreglo[j]);
      j++;
    }
    k++;
  }

  k = inicioIzq;

  for(i = 0; i < mezclado.length; i++) {
    arreglo[k] = mezclado[i];
    k++;
  }
}