# Gestão de Funcionários
O objetivo deste exercício é desenvolver um sistema em Java para gerenciar funcionários, utilizando o padrão de projeto Model-View-Presenter (MVP) em sua variante Passive View.

# V1

`COD_ATIVIDADE = FuncionarioMVP_V1`

## Requisitos

- [ ] Este exercício deve ser realizado em dupla
- [x] Configuração do Projeto: O projeto deve ser um projeto Maven e deve utilizar a versão 17 do Java.
- [x] Model: Crie uma classe Funcionario para representar um funcionário e uma classe FuncionarioCollection para manter os registros de funcionários em memória.
- [x] Views: Utilize Swing para criar as seguintes interfaces gráficas:
  - [x] Tela Principal: Interface com um menu que permite o acesso às opções de inclusão e consulta de funcionários.
  - [x] Tela de Inclusão: Interface que permite a entrada de dados para incluir um novo funcionário.
  - [x] Tela de Consulta: Interface com um JTable que lista os funcionários cadastrados.
  - [x] Tela de Visualização: Utilize a mesma interface da tela de inclusão, mas prepare-a para apenas visualizar registros, sem permitir modificações.
- [x] Presenter: Desenvolva classes Presenter correspondentes para gerenciar a lógica de negócio para cada uma das telas.
- [x] Demais requisitos de entrega estão em anexo, não é necessário fazer o Relatório Técnico.

## Funcionalidades

- [x] Inclusão de Funcionários: A partir da Tela Principal, o usuário deve poder acessar a Tela de Inclusão para cadastrar um novo funcionário.
- [x] Consulta de Funcionários: A partir da Tela Principal, o usuário deve poder acessar a Tela de Consulta para visualizar os funcionários cadastrados em um JTable.
- [ ] Visualização de Funcionários: Na Tela de Consulta, o usuário deve poder clicar em uma linha do JTable correspondente a um funcionário e, em seguida, clicar em um botão "Visualizar" para acessar a Tela de Visualização.

## Desafio Opicional

- [x] Remoção de Funcionários: Se desejado, implemente a funcionalidade de remoção de funcionários, que pode ser feita tanto na Tela de Visualização quanto na Tela de Consulta.

# Orientações

- Utilize nomenclatura em português do Brasil para identificadores de código, conforme solicitado.
- Mantenha o código-fonte aderente a boas práticas de desenvolvimento..
- Todos os princípios de projeto e design patterns aplicáveis vistos em sala de aula devem ser rigorosamente considerados, incluindo o tratamento adequado de exceções.
