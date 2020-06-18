package Sparse;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始数组 11 * 11
        //0:表示没有旗子,1表示黑子,2表示篮子
        int cheseArr1[][] = new int[11][11];
        cheseArr1[1][2] = 1;
        cheseArr1[2][3] = 2;
        cheseArr1[4][5] = 3;


        //输出原始数组
        for (int[] row : cheseArr1) {
            for (int data : row) {
                System.out.print(data + " ");

            }
            System.out.println();
        }

        //二维数组转稀疏数组
        //1 .遍历二维数组得到非零数组个数
        int sum = 0;
        for (int i = 0; i < cheseArr1.length; i++) {
            for (int j = 0; j < cheseArr1[i].length; j++) {
                if (cheseArr1[i][j] != 0)
                    sum++;
            }
        }

        System.out.println("count = " + sum);


        //2.创建对应的稀疏数组
        int sparseArr[][] = new int [sum + 1][3];
        //给稀疏数组赋值

        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;


        //3.遍历源二维数组找出不是0的值,把位置信息写到稀疏数组中
        int count = 0;
    outterLoop:  for(int i = 0;i < cheseArr1.length; i++){
            for (int j = 0;j < cheseArr1[1].length;j++){
                if(cheseArr1[i][j] != 0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = cheseArr1[i][j];
                    if(count == sum+1)
                        break outterLoop;
                }
            }
        }

        //输出稀疏数组
        for(int[] row:sparseArr){
            System.out.println(row[0] + " " + row[1] + " " + row[2]);
        }
    }
}
