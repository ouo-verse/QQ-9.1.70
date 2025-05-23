package ye3;

import android.app.Activity;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import vb3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J,\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH&\u00a8\u0006\u000e"}, d2 = {"Lye3/a;", "Lvb3/b;", "Lye3/a$b;", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "width", "height", "", "bSync", "", "o0", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a extends b {
    Size n();

    void o0(Activity activity, int width, int height, boolean bSync);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lye3/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "width", "height", "<init>", "(II)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ye3.a$b, reason: from toString */
    /* loaded from: classes36.dex */
    public static final /* data */ class Size {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int width;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        public Size(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: b, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (this.width * 31) + this.height;
        }

        public String toString() {
            return "Size(width=" + this.width + ", height=" + this.height + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Size)) {
                return false;
            }
            Size size = (Size) other;
            return this.width == size.width && this.height == size.height;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: ye3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11609a {
        public static /* synthetic */ void a(a aVar, Activity activity, int i3, int i16, boolean z16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 8) != 0) {
                    z16 = false;
                }
                aVar.o0(activity, i3, i16, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBackBufferSize");
        }
    }
}
