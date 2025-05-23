package px4;

import android.text.TextUtils;
import com.tencent.zplan.encode.d;
import com.tencent.zplan.encode.encode.f;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0012B%\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u0006J(\u0010\u0011\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0002J \u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0017\u0010\u0019\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020#0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010!\u00a8\u0006'"}, d2 = {"Lpx4/a;", "", "", "i", "", "b", "Lcom/tencent/zplan/encode/encode/f;", "data", "j", "c", "g", "", "", "dataSize", "frameIndex", "", "pts", h.F, "a", "f", "", "toString", "I", "d", "()I", "queueCacheSizeLimit", "e", "queueDataSizeAnchor", "Ljava/lang/String;", "getTempPath", "()Ljava/lang/String;", "tempPath", "Ljava/util/Queue;", "Ljava/util/Queue;", "frameQueue", "Ljava/nio/MappedByteBuffer;", "frameFdQueue", "<init>", "(IILjava/lang/String;)V", "hardware_encode_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int queueCacheSizeLimit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int queueDataSizeAnchor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String tempPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Queue<f> frameQueue;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Queue<MappedByteBuffer> frameFdQueue;

    public a(int i3, int i16, String tempPath) {
        Intrinsics.checkParameterIsNotNull(tempPath, "tempPath");
        this.queueCacheSizeLimit = i3;
        this.queueDataSizeAnchor = i16;
        this.tempPath = tempPath;
        if (!TextUtils.isEmpty(tempPath)) {
            File file = new File(tempPath);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        this.frameQueue = new ConcurrentLinkedQueue();
        this.frameFdQueue = new ConcurrentLinkedQueue();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean b() {
        MappedByteBuffer poll;
        int i3;
        Object m476constructorimpl;
        Throwable m479exceptionOrNullimpl;
        File file;
        int i16;
        long j3;
        int size = this.frameQueue.size();
        d.a("VideoFrameManager", 4, "readFrameIfNeeded cacheSize:" + size + ", queueCacheSizeLimit:" + this.queueCacheSizeLimit);
        if (size + 1 > this.queueCacheSizeLimit || (poll = this.frameFdQueue.poll()) == null) {
            return true;
        }
        byte[] bArr = new byte[this.queueDataSizeAnchor];
        try {
            Result.Companion companion = Result.INSTANCE;
            poll.get(bArr, 0, getQueueDataSizeAnchor());
            i3 = poll.getInt(getQueueDataSizeAnchor() - 0);
        } catch (Throwable th5) {
            th = th5;
            i3 = 0;
        }
        try {
            i16 = poll.getInt((getQueueDataSizeAnchor() - 0) + 4);
            j3 = poll.getLong((getQueueDataSizeAnchor() - 0) + 8);
            d.a("VideoFrameManager", 4, "readFrameIfNeeded frameIndex:" + i3 + ", pts:" + j3 + ", dataSize:" + i16);
        } catch (Throwable th6) {
            th = th6;
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
            if (Result.m483isSuccessimpl(m476constructorimpl)) {
            }
            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
            }
            poll.clear();
            file = new File(this.tempPath + '/' + hashCode() + util.base64_pad_url + i3 + ".txt");
            if (file.exists()) {
            }
            return false;
        }
        if (!f(bArr, i16, i3)) {
            m476constructorimpl = Result.m476constructorimpl(new f(bArr, i16, j3, i3));
            if (Result.m483isSuccessimpl(m476constructorimpl)) {
                this.frameQueue.offer((f) m476constructorimpl);
            }
            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                d.c("VideoFrameManager", 1, "readFrameIfNeeded throw ", m479exceptionOrNullimpl);
            }
            poll.clear();
            file = new File(this.tempPath + '/' + hashCode() + util.base64_pad_url + i3 + ".txt");
            if (file.exists()) {
                file.delete();
            }
            return false;
        }
        throw new NullPointerException("readFrameIfNeeded is invalid frame");
    }

    private final void c(f data) {
        File file = new File(this.tempPath + '/' + hashCode() + util.base64_pad_url + data.f385374d + ".txt");
        if (file.exists()) {
            file.createNewFile();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.write(data.f385371a);
        randomAccessFile.writeInt(data.f385374d);
        randomAccessFile.writeInt(data.f385372b);
        randomAccessFile.writeLong(data.f385373c);
        this.frameFdQueue.offer(randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 16 + this.queueDataSizeAnchor));
        randomAccessFile.close();
    }

    private final void i() {
        if (TextUtils.isEmpty(this.tempPath)) {
            return;
        }
        synchronized (this.frameFdQueue) {
            d.a("VideoFrameManager", 4, Intrinsics.stringPlus("readFrameIfNeeded frameFdQueue:", Integer.valueOf(this.frameFdQueue.size())));
            if (this.frameFdQueue.isEmpty()) {
                return;
            }
            synchronized (this.frameQueue) {
                if (b()) {
                    return;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void j(f data) {
        if (TextUtils.isEmpty(this.tempPath)) {
            return;
        }
        d.a("VideoFrameManager", 4, Intrinsics.stringPlus("writeFrameIntoFile data:", data));
        synchronized (this.frameFdQueue) {
            c(data);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a() {
        this.frameQueue.clear();
        Iterator<MappedByteBuffer> it = this.frameFdQueue.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.frameFdQueue.clear();
    }

    /* renamed from: d, reason: from getter */
    public final int getQueueCacheSizeLimit() {
        return this.queueCacheSizeLimit;
    }

    /* renamed from: e, reason: from getter */
    public final int getQueueDataSizeAnchor() {
        return this.queueDataSizeAnchor;
    }

    public final f g() {
        f poll;
        synchronized (this.frameQueue) {
            poll = this.frameQueue.poll();
        }
        i();
        return poll;
    }

    public final void h(byte[] data, int dataSize, int frameIndex, long pts) {
        f fVar = new f(data, dataSize, pts, frameIndex);
        synchronized (this.frameFdQueue) {
            if (!(!this.frameFdQueue.isEmpty()) && this.frameQueue.size() <= getQueueCacheSizeLimit()) {
                try {
                    this.frameQueue.offer(fVar);
                } catch (Throwable th5) {
                    d.c("VideoFrameManager", 1, "queueFrame error: ", th5);
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            j(fVar);
        }
    }

    public String toString() {
        return "queueCacheSizeLimit: " + this.queueCacheSizeLimit + ", queueDataSizeAnchor: " + this.queueDataSizeAnchor + ", quene size: " + this.frameQueue.size();
    }

    public final boolean f(byte[] data, int dataSize, int frameIndex) {
        return frameIndex < 0 || data == null || data.length != dataSize || dataSize > this.queueDataSizeAnchor;
    }
}
