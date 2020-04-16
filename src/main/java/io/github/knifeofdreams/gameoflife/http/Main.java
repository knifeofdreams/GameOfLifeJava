package io.github.knifeofdreams.gameoflife.http;

import io.github.knifeofdreams.gameoflife.Cell;
import io.github.knifeofdreams.gameoflife.GameOfLife;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.ByteString;

public class Main {

  private static final MediaType TEXT_PLAIN = MediaType.get("text/plain");

  public static void main(String[] args) throws Exception {
    new Main().runLife();
  }

  private OkHttpClient httpClient = new OkHttpClient();
  private int generationNumber;
  private List<Cell> generation = new GameOfLife(createGliderGun()).stepGeneration();

  private void runLife() throws Exception {
    while (true) {
      postLife();
      this.generation = new GameOfLife(this.generation).stepGeneration();
    }
  }

  private void postLife() throws Exception {
    var lifeAsString = generation.stream()
        .map(cell -> cell.getX() + ":" + cell.getY())
        .collect(Collectors.joining(","));
    var response = httpClient.newCall(
        new Request.Builder()
            .url("http://127.0.0.1:8080")
            .post(RequestBody.create(
                ByteString.encodeString(
                    lifeAsString,
                    StandardCharsets.ISO_8859_1),
                TEXT_PLAIN))
            .build())
        .execute();
    if (response.code() > 299) {
      throw new Exception("Failed to POST life,"
                              + "\n\tserver response: " + response.code() + ": " + response.message()
                              + "\n\tlife: " + lifeAsString);
    } else {
      System.out.println(generationNumber + " generation submitted.");
      generationNumber++;
    }
  }

  private List<Cell> createGliderGun() {
    return List.of(
        new Cell(1, 5, true),
        new Cell(1, 6, true),
        new Cell(2, 5, true),
        new Cell(2, 6, true),
        new Cell(11, 5, true),
        new Cell(11, 6, true),
        new Cell(11, 7, true),
        new Cell(12, 4, true),
        new Cell(12, 8, true),
        new Cell(13, 3, true),
        new Cell(13, 9, true),
        new Cell(14, 3, true),
        new Cell(14, 9, true),
        new Cell(15, 6, true),
        new Cell(16, 4, true),
        new Cell(16, 8, true),
        new Cell(17, 5, true),
        new Cell(17, 6, true),
        new Cell(17, 7, true),
        new Cell(18, 6, true),
        new Cell(21, 3, true),
        new Cell(21, 4, true),
        new Cell(21, 5, true),
        new Cell(22, 3, true),
        new Cell(22, 4, true),
        new Cell(22, 5, true),
        new Cell(23, 2, true),
        new Cell(23, 6, true),
        new Cell(25, 1, true),
        new Cell(25, 2, true),
        new Cell(25, 6, true),
        new Cell(25, 7, true),
        new Cell(35, 3, true),
        new Cell(35, 4, true),
        new Cell(36, 3, true),
        new Cell(36, 4, true)
    );
  }
}
