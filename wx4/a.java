package wx4;

import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_ENCODER_OOM;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\t\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\bH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0002H\u0096\u0001J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u000fH\u0096\u0001R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lwx4/a;", "Lcom/tencent/zplan/meme/encoder/a;", "", "portraitId", "", "pixels", "width", "height", "", "b", "", "outputFilePath", "frameTime", "Lcom/tencent/zplan/meme/action/ActionStatus;", "a", "", "close", "c", "getFrameCount", "", "getFrames", "init", "Lwx4/c;", "Lwx4/c;", "statistic", "Lcom/tencent/zplan/meme/encoder/a;", "impl", "<init>", "(Lwx4/c;Lcom/tencent/zplan/meme/encoder/a;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a implements com.tencent.zplan.meme.encoder.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final c statistic;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.zplan.meme.encoder.a impl;

    public a(@NotNull c statistic, @NotNull com.tencent.zplan.meme.encoder.a impl) {
        Intrinsics.checkNotNullParameter(statistic, "statistic");
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.statistic = statistic;
        this.impl = impl;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public ActionStatus a(int portraitId, @NotNull String outputFilePath, int frameTime) {
        ActionStatus actionStatus;
        Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
        this.statistic.b(portraitId);
        try {
            actionStatus = this.impl.a(portraitId, outputFilePath, frameTime);
        } catch (OutOfMemoryError unused) {
            this.statistic.d(true);
            actionStatus = ERROR_ENCODER_OOM.INSTANCE;
        }
        this.statistic.a(portraitId, actionStatus, outputFilePath, this.impl.getFrameCount());
        return actionStatus;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public boolean b(int portraitId, @NotNull byte[] pixels, int width, int height) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        try {
            return this.impl.b(portraitId, pixels, width, height);
        } catch (OutOfMemoryError unused) {
            this.statistic.d(true);
            return false;
        }
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public boolean c() {
        return this.impl.c();
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void close() {
        this.impl.close();
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public int getFrameCount() {
        return this.impl.getFrameCount();
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public List<String> getFrames() {
        return this.impl.getFrames();
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void init() {
        this.impl.init();
    }
}
