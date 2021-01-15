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
 * Dodanie produktu do koszyka
 */
WebUI.click(findTestObject('Object Repository/Page desktop/btn_buy_product'))


/*
 * Przejscie do koszyka produktów
 */
WebUI.click(findTestObject('Object Repository/Page desktop/a_shopping_cart'))


/*
 * Potwierdzenie wyboru produktów do zamówienia
 */
WebUI.click(findTestObject('Shopping Cart/btn_order_checkout'))


/*
 * Wprowadzenie imienia użytkownika - dane do wysyłki
 */
WebUI.setText(findTestObject('Object Repository/Shopping Cart/input_name'), GlobalVariable.name)


/*
 * Wprowadzenie nazwiska użytkownika - dane do wysyłki
 */
WebUI.setText(findTestObject('Object Repository/Shopping Cart/input_surename'), GlobalVariable.surname)


/*
 * Wprowadzenie kodu pocztowego użytkownika - dane do wysyłki
 */
WebUI.setText(findTestObject('Object Repository/Shopping Cart/input_zip-code'), GlobalVariable.zip_code)


/*
 * Potwierdzenie wyboru produktów do zamówienia - przejscie do podsumowania zamówienia
 */
WebUI.click(findTestObject('Object Repository/Shopping Cart/btn_continue'))


/*
 * Potwierdzenie zamówienia
 */
WebUI.click(findTestObject('Object Repository/Shopping Cart/btn_finish'))


/*
 * Pobranie informacji potwierdzającej realizację zamówienia
 */
confirmation_msg_element = WebUI.getText(findTestObject('Object Repository/Shopping Cart/str_order_confirmed'))


/*
 * Weryfikacja informacji potwierdzającej realizację zamówienia
 */
assert confirmation_msg_exp == confirmation_msg_exp


/*
 * Zamknięcie przeglądarki
 */
WebUI.closeBrowser()
