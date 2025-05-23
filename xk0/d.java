package xk0;

import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.sequencer.NormalAnimation;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.couple.config.ItemConfig;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0011B\u0013\u0012\n\u0010\u001d\u001a\u00060\u0018j\u0002`\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u000e\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00060\u0018j\u0002`\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lxk0/d;", "", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "", "animationGltfPath", "Lcom/tencent/filament/zplan/animation/sequencer/Track;", "f", "Lcom/tencent/filament/zplan/scene/couple/config/ItemConfig;", "itemConfig", "", "e", "b", "", "now", "a", "Lcom/tencent/filament/zplan/animation/sequencer/Track;", "c", "()Lcom/tencent/filament/zplan/animation/sequencer/Track;", "setCurrentItemTrack", "(Lcom/tencent/filament/zplan/animation/sequencer/Track;)V", "currentItemTrack", "", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "J", "d", "()J", "renderObjectId", "<init>", "(J)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Track currentItemTrack;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long renderObjectId;

    public d(long j3) {
        this.renderObjectId = j3;
    }

    private final Track f(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer, String animationGltfPath) {
        boolean z16;
        Object firstOrNull;
        List mutableListOf;
        if (animationGltfPath != null && animationGltfPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(animationGltfPath, spanContext));
            FilamentAnimation filamentAnimation = (FilamentAnimation) firstOrNull;
            if (filamentAnimation != null) {
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(NormalAnimation.INSTANCE.a(filamentAnimation));
                return new Track(true, mutableListOf);
            }
            FLog.INSTANCE.e("CoupleAvatarScene_ItemAsset", "loadAnimation, animation == null animationGltfPath:" + animationGltfPath);
            return null;
        }
        FLog.INSTANCE.e("CoupleAvatarScene_ItemAsset", "loadAnimationTrack, animationGltfPath.isNullOrEmpty()");
        return null;
    }

    public final void a(@NotNull FilamentViewerV2305 viewer, double now) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        if (this.currentItemTrack != null) {
            viewer.applyAnimation(this.renderObjectId, now);
        }
    }

    public final void b(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull FilamentViewerV2305 viewer) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        if (this.currentItemTrack != null) {
            viewer.cleanAnimationTracks(spanContext, this.renderObjectId);
        }
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Track getCurrentItemTrack() {
        return this.currentItemTrack;
    }

    /* renamed from: d, reason: from getter */
    public final long getRenderObjectId() {
        return this.renderObjectId;
    }

    public final void e(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull FilamentViewerV2305 viewer, @NotNull ItemConfig itemConfig) {
        boolean z16;
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(itemConfig, "itemConfig");
        String mesh = itemConfig.getMesh();
        if (mesh != null && mesh.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            FLog.INSTANCE.e("CoupleAvatarScene_ItemAsset", "loadAndBindAnimationTrack, gltf.isNullOrEmpty() itemConfig:" + itemConfig);
            return;
        }
        viewer.updateRenderObjectGltf(spanContext, this.renderObjectId, mesh);
        com.tencent.filament.zplan.scene.couple.config.d transform = itemConfig.getTransform();
        if (transform != null) {
            viewer.setRenderObjectTransform(this.renderObjectId, transform.toString());
        }
        Track f16 = f(spanContext, viewer, itemConfig.getAnim());
        if (f16 != null) {
            viewer.bindAnimationTrack(spanContext, this.renderObjectId, f16);
            Unit unit = Unit.INSTANCE;
        } else {
            f16 = null;
        }
        this.currentItemTrack = f16;
    }
}
