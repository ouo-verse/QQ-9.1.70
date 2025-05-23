package xb2;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.now.widget.DecoratorViewPager;
import com.tencent.mobileqq.now.widget.SimpleCircleIndicator;
import com.tencent.mobileqq.qqlive.api.msg.IQQLiveMsgApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends qb2.d {
    private c C;
    private SimpleCircleIndicator D;
    private ViewPager.OnPageChangeListener E;

    /* renamed from: e, reason: collision with root package name */
    private int f447760e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f447761f;

    /* renamed from: h, reason: collision with root package name */
    private BaseActivity f447762h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f447763i;

    /* renamed from: m, reason: collision with root package name */
    private DecoratorViewPager f447764m;

    public g(BaseActivity baseActivity, RecyclerView recyclerView, View view) {
        super(view);
        this.f447761f = false;
        this.E = new a();
        this.f447762h = baseActivity;
        this.f447763i = (TextView) view.findViewById(R.id.z5n);
        DecoratorViewPager decoratorViewPager = (DecoratorViewPager) view.findViewById(R.id.kwk);
        this.f447764m = decoratorViewPager;
        decoratorViewPager.setNestedpParent(recyclerView);
        c cVar = new c(baseActivity);
        this.C = cVar;
        this.f447764m.setAdapter(cVar);
        this.f447764m.setOnPageChangeListener(this.E);
        SimpleCircleIndicator simpleCircleIndicator = (SimpleCircleIndicator) view.findViewById(R.id.twv);
        this.D = simpleCircleIndicator;
        simpleCircleIndicator.setViewPager(this.f447764m);
        this.D.setMaxCount(4);
        k();
    }

    private void j() {
        View view = this.itemView;
        if (view != null) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
            this.itemView.setLayoutParams(layoutParams);
        }
    }

    private void k() {
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(new Contact(103, "u_e-JqR-NMXv0we_lZH5k1uA", ""), 0L, 5, true, new IMsgOperateCallback() { // from class: xb2.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                g.this.m(i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(ArrayList arrayList) {
        int size;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                MsgRecord msgRecord = (MsgRecord) arrayList.get(size2);
                if (msgRecord.getMsgType() == 11) {
                    arrayList2.add(msgRecord);
                }
            }
        }
        this.C.j(arrayList2);
        if (arrayList2.size() > 0) {
            QLog.d("MessageReceivingHolder", 1, "initData show banner, item size=", Integer.valueOf(arrayList2.size()));
            if (this.f447760e < arrayList2.size()) {
                size = this.f447760e;
            } else {
                size = arrayList2.size() - 1;
            }
            MsgRecord f16 = this.C.f(size);
            q(f16);
            this.f447764m.setCurrentItem(size);
            this.f447764m.invalidate();
            if (size <= 3) {
                bc2.a.e(size + 1, ((IQQLiveMsgApi) QRoute.api(IQQLiveMsgApi.class)).getAdIdFromMsgRecord(f16), "1");
            }
            r();
            return;
        }
        QLog.d("MessageReceivingHolder", 1, "initData hide banner");
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i3, String str, final ArrayList arrayList) {
        QLog.d("MessageReceivingHolder", 1, "initData getMsgs result=", Integer.valueOf(i3), ", errMsg=", str);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: xb2.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.l(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(int i3, String str) {
        QLog.d("MessageReceivingHolder", 1, "setMsgReaded result=", Integer.valueOf(i3), ", errMsg=", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(MsgRecord msgRecord) {
        if (msgRecord != null) {
            this.f447763i.setText(en.e(this.f447762h, 3, msgRecord.getMsgTime() * 1000, true));
        }
    }

    private void r() {
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(103, "u_e-JqR-NMXv0we_lZH5k1uA", ""), new IOperateCallback() { // from class: xb2.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                g.n(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        IPublicAccountDetail iPublicAccountDetail;
        String str;
        IPublicAccountDataManager iPublicAccountDataManager;
        AppInterface b16 = com.tencent.mobileqq.now.netchannel.websso.e.b();
        if (b16 != null && (iPublicAccountDataManager = (IPublicAccountDataManager) b16.getRuntimeService(IPublicAccountDataManager.class, "all")) != null) {
            iPublicAccountDetail = iPublicAccountDataManager.findAccountDetailInfo(qb2.a.f428781a);
        } else {
            iPublicAccountDetail = null;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        intent.setComponent(new ComponentName(this.f447762h, (Class<?>) ChatActivity.class));
        bundle.putString("uin", qb2.a.f428781a);
        bundle.putInt("uintype", 1008);
        if (iPublicAccountDetail != null) {
            str = iPublicAccountDetail.getName();
        } else {
            str = "";
        }
        bundle.putString("uinname", str);
        intent.putExtras(bundle);
        intent.setFlags(67108864);
        intent.putExtra("isforceRequestDetail", false);
        intent.putExtra("jump_from", 2);
        this.f447762h.startActivity(intent);
    }

    public void o() {
        c cVar = this.C;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    public void p() {
        if (!this.f447761f) {
            k();
        } else {
            this.f447761f = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f447765d = false;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            if (i3 == 3 && f16 > 0.4f) {
                if (this.f447765d) {
                    this.f447765d = false;
                    g.this.s();
                }
                g.this.f447764m.setCurrentItem(3);
            }
            if (f16 == 0.0f) {
                this.f447765d = true;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            g.this.f447760e = i3;
            if (i3 >= 0 && i3 < g.this.C.getF373114d()) {
                MsgRecord f16 = g.this.C.f(i3);
                g.this.q(f16);
                if (i3 <= 3) {
                    bc2.a.e(i3 + 1, ((IQQLiveMsgApi) QRoute.api(IQQLiveMsgApi.class)).getAdIdFromMsgRecord(f16), "1");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }
    }
}
