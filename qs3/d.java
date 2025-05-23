package qs3;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lqs3/d;", "", "", "c", "", "a", "I", "b", "()I", "e", "(I)V", "retCode", "", "[B", "()[B", "d", "([B)V", "data", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int retCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] data;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getRetCode() {
        return this.retCode;
    }

    public final boolean c() {
        if (this.retCode == 0) {
            return true;
        }
        return false;
    }

    public final void d(@Nullable byte[] bArr) {
        this.data = bArr;
    }

    public final void e(int i3) {
        this.retCode = i3;
    }
}
