1. Como o projeto funciona?
R= Ao executar o projeto você irá se deparar com a tela inicial, onde terá duas opções para serem escolhidas e um botão para confimar o modo escolhido. Ao clicar num dos dois modos, o modo clicado irá mudar de cor para rosa. O modo fácil conta com perguntas que é de conhecimento geral, ou seja, não é necessário muito conhecimento para serem respondidas, dessa forma é possível que mesmo um iniciante nesse tipo de jogo seja capaz de jogá-lo sem se extressar, além de que o modo fácil conta com 1 minuto de tempo há mais para responder as perguntas. Quanto ao modo difícil, as perguntas exigem um pouco mais de conhecimento e o tempo para responder todas elas é menor. Durante o jogo no modo fácil, você vai ter dois minutos para responder 10 perguntas e será dado 4 questões para que você escolha entre uma delas, ao escolher a resposta certa, automaticamente ela irá ficar verde, caso escolha a errada ela irá ficar vermelha e mostrará em verde qual é a certa. você pode ir para próxima pergunta clicando no botão "Próxima" quem tem no canto inferior direito. Após responder todas as perguntas, ou acabar o tempo, você irá se deparar com a tela de resultados, que mostrará todos os acertos e erros que você teve durante o Quiz, com um botão escrito "COMEÇAR UM NOVO JOGO", na parte inferior da tela, para recomeçar o jogo.


2. Requesitos do sistema:
R= O seguinte ambiente foi utilizado para o desenvolvimento do app. Para evitar erros, e se possível, recomendo a utilização do mesmo ambiente abaixo.

Android Studio Dolphin | 2021.3.1
Build #AI-213.7172.25.2113.9014738, built on August 31, 2022
Runtime version: 11.0.13+0-b1751.21-8125866 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
Windows 10 10.0
GC: G1 Young Generation, G1 Old Generation
Memory: 1280M
Cores: 12
Registry:
    external.system.auto.import.disabled=true
    ide.text.editor.with.preview.show.floating.toolbar=false


3. Configuração do projeto:

Instale o Java Development Kit (JDK): O Android Studio requer o JDK para funcionar corretamente. Baixe e instale a versão mais recente do JDK disponível em https://www.oracle.com/java/technologies/javase-downloads.html.

Baixe e instale o Android Studio: Baixe e instale a versão mais recente do Android Studio disponível em https://developer.android.com/studio/.

Configure o Android Studio: Quando você iniciar o Android Studio pela primeira vez, ele o guiará pelo processo de configuração. Certifique-se de que o SDK esteja instalado corretamente e configure o ambiente de desenvolvimento de acordo com suas necessidades.

Clone o projeto pelo git em uma pasta de sua preferência, você pode usar o link https://github.com/Robert-Marchinhaki/hilabQuizApp.git.

Na IDE do Android Studio clique em "File", "Open" e vá até o local onde você salvou o projeto.

Ao abrir o projeto, espere o Android Studio carregar as dependências.

Sincronize o projeto: Após adicionar as dependências, sincronize o projeto com as mudanças feitas. Para sincronizar o projeto, clique em "Sync Now" (Sincronizar Agora) na barra de ferramentas superior.

Execute o aplicativo: Para testar o aplicativo, você pode executá-lo em um emulador Android ou em um dispositivo físico conectado. Selecione o dispositivo de destino na barra de ferramentas superior e clique em "Run" (Executar) para executar o aplicativo.


4. Estrutura do projeto:

app: Esta pasta contém o código fonte e os recursos da aplicação. O arquivo de manifesto do aplicativo (AndroidManifest.xml) também será encontrado aqui.

build: Esta pasta contém os arquivos gerados pelo Gradle durante o processo de construção, incluindo o arquivo APK final.

Gradle: Esta pasta contém arquivos de configuração do Gradle, como o build.gradle do projeto e o build.gradle do módulo.

.gradle: Esta pasta contém arquivos de cache e outras informações utilizadas pelo Gradle durante o processo de construção.

.idea: Esta pasta contém arquivos de configuração do Android Studio.

gradle.properties: Este arquivo contém propriedades específicas do Gradle.

local.properties: Este arquivo contém informações sobre o SDK do Android.

settings.gradle: Este arquivo especifica quais módulos fazem parte do projeto.

Proguard-rules.pro: Este arquivo contém regras de configuração para o Proguard, uma ferramenta de ofuscação de código usada para melhorar a segurança do seu aplicativo.

.gitignore: Este arquivo contém arquivos e pastas que devem ser ignorados pelo Git.

5. Componentes do Projeto:

A lógica principal do projeto se encontra na pasta app/src/main/java onde tem todas as classes que foram utilizadas para construção do projeto

Já na pasta app/src/main/res você encontrara a pasta drawable onde tem os ícones e imagens utilizados, e na pasta layout você encontrará os 3 o código do layout nos arquivos .xml


6. Funcionalidades do Projeto:

O usuário pode optar por um entre dois modos de dificuldade.

O usuário pode escolhar voltar a tela inicial no meio do quiz, clicando no icone de retornar.

O usuário tem um tempo limitado para responder as perguntas.

O usuário tem escolher uma em quatro possíves respostas.

O usuário tem um feedback se a resposta está certa ou errada.

O usuário, no final do jogo, tem sua pontuação: acertos e erros, bem como a possibilidade de começar um novo jogo.
