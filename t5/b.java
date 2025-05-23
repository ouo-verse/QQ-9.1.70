package t5;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    public static byte[] c(JceStruct jceStruct) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("utf8");
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }

    public static <T extends JceStruct> T a(T t16, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf8");
                t16.readFrom(jceInputStream);
                return t16;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static <T extends JceStruct> T b(Class<T> cls, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("utf8");
            newInstance.readFrom(jceInputStream);
            return newInstance;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
