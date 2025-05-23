package td4;

import com.google.gson.JsonObject;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.LightConstants;
import org.light.lightAssetKit.components.AITextureComponent;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.EntityIdentifier;
import org.light.lightAssetKit.components.ExternalRender;
import org.light.lightAssetKit.components.FilterGroup;
import org.light.lightAssetKit.components.Image;
import org.light.lightAssetKit.components.LUTFilter;
import org.light.lightAssetKit.components.PAGAsset;
import org.light.lightAssetKit.components.ReplaceItem;
import org.light.lightAssetKit.components.Smooth;
import org.light.lightAssetKit.components.TimeOffset;
import org.light.lightAssetKit.components.Transition;
import org.light.lightAssetKit.enums.AudioSourceType;
import org.light.lightAssetKit.enums.PAGScaleMode;
import org.light.lightAssetKit.enums.ReplaceType;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J&\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J0\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J(\u0010$\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010&\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010)\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0018\u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0016J \u0010/\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00105\u001a\u000204H\u0016\u00a8\u00068"}, d2 = {"Ltd4/b;", "Ltd4/e;", "", "startOffsetUs", "durationUs", "Lorg/light/lightAssetKit/components/TimeOffset;", "e", "", "loopCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "resourceId", "", "Lorg/light/lightAssetKit/components/ReplaceItem;", "replacement", "Lorg/light/lightAssetKit/enums/PAGScaleMode;", HippyQQPagViewController.PropertyName.SCALE_MODE, "Lorg/light/lightAssetKit/components/PAGAsset;", "i", "replaceIndex", "usage", "imageLayerSize", "k", "name", "Lorg/light/lightAssetKit/components/EntityIdentifier;", "a", "", "intensity", "Lorg/light/lightAssetKit/components/LUTFilter;", "f", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "speed", "Lorg/light/lightAssetKit/components/AudioSource;", "c", "Lorg/light/lightAssetKit/enums/AudioSourceType;", "type", tl.h.F, "Lorg/light/lightAssetKit/components/Transition;", "o", "firstLayerIndex", "lastLayerIndex", "b", "key", "data", "Lorg/light/lightAssetKit/components/ExternalRender;", "j", "Lorg/light/lightAssetKit/components/Image;", "l", "Lorg/light/lightAssetKit/components/Smooth;", DomainData.DOMAIN_NAME, "Lorg/light/lightAssetKit/components/AITextureComponent;", "g", "Lorg/light/lightAssetKit/components/FilterGroup;", "d", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final b f435875a = new b();

    b() {
    }

    @Override // td4.e
    @NotNull
    public EntityIdentifier a(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        return new EntityIdentifier();
    }

    @Override // td4.e
    @NotNull
    public Transition b(@NotNull String resourceId, long durationUs, int firstLayerIndex, int lastLayerIndex) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Transition transition = new Transition();
        transition.setSrc(resourceId);
        transition.setFirstIndex(firstLayerIndex);
        transition.setLastIndex(lastLayerIndex);
        transition.setDuration(durationUs);
        return transition;
    }

    @Override // td4.e
    @NotNull
    public AudioSource c(@NotNull String resourceId, float volume, float speed) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        AudioSource audioSource = new AudioSource();
        audioSource.setSrc(resourceId);
        audioSource.setVolume(volume);
        audioSource.setSpeed(speed);
        return audioSource;
    }

    @Override // td4.e
    @NotNull
    public FilterGroup d() {
        return new FilterGroup();
    }

    @Override // td4.e
    @NotNull
    public TimeOffset e(long startOffsetUs, long durationUs) {
        TimeOffset timeOffset = new TimeOffset();
        timeOffset.setStartOffset(startOffsetUs);
        timeOffset.setLoopCount(0);
        timeOffset.setDuration(durationUs);
        return timeOffset;
    }

    @Override // td4.e
    @NotNull
    public LUTFilter f(@NotNull String resourceId, float intensity) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        LUTFilter lUTFilter = new LUTFilter();
        lUTFilter.setSrc(resourceId);
        lUTFilter.setIntensity(intensity);
        return lUTFilter;
    }

    @Override // td4.e
    @NotNull
    public AITextureComponent g() {
        JsonObject jsonObject = new JsonObject();
        Boolean bool = Boolean.FALSE;
        jsonObject.addProperty("enable_deblur", bool);
        jsonObject.addProperty("enable_hdr", Boolean.TRUE);
        jsonObject.addProperty("enable_watermark", bool);
        AITextureComponent aITextureComponent = new AITextureComponent();
        aITextureComponent.setAiInputType("camera");
        aITextureComponent.setAiType(LightConstants.AgentType.PIC_ENHANCE_AGENT);
        aITextureComponent.setIsRealTimeResult(true);
        aITextureComponent.setRenderTargetList(new ArrayList<>());
        aITextureComponent.setAiTextureInputParams(jsonObject);
        return aITextureComponent;
    }

    @Override // td4.e
    @NotNull
    public AudioSource h(@NotNull String resourceId, float volume, float speed, @NotNull AudioSourceType type) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Intrinsics.checkParameterIsNotNull(type, "type");
        AudioSource audioSource = new AudioSource();
        audioSource.setSrc(resourceId);
        audioSource.setVolume(volume);
        audioSource.setSpeed(speed);
        audioSource.setAudioSourceType(type);
        return audioSource;
    }

    @Override // td4.e
    @NotNull
    public PAGAsset i(@NotNull String resourceId, @NotNull List<? extends ReplaceItem> replacement, @NotNull PAGScaleMode scaleMode) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        Intrinsics.checkParameterIsNotNull(scaleMode, "scaleMode");
        PAGAsset pAGAsset = new PAGAsset();
        pAGAsset.setSrc(resourceId);
        pAGAsset.setReplacement(new ArrayList<>(replacement));
        pAGAsset.setScaleMode(scaleMode);
        return pAGAsset;
    }

    @Override // td4.e
    @NotNull
    public ExternalRender j(@NotNull String key, @NotNull String data) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(data, "data");
        ExternalRender externalRender = new ExternalRender();
        externalRender.setKey(key);
        externalRender.setData(data);
        return externalRender;
    }

    @Override // td4.e
    @NotNull
    public PAGAsset k(@NotNull String resourceId, @NotNull PAGScaleMode scaleMode, int replaceIndex, int usage, int imageLayerSize) {
        List<? extends ReplaceItem> listOf;
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Intrinsics.checkParameterIsNotNull(scaleMode, "scaleMode");
        ReplaceItem replaceItem = new ReplaceItem();
        ReplaceType replaceType = ReplaceType.FilterReplacement;
        if (usage != 1 || imageLayerSize != 1) {
            if (usage == 2 && imageLayerSize == 2) {
                replaceType = ReplaceType.Image;
            } else if (usage == 0) {
                replaceType = ReplaceType.Image;
            }
        }
        replaceItem.index = replaceIndex;
        replaceItem.sourceIndex = -1;
        replaceItem.replaceType = replaceType;
        replaceItem.src = "";
        listOf = CollectionsKt__CollectionsJVMKt.listOf(replaceItem);
        return i(resourceId, listOf, scaleMode);
    }

    @Override // td4.e
    @NotNull
    public Image l(@NotNull String resourceId, long durationUs, @NotNull PAGScaleMode scaleMode) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        Intrinsics.checkParameterIsNotNull(scaleMode, "scaleMode");
        Image image = new Image();
        image.setSrc(resourceId);
        image.setDuration(durationUs);
        image.setScaleMode(scaleMode);
        return image;
    }

    @Override // td4.e
    @NotNull
    public TimeOffset m(long startOffsetUs, long durationUs, int loopCount) {
        TimeOffset timeOffset = new TimeOffset();
        timeOffset.setStartOffset(startOffsetUs);
        timeOffset.setDuration(durationUs);
        timeOffset.setLoopCount(loopCount);
        return timeOffset;
    }

    @Override // td4.e
    @NotNull
    public Smooth n() {
        return new Smooth();
    }

    @NotNull
    public Transition o(@NotNull String resourceId, long durationUs) {
        Intrinsics.checkParameterIsNotNull(resourceId, "resourceId");
        return b(resourceId, durationUs, 0, 1);
    }
}
