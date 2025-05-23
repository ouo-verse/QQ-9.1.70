package v;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.v;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.io.IOException;

/* compiled from: P */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public abstract class j<T> implements com.bumptech.glide.load.f<ImageDecoder.Source, T> {

    /* renamed from: a, reason: collision with root package name */
    final v f440704a = v.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f440705a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f440706b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f440707c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DecodeFormat f440708d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DownsampleStrategy f440709e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PreferredColorSpace f440710f;

        /* compiled from: P */
        /* renamed from: v.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C11383a implements ImageDecoder.OnPartialImageListener {
            C11383a() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        a(int i3, int i16, boolean z16, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.f440705a = i3;
            this.f440706b = i16;
            this.f440707c = z16;
            this.f440708d = decodeFormat;
            this.f440709e = downsampleStrategy;
            this.f440710f = preferredColorSpace;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            Size size;
            ColorSpace.Named named;
            ColorSpace colorSpace;
            ColorSpace colorSpace2;
            ColorSpace colorSpace3;
            ColorSpace colorSpace4;
            boolean isWideGamut;
            boolean z16 = false;
            if (j.this.f440704a.e(this.f440705a, this.f440706b, this.f440707c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f440708d == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C11383a());
            size = imageInfo.getSize();
            int i3 = this.f440705a;
            if (i3 == Integer.MIN_VALUE) {
                i3 = size.getWidth();
            }
            int i16 = this.f440706b;
            if (i16 == Integer.MIN_VALUE) {
                i16 = size.getHeight();
            }
            float b16 = this.f440709e.b(size.getWidth(), size.getHeight(), i3, i16);
            int round = Math.round(size.getWidth() * b16);
            int round2 = Math.round(size.getHeight() * b16);
            if (Log.isLoggable("ImageDecoder", 2)) {
                Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + HippyTKDListViewAdapter.X + size.getHeight() + "] to [" + round + HippyTKDListViewAdapter.X + round2 + "] scaleFactor: " + b16);
            }
            imageDecoder.setTargetSize(round, round2);
            int i17 = Build.VERSION.SDK_INT;
            if (i17 >= 28) {
                if (this.f440710f == PreferredColorSpace.DISPLAY_P3) {
                    colorSpace3 = imageInfo.getColorSpace();
                    if (colorSpace3 != null) {
                        colorSpace4 = imageInfo.getColorSpace();
                        isWideGamut = colorSpace4.isWideGamut();
                        if (isWideGamut) {
                            z16 = true;
                        }
                    }
                }
                colorSpace2 = ColorSpace.get(z16 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
                imageDecoder.setTargetColorSpace(colorSpace2);
                return;
            }
            if (i17 >= 26) {
                named = ColorSpace.Named.SRGB;
                colorSpace = ColorSpace.get(named);
                imageDecoder.setTargetColorSpace(colorSpace);
            }
        }
    }

    protected abstract q<T> c(ImageDecoder.Source source, int i3, int i16, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.f
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final q<T> b(@NonNull ImageDecoder.Source source, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        boolean z16;
        DecodeFormat decodeFormat = (DecodeFormat) eVar.c(com.bumptech.glide.load.resource.bitmap.q.f31835f);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.c(DownsampleStrategy.f31791h);
        com.bumptech.glide.load.d<Boolean> dVar = com.bumptech.glide.load.resource.bitmap.q.f31839j;
        if (eVar.c(dVar) != null && ((Boolean) eVar.c(dVar)).booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        return c(source, i3, i16, new a(i3, i16, z16, decodeFormat, downsampleStrategy, (PreferredColorSpace) eVar.c(com.bumptech.glide.load.resource.bitmap.q.f31836g)));
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final boolean a(@NonNull ImageDecoder.Source source, @NonNull com.bumptech.glide.load.e eVar) {
        return true;
    }
}
