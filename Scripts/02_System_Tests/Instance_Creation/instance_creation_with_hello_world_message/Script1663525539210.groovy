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


CustomKeywords.'myApp.Login.login'(url, logged_in_user)

WebUI.verifyTextPresent('Rajesh', false)

WebUI.click(findTestObject('01_Page_Objects/user_portal_for_instance_creation/create_instance_button'))

WebUI.delay(3)

String created_instance_text = WebUI.getText(findTestObject('01_Page_Objects/user_portal_for_instance_creation/created_instance_id'))

String[] str = created_instance_text.split(' ')

String created_instance = str.last()

println(created_instance)

WebUI.verifyTextPresent('i-[0-9a-z]+', true)

WebUI.delay(40)

WebUI.click(findTestObject('01_Page_Objects/user_portal_for_instance_creation/show_instances_status_page'))

String final_text = WebUI.getText(findTestObject('01_Page_Objects/instances_listing_page/my_instance'))

println(final_text)

assert final_text.contains('running')

String pub_addr = final_text.split(',').last().split('\'')[1]

WebUI.navigateToUrl(('http://' + pub_addr) + ':80')

WebUI.verifyTextPresent(expected_message, false)

WebUI.delay(5)

WebUI.closeBrowser()

