package pw2;

import com.squareup.wire.AnyMessage;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes19.dex */
public class p {
    public static <T extends Message> T a(Class<T> cls) {
        for (Class<?> cls2 : cls.getDeclaredClasses()) {
            if (cls2.getSimpleName().equals("Builder")) {
                try {
                    return (T) cls2.getDeclaredMethod("build", new Class[0]).invoke(cls2.newInstance(), new Object[0]);
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                } catch (InstantiationException e17) {
                    e17.printStackTrace();
                } catch (NoSuchMethodException e18) {
                    e18.printStackTrace();
                } catch (InvocationTargetException e19) {
                    e19.printStackTrace();
                }
            }
        }
        return null;
    }

    public static <T extends Message> AnyMessage b(Class<T> cls, T t16) {
        try {
            return new AnyMessage(cls.getName(), ByteString.of(((ProtoAdapter) cls.getField("ADAPTER").get(cls)).encode(t16)));
        } catch (Throwable th5) {
            n.b("PBParseUtils", "parseAnyData exception cls:" + cls.getName() + "\n" + th5);
            return null;
        }
    }

    public static <T extends Message> T c(Class<T> cls, AnyMessage anyMessage) {
        if (cls != null && anyMessage != null) {
            try {
                if (anyMessage.getValue() == null) {
                    return (T) a(cls);
                }
                return (T) ((ProtoAdapter) cls.getField("ADAPTER").get(cls)).decode(anyMessage.getValue());
            } catch (IOException e16) {
                n.c("PBParseUtils", e16);
                throw new RuntimeException("parseAnyData exception cls:" + cls.getName());
            } catch (IllegalAccessException e17) {
                n.c("PBParseUtils", e17);
                throw new RuntimeException("parseAnyData exception cls:" + cls.getName());
            } catch (NoSuchFieldException e18) {
                n.c("PBParseUtils", e18);
                throw new RuntimeException("parseAnyData exception cls:" + cls.getName());
            }
        }
        return null;
    }

    public static boolean d(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
