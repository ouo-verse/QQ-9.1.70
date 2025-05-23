package ul;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.CompoundButton;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.k;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.widget.Switch;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends k {

    /* renamed from: d, reason: collision with root package name */
    private d f439128d;

    /* renamed from: e, reason: collision with root package name */
    private Switch f439129e;

    /* renamed from: f, reason: collision with root package name */
    private String f439130f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f439131a;

        public a(c cVar) {
            this.f439131a = new WeakReference<>(cVar);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            c cVar;
            WeakReference<c> weakReference = this.f439131a;
            if (weakReference == null || (cVar = weakReference.get()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            if (TextUtils.equals("clck", str)) {
                hashMap.put("switch_click_type", Integer.valueOf(!cVar.f439129e.isChecked() ? 1 : 0));
            }
            return hashMap;
        }
    }

    private void G9() {
        this.f439128d.L1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: ul.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.this.J9((Boolean) obj);
            }
        });
    }

    private void H9() {
        if (TextUtils.isEmpty(this.f439130f)) {
            return;
        }
        fo.c.o(this.f439129e, this.f439130f, new fo.b().l(new HashMap()).h(new a(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        com.tencent.xaction.log.b.a("QZoneSyncFriendFeedPart", 1, "onCheckedChanged isChecked:" + z16);
        this.f439128d.O1().postValue(Boolean.valueOf(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    public void F9(String str) {
        this.f439130f = str;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f69813jr);
        if (viewStub != null) {
            I9(viewStub.inflate());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f439128d = (d) getViewModel(d.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9(Boolean bool) {
        if (bool != null) {
            this.f439129e.setChecked(bool.booleanValue());
        }
        com.tencent.xaction.log.b.a("QZoneSyncFriendFeedPart", 1, "[initDraftInfo] isChecked:" + bool);
    }

    private void I9(View view) {
        Switch r26 = (Switch) view.findViewById(R.id.f69803jq);
        this.f439129e = r26;
        r26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ul.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                c.this.K9(compoundButton, z16);
            }
        });
        H9();
        G9();
    }
}
