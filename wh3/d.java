package wh3;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.falco.utils.UIUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.friend.FriendInfo;
import com.tencent.mobileqq.zplan.friend.changerole.model.State;
import com.tencent.mobileqq.zplan.friend.changerole.model.ZplanFriendEx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends com.tencent.mobileqq.zplan.friend.b<a> {
    private final com.tencent.mobileqq.zplan.friend.changerole.model.a D;
    private int E;
    private final com.tencent.mobileqq.zplan.friend.e F;
    protected List<ZplanFriendEx> G;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a extends com.tencent.mobileqq.zplan.friend.a {
        private final View G;
        private final CheckBox H;
        private final ImageView I;
        private final TextView J;
        private final ImageView K;

        public a(View view) {
            super(view);
            this.G = view.findViewById(R.id.qjr);
            this.H = (CheckBox) view.findViewById(R.id.qjp);
            this.I = (ImageView) view.findViewById(R.id.pyy);
            this.J = (TextView) view.findViewById(R.id.q_j);
            this.K = (ImageView) view.findViewById(R.id.pcv);
        }

        @Override // com.tencent.mobileqq.zplan.friend.a
        /* renamed from: l */
        public ImageView getAvatar() {
            return this.I;
        }

        @Override // com.tencent.mobileqq.zplan.friend.a
        /* renamed from: m */
        public TextView getName() {
            return this.J;
        }
    }

    public d(com.tencent.mobileqq.zplan.friend.changerole.model.a aVar, com.tencent.mobileqq.zplan.friend.e eVar) {
        super(eVar);
        this.G = new ArrayList();
        this.F = eVar;
        this.D = aVar;
        this.E = aVar.T1().getValue().intValue();
    }

    private void n0(a aVar, ZplanFriendEx zplanFriendEx) {
        FriendInfo friendInfo = zplanFriendEx.getFriendInfo();
        Context context = aVar.itemView.getContext();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = UIUtil.dp2px(context, 60.0f);
        obtain.mRequestWidth = UIUtil.dp2px(context, 60.0f);
        if (URLUtil.isValidUrl(friendInfo.getProfileUrl())) {
            aVar.K.setImageDrawable(URLDrawable.getDrawable(friendInfo.getProfileUrl(), obtain));
        } else {
            QLog.e("ZPlaneFriendSelectListViewAdapter", 1, "profileUrl is invalid url: " + friendInfo.getProfileUrl());
            aVar.K.setImageDrawable(null);
        }
        this.F.c(friendInfo, aVar);
        v0(aVar, zplanFriendEx.getState());
    }

    private List<ZplanFriendEx> p0() {
        FriendInfo friendInfo;
        List<FriendInfo> X1 = this.D.X1();
        ArrayList arrayList = new ArrayList();
        if (X1.isEmpty()) {
            return arrayList;
        }
        Map<Integer, FriendInfo> value = this.D.Z1().getValue();
        QLog.i("ZPlaneFriendSelectListViewAdapter", 4, " bind View " + X1);
        if (value != null) {
            QLog.i("ZPlaneFriendSelectListViewAdapter", 4, " map is " + value.size());
            friendInfo = value.get(this.D.T1().getValue());
        } else {
            friendInfo = null;
        }
        for (FriendInfo friendInfo2 : X1) {
            State state = State.Normal;
            if (friendInfo != null && friendInfo.equals(friendInfo2)) {
                state = State.Checked;
            }
            arrayList.add(new ZplanFriendEx(friendInfo2, state));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(ZplanFriendEx zplanFriendEx, a aVar, int i3, View view) {
        FriendInfo friendInfo = zplanFriendEx.getFriendInfo();
        State state = zplanFriendEx.getState();
        State state2 = State.Normal;
        if (state == state2) {
            zplanFriendEx.c(State.Checked);
        } else if (state == State.Checked) {
            zplanFriendEx.c(state2);
            friendInfo = null;
        }
        v0(aVar, zplanFriendEx.getState());
        u0(i3);
        this.D.h2(this.E, friendInfo);
    }

    private void t0() {
        this.G = p0();
        notifyDataSetChanged();
    }

    private void u0(int i3) {
        int size = this.G.size();
        for (int i16 = 0; i16 < size; i16++) {
            ZplanFriendEx zplanFriendEx = this.G.get(i16);
            if (i16 != i3) {
                State state = zplanFriendEx.getState();
                State state2 = State.Normal;
                if (state != state2) {
                    zplanFriendEx.c(state2);
                    notifyItemChanged(i16);
                }
            }
        }
    }

    private void v0(a aVar, State state) {
        Context context = aVar.itemView.getContext();
        if (state == State.Normal) {
            aVar.H.setVisibility(8);
            aVar.G.setBackground(ContextCompat.getDrawable(context, R.drawable.f159891i33));
        } else if (state == State.Checked) {
            aVar.H.setVisibility(0);
            aVar.H.setChecked(true);
            aVar.G.setBackground(ContextCompat.getDrawable(context, R.drawable.f159892i34));
        }
    }

    @Override // com.tencent.mobileqq.zplan.friend.b, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.G.size();
    }

    public int o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = this.G.size();
        for (int i3 = 0; i3 < size; i3++) {
            Character firstChar = this.G.get(i3).getFriendInfo().getFirstChar();
            Objects.requireNonNull(firstChar);
            if (firstChar.toString().equals(str)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a aVar, final int i3) {
        final ZplanFriendEx zplanFriendEx = this.G.get(i3);
        n0(aVar, zplanFriendEx);
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: wh3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.q0(zplanFriendEx, aVar, i3, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dcf, viewGroup, false));
    }

    public void w0(int i3) {
        this.E = i3;
        QLog.i("ZPlaneFriendSelectListViewAdapter", 4, " update Step select Index " + i3);
        t0();
    }
}
