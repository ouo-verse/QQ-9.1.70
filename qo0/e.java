package qo0;

import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e {

    /* renamed from: j, reason: collision with root package name */
    public static final int f429110j = ViewUtils.dpToPx(60.0f);

    /* renamed from: a, reason: collision with root package name */
    private final String[] f429111a = {"M2105K81AC", "M2011J18C"};

    /* renamed from: b, reason: collision with root package name */
    public boolean f429112b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f429113c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f429114d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f429115e = 0;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f429116f = a();

    /* renamed from: g, reason: collision with root package name */
    public int f429117g = 500;

    /* renamed from: h, reason: collision with root package name */
    public int f429118h = f429110j;

    /* renamed from: i, reason: collision with root package name */
    public int f429119i = 89;

    private Boolean a() {
        for (String str : this.f429111a) {
            if (str.equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                return Boolean.TRUE;
            }
        }
        return null;
    }
}
