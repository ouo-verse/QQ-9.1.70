package x82;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.biz.richframework.preload.recyclerview.RFWCountLoadMoreStrategy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R+\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lx82/b;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "position", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "", "onBindViewHolder", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Lx82/b$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lx82/b$a;", "viewHolder", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/properties/ReadWriteProperty;", "i0", "()Z", "j0", "(Z)V", "show", "<init>", "()V", "a", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends RFWAbsLoadMoreAdapter {
    static final /* synthetic */ KProperty<Object>[] D = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "show", "getShow()Z", 0))};

    /* renamed from: C, reason: from kotlin metadata */
    private final ReadWriteProperty show;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private a viewHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lx82/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "textView", "Landroid/view/View;", "G", "Landroid/view/View;", "l", "()Landroid/view/View;", "contentView", "Landroid/graphics/drawable/Drawable;", "H", "Landroid/graphics/drawable/Drawable;", "o", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView imageView;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView textView;

        /* renamed from: G, reason: from kotlin metadata */
        private final View contentView;

        /* renamed from: H, reason: from kotlin metadata */
        private final Drawable loadingDrawable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(new FrameLayout(context));
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f)));
            this.imageView = imageView;
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginStart(ViewUtils.dpToPx(4.0f));
            textView.setLayoutParams(layoutParams);
            textView.setTextSize(14.0f);
            textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_secondary));
            this.textView = textView;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setVisibility(8);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            linearLayout.setPadding(0, ViewUtils.dpToPx(16.0f), 0, ViewUtils.dpToPx(32.0f));
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            this.contentView = linearLayout;
            this.loadingDrawable = LoadingUtil.getLoadingDrawable(context, 2);
            View view = this.itemView;
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup != null) {
                viewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                viewGroup.addView(linearLayout);
            }
        }

        /* renamed from: l, reason: from getter */
        public final View getContentView() {
            return this.contentView;
        }

        /* renamed from: m, reason: from getter */
        public final ImageView getImageView() {
            return this.imageView;
        }

        /* renamed from: o, reason: from getter */
        public final Drawable getLoadingDrawable() {
            return this.loadingDrawable;
        }

        /* renamed from: p, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"Lx82/b$b;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWCountLoadMoreStrategy;", "", "getLinearPreloadCount", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: x82.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11533b extends RFWCountLoadMoreStrategy {
        @Override // com.tencent.biz.richframework.preload.recyclerview.RFWCountLoadMoreStrategy
        /* renamed from: getLinearPreloadCount */
        protected int getPreloadCount() {
            return 5;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c extends ObservableProperty<Boolean> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f447475b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, b bVar) {
            super(obj);
            this.f447475b = bVar;
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
            Intrinsics.checkNotNullParameter(property, "property");
            if (oldValue.booleanValue() == newValue.booleanValue()) {
                return;
            }
            this.f447475b.notifyDataSetChanged();
        }
    }

    public b() {
        Delegates delegates = Delegates.INSTANCE;
        this.show = new c(Boolean.FALSE, this);
        this.mLoadMoreStrategy = new C11533b();
    }

    public final boolean i0() {
        return ((Boolean) this.show.getValue(this, D[0])).booleanValue();
    }

    public final void j0(boolean z16) {
        this.show.setValue(this, D[0], Boolean.valueOf(z16));
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        a aVar = this.viewHolder;
        View contentView = aVar != null ? aVar.getContentView() : null;
        if (contentView == null) {
            return;
        }
        contentView.setVisibility(i0() ? 0 : 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        a aVar = new a(context);
        this.viewHolder = aVar;
        return aVar;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        a aVar = this.viewHolder;
        if (aVar != null) {
            aVar.getImageView().setVisibility(8);
            aVar.getImageView().setImageDrawable(null);
            if (hasMore) {
                aVar.getTextView().setText("");
            } else {
                aVar.getTextView().setText(R.string.x3u);
            }
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        a aVar = this.viewHolder;
        if (aVar != null) {
            aVar.getImageView().setVisibility(0);
            aVar.getImageView().setImageDrawable(aVar.getLoadingDrawable());
            aVar.getTextView().setText(R.string.x3v);
        }
    }
}
