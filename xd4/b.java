package xd4;

import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.luggage.wxa.yf.e0;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.Camera;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.FilterGroup;
import com.tencent.tavcut.composition.model.component.Image;
import com.tencent.tavcut.composition.model.component.LUTFilter;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.PostEffect;
import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.composition.model.component.Quat;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.SubAssetComponent;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.Transition;
import com.tencent.tavcut.composition.model.component.Vec2;
import com.tencent.tavcut.composition.model.component.Vec3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import org.jetbrains.annotations.NotNull;
import xd4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bF\u0010GJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J@\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J.\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u0015H\u0016J\u0018\u0010%\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0002H\u0016J \u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002H\u0016J\u0018\u0010+\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J(\u0010.\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0017H\u0016JH\u00108\u001a\u0002072\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u0017H\u0016J\u0018\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020\u0017H\u0016J \u0010@\u001a\u00020?2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010C\u001a\u00020B2\u0006\u0010A\u001a\u00020\u0015H\u0016J\b\u0010E\u001a\u00020DH\u0016\u00a8\u0006H"}, d2 = {"Lxd4/b;", "Lxd4/e;", "", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "anchorPointX", "anchorPointY", "width", "height", CanvasView.ACTION_ROTATE, "j", "Lcom/tencent/tavcut/composition/model/component/Rect;", "anchor", tl.h.F, "", "startOffsetUs", "durationUs", "Lcom/tencent/tavcut/composition/model/component/TimeOffset;", "e", "", "resourceId", "", "usage", "", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "replacement", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$PagScaleMode;", HippyQQPagViewController.PropertyName.SCALE_MODE, "Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "p", "name", "Lcom/tencent/tavcut/composition/model/component/EntityIdentifier;", "a", "intensity", "Lcom/tencent/tavcut/composition/model/component/LUTFilter;", "f", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "speed", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "c", "Lcom/tencent/tavcut/composition/model/component/Transition;", "t", "firstLayerIndex", "lastLayerIndex", "b", "sharpness", "brightness", "contrast", "hue", "highlights", "shadows", "saturation", "temperature", "Lcom/tencent/tavcut/composition/model/component/PostEffect;", "l", "index", "Lcom/tencent/tavcut/composition/model/component/SubAssetComponent;", DomainData.DOMAIN_NAME, "priority", "Lcom/tencent/tavcut/composition/model/component/Priority;", "k", "Lcom/tencent/tavcut/composition/model/component/Image;", "g", "key", "Lcom/tencent/tavcut/composition/model/component/Camera;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/tavcut/composition/model/component/FilterGroup;", "d", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final b f447836a = new b();

    b() {
    }

    @Override // xd4.e
    @NotNull
    public EntityIdentifier a(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        return new EntityIdentifier("EntityIdentifier", name, null, null, 12, null);
    }

    @Override // xd4.e
    @NotNull
    public Transition b(@NotNull String resourceId, long durationUs, int firstLayerIndex, int lastLayerIndex) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Integer valueOf = Integer.valueOf(firstLayerIndex);
        Integer valueOf2 = Integer.valueOf(lastLayerIndex);
        Long valueOf3 = Long.valueOf(durationUs);
        return new Transition(null, null, Boolean.TRUE, "Transition", valueOf, valueOf2, resourceId, valueOf3, null, null, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, null);
    }

    @Override // xd4.e
    @NotNull
    public AudioSource c(@NotNull String resourceId, float volume, float speed) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Float valueOf = Float.valueOf(volume);
        Float valueOf2 = Float.valueOf(speed);
        return new AudioSource(null, null, Boolean.TRUE, "AudioSource", null, valueOf2, null, valueOf, null, null, resourceId, null, 2899, null);
    }

    @Override // xd4.e
    @NotNull
    public FilterGroup d() {
        return new FilterGroup(null, null, Boolean.TRUE, "FilterGroup", null, null, 51, null);
    }

    @Override // xd4.e
    @NotNull
    public TimeOffset e(long startOffsetUs, long durationUs) {
        return new TimeOffset(null, null, Boolean.TRUE, "TimeOffset", Long.valueOf(startOffsetUs), Long.valueOf(durationUs), 0, null, null, tlv_t183.CMD_183, null);
    }

    @Override // xd4.e
    @NotNull
    public LUTFilter f(@NotNull String resourceId, float intensity) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Float valueOf = Float.valueOf(intensity);
        return new LUTFilter(null, null, Boolean.TRUE, "LUTFilter", resourceId, null, null, valueOf, null, 355, null);
    }

    @Override // xd4.e
    @NotNull
    public Image g(@NotNull String resourceId, long durationUs, @NotNull PAGAsset.PagScaleMode scaleMode) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Intrinsics.checkParameterIsNotNull(scaleMode, "scaleMode");
        Integer num = null;
        Long valueOf = Long.valueOf(durationUs);
        Integer valueOf2 = Integer.valueOf(scaleMode.getValue());
        return new Image(null, Boolean.TRUE, num, valueOf2, resourceId, "Image", valueOf, null, null, e0.CTRL_INDEX, null);
    }

    @Override // xd4.e
    @NotNull
    public ScreenTransform h(float scaleX, float scaleY, float rotate, @NotNull Rect anchor) {
        Intrinsics.checkParameterIsNotNull(anchor, "anchor");
        Vec3 vec3 = new Vec3(0.0f, 0.0f, 0.0f, null, 8, null);
        Quat c16 = le4.d.c(rotate);
        Vec3 vec32 = new Vec3(scaleX, scaleY, 1.0f, null, 8, null);
        Rect rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f, null, 16, null);
        Vec2 vec2 = new Vec2(0.0f, 0.0f, null, 4, null);
        Boolean bool = Boolean.TRUE;
        return new ScreenTransform(null, null, bool, "ScreenTransform", anchor, rect, vec2, null, null, null, bool, vec3, c16, vec32, null, bool, null, null, 213891, null);
    }

    @Override // xd4.e
    @NotNull
    public ScreenTransform i(float f16, float f17, @NotNull Rect anchor) {
        Intrinsics.checkParameterIsNotNull(anchor, "anchor");
        return e.a.e(this, f16, f17, anchor);
    }

    @Override // xd4.e
    @NotNull
    public ScreenTransform j(float anchorPointX, float anchorPointY, float width, float height, float scaleX, float scaleY, float rotate) {
        Vec3 vec3 = new Vec3(0.0f, 0.0f, 0.0f, null, 8, null);
        Quat c16 = le4.d.c(rotate);
        Vec3 vec32 = new Vec3(scaleX, scaleY, 1.0f, null, 8, null);
        Rect rect = new Rect(anchorPointX, anchorPointY, anchorPointX, anchorPointY, null, 16, null);
        float f16 = 2;
        Rect rect2 = new Rect((-width) / f16, height / f16, width / f16, (-height) / f16, null, 16, null);
        Vec2 vec2 = new Vec2(0.0f, 0.0f, null, 4, null);
        Boolean bool = Boolean.TRUE;
        return new ScreenTransform(null, null, bool, "ScreenTransform", rect, rect2, vec2, null, null, null, bool, vec3, c16, vec32, null, bool, null, null, 213891, null);
    }

    @Override // xd4.e
    @NotNull
    public Priority k(int priority) {
        return new Priority(null, null, null, null, Integer.valueOf(priority), null, 47, null);
    }

    @Override // xd4.e
    @NotNull
    public PostEffect l(int sharpness, int brightness, int contrast, int hue, int highlights, int shadows, int saturation, int temperature) {
        return new PostEffect(null, null, Boolean.TRUE, "PostEffect", "adjustment", Integer.valueOf(sharpness), Integer.valueOf(brightness), Integer.valueOf(contrast), Integer.valueOf(hue), Integer.valueOf(highlights), Integer.valueOf(shadows), Integer.valueOf(saturation), Integer.valueOf(temperature), null, null, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_PUNISHED, null);
    }

    @Override // xd4.e
    @NotNull
    public ScreenTransform m() {
        return e.a.b(this);
    }

    @Override // xd4.e
    @NotNull
    public SubAssetComponent n(int index, @NotNull String resourceId) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        return new SubAssetComponent(null, null, Boolean.TRUE, "SubAssetComponent", Integer.valueOf(index), null, resourceId, null, null, null, null, null, null, null, null, null, null, 130979, null);
    }

    @Override // xd4.e
    @NotNull
    public ScreenTransform o(float f16) {
        return e.a.c(this, f16);
    }

    @Override // xd4.e
    @NotNull
    public PAGAsset p(@NotNull String resourceId, int usage, @NotNull List<PAGAsset.Replacement> replacement, @NotNull PAGAsset.PagScaleMode scaleMode) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(scaleMode, "scaleMode");
        Integer valueOf = Integer.valueOf(usage);
        return new PAGAsset(null, null, Boolean.TRUE, "PAGAsset", null, resourceId, valueOf, null, replacement, Integer.valueOf(scaleMode.getValue()), null, 1171, null);
    }

    @Override // xd4.e
    @NotNull
    public ScreenTransform q(float scaleX, float scaleY) {
        Vec3 vec3 = new Vec3(0.0f, 0.0f, 0.0f, null, 8, null);
        Quat quat = new Quat(0.0f, 0.0f, 0.0f, 1.0f, null, 16, null);
        Vec3 vec32 = new Vec3(scaleX, scaleY, 1.0f, null, 8, null);
        Rect rect = new Rect(-1.0f, 1.0f, 1.0f, -1.0f, null, 16, null);
        Rect rect2 = new Rect(0.0f, 0.0f, 0.0f, 0.0f, null, 16, null);
        Vec2 vec2 = new Vec2(0.0f, 0.0f, null, 4, null);
        Boolean bool = Boolean.TRUE;
        return new ScreenTransform(null, null, bool, "ScreenTransform", rect, rect2, vec2, null, null, null, bool, vec3, quat, vec32, null, bool, null, null, 213891, null);
    }

    @Override // xd4.e
    @NotNull
    public ScreenTransform r(float f16, float f17, float f18, float f19, float f26, float f27) {
        return e.a.d(this, f16, f17, f18, f19, f26, f27);
    }

    @Override // xd4.e
    @NotNull
    public Camera s(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Integer num = null;
        return new Camera(null, Boolean.TRUE, num, key, "Camera", null, null, 101, null);
    }

    @NotNull
    public Transition t(@NotNull String resourceId, long durationUs) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        return b(resourceId, durationUs, 0, 1);
    }
}
