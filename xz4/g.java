package xz4;

import android.text.TextUtils;
import c05.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class g implements c.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wz4.b f449197a;

    public g(b bVar) {
        this.f449197a = bVar;
    }

    @Override // c05.c.a
    public final void a(Exception exc) {
        b bVar = (b) this.f449197a;
        com.xingin.xhssharesdk.i.c cVar = bVar.f449179b;
        a05.a aVar = bVar.f449178a;
        cVar.f389982d = new a05.a(aVar.f25315a, aVar.f25316b, aVar.f25317c, aVar.f25318d, false, -10000001, exc.getMessage());
        com.xingin.xhssharesdk.i.c.d(bVar.f449179b);
    }

    @Override // c05.c.a
    public final void onSuccess(String str) {
        b05.a aVar;
        b bVar = (b) this.f449197a;
        bVar.getClass();
        try {
            aVar = new b05.a();
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                aVar.f27659a = jSONObject.getInt("code");
                aVar.f27660b = jSONObject.getBoolean("success");
                aVar.f27661c = jSONObject.optString("msg");
            }
        } catch (JSONException e16) {
            bVar.f449179b.f389992n.w("XhsShare_Sdk", "CheckTokenResponse convert from json Error!", e16);
            aVar = new b05.a();
        }
        if (aVar.f27660b) {
            b bVar2 = (b) this.f449197a;
            bVar2.getClass();
            com.xingin.xhssharesdk.i.c cVar = bVar2.f449179b;
            cVar.f389982d = bVar2.f449178a;
            com.xingin.xhssharesdk.i.c.d(cVar);
            return;
        }
        wz4.b bVar3 = this.f449197a;
        int i3 = aVar.f27659a;
        Exception exc = new Exception(aVar.f27661c);
        b bVar4 = (b) bVar3;
        com.xingin.xhssharesdk.i.c cVar2 = bVar4.f449179b;
        a05.a aVar2 = bVar4.f449178a;
        cVar2.f389982d = new a05.a(aVar2.f25315a, aVar2.f25316b, aVar2.f25317c, aVar2.f25318d, false, i3, exc.getMessage());
        com.xingin.xhssharesdk.i.c.d(bVar4.f449179b);
    }
}
