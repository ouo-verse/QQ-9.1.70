package r63;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u0000 62\u00020\u0001:\u0002\u000b\u0010Bw\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u0006\u0010'\u001a\u00020\t\u0012\u0006\u0010)\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020\t\u0012\u0006\u0010+\u001a\u00020\u0006\u0012\u0006\u0010-\u001a\u00020\u0006\u0012\u0006\u0010.\u001a\u00020\t\u0012\u0006\u00103\u001a\u00020/\u00a2\u0006\u0004\b4\u00105J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010 \u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u0017\u0010'\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010)\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b(\u0010&R\u0017\u0010*\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b\u0015\u0010&R\u0017\u0010+\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010\u0013R\u0017\u0010-\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b\u000b\u0010\u0013R\u0017\u0010.\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b,\u0010&R\u0017\u00103\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b!\u00102\u00a8\u00067"}, d2 = {"Lr63/c;", "", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "path", "b", "I", "i", "()I", "width", "c", "d", "height", "getBitrate", "bitrate", "", "D", "getFrameRate", "()D", "frameRate", "f", "durationMs", "g", BasicAnimation.KeyPath.ROTATION, h.F, "Z", "k", "()Z", "isHEVC", "j", "isHDR", "hasBFrame", "videoTrackCount", "l", "audioTrackCount", "isHardwareEncode", "", DomainData.DOMAIN_NAME, "J", "()J", "startTimeMs", "<init>", "(Ljava/lang/String;IIIDIIZZZIIZJ)V", "o", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: r63.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MetaVideo {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bitrate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final double frameRate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int durationMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int rotation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isHEVC;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isHDR;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasBFrame;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final int videoTrackCount;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final int audioTrackCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isHardwareEncode;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final long startTimeMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u00062\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0014J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010#R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010#R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010#R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001bR\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u0016\u0010+\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010*\u00a8\u0006."}, d2 = {"Lr63/c$a;", "", "", "value", "k", "", "o", "g", "c", "", "e", "d", "l", "", "j", h.F, "f", DomainData.DOMAIN_NAME, "b", "i", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lr63/c;", "a", "toString", "Ljava/lang/String;", "path", "I", "width", "height", "bitrate", "D", "frameRate", "durationMs", BasicAnimation.KeyPath.ROTATION, "Z", "isHEVC", "isHDR", "hasBFrame", "videoTrackCount", "audioTrackCount", "isHardwareEncode", "J", "startTime", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: r63.c$a */
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private int rotation;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isHEVC;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isHDR;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean hasBFrame;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isHardwareEncode;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
        private long startTime;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String path = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int width = -1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int height = -1;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int bitrate = -1;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private double frameRate = -1.0d;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int duration = -1;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        private int videoTrackCount = -1;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
        private int audioTrackCount = -1;

        @Nullable
        public final MetaVideo a() {
            if (this.width > 0 && this.height > 0 && this.bitrate > 0 && this.frameRate > 0.0d && this.duration > 0 && this.videoTrackCount > 0 && this.audioTrackCount > 0) {
                return new MetaVideo(this.path, this.width, this.height, this.bitrate, this.frameRate, this.duration, this.rotation, this.isHEVC, this.isHDR, this.hasBFrame, this.videoTrackCount, this.audioTrackCount, this.isHardwareEncode, this.startTime);
            }
            QLog.w("MetaVideo-Builder", 1, "[build] invalid params, " + this);
            return null;
        }

        @NotNull
        public final a b(int value) {
            this.audioTrackCount = value;
            return this;
        }

        @NotNull
        public final a c(int value) {
            this.bitrate = value;
            return this;
        }

        @NotNull
        public final a d(int value) {
            this.duration = value;
            return this;
        }

        @NotNull
        public final a e(double value) {
            this.frameRate = value;
            return this;
        }

        @NotNull
        public final a f(boolean value) {
            this.hasBFrame = value;
            return this;
        }

        @NotNull
        public final a g(int value) {
            this.height = value;
            return this;
        }

        @NotNull
        public final a h(boolean value) {
            this.isHDR = value;
            return this;
        }

        @NotNull
        public final a i(boolean value) {
            this.isHardwareEncode = value;
            return this;
        }

        @NotNull
        public final a j(boolean value) {
            this.isHEVC = value;
            return this;
        }

        @NotNull
        public final a k(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.path = value;
            return this;
        }

        @NotNull
        public final a l(int value) {
            this.rotation = value;
            return this;
        }

        @NotNull
        public final a m(long value) {
            this.startTime = value;
            return this;
        }

        @NotNull
        public final a n(int value) {
            this.videoTrackCount = value;
            return this;
        }

        @NotNull
        public final a o(int value) {
            this.width = value;
            return this;
        }

        @NotNull
        public String toString() {
            return "path=" + this.path + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", startTime=" + this.startTime + ", duration=" + this.duration + ", rotation=" + this.rotation + ", isHEVC=" + this.isHEVC + ", isHDR=" + this.isHDR + ", hasBFrame=" + this.hasBFrame + ", videoTrackCount=" + this.videoTrackCount + ", audioTrackCount=" + this.audioTrackCount + ", isHardwareEncode=" + this.isHardwareEncode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lr63/c$b;", "", "Lorg/json/JSONObject;", "jsonObject", "Lr63/c;", "a", "", "AUDIOTRACK", "Ljava/lang/String;", "BFRAME", "BITRATE", "DURATION", "FRAMERATE", "HARDWARE", "HDR", "HEIGHT", "HEVC", AEEditorConstants.PATH, "ROTATION", "STARTTIME", "VIDEOTRACK", "WIDTH", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: r63.c$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final MetaVideo a(@NotNull JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String optString = jsonObject.optString("path");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(PATH)");
            return new MetaVideo(optString, jsonObject.optInt("width"), jsonObject.optInt("height"), jsonObject.optInt("bitrate"), jsonObject.optDouble("frameRate"), jsonObject.optInt("durationMs"), jsonObject.optInt(BasicAnimation.KeyPath.ROTATION), jsonObject.optBoolean("isHEVC"), jsonObject.optBoolean("isHDR"), jsonObject.optBoolean("hasBFrame"), jsonObject.optInt("videoTrackCount"), jsonObject.optInt("audioTrackCount"), jsonObject.optBoolean("isHardwareEncode"), jsonObject.optLong("startTime"));
        }

        Companion() {
        }
    }

    public MetaVideo(@NotNull String path, int i3, int i16, int i17, double d16, int i18, int i19, boolean z16, boolean z17, boolean z18, int i26, int i27, boolean z19, long j3) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.width = i3;
        this.height = i16;
        this.bitrate = i17;
        this.frameRate = d16;
        this.durationMs = i18;
        this.rotation = i19;
        this.isHEVC = z16;
        this.isHDR = z17;
        this.hasBFrame = z18;
        this.videoTrackCount = i26;
        this.audioTrackCount = i27;
        this.isHardwareEncode = z19;
        this.startTimeMs = j3;
    }

    /* renamed from: a, reason: from getter */
    public final int getAudioTrackCount() {
        return this.audioTrackCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHasBFrame() {
        return this.hasBFrame;
    }

    /* renamed from: d, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaVideo)) {
            return false;
        }
        MetaVideo metaVideo = (MetaVideo) other;
        if (Intrinsics.areEqual(this.path, metaVideo.path) && this.width == metaVideo.width && this.height == metaVideo.height && this.bitrate == metaVideo.bitrate && Double.compare(this.frameRate, metaVideo.frameRate) == 0 && this.durationMs == metaVideo.durationMs && this.rotation == metaVideo.rotation && this.isHEVC == metaVideo.isHEVC && this.isHDR == metaVideo.isHDR && this.hasBFrame == metaVideo.hasBFrame && this.videoTrackCount == metaVideo.videoTrackCount && this.audioTrackCount == metaVideo.audioTrackCount && this.isHardwareEncode == metaVideo.isHardwareEncode && this.startTimeMs == metaVideo.startTimeMs) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getRotation() {
        return this.rotation;
    }

    /* renamed from: g, reason: from getter */
    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    /* renamed from: h, reason: from getter */
    public final int getVideoTrackCount() {
        return this.videoTrackCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.path.hashCode() * 31) + this.width) * 31) + this.height) * 31) + this.bitrate) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.frameRate)) * 31) + this.durationMs) * 31) + this.rotation) * 31;
        boolean z16 = this.isHEVC;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isHDR;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.hasBFrame;
        int i26 = z18;
        if (z18 != 0) {
            i26 = 1;
        }
        int i27 = (((((i19 + i26) * 31) + this.videoTrackCount) * 31) + this.audioTrackCount) * 31;
        boolean z19 = this.isHardwareEncode;
        if (!z19) {
            i3 = z19 ? 1 : 0;
        }
        return ((i27 + i3) * 31) + androidx.fragment.app.a.a(this.startTimeMs);
    }

    /* renamed from: i, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsHDR() {
        return this.isHDR;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsHEVC() {
        return this.isHEVC;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsHardwareEncode() {
        return this.isHardwareEncode;
    }

    @NotNull
    public final JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("path", this.path);
        jSONObject.put("width", this.width);
        jSONObject.put("height", this.height);
        jSONObject.put("bitrate", this.bitrate);
        jSONObject.put("frameRate", this.frameRate);
        jSONObject.put("durationMs", this.durationMs);
        jSONObject.put(BasicAnimation.KeyPath.ROTATION, this.rotation);
        jSONObject.put("isHEVC", this.isHEVC);
        jSONObject.put("isHDR", this.isHDR);
        jSONObject.put("hasBFrame", this.hasBFrame);
        jSONObject.put("videoTrackCount", this.videoTrackCount);
        jSONObject.put("audioTrackCount", this.audioTrackCount);
        jSONObject.put("isHardwareEncode", this.isHardwareEncode);
        jSONObject.put("startTime", this.startTimeMs);
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "MetaVideo(path=" + this.path + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", durationMs=" + this.durationMs + ", rotation=" + this.rotation + ", isHEVC=" + this.isHEVC + ", isHDR=" + this.isHDR + ", hasBFrame=" + this.hasBFrame + ", videoTrackCount=" + this.videoTrackCount + ", audioTrackCount=" + this.audioTrackCount + ", isHardwareEncode=" + this.isHardwareEncode + ", startTimeMs=" + this.startTimeMs + ")";
    }
}
