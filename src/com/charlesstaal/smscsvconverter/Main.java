/* 
 * Copyright (C) 2015 Charles Joseph Staal
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.charlesstaal.smscsvconverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charles Joseph Staal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Message> messageList = new ArrayList();
        try {
            //commaCount%7 == 0 Each Message.
            BufferedReader bf = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(new File("C:\\Users\\Charles\\Documents\\Jay.csv")), Charset.forName("UTF-8")));
            int data;
            int commaCount = 0;
            char temp;
            CharBuffer cb = CharBuffer.allocate(2048);
            while ((data = bf.read()) != -1) {
                temp = (char) data;
                System.out.println(temp);
                cb.append(temp);
                if (temp == ',') {
                    ++commaCount;
                    System.out.println("Commacount:" + commaCount);
                    if (commaCount % 7 == 0) {
                        System.out.println("Trying to generate message.");
                        messageList.add(MessageFactory.generateMessage(cb.toString()));
                        cb.clear();
                    }
                }

            }
            Collections.reverse(messageList);
            File newFile = new File("C\\Users\\Charles\\Documents\\JayConverted.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
            for (Message message : messageList) {
                bw.write(message.toString());
                bw.flush();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
