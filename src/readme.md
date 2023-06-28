Os tipos de embarcações são:
Um único porta-avião que ocupa cinco posições do 
tabuleiro,
Dois navios-tanque onde cada um
ocupa quatro posições do tabuleiro,
Três contra-torpedeiros que ocupam três posições 
do tabuleiro, e
Quatro submarinos onde cada um ocupa duas
posições do tabuleiro.

As posições que compõem um
embarcação deve estar conectados e linha reta em uma linha ou uma coluna

O tabuleiro que representa o mar tem tamanho 
10x10 de dimensão,

Faça um código Java que leia o arquivo csv 
com a posicao das embarcações e carregue em uma lista que contem o tipo da embarcação, linha que esta posicionada e coluna posicionada.

Depois de carregar a lista o programa deve validar se a quantidade de embarcações esta correta para cada tipo.

PortaAvião, 0, 0
NavioTanque, 1, 1
NavioTanque, 2, 0
ContraTorpedeiro, 3, 0
ContraTorpedeiro, 4, 0
ContraTorpedeiro, 5, 0
Submarino, 6, 0
Submarino, 7, 0
Submarino, 8, 0
Submarino, 9, 0

O programa deve seguir os principios do Solid e existir
um tipo de classe Abstrata chamada Embarcacao do
qual cada classe filha
(PortaAvião (P), NavioTanque (N), ContraTorpedeiro 
(C),Submarino (S)) deve herdar. As classes f
ilhas possuem linha inicial e
coluna inicial e um caracter que sera 
usado futuramente.

Arrumar bug de quando todas as embarcações são atingidas, o jogo não acaba//Corrigido!!!
Arrumar bug do placar;//Em desenvolvimento;
Arrumar para visualizar toda vez que o usuário fazer um posicionamento de embarcação;//Em desenvolvimento;
Implementar escolha de posicionamento vertical e horizontal;//Em desenvolvimento;
Arrumar bug de quando o usuário digitar uma posição que já foi atingida, o jogo não conta como jogada e pede pra jogar novamente;
Arrumar bug de quando o usuário digitar uma posição que não existe, o jogo não conta como jogada e pede pra jogar novamente;


