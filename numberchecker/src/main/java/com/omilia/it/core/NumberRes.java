
package com.omilia.it.core;

import java.util.Objects;


public class NumberRes {
    private String phone;
    private boolean valid;
    
    public NumberRes(String p,boolean b){
        this.phone = p;
        this.valid = b;
    }
    
    public NumberRes(String p){
        this(p,false);
    }

    
    public String getPhone() {
        return phone;
    }

    public boolean isValid() {
        return valid;
    }
    
    public void setIsValid(boolean v) {
        this.valid = v;
    }

    @Override
    public int hashCode() {
        return this.phone.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NumberRes other = (NumberRes) obj;
        return Objects.equals(this.phone, other.phone);
    }
    
    
}
