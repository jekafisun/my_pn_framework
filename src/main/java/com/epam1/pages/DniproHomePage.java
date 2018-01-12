package com.epam1.pages;

import com.epam1.blocks.HeaderBlock;

public class DniproHomePage extends BasePage {
    private HeaderBlock headerBlock;

    public String getCityName() {
        return headerBlock.getCityName();
    }
}
