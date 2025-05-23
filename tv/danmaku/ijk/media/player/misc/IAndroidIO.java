package tv.danmaku.ijk.media.player.misc;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes30.dex */
public interface IAndroidIO {
    int close() throws IOException;

    int open(String str) throws IOException;

    int read(byte[] bArr, int i3) throws IOException;

    long seek(long j3, int i3) throws IOException;
}
