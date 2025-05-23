package zd4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import fe4.a;
import fe4.b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000  2\u00020\u0001:\u0003\t\u0013\u0005B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0013\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lzd4/a;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "Lcom/tencent/tav/coremedia/CMTimeRange;", "renderTimeRange", "", "c", "(Lcom/tencent/tav/coremedia/CMTimeRange;)V", "Lfe4/a;", "effectNode", "a", "(Lfe4/a;)V", "", "effectId", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "createFilter", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "effectNodes", "Lzd4/a$c;", "b", "Lzd4/a$c;", "getEffectDispatchListener", "()Lzd4/a$c;", "(Lzd4/a$c;)V", "effectDispatchListener", "Lzd4/a$b;", "Lzd4/a$b;", "dispatcherFilter", "d", "Lcom/tencent/tav/coremedia/CMTimeRange;", "<init>", "()V", "e", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a implements TAVVideoMixEffect {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<fe4.a> effectNodes = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c effectDispatchListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private b dispatcherFilter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CMTimeRange renderTimeRange;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u0016\u0010'\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006-"}, d2 = {"Lzd4/a$b;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "renderInfo", "b", "", "d", "Lcom/tencent/tavkit/composition/video/ImageCollection;", "imageCollection", "Lcom/tencent/tavkit/ciimage/CIImage;", "c", "Lcom/tencent/tavkit/composition/video/ImageCollection$TrackImagePair;", "imagePair", "sourceImage", "a", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", QQWinkConstants.TAB_EFFECT, "apply", "release", "Lcom/tencent/tav/coremedia/CMTimeRange;", "renderTimeRange", "e", "(Lcom/tencent/tav/coremedia/CMTimeRange;)V", "Lfe4/b;", "Lfe4/b;", "imageParams", "", "Lfe4/a$b;", "Ljava/util/List;", "mFilters", "Lcom/tencent/tavkit/ciimage/CIImage;", "backImage", "", "Z", "showCanvas", "Lcom/tencent/tav/coremedia/CMTimeRange;", "Lzd4/a$c;", "f", "Lzd4/a$c;", "effectDispatchListener", "", "Lfe4/a;", "effectNodes", "<init>", "(Ljava/util/List;Lzd4/a$c;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class b implements TAVVideoMixEffect.Filter {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final fe4.b imageParams;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private List<a.b> mFilters;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private CIImage backImage;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean showCanvas;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private CMTimeRange renderTimeRange;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final c effectDispatchListener;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lfe4/a;", "o1", "o2", "", "a", "(Lfe4/a;Lfe4/a;)I"}, k = 3, mv = {1, 4, 0})
        /* renamed from: zd4.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        static final class C11677a<T> implements Comparator<fe4.a> {

            /* renamed from: d, reason: collision with root package name */
            public static final C11677a f452388d = new C11677a();

            C11677a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final int compare(@NotNull fe4.a o16, @NotNull fe4.a o26) {
                Intrinsics.checkParameterIsNotNull(o16, "o1");
                Intrinsics.checkParameterIsNotNull(o26, "o2");
                if (o16.getNodeIndex() < o26.getNodeIndex()) {
                    return -1;
                }
                if (o16.getNodeIndex() > o26.getNodeIndex()) {
                    return 1;
                }
                return 0;
            }
        }

        public b(@NotNull List<? extends fe4.a> effectNodes, @Nullable c cVar) {
            Intrinsics.checkParameterIsNotNull(effectNodes, "effectNodes");
            this.effectDispatchListener = cVar;
            this.imageParams = new fe4.b();
            this.mFilters = new ArrayList();
            ArrayList arrayList = new ArrayList(effectNodes);
            if (!arrayList.isEmpty()) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, C11677a.f452388d);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mFilters.add(((fe4.a) it.next()).a());
            }
        }

        private final void a(RenderInfo renderInfo, ImageCollection.TrackImagePair imagePair, CIImage sourceImage) {
            if (!(imagePair.getTrack() instanceof TAVClip)) {
                return;
            }
            TAVVideoCompositionTrack track = imagePair.getTrack();
            if (track != null) {
                TAVVideoConfiguration config = ((TAVClip) track).getVideoConfiguration();
                if (config.frameEnable()) {
                    return;
                }
                CGRect cGRect = new CGRect(new PointF(0.0f, 0.0f), renderInfo.getRenderSize());
                Intrinsics.checkExpressionValueIsNotNull(config, "config");
                sourceImage.applyFillInFrame(cGRect, config.getContentMode());
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavkit.composition.TAVClip");
        }

        private final RenderInfo b(RenderInfo renderInfo) {
            CMTime cMTime;
            CMTimeRange cMTimeRange = this.renderTimeRange;
            if (cMTimeRange != null) {
                if (renderInfo.getTime().bigThan(cMTimeRange.getEnd())) {
                    cMTime = cMTimeRange.getEnd();
                } else {
                    cMTime = null;
                }
                if (renderInfo.getTime().smallThan(cMTimeRange.getStart())) {
                    cMTime = cMTimeRange.getStart();
                }
                if (cMTime != null) {
                    return new RenderInfo(cMTime, renderInfo.getRenderSize(), renderInfo.getCiContext());
                }
            }
            return renderInfo;
        }

        private final CIImage c(ImageCollection imageCollection, RenderInfo renderInfo) {
            CIImage cIImage = new CIImage(renderInfo.getRenderSize());
            for (ImageCollection.TrackImagePair trackImage : imageCollection.getVideoChannelImages()) {
                Intrinsics.checkExpressionValueIsNotNull(trackImage, "trackImage");
                CIImage image = trackImage.getImage();
                Intrinsics.checkExpressionValueIsNotNull(image, "trackImage.image");
                a(renderInfo, trackImage, image);
                image.imageByCompositingOverImage(cIImage);
            }
            for (ImageCollection.TrackImagePair overlay : imageCollection.getOverlayImages()) {
                Intrinsics.checkExpressionValueIsNotNull(overlay, "overlay");
                CIImage image2 = overlay.getImage();
                Intrinsics.checkExpressionValueIsNotNull(image2, "overlay.image");
                a(renderInfo, overlay, image2);
                image2.imageByCompositingOverImage(cIImage);
            }
            return cIImage;
        }

        private final void d(RenderInfo renderInfo) {
            CGSize cGSize;
            CIImage cIImage = this.backImage;
            if (cIImage != null) {
                if (cIImage != null) {
                    cGSize = cIImage.getSize();
                } else {
                    cGSize = null;
                }
                if (!(!Intrinsics.areEqual(cGSize, renderInfo.getRenderSize()))) {
                    return;
                }
            }
            ColorDrawable colorDrawable = new ColorDrawable(-16711936);
            Bitmap createBitmap = Bitmap.createBitmap(renderInfo.getRenderWidth(), renderInfo.getRenderHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            colorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            colorDrawable.draw(canvas);
            this.backImage = new CIImage(createBitmap);
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
        @NotNull
        public CIImage apply(@NotNull TAVVideoMixEffect effect, @NotNull ImageCollection imageCollection, @NotNull RenderInfo renderInfo) {
            Intrinsics.checkParameterIsNotNull(effect, "effect");
            Intrinsics.checkParameterIsNotNull(imageCollection, "imageCollection");
            Intrinsics.checkParameterIsNotNull(renderInfo, "renderInfo");
            yd4.a.f450209c.b("tavCut-EffectDispatcher", "tavCut-EffectDispatcher");
            this.imageParams.a().clear();
            for (ImageCollection.TrackImagePair trackImagePair : imageCollection.getVideoChannelImages()) {
                List<b.a> a16 = this.imageParams.a();
                Intrinsics.checkExpressionValueIsNotNull(trackImagePair, "trackImagePair");
                CIImage image = trackImagePair.getImage();
                Intrinsics.checkExpressionValueIsNotNull(image, "trackImagePair.image");
                a16.add(new b.a(image, trackImagePair.getTrack()));
            }
            RenderInfo b16 = b(renderInfo);
            c cVar = this.effectDispatchListener;
            if (cVar != null) {
                cVar.onBeforeApply();
            }
            for (a.b bVar : this.mFilters) {
                if (bVar.isNeedApply(b16)) {
                    bVar.a(this.imageParams, b16);
                }
            }
            if (this.showCanvas) {
                d(b16);
                b.a aVar = this.imageParams.a().get(0);
                CIImage imageByCompositingOverImage = this.imageParams.a().get(0).getImage().imageByCompositingOverImage(this.backImage);
                Intrinsics.checkExpressionValueIsNotNull(imageByCompositingOverImage, "imageParams.videoChannel\u2026itingOverImage(backImage)");
                aVar.b(imageByCompositingOverImage);
            }
            c cVar2 = this.effectDispatchListener;
            if (cVar2 != null) {
                cVar2.onAfterApply();
            }
            yd4.a.f450209c.a("tavCut-EffectDispatcher");
            if (this.imageParams.a().size() > 0) {
                return this.imageParams.a().get(0).getImage();
            }
            return c(imageCollection, b16);
        }

        public final void e(@Nullable CMTimeRange renderTimeRange) {
            this.renderTimeRange = renderTimeRange;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            Iterator<T> it = this.mFilters.iterator();
            while (it.hasNext()) {
                ((a.b) it.next()).release();
            }
            c cVar = this.effectDispatchListener;
            if (cVar != null) {
                cVar.releaseAfterAllNode();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lzd4/a$c;", "", "", "onBeforeApply", "onAfterApply", "releaseAfterAllNode", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public interface c {
        void onAfterApply();

        void onBeforeApply();

        void releaseAfterAllNode();
    }

    public final void a(@NotNull fe4.a effectNode) {
        Intrinsics.checkParameterIsNotNull(effectNode, "effectNode");
        if (!this.effectNodes.contains(effectNode)) {
            if (effectNode.getNodeIndex() == -1) {
                HashMap<String, Integer> b16 = fe4.d.f398411c.b();
                if (b16.get(effectNode.getClass().getSimpleName()) != null) {
                    Integer num = b16.get(effectNode.getClass().getSimpleName());
                    if (num == null) {
                        Intrinsics.throwNpe();
                    }
                    effectNode.e(num.intValue());
                }
            }
            if (effectNode.getNodeIndex() == -1) {
                ee4.b.b("tavCut-EffectDispatcher", "\u5f53\u524d\u8282\u70b9\u6ca1\u6709\u8bbe\u7f6e\u6e32\u67d3\u987a\u5e8f\u7684index\uff0c\u9ed8\u8ba4\u914d\u7f6e\u4e2d\u4e5f\u6ca1\u6709\u914d\u7f6e\u5f53\u524d\u8282\u70b9\u987a\u5e8f\uff0c\u4e0d\u4f1a\u52a0\u5165\u6e32\u67d3\u94fe\u4e2d\uff0c\u8bf7\u68c0\u67e5EffectNodeOrderUtils\u4e2d\u914d\u7f6e\uff01\uff01\u8282\u70b9EffectId\uff1a" + effectNode.b());
                return;
            }
            this.effectNodes.add(effectNode);
        }
    }

    public final void b(@Nullable c cVar) {
        this.effectDispatchListener = cVar;
    }

    public final void c(@Nullable CMTimeRange renderTimeRange) {
        this.renderTimeRange = renderTimeRange;
        b bVar = this.dispatcherFilter;
        if (bVar != null) {
            bVar.e(renderTimeRange);
        }
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    @NotNull
    public TAVVideoMixEffect.Filter createFilter() {
        b bVar = this.dispatcherFilter;
        if (bVar == null) {
            bVar = new b(this.effectNodes, this.effectDispatchListener);
        }
        this.dispatcherFilter = bVar;
        return bVar;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    @Nullable
    public String effectId() {
        return "tavCut-EffectDispatcher@" + Integer.toHexString(hashCode());
    }
}
