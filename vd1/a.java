package vd1;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.MD5;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class a {
    public static String a(@NonNull String str, @NonNull String str2) {
        return str + "/" + MD5.toMD5(str2) + ".jpg";
    }

    public static String b(@NonNull String str, @NonNull String str2) {
        return str + "/" + MD5.toMD5(str2) + ".mp4";
    }
}
