# Task Manager

Projeto CLI em Java desenvolvido como exercício de aprendizado de POO, com foco em boas práticas de organização de código e conceitos fundamentais do desenvolvimento orientado a objetos.

## Sobre o projeto

O Task Manager é um gerenciador de tarefas que roda no console. As tarefas são armazenadas em memória durante a execução do programa. O projeto foi construído de forma incremental, introduzindo novos conceitos a cada etapa.

## Funcionalidades

- Adicionar tarefa comum
- Adicionar tarefa urgente (vai automaticamente para o topo da lista)
- Listar tarefas com status de conclusão
- Marcar tarefa como concluída
- Marcar tarefa como não concluída
- Remover tarefa

## Arquitetura

O projeto segue o padrão MVC e está organizado nos seguintes packages:

```
src/
├── application/
│   ├── Program.java        # Ponto de entrada, orquestra View e Service
│   └── TaskView.java       # Responsável pela interação com o console
├── entities/
│   ├── Task.java           # Modelo base de tarefa
│   └── UrgentTask.java     # Tarefa urgente, herda de Task
├── services/
│   └── TaskService.java    # Regras de negócio
├── interfaces/
│   └── ITaskService.java   # Contrato do serviço
├── exceptions/
│   ├── EmptyListException.java
│   ├── InvalidIndexException.java
│   └── InvalidDescription.java
└── enums/
    └── ListOfPriority.java # LOW, MEDIUM, HIGH
```

## Conceitos praticados

**Interfaces**
`ITaskService` define o contrato que o `TaskService` deve cumprir. O `Program` depende da interface, não da implementação concreta — permitindo trocar a implementação sem alterar o restante do código.

**Herança**
`UrgentTask extends Task`, reaproveitando descrição, status de conclusão e validações da classe pai, e adicionando o campo `priority` do tipo `ListOfPriority`.

**Polimorfismo**
O `ArrayList<Task>` armazena tanto `Task` quanto `UrgentTask`. O método `toString()` é sobrescrito em `UrgentTask` e chamado automaticamente pelo Java com o comportamento correto para cada tipo.

**MVC**
- `TaskView` — captura input do usuário e exibe resultados no console
- `TaskService` — contém as regras de negócio e manipulação da lista
- `Program` — orquestra as chamadas entre View e Service

**Exceções personalizadas**
Validações centralizadas com fail fast: `InvalidDescription`, `InvalidIndexException` e `EmptyListException` estendem `RuntimeException` e são lançadas no ponto mais próximo do problema.

**Enums**
`ListOfPriority` representa os níveis de prioridade: `NEUTRAL`, `HIGH`.
