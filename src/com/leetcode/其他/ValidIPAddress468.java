package com.leetcode.其他;

public class ValidIPAddress468 {

    public String validIPAddress(String queryIP) {

        if(queryIP.contains(".") && queryIP.contains(":")){
            return "Neither";
        }else if(queryIP.contains(".")){
            if(validateIpV4(queryIP)){
                return "IPv4";
            }
        }else {
            if(validateIpV6(queryIP)){
                return "IPv6";
            }
        }

        return "Neither";

    }



    public boolean validateIpV4(String ipv4){

        if(ipv4 == null || "".equals(ipv4)){
            return false;
        }

        // FIXME: 2022/4/3 split("",-1);很重要
        String[] strs = ipv4.split("\\.",-1);
        if(strs.length != 4){
            return false;
        }

        for(String tmp : strs){
            if(tmp.length() == 0 || tmp.length() > 3){
                return false;
            }

            if(tmp.charAt(0) == '0' && tmp.length() != 1){
                return false;
            }

            int amount = 0;
            for(char c : tmp.toCharArray()){
                int a =  c- '0';
                if(a<0 || a>9){
                    return false;
                }
                amount = 10 * amount + a;
            }

            if(amount < 0 || amount > 255){
                return false;
            }
        }

        return true;
    }



    public boolean validateIpV6(String ipv6){

        if(ipv6 == null || "".equals(ipv6) ){
            return false;
        }

        String[] strs = ipv6.split(":",-1);
        if(strs.length != 8){
            return false;
        }

        for(String tmp : strs){
            if(tmp.length() == 0 || tmp.length() > 4){
                return false;
            }
            for(char c : tmp.toCharArray()){
                if(!(
                        (c-'0' >=0 && c-'0' <=9) ||
                                (c-'a' >=0 && c-'a' <=5) ||
                                (c-'A' >=0 && c-'A' <=5)
                )){
                    return false;
                }
            }
        }

        return true;
    }



}
