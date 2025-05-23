package xx1;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int C;
    private final a D;
    private final Set<String> E = new HashSet();
    private final List<RoleGroupUserUIData> F = new ArrayList();
    private String G = "0";

    /* renamed from: m, reason: collision with root package name */
    public final int f448975m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(RoleGroupUserUIData roleGroupUserUIData);

        void b();

        void c();

        void d();

        void e(RoleGroupUserUIData roleGroupUserUIData);

        void f(RoleGroupUserUIData[] roleGroupUserUIDataArr);

        void g(String str, RoleGroupUserUIData[] roleGroupUserUIDataArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b extends RecyclerView.ViewHolder {
        TextView E;
        RoleGroupUserUIData F;

        public b(View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.z27);
        }

        public void l(RoleGroupUserUIData roleGroupUserUIData) {
            this.F = roleGroupUserUIData;
            this.E.setText(roleGroupUserUIData.getMTitleName());
        }
    }

    /* compiled from: P */
    /* renamed from: xx1.c$c, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    private static class C11574c extends RecyclerView.ViewHolder {
        public C11574c(ViewGroup viewGroup) {
            super(l(viewGroup));
        }

        private static View l(ViewGroup viewGroup) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.addView(new View(viewGroup.getContext()), -1, QQGuildUIUtil.f(12.0f));
            return frameLayout;
        }
    }

    public c(int i3, a aVar, int i16) {
        this.C = i16;
        this.f448975m = i3;
        this.D = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.F.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.F.isEmpty()) {
            return 0;
        }
        return this.F.get(i3).getType();
    }

    public void i0() {
        this.F.clear();
    }

    public List<String> j0() {
        ArrayList arrayList = new ArrayList();
        if (this.f448975m != 2) {
            return arrayList;
        }
        Iterator<RoleGroupUserUIData> it = this.F.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMTinyId());
        }
        return arrayList;
    }

    public Set<String> k0() {
        return this.E;
    }

    public boolean l0(CompoundButton compoundButton, boolean z16) {
        boolean z17 = true;
        if (!compoundButton.isShown()) {
            return true;
        }
        if (z16 && this.E.size() >= this.C) {
            QQToast.makeText(BaseApplication.getContext(), 1, "\u8be5\u8eab\u4efd\u7ec4\u6210\u5458\u5df2\u8fbe\u4e0a\u9650", 1).show();
            this.D.d();
            return false;
        }
        RoleGroupUserUIData roleGroupUserUIData = (RoleGroupUserUIData) compoundButton.getTag();
        if (z16) {
            this.E.add(roleGroupUserUIData.getMTinyId());
            this.D.g(this.G, new RoleGroupUserUIData[]{roleGroupUserUIData});
        } else {
            this.E.remove(roleGroupUserUIData.getMTinyId());
            this.D.f(new RoleGroupUserUIData[]{roleGroupUserUIData});
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.rg.GuildRoleGroupMemberAdapter", 2, "onCheckedChanged, mSelectedIdSet: " + this.E.toString());
        }
        if (this.E.isEmpty()) {
            this.D.c();
        } else {
            this.D.b();
        }
        this.D.d();
        return z17;
    }

    public void m0(RoleGroupUserUIData roleGroupUserUIData) {
        if (roleGroupUserUIData != null && !TextUtils.isEmpty(roleGroupUserUIData.getMTinyId())) {
            this.D.e(roleGroupUserUIData);
        }
    }

    public void n0(RoleGroupUserUIData roleGroupUserUIData) {
        if (roleGroupUserUIData != null && !TextUtils.isEmpty(roleGroupUserUIData.getMTinyId())) {
            this.D.a(roleGroupUserUIData);
        }
    }

    public void o0(RoleGroupUserUIData roleGroupUserUIData) {
        for (int i3 = 0; i3 < this.F.size(); i3++) {
            if (TextUtils.equals(this.F.get(i3).getMTinyId(), roleGroupUserUIData.getMTinyId())) {
                this.F.remove(i3);
                notifyItemRemoved(i3);
                return;
            }
        }
        QLog.e("Guild.rg.GuildRoleGroupMemberAdapter", 1, "item to remove not found:" + roleGroupUserUIData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        onBindViewHolder(viewHolder, i3, new ArrayList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            return new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f6e, (ViewGroup) null), this);
        }
        if (i3 == 2) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f6f, (ViewGroup) null));
        }
        if (i3 == 3) {
            return new C11574c(viewGroup);
        }
        throw new IllegalArgumentException("illegal viewType:" + i3);
    }

    public void p0(String[] strArr) {
        for (String str : strArr) {
            this.E.remove(str);
            for (int i3 = 0; i3 < this.F.size(); i3++) {
                if (TextUtils.equals(this.F.get(i3).getMTinyId(), str)) {
                    notifyItemChanged(i3, 1);
                }
            }
        }
        if (this.E.isEmpty()) {
            this.D.c();
        }
    }

    public void q0(String str, List<RoleGroupUserUIData> list) {
        this.G = str;
        this.F.clear();
        if (list != null) {
            this.F.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void r0(String[] strArr) {
        Collections.addAll(this.E, strArr);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List<Object> list) {
        RoleGroupUserUIData roleGroupUserUIData = this.F.get(i3);
        if (viewHolder instanceof f) {
            ((f) viewHolder).m(this.G, roleGroupUserUIData, this.E.contains(roleGroupUserUIData.getMTinyId()), list);
        } else if (viewHolder instanceof b) {
            ((b) viewHolder).l(roleGroupUserUIData);
        }
    }

    public void onDestroy() {
    }
}
