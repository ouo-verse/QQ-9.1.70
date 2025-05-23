package zp3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.model.AppInfo;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.appauth_comm$AuthGroupTuple;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f452983a;

        /* renamed from: b, reason: collision with root package name */
        public final List<String> f452984b;

        /* renamed from: c, reason: collision with root package name */
        public final List<appauth_comm$AuthGroupTuple> f452985c;

        /* compiled from: P */
        /* renamed from: zp3.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        static class C11709a {

            /* renamed from: a, reason: collision with root package name */
            private boolean f452986a = false;

            /* renamed from: b, reason: collision with root package name */
            String f452987b;

            /* renamed from: c, reason: collision with root package name */
            List<String> f452988c;

            /* renamed from: d, reason: collision with root package name */
            List<appauth_comm$AuthGroupTuple> f452989d;

            /* JADX INFO: Access modifiers changed from: package-private */
            public a a() {
                if (this.f452986a) {
                    return new a(this);
                }
                return null;
            }

            public C11709a b(List<appauth_comm$AuthGroupTuple> list) {
                if (list != null) {
                    ArrayList arrayList = new ArrayList(list);
                    this.f452989d = arrayList;
                    if (!arrayList.isEmpty()) {
                        this.f452986a = true;
                    }
                }
                return this;
            }

            public C11709a c(String str) {
                this.f452987b = str;
                if (str != null && str.length() > 0) {
                    this.f452986a = true;
                }
                return this;
            }

            public C11709a d(List<String> list) {
                if (list != null) {
                    ArrayList arrayList = new ArrayList(list);
                    this.f452988c = arrayList;
                    if (!arrayList.isEmpty()) {
                        this.f452986a = true;
                    }
                }
                return this;
            }
        }

        a(C11709a c11709a) {
            this.f452983a = c11709a.f452987b;
            ArrayList arrayList = new ArrayList();
            this.f452984b = arrayList;
            List<String> list = c11709a.f452988c;
            if (list != null) {
                arrayList.addAll(list);
            }
            ArrayList arrayList2 = new ArrayList();
            this.f452985c = arrayList2;
            List<appauth_comm$AuthGroupTuple> list2 = c11709a.f452989d;
            if (list2 != null) {
                arrayList2.addAll(list2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void a(int i3, byte[] bArr, Bundle bundle, AppInfo appInfo);
    }

    void a(b bVar);

    String b(byte[] bArr);

    void c(Activity activity, int i3, String str);

    void d(Intent intent);

    String getAppId();

    Context getContext();

    String getOpenId();

    String getPackageName();
}
