import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoWriter;

public class Encode {
  public static void main(String[] args) throws IOException {
    String inputFile = args[0]; // path to the input file
    String outputVideo = args[1]; // path to the output video

    // Read the input file into a byte array
    byte[] inputData = Files.readAllBytes(Paths.get(inputFile));

    // Create an OpenCV VideoWriter object to write the output video
    VideoWriter video = new VideoWriter(outputVideo, VideoWriter.fourcc('M','P','4','V'), 30.0, new Size(1280, 720));

    // Encode the input data into the output video
    for (int i = 0; i < inputData.length; i++) {
      // Create an empty image with 3 channels (RGB)
      Mat frame = Mat.zeros(720, 1280, 16);
      // Set the i-th pixel in the blue channel to the i-th byte of the input data
      frame.put(0, i, inputData[i]);
      // Write the frame to the output video
      video.write(frame);
    }
    video.release();
  }
}
