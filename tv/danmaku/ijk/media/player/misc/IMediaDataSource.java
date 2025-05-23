package tv.danmaku.ijk.media.player.misc;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes30.dex */
public interface IMediaDataSource {
    void close() throws IOException;

    long getSize() throws IOException;

    int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException;
}
