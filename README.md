# POOFoodTruck
## Projeto da Disciplina de Programação Orientada a Objeto
### Quesitos a serem avaliados:

- [ ] Modelagem de classes com herança
- [x] Polimorfismo entre classes
     - [x] Sobrescrita (*@Override*) de métodos
     - [x] Referências polimórficas
     - [x] Controle de repetição usado em coleção de objetos (ArrayList)
- [x] Gravação e recuperação de objetos em arquivo
- [ ] Utilização da estrutura switch para controle de menu de opções
- [x] Utilização de tratamento de exceções para manipulação de arquivos
- [ ] Interface gráfica

### Descritivo do projeto

Trata-se de um sistema para gerenciamento de cardápio e pedidos de um *FoodTruck*.

A partir da tela inicial, será possível consultar os **itens** do **cardápio**, que poderão ser de 3 tipos: **Lanche**, **Bebida** ou **Acompanhamento**. Também será possível inserir novos itens no cardápio, gravá-lo em um arquivo e recuperá-lo do mesmo arquivo a fim de que exista permanência dos dados.

O sistema deve permitir, a partir da tela inicial, lançar um novo **pedido**. O pedido é composto de um ou mais itens do cardápio, associado a uma quantidade e uma observação. O pedido deve ter um **status** associado a ele:
1. **Lançado** - Quando o pedido é cadastrado e enviado para a cozinha;
2. **Preparando** - Quando a cozinha já iniciou o preparo do pedido;
3. **Pronto** - A cozinha concluiu o preparo e o mesmo encontra-se disponível para retirada;
4. **Entregue** - Pedido entregue para o cliente.

### Exemplos
#### Cardápio
 ```
                   Lanches

   7. X-burger                       R$ 15,00 (Pão francês, queijo mussarela e hambúrger de 200g)
   8. X-salada                       R$ 17,00 (Pão francês, queijo mussarela, salada e hambúrger de 200g)
   9. duplo X-burger                 R$ 20,00 (Pão francês, queijo mussarela e dois hambúrgeres de 200g)
  10. Hot Dog                        R$ 13,00 (Pão especial, salsicha, molho)

                     Bebidas

   2. Coca-cola 500                  R$ 10,00
   3. Sprite 500                     R$ 10,00
   4. Chopp IPA 700                  R$ 25,00
   5. Chopp Lager 700                R$ 20,00
   6. Chopp Pale Ale 700             R$ 20,00

             Acompanhamentos

  11. Batatas rústicas               R$ 12,00 ( Porção de 200g)
  12. Onion rings                    R$ 18,00 ( Porção de 200g)
  13. Mini pastéis                   R$ 20,00 (    10 unidades)

 ```
#### Pedido
```
Status: Preparando
Item		Quantidade		Obs
7			1				Sem cebola
5			2
```
### Diagrama de Classes
![POOFoodTruck](/assets/PUCPOOFoodTruck.drawio.png)