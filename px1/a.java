package px1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import java.util.ArrayList;
import java.util.List;
import sx1.f;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends RecyclerView.Adapter<b> {
    private final GProGuildRobotData C;
    private final List<C11044a> D;

    /* renamed from: m, reason: collision with root package name */
    private Context f427871m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: px1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C11044a {

        /* renamed from: a, reason: collision with root package name */
        String f427872a;

        /* renamed from: b, reason: collision with root package name */
        String f427873b;

        public C11044a(String str, String str2) {
            this.f427872a = str;
            this.f427873b = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends RecyclerView.ViewHolder {
        private TextView E;
        private TextView F;

        public b(@NonNull View view) {
            super(view);
            n(view);
        }

        private void n(View view) {
            this.E = (TextView) view.findViewById(R.id.f767942m);
            this.F = (TextView) view.findViewById(R.id.f768042n);
        }
    }

    public a(Context context, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        this.f427871m = context;
        GProGuildRobotData robotData = gProGuildRobotInfoRsp.getRobotData();
        this.C = robotData;
        ArrayList arrayList = new ArrayList();
        this.D = arrayList;
        arrayList.add(new C11044a(HardCodeUtil.qqStr(R.string.f153591ci), robotData.getOwnerEntity()));
        arrayList.add(new C11044a(HardCodeUtil.qqStr(R.string.f153451c5), robotData.getAppid() + ""));
        arrayList.add(new C11044a(HardCodeUtil.qqStr(R.string.f154241e_), String.valueOf(robotData.getRobotName())));
        arrayList.add(new C11044a(HardCodeUtil.qqStr(R.string.f153781d1), String.valueOf(robotData.getRobotDesc())));
        arrayList.add(new C11044a(HardCodeUtil.qqStr(R.string.f154251ea), String.valueOf(gProGuildRobotInfoRsp.getServiceNote())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.D.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i3) {
        C11044a c11044a = this.D.get(i3);
        bVar.E.setText(c11044a.f427872a);
        bVar.F.setText(c11044a.f427873b);
        if (f.j(this.f427871m)) {
            if (QQTheme.isNowThemeIsNight()) {
                bVar.E.setTextColor(Color.parseColor("#5D6064"));
                bVar.F.setTextColor(Color.parseColor("#E3E4E6"));
            } else {
                bVar.E.setTextColor(Color.parseColor("#999999"));
                bVar.F.setTextColor(Color.parseColor("#000000"));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new b(LayoutInflater.from(this.f427871m).inflate(R.layout.f5t, (ViewGroup) null));
    }
}
