package z81;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import androidx.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private RenderScript f452152a;

        /* renamed from: b, reason: collision with root package name */
        private ScriptIntrinsicYuvToRGB f452153b;

        /* renamed from: c, reason: collision with root package name */
        private Type.Builder f452154c;

        /* renamed from: d, reason: collision with root package name */
        private Type.Builder f452155d;

        /* renamed from: e, reason: collision with root package name */
        private Allocation f452156e;

        /* renamed from: f, reason: collision with root package name */
        private Allocation f452157f;

        @RequiresApi(api = 17)
        public a(Context context) {
            RenderScript create = RenderScript.create(context);
            this.f452152a = create;
            this.f452153b = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
        }

        @RequiresApi(api = 17)
        public Bitmap a(byte[] bArr, int i3, int i16) {
            if (this.f452154c == null) {
                RenderScript renderScript = this.f452152a;
                Type.Builder x16 = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
                this.f452154c = x16;
                this.f452156e = Allocation.createTyped(this.f452152a, x16.create(), 1);
                RenderScript renderScript2 = this.f452152a;
                Type.Builder y16 = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i3).setY(i16);
                this.f452155d = y16;
                this.f452157f = Allocation.createTyped(this.f452152a, y16.create(), 1);
            }
            this.f452156e.copyFrom(bArr);
            this.f452153b.setInput(this.f452156e);
            this.f452153b.forEach(this.f452157f);
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            this.f452157f.copyTo(createBitmap);
            return createBitmap;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0050 -> B:20:0x0068). Please report as a decompilation issue!!! */
    public static boolean a(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i3, boolean z16) {
        File file = new File(str);
        boolean z17 = false;
        try {
            File file2 = new File(str.substring(0, str.lastIndexOf("/")));
            if (!file2.exists()) {
                file2.mkdirs();
            }
        } catch (Exception unused) {
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e16) {
                QLog.e("Utils", 1, "create new bitmap file exception ", e16);
            }
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        z17 = bitmap.compress(compressFormat, i3, bufferedOutputStream2);
                        bufferedOutputStream2.flush();
                        if (z16) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream2.close();
                    } catch (Exception e17) {
                        e = e17;
                        bufferedOutputStream = bufferedOutputStream2;
                        QLog.e("Utils", 1, "saveBitmapToFile exception", e);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return z17;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e19) {
                e = e19;
            }
        } catch (IOException e26) {
            e26.printStackTrace();
        }
        return z17;
    }
}
