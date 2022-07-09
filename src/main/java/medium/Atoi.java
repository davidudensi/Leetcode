/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

/**
 *
 * @author hp
 */
public class Atoi {

    public int myAtoi(String s) {
        enum State {
            UNSET, NEGATIVE, POSITIVE
        }
        StringBuilder result = new StringBuilder();
        State lead = State.UNSET;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                    if (lead == State.UNSET) {
                        lead = s.charAt(i) == '-' ? State.NEGATIVE
                                : State.POSITIVE;
                        continue;
                    }
                    break;
                }

                if (s.codePointAt(i) > 47 && s.codePointAt(i) < 58) {
                    result.append(s.charAt(i));
                    if (lead == State.UNSET) {
                        lead = State.POSITIVE;
                    }
                } else {
                    break;
                }
            }
            if (result.length() >= 9) {
                if (exceeds(result)) {
                    System.out.println(lead);
                    return (Integer.MAX_VALUE
                            * (lead == State.NEGATIVE ? -1 : 1))
                            + (lead == State.NEGATIVE ? -1 : 0);
                }
            }
        }
        if (result.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(result.toString())
                * (lead == State.NEGATIVE ? -1 : 1);
    }

    private boolean exceeds(StringBuilder s) {
        try {
            Integer.parseInt(s.toString());
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("00000-42a1234"));
    }
}
