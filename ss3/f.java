package ss3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qq.minibox.ui.view.indicator.CircleIndicator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import us3.q;
import us3.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0003?\u001b!B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0007J\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R(\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u00103\u001a\u000600R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lss3/f;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "A0", "Landroid/os/Message;", "msg", "t0", "z0", "r0", "", "coverUrl", "q0", "y0", "", CoverDBCacheData.URLS, "x0", "s0", "", "state", "onPageScrollStateChanged", "position", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroidx/viewpager2/widget/ViewPager2;", "c", "Landroidx/viewpager2/widget/ViewPager2;", "coverViewPager", "Lcom/tencent/qq/minibox/ui/view/indicator/CircleIndicator;", "d", "Lcom/tencent/qq/minibox/ui/view/indicator/CircleIndicator;", "indicator", "", "e", "Ljava/util/List;", "u0", "()Ljava/util/List;", "setCoverUrlList", "(Ljava/util/List;)V", "coverUrlList", "Lss3/f$c;", "f", "Lss3/f$c;", "coverApapter", "", "g", "Z", "isGuide", "Landroid/os/Handler;", h.F, "Landroid/os/Handler;", "mHandle", "<init>", "(Landroid/content/Context;Landroidx/viewpager2/widget/ViewPager2;Lcom/tencent/qq/minibox/ui/view/indicator/CircleIndicator;)V", "i", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f extends ViewPager2.OnPageChangeCallback {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPager2 coverViewPager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CircleIndicator indicator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> coverUrlList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c coverApapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isGuide;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lss3/f$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "url", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            View view = this.itemView;
            if (view instanceof ImageView) {
                r rVar = r.f440004a;
                Context context = view.getContext();
                View view2 = this.itemView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.ImageView");
                rVar.d(context, (ImageView) view2, url);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"Lss3/f$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "<init>", "(Lss3/f;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return f.this.u0().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            String str = f.this.u0().get(position);
            if (holder instanceof b) {
                ((b) holder).l(str);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ImageView imageView = new ImageView(parent.getContext());
            ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "parent.layoutParams");
            layoutParams.width = -1;
            layoutParams.height = -1;
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return new b(imageView);
        }
    }

    public f(@NotNull Context context, @NotNull ViewPager2 coverViewPager, @NotNull CircleIndicator indicator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coverViewPager, "coverViewPager");
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        this.context = context;
        this.coverViewPager = coverViewPager;
        this.indicator = indicator;
        this.coverUrlList = new ArrayList();
        c cVar = new c();
        this.coverApapter = cVar;
        this.mHandle = new Handler(new Handler.Callback() { // from class: ss3.e
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean v06;
                v06 = f.v0(f.this, message);
                return v06;
            }
        });
        coverViewPager.setAdapter(cVar);
        coverViewPager.setOrientation(0);
        coverViewPager.setOffscreenPageLimit(2);
        coverViewPager.registerOnPageChangeCallback(this);
        A0();
        z0();
    }

    private final void A0() {
        int i3;
        CircleIndicator circleIndicator = this.indicator;
        RecyclerView.Adapter adapter = this.coverViewPager.getAdapter();
        if (adapter != null) {
            i3 = adapter.getNUM_BACKGOURND_ICON();
        } else {
            i3 = 0;
        }
        circleIndicator.c(i3, this.coverViewPager.getCurrentItem());
        z0();
    }

    private final void t0(Message msg2) {
        int i3;
        if (msg2.what == 1) {
            int currentItem = this.coverViewPager.getCurrentItem();
            RecyclerView.Adapter adapter = this.coverViewPager.getAdapter();
            if (adapter != null) {
                i3 = adapter.getNUM_BACKGOURND_ICON();
            } else {
                i3 = 0;
            }
            if (currentItem == i3 - 1) {
                this.coverViewPager.setCurrentItem(0);
            } else {
                ViewPager2 viewPager2 = this.coverViewPager;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
            this.mHandle.sendEmptyMessageDelayed(1, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v0(f this$0, Message it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.t0(it);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0() {
        q.f440003a.q(true);
    }

    private final void z0() {
        this.mHandle.removeMessages(1);
        this.mHandle.sendEmptyMessageDelayed(1, 5000L);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int state) {
        super.onPageScrollStateChanged(state);
        this.indicator.d(state);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        this.indicator.e(position, positionOffset, positionOffsetPixels);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        this.indicator.f(position);
        z0();
        if (this.isGuide && position == this.coverUrlList.size() - 1 && !q.f440003a.e()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ss3.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.w0();
                }
            });
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void q0(@NotNull String coverUrl) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        if (HttpUtil.isValidUrl(coverUrl)) {
            this.coverUrlList.add(coverUrl);
            this.coverApapter.notifyDataSetChanged();
            A0();
        }
    }

    public final void r0() {
        this.coverUrlList.clear();
    }

    public final void s0() {
        this.mHandle.removeMessages(1);
        this.coverViewPager.unregisterOnPageChangeCallback(this);
    }

    @NotNull
    public final List<String> u0() {
        return this.coverUrlList;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void x0(@NotNull List<String> urls) {
        List<String> mutableList;
        Intrinsics.checkNotNullParameter(urls, "urls");
        List<String> list = urls;
        if (!list.isEmpty()) {
            this.coverUrlList.clear();
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            this.coverUrlList = mutableList;
            this.coverApapter.notifyDataSetChanged();
            A0();
        }
    }

    public final void y0() {
        this.isGuide = true;
        r0();
        x0(fs3.b.INSTANCE.a());
    }
}
