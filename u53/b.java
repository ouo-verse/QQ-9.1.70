package u53;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.io.File;
import u53.h;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f438370a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f438371b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f438372c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f438373d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f438374e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f438375f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f438376g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f438377h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f438378i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f438379j;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(h.a.f438426b);
        String str = File.separator;
        sb5.append(str);
        sb5.append("editor");
        String sb6 = sb5.toString();
        f438370a = sb6;
        f438371b = sb6 + str + DKConfiguration.Directory.RESOURCES;
        f438372c = sb6 + str + QQWinkConstants.TAB_EFFECT;
        f438373d = sb6 + str + "generated_images";
        f438374e = sb6 + str + "generated_videos";
        f438375f = sb6 + str + "generated_magic_avatars";
        f438376g = sb6 + str + "enhance_material";
        f438377h = sb6 + str + "track_sticker";
        String str2 = h.a.f438425a + str + "editor";
        f438378i = str2;
        f438379j = str2 + str + "generated_videos" + str + "cover";
    }
}
