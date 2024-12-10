//26 5
//Bulbasaur
//Ivysaur
//Venusaur
//Charmander
//Charmeleon
//Charizard
//Squirtle
//Wartortle
//Blastoise
//Caterpie
//Metapod
//Butterfree
//Weedle
//Kakuna
//Beedrill
//Pidgey
//Pidgeotto
//Pidgeot
//Rattata
//Raticate
//Spearow
//Fearow
//Ekans
//Arbok
//Pikachu
//Raichu
//25
//Raichu
//3
//Pidgey
//Kakuna

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			map.put(name, String.valueOf(i + 1));
			map.put(String.valueOf(i + 1), name);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(map.get(st.nextToken())).append("\n");
		}
		System.out.println(sb);
	}
}