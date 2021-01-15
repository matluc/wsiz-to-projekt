import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable


/*
 * Uruchomienie przeglądarki z adresem aplikacji
 */
WebUI.openBrowser(rawUrl=GlobalVariable.url)


/*
 * Dostęp do danych testowych
 */
for (def row = 1; row <= findTestData('SwagLabs/SwagLab_DATA_logins').getRowNumbers(); row++)
{
	/*
	 * Wprowadzenie nazwy użytkownika - wartosc ze zmiennej user_id dla pola nick
	 */
	WebUI.setText(findTestObject('Object Repository/User login/input_user-name'),
		 findTestData('SwagLabs/SwagLab_DATA_logins').getValue('nick', row))
	
	/*
	 * Wprowadzenie hasła użytkownika - wartosc ze zmiennej pwd dla pola pass
	 */
	WebUI.setText(findTestObject('Object Repository/User login/input_user-password'),
		findTestData('SwagLabs/SwagLab_DATA_logins').getValue('pass', row))
	
	/*
	* Uruchomienie opcji ZALOGUJ
	*/
	WebUI.click(findTestObject('Object Repository/User login/btn_login'))

	/*
	 * Zatrzymanie skryptu - wartosc ze zmiennej wait_a_sec
	 */
	WebUI.delay(GlobalVariable.wait_a_sec)
	
	/*
	 * Sprawdzenie nazwy uzytkownika
	 */
	error_msg_login = WebUI.getText(findTestObject('Object Repository/User login/str_error_msg_login'))
	assert error_msg_exp == error_msg_login
}
/*
 * Zamkniecie przegladarki
 */
WebUI.closeBrowser()
