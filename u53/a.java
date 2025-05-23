package u53;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.io.File;
import u53.h;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f438360a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f438361b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f438362c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f438363d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f438364e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f438365f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f438366g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f438367h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f438368i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f438369j;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(h.a.f438427c);
        String str = File.separator;
        sb5.append(str);
        sb5.append("editor");
        String sb6 = sb5.toString();
        f438360a = sb6;
        f438361b = sb6 + str + ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS;
        f438362c = sb6 + str + JsonUtils.KEY_BGM;
        f438363d = sb6 + str + "comic";
        f438364e = sb6 + str + QQWinkConstants.TAB_TTS;
        f438365f = sb6 + str + "ai_elimination";
        f438366g = sb6 + str + AIInput.KEY_FRAME;
        f438367h = sb6 + str + "online_asset";
        f438368i = sb6 + str + "online_media";
        f438369j = sb6 + str + "qzone_daily";
    }
}
