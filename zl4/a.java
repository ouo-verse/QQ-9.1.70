package zl4;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.profile.impl.view.forbidden.ForbiddenDurationView;
import com.tencent.timi.game.profile.impl.view.forbidden.UpdateForbiddenEvent;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.ui.widget.k;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import fm4.g;
import gh4.e;
import java.util.HashMap;
import java.util.Map;
import mm4.b;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends BaseSlideUpDialog implements View.OnClickListener, k {
    private ImageView T;
    private TextView U;
    private View V;
    private ForbiddenDurationView W;
    private TextView X;
    private TimiGamePageLoadingView Y;
    private long Z;

    /* renamed from: a0, reason: collision with root package name */
    private CommonOuterClass$QQUserId f452764a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f452765b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: zl4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C11697a implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f452766a;

        C11697a(int i3) {
            this.f452766a = i3;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp) {
            l.i("ForbiddenSpeechDialog", "forbiddenSpeech success");
            a.this.dismiss();
            SimpleEventBus.getInstance().dispatchEvent(new UpdateForbiddenEvent(this.f452766a));
            a.this.hideLoadingView();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            f.c("\u670d\u52a1\u5668\u8d70\u8ff7\u8def\u4e86\uff0c\u518d\u8bd5\u4e00\u4e0b");
            l.e("ForbiddenSpeechDialog", "forbiddenSpeech failed: errorCode == " + i3 + ",errorMessage == " + str);
            a.this.hideLoadingView();
            a.this.dismiss();
        }
    }

    public a(Context context, long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3) {
        super(context);
        this.Z = j3;
        this.f452764a0 = commonOuterClass$QQUserId;
        this.f452765b0 = i3;
    }

    private void initView() {
        setContentView(R.layout.f169117hu2);
        this.Y = (TimiGamePageLoadingView) findViewById(R.id.f93525_t);
        this.T = (ImageView) findViewById(R.id.vdi);
        this.U = (TextView) findViewById(R.id.vdh);
        this.W = (ForbiddenDurationView) findViewById(R.id.vdl);
        this.X = (TextView) findViewById(R.id.vdj);
        this.V = findViewById(R.id.vdk);
        f0();
        e0(this.V);
    }

    private Map<String, String> j0() {
        e I0 = ((gh4.f) b.b(gh4.f.class)).I0();
        HashMap hashMap = new HashMap();
        if (I0 != null) {
            hashMap.putAll(I0.m0().E());
        }
        hashMap.put("yes_to_uid", String.valueOf(this.f452764a0.uid.get()));
        hashMap.put("yes_to_yes_uid", nn4.a.a(this.f452764a0.yes_uid.get()));
        return hashMap;
    }

    private void k0() {
        showLoadingView();
        int d16 = this.W.d();
        ((g) b.b(g.class)).A(this.Z).B(this.f452764a0, d16, new C11697a(d16));
        Map<String, String> j06 = j0();
        j06.put("yes_mute_duration", String.valueOf(d16));
        ((ug4.b) b.b(ug4.b.class)).a(this.X, true, null, "em_yes_mute_panel_confirm", j06);
    }

    private void l0() {
        this.W.e(this.Z, this.f452765b0);
    }

    private void m0() {
        this.T.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.X.setOnClickListener(this);
    }

    private void n0() {
        e I0 = ((gh4.f) b.b(gh4.f.class)).I0();
        if (I0 == null) {
            return;
        }
        ((ug4.b) b.b(ug4.b.class)).G2(this, I0.m0().C());
        ((ug4.b) b.b(ug4.b.class)).a(this.T, true, null, "em_yes_mute_panel_close", j0());
        ((ug4.b) b.b(ug4.b.class)).a(this.U, true, null, "em_yes_mute_panel_cancel", j0());
        ((ug4.b) b.b(ug4.b.class)).a(this.X, true, null, "em_yes_mute_panel_confirm", j0());
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void hideLoadingView() {
        TimiGamePageLoadingView timiGamePageLoadingView = this.Y;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.c();
        }
    }

    public void o0(int i3) {
        this.Y.setHintText(getContext().getString(R.string.f23156727));
        this.Y.d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.vdi) {
            dismiss();
        } else if (view.getId() == R.id.vdh) {
            dismiss();
        } else if (view.getId() == R.id.vdj) {
            k0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        m0();
        l0();
        n0();
    }

    public void showLoadingView() {
        o0(R.string.f23156727);
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void K(@NotNull String str) {
    }
}
