## Structural Test

### Primeira branch
```java
if (palavra == null || palavra.isBlank()) {
        return false;
        }
```

#### Aplicando MC/DC
|Testes|A|B|A OR B|
|:-:|:-:|:-:|:-:|
|1|V|V|V|
|2|V|F|V|
|3|F|V|V|
|4|F|F|F|

A(2,4)
2-> Estado inicial do A
4-> Quando A flipa e altera valor do resultado

B(3,4)
3-> Estado inicial do B
4-> Quando B flipa e altera valor do resultado

#### Testes a serem realizados para validar primeira branch
2 - Palavra nula -> A(2)
3 - Palavra em branco -> B(3)
4 - Palavra válida -> A(4) B(4)

obs: Não é possível passar uma palavra nula e em branco ao mesmo tempo (apenas um parâmetro)

### Segunda branch
```java
if (indexDaPontaDireitaDoArray > 0 && letraAtualDaPontaEsquerda == letraAtualDaPontaDireita) {
    return isPalindromoRecursive(palavra, indexDaPontaEsquerdaDoArray + 1, indexDaPontaDireitaDoArray - 1);
}
```

#### Aplicando MC/DC
|Testes|A|B|A && B|
|:-:|:-:|:-:|:-:|
|1|V|V|V|
|2|V|F|F|
|3|F|V|F|
|4|F|F|F|

A(1,3)
1 -> Estado inicial de A
3 -> Quando A flipa e altera o valor do resultado

B(1,2)
1 -> Estado inicial de B
2 -> Quando B flipa e altera o valor do resultado

#### Testes a serem realizados para validar segunda branch
1 -> Index da ponta direita do array MAIOR que zero e letra da ponta esquerda IGUAL à letra da ponta direita -> A(1) B(1)  
2 -> Index da ponta direita do array MAIOR que zero e letra da ponta esquerda DIFERENTE da letra da ponta direita -> B(2)  
3 -> Index da ponta direita do array MENOR ou IGUAL a zero e letra da ponta esquerda IGUAL à letra da ponta direita -> A(3)  


