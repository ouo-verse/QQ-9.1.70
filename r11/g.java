package r11;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g implements h {

    /* renamed from: a, reason: collision with root package name */
    private File f430499a;

    public g(File file) {
        this.f430499a = file;
    }

    @Override // r11.h
    public boolean a(@NonNull e eVar) throws IOException {
        com.tencent.local_edit.andserver.util.a.c(eVar, "The session can not be null.");
        String id5 = eVar.getId();
        if (!TextUtils.isEmpty(id5)) {
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    if (!com.tencent.local_edit.andserver.util.d.c(this.f430499a)) {
                        com.tencent.local_edit.andserver.util.d.a(null);
                        return false;
                    }
                    File file = new File(this.f430499a, id5);
                    if (!com.tencent.local_edit.andserver.util.d.d(file)) {
                        com.tencent.local_edit.andserver.util.d.a(null);
                        return false;
                    }
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file));
                    try {
                        eVar.e(objectOutputStream2);
                        com.tencent.local_edit.andserver.util.d.a(objectOutputStream2);
                        return true;
                    } catch (IOException e16) {
                        e = e16;
                        objectOutputStream = objectOutputStream2;
                        com.tencent.local_edit.andserver.util.d.e(new File(this.f430499a, id5));
                        throw e;
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream = objectOutputStream2;
                        com.tencent.local_edit.andserver.util.d.a(objectOutputStream);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } else {
            throw new IllegalStateException("The session id can not be empty or null.");
        }
    }
}
