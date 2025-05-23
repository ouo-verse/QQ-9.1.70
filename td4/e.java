package td4;

import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH&J0\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\nH&J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH&J \u0010!\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH&J(\u0010$\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"H&J(\u0010(\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H&J\u0018\u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH&J$\u0010.\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000fH&J\b\u00100\u001a\u00020/H&J\b\u00102\u001a\u000201H&J\b\u00104\u001a\u000203H&\u00a8\u00065"}, d2 = {"Ltd4/e;", "", "", "startOffsetUs", "durationUs", "Lorg/light/lightAssetKit/components/TimeOffset;", "e", "", "loopCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "resourceId", "", "Lorg/light/lightAssetKit/components/ReplaceItem;", "replacement", "Lorg/light/lightAssetKit/enums/PAGScaleMode;", HippyQQPagViewController.PropertyName.SCALE_MODE, "Lorg/light/lightAssetKit/components/PAGAsset;", "i", "replaceIndex", "usage", "imageLayerSize", "k", "name", "Lorg/light/lightAssetKit/components/EntityIdentifier;", "a", "", "strength", "Lorg/light/lightAssetKit/components/LUTFilter;", "f", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "speed", "Lorg/light/lightAssetKit/components/AudioSource;", "c", "Lorg/light/lightAssetKit/enums/AudioSourceType;", "type", tl.h.F, "firstLayerIndex", "lastLayerIndex", "Lorg/light/lightAssetKit/components/Transition;", "b", "key", "data", "Lorg/light/lightAssetKit/components/ExternalRender;", "j", "Lorg/light/lightAssetKit/components/Image;", "l", "Lorg/light/lightAssetKit/components/Smooth;", DomainData.DOMAIN_NAME, "Lorg/light/lightAssetKit/components/AITextureComponent;", "g", "Lorg/light/lightAssetKit/components/FilterGroup;", "d", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface e {
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
    AITextureComponent g();

    @NotNull
    AudioSource h(@NotNull String resourceId, float volume, float speed, @NotNull AudioSourceType type);

    @NotNull
    PAGAsset i(@NotNull String resourceId, @NotNull List<? extends ReplaceItem> replacement, @NotNull PAGScaleMode scaleMode);

    @NotNull
    ExternalRender j(@NotNull String key, @NotNull String data);

    @NotNull
    PAGAsset k(@NotNull String resourceId, @NotNull PAGScaleMode scaleMode, int replaceIndex, int usage, int imageLayerSize);

    @NotNull
    Image l(@NotNull String resourceId, long durationUs, @NotNull PAGScaleMode scaleMode);

    @NotNull
    TimeOffset m(long startOffsetUs, long durationUs, int loopCount);

    @NotNull
    Smooth n();
}
