package q;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
class e {

    /* renamed from: f, reason: collision with root package name */
    private static final a f428105f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final a f428106a;

    /* renamed from: b, reason: collision with root package name */
    private final d f428107b;

    /* renamed from: c, reason: collision with root package name */
    private final r.b f428108c;

    /* renamed from: d, reason: collision with root package name */
    private final ContentResolver f428109d;

    /* renamed from: e, reason: collision with root package name */
    private final List<ImageHeaderParser> f428110e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<ImageHeaderParser> list, d dVar, r.b bVar, ContentResolver contentResolver) {
        this(list, f428105f, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:75), block:B:26:0x004a */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(@NonNull Uri uri) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        try {
            try {
                cursor = this.f428107b.a(uri);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(0);
                            cursor.close();
                            return string;
                        }
                    } catch (SecurityException e16) {
                        e = e16;
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (SecurityException e17) {
                e = e17;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (cursor3 != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            cursor3 = cursor2;
            if (cursor3 != null) {
                cursor3.close();
            }
            throw th;
        }
    }

    private boolean c(File file) {
        if (this.f428106a.a(file) && 0 < this.f428106a.c(file)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f428109d.openInputStream(uri);
                int b16 = com.bumptech.glide.load.b.b(this.f428110e, inputStream, this.f428108c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return b16;
            } catch (IOException | NullPointerException e16) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e16);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException unused2) {
                        return -1;
                    }
                }
                return -1;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th5;
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b16 = b(uri);
        if (TextUtils.isEmpty(b16)) {
            return null;
        }
        File b17 = this.f428106a.b(b16);
        if (!c(b17)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b17);
        try {
            return this.f428109d.openInputStream(fromFile);
        } catch (NullPointerException e16) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e16));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, r.b bVar, ContentResolver contentResolver) {
        this.f428106a = aVar;
        this.f428107b = dVar;
        this.f428108c = bVar;
        this.f428109d = contentResolver;
        this.f428110e = list;
    }
}
