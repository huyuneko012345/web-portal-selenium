package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * 参考ページ
 * https://qiita.com/hirotatsuuu/items/6a87df10c635a37ade16
 * https://saikeblog.com/2020/01/13/java%E3%81%A7selenium%E3%82%92%E4%BD%BF%E3%81%A3%E3%81%A6%E8%87%AA%E5%8B%95ui%E3%83%86%E3%82%B9%E3%83%88%E3%82%92%E3%81%99%E3%82%8B%E6%96%B9%E6%B3%95/
 * 
 * seleniumクイックリファレンス
 * https://www.seleniumqref.com/
 * 
 * selenium公式
 * https://www.selenium.dev/
 * 
 * @author **
 *
 */
public class test {

	public static void main(String[] args) throws InterruptedException {
//		「自動テストソフトウェアによって制御されています」を消す
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.setExperimentalOption("useAutomationExtension", false);
//		ドライバーのパスを設定
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new  ChromeDriver(options);
//		webportalを開く
		driver.get("http://localhost:8080/login");
		login(driver);
		driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/form/div/input")).sendKeys("0030608");
		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).click();
//		待つ
		Thread.sleep(500);
//		一つ前の画面に戻る
		driver.navigate().back();



	}
	/**
	 * ログイン処理用
	 * @param driver
	 */
	public static void login(WebDriver driver) {
//		メールアドレス入力
		driver.findElement(By.xpath("/html/body/div[1]/div/form/input[1]")).sendKeys("taro@xxx.co.jp");
//		パスワード入力
		driver.findElement(By.xpath("/html/body/div[1]/div/form/input[2]")).sendKeys("hcs2022");
//		ログインボタン押下
		driver.findElement(By.xpath("/html/body/div[1]/div/form/button")).click();
	}
}
