import java.util.*;

class Solution {

    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1}; 

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int a = 0; a < places.length; a++) {
            String[][] place = new String[5][5];

            // 2차원 배열로 변환
            for (int b = 0; b < 5; b++) {
                place[b] = places[a][b].split("");
            }

            boolean pass = true;  // 기본적으로 거리두기를 지킨다고 가정

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (!place[i][j].equals("P")) continue;

                    // 상하좌우 거리 1 체크
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (isValid(nx, ny) && place[nx][ny].equals("P")) {
                            pass = false;
                            break;
                        }
                    }

                    // 맨해튼 거리 2 체크 (P O P)
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k] * 2;
                        int ny = j + dy[k] * 2;

                        if (isValid(nx, ny) && place[nx][ny].equals("P")) {
                            if (place[i + dx[k]][j + dy[k]].equals("O")) {  // 사이가 빈 자리면 거리두기 위반
                                pass = false;
                                break;
                            }
                        }
                    }

                    // 대각선 체크 (P X P 허용, P O P 금지)
                    int[][] diagonal = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
                    for (int[] d : diagonal) {
                        int nx = i + d[0];
                        int ny = j + d[1];

                        if (isValid(nx, ny) && place[nx][ny].equals("P")) {
                            if (!(isValid(i, ny) && place[i][ny].equals("X")) || !(isValid(nx, j) && place[nx][j].equals("X"))) {
                                pass = false;
                                break;
                            }
                        }
                    }

                    if (!pass) break;
                }
                if (!pass) break;
            }

            answer[a] = pass ? 1 : 0;
        }

        return answer;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
