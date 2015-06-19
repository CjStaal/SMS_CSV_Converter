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

/**
 *
 * @author Charles Joseph Staal
 */
public class MessageFactory {

    public static Message generateMessage(char[] message) {
        String[] info = new String[7];
        StringBuilder sb = new StringBuilder();
        int commaCount = 0;
        message = String.valueOf(message).trim().toCharArray();
        for (int index0 = 0, index1 = 0; index0 < message.length; index0++) {
            if (commaCount < 6) {
                if (message[index0] == ',') {
                    ++commaCount;
                    info[index1++] = sb.toString();
                    sb.delete(0, sb.length());
                } else {
                    sb.append(message[index0]);
                }
            } else {
                sb.append(message[index0]);
            }
        }
        info[info.length-1] = sb.toString();
        sb.delete(0, sb.length());
        return new Message(info[4], info[1], info[6]);
    }
}
