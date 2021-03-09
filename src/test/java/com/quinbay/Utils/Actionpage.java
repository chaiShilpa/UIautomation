package com.quinbay.Utils;

import com.quinbay.Pages.XpathPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Actionpage {
XpathPage xpath;
    public Actionpage(WebDriver driver) {
        xpath = PageFactory.initElements(driver, XpathPage.class);
    }
public void name_palce(){
    xpath.name();
}
}
