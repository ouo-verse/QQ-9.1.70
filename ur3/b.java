package ur3;

import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f439878a;

    /* renamed from: b, reason: collision with root package name */
    private String f439879b;

    /* renamed from: c, reason: collision with root package name */
    private String f439880c;

    /* renamed from: d, reason: collision with root package name */
    private final String f439881d;

    /* renamed from: e, reason: collision with root package name */
    private final String f439882e = "PandoraEx";

    /* renamed from: f, reason: collision with root package name */
    private final String f439883f = "0.9.15-rc2+build.1";

    public b(String str) {
        this.f439881d = str;
    }

    public void a(a aVar) {
        this.f439878a = aVar.b();
        this.f439879b = aVar.c();
        this.f439880c = aVar.d();
    }

    public String b() {
        return "platform=" + this.f439881d + ContainerUtils.FIELD_DELIMITER + "app_id=" + this.f439878a + ContainerUtils.FIELD_DELIMITER + "app_version=" + this.f439880c + ContainerUtils.FIELD_DELIMITER + "app_name=" + this.f439879b + ContainerUtils.FIELD_DELIMITER + "sdk_name=" + this.f439882e + ContainerUtils.FIELD_DELIMITER + "sdk_version=" + this.f439883f;
    }
}
