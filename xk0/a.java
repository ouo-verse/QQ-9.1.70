package xk0;

import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.sequencer.NormalAnimation;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.filament.zplan.scene.couple.config.BpConfig;
import com.tencent.filament.zplan.scene.couple.config.ItemConfig;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0010\u0018\u0000 82\u00020\u0001:\u0001\u0014B\u001b\u0012\n\u0010E\u001a\u00060@j\u0002`A\u0012\u0006\u0010K\u001a\u00020F\u00a2\u0006\u0004\bL\u0010MJ*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J,\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\bJ\u001a\u0010\u0011\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\"\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\bH\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR \u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010/\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00106\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010<\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010?\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010*\u001a\u0004\b=\u0010,\"\u0004\b>\u0010.R\u001b\u0010E\u001a\u00060@j\u0002`A8\u0006\u00a2\u0006\f\n\u0004\b2\u0010B\u001a\u0004\bC\u0010DR\"\u0010K\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010G\u001a\u0004\b0\u0010H\"\u0004\bI\u0010J\u00a8\u0006N"}, d2 = {"Lxk0/a;", "", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "avatarConfig", "", "isCoupleAnim", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "gltfPath", "loop", "Lcom/tencent/filament/zplan/animation/sequencer/Track;", DomainData.DOMAIN_NAME, "d", "", "now", "a", "nowInterval", "forceChange", "b", "i", "()Ljava/lang/Double;", "Lcom/tencent/filament/zplan/animation/sequencer/Track;", "f", "()Lcom/tencent/filament/zplan/animation/sequencer/Track;", "p", "(Lcom/tencent/filament/zplan/animation/sequencer/Track;)V", "currentFaceTrack", "getCurrentBodyTrack", "o", "currentBodyTrack", "", "Lxk0/d;", "c", "Ljava/util/List;", "g", "()Ljava/util/List;", "currentItemAssets", "Z", "k", "()Z", "t", "(Z)V", "needResetBeginTime", "e", "D", h.F, "()D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(D)V", "currentTrackBeginTime", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "j", "()Lcom/tencent/filament/zplan/scene/couple/config/a;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/filament/zplan/scene/couple/config/a;)V", "idleAvatarConfig", "getCurrentTrackIsCoupleAnim", "r", "currentTrackIsCoupleAnim", "", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "J", "l", "()J", "renderObjectId", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "setAvatarCharacter", "(Lorg/json/JSONObject;)V", "avatarCharacter", "<init>", "(JLorg/json/JSONObject;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Track currentFaceTrack;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Track currentBodyTrack;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> currentItemAssets;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needResetBeginTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private double currentTrackBeginTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarConfig idleAvatarConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean currentTrackIsCoupleAnim;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long renderObjectId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private JSONObject avatarCharacter;

    public a(long j3, @NotNull JSONObject avatarCharacter) {
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        this.renderObjectId = j3;
        this.avatarCharacter = avatarCharacter;
        this.currentItemAssets = new ArrayList();
    }

    public static /* synthetic */ void c(a aVar, FilamentViewerV2305 filamentViewerV2305, double d16, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            aVar.b(filamentViewerV2305, d16, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeToIdleTrackIfNeed");
    }

    public void a(@NotNull FilamentViewerV2305 viewer, double now) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        if (this.needResetBeginTime) {
            this.needResetBeginTime = false;
            this.currentTrackBeginTime = now;
        }
        Track track = this.currentFaceTrack;
        if (track == null || !track.getLoop()) {
            now -= this.currentTrackBeginTime;
        }
        c(this, viewer, now, false, 4, null);
        viewer.applyAnimation(this.renderObjectId, now);
        Iterator<T> it = this.currentItemAssets.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(viewer, now);
        }
    }

    public void b(@NotNull FilamentViewerV2305 viewer, double nowInterval, boolean forceChange) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Track track = this.currentFaceTrack;
        if (track == null || track.getLoop()) {
            return;
        }
        if (nowInterval > track.getDuration() || (forceChange && this.currentTrackIsCoupleAnim)) {
            d(null, viewer);
            viewer.garbageCollect();
            AvatarConfig avatarConfig = this.idleAvatarConfig;
            if (avatarConfig != null) {
                com.tencent.filament.zplan.scene.couple.config.d transform = avatarConfig.getTransform();
                if (transform != null) {
                    viewer.setRenderObjectTransform(this.renderObjectId, transform.toString());
                }
                m(null, viewer, avatarConfig, false);
            }
        }
    }

    public void d(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull FilamentViewerV2305 viewer) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        viewer.cleanAnimationTracks(spanContext, this.renderObjectId);
        for (d dVar : this.currentItemAssets) {
            dVar.b(spanContext, viewer);
            viewer.deleteRenderObject(spanContext, dVar.getRenderObjectId());
        }
        this.currentItemAssets.clear();
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final JSONObject getAvatarCharacter() {
        return this.avatarCharacter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: f, reason: from getter */
    public final Track getCurrentFaceTrack() {
        return this.currentFaceTrack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<d> g() {
        return this.currentItemAssets;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h, reason: from getter */
    public final double getCurrentTrackBeginTime() {
        return this.currentTrackBeginTime;
    }

    @Nullable
    public final Double i() {
        Track track = this.currentFaceTrack;
        if (track != null) {
            return Double.valueOf(track.getDuration());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: j, reason: from getter */
    public final AvatarConfig getIdleAvatarConfig() {
        return this.idleAvatarConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k, reason: from getter */
    public final boolean getNeedResetBeginTime() {
        return this.needResetBeginTime;
    }

    /* renamed from: l, reason: from getter */
    public final long getRenderObjectId() {
        return this.renderObjectId;
    }

    public void m(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull FilamentViewerV2305 viewer, @NotNull AvatarConfig avatarConfig, boolean isCoupleAnim) {
        Collection<? extends d> emptySet;
        Collection<? extends d> emptySet2;
        List<ItemConfig> c16;
        int collectionSizeOrDefault;
        List<ItemConfig> c17;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(avatarConfig, "avatarConfig");
        this.currentTrackIsCoupleAnim = isCoupleAnim;
        d(spanContext, viewer);
        FLog fLog = FLog.INSTANCE;
        fLog.i("CoupleAvatarScene_AvatarAsset", "loadAndBindAnimationTrack, renderObjectId:" + this.renderObjectId + ", avatarConfig:" + avatarConfig);
        Track n3 = n(spanContext, viewer, avatarConfig.getFaceAnim(), avatarConfig.getLoop());
        Track track = null;
        if (n3 != null) {
            viewer.bindAnimationTrack(spanContext, this.renderObjectId, n3);
            Unit unit = Unit.INSTANCE;
        } else {
            n3 = null;
        }
        this.currentFaceTrack = n3;
        if (n3 == null) {
            fLog.e("CoupleAvatarScene_AvatarAsset", "loadAndBindAnimationTrack, currentFaceTrack == null renderObjectId:" + this.renderObjectId + ", avatarConfig:" + avatarConfig);
        }
        Track n16 = n(spanContext, viewer, avatarConfig.getBodyAnim(), avatarConfig.getLoop());
        if (n16 != null) {
            viewer.bindAnimationTrack(spanContext, this.renderObjectId, n16);
            Unit unit2 = Unit.INSTANCE;
            track = n16;
        }
        this.currentBodyTrack = track;
        if (track == null) {
            fLog.e("CoupleAvatarScene_AvatarAsset", "loadAndBindAnimationTrack, currentBodyTrack == null renderObjectId:" + this.renderObjectId + ", avatarConfig:" + avatarConfig);
        }
        List<d> list = this.currentItemAssets;
        BpConfig bpConfig = avatarConfig.getBpConfig();
        if (bpConfig == null || (c17 = bpConfig.c()) == null) {
            emptySet = SetsKt__SetsKt.emptySet();
        } else {
            List<ItemConfig> list2 = c17;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            emptySet = new ArrayList<>(collectionSizeOrDefault2);
            for (ItemConfig itemConfig : list2) {
                d dVar = new d(viewer.createGltfRenderObject(spanContext));
                dVar.e(spanContext, viewer, itemConfig);
                emptySet.add(dVar);
            }
        }
        list.addAll(emptySet);
        List<d> list3 = this.currentItemAssets;
        BpConfig detailBpConfig = avatarConfig.getDetailBpConfig();
        if (detailBpConfig == null || (c16 = detailBpConfig.c()) == null) {
            emptySet2 = SetsKt__SetsKt.emptySet();
        } else {
            List<ItemConfig> list4 = c16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            emptySet2 = new ArrayList<>(collectionSizeOrDefault);
            for (ItemConfig itemConfig2 : list4) {
                d dVar2 = new d(viewer.createGltfRenderObject(spanContext));
                dVar2.e(spanContext, viewer, itemConfig2);
                emptySet2.add(dVar2);
            }
        }
        list3.addAll(emptySet2);
        if (avatarConfig.getLoop()) {
            AvatarConfig b16 = AvatarConfig.b(avatarConfig, null, null, null, null, false, false, 63, null);
            b16.n(avatarConfig.getTransform());
            Unit unit3 = Unit.INSTANCE;
            this.idleAvatarConfig = b16;
        }
        this.needResetBeginTime = true;
    }

    @Nullable
    public final Track n(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull FilamentViewerV2305 viewer, @Nullable String gltfPath, boolean loop) {
        boolean z16;
        Object firstOrNull;
        List mutableListOf;
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        if (gltfPath != null && gltfPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(gltfPath, spanContext));
            FilamentAnimation filamentAnimation = (FilamentAnimation) firstOrNull;
            if (filamentAnimation != null) {
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a(filamentAnimation));
                return new Track(loop, mutableListOf);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(@Nullable Track track) {
        this.currentBodyTrack = track;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(@Nullable Track track) {
        this.currentFaceTrack = track;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(double d16) {
        this.currentTrackBeginTime = d16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(boolean z16) {
        this.currentTrackIsCoupleAnim = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(@Nullable AvatarConfig avatarConfig) {
        this.idleAvatarConfig = avatarConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(boolean z16) {
        this.needResetBeginTime = z16;
    }
}
