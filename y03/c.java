package y03;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.font.IFontManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0015\u001a\u00020\u0002H&J\u001c\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0017H&J!\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH&\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH&J\u001c\u0010\"\u001a\u00020\b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0 H&\u00a8\u0006#"}, d2 = {"Ly03/c;", "", "", "t", "", DomainData.DOMAIN_NAME, "Landroid/graphics/Rect;", "padding", "", "j", "", "widthMeasureSpec", "heightMeasureSpec", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/tencent/mobileqq/vas/font/IFontManager$b;", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "o", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", HippyTKDListViewAdapter.X, "y", "b", "(II)Ljava/lang/Integer;", "Ly03/a;", "info", "f", "Lkotlin/Function1;", "block", "setLoadedListener", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Ly03/c$a;", "", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
    }

    @Nullable
    ArrayList<Rect> a();

    @Nullable
    Integer b(int x16, int y16);

    @NotNull
    IFontManager.DrawableResultInfo e(@NotNull Canvas canvas);

    void f(@NotNull AIOTextViewInfo info);

    void g();

    void j(@NotNull Rect padding);

    void m();

    @NotNull
    String n();

    boolean o();

    @Nullable
    int[] q(int widthMeasureSpec, int heightMeasureSpec);

    void setLoadedListener(@NotNull Function1<? super c, Unit> block);

    boolean t();
}
