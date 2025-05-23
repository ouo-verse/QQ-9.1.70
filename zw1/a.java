package zw1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddFragment;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfo;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import zw1.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends RecyclerView.Adapter<g> {
    private LayoutInflater C;
    private GuildChannel D;
    private zw1.e E;
    private FragmentActivity F;
    private boolean G;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<GProGuildRobotInfo> f453577m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: zw1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C11723a implements RobotInfoFragment.a {
        C11723a() {
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void a() {
            a.this.E.o();
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void b(boolean z16) {
            a.this.E.s();
            a.this.E.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProGuildRobotInfo f453579d;

        b(GProGuildRobotInfo gProGuildRobotInfo) {
            this.f453579d = gProGuildRobotInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(GProGuildRobotInfo gProGuildRobotInfo, int i3, String str) {
            a.this.n0(gProGuildRobotInfo, i3, str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("robot_add_btn")) {
                if (a.this.E.n() == 0) {
                    QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), 0, R.string.f15122174, 0).show();
                } else {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        RobotInfo robotInfo = new RobotInfo();
                        robotInfo.u(this.f453579d.getRobotUin());
                        robotInfo.s(this.f453579d.getRobotName());
                        FragmentActivity fragmentActivity = a.this.F;
                        GuildChannel guildChannel = a.this.D;
                        final GProGuildRobotInfo gProGuildRobotInfo = this.f453579d;
                        RobotAuthorizeAddFragment.Jh(fragmentActivity, peekAppRuntime, guildChannel, robotInfo, null, new vw1.d() { // from class: zw1.b
                            @Override // vw1.d
                            public final void a(int i3, String str) {
                                a.b.this.b(gProGuildRobotInfo, i3, str);
                            }
                        }, "\u97f3\u9891\u673a\u5668\u4eba\u5217\u8868");
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProGuildRobotInfo f453581d;

        c(GProGuildRobotInfo gProGuildRobotInfo) {
            this.f453581d = gProGuildRobotInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("updown_mic_btn")) {
                a.this.E.i(a.this.D, this.f453581d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProGuildRobotInfo f453583d;

        d(GProGuildRobotInfo gProGuildRobotInfo) {
            this.f453583d = gProGuildRobotInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("updown_mic_btn")) {
                a.this.E.t(a.this.D, this.f453583d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProGuildRobotInfo f453585d;

        e(GProGuildRobotInfo gProGuildRobotInfo) {
            this.f453585d = gProGuildRobotInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.p0(this.f453585d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProGuildRobotInfo f453587d;

        f(GProGuildRobotInfo gProGuildRobotInfo) {
            this.f453587d = gProGuildRobotInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.p0(this.f453587d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g extends RecyclerView.ViewHolder {
        private ImageView E;
        private ImageView F;
        private TextView G;
        private TextView H;
        private FrameLayout I;
        private FrameLayout J;
        private TextView K;
        private LinearLayout L;

        public g(View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.wwm);
            this.G = (TextView) view.findViewById(R.id.f165607wx2);
            this.H = (TextView) view.findViewById(R.id.wwq);
            this.I = (FrameLayout) view.findViewById(R.id.vwo);
            this.J = (FrameLayout) view.findViewById(R.id.x48);
            this.K = (TextView) view.findViewById(R.id.x4_);
            this.F = (ImageView) view.findViewById(R.id.x49);
            this.L = (LinearLayout) view.findViewById(R.id.f165433vz3);
        }
    }

    public a(FragmentActivity fragmentActivity, ArrayList<GProGuildRobotInfo> arrayList, GuildChannel guildChannel, boolean z16, zw1.e eVar) {
        this.f453577m = arrayList;
        this.E = eVar;
        this.D = guildChannel;
        this.F = fragmentActivity;
        this.G = z16;
        this.C = LayoutInflater.from(fragmentActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(GProGuildRobotInfo gProGuildRobotInfo, int i3, String str) {
        QLog.i("AudioRobotListAdapter", 1, "authorize add, code: " + i3 + ", message: " + str);
        if (i3 == -2) {
            return;
        }
        if (i3 == 0) {
            QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), 2, R.string.f154601f9, 0).show();
            this.E.t(this.D, gProGuildRobotInfo);
        } else if (i3 == 32004) {
            this.E.t(this.D, gProGuildRobotInfo);
        } else {
            QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), 1, R.string.f154591f8, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(GProGuildRobotInfo gProGuildRobotInfo) {
        if (this.D != null && !o.c("robot_avatar")) {
            RobotInfoFragment.xh(this.F, String.valueOf(this.D.a()), String.valueOf(this.D.b()), "", String.valueOf(gProGuildRobotInfo.getRobotUin()), "5", false, new C11723a(), 0);
        }
    }

    private void r0(g gVar, GProGuildRobotInfo gProGuildRobotInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            gVar.E.setImageDrawable(((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getFaceDrawableByUser((AppInterface) peekAppRuntime, String.valueOf(gProGuildRobotInfo.getRobotUin())));
        }
    }

    private void s0(g gVar, int i3) {
        GProGuildRobotInfo gProGuildRobotInfo = this.f453577m.get(i3);
        if (gProGuildRobotInfo == null) {
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("qq_robot_robot_location", Integer.valueOf(i3));
        hashMap.put("qq_robot_robot_name", gProGuildRobotInfo.getRobotName());
        hashMap.put("qq_robot_robot_id", Long.valueOf(gProGuildRobotInfo.getRobotUin()));
        hashMap.put("qq_robot_function_introduct", gProGuildRobotInfo.getRobotDesc());
        if (this.G) {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(gVar.itemView, "em_qqrobot_added_robot", hashMap);
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(gVar.E, "em_qqrobot_added_robot", hashMap);
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(gVar.L, "em_qqrobot_added_robot", hashMap);
            View view = gVar.itemView;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
            VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
            if (gVar.K.getText() == this.F.getText(R.string.f158121or)) {
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(gVar.J, "em_qqrobot_microphone_up", null);
            } else {
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(gVar.J, "em_qqrobot_microphone_down", null);
            }
            VideoReport.setElementEndExposePolicy(gVar.J, endExposurePolicy);
            return;
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(gVar.itemView, "em_qqrobot_not_added_robot", hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(gVar.E, "em_qqrobot_not_added_robot", hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(gVar.L, "em_qqrobot_not_added_robot", hashMap);
        View view2 = gVar.itemView;
        EndExposurePolicy endExposurePolicy2 = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(view2, endExposurePolicy2);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(gVar.I, "em_qqrobot_add_robot", null);
        VideoReport.setElementEndExposePolicy(gVar.I, endExposurePolicy2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f453577m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(g gVar, int i3) {
        GProGuildRobotInfo gProGuildRobotInfo = this.f453577m.get(i3);
        r0(gVar, gProGuildRobotInfo);
        gVar.G.setText(gProGuildRobotInfo.getRobotName());
        gVar.H.setText(gProGuildRobotInfo.getRobotDesc());
        gVar.I.setOnClickListener(new b(gProGuildRobotInfo));
        if (this.G) {
            gVar.J.setVisibility(0);
            gVar.I.setVisibility(8);
        } else {
            gVar.J.setVisibility(8);
            gVar.I.setVisibility(0);
        }
        if (sx1.f.e(String.valueOf(gProGuildRobotInfo.getRobotTid()))) {
            gVar.K.setText(R.string.f143350lu);
            gVar.F.setImageDrawable(this.F.getDrawable(R.drawable.guild_add_robot_btn_selector));
            gVar.K.setTextColor(MobileQQ.sMobileQQ.getApplicationContext().getColor(R.color.guild_skin_content_text));
            gVar.J.setOnClickListener(new c(gProGuildRobotInfo));
        } else {
            gVar.K.setText(R.string.f158121or);
            gVar.F.setImageDrawable(this.F.getDrawable(R.drawable.guild_upmic_robot_btn));
            gVar.K.setTextColor(-1);
            gVar.J.setOnClickListener(new d(gProGuildRobotInfo));
        }
        gVar.E.setOnClickListener(new e(gProGuildRobotInfo));
        gVar.L.setOnClickListener(new f(gProGuildRobotInfo));
        s0(gVar, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public g onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new g(this.C.inflate(R.layout.edn, viewGroup, false));
    }

    public void t0(ArrayList<GProGuildRobotInfo> arrayList) {
        this.f453577m = arrayList;
        notifyDataSetChanged();
    }
}
