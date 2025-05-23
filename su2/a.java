package su2;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Map;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends d {

    /* renamed from: o, reason: collision with root package name */
    private Map<String, String> f434767o;

    /* renamed from: p, reason: collision with root package name */
    private String f434768p;

    public a(String str, String str2, String str3, Map<String, String> map) {
        super(null, "", "", str2, str3);
        this.f434768p = str;
        this.f434767o = map;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public String q() {
        String str;
        String c16 = y.c(this.f434767o);
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(this.f434768p)) {
            str = this.f434768p;
        } else {
            str = "https://lives.l.qq.com/livemsg?";
        }
        sb5.append(str);
        if (c16.length() > 0 && sb5.toString().contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(c16);
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void t(g gVar) {
        e.h(this, this.f304054g, gVar);
    }
}
