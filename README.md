This is a test to verify the search results on Google search pages 1 and 2 using TestNG framework


1. Download + Install IDEA Community Edition
2. Download + Install Java JDK 1.8.211
3. Download + unpack/install  Chrome Webdriver (3.8.1)
 or better implement the dependency and upgrade the BaseTest class with
  @BeforeMethod

      @Parameters("browser")
      public void beforeMethod(@Optional("chrome") String browserName) throws Exception {
          if (browserName.toLowerCase().equals("chrome")){
              WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
          }
          else if (browserName.toLowerCase().equals("firefox")){
              WebDriverManager.firefoxdriver().setup();
              driver = new FirefoxDriver();
          }else {
              throw new Exception("Unsupported 'BrowserName'");
          }

          driver.manage().window().maximize();
      }

4. Add the dependencies into pom.xml file:
 <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-chrome-driver</artifactId>
            <version>33.141.59</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-api</artifactId>
            <version>3.8.1</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-chrome-driver</artifactId>
            <version>3.8.1</version>
        </dependency>
        <dependency>
                    <groupId>io.github.bonigarcia</groupId>
                    <artifactId>webdrivermanager</artifactId>
                    <version>3.6.0</version>
                    <scope>test</scope>
                </dependency>
    </dependencies>
 5. .gitignore file should contain :
 .idea/
 target/
 *.iml

6. Run with cmd:
mvn clean test