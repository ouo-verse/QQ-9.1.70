package vx1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final InterfaceC11444a C;
    private final String D;
    private boolean E;

    /* renamed from: m, reason: collision with root package name */
    private final List<by1.a> f443629m = new ArrayList();

    /* compiled from: P */
    /* renamed from: vx1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC11444a {
        void g6(String str, String str2, int i3);
    }

    public a(String str, InterfaceC11444a interfaceC11444a) {
        this.D = str;
        this.C = interfaceC11444a;
        this.E = GuildDebugUtils.f(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f443629m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f443629m.get(i3).a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        int e16;
        by1.a aVar = this.f443629m.get(i3);
        if (aVar instanceof by1.b) {
            ((b) viewHolder).l(i3, (by1.b) aVar);
            if (!(viewHolder.itemView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.itemView.getLayoutParams();
            if (i3 == 0) {
                e16 = 0;
            } else {
                e16 = QQGuildUIUtil.e(13.0f, viewHolder.itemView.getResources());
            }
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, e16, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            viewHolder.itemView.requestLayout();
            return;
        }
        if (aVar instanceof by1.c) {
            ((c) viewHolder).l(i3, (by1.c) aVar);
        } else if (aVar instanceof by1.e) {
            ((e) viewHolder).m(((by1.e) aVar).getGroupName());
        } else if (aVar instanceof by1.d) {
            ((d) viewHolder).m(((by1.d) aVar).getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(b.m(), viewGroup, false));
        }
        if (i3 == 1) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(c.m(), viewGroup, false), this.E, this.C);
        }
        if (i3 == 2) {
            return e.l(viewGroup);
        }
        if (i3 == 3) {
            return d.l(viewGroup);
        }
        throw new IllegalStateException("onCreateViewHolder viewType:" + i3);
    }

    public void setData(List<by1.a> list) {
        this.f443629m.clear();
        this.f443629m.addAll(list);
        notifyDataSetChanged();
    }
}
