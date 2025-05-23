package vx4;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.encode.EncodeConfig;
import com.tencent.zplan.encode.EncodeResult;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_COVER_ENCODE_FAIL;
import com.tencent.zplan.meme.action.ERROR_MP4_ENCODE_FAIL;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.encoder.a;
import com.tencent.zplan.meme.f;
import com.tencent.zplan.meme.model.BusinessConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.b;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wx4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 @2\u00020\u0001:\u0001\u0019BA\u0012\b\u00101\u001a\u0004\u0018\u00010/\u0012\u0006\u00104\u001a\u000202\u0012\u0006\u00106\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u00109\u001a\u00020\u0002\u0012\u0006\u0010;\u001a\u00020\u0015\u0012\u0006\u0010=\u001a\u00020\u0015\u00a2\u0006\u0004\b>\u0010?J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016R\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010*R&\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010-R\u0016\u00101\u001a\u0004\u0018\u00010/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00103R\u0014\u00106\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00105R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010%R\u0014\u00109\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010%R\u0014\u0010;\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00105R\u0014\u0010=\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00105\u00a8\u0006A"}, d2 = {"Lvx4/a;", "Lcom/tencent/zplan/meme/encoder/a;", "", "width", "height", "", "g", "portraitId", "", "pixels", "f", h.F, "", "costTime", "Lcom/tencent/zplan/encode/EncodeResult;", "encodeResult", "", "j", "i", "init", "b", "", "outputFilePath", "frameTime", "Lcom/tencent/zplan/meme/action/ActionStatus;", "a", "", "getFrames", "getFrameCount", "Lcom/tencent/zplan/a;", "Lcom/tencent/zplan/a;", "encoderManager", "Lcom/tencent/zplan/encode/a;", "c", "Lcom/tencent/zplan/encode/a;", "encodeConfig", "d", "I", "frameCount", "e", "J", "startTime", "Lcom/tencent/zplan/meme/action/ActionStatus;", "encodeStatus", "Lkotlin/Pair;", "Lkotlin/Pair;", "errorInfo", "Lwx4/c;", "Lwx4/c;", "statistic", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, "Ljava/lang/String;", "filePath", "k", "l", "totalFrame", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tempFilePath", DomainData.DOMAIN_NAME, "coverFilePath", "<init>", "(Lwx4/c;Lcom/tencent/zplan/meme/model/BusinessConfig;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "p", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a implements com.tencent.zplan.meme.encoder.a {

    /* renamed from: o, reason: collision with root package name */
    private static volatile boolean f443649o;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.zplan.a encoderManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private EncodeConfig encodeConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int frameCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ActionStatus encodeStatus;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Pair<Integer, String> errorInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final c statistic;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final BusinessConfig config;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final String filePath;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int frameTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int totalFrame;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String tempFilePath;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final String coverFilePath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lvx4/a$a;", "", "", "b", "c", "", "ENCODE_CACHE_FRAME_COUNT", "I", "IMAGE_BYTES_PER_PIXEL", "", "SO_MP4V2_NAME", "Ljava/lang/String;", "SO_SYNTHESIZER_NAME", "SO_X264_NAME", "TAG", "soLoaded", "Z", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: vx4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return a.f443649o;
        }

        public final boolean c() {
            if (!a.f443649o) {
                a.f443649o = com.tencent.zplan.common.soloader.c.INSTANCE.c(new String[]{SoLoadConstants.SONAME_X264, SoLoadConstants.SONAME_MP4V2, SoLoadConstants.SONAME_MP4_SYNTHESIZER});
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeMp4Encoder]", 1, "load mp4 soft encode so, success:" + a.f443649o, null, 8, null);
                }
                return a.f443649o;
            }
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(@Nullable c cVar, @NotNull BusinessConfig config, @NotNull String filePath, int i3, int i16, @NotNull String tempFilePath, @NotNull String coverFilePath) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        Intrinsics.checkNotNullParameter(coverFilePath, "coverFilePath");
        this.statistic = cVar;
        this.config = config;
        this.filePath = filePath;
        this.frameTime = i3;
        this.totalFrame = i16;
        this.tempFilePath = tempFilePath;
        this.coverFilePath = coverFilePath;
        this.encoderManager = new com.tencent.zplan.a();
        this.encodeStatus = ERROR_MP4_ENCODE_FAIL.INSTANCE;
    }

    private final boolean f(int portraitId, byte[] pixels, int width, int height) {
        ActionStatus actionStatus = ERROR_COVER_ENCODE_FAIL.INSTANCE;
        boolean z16 = true;
        if (this.config.getMp4Config().getCover().getSaveCover() && this.frameCount == this.config.getMp4Config().getCover().getCoverIndex()) {
            Bitmap bitmap = null;
            try {
                try {
                    bitmap = a.Companion.b(com.tencent.zplan.meme.encoder.a.INSTANCE, pixels, width, height, null, 4, null);
                    f.e(bitmap, 100, this.coverFilePath);
                    actionStatus = RECORD_COMPLETE.INSTANCE;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                } catch (OutOfMemoryError e16) {
                    d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        a16.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeMp4Encoder]", 1, "checkAndComposeCover OOM", e16);
                    }
                    System.gc();
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    z16 = false;
                }
                c cVar = this.statistic;
                if (cVar != null) {
                    cVar.c(portraitId, actionStatus, this.coverFilePath);
                }
            } catch (Throwable th5) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th5;
            }
        }
        return z16;
    }

    private final boolean g(int width, int height) {
        int min = Math.min(width * height * 4 * 2, 16588800);
        try {
            if (this.encodeConfig == null) {
                this.startTime = System.nanoTime();
                EncodeConfig encodeConfig = new EncodeConfig(width, height, this.filePath, i(), this.config.getMp4Config().getMode(), Integer.valueOf(min));
                encodeConfig.k(this.tempFilePath);
                encodeConfig.l(h());
                encodeConfig.j(this.config.getMp4Config().getDebugger());
                encodeConfig.getEncodeConfig().d(this.config.getMp4Config().getBitRate());
                encodeConfig.getEncodeConfig().e(this.config.getMp4Config().getBitRateMode());
                Unit unit = Unit.INSTANCE;
                this.encoderManager.i(encodeConfig);
                this.encodeConfig = encodeConfig;
            }
            return true;
        } catch (Throwable th5) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                a16.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeMp4Encoder]", 1, "checkAndInit throw ", th5);
                return false;
            }
            return false;
        }
    }

    private final int h() {
        if (!INSTANCE.b() && this.config.getMp4Config().getEncodeType() == 0) {
            this.errorInfo = TuplesKt.to(-1, "isSoReady false");
            return 1;
        }
        return this.config.getMp4Config().getEncodeType();
    }

    private final int i() {
        return (int) (1000.0f / this.frameTime);
    }

    private final void j(int portraitId, long costTime, EncodeResult encodeResult) {
        Integer num;
        long j3;
        Map mutableMapOf;
        String second;
        Pair[] pairArr = new Pair[15];
        int i3 = 0;
        pairArr[0] = TuplesKt.to("cost_time", String.valueOf(costTime));
        pairArr[1] = TuplesKt.to("portrait_id", String.valueOf(portraitId));
        pairArr[2] = TuplesKt.to("encode_status", String.valueOf(encodeResult.name()));
        String e16 = this.encoderManager.e();
        String str = "";
        if (e16 == null) {
            e16 = "";
        }
        pairArr[3] = TuplesKt.to("real_encode_type", e16);
        EncodeConfig encodeConfig = this.encodeConfig;
        if (encodeConfig != null) {
            i3 = encodeConfig.getType();
        }
        pairArr[4] = TuplesKt.to("init_encode_type", String.valueOf(i3));
        pairArr[5] = TuplesKt.to("config_encode_type", String.valueOf(this.config.getMp4Config().getEncodeType()));
        pairArr[6] = TuplesKt.to("background_color", String.valueOf(this.config.getBackgroundColor()));
        pairArr[7] = TuplesKt.to("frame_type", String.valueOf(this.config.getFrameType().name()));
        pairArr[8] = TuplesKt.to("aa_type", String.valueOf(this.config.getAaType()));
        pairArr[9] = TuplesKt.to("aa_level", String.valueOf(this.config.getAaLevel()));
        Pair<Integer, String> pair = this.errorInfo;
        if (pair == null || (num = pair.getFirst()) == null) {
            num = "0";
        }
        pairArr[10] = TuplesKt.to("error_code", String.valueOf(num));
        Pair<Integer, String> pair2 = this.errorInfo;
        if (pair2 != null && (second = pair2.getSecond()) != null) {
            str = second;
        }
        pairArr[11] = TuplesKt.to("error_message", str);
        pairArr[12] = TuplesKt.to("file_size", String.valueOf(com.tencent.zplan.common.utils.c.f385288a.i(this.filePath)));
        pairArr[13] = TuplesKt.to("real_soft_encode_mode", String.valueOf(this.encoderManager.getEncodeMode()));
        Long c16 = this.encoderManager.c();
        if (c16 != null) {
            j3 = c16.longValue();
        } else {
            j3 = 0;
        }
        pairArr[14] = TuplesKt.to("convert_cost_time", String.valueOf(j3 / 1000000));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        lx4.b bVar = (lx4.b) mx4.a.f417748a.a(lx4.b.class);
        if (bVar != null) {
            b.C10752b.a(bVar, null, "ev_mp4_synthesizer", mutableMapOf, 1, null);
        }
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public ActionStatus a(int portraitId, @NotNull String outputFilePath, int frameTime) {
        Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
        d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.a(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeMp4Encoder]", 1, "encode " + portraitId + ", encodeStatus: " + this.encodeStatus.toInt(), null, 8, null);
        }
        return this.encodeStatus;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public boolean b(int portraitId, @NotNull byte[] pixels, int width, int height) {
        ActionStatus actionStatus;
        d a16;
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        if (!f(portraitId, pixels, width, height)) {
            return false;
        }
        boolean g16 = g(width, height);
        if (!g16 && (a16 = LogUtil.f385285b.a()) != null) {
            d.a.d(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeMp4Encoder]", 1, "checkAndInit result false", null, 8, null);
        }
        try {
            com.tencent.zplan.a aVar = this.encoderManager;
            int i3 = this.frameCount;
            this.frameCount = i3 + 1;
            g16 = aVar.a(i3, pixels, width, height);
            int i16 = this.totalFrame;
            if (i16 > 0 && this.frameCount == i16) {
                LogUtil logUtil = LogUtil.f385285b;
                d a17 = logUtil.a();
                if (a17 != null) {
                    d.a.a(a17, "[zplan][MemePlayer-SDK][MemeEncoder][MemeMp4Encoder]", 1, "add last frame, ready to flush", null, 8, null);
                }
                EncodeResult j3 = this.encoderManager.j(this.totalFrame);
                if (j3 == EncodeResult.SUCCESS) {
                    actionStatus = RECORD_COMPLETE.INSTANCE;
                } else {
                    actionStatus = ERROR_MP4_ENCODE_FAIL.INSTANCE;
                }
                this.encodeStatus = actionStatus;
                d a18 = logUtil.a();
                if (a18 != null) {
                    d.a.a(a18, "[zplan][MemePlayer-SDK][MemeEncoder][MemeMp4Encoder]", 1, "frame end, encode result: " + this.encodeStatus.toInt(), null, 8, null);
                }
                j(portraitId, (System.nanoTime() - this.startTime) / 1000000, j3);
            }
        } catch (Throwable th5) {
            d a19 = LogUtil.f385285b.a();
            if (a19 != null) {
                a19.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeMp4Encoder]", 1, "add frame throw: ", th5);
            }
            this.errorInfo = TuplesKt.to(-2, th5.getMessage());
        }
        return g16;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public boolean c() {
        return a.C10067a.b(this);
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void close() {
        a.C10067a.a(this);
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public int getFrameCount() {
        return this.frameCount;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public List<String> getFrames() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void init() {
        a.C10067a.c(this);
        if (this.config.getMp4Config().getEncodeType() == 0) {
            INSTANCE.c();
        }
    }
}
