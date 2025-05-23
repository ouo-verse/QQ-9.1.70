package rl;

import com.qzone.reborn.util.i;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static Serializable a(byte[] bArr) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Serializable serializable = (Serializable) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return serializable;
    }

    public static void b(String str, long j3) {
        i.b().m(c(str, j3), new byte[0]);
    }

    private static String c(String str, long j3) {
        return "qzone_publish_draft_info_" + str + "_" + j3;
    }

    public static <T extends Serializable> T d(String str, long j3, Class<T> cls) {
        try {
            return (T) a(i.b().e(c(str, j3), new byte[0]));
        } catch (Exception e16) {
            QLog.e("QZoneDraftUtils", 1, "[getPublishDraftInfo] error:" + e16);
            return null;
        }
    }

    public static void e(String str, Serializable serializable, long j3) {
        try {
            i.b().m(c(str, j3), f(serializable));
            RFWLog.d("QZoneDraftUtils", RFWLog.USR, "[savePublishDraftInfo] succeed");
        } catch (IOException e16) {
            RFWLog.e("QZoneDraftUtils", RFWLog.USR, "[savePublishDraftInfo] error:" + e16);
        }
    }

    public static byte[] f(Serializable serializable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
