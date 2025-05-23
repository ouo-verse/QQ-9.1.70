package xe1;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends a<ze1.b> {

    /* renamed from: e, reason: collision with root package name */
    protected final AppInterface f447847e;

    /* renamed from: f, reason: collision with root package name */
    protected Activity f447848f;

    /* renamed from: g, reason: collision with root package name */
    private final int f447849g;

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<String, String> f447850h;

    public b(@NonNull String str, @NonNull String str2, int i3, @Nullable Activity activity, @Nullable Context context, @NonNull AppInterface appInterface, int i16, HashMap<String, String> hashMap) {
        super(context, str, str2, i3);
        this.f447847e = appInterface;
        this.f447848f = activity;
        this.f447849g = i16;
        this.f447850h = hashMap;
    }

    public static HashMap<String, String> h(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page_id", str);
        hashMap.put("content_id", str2);
        return hashMap;
    }

    public AppInterface e() {
        return this.f447847e;
    }

    public String f() {
        return this.f447850h.get("content_id");
    }

    public String g() {
        return this.f447850h.get("page_id");
    }

    public int i() {
        return this.f447849g;
    }

    public int j() {
        IGProGuildInfo guildInfo = ((IGPSService) this.f447847e.getRuntimeService(IGPSService.class, "all")).getGuildInfo(this.f447844b);
        if (guildInfo != null) {
            return guildInfo.getUserType();
        }
        return -1;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        int i3 = this.f447846d;
        if (i3 != 5 && i3 != 2) {
            return false;
        }
        return true;
    }
}
