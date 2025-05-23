package ur0;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lur0/a;", "", "Ljava/io/File;", "file", "", "a", "<init>", "()V", "guild-coms-util_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f439860a = new a();

    a() {
    }

    public final boolean a(@Nullable File file) {
        File file2;
        byte[] copyOfRange;
        if (file == null) {
            return false;
        }
        try {
            if (file.exists()) {
                file2 = file;
            } else {
                file2 = null;
            }
            if (file2 == null) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[3];
                randomAccessFile.read(bArr);
                copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(bArr, 0, 3);
                boolean areEqual = Intrinsics.areEqual(new String(copyOfRange, Charsets.UTF_8), "GIF");
                CloseableKt.closeFinally(randomAccessFile, null);
                return areEqual;
            } finally {
            }
        } catch (Exception e16) {
            QLog.e("ImageUtil", 1, "isGifFile error: ", e16);
            return false;
        }
    }
}
