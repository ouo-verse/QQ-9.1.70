package xd4;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.Camera;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.FilterGroup;
import com.tencent.tavcut.composition.model.component.Image;
import com.tencent.tavcut.composition.model.component.LUTFilter;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.PostEffect;
import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.SubAssetComponent;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.Transition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&J8\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J@\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H&J\"\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J*\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H&J2\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010\"\u001a\u00020!H&J\u0010\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020\u001aH&J\u0018\u0010*\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u0004H&J \u0010.\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H&J(\u00102\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001cH&JX\u0010<\u001a\u00020;2\b\b\u0002\u00103\u001a\u00020\u001c2\b\b\u0002\u00104\u001a\u00020\u001c2\b\b\u0002\u00105\u001a\u00020\u001c2\b\b\u0002\u00106\u001a\u00020\u001c2\b\b\u0002\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\u001c2\b\b\u0002\u00109\u001a\u00020\u001c2\b\b\u0002\u0010:\u001a\u00020\u001cH&J\u0018\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0010\u0010B\u001a\u00020A2\u0006\u0010@\u001a\u00020\u001cH&J$\u0010D\u001a\u00020C2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020!H&J\u0010\u0010G\u001a\u00020F2\u0006\u0010E\u001a\u00020\u001aH&J\b\u0010I\u001a\u00020HH&\u00a8\u0006J"}, d2 = {"Lxd4/e;", "", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "scale", "o", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "anchorPointX", "anchorPointY", "width", "height", CanvasView.ACTION_ROTATE, "r", "j", "Lcom/tencent/tavcut/composition/model/component/Rect;", "anchor", "i", tl.h.F, "", "startOffsetUs", "durationUs", "Lcom/tencent/tavcut/composition/model/component/TimeOffset;", "e", "", "resourceId", "", "usage", "", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "replacement", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$PagScaleMode;", HippyQQPagViewController.PropertyName.SCALE_MODE, "Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "p", "name", "Lcom/tencent/tavcut/composition/model/component/EntityIdentifier;", "a", "strength", "Lcom/tencent/tavcut/composition/model/component/LUTFilter;", "f", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "speed", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "c", "firstLayerIndex", "lastLayerIndex", "Lcom/tencent/tavcut/composition/model/component/Transition;", "b", "sharpness", "brightness", "contrast", "hue", "highlights", "shadows", "saturation", "temperature", "Lcom/tencent/tavcut/composition/model/component/PostEffect;", "l", "index", "Lcom/tencent/tavcut/composition/model/component/SubAssetComponent;", DomainData.DOMAIN_NAME, "priority", "Lcom/tencent/tavcut/composition/model/component/Priority;", "k", "Lcom/tencent/tavcut/composition/model/component/Image;", "g", "renderTargetKey", "Lcom/tencent/tavcut/composition/model/component/Camera;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/tavcut/composition/model/component/FilterGroup;", "d", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface e {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ Image a(e eVar, String str, long j3, PAGAsset.PagScaleMode pagScaleMode, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                if ((i3 & 4) != 0) {
                    pagScaleMode = PAGAsset.PagScaleMode.LETTERBOX;
                }
                return eVar.g(str, j3, pagScaleMode);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createImage");
        }

        @NotNull
        public static ScreenTransform b(e eVar) {
            return eVar.o(1.0f);
        }

        @NotNull
        public static ScreenTransform c(e eVar, float f16) {
            return eVar.q(f16, f16);
        }

        @NotNull
        public static ScreenTransform d(e eVar, float f16, float f17, float f18, float f19, float f26, float f27) {
            return eVar.j(f16, f17, f18, f19, f26, f26, f27);
        }

        @NotNull
        public static ScreenTransform e(e eVar, float f16, float f17, @NotNull Rect anchor) {
            Intrinsics.checkParameterIsNotNull(anchor, "anchor");
            return eVar.h(f16, f16, f17, anchor);
        }
    }

    @NotNull
    EntityIdentifier a(@NotNull String name);

    @NotNull
    Transition b(@NotNull String resourceId, long durationUs, int firstLayerIndex, int lastLayerIndex);

    @NotNull
    AudioSource c(@NotNull String resourceId, float volume, float speed);

    @NotNull
    FilterGroup d();

    @NotNull
    TimeOffset e(long startOffsetUs, long durationUs);

    @NotNull
    LUTFilter f(@NotNull String resourceId, float strength);

    @NotNull
    Image g(@NotNull String resourceId, long durationUs, @NotNull PAGAsset.PagScaleMode scaleMode);

    @NotNull
    ScreenTransform h(float scaleX, float scaleY, float rotate, @NotNull Rect anchor);

    @NotNull
    ScreenTransform i(float scale, float rotate, @NotNull Rect anchor);

    @NotNull
    ScreenTransform j(float anchorPointX, float anchorPointY, float width, float height, float scaleX, float scaleY, float rotate);

    @NotNull
    Priority k(int priority);

    @NotNull
    PostEffect l(int sharpness, int brightness, int contrast, int hue, int highlights, int shadows, int saturation, int temperature);

    @NotNull
    ScreenTransform m();

    @NotNull
    SubAssetComponent n(int index, @NotNull String resourceId);

    @NotNull
    ScreenTransform o(float scale);

    @NotNull
    PAGAsset p(@NotNull String resourceId, int usage, @NotNull List<PAGAsset.Replacement> replacement, @NotNull PAGAsset.PagScaleMode scaleMode);

    @NotNull
    ScreenTransform q(float scaleX, float scaleY);

    @NotNull
    ScreenTransform r(float anchorPointX, float anchorPointY, float width, float height, float scale, float rotate);

    @NotNull
    Camera s(@NotNull String renderTargetKey);
}
