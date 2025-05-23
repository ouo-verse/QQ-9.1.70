package x8;

import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.DynamicImageCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.qzone.widget.x;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends j {

    /* renamed from: h, reason: collision with root package name */
    private static final String f447397h = "x8.d";

    public d(Pattern pattern) {
        super(pattern);
    }

    private a f(String str) {
        a aVar = new a();
        try {
            int indexOf = str.indexOf(",from:");
            aVar.f447398a = Integer.parseInt(str.substring(8, indexOf));
            int indexOf2 = str.indexOf(",needColon:");
            aVar.f447399b = str.substring(indexOf + 6, indexOf2);
            int indexOf3 = str.indexOf(",level:");
            aVar.f447402e = Boolean.valueOf(Boolean.parseBoolean(str.substring(indexOf2 + 11, indexOf3)));
            int indexOf4 = str.indexOf(",jumpUrl:");
            aVar.f447400c = Integer.parseInt(str.substring(indexOf3 + 7, indexOf4));
            aVar.f447401d = str.substring(indexOf4 + 9, str.indexOf(",uin:"));
        } catch (Exception e16) {
            QLog.e(f447397h, 1, "parse error" + e16);
        }
        return aVar;
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList) {
        String str;
        boolean z17;
        String str2 = ",nickname:";
        if (!this.f447411e.contains(",nickname:")) {
            str2 = ",nick:";
        }
        User i16 = x.i(this.f447411e, str2);
        if (this.f447411e.startsWith("@")) {
            str = "@" + i16.nickName;
            z17 = false;
        } else {
            str = i16.nickName;
            z17 = true;
        }
        if (!z16) {
            arrayList.add(new TextCell(0, str));
            return arrayList;
        }
        DynamicImageCell dynamicImageCell = new DynamicImageCell(textLayoutBase.getAttachedView(), this.f447411e.indexOf(",superLike:") > 0 ? 19 : 3, str, i16.nameSeperate, f(this.f447411e));
        dynamicImageCell.setUin(Long.valueOf(i16.uin));
        if (i16.uin < 1000) {
            dynamicImageCell.setTextColor(-16777216);
        }
        dynamicImageCell.useDefaultFont = z17;
        dynamicImageCell.useSuperFont = !z17;
        arrayList.add(dynamicImageCell);
        return arrayList;
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f447398a;

        /* renamed from: b, reason: collision with root package name */
        public String f447399b;

        /* renamed from: c, reason: collision with root package name */
        public int f447400c;

        /* renamed from: d, reason: collision with root package name */
        public String f447401d;

        /* renamed from: e, reason: collision with root package name */
        public Boolean f447402e;

        public a() {
            this.f447398a = 0;
            this.f447399b = "";
            this.f447400c = 0;
            this.f447401d = "";
            this.f447402e = Boolean.FALSE;
        }

        public a(int i3, String str, int i16, String str2, Boolean bool) {
            this.f447398a = i3;
            this.f447399b = str;
            this.f447400c = i16;
            this.f447401d = str2;
            this.f447402e = bool;
        }
    }
}
