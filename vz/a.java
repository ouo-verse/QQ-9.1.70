package vz;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import UserGrowth.stGetFollowedDramasRsp;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi.drama.c;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.e;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mz.d;
import mz.g;
import mz.h;
import tz.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f443763a = "_preview_1";

    /* renamed from: b, reason: collision with root package name */
    public static String f443764b = "_preview_2";

    /* renamed from: c, reason: collision with root package name */
    public static String f443765c = "_preview_3";

    public static List<h> b(ArrayList<stDrama> arrayList) {
        stDramaInfo stdramainfo;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null) {
            return arrayList2;
        }
        Iterator<stDrama> it = arrayList.iterator();
        while (it.hasNext()) {
            stDrama next = it.next();
            if (next != null && (stdramainfo = next.dramaInfo) != null) {
                arrayList2.add(new h().k(stdramainfo.f25116id).j(stdramainfo.coverImg).l(stdramainfo.name).n(next.showUpdate).m(stdramainfo.isPublishCompleted).h(stdramainfo.curPublishedFeedNum).i(stdramainfo.curWatchedFeedNum));
            }
        }
        return arrayList2;
    }

    public static String e(Context context, stDramaInfo stdramainfo) {
        if (stdramainfo.isPublishCompleted) {
            return context.getString(R.string.f169721x81, Integer.valueOf(stdramainfo.curPublishedFeedNum));
        }
        return context.getString(R.string.f169722x82, Integer.valueOf(stdramainfo.curPublishedFeedNum));
    }

    private static String h(String str, String str2) {
        String str3;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1282366045:
                if (str.equals("aio_red_dot")) {
                    c16 = 0;
                    break;
                }
                break;
            case -763476863:
                if (str.equals("grid_drama_card")) {
                    c16 = 1;
                    break;
                }
                break;
            case 836791522:
                if (str.equals("grid_drama_follow")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                str3 = "direct";
                break;
            case 1:
                str3 = "feeds";
                break;
            case 2:
                str3 = "feeds_history";
                break;
            default:
                str3 = "";
                break;
        }
        if (TextUtils.isEmpty(str3)) {
            return "";
        }
        return str3 + str2;
    }

    private static boolean k(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public static void l(c cVar, e eVar, boolean z16) {
        pz.a Bd = cVar.Bd();
        tz.a.u(new b(cVar.getFrom(), eVar).i(d(Bd)).g(z16).j(c(Bd)));
    }

    public static void m(c cVar, e eVar, boolean z16) {
        pz.a Bd = cVar.Bd();
        tz.a.v(new b(cVar.getFrom(), eVar).i(d(Bd)).j(c(Bd)).h(z16));
    }

    public static int c(pz.a aVar) {
        d dVar = aVar != null ? aVar.f428078f : null;
        if (dVar != null) {
            return dVar.a();
        }
        return 0;
    }

    public static String d(pz.a aVar) {
        d dVar = aVar != null ? aVar.f428078f : null;
        if (dVar != null) {
            return dVar.d();
        }
        return "";
    }

    public static String f(pz.a aVar) {
        d dVar = aVar != null ? aVar.f428078f : null;
        if (dVar != null) {
            return dVar.f();
        }
        return "";
    }

    public static String g(pz.a aVar) {
        d dVar = aVar != null ? aVar.f428078f : null;
        if (dVar != null) {
            return dVar.j();
        }
        return "";
    }

    public static int i(pz.a aVar) {
        d dVar = aVar != null ? aVar.f428078f : null;
        if (dVar == null || dVar.i() == null) {
            return 0;
        }
        return dVar.i().videoPoolType;
    }

    private static boolean j(WSPlayerManager wSPlayerManager) {
        return wSPlayerManager != null && (wSPlayerManager.A0() || wSPlayerManager.H0());
    }

    public static void n(WSDramaPageFragment wSDramaPageFragment, String str, String str2, String str3) {
        if (wSDramaPageFragment == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("drama_id", str);
        bundle.putString("current_episode_id", str2);
        k F = new k(wSDramaPageFragment.getActivity(), "drama_history", h(wSDramaPageFragment.getFrom(), str3)).M(1).F(bundle);
        a.b.c(F);
        x.f("WSDramaUtilsLog", "[WSDramaUtils.java][startVerticalPageHistory] params:" + F);
    }

    public static void o(WSDramaPageFragment wSDramaPageFragment, String str, String str2, String str3) {
        if (wSDramaPageFragment == null || bb.E()) {
            return;
        }
        WSPlayerManager U0 = wSDramaPageFragment.U0();
        if (k(str, str2) || j(U0)) {
            return;
        }
        wSDramaPageFragment.Uh(false);
        Bundle bundle = new Bundle();
        bundle.putString("drama_id", str);
        bundle.putString("current_episode_id", str2);
        k F = new k(wSDramaPageFragment.getActivity(), "drama_preview", h(wSDramaPageFragment.getFrom(), str3)).M(1).S(4097).F(bundle);
        a.b.d(F);
        pz.a Bd = wSDramaPageFragment.Bd();
        tz.a.t(str2, g(Bd), str, c(Bd), wSDramaPageFragment.getFrom());
        x.f("WSDramaUtilsLog", "[WSDramaUtils.java][startVerticalPageSeamless] params:" + F);
    }

    public static g a(stGetFollowedDramasRsp stgetfolloweddramasrsp) {
        if (stgetfolloweddramasrsp == null) {
            return null;
        }
        g gVar = new g();
        gVar.c(stgetfolloweddramasrsp.title);
        gVar.b(b(stgetfolloweddramasrsp.dramas));
        return gVar;
    }
}
