package zd4;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.model.TextPlaceInfo;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.listener.OnLoadAssetListener;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&J\"\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001b\u001a\u00020\u0006H&J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH&J\u001a\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH&J\u0018\u0010$\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010'\u001a\u00020\u00062\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010#H&J\u0012\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(H&J\u001e\u0010-\u001a\u00020\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010+H&J$\u0010.\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140+H&J\u001e\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010+2\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u000200H&J\u0010\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0018H&J\"\u00107\u001a\u00020\u00062\u0018\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000605H&J\"\u0010:\u001a\u00020\u00062\u0018\u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002090#\u0012\u0004\u0012\u00020\u000608H&J\b\u0010;\u001a\u00020\u0018H&J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0018H&J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>H&J\u0010\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020AH&J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010B\u001a\u00020AH&\u00a8\u0006E"}, d2 = {"Lzd4/b;", "", "", TemplateParser.KEY_ENTITY_ID, "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", HippyQQConstants.URL_COMPONENT_NAME, "", "c", "parentId", "childIndex", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "e", "a", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "inputSource", "g", "Ljava/lang/Runnable;", "runnable", "runOnAfterApply", "", "templateDir", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "", "targetTime", h.F, "release", "", HippyTKDListViewAdapter.X, "y", "Ljava/util/ArrayList;", "getEntitiesUnderPoint", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "getEditableTextUnderPoint", "", "getEditableTextByEntityId", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", DownloadInfo.spKey_Config, "setVoiceChangerConfig", "Lcom/tencent/tav/coremedia/CMTimeRange;", "renderTimeRange", "setRenderTimeRange", "Ljava/util/HashMap;", "assetData", "setAssetData", "addAssetDataToHolder", "getCurrentAssetData", "Lfe4/a;", "effectNode", "d", "durationUs", "f", "Lkotlin/Function2;", "observer", "registerDurationObserver", "Lkotlin/Function1;", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "registerTimelineObserver", "getMovieControllerDuration", "duration", "setRenderNodeDuration", "Lorg/light/listener/OnLoadAssetListener;", "listener", "setLoadAssetListener", "Lcom/tencent/tavcut/session/b;", "callback", "i", "b", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, String str, RenderModel renderModel, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    j3 = -1;
                }
                bVar.h(str, renderModel, j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadAsset");
        }
    }

    void a(int entityId);

    void addAssetDataToHolder(@NotNull String templateDir, @NotNull HashMap<String, String> assetData);

    void b(@NotNull com.tencent.tavcut.session.b callback);

    void c(int entityId, @NotNull IdentifyComponent component);

    void d(@NotNull fe4.a effectNode);

    void e(int parentId, int childIndex, @NotNull Entity entity);

    void f(long durationUs);

    void g(@NotNull InputSource inputSource);

    @Nullable
    HashMap<String, String> getCurrentAssetData(@NotNull String templateDir);

    @Nullable
    List<TextPlaceInfo> getEditableTextByEntityId(int entityId);

    @Nullable
    TextPlaceInfo getEditableTextUnderPoint(float x16, float y16);

    @NotNull
    ArrayList<Integer> getEntitiesUnderPoint(float x16, float y16);

    long getMovieControllerDuration();

    void h(@NotNull String templateDir, @NotNull RenderModel renderModel, long targetTime);

    void i(@NotNull com.tencent.tavcut.session.b callback);

    void registerDurationObserver(@NotNull Function2<? super Long, ? super Long, Unit> observer);

    void registerTimelineObserver(@NotNull Function1<? super List<Timeline>, Unit> observer);

    void release();

    void runOnAfterApply(@NotNull Runnable runnable);

    void setAssetData(@Nullable HashMap<String, String> assetData);

    void setLoadAssetListener(@NotNull OnLoadAssetListener listener);

    void setRenderNodeDuration(long duration);

    void setRenderTimeRange(@Nullable CMTimeRange renderTimeRange);

    void setVoiceChangerConfig(@Nullable List<? extends VoiceEnum> config);
}
