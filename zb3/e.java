package zb3;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaMapItemView;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lzb3/e;", "", "Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView;", "a", "Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView;", "b", "()Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView;", "itemView", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "()Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "info", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "c", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "getButtonStatus", "()Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "setButtonStatus", "(Lcom/tencent/sqshow/zootopia/data/ButtonStatus;)V", "buttonStatus", "", "d", "Ljava/lang/Float;", HippyQQPagView.FunctionName.GET_PROGRESS, "()Ljava/lang/Float;", HippyQQPagView.FunctionName.SET_PROGRESS, "(Ljava/lang/Float;)V", "progress", "<init>", "(Lcom/tencent/mobileqq/zootopia/portal/home/view/ZootopiaMapItemView;Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;Lcom/tencent/sqshow/zootopia/data/ButtonStatus;Ljava/lang/Float;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaMapItemView itemView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaMapSimpleInfo info;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ButtonStatus buttonStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Float progress;

    public e(ZootopiaMapItemView itemView, ZootopiaMapSimpleInfo info, ButtonStatus buttonStatus, Float f16) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(info, "info");
        this.itemView = itemView;
        this.info = info;
        this.buttonStatus = buttonStatus;
        this.progress = f16;
    }

    /* renamed from: a, reason: from getter */
    public final ZootopiaMapSimpleInfo getInfo() {
        return this.info;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaMapItemView getItemView() {
        return this.itemView;
    }
}
