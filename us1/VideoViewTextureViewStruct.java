package us1;

import android.view.Surface;
import android.view.TextureView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lus1/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/TextureView;", "a", "Landroid/view/TextureView;", "c", "()Landroid/view/TextureView;", "textureView", "Landroid/view/Surface;", "b", "Landroid/view/Surface;", "()Landroid/view/Surface;", "e", "(Landroid/view/Surface;)V", "surface", "Z", "()Z", "d", "(Z)V", "needShowVideo", "<init>", "(Landroid/view/TextureView;Landroid/view/Surface;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: us1.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class VideoViewTextureViewStruct {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TextureView textureView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Surface surface;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needShowVideo;

    public VideoViewTextureViewStruct(@NotNull TextureView textureView, @Nullable Surface surface, boolean z16) {
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        this.textureView = textureView;
        this.surface = surface;
        this.needShowVideo = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getNeedShowVideo() {
        return this.needShowVideo;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Surface getSurface() {
        return this.surface;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final TextureView getTextureView() {
        return this.textureView;
    }

    public final void d(boolean z16) {
        this.needShowVideo = z16;
    }

    public final void e(@Nullable Surface surface) {
        this.surface = surface;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoViewTextureViewStruct)) {
            return false;
        }
        VideoViewTextureViewStruct videoViewTextureViewStruct = (VideoViewTextureViewStruct) other;
        if (Intrinsics.areEqual(this.textureView, videoViewTextureViewStruct.textureView) && Intrinsics.areEqual(this.surface, videoViewTextureViewStruct.surface) && this.needShowVideo == videoViewTextureViewStruct.needShowVideo) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.textureView.hashCode() * 31;
        Surface surface = this.surface;
        if (surface == null) {
            hashCode = 0;
        } else {
            hashCode = surface.hashCode();
        }
        int i3 = (hashCode2 + hashCode) * 31;
        boolean z16 = this.needShowVideo;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "VideoViewTextureViewStruct(textureView=" + this.textureView + ", surface=" + this.surface + ", needShowVideo=" + this.needShowVideo + ")";
    }
}
