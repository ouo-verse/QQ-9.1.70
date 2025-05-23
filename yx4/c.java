package yx4;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.model.GeneralRecordSwitches;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\b*\u0014\u0018\u001e\u0004\u001d$\u001aJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010%\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\bH\u0016\u00a8\u00061"}, d2 = {"Lyx4/c;", "", "", "userId", "f", "jsonParams", "", "appearanceKeyChangeFromEngine", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "data", DomainData.DOMAIN_NAME, "Lyx4/c$c;", "getConfig", "avatarSceneParams", "notifyEnterAvatarScene", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "j", "c", "l", "i", "p", "t", "g", "e", "k", "getZPlanVersion", "Lcom/tencent/zplan/record/a;", "scene", "Lcom/tencent/zplan/record/model/c;", h.F, "enableFilament", "Lcom/tencent/zplan/meme/EngineType;", "v", "r", "Lyx4/c$b;", "a", "Lyx4/c$h;", DownloadInfo.spKey_Config, "o", "Lyx4/c$e;", "d", ReportConstant.COSTREPORT_PREFIX, "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lyx4/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "apngCheckHeapSize", "J", "b", "()J", "apng2GifLimitAlpha", "I", "a", "()I", "streamingMode", "Z", "c", "()Z", "<init>", "(JIZ)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: yx4.c$a, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class APNGModeConfig {

        @SerializedName("apng2GifLimitAlpha")
        private final int apng2GifLimitAlpha;

        @SerializedName("apngCheckHeapSize")
        private final long apngCheckHeapSize;

        @SerializedName("streamingMode")
        private final boolean streamingMode;

        public APNGModeConfig() {
            this(0L, 0, false, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getApng2GifLimitAlpha() {
            return this.apng2GifLimitAlpha;
        }

        /* renamed from: b, reason: from getter */
        public final long getApngCheckHeapSize() {
            return this.apngCheckHeapSize;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getStreamingMode() {
            return this.streamingMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof APNGModeConfig) {
                    APNGModeConfig aPNGModeConfig = (APNGModeConfig) other;
                    if (this.apngCheckHeapSize != aPNGModeConfig.apngCheckHeapSize || this.apng2GifLimitAlpha != aPNGModeConfig.apng2GifLimitAlpha || this.streamingMode != aPNGModeConfig.streamingMode) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((androidx.fragment.app.a.a(this.apngCheckHeapSize) * 31) + this.apng2GifLimitAlpha) * 31;
            boolean z16 = this.streamingMode;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "APNGModeConfig(apngCheckHeapSize=" + this.apngCheckHeapSize + ", apng2GifLimitAlpha=" + this.apng2GifLimitAlpha + ", streamingMode=" + this.streamingMode + ")";
        }

        public APNGModeConfig(long j3, int i3, boolean z16) {
            this.apngCheckHeapSize = j3;
            this.apng2GifLimitAlpha = i3;
            this.streamingMode = z16;
        }

        public /* synthetic */ APNGModeConfig(long j3, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1048576L : j3, (i16 & 2) != 0 ? 10 : i3, (i16 & 4) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lyx4/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "enableSuperQQShowBackend", "Z", "a", "()Z", "Lyx4/c$h;", "localResourceUploadConfig", "Lyx4/c$h;", "b", "()Lyx4/c$h;", "<init>", "(ZLyx4/c$h;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: yx4.c$b, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class CloudCommonConfig {

        @SerializedName("enableSuperQQShowBackend")
        private final boolean enableSuperQQShowBackend;

        @SerializedName("localResourceUploadConfig")
        @NotNull
        private final LocalResourceUploadConfig localResourceUploadConfig;

        public CloudCommonConfig() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getEnableSuperQQShowBackend() {
            return this.enableSuperQQShowBackend;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final LocalResourceUploadConfig getLocalResourceUploadConfig() {
            return this.localResourceUploadConfig;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof CloudCommonConfig) {
                    CloudCommonConfig cloudCommonConfig = (CloudCommonConfig) other;
                    if (this.enableSuperQQShowBackend != cloudCommonConfig.enableSuperQQShowBackend || !Intrinsics.areEqual(this.localResourceUploadConfig, cloudCommonConfig.localResourceUploadConfig)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            int i3;
            boolean z16 = this.enableSuperQQShowBackend;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            LocalResourceUploadConfig localResourceUploadConfig = this.localResourceUploadConfig;
            if (localResourceUploadConfig != null) {
                i3 = localResourceUploadConfig.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "CloudCommonConfig(enableSuperQQShowBackend=" + this.enableSuperQQShowBackend + ", localResourceUploadConfig=" + this.localResourceUploadConfig + ")";
        }

        public CloudCommonConfig(boolean z16, @NotNull LocalResourceUploadConfig localResourceUploadConfig) {
            Intrinsics.checkNotNullParameter(localResourceUploadConfig, "localResourceUploadConfig");
            this.enableSuperQQShowBackend = z16;
            this.localResourceUploadConfig = localResourceUploadConfig;
        }

        public /* synthetic */ CloudCommonConfig(boolean z16, LocalResourceUploadConfig localResourceUploadConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? new LocalResourceUploadConfig(0.0f, 0, null, null, 15, null) : localResourceUploadConfig);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u00a7\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010-\u001a\u00020,\u0012\b\b\u0002\u00102\u001a\u000201\u0012\b\b\u0002\u00106\u001a\u00020\u0007\u0012\b\b\u0002\u00108\u001a\u00020\u0007\u0012\b\b\u0002\u0010:\u001a\u00020\u0007\u00a2\u0006\u0004\b<\u0010=J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u001a\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\fR\u001a\u0010\u001a\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001a\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b!\u0010\fR\u001a\u0010#\u001a\u00020\"8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020'8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020,8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00102\u001a\u0002018\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b6\u0010\u001b\u001a\u0004\b7\u0010\u001dR\u001a\u00108\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b8\u0010\u001b\u001a\u0004\b9\u0010\u001dR\u001a\u0010:\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b:\u0010\u001b\u001a\u0004\b;\u0010\u001d\u00a8\u0006>"}, d2 = {"Lyx4/c$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "maxRetryCount", "I", "k", "()I", "", "timeout", "J", "o", "()J", "cacheSize", "b", "frameRate", h.F, "maximumFrameCount", "l", "encodeThreadPoolSize", "f", "killProcessOnDestroy", "Z", "getKillProcessOnDestroy", "()Z", "genRecordKeyWithGender", "i", "taskIdStartFrom", DomainData.DOMAIN_NAME, "Lyx4/c$f;", "frameModeConfig", "Lyx4/c$f;", "g", "()Lyx4/c$f;", "Lyx4/c$a;", "apngModeConfig", "Lyx4/c$a;", "a", "()Lyx4/c$a;", "Lyx4/c$g;", "gifModeConfig", "Lyx4/c$g;", "j", "()Lyx4/c$g;", "Lyx4/c$i;", "sharpPConfig", "Lyx4/c$i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lyx4/c$i;", "enableRecordQueuePause", "e", "continueOnResourceDownloadFailed", "c", "detectErrorOnL2NEnd", "d", "<init>", "(IJJIIIZZILyx4/c$f;Lyx4/c$a;Lyx4/c$g;Lyx4/c$i;ZZZ)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: yx4.c$c, reason: collision with other inner class name and from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class Config {

        @SerializedName("apngModeConfig")
        @NotNull
        private final APNGModeConfig apngModeConfig;

        @SerializedName("cacheSize")
        private final long cacheSize;

        @SerializedName("continueOnResourceDownloadFailed")
        private final boolean continueOnResourceDownloadFailed;

        @SerializedName("detectErrorOnL2NEnd")
        private final boolean detectErrorOnL2NEnd;

        @SerializedName("enableRecordQueuePause")
        private final boolean enableRecordQueuePause;

        @SerializedName("encodeThreadPoolSize")
        private final int encodeThreadPoolSize;

        @SerializedName("frameModeConfig")
        @NotNull
        private final FrameModeConfig frameModeConfig;

        @SerializedName("frameRate")
        private final int frameRate;

        @SerializedName("genRecordKeyWithGender")
        private final boolean genRecordKeyWithGender;

        @SerializedName("gifModeConfig")
        @NotNull
        private final GIFModeConfig gifModeConfig;

        @SerializedName("killProcessOnDestroy")
        private final boolean killProcessOnDestroy;

        @SerializedName("maxRetryCount")
        private final int maxRetryCount;

        @SerializedName("maximumFrameCount")
        private final int maximumFrameCount;

        @SerializedName("sharpPConfig")
        @NotNull
        private final SharpPConfig sharpPConfig;

        @SerializedName("taskIdStartFrom")
        private final int taskIdStartFrom;

        @SerializedName("timeout")
        private final long timeout;

        public Config() {
            this(0, 0L, 0L, 0, 0, 0, false, false, 0, null, null, null, null, false, false, false, 65535, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final APNGModeConfig getApngModeConfig() {
            return this.apngModeConfig;
        }

        /* renamed from: b, reason: from getter */
        public final long getCacheSize() {
            return this.cacheSize;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getContinueOnResourceDownloadFailed() {
            return this.continueOnResourceDownloadFailed;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getDetectErrorOnL2NEnd() {
            return this.detectErrorOnL2NEnd;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getEnableRecordQueuePause() {
            return this.enableRecordQueuePause;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Config) {
                    Config config = (Config) other;
                    if (this.maxRetryCount != config.maxRetryCount || this.timeout != config.timeout || this.cacheSize != config.cacheSize || this.frameRate != config.frameRate || this.maximumFrameCount != config.maximumFrameCount || this.encodeThreadPoolSize != config.encodeThreadPoolSize || this.killProcessOnDestroy != config.killProcessOnDestroy || this.genRecordKeyWithGender != config.genRecordKeyWithGender || this.taskIdStartFrom != config.taskIdStartFrom || !Intrinsics.areEqual(this.frameModeConfig, config.frameModeConfig) || !Intrinsics.areEqual(this.apngModeConfig, config.apngModeConfig) || !Intrinsics.areEqual(this.gifModeConfig, config.gifModeConfig) || !Intrinsics.areEqual(this.sharpPConfig, config.sharpPConfig) || this.enableRecordQueuePause != config.enableRecordQueuePause || this.continueOnResourceDownloadFailed != config.continueOnResourceDownloadFailed || this.detectErrorOnL2NEnd != config.detectErrorOnL2NEnd) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* renamed from: f, reason: from getter */
        public final int getEncodeThreadPoolSize() {
            return this.encodeThreadPoolSize;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final FrameModeConfig getFrameModeConfig() {
            return this.frameModeConfig;
        }

        /* renamed from: h, reason: from getter */
        public final int getFrameRate() {
            return this.frameRate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3;
            int i16;
            int i17;
            int a16 = ((((((((((this.maxRetryCount * 31) + androidx.fragment.app.a.a(this.timeout)) * 31) + androidx.fragment.app.a.a(this.cacheSize)) * 31) + this.frameRate) * 31) + this.maximumFrameCount) * 31) + this.encodeThreadPoolSize) * 31;
            boolean z16 = this.killProcessOnDestroy;
            int i18 = 1;
            int i19 = z16;
            if (z16 != 0) {
                i19 = 1;
            }
            int i26 = (a16 + i19) * 31;
            boolean z17 = this.genRecordKeyWithGender;
            int i27 = z17;
            if (z17 != 0) {
                i27 = 1;
            }
            int i28 = (((i26 + i27) * 31) + this.taskIdStartFrom) * 31;
            FrameModeConfig frameModeConfig = this.frameModeConfig;
            int i29 = 0;
            if (frameModeConfig != null) {
                i3 = frameModeConfig.hashCode();
            } else {
                i3 = 0;
            }
            int i36 = (i28 + i3) * 31;
            APNGModeConfig aPNGModeConfig = this.apngModeConfig;
            if (aPNGModeConfig != null) {
                i16 = aPNGModeConfig.hashCode();
            } else {
                i16 = 0;
            }
            int i37 = (i36 + i16) * 31;
            GIFModeConfig gIFModeConfig = this.gifModeConfig;
            if (gIFModeConfig != null) {
                i17 = gIFModeConfig.hashCode();
            } else {
                i17 = 0;
            }
            int i38 = (i37 + i17) * 31;
            SharpPConfig sharpPConfig = this.sharpPConfig;
            if (sharpPConfig != null) {
                i29 = sharpPConfig.hashCode();
            }
            int i39 = (i38 + i29) * 31;
            boolean z18 = this.enableRecordQueuePause;
            int i46 = z18;
            if (z18 != 0) {
                i46 = 1;
            }
            int i47 = (i39 + i46) * 31;
            boolean z19 = this.continueOnResourceDownloadFailed;
            int i48 = z19;
            if (z19 != 0) {
                i48 = 1;
            }
            int i49 = (i47 + i48) * 31;
            boolean z26 = this.detectErrorOnL2NEnd;
            if (!z26) {
                i18 = z26 ? 1 : 0;
            }
            return i49 + i18;
        }

        /* renamed from: i, reason: from getter */
        public final boolean getGenRecordKeyWithGender() {
            return this.genRecordKeyWithGender;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final GIFModeConfig getGifModeConfig() {
            return this.gifModeConfig;
        }

        /* renamed from: k, reason: from getter */
        public final int getMaxRetryCount() {
            return this.maxRetryCount;
        }

        /* renamed from: l, reason: from getter */
        public final int getMaximumFrameCount() {
            return this.maximumFrameCount;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final SharpPConfig getSharpPConfig() {
            return this.sharpPConfig;
        }

        /* renamed from: n, reason: from getter */
        public final int getTaskIdStartFrom() {
            return this.taskIdStartFrom;
        }

        /* renamed from: o, reason: from getter */
        public final long getTimeout() {
            return this.timeout;
        }

        @NotNull
        public String toString() {
            return "Config(maxRetryCount=" + this.maxRetryCount + ", timeout=" + this.timeout + ", cacheSize=" + this.cacheSize + ", frameRate=" + this.frameRate + ", maximumFrameCount=" + this.maximumFrameCount + ", encodeThreadPoolSize=" + this.encodeThreadPoolSize + ", killProcessOnDestroy=" + this.killProcessOnDestroy + ", genRecordKeyWithGender=" + this.genRecordKeyWithGender + ", taskIdStartFrom=" + this.taskIdStartFrom + ", frameModeConfig=" + this.frameModeConfig + ", apngModeConfig=" + this.apngModeConfig + ", gifModeConfig=" + this.gifModeConfig + ", sharpPConfig=" + this.sharpPConfig + ", enableRecordQueuePause=" + this.enableRecordQueuePause + ", continueOnResourceDownloadFailed=" + this.continueOnResourceDownloadFailed + ", detectErrorOnL2NEnd=" + this.detectErrorOnL2NEnd + ")";
        }

        public Config(int i3, long j3, long j16, int i16, int i17, int i18, boolean z16, boolean z17, int i19, @NotNull FrameModeConfig frameModeConfig, @NotNull APNGModeConfig apngModeConfig, @NotNull GIFModeConfig gifModeConfig, @NotNull SharpPConfig sharpPConfig, boolean z18, boolean z19, boolean z26) {
            Intrinsics.checkNotNullParameter(frameModeConfig, "frameModeConfig");
            Intrinsics.checkNotNullParameter(apngModeConfig, "apngModeConfig");
            Intrinsics.checkNotNullParameter(gifModeConfig, "gifModeConfig");
            Intrinsics.checkNotNullParameter(sharpPConfig, "sharpPConfig");
            this.maxRetryCount = i3;
            this.timeout = j3;
            this.cacheSize = j16;
            this.frameRate = i16;
            this.maximumFrameCount = i17;
            this.encodeThreadPoolSize = i18;
            this.killProcessOnDestroy = z16;
            this.genRecordKeyWithGender = z17;
            this.taskIdStartFrom = i19;
            this.frameModeConfig = frameModeConfig;
            this.apngModeConfig = apngModeConfig;
            this.gifModeConfig = gifModeConfig;
            this.sharpPConfig = sharpPConfig;
            this.enableRecordQueuePause = z18;
            this.continueOnResourceDownloadFailed = z19;
            this.detectErrorOnL2NEnd = z26;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Config(int i3, long j3, long j16, int i16, int i17, int i18, boolean z16, boolean z17, int i19, FrameModeConfig frameModeConfig, APNGModeConfig aPNGModeConfig, GIFModeConfig gIFModeConfig, SharpPConfig sharpPConfig, boolean z18, boolean z19, boolean z26, int i26, DefaultConstructorMarker defaultConstructorMarker) {
            this(r1, r2, r4, r6, r7, r8, r9, r11, r12, r16, r42, r17, r13, (i26 & 8192) != 0 ? true : z18, (i26 & 16384) != 0 ? true : z19, (i26 & 32768) != 0 ? true : z26);
            FrameModeConfig frameModeConfig2;
            APNGModeConfig aPNGModeConfig2;
            DefaultConstructorMarker defaultConstructorMarker2;
            GIFModeConfig gIFModeConfig2;
            GIFModeConfig gIFModeConfig3;
            SharpPConfig sharpPConfig2;
            int i27 = (i26 & 1) != 0 ? 2 : i3;
            long j17 = (i26 & 2) != 0 ? 65000L : j3;
            long j18 = (i26 & 4) != 0 ? 200L : j16;
            int i28 = (i26 & 8) != 0 ? 120 : i16;
            int i29 = (i26 & 16) != 0 ? 150 : i17;
            int i36 = (i26 & 32) != 0 ? 4 : i18;
            int i37 = 0;
            boolean z27 = (i26 & 64) != 0 ? false : z16;
            boolean z28 = (i26 & 128) != 0 ? false : z17;
            int i38 = (i26 & 256) != 0 ? 0 : i19;
            FrameModeConfig frameModeConfig3 = (i26 & 512) != 0 ? new FrameModeConfig(i37, 1, null) : frameModeConfig;
            APNGModeConfig aPNGModeConfig3 = (i26 & 1024) != 0 ? new APNGModeConfig(0L, 0, false, 7, null) : aPNGModeConfig;
            int i39 = 3;
            if ((i26 & 2048) != 0) {
                frameModeConfig2 = frameModeConfig3;
                aPNGModeConfig2 = aPNGModeConfig3;
                defaultConstructorMarker2 = null;
                gIFModeConfig2 = new GIFModeConfig(false, 0 == true ? 1 : 0, i39, defaultConstructorMarker2);
            } else {
                frameModeConfig2 = frameModeConfig3;
                aPNGModeConfig2 = aPNGModeConfig3;
                defaultConstructorMarker2 = null;
                gIFModeConfig2 = gIFModeConfig;
            }
            if ((i26 & 4096) != 0) {
                gIFModeConfig3 = gIFModeConfig2;
                int i46 = 0;
                sharpPConfig2 = new SharpPConfig(i46, i46, i39, defaultConstructorMarker2);
            } else {
                gIFModeConfig3 = gIFModeConfig2;
                sharpPConfig2 = sharpPConfig;
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d {
        public static void a(@NotNull c cVar, @NotNull String jsonParams) {
            Intrinsics.checkNotNullParameter(jsonParams, "jsonParams");
        }

        public static boolean b(@NotNull c cVar) {
            return true;
        }

        public static void c(@NotNull c cVar, @Nullable String str) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[zplan][MemePlayer-SDK]", 1, "notifyEnterAvatarScene: " + str, null, 8, null);
            }
        }

        public static int d(@NotNull c cVar) {
            return 6;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lyx4/c$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "configTimestamp", "J", "a", "()J", "", "forceDeleteItems", "Ljava/util/Set;", "b", "()Ljava/util/Set;", "<init>", "(JLjava/util/Set;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: yx4.c$e, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class ForceDeleteResourceConfig {

        @SerializedName("configTimestamp")
        private final long configTimestamp;

        @SerializedName("forceDeleteItems")
        @NotNull
        private final Set<String> forceDeleteItems;

        public ForceDeleteResourceConfig() {
            this(0L, null, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getConfigTimestamp() {
            return this.configTimestamp;
        }

        @NotNull
        public final Set<String> b() {
            return this.forceDeleteItems;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof ForceDeleteResourceConfig) {
                    ForceDeleteResourceConfig forceDeleteResourceConfig = (ForceDeleteResourceConfig) other;
                    if (this.configTimestamp != forceDeleteResourceConfig.configTimestamp || !Intrinsics.areEqual(this.forceDeleteItems, forceDeleteResourceConfig.forceDeleteItems)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int a16 = androidx.fragment.app.a.a(this.configTimestamp) * 31;
            Set<String> set = this.forceDeleteItems;
            if (set != null) {
                i3 = set.hashCode();
            } else {
                i3 = 0;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "ForceDeleteResourceConfig(configTimestamp=" + this.configTimestamp + ", forceDeleteItems=" + this.forceDeleteItems + ")";
        }

        public ForceDeleteResourceConfig(long j3, @NotNull Set<String> forceDeleteItems) {
            Intrinsics.checkNotNullParameter(forceDeleteItems, "forceDeleteItems");
            this.configTimestamp = j3;
            this.forceDeleteItems = forceDeleteItems;
        }

        public /* synthetic */ ForceDeleteResourceConfig(long j3, Set set, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? SetsKt__SetsKt.emptySet() : set);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lyx4/c$f;", "", "", "toString", "", "hashCode", "other", "", "equals", "waitingFrameIndex", "I", "a", "()I", "<init>", "(I)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: yx4.c$f, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class FrameModeConfig {

        @SerializedName("waitingFrameIndex")
        private final int waitingFrameIndex;

        public FrameModeConfig() {
            this(0, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getWaitingFrameIndex() {
            return this.waitingFrameIndex;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (!(other instanceof FrameModeConfig) || this.waitingFrameIndex != ((FrameModeConfig) other).waitingFrameIndex) {
                    return false;
                }
                return true;
            }
            return true;
        }

        public int hashCode() {
            return this.waitingFrameIndex;
        }

        @NotNull
        public String toString() {
            return "FrameModeConfig(waitingFrameIndex=" + this.waitingFrameIndex + ")";
        }

        public FrameModeConfig(int i3) {
            this.waitingFrameIndex = i3;
        }

        public /* synthetic */ FrameModeConfig(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lyx4/c$g;", "", "", "toString", "", "hashCode", "other", "", "equals", "streamingMode", "Z", "a", "()Z", "transparentThreshold", "I", "b", "()I", "<init>", "(ZI)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: yx4.c$g, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class GIFModeConfig {

        @SerializedName("streamingMode")
        private final boolean streamingMode;

        @SerializedName("transparentThreshold")
        private final int transparentThreshold;

        public GIFModeConfig() {
            this(false, 0 == true ? 1 : 0, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getStreamingMode() {
            return this.streamingMode;
        }

        /* renamed from: b, reason: from getter */
        public final int getTransparentThreshold() {
            return this.transparentThreshold;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof GIFModeConfig) {
                    GIFModeConfig gIFModeConfig = (GIFModeConfig) other;
                    if (this.streamingMode != gIFModeConfig.streamingMode || this.transparentThreshold != gIFModeConfig.transparentThreshold) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.streamingMode;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.transparentThreshold;
        }

        @NotNull
        public String toString() {
            return "GIFModeConfig(streamingMode=" + this.streamingMode + ", transparentThreshold=" + this.transparentThreshold + ")";
        }

        public GIFModeConfig(boolean z16, int i3) {
            this.streamingMode = z16;
            this.transparentThreshold = i3;
        }

        public /* synthetic */ GIFModeConfig(boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? 200 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lyx4/c$h;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "memory", UserInfo.SEX_FEMALE, "c", "()F", "apiLevel", "I", "a", "()I", "", "gpuBlackList", "Ljava/util/List;", "b", "()Ljava/util/List;", "modelBlackList", "d", "<init>", "(FILjava/util/List;Ljava/util/List;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: yx4.c$h, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class LocalResourceUploadConfig {

        @SerializedName("apiLevel")
        private final int apiLevel;

        @SerializedName("gpuBlackList")
        @NotNull
        private final List<String> gpuBlackList;

        @SerializedName("memory")
        private final float memory;

        @SerializedName("modelBlackList")
        @NotNull
        private final List<String> modelBlackList;

        public LocalResourceUploadConfig() {
            this(0.0f, 0, null, null, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getApiLevel() {
            return this.apiLevel;
        }

        @NotNull
        public final List<String> b() {
            return this.gpuBlackList;
        }

        /* renamed from: c, reason: from getter */
        public final float getMemory() {
            return this.memory;
        }

        @NotNull
        public final List<String> d() {
            return this.modelBlackList;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof LocalResourceUploadConfig) {
                    LocalResourceUploadConfig localResourceUploadConfig = (LocalResourceUploadConfig) other;
                    if (Float.compare(this.memory, localResourceUploadConfig.memory) != 0 || this.apiLevel != localResourceUploadConfig.apiLevel || !Intrinsics.areEqual(this.gpuBlackList, localResourceUploadConfig.gpuBlackList) || !Intrinsics.areEqual(this.modelBlackList, localResourceUploadConfig.modelBlackList)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int floatToIntBits = ((Float.floatToIntBits(this.memory) * 31) + this.apiLevel) * 31;
            List<String> list = this.gpuBlackList;
            int i16 = 0;
            if (list != null) {
                i3 = list.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = (floatToIntBits + i3) * 31;
            List<String> list2 = this.modelBlackList;
            if (list2 != null) {
                i16 = list2.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "LocalResourceUploadConfig(memory=" + this.memory + ", apiLevel=" + this.apiLevel + ", gpuBlackList=" + this.gpuBlackList + ", modelBlackList=" + this.modelBlackList + ")";
        }

        public LocalResourceUploadConfig(float f16, int i3, @NotNull List<String> gpuBlackList, @NotNull List<String> modelBlackList) {
            Intrinsics.checkNotNullParameter(gpuBlackList, "gpuBlackList");
            Intrinsics.checkNotNullParameter(modelBlackList, "modelBlackList");
            this.memory = f16;
            this.apiLevel = i3;
            this.gpuBlackList = gpuBlackList;
            this.modelBlackList = modelBlackList;
        }

        public /* synthetic */ LocalResourceUploadConfig(float f16, int i3, List list, List list2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 6.0f : f16, (i16 & 2) != 0 ? 28 : i3, (i16 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i16 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lyx4/c$i;", "", "", "toString", "", "hashCode", "other", "", "equals", "qualityParameter", "I", "b", "()I", "estimateCompressRatePercent", "a", "<init>", "(II)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: yx4.c$i, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class SharpPConfig {

        @SerializedName("estimateCompressRatePercent")
        private final int estimateCompressRatePercent;

        @SerializedName("qualityParameter")
        private final int qualityParameter;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SharpPConfig() {
            this(r2, r2, 3, null);
            int i3 = 0;
        }

        /* renamed from: a, reason: from getter */
        public final int getEstimateCompressRatePercent() {
            return this.estimateCompressRatePercent;
        }

        /* renamed from: b, reason: from getter */
        public final int getQualityParameter() {
            return this.qualityParameter;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof SharpPConfig) {
                    SharpPConfig sharpPConfig = (SharpPConfig) other;
                    if (this.qualityParameter != sharpPConfig.qualityParameter || this.estimateCompressRatePercent != sharpPConfig.estimateCompressRatePercent) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.qualityParameter * 31) + this.estimateCompressRatePercent;
        }

        @NotNull
        public String toString() {
            return "SharpPConfig(qualityParameter=" + this.qualityParameter + ", estimateCompressRatePercent=" + this.estimateCompressRatePercent + ")";
        }

        public SharpPConfig(int i3, int i16) {
            this.qualityParameter = i3;
            this.estimateCompressRatePercent = i16;
        }

        public /* synthetic */ SharpPConfig(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 27 : i3, (i17 & 2) != 0 ? 2 : i16);
        }
    }

    @NotNull
    CloudCommonConfig a();

    void appearanceKeyChangeFromEngine(@NotNull String jsonParams);

    int b();

    int c();

    @NotNull
    ForceDeleteResourceConfig d();

    boolean e();

    @Nullable
    String f(@NotNull String userId);

    int g();

    @NotNull
    Config getConfig();

    @NotNull
    String getZPlanVersion();

    @NotNull
    GeneralRecordSwitches h(@NotNull com.tencent.zplan.record.a scene);

    long i();

    boolean j();

    boolean k();

    int l();

    long m();

    void n(boolean success, @NotNull MemeResult data);

    void notifyEnterAvatarScene(@Nullable String avatarSceneParams);

    boolean o(@NotNull LocalResourceUploadConfig config);

    long p();

    long q();

    @NotNull
    String r();

    boolean s();

    long t();

    boolean u();

    @Nullable
    EngineType v(boolean enableFilament);
}
