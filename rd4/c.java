package rd4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.constants.Constants;
import com.tencent.tavcut.core.render.LightAiManager;
import com.tencent.tavcut.core.render.RenderConfig;
import com.tencent.tavcut.core.render.RenderPlayerFactory;
import com.tencent.tavcut.core.render.audio.extractor.AudioExtractorProcessor;
import com.tencent.tavcut.core.render.audio.extractor.IAudioExtractorProcessor;
import com.tencent.tavcut.core.render.builder.light.LightSDKUtils;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.CustomRenderConfig;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.cover.CoverProviderAccessor;
import com.tencent.tavcut.core.render.cover.ICoverProvider;
import com.tencent.tavcut.core.render.exporter.IExporter;
import com.tencent.tavcut.core.render.exporter.MovieExporter;
import com.tencent.tavcut.core.render.parser.PagEffectParser;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.render.thumb.IThumbProvider;
import com.tencent.tavcut.core.render.thumb.ThumbProviderAccessor;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.LAKCutSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.MultiMedia;
import org.light.lightAssetKit.components.Size;
import sd4.DynamicSoConfig;
import td4.d;
import td4.e;
import td4.f;
import td4.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bW\u0010XJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\b\u0010\u0011\u001a\u00020\u000fH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u0014\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\fJ\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u001a\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\u001c2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013JZ\u0010/\u001a\u00020.2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00042\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\f2(\b\u0002\u0010-\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`,J\u0006\u00101\u001a\u000200J\u0006\u00103\u001a\u000202J\u0006\u00105\u001a\u000204J\u0006\u00107\u001a\u000206J\u0016\u0010:\u001a\u0002092\u0006\u00108\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020&J\u0006\u0010<\u001a\u00020;J\u0010\u0010?\u001a\u0004\u0018\u00010>2\u0006\u0010=\u001a\u00020\u0004J\u001e\u0010A\u001a\u0004\u0018\u00010\u001c2\u0006\u0010@\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\fJ&\u0010C\u001a\u0004\u0018\u00010\u001c2\u0006\u0010@\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\f2\u0006\u0010B\u001a\u00020\u000fJ\u0011\u0010D\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\bD\u0010EJ\u001a\u0010H\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010'\u001a\u00020&R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR$\u0010\u0006\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010K\u001a\u0004\bL\u0010MR$\u0010\u0007\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b<\u0010K\u001a\u0004\bN\u0010MR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b/\u0010K\u001a\u0004\bO\u0010MR\"\u0010V\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u00a8\u0006Y"}, d2 = {"Lrd4/c;", "", "Landroid/content/Context;", "context", "", "licencePath", "appId", "appEntry", "", "t", "assetPath", "u", "", "Lsd4/a;", "dynamicSoConfigs", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "b", "Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "customRenderConfig", "Lcom/tencent/tavcut/core/session/ICutSession;", h.F, "agent", "path", "B", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clipAssets", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "y", HippyTKDListViewAdapter.X, "Landroid/widget/FrameLayout;", "playerContainer", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "g", "renderModel", "Lcom/tencent/tavcut/core/render/exporter/IExporter;", "f", "Lorg/light/lightAssetKit/components/Size;", "size", "templateDir", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "renderNodes", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "d", "Ltd4/d;", DomainData.DOMAIN_NAME, "Ltd4/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ltd4/e;", "o", "Ltd4/g;", "r", "clipSource", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "i", "Lcom/tencent/tavcut/core/render/audio/extractor/IAudioExtractorProcessor;", "c", "filePath", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "jsonFilePath", "j", "modifyClipsDuration", "k", "p", "()Landroid/content/Context;", "Lorg/light/lightAssetKit/Entity;", "root", "a", "Landroid/content/Context;", "<set-?>", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "l", ReportConstant.COSTREPORT_PREFIX, "e", "Z", "w", "()Z", BdhLogUtil.LogTag.Tag_Conn, "(Z)V", "isMediaDurationLimit", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isMediaDurationLimit;

    /* renamed from: f, reason: collision with root package name */
    public static final c f431135f = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String appId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String appEntry = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String licencePath = "";

    c() {
    }

    private final void b() {
        if (v()) {
        } else {
            throw new IllegalStateException("You maybe forgot involve installLightAssets first!!!");
        }
    }

    public static /* synthetic */ ICoverProvider e(c cVar, LAKRenderModel lAKRenderModel, Size size, String str, List list, HashMap hashMap, int i3, Object obj) {
        List list2;
        HashMap hashMap2;
        if ((i3 & 8) != 0) {
            list2 = null;
        } else {
            list2 = list;
        }
        if ((i3 & 16) != 0) {
            hashMap2 = null;
        } else {
            hashMap2 = hashMap;
        }
        return cVar.d(lAKRenderModel, size, str, list2, hashMap2);
    }

    @JvmStatic
    public static final void t(@NotNull Context context2, @NotNull String licencePath2, @NotNull String appId2, @NotNull String appEntry2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(licencePath2, "licencePath");
        Intrinsics.checkParameterIsNotNull(appId2, "appId");
        Intrinsics.checkParameterIsNotNull(appEntry2, "appEntry");
        context = context2.getApplicationContext();
        appId = appId2;
        appEntry = appEntry2;
        licencePath = licencePath2;
    }

    @JvmStatic
    public static final void u(@NotNull String assetPath) {
        Intrinsics.checkParameterIsNotNull(assetPath, "assetPath");
        RenderConfig.INSTANCE.setRenderAssetDir(assetPath);
    }

    @JvmStatic
    public static final boolean v() {
        boolean z16;
        if (!LightSDKUtils.INSTANCE.isSoLoaded()) {
            return false;
        }
        if (RenderConfig.INSTANCE.getRenderAssetDir().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean z(@NotNull List<DynamicSoConfig> dynamicSoConfigs) {
        Intrinsics.checkParameterIsNotNull(dynamicSoConfigs, "dynamicSoConfigs");
        return LightSDKUtils.INSTANCE.loadSo(dynamicSoConfigs);
    }

    @Nullable
    public final PagEffectData A(@NotNull String filePath) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        return PagEffectParser.INSTANCE.parse(filePath);
    }

    public final void B(@NotNull String agent, @NotNull String path) {
        Intrinsics.checkParameterIsNotNull(agent, "agent");
        Intrinsics.checkParameterIsNotNull(path, "path");
        b();
        LightAiManager.INSTANCE.registerAiPath(agent, path);
    }

    public final void C(boolean z16) {
        isMediaDurationLimit = z16;
    }

    @Nullable
    public final Entity a(@Nullable Entity root, @NotNull Size size) {
        List<Entity> children;
        Collection<Component> components;
        Intrinsics.checkParameterIsNotNull(size, "size");
        if (root != null && (components = root.getComponents()) != null) {
            for (Component component : components) {
                if (component instanceof MultiMedia) {
                    ((MultiMedia) component).setSize(size);
                }
            }
        }
        if (root != null && (children = root.getChildren()) != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                f431135f.a((Entity) it.next(), size);
            }
        }
        return root;
    }

    @NotNull
    public final IAudioExtractorProcessor c() {
        return new AudioExtractorProcessor();
    }

    @NotNull
    public final ICoverProvider d(@NotNull LAKRenderModel renderModel, @NotNull Size size, @NotNull String templateDir, @Nullable List<? extends BaseEffectNode> renderNodes, @Nullable HashMap<String, String> assetData) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(size, "size");
        Intrinsics.checkParameterIsNotNull(templateDir, "templateDir");
        return CoverProviderAccessor.accessCoverProvider(templateDir, renderModel, size, renderNodes, assetData);
    }

    @NotNull
    public final IExporter f(@NotNull LAKRenderModel renderModel, @Nullable CustomRenderConfig customRenderConfig) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        return new MovieExporter(renderModel);
    }

    @NotNull
    public final IPlayer g(@Nullable FrameLayout playerContainer) {
        return RenderPlayerFactory.INSTANCE.createPlayer(playerContainer, 1);
    }

    @NotNull
    public final ICutSession h(@Nullable CustomRenderConfig customRenderConfig) {
        return new LAKCutSession(customRenderConfig);
    }

    @NotNull
    public final IThumbProvider i(@NotNull ClipSource clipSource, @NotNull Size size) {
        Intrinsics.checkParameterIsNotNull(clipSource, "clipSource");
        Intrinsics.checkParameterIsNotNull(size, "size");
        return ThumbProviderAccessor.getThumbProvider(clipSource, size);
    }

    @Nullable
    public final LAKRenderModel j(@NotNull String jsonFilePath, @NotNull List<ClipSource> clipAssets) {
        Intrinsics.checkParameterIsNotNull(jsonFilePath, "jsonFilePath");
        Intrinsics.checkParameterIsNotNull(clipAssets, "clipAssets");
        b();
        return wd4.a.f445487a.g(jsonFilePath, clipAssets, true);
    }

    @Nullable
    public final LAKRenderModel k(@NotNull String jsonFilePath, @NotNull List<ClipSource> clipAssets, boolean modifyClipsDuration) {
        Intrinsics.checkParameterIsNotNull(jsonFilePath, "jsonFilePath");
        Intrinsics.checkParameterIsNotNull(clipAssets, "clipAssets");
        b();
        return wd4.a.f445487a.g(jsonFilePath, clipAssets, modifyClipsDuration);
    }

    @NotNull
    public final String l() {
        return appEntry;
    }

    @NotNull
    public final String m() {
        return appId;
    }

    @NotNull
    public final d n() {
        return td4.a.f435874a;
    }

    @NotNull
    public final e o() {
        return td4.b.f435875a;
    }

    @Nullable
    public final Context p() {
        return context;
    }

    @NotNull
    public final f q() {
        return td4.c.f435876a;
    }

    @NotNull
    public final g r() {
        return td4.h.f435877a;
    }

    @NotNull
    public final String s() {
        return licencePath;
    }

    public final boolean w() {
        return isMediaDurationLimit;
    }

    @NotNull
    public final String x() {
        Context context2 = context;
        if (context2 != null) {
            return com.tencent.videocut.utils.g.f384239a.i(context2, Constants.FILE_EMPTY_TEMPLATE);
        }
        throw new IllegalStateException("Before use TavCut, must init it first!");
    }

    @NotNull
    public final LAKRenderModel y(@NotNull List<ClipSource> clipAssets) {
        Intrinsics.checkParameterIsNotNull(clipAssets, "clipAssets");
        return new LAKRenderModel(null, null, null, null, null, clipAssets, false, 0, null, null, null, 0L, 0, null, null, false, null, null, 262111, null);
    }
}
