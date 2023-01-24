import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class Decode {
  public static void main(String[] args) {
    // Load the OpenCV library
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    // Read the input video file
    VideoCapture capture = new VideoCapture("input.mp4");
    Mat frame = new Mat();
    List<Byte> data = new ArrayList<>();
    while (capture.read(frame)) {
      // Extract the data from the blue channel of the frame
      data.add((byte) frame.get(0, 0)[0]);
    }
    capture.release();

    // Write the decoded data to the output file
    try {
      Files.write(Paths.get("output.bin"), data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
