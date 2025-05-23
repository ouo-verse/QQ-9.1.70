package ts1;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.core.f;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.core.notify.al;
import com.tencent.mobileqq.guild.media.core.notify.e;
import com.tencent.mobileqq.guild.media.core.notify.p;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001'\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b+\u0010,J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R2\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\"j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0010`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lts1/a;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", "guildId", "channelId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVChannelConfig;", DownloadInfo.spKey_Config, "from", "", "W", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessNode;", "bizNode", BdhLogUtil.LogTag.Tag_Req, "", "nodeType", "", "dataVersion", "", "T", "U", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "E0", "p", "u", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "getCore", "()Lcom/tencent/mobileqq/guild/media/core/f;", "core", "f", "J", "channelDataVersion", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", h.F, "Ljava/util/HashMap;", "bizNodeDataVersionMap", "ts1/a$b", "i", "Lts1/a$b;", "gProObserver", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends com.tencent.mobileqq.guild.media.core.logic.h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f core;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long channelDataVersion;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Integer, Long> bizNodeDataVersionMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b gProObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J \u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J \u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014\u00a8\u0006\u0010"}, d2 = {"ts1/a$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProHeartbeatRsq;", "heartBeatRsp", "", "onPushAVHeartbeatRsp", "guildId", "channelId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVChannelConfig;", "avChannelConfig", "onPushAVChannelConfigUpdate", "onAVChannelThemeUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAVChannelThemeUpdate(@NotNull String guildId, @NotNull String channelId, @NotNull IGProAVChannelConfig avChannelConfig) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(avChannelConfig, "avChannelConfig");
            a.this.W(guildId, channelId, avChannelConfig, "onAVChannelThemeUpdate");
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushAVChannelConfigUpdate(@NotNull String guildId, @NotNull String channelId, @NotNull IGProAVChannelConfig avChannelConfig) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(avChannelConfig, "avChannelConfig");
            a.this.W(guildId, channelId, avChannelConfig, "onPushAVChannelConfigUpdate");
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushAVHeartbeatRsp(int result, @Nullable String errMsg, @Nullable IGProHeartbeatRsq heartBeatRsp) {
            if (heartBeatRsp != null) {
                a aVar = a.this;
                String valueOf = String.valueOf(heartBeatRsp.getGuildId());
                String valueOf2 = String.valueOf(heartBeatRsp.getChannelId());
                IGProAVChannelConfig avChannelConfig = heartBeatRsp.getAVChannelConfig();
                Intrinsics.checkNotNullExpressionValue(avChannelConfig, "avChannelConfig");
                aVar.W(valueOf, valueOf2, avChannelConfig, "onPushAVHeartbeatRsp");
            }
        }
    }

    public a(@NotNull f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.bizNodeDataVersionMap = new HashMap<>();
        this.gProObserver = new b();
    }

    private final boolean Q(String guildId, String channelId) {
        boolean z16;
        boolean z17;
        if (guildId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (channelId.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && Intrinsics.areEqual(guildId, this.core.getGuildID()) && Intrinsics.areEqual(channelId, this.core.E())) {
                return true;
            }
        }
        return false;
    }

    private final void R(IGProBusinessNode bizNode) {
        if (!T(bizNode.getNodeType(), bizNode.getDataVersion())) {
            Logger.f235387a.d().i("QGMC.Core.MediaChannelConfigHelper", 1, "bizNode.nodeType[" + bizNode.getNodeType() + "] needn't update, bizNode.dataVersion[" + bizNode.getDataVersion() + "]");
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelConfigHelper", 1, "bizNode.nodeType[" + bizNode.getNodeType() + "] notify update, bizNode.dataVersion[" + bizNode.getDataVersion() + "]");
        if (bizNode.getDataVersion() != -1) {
            U(bizNode.getNodeType(), bizNode.getDataVersion());
        }
        this.core.getEventBus().i(new e(bizNode));
    }

    private final void S(IGProAVChannelConfig config) {
        boolean z16 = true;
        Logger.f235387a.d().i("QGMC.Core.MediaChannelConfigHelper", 1, "handleThemeInfoUpdate:" + config.getThemeInfo().getThemeType());
        if (config.getThemeInfo().getThemeType() == 0) {
            return;
        }
        Integer value = this.core.o0().M().getValue();
        int themeType = config.getThemeInfo().getThemeType();
        if (value != null && value.intValue() == themeType) {
            IGProGuildThemeInfo value2 = this.core.o0().J().getValue();
            if (value2 == null || value2.getThemeType() != config.getThemeInfo().getThemeType()) {
                z16 = false;
            }
            if (z16) {
                return;
            }
        }
        this.core.o0().M().setValue(Integer.valueOf(config.getThemeInfo().getThemeType()));
        this.core.o0().J().setValue(config.getThemeInfo());
        this.core.o0().L().setValue(Long.valueOf(config.getOriginatorTinyId()));
        this.core.o0().I().setValue(config.getBusinessList());
        p eventBus = this.core.getEventBus();
        Intrinsics.checkNotNull(value);
        eventBus.i(new SwitchThemeEvent(value.intValue(), config.getThemeInfo().getThemeType()));
        this.core.getEventBus().i(new al());
    }

    private final boolean T(int nodeType, long dataVersion) {
        Long l3 = this.bizNodeDataVersionMap.get(Integer.valueOf(nodeType));
        if (l3 == null) {
            l3 = 0L;
        }
        long longValue = l3.longValue();
        if (dataVersion != -1 && dataVersion <= longValue) {
            return false;
        }
        return true;
    }

    private final void U(int nodeType, long dataVersion) {
        this.bizNodeDataVersionMap.put(Integer.valueOf(nodeType), Long.valueOf(dataVersion));
        Logger.f235387a.d().i("QGMC.Core.MediaChannelConfigHelper", 1, "updateBizNodeVersion bizNode.nodeType[" + nodeType + "], bizNode.dataVersion[" + dataVersion + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(String guildId, String channelId, IGProAVChannelConfig config, String from) {
        if (!Q(guildId, channelId)) {
            return;
        }
        if (config.getChannelDataVersion() <= this.channelDataVersion) {
            Logger.f235387a.d().i("QGMC.Core.MediaChannelConfigHelper", 1, "updateConfigByVersion ignore, from:" + from + ", newVersion:" + config.getChannelDataVersion() + ", lastVersion:" + this.channelDataVersion);
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelConfigHelper", 1, "updateConfigByVersion, from:" + from + ",  newVersion:" + config.getChannelDataVersion() + ", lastVersion:" + this.channelDataVersion + ", bizNodeSize:" + config.getBusinessList().size());
        this.channelDataVersion = config.getChannelDataVersion();
        Iterator<IGProBusinessNode> it = config.getBusinessList().iterator();
        while (it.hasNext()) {
            IGProBusinessNode bizNode = it.next();
            Intrinsics.checkNotNullExpressionValue(bizNode, "bizNode");
            R(bizNode);
        }
        S(config);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).addObserver(this.gProObserver);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void p() {
        super.p();
        E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).deleteObserver(this.gProObserver);
        this.channelDataVersion = 0L;
        this.bizNodeDataVersionMap.clear();
    }
}
