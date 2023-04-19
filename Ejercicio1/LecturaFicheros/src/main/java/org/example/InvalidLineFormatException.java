package org.example;

import java.util.ArrayList;

public class InvalidLineFormatException extends Exception{

    public String CapturaError(String error){

        return error  + super.getStackTrace();
    }


}
