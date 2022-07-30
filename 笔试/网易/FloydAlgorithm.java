package ����.����;

import java.util.*;

public class FloydAlgorithm {
    public static int MaxValue = 100000;
    public static int[][] path;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("�����붥�����ͱ���:");
        //������
        int vertex = input.nextInt();
        //����
        int edge = input.nextInt();

        int[][] matrix = new int[vertex][vertex];
        //��ʼ���ڽӾ���
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }

        //��ʼ��·������
        path = new int[matrix.length][matrix.length];

        //��ʼ����Ȩֵ
        for (int i = 0; i < edge; i++) {
            System.out.println("�������" + (i + 1) + "��������Ȩֵ:");
            int source = input.nextInt();
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }

        //�����㷨�������·��
        floyd(matrix);
    }

    //�ǵݹ�ʵ��
    public static void floyd(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                path[i][j] = -1;
            }
        }

        for (int m = 0; m < matrix.length; m++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][m] + matrix[m][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][m] + matrix[m][j];
                        //��¼�����ĸ��㵽��
                        path[i][j] = m;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j) {
                    if (matrix[i][j] == MaxValue) {
                        System.out.println(i + "��" + j + "���ɴ�");
                    } else {
                        System.out.print(i + "��" + j + "�����·�������ǣ�" + matrix[i][j]);
                        System.out.print("���·��Ϊ��" + i + "->");
                        findPath(i, j);
                        System.out.println(j);
                    }
                }
            }
        }
    }

    //�ݹ�Ѱ��·��
    public static void findPath(int i, int j) {
        int m = path[i][j];
        if (m == -1) {
            return;
        }

        findPath(i, m);
        System.out.print(m + "->");
        findPath(m, j);
    }
}