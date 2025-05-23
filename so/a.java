package so;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    Activity f434006a;

    /* renamed from: b, reason: collision with root package name */
    C11239a f434007b;

    /* compiled from: P */
    /* renamed from: so.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11239a extends BroadcastReceiver {
        C11239a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.qzone.signin.ui.activity.QZonePublishSealActivity.POST_SEAL_SUCCEED")) {
                a.this.f434006a.finish();
                a.this.f434006a.overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
            }
        }
    }

    public a(Activity activity) {
        this.f434006a = activity;
    }

    public void a() {
        this.f434007b = new C11239a();
        this.f434006a.registerReceiver(this.f434007b, new IntentFilter("com.qzone.signin.ui.activity.QZonePublishSealActivity.POST_SEAL_SUCCEED"));
    }

    public void b() {
        this.f434006a.sendBroadcast(new Intent("com.qzone.signin.ui.activity.QZonePublishSealActivity.POST_SEAL_SUCCEED"));
    }

    public void c() {
        try {
            this.f434006a.unregisterReceiver(this.f434007b);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
