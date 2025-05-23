package s8;

import NS_MOBILE_FEEDS.mobile_feeds_rsp;
import NS_MOBILE_FEEDS.single_feed;
import com.qzone.common.business.task.QZoneTask;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g extends com.qzone.adapter.feedcomponent.c {
    g() {
    }

    public static g q(QZoneTask qZoneTask) {
        g gVar = new g();
        gVar.f41880a = qZoneTask.succeeded();
        gVar.f41881b = qZoneTask.mRequest.rsp;
        gVar.f41882c = qZoneTask.mUniAttr;
        return gVar;
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public int a() {
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar == null) {
            return 0;
        }
        return mobile_feeds_rspVar.auto_load;
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public ArrayList<single_feed> b() {
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar == null) {
            return null;
        }
        return mobile_feeds_rspVar.all_feeds_data;
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public String c() {
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar == null) {
            return null;
        }
        return mobile_feeds_rspVar.attach_info;
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public Map<String, String> e() {
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar != null) {
            return mobile_feeds_rspVar.kitfileData;
        }
        return null;
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public int g() {
        Map<Integer, String> map;
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar == null || (map = mobile_feeds_rspVar.extendinfo) == null || map.isEmpty() || !mobile_feeds_rspVar.extendinfo.containsKey(1)) {
            return 0;
        }
        return Integer.valueOf(mobile_feeds_rspVar.extendinfo.get(1)).intValue();
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public int i() {
        return 0;
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public int j() {
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar == null) {
            return 0;
        }
        return mobile_feeds_rspVar.hasmore;
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public int m() {
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar == null) {
            return 0;
        }
        return mobile_feeds_rspVar.no_update;
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public String n() {
        Map<Integer, String> map;
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar == null || (map = mobile_feeds_rspVar.extendinfo) == null || map.isEmpty() || !mobile_feeds_rspVar.extendinfo.containsKey(22)) {
            return null;
        }
        return mobile_feeds_rspVar.extendinfo.get(22);
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public int o() {
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar == null) {
            return 0;
        }
        return (int) mobile_feeds_rspVar.req_count;
    }

    @Override // com.qzone.adapter.feedcomponent.c
    public String p() {
        mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) d();
        if (mobile_feeds_rspVar == null) {
            return null;
        }
        return mobile_feeds_rspVar.user_sid;
    }
}
