package xo0;

import android.content.Context;
import com.tencent.guild.aio.input.at.quickAt.selectmember.data.GuildAtFolderItemData;
import com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.GuildAtDividerAdapterDelegate;
import com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.GuildAtEmptyAdapterDelegate;
import com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.GuildAtExpandAdapterDelegate;
import com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.GuildAtFolderAdapterDelegate;
import com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.GuildAtMemberAdapterDelegate;
import com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.GuildAtRobotAdapterDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.l;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends l<List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a>> implements vo0.b {
    private xo0.b D;
    private vo0.a E;
    private boolean G;
    private List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> H;
    private HashMap<Integer, wo0.a> F = new HashMap<>();
    private final com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d I = new C11557a();
    private wo0.d J = new b();

    /* compiled from: P */
    /* renamed from: xo0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C11557a implements com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d {
        C11557a() {
        }

        @Override // com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d
        public boolean a(com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar) {
            wo0.a aVar2;
            if ((!aVar.e() && d.b(a.this.E.d().size())) || (aVar2 = (wo0.a) a.this.F.get(Integer.valueOf(a.this.s0(aVar.a())))) == null) {
                return false;
            }
            return aVar2.d(aVar, a.this.E.e());
        }

        @Override // com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d
        public int getChannelType() {
            return a.this.D.a();
        }

        @Override // com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d
        public Context getContext() {
            return a.this.D.b();
        }

        @Override // com.tencent.guild.aio.input.at.quickAt.selectmember.delegate.d
        public String getGuildId() {
            return a.this.D.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements wo0.d {
        b() {
        }

        @Override // wo0.d
        public boolean a(com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, int i3) {
            return a.this.E.b(aVar, i3);
        }

        @Override // wo0.d
        public boolean b(com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, int i3) {
            return a.this.E.l(aVar, i3);
        }

        @Override // wo0.d
        public String getGuildId() {
            return a.this.D.c();
        }
    }

    public a(xo0.b bVar, vo0.a aVar, boolean z16) {
        this.G = false;
        this.D = bVar;
        this.E = aVar;
        this.G = z16;
        o0();
        p0();
    }

    private void o0() {
        this.f236199m.c(new GuildAtMemberAdapterDelegate(this.I)).c(new GuildAtRobotAdapterDelegate(this.I)).c(new GuildAtEmptyAdapterDelegate(this.I)).c(new GuildAtDividerAdapterDelegate(this.I)).c(new GuildAtFolderAdapterDelegate(this.I)).c(new GuildAtExpandAdapterDelegate(this.I));
    }

    private void p0() {
        this.F.put(3, new wo0.b(this.J));
        this.F.put(2, new wo0.c(this.J, this.D.a()));
        t0();
    }

    private void q0() {
        Iterator<Map.Entry<Integer, wo0.a>> it = this.F.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }

    private void r0() {
        Iterator<Map.Entry<Integer, wo0.a>> it = this.F.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s0(int i3) {
        if (!this.F.containsKey(Integer.valueOf(i3))) {
            return 0;
        }
        return i3;
    }

    private void t0() {
        Iterator<Map.Entry<Integer, wo0.a>> it = this.F.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().c();
        }
    }

    private void v0() {
        setItems(this.E.c());
    }

    @Override // vo0.b
    public void c(List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list) {
        v0();
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List, T] */
    @Override // vo0.b
    public void e(boolean z16, com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list, int i3) {
        ?? c16 = this.E.c();
        this.C = c16;
        int indexOf = ((List) c16).indexOf(aVar);
        if (indexOf >= 0) {
            notifyItemChanged(indexOf);
            return;
        }
        for (com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar2 : (List) this.C) {
            if (aVar2.c() == aVar.c() && aVar2.a() == aVar.a()) {
                int indexOf2 = ((List) this.C).indexOf(aVar2);
                aVar2.h(aVar.e());
                notifyItemChanged(indexOf2);
            }
        }
    }

    @Override // vo0.b
    public void g(boolean z16) {
        v0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return ((com.tencent.guild.aio.input.at.quickAt.selectmember.data.a) ((List) i0()).get(i3)).c();
    }

    @Override // vo0.b
    public void i() {
        v0();
    }

    public void onDestroy() {
        QLog.d("GuildAtSelectItemAdapter", 1, "onDestroy()");
        r0();
        this.F.clear();
    }

    public void setItems(List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list) {
        boolean z16;
        boolean z17;
        super.j0(list);
        List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list2 = this.H;
        if (list.size() > 0 && (list.get(0) instanceof GuildAtFolderItemData)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (list2 != null && list2.size() > 0 && (list2.get(0) instanceof GuildAtFolderItemData)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (list2 != null && list.size() != 0 && list2.size() != 0 && list.size() != list2.size() && z16 && z17) {
            int min = Math.min(list.size(), list2.size());
            int i3 = 0;
            while (i3 < min && list.get(i3).c() == list2.get(i3).c()) {
                i3++;
            }
            for (int i16 = 0; i16 < min - i3 && list.get((list.size() - 1) - i16).c() == list2.get((list2.size() - 1) - i16).c(); i16++) {
            }
            if (i3 > 0) {
                int i17 = i3 - 1;
                if (list.get(i17) instanceof GuildAtFolderItemData) {
                    notifyItemChanged(i17);
                }
            }
            if (list.size() > list2.size()) {
                notifyItemRangeInserted(i3, list.size() - min);
            } else {
                notifyItemRangeRemoved(i3, list2.size() - min);
            }
        } else {
            notifyDataSetChanged();
        }
        this.H = new ArrayList(list);
    }

    public void u0() {
        QLog.d("GuildAtSelectItemAdapter", 1, "onClear()");
        q0();
    }
}
