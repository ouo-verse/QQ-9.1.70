package wd4;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tavcut.core.render.RenderConfig;
import com.tencent.tavcut.core.render.builder.light.LightEntityTransHelper;
import com.tencent.tavcut.core.render.builder.light.LightSDKUtils;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.tavcut.core.render.log.TavLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutputConfig;
import org.light.ClipAsset;
import org.light.ClipInfo;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.TimeRange;
import org.light.VideoOutputConfig;
import rd4.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0010B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ:\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u001c\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J(\u0010\u001d\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005H\u0002J\u0016\u0010 \u001a\u00020\u001e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J\u0016\u0010!\u001a\u00020\u001e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J\u0016\u0010\"\u001a\u00020\u001e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002J(\u0010%\u001a\u00020\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J&\u0010(\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J+\u0010*\u001a\u00020\u001e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u00a2\u0006\u0004\b*\u0010+J&\u00101\u001a\u0004\u0018\u0001002\u0006\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010/\u001a\u00020\u001eJ\u001d\u00103\u001a\u00020\u001e2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b3\u00104\u00a8\u00067"}, d2 = {"Lwd4/a;", "", "", "Lorg/light/ClipPlaceHolder;", "clipPlaceHolders", "", "Lwd4/a$a;", "p", "([Lorg/light/ClipPlaceHolder;)Ljava/util/List;", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clips", "lightSegments", "", "musicVolume", "", "duration", "b", "e", "segment", "", "", "a", "clip", "mLightSegments", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "movieClips", "r", "videoRes", "c", h.F, "", "o", "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "remainClips", "mNeedCycleFill", "f", "mediaClip", "d", "i", SegmentKeeper.KEY_SEGMENT_LIST, "l", "([Lorg/light/ClipPlaceHolder;Ljava/util/List;)Z", "", "templateJsonPath", "filledClipAssets", "modifyClipsDuration", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "g", "clipHolders", DomainData.DOMAIN_NAME, "([Lorg/light/ClipPlaceHolder;)Z", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f445487a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lwd4/a$a;", "", "Lwd4/a$b;", "a", "Lwd4/a$b;", "()Lwd4/a$b;", "d", "(Lwd4/a$b;)V", "timeRange", "", "b", "J", "getMinDuration", "()J", "c", "(J)V", "minDuration", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "Ljava/util/List;", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "videoResourceModels", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
    /* renamed from: wd4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11478a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long minDuration;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private b timeRange = new b(0, 0, 3, null);

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<ClipSource> videoResourceModels = new ArrayList();

        @NotNull
        /* renamed from: a, reason: from getter */
        public final b getTimeRange() {
            return this.timeRange;
        }

        @NotNull
        public final List<ClipSource> b() {
            return this.videoResourceModels;
        }

        public final void c(long j3) {
            this.minDuration = j3;
        }

        public final void d(@NotNull b bVar) {
            Intrinsics.checkParameterIsNotNull(bVar, "<set-?>");
            this.timeRange = bVar;
        }

        public final void e(@NotNull List<ClipSource> list) {
            Intrinsics.checkParameterIsNotNull(list, "<set-?>");
            this.videoResourceModels = list;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lwd4/a$b;", "", "", "a", "J", "getStart", "()J", "start", "b", "duration", "<init>", "(JJ)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long start;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long duration;

        public b(long j3, long j16) {
            this.start = j3;
            this.duration = j16;
        }

        /* renamed from: a, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        public /* synthetic */ b(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16);
        }
    }

    a() {
    }

    private final void a(C11478a segment, float musicVolume, List<ClipSource> clips) {
        for (ClipSource clipSource : segment.b()) {
            if (clipSource.getType() == ClipType.VIDEO) {
                h(clipSource, musicVolume, clips);
            } else if (clipSource.getType() == ClipType.PHOTO) {
                c(clipSource, clips);
            }
        }
    }

    private final List<ClipSource> b(List<ClipSource> clips, List<C11478a> lightSegments, float musicVolume, long duration) {
        List<ClipSource> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) clips);
        boolean o16 = o(mutableList);
        if (o16 && lightSegments.size() > 1) {
            mutableList = q(mutableList.get(0), lightSegments);
        } else if (k(mutableList) && mutableList.size() < lightSegments.size() && !o16) {
            mutableList = r(mutableList, lightSegments, duration);
        }
        boolean m3 = m(mutableList);
        for (C11478a c11478a : lightSegments) {
            if (mutableList.isEmpty()) {
                break;
            }
            f(c11478a, mutableList, m3);
        }
        return e(lightSegments, musicVolume);
    }

    private final void c(ClipSource videoRes, List<ClipSource> clips) {
        if (videoRes == null) {
            return;
        }
        ClipType clipType = ClipType.PHOTO;
        clips.add(new ClipSource(videoRes.getSourceId(), videoRes.getPath(), clipType, videoRes.getDuration(), null, null, null, null, null, null, null, videoRes.getByteArray(), null, BaseConstants.ERR_PACKET_FAIL_RESP_NO_RESEND, null));
    }

    private final void d(ClipSource mediaClip, C11478a segment) {
        ClipSource copy;
        copy = mediaClip.copy((r30 & 1) != 0 ? mediaClip.sourceId : null, (r30 & 2) != 0 ? mediaClip.path : null, (r30 & 4) != 0 ? mediaClip.type : null, (r30 & 8) != 0 ? mediaClip.duration : segment.getTimeRange().getDuration(), (r30 & 16) != 0 ? mediaClip.speed : null, (r30 & 32) != 0 ? mediaClip.volume : null, (r30 & 64) != 0 ? mediaClip.startOffset : null, (r30 & 128) != 0 ? mediaClip.matrix : null, (r30 & 256) != 0 ? mediaClip.photoEffectPath : null, (r30 & 512) != 0 ? mediaClip.transform : null, (r30 & 1024) != 0 ? mediaClip.clipRect : null, (r30 & 2048) != 0 ? mediaClip.byteArray : null, (r30 & 4096) != 0 ? mediaClip.autoLoop : null);
        segment.b().add(copy);
    }

    private final List<ClipSource> e(List<C11478a> lightSegments, float musicVolume) {
        ArrayList arrayList = new ArrayList();
        Iterator<C11478a> it = lightSegments.iterator();
        while (it.hasNext()) {
            a(it.next(), musicVolume, arrayList);
        }
        return arrayList;
    }

    private final boolean f(C11478a segment, List<ClipSource> remainClips, boolean mNeedCycleFill) {
        ClipSource remove;
        ClipSource copy;
        if (segment == null || remainClips.isEmpty()) {
            return false;
        }
        if (mNeedCycleFill) {
            remove = remainClips.remove(0);
            copy = remove.copy((r30 & 1) != 0 ? remove.sourceId : null, (r30 & 2) != 0 ? remove.path : null, (r30 & 4) != 0 ? remove.type : null, (r30 & 8) != 0 ? remove.duration : 0L, (r30 & 16) != 0 ? remove.speed : null, (r30 & 32) != 0 ? remove.volume : null, (r30 & 64) != 0 ? remove.startOffset : null, (r30 & 128) != 0 ? remove.matrix : null, (r30 & 256) != 0 ? remove.photoEffectPath : null, (r30 & 512) != 0 ? remove.transform : null, (r30 & 1024) != 0 ? remove.clipRect : null, (r30 & 2048) != 0 ? remove.byteArray : null, (r30 & 4096) != 0 ? remove.autoLoop : null);
            remainClips.add(copy);
        } else {
            remove = remainClips.remove(0);
        }
        ClipType type = remove.getType();
        if (type != null) {
            int i3 = wd4.b.f445493a[type.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    i(remove, segment, remainClips);
                }
            } else {
                d(remove, segment);
            }
        }
        return true;
    }

    private final void h(ClipSource videoRes, float musicVolume, List<ClipSource> clips) {
        if (videoRes == null) {
            return;
        }
        ClipType clipType = ClipType.VIDEO;
        clips.add(new ClipSource(videoRes.getSourceId(), videoRes.getPath(), clipType, videoRes.getDuration(), videoRes.getSpeed(), videoRes.getVolume(), videoRes.getStartOffset(), null, null, null, null, null, videoRes.getAutoLoop(), Utf8.MASK_2BYTES, null));
    }

    private final void i(ClipSource mediaClip, C11478a segment, List<ClipSource> remainClips) {
        long j3;
        ArrayList arrayList = new ArrayList();
        long duration = segment.getTimeRange().getDuration();
        ClipSource clipSource = mediaClip;
        while (duration > 0) {
            long duration2 = clipSource.getDuration();
            if (clipSource.getType() == ClipType.PHOTO) {
                clipSource = clipSource.copy((r30 & 1) != 0 ? clipSource.sourceId : null, (r30 & 2) != 0 ? clipSource.path : null, (r30 & 4) != 0 ? clipSource.type : null, (r30 & 8) != 0 ? clipSource.duration : duration, (r30 & 16) != 0 ? clipSource.speed : null, (r30 & 32) != 0 ? clipSource.volume : null, (r30 & 64) != 0 ? clipSource.startOffset : 0L, (r30 & 128) != 0 ? clipSource.matrix : null, (r30 & 256) != 0 ? clipSource.photoEffectPath : null, (r30 & 512) != 0 ? clipSource.transform : null, (r30 & 1024) != 0 ? clipSource.clipRect : null, (r30 & 2048) != 0 ? clipSource.byteArray : null, (r30 & 4096) != 0 ? clipSource.autoLoop : null);
                j3 = duration;
            } else {
                j3 = duration2;
            }
            ClipSource clipSource2 = clipSource;
            if (duration < j3) {
                clipSource2 = clipSource2.copy((r30 & 1) != 0 ? clipSource2.sourceId : null, (r30 & 2) != 0 ? clipSource2.path : null, (r30 & 4) != 0 ? clipSource2.type : null, (r30 & 8) != 0 ? clipSource2.duration : duration, (r30 & 16) != 0 ? clipSource2.speed : null, (r30 & 32) != 0 ? clipSource2.volume : null, (r30 & 64) != 0 ? clipSource2.startOffset : clipSource2.getStartOffset(), (r30 & 128) != 0 ? clipSource2.matrix : null, (r30 & 256) != 0 ? clipSource2.photoEffectPath : null, (r30 & 512) != 0 ? clipSource2.transform : null, (r30 & 1024) != 0 ? clipSource2.clipRect : null, (r30 & 2048) != 0 ? clipSource2.byteArray : null, (r30 & 4096) != 0 ? clipSource2.autoLoop : null);
            }
            arrayList.add(clipSource2);
            duration -= j3;
            if (duration > 0) {
                if (remainClips.size() == 0 || Intrinsics.areEqual(clipSource2.getAutoLoop(), Boolean.TRUE)) {
                    break;
                } else {
                    clipSource = remainClips.remove(0);
                }
            } else {
                clipSource = clipSource2;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((ClipSource) it.next());
        }
        segment.e(arrayList2);
    }

    private final boolean j(List<ClipSource> clips) {
        boolean z16;
        if (clips.isEmpty()) {
            return false;
        }
        List<ClipSource> list = clips;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ClipSource) it.next()).getType() == ClipType.PHOTO) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean k(List<ClipSource> movieClips) {
        boolean z16;
        if (movieClips.isEmpty()) {
            return false;
        }
        List<ClipSource> list = movieClips;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ClipSource) it.next()).getType() == ClipType.VIDEO) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean l(ClipPlaceHolder[] clipPlaceHolders, List<C11478a> segments) {
        Object lastOrNull;
        long j3;
        Object lastOrNull2;
        List<ClipSource> b16;
        if (segments.size() >= clipPlaceHolders.length) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) segments);
            C11478a c11478a = (C11478a) lastOrNull;
            long j16 = 0;
            if (c11478a != null && (b16 = c11478a.b()) != null) {
                Iterator<T> it = b16.iterator();
                j3 = 0;
                while (it.hasNext()) {
                    j3 += ((ClipSource) it.next()).getDuration();
                }
            } else {
                j3 = 0;
            }
            lastOrNull2 = ArraysKt___ArraysKt.lastOrNull(clipPlaceHolders);
            ClipPlaceHolder clipPlaceHolder = (ClipPlaceHolder) lastOrNull2;
            if (clipPlaceHolder != null) {
                j16 = clipPlaceHolder.contentDuration;
            }
            if (j3 < j16) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean m(List<ClipSource> clips) {
        return j(clips);
    }

    private final boolean o(List<ClipSource> clips) {
        if (clips == null || clips.size() != 1 || clips.get(0).getType() != ClipType.VIDEO) {
            return false;
        }
        return true;
    }

    private final List<C11478a> p(ClipPlaceHolder[] clipPlaceHolders) {
        List<C11478a> emptyList;
        boolean z16;
        if (clipPlaceHolders != null) {
            if (clipPlaceHolders.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ArrayList arrayList = new ArrayList();
                for (ClipPlaceHolder clipPlaceHolder : clipPlaceHolders) {
                    C11478a c11478a = new C11478a();
                    c11478a.d(new b(0L, clipPlaceHolder.contentDuration));
                    c11478a.c(clipPlaceHolder.contentDuration);
                    arrayList.add(c11478a);
                }
                return arrayList;
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    private final List<ClipSource> q(ClipSource clip, List<C11478a> mLightSegments) {
        ClipSource copy;
        long j3;
        ArrayList arrayList = new ArrayList();
        Iterator<C11478a> it = mLightSegments.iterator();
        ClipSource clipSource = clip;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C11478a next = it.next();
            if (next != null) {
                if (next.getTimeRange().getDuration() >= clipSource.getDuration()) {
                    arrayList.add(clipSource);
                    break;
                }
                ClipSource clipSource2 = clipSource;
                copy = clipSource.copy((r30 & 1) != 0 ? clipSource.sourceId : null, (r30 & 2) != 0 ? clipSource.path : null, (r30 & 4) != 0 ? clipSource.type : null, (r30 & 8) != 0 ? clipSource.duration : next.getTimeRange().getDuration(), (r30 & 16) != 0 ? clipSource.speed : null, (r30 & 32) != 0 ? clipSource.volume : null, (r30 & 64) != 0 ? clipSource.startOffset : clipSource.getStartOffset(), (r30 & 128) != 0 ? clipSource.matrix : null, (r30 & 256) != 0 ? clipSource.photoEffectPath : null, (r30 & 512) != 0 ? clipSource.transform : null, (r30 & 1024) != 0 ? clipSource.clipRect : null, (r30 & 2048) != 0 ? clipSource.byteArray : null, (r30 & 4096) != 0 ? clipSource.autoLoop : null);
                arrayList.add(copy);
                long duration = clipSource2.getDuration() - copy.getDuration();
                Long startOffset = copy.getStartOffset();
                if (startOffset != null) {
                    j3 = startOffset.longValue();
                } else {
                    j3 = 0;
                }
                clipSource = clipSource2.copy((r30 & 1) != 0 ? clipSource2.sourceId : null, (r30 & 2) != 0 ? clipSource2.path : null, (r30 & 4) != 0 ? clipSource2.type : null, (r30 & 8) != 0 ? clipSource2.duration : duration, (r30 & 16) != 0 ? clipSource2.speed : null, (r30 & 32) != 0 ? clipSource2.volume : null, (r30 & 64) != 0 ? clipSource2.startOffset : Long.valueOf(j3 + copy.getDuration()), (r30 & 128) != 0 ? clipSource2.matrix : null, (r30 & 256) != 0 ? clipSource2.photoEffectPath : null, (r30 & 512) != 0 ? clipSource2.transform : null, (r30 & 1024) != 0 ? clipSource2.clipRect : null, (r30 & 2048) != 0 ? clipSource2.byteArray : null, (r30 & 4096) != 0 ? clipSource2.autoLoop : null);
            }
        }
        return arrayList;
    }

    private final List<ClipSource> r(List<ClipSource> movieClips, List<C11478a> lightSegments, long duration) {
        int i3;
        long j3;
        ClipSource copy;
        long j16;
        ClipSource copy2;
        ArrayList<ClipSource> arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        long j17 = 0;
        if (duration <= 0) {
            return arrayList;
        }
        if (movieClips == null) {
            Intrinsics.throwNpe();
        }
        Iterator<ClipSource> it = movieClips.iterator();
        long j18 = 0;
        while (it.hasNext()) {
            ClipSource next = it.next();
            if (next != null && next.getDuration() != 0) {
                j18 += next.getDuration();
            } else {
                it.remove();
            }
        }
        if (j18 <= 0) {
            return arrayList;
        }
        for (ClipSource clipSource : movieClips) {
            long duration2 = clipSource.getDuration();
            long j19 = (duration2 * duration) / j18;
            if (duration2 >= j19) {
                duration2 = j19;
            }
            String path = clipSource.getPath();
            if (path == null) {
                path = "";
            }
            concurrentHashMap.put(path, Long.valueOf(duration2));
        }
        int size = lightSegments.size();
        int i16 = 0;
        int i17 = 0;
        while (i17 < size && !movieClips.isEmpty()) {
            long duration3 = lightSegments.get(i17).getTimeRange().getDuration();
            while (duration3 > j17 && (!movieClips.isEmpty())) {
                ClipSource remove = movieClips.remove(i16);
                long duration4 = remove.getDuration();
                long j26 = j17;
                for (ClipSource clipSource2 : arrayList) {
                    if (TextUtils.equals(clipSource2.getPath(), remove.getPath())) {
                        j26 += clipSource2.getDuration();
                    }
                }
                Object obj = concurrentHashMap.get(remove.getPath());
                if (obj == null) {
                    Intrinsics.throwNpe();
                }
                if (j26 <= ((Number) obj).longValue()) {
                    j17 = 0;
                    if (duration4 > 0) {
                        if (j26 != 0 && duration4 < duration3) {
                            j17 = 0;
                        } else {
                            if (duration4 > duration3) {
                                j3 = duration3;
                            } else {
                                j3 = duration4;
                            }
                            copy = remove.copy((r30 & 1) != 0 ? remove.sourceId : null, (r30 & 2) != 0 ? remove.path : null, (r30 & 4) != 0 ? remove.type : null, (r30 & 8) != 0 ? remove.duration : j3, (r30 & 16) != 0 ? remove.speed : null, (r30 & 32) != 0 ? remove.volume : null, (r30 & 64) != 0 ? remove.startOffset : null, (r30 & 128) != 0 ? remove.matrix : null, (r30 & 256) != 0 ? remove.photoEffectPath : null, (r30 & 512) != 0 ? remove.transform : null, (r30 & 1024) != 0 ? remove.clipRect : null, (r30 & 2048) != 0 ? remove.byteArray : null, (r30 & 4096) != 0 ? remove.autoLoop : null);
                            arrayList.add(copy);
                            long j27 = duration4 - duration3;
                            j17 = 0;
                            if (j27 > 0) {
                                Long startOffset = remove.getStartOffset();
                                if (startOffset != null) {
                                    j16 = startOffset.longValue();
                                } else {
                                    j16 = 0;
                                }
                                copy2 = remove.copy((r30 & 1) != 0 ? remove.sourceId : null, (r30 & 2) != 0 ? remove.path : null, (r30 & 4) != 0 ? remove.type : null, (r30 & 8) != 0 ? remove.duration : j27, (r30 & 16) != 0 ? remove.speed : null, (r30 & 32) != 0 ? remove.volume : null, (r30 & 64) != 0 ? remove.startOffset : Long.valueOf(j16 + duration3), (r30 & 128) != 0 ? remove.matrix : null, (r30 & 256) != 0 ? remove.photoEffectPath : null, (r30 & 512) != 0 ? remove.transform : null, (r30 & 1024) != 0 ? remove.clipRect : null, (r30 & 2048) != 0 ? remove.byteArray : null, (r30 & 4096) != 0 ? remove.autoLoop : null);
                                i3 = 0;
                                movieClips.add(0, copy2);
                            } else {
                                i3 = 0;
                            }
                            duration3 -= duration4;
                            i16 = i3;
                        }
                    }
                } else {
                    j17 = 0;
                }
                i3 = 0;
                i16 = i3;
            }
            i17++;
            i16 = i16;
        }
        return arrayList;
    }

    @Nullable
    public final LAKRenderModel g(@NotNull String templateJsonPath, @NotNull List<ClipSource> filledClipAssets, boolean modifyClipsDuration) {
        LightAsset lightAsset;
        MovieController assetForMovie;
        List<ClipSource> list;
        List<ClipSource> list2;
        int collectionSizeOrDefault;
        Object orNull;
        Object lastOrNull;
        Object lastOrNull2;
        Intrinsics.checkParameterIsNotNull(templateJsonPath, "templateJsonPath");
        Intrinsics.checkParameterIsNotNull(filledClipAssets, "filledClipAssets");
        if (TextUtils.isEmpty(templateJsonPath)) {
            return null;
        }
        try {
            lightAsset = LightAsset.Load(templateJsonPath, 0);
        } catch (IllegalStateException e16) {
            TavLogger.e("TemplateSegmentHelper", "parse renderModel json error: " + e16.getMessage());
            try {
                lightAsset = LightAsset.LoadFromString("/", c.f431135f.x(), 0);
            } catch (IllegalStateException e17) {
                TavLogger.e("TemplateSegmentHelper", "parse renderModel json error: " + e17.getMessage());
                lightAsset = null;
            }
        }
        if (lightAsset == null) {
            return null;
        }
        VideoOutputConfig videoOutputConfig = new VideoOutputConfig(30.0f, 0);
        AudioOutputConfig audioOutputConfig = new AudioOutputConfig();
        RendererConfig rendererConfig = new RendererConfig(RenderConfig.INSTANCE.getRenderAssetDir());
        LightSDKUtils lightSDKUtils = LightSDKUtils.INSTANCE;
        c cVar = c.f431135f;
        if (lightSDKUtils.authLightSdk(cVar.p(), cVar.s(), cVar.m(), cVar.l()) != 0) {
            TavLogger.d("TemplateSegmentHelper", "\u9274\u6743\u5931\u8d25");
            return null;
        }
        LightEngine make = LightEngine.make(videoOutputConfig, audioOutputConfig, rendererConfig);
        if (make == null || (assetForMovie = make.setAssetForMovie(lightAsset)) == null) {
            return null;
        }
        boolean n3 = n(assetForMovie.getClipPlaceHolders());
        List<C11478a> p16 = p(assetForMovie.getClipPlaceHolders());
        if (!n3) {
            list = b(filledClipAssets, p16, 0.0f, assetForMovie.duration());
        } else {
            list = filledClipAssets;
        }
        Object[] array = LightEntityTransHelper.transClipSourcesToClipAssets(list).toArray(new ClipAsset[0]);
        if (array != null) {
            ClipAsset[] clipAssetArr = (ClipAsset[]) array;
            TavLogger.d("TemplateSegmentHelper", "setClipAssets clipAssets size: " + clipAssetArr.length);
            assetForMovie.setClipAssets(clipAssetArr, "", modifyClipsDuration);
            long duration = assetForMovie.duration();
            if (!n3) {
                ClipPlaceHolder[] clipPlaceHolders = assetForMovie.getClipPlaceHolders();
                Intrinsics.checkExpressionValueIsNotNull(clipPlaceHolders, "movieController.clipPlaceHolders");
                if (!l(clipPlaceHolders, p16)) {
                    ClipInfo[][] clipInfos = assetForMovie.getClipInfos();
                    Intrinsics.checkExpressionValueIsNotNull(clipInfos, "movieController.clipInfos");
                    lastOrNull = ArraysKt___ArraysKt.lastOrNull(clipInfos);
                    ClipInfo[] clipInfoArr = (ClipInfo[]) lastOrNull;
                    if (clipInfoArr != null) {
                        lastOrNull2 = ArraysKt___ArraysKt.lastOrNull(clipInfoArr);
                        ClipInfo clipInfo = (ClipInfo) lastOrNull2;
                        if (clipInfo != null) {
                            TimeRange timeRange = clipInfo.targetTimeRange;
                            duration = timeRange.startTime + timeRange.duration;
                        }
                    }
                    duration = -1;
                }
            }
            long j3 = duration;
            if (n3) {
                List<ClipSource> list3 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                int i3 = 0;
                for (Object obj : list3) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    ClipSource clipSource = (ClipSource) obj;
                    ClipInfo[][] clipInfos2 = assetForMovie.getClipInfos();
                    if (clipInfos2 != null) {
                        orNull = ArraysKt___ArraysKt.getOrNull(clipInfos2, i3);
                        ClipInfo[] clipInfoArr2 = (ClipInfo[]) orNull;
                        if (clipInfoArr2 != null) {
                            long j16 = 0;
                            for (ClipInfo clipInfo2 : clipInfoArr2) {
                                j16 += clipInfo2.sourceTimeRange.duration;
                            }
                            clipSource = clipSource.copy((r30 & 1) != 0 ? clipSource.sourceId : null, (r30 & 2) != 0 ? clipSource.path : null, (r30 & 4) != 0 ? clipSource.type : null, (r30 & 8) != 0 ? clipSource.duration : j16, (r30 & 16) != 0 ? clipSource.speed : null, (r30 & 32) != 0 ? clipSource.volume : null, (r30 & 64) != 0 ? clipSource.startOffset : null, (r30 & 128) != 0 ? clipSource.matrix : null, (r30 & 256) != 0 ? clipSource.photoEffectPath : null, (r30 & 512) != 0 ? clipSource.transform : null, (r30 & 1024) != 0 ? clipSource.clipRect : null, (r30 & 2048) != 0 ? clipSource.byteArray : null, (r30 & 4096) != 0 ? clipSource.autoLoop : null);
                        }
                    }
                    arrayList.add(clipSource);
                    i3 = i16;
                }
                list2 = arrayList;
            } else {
                list2 = list;
            }
            assetForMovie.resetAsset();
            make.release();
            return new LAKRenderModel(null, null, null, null, null, list2, false, 0, null, null, null, j3, 0, null, null, false, null, null, 260063, null);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final boolean n(@Nullable ClipPlaceHolder[] clipHolders) {
        boolean z16;
        if (clipHolders != null) {
            if (clipHolders.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (ClipPlaceHolder clipPlaceHolder : clipHolders) {
                    if (clipPlaceHolder.contentDuration != 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
