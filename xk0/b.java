package xk0;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.sequencer.Animation;
import com.tencent.filament.zplan.animation.sequencer.Track;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.scene.couple.config.AvatarConfig;
import com.tencent.filament.zplan.scene.couple.config.BpConfig;
import com.tencent.filament.zplan.scene.couple.config.ItemConfig;
import com.tencent.filament.zplan.scene.couple.crossfade.AnimateState;
import com.tencent.filament.zplan.scene.couple.crossfade.CrossFadeParams;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 62\u00020\u0001:\u0001!B\u001b\u0012\n\u00101\u001a\u00060/j\u0002`0\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J0\u0010\u0016\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\f\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H\u0002J(\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\f2\n\u0010\u001b\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u001c\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001a\u0010\u001e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\u001f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\fH\u0016R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00067"}, d2 = {"Lxk0/b;", "Lxk0/a;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "avatarConfig", "", "isCoupleAnim", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "nowInterval", "B", "crossFadeDuration", "w", "actionDuration", HippyTKDListViewAdapter.X, "v", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "transform", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/filament/zplan/scene/couple/config/Location;", "y", "ratio", "from", "to", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "now", "a", "k", "D", "lastAnimateNowInterval", "Lcom/tencent/filament/zplan/scene/couple/crossfade/b;", "l", "Lcom/tencent/filament/zplan/scene/couple/crossfade/b;", "crossFadeParams", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "actionAvatarConfig", "Lcom/tencent/filament/zplan/scene/couple/crossfade/AnimateState;", DomainData.DOMAIN_NAME, "Lcom/tencent/filament/zplan/scene/couple/crossfade/AnimateState;", "animationState", "", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "renderObjectId", "Lorg/json/JSONObject;", "avatarCharacter", "<init>", "(JLorg/json/JSONObject;)V", "o", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class b extends a {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private double lastAnimateNowInterval;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private CrossFadeParams crossFadeParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private AvatarConfig actionAvatarConfig;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private AnimateState animationState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(long j3, @NotNull JSONObject avatarCharacter) {
        super(j3, avatarCharacter);
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        this.animationState = AnimateState.NORMAL;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer, AvatarConfig avatarConfig, boolean isCoupleAnim) {
        FilamentAnimation filamentAnimation;
        FilamentAnimation filamentAnimation2;
        String str;
        Track track;
        Track track2;
        List<Animation> animations;
        Object firstOrNull;
        List<Animation> animations2;
        Object firstOrNull2;
        Object firstOrNull3;
        Object firstOrNull4;
        r(isCoupleAnim);
        AvatarConfig idleAvatarConfig = getIdleAvatarConfig();
        if (idleAvatarConfig != null) {
            d(spanContext, viewer);
            CrossFadeParams crossFadeParams = new CrossFadeParams(this.lastAnimateNowInterval, 0.3d, true, false, avatarConfig.getSingleAnimPosition(), 8, null);
            String faceAnim = avatarConfig.getFaceAnim();
            if (faceAnim != null) {
                firstOrNull4 = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(faceAnim, spanContext));
                filamentAnimation = (FilamentAnimation) firstOrNull4;
            } else {
                filamentAnimation = null;
            }
            if (filamentAnimation == null) {
                FLog.INSTANCE.e("CoupleAvatarScene_CrossFadeAvatarAsset", "loadAndBindAnimationTrackWithCrossFade, targetFaceAnimation == null renderObjectId:" + getRenderObjectId() + ", avatarConfig:" + avatarConfig);
                return;
            }
            String bodyAnim = avatarConfig.getBodyAnim();
            if (bodyAnim != null) {
                firstOrNull3 = ArraysKt___ArraysKt.firstOrNull(viewer.loadAnimation(bodyAnim, spanContext));
                filamentAnimation2 = (FilamentAnimation) firstOrNull3;
            } else {
                filamentAnimation2 = null;
            }
            if (filamentAnimation2 == null) {
                FLog.INSTANCE.e("CoupleAvatarScene_CrossFadeAvatarAsset", "loadAndBindAnimationTrackWithCrossFade, targetBodyAnimation == null renderObjectId:" + getRenderObjectId() + ", avatarConfig:" + avatarConfig);
                return;
            }
            Track n3 = n(spanContext, viewer, idleAvatarConfig.getFaceAnim(), avatarConfig.getLoop());
            if (n3 != null && (animations2 = n3.getAnimations()) != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) animations2);
                Animation animation = (Animation) firstOrNull2;
                if (animation != null) {
                    str = "CoupleAvatarScene_CrossFadeAvatarAsset";
                    track = com.tencent.filament.zplan.scene.couple.crossfade.a.f105953a.a(animation, filamentAnimation, crossFadeParams.getDuration(), this.lastAnimateNowInterval);
                    if (track != null) {
                        FLog.INSTANCE.e(str, "loadAndBindAnimationTrackWithCrossFade, crossFadeFaceTrack == null renderObjectId:" + getRenderObjectId() + ", idleConfig:" + idleAvatarConfig);
                        return;
                    }
                    String str2 = str;
                    Track n16 = n(spanContext, viewer, idleAvatarConfig.getBodyAnim(), avatarConfig.getLoop());
                    if (n16 != null && (animations = n16.getAnimations()) != null) {
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) animations);
                        Animation animation2 = (Animation) firstOrNull;
                        if (animation2 != null) {
                            track2 = com.tencent.filament.zplan.scene.couple.crossfade.a.f105953a.a(animation2, filamentAnimation2, crossFadeParams.getDuration(), this.lastAnimateNowInterval);
                            if (track2 != null) {
                                FLog.INSTANCE.e(str2, "loadAndBindAnimationTrackWithCrossFade, crossFadeBodyTrack == null renderObjectId:" + getRenderObjectId() + ", idleConfig:" + idleAvatarConfig);
                                return;
                            }
                            viewer.bindAnimationTrack(spanContext, getRenderObjectId(), track);
                            viewer.bindAnimationTrack(spanContext, getRenderObjectId(), track2);
                            p(track);
                            o(track2);
                            this.crossFadeParams = crossFadeParams;
                            this.animationState = AnimateState.CROSS_FADE_TO;
                            FLog.INSTANCE.i(str2, "loadAndBindAnimationTrackWithCrossFade, renderObjectId:" + getRenderObjectId() + ", avatarConfig:" + avatarConfig);
                            if (avatarConfig.getLoop()) {
                                s(AvatarConfig.b(avatarConfig, null, null, null, null, false, false, 63, null));
                                AvatarConfig idleAvatarConfig2 = getIdleAvatarConfig();
                                if (idleAvatarConfig2 != null) {
                                    idleAvatarConfig2.n(avatarConfig.getTransform());
                                }
                            } else {
                                this.actionAvatarConfig = AvatarConfig.b(avatarConfig, null, null, null, null, false, false, 63, null);
                            }
                            t(true);
                            return;
                        }
                    }
                    track2 = null;
                    if (track2 != null) {
                    }
                }
            }
            str = "CoupleAvatarScene_CrossFadeAvatarAsset";
            track = null;
            if (track != null) {
            }
        }
    }

    private final boolean B(FilamentViewerV2305 viewer, double nowInterval) {
        List<Animation> animations;
        Animation animation;
        CrossFadeParams crossFadeParams = this.crossFadeParams;
        if (crossFadeParams == null) {
            return true;
        }
        if (crossFadeParams != null) {
            double duration = crossFadeParams.getDuration();
            Track currentFaceTrack = getCurrentFaceTrack();
            if (currentFaceTrack != null && (animations = currentFaceTrack.getAnimations()) != null && (animation = animations.get(1)) != null) {
                double duration2 = animation.getDuration();
                int i3 = c.f448101a[this.animationState.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return false;
                        }
                        v(viewer, nowInterval, duration2, duration);
                    } else {
                        x(viewer, nowInterval, duration2, duration);
                    }
                } else {
                    w(viewer, nowInterval, duration);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0084, code lost:
    
        if (r7 != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void C(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer, AvatarConfig avatarConfig, com.tencent.filament.zplan.scene.couple.config.d transform) {
        List arrayList;
        Collection arrayList2;
        BpConfig detailBpConfig;
        List<ItemConfig> c16;
        int collectionSizeOrDefault;
        BpConfig bpConfig;
        List<ItemConfig> c17;
        int collectionSizeOrDefault2;
        if (avatarConfig != null && (bpConfig = avatarConfig.getBpConfig()) != null && (c17 = bpConfig.c()) != null) {
            List<ItemConfig> list = c17;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            for (ItemConfig itemConfig : list) {
                d dVar = new d(viewer.createGltfRenderObject(spanContext));
                dVar.e(spanContext, viewer, itemConfig);
                arrayList3.add(dVar);
            }
            arrayList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        }
        arrayList = new ArrayList();
        if (avatarConfig != null && (detailBpConfig = avatarConfig.getDetailBpConfig()) != null && (c16 = detailBpConfig.c()) != null) {
            List<ItemConfig> list2 = c16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            for (ItemConfig itemConfig2 : list2) {
                d dVar2 = new d(viewer.createGltfRenderObject(spanContext));
                dVar2.e(spanContext, viewer, itemConfig2);
                arrayList4.add(dVar2);
            }
            arrayList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        }
        arrayList2 = new ArrayList();
        arrayList.addAll(arrayList2);
        if (arrayList.isEmpty()) {
            return;
        }
        g().clear();
        g().addAll(arrayList);
    }

    static /* synthetic */ void D(b bVar, com.tencent.zplan.zplantracing.c cVar, FilamentViewerV2305 filamentViewerV2305, AvatarConfig avatarConfig, com.tencent.filament.zplan.scene.couple.config.d dVar, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            dVar = null;
        }
        bVar.C(cVar, filamentViewerV2305, avatarConfig, dVar);
    }

    private final void u(com.tencent.zplan.zplantracing.c spanContext, FilamentViewerV2305 viewer) {
        for (d dVar : g()) {
            dVar.b(spanContext, viewer);
            viewer.deleteRenderObject(spanContext, dVar.getRenderObjectId());
        }
        g().clear();
    }

    private final void v(FilamentViewerV2305 viewer, double nowInterval, double actionDuration, double crossFadeDuration) {
        double[] finalLocation;
        com.tencent.filament.zplan.scene.couple.config.d z16;
        if (nowInterval < (2 * crossFadeDuration) + actionDuration) {
            double d16 = ((nowInterval - crossFadeDuration) - actionDuration) / crossFadeDuration;
            CrossFadeParams crossFadeParams = this.crossFadeParams;
            if (crossFadeParams != null && (finalLocation = crossFadeParams.getFinalLocation()) != null && (z16 = z(d16, finalLocation, y())) != null) {
                viewer.setRenderObjectTransform(getRenderObjectId(), z16.toString());
                return;
            }
            return;
        }
        this.crossFadeParams = null;
        this.animationState = AnimateState.NORMAL;
        D(this, null, viewer, getIdleAvatarConfig(), null, 8, null);
    }

    private final void w(FilamentViewerV2305 viewer, double nowInterval, double crossFadeDuration) {
        double[] finalLocation;
        com.tencent.filament.zplan.scene.couple.config.d z16;
        double[] finalLocation2;
        if (nowInterval < crossFadeDuration) {
            CrossFadeParams crossFadeParams = this.crossFadeParams;
            if (crossFadeParams != null && (finalLocation2 = crossFadeParams.getFinalLocation()) != null) {
                viewer.setRenderObjectTransform(getRenderObjectId(), z(nowInterval / crossFadeDuration, y(), finalLocation2).toString());
            }
            CrossFadeParams crossFadeParams2 = this.crossFadeParams;
            if (crossFadeParams2 != null && crossFadeParams2.getNeedRemoveFromItems()) {
                u(null, viewer);
                CrossFadeParams crossFadeParams3 = this.crossFadeParams;
                if (crossFadeParams3 != null) {
                    crossFadeParams3.e(false);
                    return;
                }
                return;
            }
            return;
        }
        this.animationState = AnimateState.CROSS_FADE_TARGET_ACTION;
        CrossFadeParams crossFadeParams4 = this.crossFadeParams;
        if (crossFadeParams4 != null && (finalLocation = crossFadeParams4.getFinalLocation()) != null && (z16 = z(1.0d, y(), finalLocation)) != null) {
            viewer.setRenderObjectTransform(getRenderObjectId(), z16.toString());
            C(null, viewer, this.actionAvatarConfig, z16);
        }
        CrossFadeParams crossFadeParams5 = this.crossFadeParams;
        if (crossFadeParams5 != null) {
            crossFadeParams5.f(true);
        }
    }

    private final void x(FilamentViewerV2305 viewer, double nowInterval, double actionDuration, double crossFadeDuration) {
        if (nowInterval < crossFadeDuration + actionDuration) {
            return;
        }
        CrossFadeParams crossFadeParams = this.crossFadeParams;
        if (crossFadeParams != null && crossFadeParams.getNeedRemoveToItems()) {
            u(null, viewer);
            CrossFadeParams crossFadeParams2 = this.crossFadeParams;
            if (crossFadeParams2 != null) {
                crossFadeParams2.f(false);
            }
        }
        this.animationState = AnimateState.CROSS_FADE_REVERSE;
    }

    private final double[] y() {
        com.tencent.filament.zplan.scene.couple.config.d transform;
        double[] location;
        AvatarConfig idleAvatarConfig = getIdleAvatarConfig();
        if (idleAvatarConfig == null || (transform = idleAvatarConfig.getTransform()) == null || (location = transform.getLocation()) == null) {
            return new double[]{0.0d, 0.0d, 0.0d};
        }
        return location;
    }

    private final com.tencent.filament.zplan.scene.couple.config.d z(double ratio, double[] from, double[] to5) {
        double d16 = from[0];
        double d17 = from[1];
        double d18 = from[2];
        return new com.tencent.filament.zplan.scene.couple.config.d(new double[]{d16 + ((to5[0] - d16) * ratio), d17 + ((to5[1] - d17) * ratio), d18 + ((to5[2] - d18) * ratio)}, null, null, 6, null);
    }

    @Override // xk0.a
    public void a(@NotNull FilamentViewerV2305 viewer, double now) {
        double d16;
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        this.lastAnimateNowInterval = now;
        if (getNeedResetBeginTime()) {
            t(false);
            q(now);
        }
        Track currentFaceTrack = getCurrentFaceTrack();
        if (currentFaceTrack == null || !currentFaceTrack.getLoop()) {
            now -= getCurrentTrackBeginTime();
        }
        if (!B(viewer, now)) {
            FLog.INSTANCE.e("CoupleAvatarScene_CrossFadeAvatarAsset", "prepareCrossFadeBeforeApplyAnimation failed.");
            return;
        }
        a.c(this, viewer, now, false, 4, null);
        viewer.applyAnimation(getRenderObjectId(), now);
        CrossFadeParams crossFadeParams = this.crossFadeParams;
        if (crossFadeParams != null) {
            d16 = crossFadeParams.getDuration();
        } else {
            d16 = 0;
        }
        if (now >= d16) {
            Iterator<T> it = g().iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(viewer, now - d16);
            }
        }
    }

    @Override // xk0.a
    public void m(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull FilamentViewerV2305 viewer, @NotNull AvatarConfig avatarConfig, boolean isCoupleAnim) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(avatarConfig, "avatarConfig");
        if (!avatarConfig.getCrossFade()) {
            this.crossFadeParams = null;
            super.m(spanContext, viewer, avatarConfig, isCoupleAnim);
            this.animationState = AnimateState.NORMAL;
            return;
        }
        A(spanContext, viewer, avatarConfig, isCoupleAnim);
    }
}
