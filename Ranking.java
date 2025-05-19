public class Ranking{
    
    private SuperViloes[] rankingSuperViloes;
    private int elementos;

    public Ranking(int tamanho){
        rankingSuperViloes = new SuperViloes[tamanho];
        elementos = 0;
    }

    public SuperViloes[] getRankingSuperViloes() {
        return rankingSuperViloes;
    }

    public int getElementos(){
        return elementos;
    }

    public void adicionaVilao(SuperViloes vilao) {
        if (elementos == rankingSuperViloes.length) {
            System.out.println("Erro: O ranking está cheio!");
        }
        else{
            rankingSuperViloes[elementos] = vilao;
            elementos++;
        }
    }

    public void removeVilao(String vilao){
        boolean check = false;
        for (int i = 0; i < elementos; i++) {
            if (rankingSuperViloes[i].getNome().equals(vilao)) {
                System.out.println("Vilão " + rankingSuperViloes[i].getNome() + " derrotado e removido do ranking!");
                System.out.println("");
                for (int j = i; j < elementos - 1; j++) {
                    rankingSuperViloes[j] = rankingSuperViloes[j + 1];
                }
                rankingSuperViloes[elementos-1] = null;
                elementos--;
                check = true;
            }
        }
        if (check == false) {
            System.out.println(vilao + " não foi encontrado no ranking!");
        }
    }

    public void buscaVilao(){
        int maiornivel = 0;
        String nomevilao = "";
        if (elementos == 0) {
            System.out.println("Não há vilões no ranking");
            return;
        }
        for (int i = 0; i < elementos; i++){
            if (i == 0) {
                maiornivel = rankingSuperViloes[i].getNivelDeMaldade();
                nomevilao = rankingSuperViloes[i].getNome();
            }
            else{
                if (rankingSuperViloes[i].getNivelDeMaldade() > maiornivel) {
                    maiornivel = rankingSuperViloes[i].getNivelDeMaldade();
                    nomevilao = rankingSuperViloes[i].getNome();
                }
            }
        }
        System.out.println("O vilão mais malvado é: " + nomevilao);
        System.out.println("");
    }

public int separar(SuperViloes[] array, int ini, int fim) {
    SuperViloes pivo = array[fim];
    int i = ini - 1;

    for (int j = ini; j < fim; j++) {
        if (array[j].getNivelDeMaldade() >= pivo.getNivelDeMaldade()) { // INVERTIDO PARA DECRESCENTE
            i++;
            SuperViloes temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    SuperViloes temp = array[i + 1];
    array[i + 1] = array[fim];
    array[fim] = temp;

    return i + 1;
}



    public void ordenaViloes(SuperViloes[] array, int ini, int fim){
        int k;

        if(fim>ini){
            k = separar(array, ini, fim);
            ordenaViloes(array, ini, k-1);
            ordenaViloes(array, k+1, fim);
        }
        
    }

    public void mostrarRanking(){
        for (int i = 0; i < elementos; i++) {
            System.out.println("Vilão: "+rankingSuperViloes[i].getNome()+". Nível de maldade: "+rankingSuperViloes[i].getNivelDeMaldade());
        }
        System.out.println("");
    }
}