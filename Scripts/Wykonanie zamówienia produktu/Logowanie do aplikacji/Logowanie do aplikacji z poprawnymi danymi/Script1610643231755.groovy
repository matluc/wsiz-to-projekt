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
 * Wprowadzenie nazwy użytkownika
 */
WebUI.setText(findTestObject('Object Repository/User login/input_user-name'), GlobalVariable.user_id)

/*
 * Wprowadzenie hasła użytkownika
 */
WebUI.setEncryptedText(findTestObject('Object Repository/User login/input_user-password'), GlobalVariable.pwd)

/*
 * Uruchomienie opcji ZALOGUJ
 */
WebUI.click(findTestObject('Object Repository/User login/btn_login'))


/*
 * Pobranie nazwy strony głównej aplikacji
 */
str_mainpage_view = WebUI.getText(findTestObject('Object Repository/Page desktop/str_mainpage'))


/*
 * Sprawdzenie wartosci oczekiwanej z nazwą strony głównej
 */
assert mainpage_exp == str_mainpage_view

/*
 * Uruchomienie menu rozwijanego aplikacji
 */
WebUI.click(findTestObject('Object Repository/Page desktop/btn_menu'))

/*
 * Uruchomienie opcji WYLOGUJ
 */
WebUI.click(findTestObject('Object Repository/Page desktop/a_logout'))

/*
 * Zamknięcie przeglądarki
 */
WebUI.closeBrowser()

