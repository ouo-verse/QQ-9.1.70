package r63;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.wink.editor.merger.MergeException;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.DecoderUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\u0005\u0014B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J2\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010#R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010%R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010%R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010(R\u001c\u0010-\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010,\u00a8\u00060"}, d2 = {"Lr63/f;", "", "Lr63/d;", TtmlNode.TAG_METADATA, "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "a", "", "totalDurationMs", "Lr63/a;", "callback", "", "i", "Landroid/media/MediaExtractor;", "extractor", "writeTrack", "", "j", "", "path", "f", "b", "Lr63/c;", "metaVideo", "g", h.F, "d", "e", "c", "", "Z", "canceled", "Landroid/media/MediaMuxer;", "Landroid/media/MediaMuxer;", "muxer", "Lr63/f$b;", "Lr63/f$b;", "sliceExtractorInfo", "I", "outputVideoTrack", "outputAudioTrack", "J", "slicePtsOffsetUs", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "Ljava/nio/ByteBuffer;", "byteBuffer", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean canceled;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MediaMuxer muxer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SliceExtractorInfo sliceExtractorInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long slicePtsOffsetUs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int outputVideoTrack = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int outputAudioTrack = -1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ByteBuffer byteBuffer = ByteBuffer.allocate(2073600);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u001bR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b\u00a8\u0006!"}, d2 = {"Lr63/f$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/media/MediaExtractor;", "a", "Landroid/media/MediaExtractor;", "c", "()Landroid/media/MediaExtractor;", "videoExtractor", "b", "audioExtractor", "I", "getVideoTrack", "()I", "videoTrack", "d", "getAudioTrack", "audioTrack", "Landroid/media/MediaFormat;", "e", "Landroid/media/MediaFormat;", "()Landroid/media/MediaFormat;", "videoFormat", "f", "audioFormat", "<init>", "(Landroid/media/MediaExtractor;Landroid/media/MediaExtractor;IILandroid/media/MediaFormat;Landroid/media/MediaFormat;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: r63.f$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class SliceExtractorInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MediaExtractor videoExtractor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MediaExtractor audioExtractor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int videoTrack;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int audioTrack;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final MediaFormat videoFormat;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final MediaFormat audioFormat;

        public SliceExtractorInfo(@NotNull MediaExtractor videoExtractor, @NotNull MediaExtractor audioExtractor, int i3, int i16, @Nullable MediaFormat mediaFormat, @Nullable MediaFormat mediaFormat2) {
            Intrinsics.checkNotNullParameter(videoExtractor, "videoExtractor");
            Intrinsics.checkNotNullParameter(audioExtractor, "audioExtractor");
            this.videoExtractor = videoExtractor;
            this.audioExtractor = audioExtractor;
            this.videoTrack = i3;
            this.audioTrack = i16;
            this.videoFormat = mediaFormat;
            this.audioFormat = mediaFormat2;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MediaExtractor getAudioExtractor() {
            return this.audioExtractor;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final MediaFormat getAudioFormat() {
            return this.audioFormat;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final MediaExtractor getVideoExtractor() {
            return this.videoExtractor;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final MediaFormat getVideoFormat() {
            return this.videoFormat;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SliceExtractorInfo)) {
                return false;
            }
            SliceExtractorInfo sliceExtractorInfo = (SliceExtractorInfo) other;
            if (Intrinsics.areEqual(this.videoExtractor, sliceExtractorInfo.videoExtractor) && Intrinsics.areEqual(this.audioExtractor, sliceExtractorInfo.audioExtractor) && this.videoTrack == sliceExtractorInfo.videoTrack && this.audioTrack == sliceExtractorInfo.audioTrack && Intrinsics.areEqual(this.videoFormat, sliceExtractorInfo.videoFormat) && Intrinsics.areEqual(this.audioFormat, sliceExtractorInfo.audioFormat)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((this.videoExtractor.hashCode() * 31) + this.audioExtractor.hashCode()) * 31) + this.videoTrack) * 31) + this.audioTrack) * 31;
            MediaFormat mediaFormat = this.videoFormat;
            int i3 = 0;
            if (mediaFormat == null) {
                hashCode = 0;
            } else {
                hashCode = mediaFormat.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            MediaFormat mediaFormat2 = this.audioFormat;
            if (mediaFormat2 != null) {
                i3 = mediaFormat2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "SliceExtractorInfo(videoExtractor=" + this.videoExtractor + ", audioExtractor=" + this.audioExtractor + ", videoTrack=" + this.videoTrack + ", audioTrack=" + this.audioTrack + ", videoFormat=" + this.videoFormat + ", audioFormat=" + this.audioFormat + ")";
        }
    }

    private final ExportErrorCode a(Metadata metadata) {
        boolean isBlank;
        boolean z16;
        Object first;
        ExportErrorCode exportErrorCode = new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_MERGE_INVALID_METADATA, null, 2, null);
        isBlank = StringsKt__StringsJVMKt.isBlank(metadata.getOutputPath());
        if (!isBlank) {
            List<MetaVideo> a16 = metadata.a();
            if (a16 != null && !a16.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) metadata.a());
                MetaVideo metaVideo = (MetaVideo) first;
                Iterator<MetaVideo> it = metadata.a().iterator();
                while (it.hasNext()) {
                    if (!e.b(metaVideo, it.next())) {
                        QLog.i("WinkVideoMerger", 1, "[checkData] invalid parameters, " + metadata);
                        return exportErrorCode;
                    }
                }
                if (e.a(metaVideo).getHasBFrame() && Build.VERSION.SDK_INT < 24) {
                    QLog.i("WinkVideoMerger", 1, "[checkData] not support B frame");
                    return exportErrorCode;
                }
                return new ExportErrorCode(0L, null, 2, null);
            }
        }
        QLog.i("WinkVideoMerger", 1, "[checkData] no metaVideos");
        return exportErrorCode;
    }

    private final void b() {
        if (!this.canceled) {
        } else {
            throw new MergeException(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_MERGE_CANCEL, null, 2, null));
        }
    }

    private final void d() {
        try {
            MediaMuxer mediaMuxer = this.muxer;
            if (mediaMuxer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muxer");
                mediaMuxer = null;
            }
            mediaMuxer.release();
        } catch (Exception e16) {
            QLog.w("WinkVideoMerger", 1, "[release] ", e16);
        }
    }

    private final void e() {
        MediaExtractor audioExtractor;
        MediaExtractor videoExtractor;
        try {
            SliceExtractorInfo sliceExtractorInfo = this.sliceExtractorInfo;
            if (sliceExtractorInfo != null && (videoExtractor = sliceExtractorInfo.getVideoExtractor()) != null) {
                videoExtractor.release();
            }
        } catch (Exception e16) {
            QLog.w("WinkVideoMerger", 1, "[release] ", e16);
        }
        try {
            SliceExtractorInfo sliceExtractorInfo2 = this.sliceExtractorInfo;
            if (sliceExtractorInfo2 != null && (audioExtractor = sliceExtractorInfo2.getAudioExtractor()) != null) {
                audioExtractor.release();
            }
        } catch (Exception e17) {
            QLog.w("WinkVideoMerger", 1, "[release] ", e17);
        }
    }

    private final void f(String path) {
        MediaFormat trackFormat;
        try {
            e();
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(path);
            MediaExtractor mediaExtractor2 = new MediaExtractor();
            mediaExtractor2.setDataSource(path);
            int selectTrack = DecoderUtils.selectTrack(mediaExtractor, "video/");
            if (selectTrack >= 0) {
                mediaExtractor.selectTrack(selectTrack);
                MediaFormat trackFormat2 = mediaExtractor.getTrackFormat(selectTrack);
                Intrinsics.checkNotNullExpressionValue(trackFormat2, "sliceVideoExtractor.getT\u2026ckFormat(sliceVideoTrack)");
                int selectTrack2 = DecoderUtils.selectTrack(mediaExtractor2, "audio/");
                if (selectTrack2 < 0) {
                    QLog.w("WinkVideoMerger", 1, "[setupExtractor] no audio track found, " + selectTrack2);
                    trackFormat = null;
                } else {
                    mediaExtractor2.selectTrack(selectTrack2);
                    trackFormat = mediaExtractor2.getTrackFormat(selectTrack2);
                }
                this.sliceExtractorInfo = new SliceExtractorInfo(mediaExtractor, mediaExtractor2, selectTrack, selectTrack2, trackFormat2, trackFormat);
                QLog.i("WinkVideoMerger", 1, "[setupSliceExtractor] path=" + path + ", videoTrack=" + selectTrack + ", audioTrack=" + selectTrack2);
                return;
            }
            QLog.w("WinkVideoMerger", 1, "[setupExtractor] invalid video track, " + selectTrack);
            throw new MergeException(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_MERGE_SETUP_EXTRACTOR, null, 2, null));
        } catch (Exception e16) {
            QLog.w("WinkVideoMerger", 1, "[setupExtractor] ", e16);
            throw new MergeException(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_MERGE_SETUP_EXTRACTOR, null, 2, null));
        }
    }

    private final void g(MetaVideo metaVideo) {
        try {
            SliceExtractorInfo sliceExtractorInfo = this.sliceExtractorInfo;
            Intrinsics.checkNotNull(sliceExtractorInfo);
            MediaMuxer mediaMuxer = this.muxer;
            MediaMuxer mediaMuxer2 = null;
            if (mediaMuxer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muxer");
                mediaMuxer = null;
            }
            MediaFormat videoFormat = sliceExtractorInfo.getVideoFormat();
            Intrinsics.checkNotNull(videoFormat);
            this.outputVideoTrack = mediaMuxer.addTrack(videoFormat);
            if (sliceExtractorInfo.getAudioFormat() != null) {
                MediaMuxer mediaMuxer3 = this.muxer;
                if (mediaMuxer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("muxer");
                    mediaMuxer3 = null;
                }
                this.outputAudioTrack = mediaMuxer3.addTrack(sliceExtractorInfo.getAudioFormat());
            }
            QLog.i("WinkVideoMerger", 1, "[startMuxer] rotation=" + metaVideo.getRotation());
            MediaMuxer mediaMuxer4 = this.muxer;
            if (mediaMuxer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muxer");
                mediaMuxer4 = null;
            }
            mediaMuxer4.setOrientationHint(metaVideo.getRotation());
            MediaMuxer mediaMuxer5 = this.muxer;
            if (mediaMuxer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muxer");
            } else {
                mediaMuxer2 = mediaMuxer5;
            }
            mediaMuxer2.start();
        } catch (Exception e16) {
            QLog.w("WinkVideoMerger", 1, "[startMuxer] ", e16);
            throw new MergeException(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_MERGE_START_MUXER, null, 2, null));
        }
    }

    private final void h() {
        try {
            MediaMuxer mediaMuxer = this.muxer;
            if (mediaMuxer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muxer");
                mediaMuxer = null;
            }
            mediaMuxer.stop();
        } catch (Exception e16) {
            QLog.w("WinkVideoMerger", 1, "[release] ", e16);
        }
    }

    private final void i(Metadata metadata, int totalDurationMs, a callback) {
        boolean z16;
        long j3;
        long coerceAtLeast;
        SliceExtractorInfo sliceExtractorInfo = this.sliceExtractorInfo;
        Intrinsics.checkNotNull(sliceExtractorInfo);
        boolean z17 = false;
        if (sliceExtractorInfo.getVideoFormat() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        SliceExtractorInfo sliceExtractorInfo2 = this.sliceExtractorInfo;
        Intrinsics.checkNotNull(sliceExtractorInfo2);
        if (sliceExtractorInfo2.getAudioFormat() != null) {
            z17 = true;
        }
        if (z16) {
            SliceExtractorInfo sliceExtractorInfo3 = this.sliceExtractorInfo;
            Intrinsics.checkNotNull(sliceExtractorInfo3);
            long j16 = j(sliceExtractorInfo3.getVideoExtractor(), this.outputVideoTrack, totalDurationMs, callback, metadata);
            if (z17) {
                SliceExtractorInfo sliceExtractorInfo4 = this.sliceExtractorInfo;
                Intrinsics.checkNotNull(sliceExtractorInfo4);
                j3 = j(sliceExtractorInfo4.getAudioExtractor(), this.outputAudioTrack, totalDurationMs, null, metadata);
            } else {
                j3 = 0;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j16, j3);
            this.slicePtsOffsetUs = coerceAtLeast;
            QLog.i("WinkVideoMerger", 1, "[writeMuxer] slicePtsOffsetUs=" + coerceAtLeast);
            return;
        }
        throw new MergeException(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_MERGE_NO_TRACK_FORMAT_DATA, null, 2, null));
    }

    private final long j(MediaExtractor extractor, int writeTrack, int totalDurationMs, a callback, Metadata metadata) {
        long j3 = 0;
        boolean z16 = false;
        while (!z16) {
            this.byteBuffer.clear();
            int readSampleData = extractor.readSampleData(this.byteBuffer, 0);
            if (readSampleData < 0) {
                z16 = true;
            } else {
                j3 = extractor.getSampleTime() + this.slicePtsOffsetUs;
                if (callback != null) {
                    callback.c(metadata, ((j3 * 1.0d) / 1000) / totalDurationMs);
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                bufferInfo.offset = 0;
                bufferInfo.size = readSampleData;
                bufferInfo.presentationTimeUs = j3;
                if ((extractor.getSampleFlags() & 1) != 0) {
                    bufferInfo.flags = 1;
                }
                this.byteBuffer.rewind();
                MediaMuxer mediaMuxer = this.muxer;
                if (mediaMuxer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("muxer");
                    mediaMuxer = null;
                }
                mediaMuxer.writeSampleData(writeTrack, this.byteBuffer, bufferInfo);
                extractor.advance();
            }
        }
        return j3;
    }

    @WorkerThread
    public final void c(@NotNull Metadata metadata, @Nullable a callback) {
        int collectionSizeOrDefault;
        int sumOfInt;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        ExportErrorCode a16 = a(metadata);
        if (!a16.isOK()) {
            if (callback != null) {
                callback.a(metadata, a16);
                return;
            }
            return;
        }
        try {
            try {
                List<MetaVideo> a17 = metadata.a();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a17, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = a17.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((MetaVideo) it.next()).getDurationMs()));
                }
                sumOfInt = CollectionsKt___CollectionsKt.sumOfInt(arrayList);
                QLog.i("WinkVideoMerger", 1, "[merge] outputPath=" + metadata.getOutputPath() + ", totalDurationMs=" + sumOfInt);
                int i3 = 0;
                this.muxer = new MediaMuxer(metadata.getOutputPath(), 0);
                this.slicePtsOffsetUs = 0L;
                for (Object obj : metadata.a()) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    MetaVideo metaVideo = (MetaVideo) obj;
                    b();
                    f(metaVideo.getPath());
                    if (i3 == 0) {
                        g(metaVideo);
                    }
                    i(metadata, sumOfInt, callback);
                    i3 = i16;
                }
                if (callback != null) {
                    callback.b(metadata);
                }
            } catch (MergeException e16) {
                QLog.w("WinkVideoMerger", 1, "[merge] ", e16);
                if (callback != null) {
                    callback.a(metadata, e16.getWinkErrorCode());
                }
            } catch (Exception e17) {
                QLog.w("WinkVideoMerger", 1, "[merge] ", e17);
                if (callback != null) {
                    callback.a(metadata, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_MERGE_FAILED_UNKNOWN, e17.getMessage()));
                }
            }
        } finally {
            e();
            h();
            d();
        }
    }
}
