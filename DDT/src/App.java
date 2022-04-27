public class App {
    static int[] sbox = {6,4,0xc,5,0,7,2,0xe,1,0xf,3,0xd,8,0xa,9,0xb};
    static int SIZE_SBOX = sbox.length;
    
    public static void main(String[] args) throws Exception {
        int Inlength = 16;
        int OutLength = 16;
        

        int[][] DFT = new int[Inlength][OutLength];

        for(int i=0;i<Inlength;i++)
        {
            for(int j=0;j<OutLength;j++)
            {
                DFT[i][j] = 0;
            }
        }
        int XOR_IN;
        int XOR_OUT;
        for(int p1=0;p1<Inlength;p1++)
        {
            for(int p2=0;p2<OutLength;p2++)
            {
                XOR_IN= p1 ^ p2;
                XOR_OUT = sbox[p1] ^ sbox[p2];
                DFT[XOR_IN][XOR_OUT]++;
            }
        }

        //............................................................ PRINT ......................................................
        //rows
        System.out.print( "    ");
        for (int i=0;i<SIZE_SBOX;i++)
            System.out.print(rjust(Integer.toHexString(i),3) + " ");

            System.out.println("");


        String dashes = "";
        for (int j = 0;j< (SIZE_SBOX * 4 + 4);j++) dashes += "-";
        System.out.println(" " + dashes);

        for (int row=0;row< SIZE_SBOX;row++) {
            System.out.print(rjust(Integer.toHexString(row),3) +  " | ");
            // cols
            for (int col = 0; col<SIZE_SBOX;col++) {
                // print the linear approx
                if(row == 0 && col==0)
                    System.out.print(DFT[row][col] + "| ");
                else if(row == 15 && col==13)
                     System.out.print(DFT[row][col] + "| ");
                else
                System.out.print(DFT[row][col] + " | ");
            }

            System.out.println("");
        }

       

        
      



        
    }


    private static String rjust(String s, int len) {
        len = len-s.length();
        for (int i =0;i<len;i++) s = " "+s;
        return s;
    }
}
