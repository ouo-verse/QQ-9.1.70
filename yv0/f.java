package yv0;

import android.content.Context;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.bottombtn.ButtonBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final IAegisLogApi f451296a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: b, reason: collision with root package name */
    private List<ButtonBean> f451297b;

    /* renamed from: c, reason: collision with root package name */
    private Context f451298c;

    /* renamed from: d, reason: collision with root package name */
    private ep4.d f451299d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f451300e;

    public f(Context context, ep4.d dVar, boolean z16) {
        ArrayList arrayList = new ArrayList();
        this.f451297b = arrayList;
        this.f451298c = context;
        this.f451299d = dVar;
        this.f451300e = z16;
        arrayList.addAll(b(context, Arrays.asList(dVar.f396949b)));
    }

    private List<ButtonBean> a(Context context, boolean z16) {
        int i3;
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ButtonBean(2, R.drawable.nls, context.getString(R.string.zfu)));
        if (z16) {
            arrayList.add(new ButtonBean(2, R.drawable.o6v, context.getString(R.string.zfp)));
        }
        arrayList.add(new ButtonBean(2, R.drawable.nlp, context.getString(R.string.zfo)));
        boolean a16 = ew0.d.a();
        if (a16) {
            i3 = R.drawable.mys;
        } else {
            i3 = R.drawable.myr;
        }
        if (a16) {
            str = context.getString(R.string.zfv) + "-\u5f00";
        } else {
            str = context.getString(R.string.zfv) + "-\u5173";
        }
        arrayList.add(new ButtonBean(2, i3, str));
        return arrayList;
    }

    private List<ButtonBean> b(Context context, List<ep4.a> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            ep4.a aVar = list.get(i3);
            if (aVar.f396940e) {
                arrayList.add(new ButtonBean(1, aVar));
            }
        }
        return arrayList;
    }

    public ep4.d c() {
        return this.f451299d;
    }

    public List<ButtonBean> d() {
        return a(this.f451298c, this.f451300e);
    }

    public List<ButtonBean> e() {
        return this.f451297b;
    }

    public void f(Context context, boolean z16) {
        this.f451296a.i("ICGameMoreBtnPanelConfig", "setSwitchDefinitionEnable:" + z16);
        this.f451300e = z16;
    }
}
