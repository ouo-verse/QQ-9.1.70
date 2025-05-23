package wns_proxy;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class EnumHttpMethod implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _eGET = 0;
    public static final int _ePOST = 1;
    private String __T;
    private int __value;
    private static EnumHttpMethod[] __values = new EnumHttpMethod[2];
    public static final EnumHttpMethod eGET = new EnumHttpMethod(0, 0, "eGET");
    public static final EnumHttpMethod ePOST = new EnumHttpMethod(1, 1, "ePOST");

    EnumHttpMethod(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static EnumHttpMethod convert(int i3) {
        int i16 = 0;
        while (true) {
            EnumHttpMethod[] enumHttpMethodArr = __values;
            if (i16 >= enumHttpMethodArr.length) {
                return null;
            }
            if (enumHttpMethodArr[i16].value() == i3) {
                return __values[i16];
            }
            i16++;
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static EnumHttpMethod convert(String str) {
        int i3 = 0;
        while (true) {
            EnumHttpMethod[] enumHttpMethodArr = __values;
            if (i3 >= enumHttpMethodArr.length) {
                return null;
            }
            if (enumHttpMethodArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
