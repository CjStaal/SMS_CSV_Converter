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
public final class Message implements Comparable {

    private final String date, sender, message;

    public Message(String date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
        System.out.println("Created message: " + this.toString());
    }

    private final String getDate() {
        return this.date;
    }

    private final String getSender() {
        return this.sender;
    }

    private final String getMessage() {
        return this.message;
    }

    @Override
    public final int compareTo(Object msg) {
        if (msg instanceof Message) {
            if (msg.toString().equals(this.toString())) {
                return 0;
            }
        }
        return 1;
    }

    @Override
    public final String toString() {
        return "\n" + this.getSender() + ": " + this.getDate() + ":\n" + this.getMessage() + "\n";
    }
}
