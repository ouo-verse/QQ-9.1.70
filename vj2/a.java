package vj2;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropFragment;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.tavcut.render.player.IPlayer;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bG\u0010HJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J>\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u0012\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0016\u0010&\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\n028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\n068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R&\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0<028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00104R)\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0<068\u0006\u00a2\u0006\f\n\u0004\b?\u00108\u001a\u0004\b@\u0010:R0\u0010F\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\"0Bj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\"`C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006J"}, d2 = {"Lvj2/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "mediaClip", "Landroid/graphics/Matrix;", "matrix", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "ratioType", "Landroid/graphics/RectF;", "cropRect", "", "isRotate90", "", "T1", CanvasView.ACTION_RECT, "P1", "", "getLogTag", "Lcom/tencent/tavcut/session/a;", "iCutSession", "Lcom/tencent/tavcut/render/player/IPlayer;", "iPlayer", "M1", "N1", "", "angle", "storedMatrix", "storedRectF", "U1", "show", "R1", "needShow", "S1", "O1", "Lvj2/a$a;", "Q1", "i", "Lcom/tencent/tavcut/session/a;", "cutSession", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/tavcut/render/player/IPlayer;", "player", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer;", "renderLayerHelper", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "D", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "mCurrentMediaModel", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "_cropPageShowLiveData", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "getCropPageShowLiveData", "()Landroidx/lifecycle/LiveData;", "cropPageShowLiveData", "Lkotlin/Pair;", "G", "_changedClipLiveData", "H", "L1", "changedClipLiveData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "I", "Ljava/util/HashMap;", "storedCropInfo", "<init>", "()V", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private ComposeRenderLayer renderLayerHelper;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MediaModel mCurrentMediaModel = new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _cropPageShowLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> cropPageShowLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Matrix, RectF>> _changedClipLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Pair<Matrix, RectF>> changedClipLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, CropInfo> storedCropInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.tavcut.session.a cutSession;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private IPlayer player;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lvj2/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Matrix;", "a", "Landroid/graphics/Matrix;", "b", "()Landroid/graphics/Matrix;", "matrix", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "c", "()Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;", "ratioType", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "()Landroid/graphics/RectF;", "cropRect", "d", "Z", "()Z", "isRotate90", "<init>", "(Landroid/graphics/Matrix;Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropFragment$RatioType;Landroid/graphics/RectF;Z)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vj2.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class CropInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Matrix matrix;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final VideoEditorCropFragment.RatioType ratioType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RectF cropRect;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isRotate90;

        public CropInfo(@NotNull Matrix matrix, @NotNull VideoEditorCropFragment.RatioType ratioType, @NotNull RectF cropRect, boolean z16) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            Intrinsics.checkNotNullParameter(ratioType, "ratioType");
            Intrinsics.checkNotNullParameter(cropRect, "cropRect");
            this.matrix = matrix;
            this.ratioType = ratioType;
            this.cropRect = cropRect;
            this.isRotate90 = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RectF getCropRect() {
            return this.cropRect;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Matrix getMatrix() {
            return this.matrix;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final VideoEditorCropFragment.RatioType getRatioType() {
            return this.ratioType;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsRotate90() {
            return this.isRotate90;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CropInfo)) {
                return false;
            }
            CropInfo cropInfo = (CropInfo) other;
            if (Intrinsics.areEqual(this.matrix, cropInfo.matrix) && this.ratioType == cropInfo.ratioType && Intrinsics.areEqual(this.cropRect, cropInfo.cropRect) && this.isRotate90 == cropInfo.isRotate90) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.matrix.hashCode() * 31) + this.ratioType.hashCode()) * 31) + this.cropRect.hashCode()) * 31;
            boolean z16 = this.isRotate90;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "CropInfo(matrix=" + this.matrix + ", ratioType=" + this.ratioType + ", cropRect=" + this.cropRect + ", isRotate90=" + this.isRotate90 + ")";
        }
    }

    public a() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._cropPageShowLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.cropPageShowLiveData = mutableLiveData;
        MutableLiveData<Pair<Matrix, RectF>> mutableLiveData2 = new MutableLiveData<>();
        this._changedClipLiveData = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Pair<android.graphics.Matrix, android.graphics.RectF>>");
        this.changedClipLiveData = mutableLiveData2;
        this.storedCropInfo = new HashMap<>();
    }

    private final void P1(RectF rect) {
        float f16 = 2;
        if (rect.width() < f16) {
            float f17 = rect.left;
            if (f17 > f16) {
                rect.left = rect.right - f16;
            } else {
                rect.right = f17 + f16;
            }
        }
        if (rect.height() < f16) {
            float f18 = rect.top;
            if (f18 > f16) {
                rect.top = rect.bottom - f16;
            } else {
                rect.bottom = f18 + f16;
            }
        }
    }

    private final void T1(MediaClip mediaClip, Matrix matrix, VideoEditorCropFragment.RatioType ratioType, RectF cropRect, boolean isRotate90) {
        String str;
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null && (str = resourceModel.path) != null) {
            this.storedCropInfo.put(str, new CropInfo(new Matrix(matrix), ratioType, cropRect, isRotate90));
        }
    }

    @NotNull
    public final LiveData<Pair<Matrix, RectF>> L1() {
        return this.changedClipLiveData;
    }

    public final void M1(@NotNull com.tencent.tavcut.session.a iCutSession, @NotNull IPlayer iPlayer) {
        Intrinsics.checkNotNullParameter(iCutSession, "iCutSession");
        Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        this.cutSession = iCutSession;
        this.player = iPlayer;
    }

    public final void N1(@Nullable MediaClip mediaClip) {
        MediaClip mediaClip2;
        MediaType mediaType;
        ComposeRenderLayer.RenderScene renderScene;
        List listOf;
        ResourceModel resourceModel;
        List emptyList;
        ResourceModel resourceModel2;
        ComposeRenderLayer composeRenderLayer = null;
        if (mediaClip != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            ResourceModel resourceModel3 = mediaClip.resource;
            if (resourceModel3 != null) {
                resourceModel2 = ResourceModel.copy$default(resourceModel3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 63487, null);
            } else {
                resourceModel2 = null;
            }
            mediaClip2 = MediaClip.copy$default(mediaClip, resourceModel2, null, null, null, null, emptyList, null, 94, null);
        } else {
            mediaClip2 = null;
        }
        com.tencent.tavcut.session.a aVar = this.cutSession;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cutSession");
            aVar = null;
        }
        MediaModel mediaModel = new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
        if (mediaClip2 != null && (resourceModel = mediaClip2.resource) != null) {
            mediaType = resourceModel.type;
        } else {
            mediaType = null;
        }
        if (mediaType == MediaType.IMAGE) {
            renderScene = ComposeRenderLayer.RenderScene.PIC;
        } else {
            renderScene = ComposeRenderLayer.RenderScene.VIDEO;
        }
        this.renderLayerHelper = new ComposeRenderLayer(aVar, mediaModel, renderScene);
        if (mediaClip2 != null) {
            MediaModel mediaModel2 = this.mCurrentMediaModel;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(mediaClip2);
            this.mCurrentMediaModel = MediaModel.copy$default(mediaModel2, null, null, null, null, null, null, listOf, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null);
            ComposeRenderLayer composeRenderLayer2 = this.renderLayerHelper;
            if (composeRenderLayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            } else {
                composeRenderLayer = composeRenderLayer2;
            }
            composeRenderLayer.d(this.mCurrentMediaModel);
        }
    }

    public final boolean O1() {
        return AECameraPrefsUtil.b().a(AECameraPrefsUtil.f275093h, true, 0);
    }

    @Nullable
    public final CropInfo Q1(@Nullable MediaClip mediaClip) {
        ResourceModel resourceModel;
        String str;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (str = resourceModel.path) != null) {
            return this.storedCropInfo.get(str);
        }
        return null;
    }

    public final void R1(boolean show) {
        this._cropPageShowLiveData.postValue(Boolean.valueOf(show));
    }

    public final void S1(boolean needShow) {
        AECameraPrefsUtil.b().d(AECameraPrefsUtil.f275093h, needShow, 0);
    }

    public final void U1(@NotNull MediaClip mediaClip, float angle, @NotNull VideoEditorCropFragment.RatioType ratioType, @NotNull RectF rect, @NotNull Matrix storedMatrix, @NotNull RectF storedRectF, boolean isRotate90) {
        Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
        Intrinsics.checkNotNullParameter(ratioType, "ratioType");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(storedMatrix, "storedMatrix");
        Intrinsics.checkNotNullParameter(storedRectF, "storedRectF");
        P1(rect);
        Matrix matrix = new Matrix();
        matrix.setRotate(angle);
        T1(mediaClip, storedMatrix, ratioType, storedRectF, isRotate90);
        ms.a.a("VideoEditorCropFragment", "[updateCurMediaClip] matrix=" + matrix + " rect=" + rect);
        this._changedClipLiveData.postValue(TuplesKt.to(matrix, rect));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "qqVideoEditorCropViewModel";
    }
}
