import java.util.Scanner;
public class Tictactoe{
   public static void main(String[] args){

      int size = 3;
      int[][] masu = new int[size][size];

      for (int y = 0; y<size; y++){
         for(int x = 0; x<size; x++){
            masu[x][y] = 0;
         }
      }

      int putX = 0;
      int putY = 0;

      for(int turn = 0; turn < size*size; turn++){
         int player = turn%2+1;
         play(putX,putY,size,masu,player);

         String sign[] = {" ", "O", "X"};
         for(int y = 0; y<size; y++){
            String p = "|";
            for(int x = 0; x<size; x++){
               p += sign[masu[x][y]] + "|";
            }
            System.out.println(p);
         }
         System.out.println();
      }
      System.out.println("引き分けです");
   }

   private static void play(int putX,int putY,int size,int[][] masu,int player){
      Scanner sc = new Scanner(System.in);
      if(player == 1) {
         System.out.println("先手です\n");
      }else{
         System.out.println("後手です\n");
      }
      while(true){
         System.out.println("整数の0~"+(size-1)+"を入力してください（縦列）");
         putX = sc.nextInt();
         System.out.println("整数の0~"+(size-1)+"を入力してください（横列）");
         putY = sc.nextInt();
         if(putX<0 || putY<0 || putX>=size || putY>=size){
            System.out.println("0~"+(size-1)+"の整数でもう一度入力してください\n");
            continue;
         }else if(masu[putX][putY]!=0){
            System.out.println("その場所は置かれています\nもう一度入力してください\n");
            continue;
         }else{
            masu[putX][putY] = player;
            break;
         }
      }

      if((masu[0][0] == player && masu[1][0] == player && masu[2][0] == player) || (masu[0][1] == player && masu[1][1] == player && masu[2][1] == player) || (masu[0][2] == player && masu[1][2] == player && masu[2][2] == player))win(player);
      if((masu[0][0] == player && masu[0][1] == player && masu[0][2] == player) || (masu[1][0] == player && masu[1][1] == player && masu[1][2] == player) || (masu[2][0] == player && masu[2][1] == player && masu[2][2] == player))win(player);
      if(masu[0][0] == player && masu[1][1] == player && masu[2][2] == player)win(player);
      if(masu[0][2] == player && masu[1][1] == player && masu[2][0] == player)win(player);
   }

   private static void win(int player){
      if(player == 1) {
         System.out.println("先手の勝ちです");
      }else{
         System.out.println("後手の勝ちです");
      }
      System.exit(0);
   }
}
