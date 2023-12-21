package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

    private final By companyTitleName = By.id("com.zkbiocloudaccess:id/tvTitle");
    private final By homePageElements = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView");
    private final By deviceDropdown = By.xpath("//android.widget.Spinner/android.widget.RelativeLayout/android.widget.TextView");
    private final By devicedropdownElement = By.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.TextView");
    private final By homeSubmoduleIcon = By.xpath("//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.ImageView");
    private final By dashboardSubmoduleIcon = By.xpath("//android.widget.FrameLayout[@content-desc=\"Dashboard\"]/android.widget.ImageView");
    private final By organizationSubmoduleIcon = By.xpath("//android.widget.FrameLayout[@content-desc=\"Organization\"]/android.widget.ImageView");
    private final By messageSubmoduleIcon = By.xpath("//android.widget.FrameLayout[@content-desc=\"Message\"]/android.widget.ImageView");
    private final By hamburgermenuIcon = By.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton");
    private final By editIcon = By.id("com.zkbiocloudaccess:id/action_edit");
    private final By deleteIcon = By.id("com.zkbiocloudaccess:id/action_delete");
    private final By deleteConfirmation = By.id("com.zkbiocloudaccess:id/tv_delete");
    private final By deleteCancel = By.id("com.zkbiocloudaccess:id/cancel_tv");
    //Device Management
    private final By deviceNameList = By.id("com.zkbiocloudaccess:id/device_name_val");
    private final By deviceSerialNumberList = By.id("com.zkbiocloudaccess:id/serial_nu_val");
    private final By deviceIPList = By.id("com.zkbiocloudaccess:id/ip_add_val");
    private final By expandIcon = By.id("com.zkbiocloudaccess:id/down_img");
    private final By registeredDevice = By.id("com.zkbiocloudaccess:id/reg_dev_val");
    private final By firmwareVersion = By.id("com.zkbiocloudaccess:id/fir_ver_val");
    private final By deviceStatusList = By.id("com.zkbiocloudaccess:id/status_tv");
    private final By deviceMangementAddicon = By.id("com.zkbiocloudaccess:id/fab_add");
    private final By uncheckIcon = By.id("com.zkbiocloudaccess:id/img_check_box");
    private final By addDeviceIcon = By.id("com.zkbiocloudaccess:id/fab_add");
    private final By deviceCheckbox = By.id("com.zkbiocloudaccess:id/con_layout");
    private final By selectandDeselectAll = By.id("com.zkbiocloudaccess:id/select_all_tv");
    private final By deleteButton = By.id("com.zkbiocloudaccess:id/action_delete");
    private final By filterIcon = By.id("com.zkbiocloudaccess:id/filter_iv");
    private final By refreshIcon = By.id("com.zkbiocloudaccess:id/refresh_iv");
    private final By editDeviceName = By.id("com.zkbiocloudaccess:id/device_name_et");
    private final By iconTypeDropdown = By.id("com.zkbiocloudaccess:id/icon_type_dropdown");
    private final By timezoneDropdown = By.id("com.zkbiocloudaccess:id/timeZone_dropdown");
    private final By siteNameDropdown = By.id("com.zkbiocloudaccess:id/site_name_dropdown");
    private final By saveButton = By.id("com.zkbiocloudaccess:id/apply_btn");
    private final By deviceDeleteConfirmation = By.id("com.zkbiocloudaccess:id/delete_tv");
    private final By editDeviceBackButton = By.id("com.zkbiocloudaccess:id/back");
    //Filter
    private final By onlineCheckbox = By.id("com.zkbiocloudaccess:id/filter_value_1");
    private final By offlineCheckbox = By.id("com.zkbiocloudaccess:id/filter_value_2");
    private final By clearAllButton = By.id("com.zkbiocloudaccess:id/clear_text");
    private final By clearFilterButton = By.id("com.zkbiocloudaccess:id/clear_filter_tv");
    private final By filterApplyButton = By.id("com.zkbiocloudaccess:id/apply_text");
    private final By registeredDeviceOption = By.id("com.zkbiocloudaccess:id/filter_option_2");
    private final By registeredCheckbox = By.id("com.zkbiocloudaccess:id/filter_value_2_1");
    private final By unRegisteredCheckbox = By.id("com.zkbiocloudaccess:id/filter_value_2_2");
    private final By filterCloseIcon = By.id("com.zkbiocloudaccess:id/close_iv");
    //Auto Search
    private final By deviceContainerList = By.id("com.zkbiocloudaccess:id/row");
    private final By checkBox = By.id("com.zkbiocloudaccess:id/img_check_box");
    private final By ipAdress = By.id("com.zkbiocloudaccess:id/txt_ip_address");
    private final By serialNumber = By.id("com.zkbiocloudaccess:id/txt_serialNumber");
    private final By deviceType = By.id("com.zkbiocloudaccess:id/txt_deviceType");
    private final By addSelectDeviceButton = By.id("com.zkbiocloudaccess:id/btn_add");
    private final By autoSearchCrossButtonorBackbutton = By.id("com.zkbiocloudaccess:id/back_iv");
    private final By pageRefreshIcon = By.id("com.zkbiocloudaccess:id/iv_refresh");
    //Door & Access control
    private final By doorNameList = By.id("com.zkbiocloudaccess:id/device_name_val");
    private final By doorStatusList = By.id("com.zkbiocloudaccess:id/enabled_val");
    private final By expandIconList = By.id("com.zkbiocloudaccess:id/img_drop_down");
    private final By doorInfoIconList = By.id("com.zkbiocloudaccess:id/infoIv");
    private final By doorSerialNumberList = By.id("com.zkbiocloudaccess:id/serial_nu_val");
    private final By doorNumberList = By.id("com.zkbiocloudaccess:id/ip_add_val");
    private final By timeZoneList = By.id("com.zkbiocloudaccess:id/time_zone_val");
    private final By verificationList = By.id("com.zkbiocloudaccess:id/verification_val");
    //operation on Door
    private final By doorvalue = By.id("com.zkbiocloudaccess:id/door_val");
    private final By doorOpenandClosetextList = By.id("com.zkbiocloudaccess:id/ivText"); //0->open ,1-> close
    private final By doorOpenandCloseIconList = By.id("com.zkbiocloudaccess:id/ivImage"); //0->open ,1-> close
    //Access Control
    private final By accessLevelText = By.id("com.zkbiocloudaccess:id/tvCountry");
    private final By addIcon = By.id("com.zkbiocloudaccess:id/fab_add_access");
    private final By accessLevelList = By.id("com.zkbiocloudaccess:id/txt_level_name");
    private final By levelNameTextfield = By.id("com.zkbiocloudaccess:id/level_name_et");
    private final By timeperiodDropdown = By.id("com.zkbiocloudaccess:id/time_period_dropdown");
    private final By siteDropdown = By.id("com.zkbiocloudaccess:id/zone_dropdown");
    private final By addButton = By.id("com.zkbiocloudaccess:id/apply_btn");
    private final By checkBoxlist = By.id("com.zkbiocloudaccess:id/row");
    private final By timePeriodList = By.id("com.zkbiocloudaccess:id/txt_accessibility");
    private final By doorCountList = By.id("com.zkbiocloudaccess:id/txt_door_count");
    private final By personCountList = By.id("com.zkbiocloudaccess:id/txt_user_count");
    private final By expandList = By.id("com.zkbiocloudaccess:id/img_drop_down");
    //Access Controls -> Person
    private final By personTab = By.xpath("//android.widget.LinearLayout[@content-desc=\"Person\"]");
    private final By departmentTab = By.xpath("//android.widget.LinearLayout[@content-desc=\"Department\"]");
    private final By employeeRefreshButton = By.id("com.zkbiocloudaccess:id/empty_list_button");
    private final By addPersonIcon = By.id("com.zkbiocloudaccess:id/fab_add_person");
    private final By addDepartmentIcon = By.id("com.zkbiocloudaccess:id/fab_add_access");
    private final By addPersonTitle = By.id("com.zkbiocloudaccess:id/title");
    private final By searchBar = By.id("com.zkbiocloudaccess:id/search_edt");
    private final By selectAllLink = By.id("com.zkbiocloudaccess:id/select_all_tv");
    private final By nameList = By.id("com.zkbiocloudaccess:id/txt_name");
    private final By empIdList = By.id("com.zkbiocloudaccess:id/txt_emp_id");
    private final By departmentList = By.id("com.zkbiocloudaccess:id/txt_department");
    private final By personCheckBoxList = By.id("com.zkbiocloudaccess:id/cb");
    private final By addPersonButton = By.id("com.zkbiocloudaccess:id/btn_add");
    private final By seletAllPersonLink = By.id("com.zkbiocloudaccess:id/select_all_tv");
    private final By personNameList = By.id("com.zkbiocloudaccess:id/txt_person_name");
    private final By departmentNameList = By.id("com.zkbiocloudaccess:id/txt_department_name");
    private final By employeeIdList = By.id("com.zkbiocloudaccess:id/txt_emp_id");
    private final By noDataFound = By.id("com.zkbiocloudaccess:id/txt_data_placeholder");
    private final By refreshButton = By.id("com.zkbiocloudaccess:id/empty_list_button");
    private final By addPersonName = By.id("com.zkbiocloudaccess:id/txt_name");
    //Reports
    private final By transactionText = By.id("com.zkbiocloudaccess:id/tvCountry");
    private final By bcakIcon = By.id("com.zkbiocloudaccess:id/back_iv1");
    private final By ArrowUpIcon = By.id("com.zkbiocloudaccess:id/up_img");
    private final By cardNumberList = By.id("com.zkbiocloudaccess:id/report_name_val");
    private final By personIDList = By.id("com.zkbiocloudaccess:id/personal_name_val");
    private final By deviceAliasList = By.id("com.zkbiocloudaccess:id/no_val");
    private final By serialNumberList = By.id("com.zkbiocloudaccess:id/serial_val");
    private final By eventTimeList = By.id("com.zkbiocloudaccess:id/even_time_val");
    private final By eventAddressList = By.id("com.zkbiocloudaccess:id/event_address");
    private final By eventNameList = By.id("com.zkbiocloudaccess:id/comm_type_val");
    private final By eventPointNameList = By.id("com.zkbiocloudaccess:id/eventPointName_val");
    private final By verificationModeList = By.id("com.zkbiocloudaccess:id/verificationMode_val");
    private final By reportContainerList = By.id("com.zkbiocloudaccess:id/container");
    private final By deviceAliasTexfield = By.id("com.zkbiocloudaccess:id/et_device_alias");
    private final By applyButton = By.id("com.zkbiocloudaccess:id/tv_apply");
    public HomePageObject(AndroidDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //Getters
    public By getCompanyTitleName() {
        return companyTitleName;
    }

    public By getHomePageElements() {
        return homePageElements;
    }

    public By getDeviceDropdown() {
        return deviceDropdown;
    }

    public By getDevicedropdownElement() {
        return devicedropdownElement;
    }

    public By getHomeSubmoduleIcon() {
        return homeSubmoduleIcon;
    }

    public By getDashboardSubmoduleIcon() {
        return dashboardSubmoduleIcon;
    }

    public By getOrganizationSubmoduleIcon() {
        return organizationSubmoduleIcon;
    }

    public By getMessageSubmoduleIcon() {
        return messageSubmoduleIcon;
    }

    public By getHamburgermenuIcon() {
        return hamburgermenuIcon;
    }

    public By getDeviceNameList() {
        return deviceNameList;
    }

    public By getDeviceSerialNumberList() {
        return deviceSerialNumberList;
    }

    public By getDeviceIPList() {
        return deviceIPList;
    }

    public By getDeviceStatusList() {
        return deviceStatusList;
    }

    public By getDeviceMangementAddicon() {
        return deviceMangementAddicon;
    }

    public By getUncheckIcon() {
        return uncheckIcon;
    }

    public By getSelectandDeselectAll() {
        return selectandDeselectAll;
    }

    public By getDeleteButton() {
        return deleteButton;
    }

    public By getFilterIcon() {
        return filterIcon;
    }

    public By getRefreshIcon() {
        return refreshIcon;
    }

    public By getCheckBox() {
        return checkBox;
    }

    public By getIpAdress() {
        return ipAdress;
    }

    public By getSerialNumber() {
        return serialNumber;
    }

    public By getDeviceType() {
        return deviceType;
    }

    public By getAddSelectDeviceButton() {
        return addSelectDeviceButton;
    }

    public By getAutoSearchCrossButtonorBackbutton() {
        return autoSearchCrossButtonorBackbutton;
    }

    public By getPageRefreshIcon() {
        return pageRefreshIcon;
    }

    public By getDoorNameList() {
        return doorNameList;
    }

    public By getDoorStatusList() {
        return doorStatusList;
    }

    public By getExpandIconList() {
        return expandIconList;
    }

    public By getDoorInfoIconList() {
        return doorInfoIconList;
    }

    public By getDoorSerialNumberList() {
        return doorSerialNumberList;
    }

    public By getDoorNumberList() {
        return doorNumberList;
    }

    public By getTimeZoneList() {
        return timeZoneList;
    }

    public By getVerificationList() {
        return verificationList;
    }

    public By getDoorvalue() {
        return doorvalue;
    }

    public By getDoorOpenandClosetextList() {
        return doorOpenandClosetextList;
    }

    public By getDoorOpenandCloseIconList() {
        return doorOpenandCloseIconList;
    }

    public By getAddIcon() {
        return addIcon;
    }

    public By getAccessLevelList() {
        return accessLevelList;
    }

    public By getLevelNameTextfield() {
        return levelNameTextfield;
    }

    public By getTimeperiodDropdown() {
        return timeperiodDropdown;
    }

    public By getSiteDropdown() {
        return siteDropdown;
    }

    public By getAddButton() {
        return addButton;
    }

    public By getAccessLevelText() {
        return accessLevelText;
    }

    public By getCheckBoxlist() {
        return checkBoxlist;
    }

    public By getTimePeriodList() {
        return timePeriodList;
    }

    public By getDoorCountList() {
        return doorCountList;
    }

    public By getPersonCountList() {
        return personCountList;
    }

    public By getExpandList() {
        return expandList;
    }

    public By getEditIcon() {
        return editIcon;
    }

    public By getDeleteIcon() {
        return deleteIcon;
    }

    public By getDeleteConfirmation() {
        return deleteConfirmation;
    }

    public By getPersonTab() {
        return personTab;
    }

    public By getEmployeeRefreshButton() {
        return employeeRefreshButton;
    }

    public By getAddPersonIcon() {
        return addPersonIcon;
    }

    public By getAddDeviceIcon() {
        return addDeviceIcon;
    }

    public By getAddPersonTitle() {
        return addPersonTitle;
    }

    public By getSearchBar() {
        return searchBar;
    }

    public By getSelectAllLink() {
        return selectAllLink;
    }

    public By getNameList() {
        return nameList;
    }

    public By getEmpIdList() {
        return empIdList;
    }

    public By getDepartmentList() {
        return departmentList;
    }

    public By getPersonCheckBoxList() {
        return personCheckBoxList;
    }

    public By getAddPersonButton() {
        return addPersonButton;
    }

    public By getSeletAllPersonLink() {
        return seletAllPersonLink;
    }

    public By getPersonNameList() {
        return personNameList;
    }

    public By getEmployeeIdList() {
        return employeeIdList;
    }

    public By getDeleteCancel() {
        return deleteCancel;
    }

    public By getNoDataFound() {
        return noDataFound;
    }

    public By getRefreshButton() {
        return refreshButton;
    }

    public By getAddPersonName() {
        return addPersonName;
    }

    public By getDepartmentTab() {
        return departmentTab;
    }

    public By getAddDepartmentIcon() {
        return addDepartmentIcon;
    }

    public By getDepartmentNameList() {
        return departmentNameList;
    }

    public By getTransactionText() {
        return transactionText;
    }

    public By getBcakIcon() {
        return bcakIcon;
    }

    public By getArrowUpIcon() {
        return ArrowUpIcon;
    }

    public By getCardNumberList() {
        return cardNumberList;
    }

    public By getPersonIDList() {
        return personIDList;
    }

    public By getDeviceAliasList() {
        return deviceAliasList;
    }

    public By getSerialNumberList() {
        return serialNumberList;
    }

    public By getEventTimeList() {
        return eventTimeList;
    }

    public By getEventAddressList() {
        return eventAddressList;
    }

    public By getEventNameList() {
        return eventNameList;
    }

    public By getEventPointNameList() {
        return eventPointNameList;
    }

    public By getVerificationModeList() {
        return verificationModeList;
    }

    public By getReportContainerList() {
        return reportContainerList;
    }

    public By getDeviceAliasTexfield() {
        return deviceAliasTexfield;
    }

    public By getApplyButton() {
        return applyButton;
    }

    public By getExpandIcon() {
        return expandIcon;
    }

    public By getRegisteredDevice() {
        return registeredDevice;
    }

    public By getFirmwareVersion() {
        return firmwareVersion;
    }

    public By getDeviceCheckbox() {
        return deviceCheckbox;
    }

    public By getEditDeviceName() {
        return editDeviceName;
    }

    public By getIconTypeDropdown() {
        return iconTypeDropdown;
    }

    public By getTimezoneDropdown() {
        return timezoneDropdown;
    }

    public By getSiteNameDropdown() {
        return siteNameDropdown;
    }

    public By getSaveButton() {
        return saveButton;
    }

    public By getDeviceDeleteConfirmation() {
        return deviceDeleteConfirmation;
    }

    public By getDeviceContainerList() {
        return deviceContainerList;
    }

    public By getEditDeviceBackButton() {
        return editDeviceBackButton;
    }

    public By getOnlineCheckbox() {
        return onlineCheckbox;
    }

    public By getOfflineCheckbox() {
        return offlineCheckbox;
    }

    public By getClearAllButton() {
        return clearAllButton;
    }

    public By getFilterApplyButton() {
        return filterApplyButton;
    }

    public By getRegisteredDeviceOption() {
        return registeredDeviceOption;
    }

    public By getRegisteredCheckbox() {
        return registeredCheckbox;
    }

    public By getUnRegisteredCheckbox() {
        return unRegisteredCheckbox;
    }

    public By getClearFilterButton() {
        return clearFilterButton;
    }

    public By getFilterCloseIcon() {
        return filterCloseIcon;
    }


}