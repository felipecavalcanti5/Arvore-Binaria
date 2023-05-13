/*
A árvore binária tem a função de agilizar o acesso a elementos de um banco de dados. Funciona da seguinte maneira:
é primeiro criada a raiz da árvore, que será o primeiro número posto. À medida em que forem sendo inseridos novos
números, o código irá verificar se aquele número é maior ou menor que a raiz. Em caso afirmativo, esse número será
colocado abaixo e à direita da raiz. Se o número for menor, ficará abaixo e à esquerda. Quanto mais números haver na
árvore, essa verificação se repetirá sempre em relação aos números anteriores, de modo a "encurtar" o caminho para
encontrar um número específico da árvore.
*/

class No {
    int valor;
    No esquerda;
    No direita;

    No(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}

class ArvoreBinaria {
    No raiz;

    ArvoreBinaria() {
        raiz = null;
    }

    void inserir(int valor) {
        No no = new No(valor);
        if (raiz == null) {
            raiz = no;
        } else {
            _inserir(no, raiz);
        }
    }

    void _inserir(No no, No atual) {
        if (no.valor < atual.valor) {
            if (atual.esquerda == null) {
                atual.esquerda = no;
            } else {
                _inserir(no, atual.esquerda);
            }
        } else if (no.valor > atual.valor) {
            if (atual.direita == null) {
                atual.direita = no;
            } else {
                _inserir(no, atual.direita);
            }
        }
    }

    void emOrdem() {
        _emOrdem(raiz);
    }

    void _emOrdem(No atual) {
        if (atual != null) {
            _emOrdem(atual.esquerda);
            System.out.print(atual.valor + " ");
            _emOrdem(atual.direita);
        }
    }
    void mostrarArvore() {
        mostrarArvoreRecursivo(raiz, 0);
    }

    void mostrarArvoreRecursivo(No atual, int nivel) {
        if (atual == null) {
            return;
        }

        mostrarArvoreRecursivo(atual.direita, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }

        System.out.println(atual.valor);

        mostrarArvoreRecursivo(atual.esquerda, nivel + 1);
    }
}