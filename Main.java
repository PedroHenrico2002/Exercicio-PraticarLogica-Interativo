import java.util.Scanner;

public class Main {
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(BLUE + "JAVA 10 EXERCICIOS INTERATIVOS - CONSOLE" + RESET);
            System.out.println("1. Hello World | 2. Scanner Soma | 3. FOR 1-10 | 4. IF Maioridade");
            System.out.println("5. % Par/Impar | 6. Array Soma | 7. Metodo | 8. While | 9. do-while");
            System.out.println("10. Switch | 0. Sair");
            System.out.print("Escolha exercicio: ");
            
            int op = sc.nextInt();
            sc.nextLine(); // consume newline
            
            if (op == 0) break;
            if (op >= 1 && op <= 10) {
                executarExercicio(op, sc);
            } else {
                System.out.println(RED + "Opcao invalida!" + RESET);
            }
            System.out.println("\n" + YELLOW + "Enter para continuar..." + RESET);
            sc.nextLine();
        }
        System.out.println(GREEN + "FIM DOS EXERCICIOS!" + RESET);
        sc.close();
    }

    private static void executarExercicio(int n, Scanner sc) {
        System.out.println("\n" + BLUE + "=".repeat(60) + RESET);
        System.out.println(BLUE + "EXERCICIO " + n + RESET);
        
        // Descrições portadas do HTML
        String[] descricoes = {
            "System.out.println(\"Oi Mundo!\")",
            "2 nextInt() -> println(soma)",
            "for(i=1; i<=10; i++) println(i)",
            "idade >=18 \"adulto\" else \"criança\"",
            "n % 2 == 0 \"PAR\" else \"IMPAR\"",
            "int[] n = {1,2,3}; soma = 6",
            "static int soma(int a,int b) -> soma(2,3)=5",
            "while(i<5) imprimir i++",
            "do {menu} while(opc != 0)",
            "switch(dia) 1=\"Segunda\" default=\"Inválido\""
        };
        
        System.out.println(YELLOW + descricoes[n-1] + RESET);
        System.out.println(BLUE + "=".repeat(60) + RESET);
        
        // 1. DICA PASSO A PASSO?
        System.out.print(YELLOW + "DICA PASSO A PASSO? (s/n): " + RESET);
        if (sc.nextLine().toLowerCase().startsWith("s")) {
            mostrarDicas(n);
        }
        
        // 2. Escrever código (multi-linha simulado)
        System.out.println(BLUE + "Escreva seu codigo Java (Enter vazio para finalizar):" + RESET);
        StringBuilder codigo = new StringBuilder();
        while (true) {
            String linha = sc.nextLine();
            if (linha.trim().isEmpty()) break;
            codigo.append(linha).append("\n");
        }
        String codeLower = codigo.toString().toLowerCase();
        
        // 3. TESTAR (checks portados do JS)
        boolean correto = switch (n) {
            case 1 -> codeLower.contains("println") && codeLower.contains("oi");
            case 2 -> codeLower.contains("nextint") && codeLower.contains("+");
            case 3 -> codeLower.contains("for") && codeLower.contains("<=10");
            case 4 -> codeLower.contains("if") && codeLower.contains(">=18");
            case 5 -> codeLower.contains("%") && codeLower.contains("2");
            case 6 -> codeLower.contains("int[]") && codeLower.contains("for");
            case 7 -> codeLower.contains("static int") && codeLower.contains("return");
            case 8 -> codeLower.contains("while") && codeLower.contains("<5");
            case 9 -> codeLower.contains("do") && codeLower.contains("while");
            case 10 -> codeLower.contains("switch") && codeLower.contains("case");
            default -> false;
        };
        
        // Feedback
        if (correto) {
            System.out.println(GREEN + "CODIGO COMPLETO VALIDADO!" + RESET);
            System.out.println(GREEN + "Estrutura 100% correta!" + RESET);
        } else {
            System.out.println(RED + "Estrutura incompleta" + RESET);
            System.out.println(RED + "Use DICA PASSO A PASSO" + RESET);
        }
    }

    private static void mostrarDicas(int n) {
        String[][] passos = {
            {"1. System.out.println(", "2. \"Oi Mundo Java!\" );", "3. FIM!"},
            {"1. int n1 = sc.nextInt();", "2. int n2 = sc.nextInt();", "3. System.out.println(n1+n2);"},
            {"1. for(int i=1; i<=10; i++) {", "2. System.out.println(i);", "3. }"},
            {"1. int idade = sc.nextInt();", "2. if(idade>=18) System.out.println(\"adulto\");", "3. else System.out.println(\"criança\");"},
            {"1. int n = sc.nextInt();", "2. if(n%2==0) System.out.println(\"PAR\");", "3. else System.out.println(\"IMPAR\");"},
            {"1. int[] arr = {1,2,3};", "2. int soma=0;", "3. for(int x:arr) soma+=x;", "4. System.out.println(soma);"},
            {"1. static int soma(int a, int b) {", "2. return a+b;", "3. }", "4. System.out.println(soma(2,3));"},
            {"1. int i=0;", "2. while(i<5) {", "3. System.out.println(\"i=\"+i); i++;", "4. }"},
            {"1. int opc=1;", "2. do { System.out.println(\"Menu\"); opc=sc.nextInt(); }", "3. while(opc != 0);"},
            {"1. int dia = sc.nextInt();", "2. switch(dia) {", "3. case 1: System.out.println(\"Segunda\"); break;", "4. default: System.out.println(\"Invalido\"); }"}
        };
        
        System.out.println(YELLOW + "PASSOS:" + RESET);
        for (String passo : passos[n-1]) {
            System.out.println(YELLOW + passo + RESET);
        }
        System.out.println();
    }
}

