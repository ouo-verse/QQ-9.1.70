package ux1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.TextAndSwitchButtonBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g extends RecyclerView.Adapter<c> {
    private a C;

    /* renamed from: m, reason: collision with root package name */
    private final List<b> f440536m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(int i3, String str, boolean z16, View view);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c extends RecyclerView.ViewHolder implements com.tencent.mobileqq.guild.base.extension.f {
        public View E;

        public c(@NonNull View view) {
            super(view);
            this.E = view;
        }

        @Override // com.tencent.mobileqq.guild.base.extension.f
        public boolean c(int i3) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(GuildSwitchButton guildSwitchButton, boolean z16) {
        if (this.C != null && (guildSwitchButton.getTag() instanceof b)) {
            b bVar = (b) guildSwitchButton.getTag();
            bVar.f440542f = z16;
            this.C.a(bVar.f440538b, bVar.f440539c, z16, guildSwitchButton);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f440536m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f440536m.get(i3).f440537a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i3) {
        b bVar = this.f440536m.get(i3);
        int i16 = bVar.f440537a;
        if (i16 == 0) {
            ((TextView) cVar.E.findViewById(R.id.f240107z)).setText(bVar.f440539c);
            return;
        }
        if (i16 == 1) {
            TextAndSwitchButtonBar textAndSwitchButtonBar = (TextAndSwitchButtonBar) cVar.E;
            textAndSwitchButtonBar.setTagForSwitchBtn(bVar);
            textAndSwitchButtonBar.setProperty(bVar.f440539c, bVar.f440540d, bVar.f440541e, bVar.f440542f, bVar.f440543g, bVar.f440545i);
            textAndSwitchButtonBar.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            textAndSwitchButtonBar.setRightButtonListener(new GuildSwitchButton.a() { // from class: ux1.f
                @Override // com.tencent.mobileqq.guild.widget.GuildSwitchButton.a
                public final void onCheckedChanged(GuildSwitchButton guildSwitchButton, boolean z16) {
                    g.this.j0(guildSwitchButton, z16);
                }
            });
            float f16 = 1.0f;
            if (bVar.f440541e == TextAndSwitchButtonBar.ButtonState.SWITCH_BUTTON) {
                if (!bVar.f440543g) {
                    f16 = 0.5f;
                }
                textAndSwitchButtonBar.setAlpha(f16);
                return;
            }
            textAndSwitchButtonBar.setAlpha(1.0f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        View inflate;
        if (i3 == 1) {
            inflate = new TextAndSwitchButtonBar(viewGroup.getContext());
        } else {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f6k, viewGroup, false);
        }
        return new c(inflate);
    }

    public void m0(boolean z16, List<Integer> list, boolean z17) {
        if (z16) {
            for (b bVar : this.f440536m) {
                if (list.contains(Integer.valueOf(bVar.f440538b))) {
                    bVar.f440543g = true;
                }
            }
        } else {
            Iterator<b> it = this.f440536m.iterator();
            while (it.hasNext()) {
                it.next().f440543g = false;
            }
        }
        if (z17) {
            Iterator<b> it5 = this.f440536m.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                b next = it5.next();
                if (next.f440538b == 70000) {
                    next.f440543g = false;
                    break;
                }
            }
        }
        notifyDataSetChanged();
    }

    public void n0(a aVar) {
        this.C = aVar;
    }

    public void setData(@NonNull List<b> list) {
        this.f440536m.clear();
        this.f440536m.addAll(list);
        notifyDataSetChanged();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f440537a;

        /* renamed from: b, reason: collision with root package name */
        public int f440538b;

        /* renamed from: c, reason: collision with root package name */
        public String f440539c;

        /* renamed from: d, reason: collision with root package name */
        public String f440540d;

        /* renamed from: e, reason: collision with root package name */
        public TextAndSwitchButtonBar.ButtonState f440541e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f440542f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f440543g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f440544h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f440545i;

        public b(String str, String str2, boolean z16, boolean z17, TextAndSwitchButtonBar.ButtonState buttonState, int i3) {
            this.f440544h = true;
            this.f440545i = false;
            this.f440537a = 1;
            this.f440539c = str;
            this.f440540d = str2;
            this.f440542f = z16;
            this.f440543g = z17;
            this.f440541e = buttonState;
            this.f440538b = i3;
        }

        public String toString() {
            return "PermissionInfoItem{mType=" + this.f440537a + ", mPermissionType=" + this.f440538b + ", mTitle='" + this.f440539c + "', mIsChecked=" + this.f440542f + ", mIsAccessible=" + this.f440543g + ", mIsShow=" + this.f440544h + ", mSummary='" + this.f440540d + "', mButtonState=" + this.f440541e + ", mIsShowBottomLine=" + this.f440545i + '}';
        }

        public b(String str, String str2) {
            this.f440544h = true;
            this.f440545i = false;
            this.f440537a = 1;
            this.f440539c = str;
            this.f440540d = str2;
            this.f440542f = true;
            this.f440543g = true;
            this.f440541e = TextAndSwitchButtonBar.ButtonState.IMAGE_ICON;
        }

        public b(String str) {
            this.f440543g = false;
            this.f440544h = true;
            this.f440545i = false;
            this.f440539c = str;
            this.f440537a = 0;
        }
    }
}
