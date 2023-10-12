package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ElementUtil {

  public String captureScreenshot(WebDriver driver) {
    //   TakesScreenshot ts = (TakesScreenshot) driver;

    //   File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

    //   String fileName = "screenshot_" + System.currentTimeMillis() + ".png";

    //   String screenshotDir = "selenium-demo/test-output/";
    //   Path screenshotPath = Paths.get(screenshotDir, fileName);
    //   Files.write(screenshotPath, screenshotBytes);

    //return screenshotPath.toString();
    return null;
  }
}

////>>>>>>>>I didn't have time to finish implemeting attaching screenshots to the report.