package text1;
/**
 * Java: �ڽӾ���ͼ
 *
 * @author skywang
 * @date 2015/04/12
 */

import java.io.IOException;
import java.util.Scanner;

public class MatrixDG {

    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���

    /* 
     * ����ͼ(�Լ���������)
     */
    public MatrixDG() {

        // ����"������"��"����"
        System.out.printf("input vertex number: ");
        int vlen = readInt();
        System.out.printf("input edge number: ");
        int elen = readInt();
        if ( vlen < 1 || elen < 1 || (elen > (vlen*(vlen - 1)))) {
            System.out.printf("input error: invalid parameters!\n");
            return ;
        }

        // ��ʼ��"����"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d): ", i);
            mVexs[i] = readChar();
        }

        // ��ʼ��"��"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����ͽ�������
            System.out.printf("edge(%d):", i);
            char c1 = readChar();
            char c2 = readChar();
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);

            if (p1==-1 || p2==-1) {
                System.out.printf("input error: invalid edge!\n");
                return ;
            }

            mMatrix[p1][p2] = 1;
        }
    }

    /*
     * ����ͼ(�����ṩ�ľ���)
     *
     * ����˵����
     *     vexs  -- ��������
     *     edges -- ������
     */
    public MatrixDG(char[] vexs, char[][] edges) {

        // ��ʼ��"������"��"����"
        int vlen = vexs.length;
        int elen = edges.length;

        // ��ʼ��"����"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // ��ʼ��"��"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����ͽ�������
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            mMatrix[p1][p2] = 1;
        }
    }

    /*
     * ����chλ��
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i]==ch)
                return i;
        return -1;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private char readChar() {
        char ch='0';

        do {
            try {
                ch = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(!((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')));

        return ch;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /*
     * ��ӡ�������ͼ
     */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%d ", mMatrix[i][j]);
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
            {'A', 'B'}, 
            {'B', 'C'}, 
            {'B', 'E'}, 
            {'B', 'F'}, 
            {'C', 'E'}, 
            {'D', 'C'}, 
            {'E', 'B'}, 
            {'E', 'D'}, 
            {'F', 'G'}}; 
        MatrixDG pG;

        // �Զ���"ͼ"(����������)
        //pG = new MatrixDG();
        // �������е�"ͼ"
        pG = new MatrixDG(vexs, edges);

        pG.print();   // ��ӡͼ
    }
}
