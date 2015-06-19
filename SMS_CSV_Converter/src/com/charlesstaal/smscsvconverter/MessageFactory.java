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

import java.nio.CharBuffer;

/**
 *
 * @author Charles Joseph Staal
 */
public class MessageFactory {

    public static Message generateMessage(char[] message) {
        char[][] info = new char[7][];
        int commaCount = 0;
        int index = 0;
        CharBuffer cb = CharBuffer.allocate(message.length);
        while (commaCount < 7) {
            if (message[index] == ',') {
                info[index] = cb.array();
                ++index;
                ++commaCount;
                cb.clear();
            }
        }
        return new Message(String.copyValueOf(info[1]), String.copyValueOf(info[1]), String.copyValueOf(info[6]));
    }
}
