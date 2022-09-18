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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('http://localhost:5000')

WebUI.setText(findTestObject('user_name_field'), 'Rajesh')

WebUI.click(findTestObject('login_button'))

WebUI.verifyTextPresent('Rajesh', false)

WebUI.click(findTestObject('create_instance_button'))

WebUI.delay(3)

String created_instance_text = WebUI.getText(findTestObject('created_instance_id'))

String[] str = created_instance_text.split(' ')

String created_instance = str.last()

WebUI.verifyTextPresent('i-[0-9a-z]+', true)

WebUI.click(findTestObject('show_instances_status_page'))

WebUI.delay(2)

String final_text = WebUI.getText(findTestObject('instances_on_show_page', [(created_instance) : created_instance]))

assert final_text.contains('running')

WebUI.closeBrowser()
