package zj3;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.rdelivery.dependencyimpl.MmkvStorage;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lzj3/a;", "Lcom/tencent/rdelivery/dependencyimpl/MmkvStorage$a;", "", "storageId", "", "b", "a", "Ljava/lang/String;", "fileDir", "Ljava/util/concurrent/ConcurrentHashMap;", "Lzj3/a$a;", "Ljava/util/concurrent/ConcurrentHashMap;", "lockMap", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements MmkvStorage.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String fileDir;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, C11686a> lockMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lzj3/a$a;", "", "", "fileDir", "storageId", "Ljava/nio/channels/FileChannel;", "a", "", "b", "c", "Ljava/lang/String;", "Ljava/nio/channels/FileLock;", "Ljava/nio/channels/FileLock;", "getLock", "()Ljava/nio/channels/FileLock;", "setLock", "(Ljava/nio/channels/FileLock;)V", JoinPoint.SYNCHRONIZATION_LOCK, "d", "Ljava/nio/channels/FileChannel;", "getLockFileChannel", "()Ljava/nio/channels/FileChannel;", "setLockFileChannel", "(Ljava/nio/channels/FileChannel;)V", "lockFileChannel", "", "e", "I", "getLockCount", "()I", "setLockCount", "(I)V", "lockCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zj3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11686a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String fileDir;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String storageId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private volatile FileLock lock;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private volatile FileChannel lockFileChannel;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private volatile int lockCount;

        public C11686a(String fileDir, String storageId) {
            Intrinsics.checkNotNullParameter(fileDir, "fileDir");
            Intrinsics.checkNotNullParameter(storageId, "storageId");
            this.fileDir = fileDir;
            this.storageId = storageId;
        }

        private final FileChannel a(String fileDir, String storageId) {
            try {
                File n3 = jz3.c.n(fileDir + File.separator + storageId + ".lock");
                Intrinsics.checkNotNullExpressionValue(n3, "safeCreateFile(lockFilePath)");
                return new FileOutputStream(n3).getChannel();
            } catch (Exception e16) {
                jz3.d.d("Reshub-ShiplyLockMgr", "Get LockFile Channel Exception(" + storageId + "): " + e16.getMessage() + ", tid:" + Thread.currentThread().getId(), e16);
                return null;
            }
        }

        public final synchronized void b() {
            if (this.lockCount == 0) {
                try {
                    FileChannel a16 = a(this.fileDir, this.storageId);
                    if (a16 == null) {
                        jz3.d.e("Reshub-ShiplyLockMgr", "Lock File Operate: " + this.storageId + ", return for null channel, tid:" + Thread.currentThread().getId());
                        return;
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 1000) {
                            jz3.d.e("Reshub-ShiplyLockMgr", "Lock File Operate: " + this.storageId + ", break for timeout sleepCount = " + i3 + ", tid:" + Thread.currentThread().getId());
                            break;
                        }
                        try {
                            this.lock = a16.tryLock();
                            if (this.lock != null) {
                                break;
                            }
                            jz3.d.a("Reshub-ShiplyLockMgr", "Lock File Operate: " + this.storageId + ", sleep for get null lock, tid:" + Thread.currentThread().getId());
                            LockMethodProxy.sleep(20L);
                            i3++;
                        } catch (OverlappingFileLockException unused) {
                            jz3.d.c("Reshub-ShiplyLockMgr", "Lock File Operate: " + this.storageId + ", return for OverlappingFileLockException, tid:" + Thread.currentThread().getId());
                            return;
                        }
                    }
                    if (this.lock != null) {
                        this.lockFileChannel = a16;
                    }
                } catch (Exception e16) {
                    jz3.d.d("Reshub-ShiplyLockMgr", "Lock File Operate(" + this.storageId + ") Exception: " + e16.getMessage() + ", tid:" + Thread.currentThread().getId(), e16);
                }
            }
            this.lockCount++;
        }

        public final synchronized void c() {
            this.lockCount--;
            if (this.lockCount == 0) {
                try {
                    FileLock fileLock = this.lock;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    FileChannel fileChannel = this.lockFileChannel;
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                } catch (Exception e16) {
                    jz3.d.d("Reshub-ShiplyLockMgr", "Unlock File Operate(" + this.storageId + ") Exception: " + e16.getMessage() + ", tid:" + Thread.currentThread().getId(), e16);
                }
            }
        }
    }

    public a(String fileDir) {
        Intrinsics.checkNotNullParameter(fileDir, "fileDir");
        this.fileDir = fileDir;
        this.lockMap = new ConcurrentHashMap<>();
    }

    @Override // com.tencent.rdelivery.dependencyimpl.MmkvStorage.a
    public void a(String storageId) {
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        C11686a c11686a = this.lockMap.get(storageId);
        if (c11686a != null) {
            c11686a.c();
        }
    }

    @Override // com.tencent.rdelivery.dependencyimpl.MmkvStorage.a
    public void b(String storageId) {
        C11686a c11686a;
        Intrinsics.checkNotNullParameter(storageId, "storageId");
        synchronized (this) {
            c11686a = this.lockMap.get(storageId);
            if (c11686a == null) {
                this.lockMap.put(storageId, new C11686a(this.fileDir, storageId));
                c11686a = this.lockMap.get(storageId);
            }
            Unit unit = Unit.INSTANCE;
        }
        C11686a c11686a2 = c11686a;
        if (c11686a2 != null) {
            c11686a2.b();
        }
    }
}
