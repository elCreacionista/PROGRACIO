package ROBOT;

import MAPA.Mapa;

public class SemiPathFinder extends RandomPathFinder{

    public SemiPathFinder(String mapa){
        super(mapa);
    }
    public void improvePath(){
        StringBuilder sb = new StringBuilder();
        System.out.println(this.bestPath);
        for (int i = 0; i < this.bestPath.length(); ) {
            if (i == this.bestPath.length() - 1) {
                sb.append(this.bestPath.charAt(i));
                break;
            }
            if (!contraris(this.bestPath.charAt(i), this.bestPath.charAt(i+1))) {
                sb.append(this.bestPath.charAt(i));
                i++;
            }
            else
                i +=2;
        }
        this.bestPath = sb.toString();
        System.out.println(sb.toString());
    }
    private boolean contraris(char a, char b){
        return switch ("" + a + b) {
            case "AD", "DA", "WS", "SW" -> true;
            default -> false;
        };
    }
}
