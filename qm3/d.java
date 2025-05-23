package qm3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.app.common.widget.BaseViewPager;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.mainpage.model.LinkPKTabData;
import com.tencent.now.linkpkanchorplay.mainpage.view.LinkAndPkInvitePage;
import com.tencent.now.linkpkanchorplay.mainpage.view.LinkPage;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00011B=\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020 \u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020+\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u001c\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lqm3/d;", "Landroidx/viewpager/widget/PagerAdapter;", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData;", "tabInfo", "Landroid/view/View;", "d", "", "getCount", "view", "", "object", "", "isViewFromObject", "position", "", "getPageTitle", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "instantiateItem", "Lcom/tencent/now/app/common/widget/BaseViewPager;", "viewPager", "", "tabsInfo", "", "f", "e", "Lcom/tencent/now/linkpkanchorplay/event/b;", "Lcom/tencent/now/linkpkanchorplay/event/b;", "eventTrigger", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "Landroidx/lifecycle/ViewModelProvider;", tl.h.F, "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "Landroidx/lifecycle/LifecycleOwner;", "i", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "<init>", "(Lcom/tencent/now/linkpkanchorplay/event/b;Landroid/content/Context;Lcom/tencent/now/linkpkanchorplay/invite/model/a;Landroidx/lifecycle/ViewModelProvider;Landroidx/lifecycle/LifecycleOwner;Ljava/util/List;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d extends PagerAdapter {

    @NotNull
    private static Map<LinkPKTabData.TabId, View> D = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.now.linkpkanchorplay.event.b eventTrigger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorTabPageContext pageContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelProvider viewModelProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<LinkPKTabData> tabsInfo;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429080a;

        static {
            int[] iArr = new int[LinkPKTabData.TabId.values().length];
            try {
                iArr[LinkPKTabData.TabId.PK_TAB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LinkPKTabData.TabId.LINK_TAB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f429080a = iArr;
        }
    }

    public d(@NotNull com.tencent.now.linkpkanchorplay.event.b eventTrigger, @NotNull Context context, @NotNull AnchorTabPageContext pageContext, @NotNull ViewModelProvider viewModelProvider, @NotNull LifecycleOwner lifecycleOwner, @NotNull List<LinkPKTabData> tabsInfo) {
        Intrinsics.checkNotNullParameter(eventTrigger, "eventTrigger");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(tabsInfo, "tabsInfo");
        this.eventTrigger = eventTrigger;
        this.context = context;
        this.pageContext = pageContext;
        this.viewModelProvider = viewModelProvider;
        this.lifecycleOwner = lifecycleOwner;
        this.tabsInfo = tabsInfo;
    }

    private final View d(LinkPKTabData tabInfo) {
        int i3 = b.f429080a[tabInfo.getTabID().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return new LinkPage(this.eventTrigger, this.context, this.lifecycleOwner, this.pageContext, new com.tencent.now.linkpkanchorplay.mainpage.model.a());
            }
            throw new NoWhenBranchMatchedException();
        }
        return new LinkAndPkInvitePage(this.eventTrigger, this.context, this.lifecycleOwner, this.pageContext, new com.tencent.now.linkpkanchorplay.mainpage.model.a());
    }

    @NotNull
    public final List<LinkPKTabData> e() {
        return this.tabsInfo;
    }

    public final void f(@NotNull BaseViewPager viewPager, @NotNull List<LinkPKTabData> tabsInfo) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(tabsInfo, "tabsInfo");
        this.tabsInfo.clear();
        this.tabsInfo.addAll(tabsInfo);
        int size = tabsInfo.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (tabsInfo.get(i3).getSelected()) {
                viewPager.setCurrentItem(i3);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.tabsInfo.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int position) {
        return this.tabsInfo.get(position).getTabTitle();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        View d16 = d(this.tabsInfo.get(position));
        container.addView(d16);
        return d16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }
}
