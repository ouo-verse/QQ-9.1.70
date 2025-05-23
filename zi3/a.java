package zi3;

import android.content.Context;
import android.util.AttributeSet;
import b94.e;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import vb3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lzi3/a;", "Lvb3/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "", "onlyBrandMallMode", "Lb94/e;", "Z", "", "doWhenQQLogout", "j0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a extends b {
    e Z(Context context, AttributeSet attrs, int defStyleAttr, boolean onlyBrandMallMode);

    void doWhenQQLogout();

    void j0();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: zi3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11684a {
        public static /* synthetic */ e a(a aVar, Context context, AttributeSet attributeSet, int i3, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    attributeSet = null;
                }
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                if ((i16 & 8) != 0) {
                    z16 = false;
                }
                return aVar.Z(context, attributeSet, i3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildPanelView");
        }
    }
}
