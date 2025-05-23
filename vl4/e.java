package vl4;

import am4.a;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.profile.impl.dialog.picker.PickerSelectItemView;
import com.tencent.widget.VerticalGallery;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016J$\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lvl4/e;", "T", "Landroid/widget/BaseAdapter;", "", "list", "", "setData", "", "getCount", "position", "", "getItem", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "e", "Ljava/util/List;", "dataList", "<init>", "(Landroid/content/Context;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e<T> extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<T> dataList;

    public e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.dataList = new ArrayList();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataList.size();
    }

    @Override // android.widget.Adapter
    @NotNull
    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = new PickerSelectItemView(this.context);
            view.setLayoutParams(new VerticalGallery.LayoutParams(-1, -2));
        } else {
            view = convertView;
        }
        if (view instanceof PickerSelectItemView) {
            T t16 = this.dataList.get(position);
            if (t16 instanceof a.b) {
                ((PickerSelectItemView) view).setContent(((a.b) t16).getText());
            } else if (t16 instanceof a.c) {
                ((PickerSelectItemView) view).setContent(((a.c) t16).getText());
            }
            ((PickerSelectItemView) view).setSelectStyle(false);
        }
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return view;
    }

    public final void setData(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList.clear();
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }
}
