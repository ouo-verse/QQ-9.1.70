package wh3;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.friend.changerole.model.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import fi3.ba;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wh3.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lwh3/h;", "Lcom/tencent/mobileqq/mvvm/b;", "Lfi3/ba;", "binding", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zplan/friend/changerole/model/a;", "viewModel", "", "p", "Landroidx/lifecycle/LifecycleOwner;", "owner", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", "d", "Z", "isUseInLittleWorld", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "<init>", "()V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h extends com.tencent.mobileqq.mvvm.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isUseInLittleWorld;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"wh3/h$b", "Lcom/tencent/mobileqq/zplan/friend/changerole/model/a$c;", "", "onInitFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements a.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f445665b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LifecycleOwner f445666c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ba f445667d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.friend.changerole.model.a f445668e;

        b(Activity activity, LifecycleOwner lifecycleOwner, ba baVar, com.tencent.mobileqq.zplan.friend.changerole.model.a aVar) {
            this.f445665b = activity;
            this.f445666c = lifecycleOwner;
            this.f445667d = baVar;
            this.f445668e = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(h this$0, Activity activity, LifecycleOwner owner, ba binding, com.tencent.mobileqq.zplan.friend.changerole.model.a viewModel) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(owner, "$owner");
            Intrinsics.checkNotNullParameter(binding, "$binding");
            Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
            this$0.k(activity, owner, binding, viewModel);
        }

        @Override // com.tencent.mobileqq.zplan.friend.changerole.model.a.c
        public void onInitFinish() {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final h hVar = h.this;
            final Activity activity = this.f445665b;
            final LifecycleOwner lifecycleOwner = this.f445666c;
            final ba baVar = this.f445667d;
            final com.tencent.mobileqq.zplan.friend.changerole.model.a aVar = this.f445668e;
            uIHandlerV2.post(new Runnable() { // from class: wh3.i
                @Override // java.lang.Runnable
                public final void run() {
                    h.b.b(h.this, activity, lifecycleOwner, baVar, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(h this$0, ba binding, Activity activity, com.tencent.mobileqq.zplan.friend.changerole.model.a viewModel, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        this$0.p(binding, activity, viewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Activity activity, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(h this$0, com.tencent.mobileqq.zplan.friend.changerole.model.a viewModel, Activity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        try {
            if (this$0.isUseInLittleWorld) {
                ArrayList<String> S1 = viewModel.S1();
                Intent intent = new Intent();
                intent.putStringArrayListExtra("uin_key", S1);
                intent.putExtra("lua_key", viewModel.R1(S1).toString());
                activity.setResult(-1, intent);
            } else {
                ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
                JSONObject U1 = viewModel.U1();
                Intrinsics.checkNotNullExpressionValue(U1, "viewModel.finalUinJsonStr");
                a.C10063a.d(zPlanLuaBridge, "N2L_SameStyle_OnFriendChoosen", U1, null, false, 12, null);
            }
            activity.onBackPressed();
        } catch (Exception e16) {
            QLog.e("ZplaneChangeRoleViewBinder", 1, e16, new Object[0]);
        }
    }

    private final void p(ba binding, Activity activity, com.tencent.mobileqq.zplan.friend.changerole.model.a viewModel) {
        Integer value = viewModel.T1().getValue();
        binding.f399026g.setText(activity.getString(R.string.xtc, value != null ? Integer.valueOf(value.intValue() + 1) : null, Integer.valueOf(viewModel.a2())));
    }

    public final void j(LifecycleOwner owner, Activity activity, ba binding, com.tencent.mobileqq.zplan.friend.changerole.model.a viewModel) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        m(activity, binding, viewModel);
        viewModel.b2(new b(activity, owner, binding, viewModel));
    }

    public final void k(final Activity activity, LifecycleOwner owner, final ba binding, final com.tencent.mobileqq.zplan.friend.changerole.model.a viewModel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        AppInterface Q1 = viewModel.Q1();
        Intrinsics.checkNotNullExpressionValue(Q1, "viewModel.app");
        com.tencent.mobileqq.zplan.friend.e eVar = new com.tencent.mobileqq.zplan.friend.e(Q1);
        binding.f399025f.setViewModelAndObserveData(owner, viewModel, eVar);
        binding.f399028i.setLiveDataAndObserverData(owner, viewModel, eVar);
        viewModel.T1().observe(owner, new Observer() { // from class: wh3.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.l(h.this, binding, activity, viewModel, (Integer) obj);
            }
        });
    }

    public final void m(final Activity activity, ba binding, final com.tencent.mobileqq.zplan.friend.changerole.model.a viewModel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        binding.f399021b.setOnClickListener(new View.OnClickListener() { // from class: wh3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.n(activity, view);
            }
        });
        binding.f399022c.setOnClickListener(new View.OnClickListener() { // from class: wh3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.o(h.this, viewModel, activity, view);
            }
        });
        p(binding, activity, viewModel);
    }

    public final void q(boolean z16) {
        this.isUseInLittleWorld = z16;
    }
}
