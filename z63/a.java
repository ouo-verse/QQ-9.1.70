package z63;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0006B\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0002R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lz63/a;", "Landroid/widget/BaseAdapter;", "", "getCount", "position", "Lcom/tencent/mobileqq/wink/editor/crop/model/a;", "a", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "", "b", "", "d", "Ljava/util/List;", "mosaicDataList", "Landroid/view/LayoutInflater;", "e", "Landroid/view/LayoutInflater;", "mInflater", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.wink.editor.crop.model.a> mosaicDataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LayoutInflater mInflater;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lz63/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "img", "Landroid/view/View;", "b", "Landroid/view/View;", "()Landroid/view/View;", "selectCoverView", "<init>", "(Landroid/widget/ImageView;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: z63.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ViewHolder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ImageView img;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final View selectCoverView;

        public ViewHolder(@NotNull ImageView img, @NotNull View selectCoverView) {
            Intrinsics.checkNotNullParameter(img, "img");
            Intrinsics.checkNotNullParameter(selectCoverView, "selectCoverView");
            this.img = img;
            this.selectCoverView = selectCoverView;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ImageView getImg() {
            return this.img;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final View getSelectCoverView() {
            return this.selectCoverView;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewHolder)) {
                return false;
            }
            ViewHolder viewHolder = (ViewHolder) other;
            if (Intrinsics.areEqual(this.img, viewHolder.img) && Intrinsics.areEqual(this.selectCoverView, viewHolder.selectCoverView)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.img.hashCode() * 31) + this.selectCoverView.hashCode();
        }

        @NotNull
        public String toString() {
            return "ViewHolder(img=" + this.img + ", selectCoverView=" + this.selectCoverView + ")";
        }
    }

    public a(@NotNull Context context, @NotNull List<com.tencent.mobileqq.wink.editor.crop.model.a> mosaicDataList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mosaicDataList, "mosaicDataList");
        this.mosaicDataList = mosaicDataList;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.mInflater = from;
    }

    @Override // android.widget.Adapter
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.wink.editor.crop.model.a getItem(int position) {
        return this.mosaicDataList.get(position);
    }

    public final void b(int position) {
        Iterator<T> it = this.mosaicDataList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.wink.editor.crop.model.a) it.next()).g(false);
        }
        if (position >= 0 && position < this.mosaicDataList.size()) {
            this.mosaicDataList.get(position).g(true);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mosaicDataList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        Pair pair;
        int i3 = 0;
        if (convertView != null) {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.mosaic.ui.adapter.WinkMosaicListAdapter.ViewHolder");
            pair = new Pair(convertView, (ViewHolder) tag);
        } else {
            View inflate = this.mInflater.inflate(R.layout.hdq, parent, false);
            View findViewById = inflate.findViewById(R.id.y8t);
            Intrinsics.checkNotNullExpressionValue(findViewById, "tempView.findViewById(R.id.iv_seg_cover)");
            View findViewById2 = inflate.findViewById(R.id.y8u);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "tempView.findViewById(R.id.iv_select)");
            ViewHolder viewHolder = new ViewHolder((ImageView) findViewById, findViewById2);
            inflate.setTag(viewHolder);
            pair = new Pair(inflate, viewHolder);
        }
        View view = (View) pair.component1();
        ViewHolder viewHolder2 = (ViewHolder) pair.component2();
        com.tencent.mobileqq.wink.editor.crop.model.a item = getItem(position);
        QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
        Option obtain = Option.obtain();
        obtain.setUrl(item.getThumbUrl());
        obtain.setTargetView(viewHolder2.getImg());
        obtain.setRequestHeight(ViewExKt.d(64));
        obtain.setRequestWidth(ViewExKt.d(64));
        g16.loadImage(obtain);
        View selectCoverView = viewHolder2.getSelectCoverView();
        if (!item.getIsSelect()) {
            i3 = 8;
        }
        selectCoverView.setVisibility(i3);
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return view;
    }
}
