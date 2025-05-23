package xx1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.adapters.extra.GuildTouchCrossLinearLayout;
import com.tencent.mobileqq.guild.rolegroup.view.GuildCommonMemberSearchGridView;
import com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends BaseAdapter {
    private final a C;

    /* renamed from: d, reason: collision with root package name */
    public EditText f448966d;

    /* renamed from: f, reason: collision with root package name */
    private final GuildGridSearchSelectMemberView.h f448968f;

    /* renamed from: h, reason: collision with root package name */
    private final GuildGridSearchSelectMemberView.g f448969h;

    /* renamed from: i, reason: collision with root package name */
    private final GuildCommonMemberSearchGridView f448970i;

    /* renamed from: m, reason: collision with root package name */
    private GuildTouchCrossLinearLayout f448971m;
    private String D = "0";
    private final ArrayList<C11573b> E = new ArrayList<>();
    private final LinkedHashMap<String, C11573b> F = new LinkedHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final C11573b f448967e = new C11573b(1);

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(String[] strArr, boolean z16);

        void b();
    }

    /* compiled from: P */
    /* renamed from: xx1.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C11573b {

        /* renamed from: a, reason: collision with root package name */
        public final int f448972a;

        /* renamed from: b, reason: collision with root package name */
        public String f448973b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f448974c = "";

        public C11573b(int i3) {
            this.f448972a = i3;
        }
    }

    public b(GuildCommonMemberSearchGridView guildCommonMemberSearchGridView, GuildGridSearchSelectMemberView.h hVar, GuildGridSearchSelectMemberView.g gVar, a aVar) {
        this.f448968f = hVar;
        this.f448969h = gVar;
        this.f448970i = guildCommonMemberSearchGridView;
        this.C = aVar;
    }

    private View e(int i3, View view, ViewGroup viewGroup) {
        View view2;
        d dVar;
        if (view == null) {
            dVar = new d(this);
            view2 = dVar.b(viewGroup);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        dVar.a(this.D, getItem(i3));
        return view2;
    }

    private View f(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f6n, (ViewGroup) null);
            EditText editText = (EditText) view.findViewById(R.id.et_search_keyword);
            this.f448971m = (GuildTouchCrossLinearLayout) view.findViewById(R.id.wx_);
            this.f448968f.b(editText);
            editText.addTextChangedListener(this.f448968f);
            editText.setOnKeyListener(this.f448969h);
            this.f448966d = editText;
        }
        this.f448971m.setLayoutParams(new ViewGroup.LayoutParams((bi.d() - QQGuildUIUtil.f(10.0f)) - (QQGuildUIUtil.f(20.0f) + ((i3 % this.f448970i.getNumColumns()) * QQGuildUIUtil.f(85.0f))), -2));
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f448970i.setSelection(getCount() - 1);
    }

    private void j() {
        EditText editText = this.f448966d;
        if (editText != null) {
            editText.setText("");
            this.f448966d.requestFocus();
            this.f448970i.postDelayed(new Runnable() { // from class: xx1.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.g();
                }
            }, 200L);
        }
    }

    public void b(String str, List<C11573b> list) {
        this.D = str;
        this.E.addAll(list);
        for (C11573b c11573b : list) {
            if (this.F.containsKey(c11573b.f448973b) && QLog.isColorLevel()) {
                QLog.e("Guild.rg.GuildRoleGroupMemberFragment.GuildRoleGroupSearchGridAdapter", 2, "same tinyID:" + c11573b.f448973b);
            }
            this.F.put(c11573b.f448973b, c11573b);
        }
        j();
        this.C.b();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C11573b getItem(int i3) {
        if (i3 < this.E.size()) {
            return this.E.get(i3);
        }
        return this.f448967e;
    }

    public List<C11573b> d() {
        return this.E;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.E.size() + 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (i3 < this.E.size()) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View e16;
        int itemViewType = getItemViewType(i3);
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                e16 = view;
            } else {
                e16 = f(i3, view, viewGroup);
            }
        } else {
            e16 = e(i3, view, viewGroup);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return e16;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void i(String[] strArr, boolean z16) {
        for (String str : strArr) {
            if (this.F.containsKey(str)) {
                this.E.remove(this.F.get(str));
                this.F.remove(str);
            }
        }
        j();
        this.C.a(strArr, z16);
        notifyDataSetChanged();
    }

    public void h() {
    }
}
