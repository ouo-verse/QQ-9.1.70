package x8;

import android.graphics.Color;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends j {

    /* renamed from: h, reason: collision with root package name */
    private Pattern f447396h;

    public c(Pattern pattern) {
        super(pattern);
        this.f447396h = pattern;
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList) {
        String str;
        String str2;
        String str3;
        Matcher matcher = this.f447396h.matcher(this.f447411e);
        if (matcher.find()) {
            str2 = matcher.group(1).trim();
            str3 = matcher.group(2).trim();
            str = matcher.group(3).trim();
        } else {
            str = "#FFFFFF";
            str2 = "";
            str3 = str2;
        }
        UrlCell urlCell = new UrlCell(str3, str2, "");
        if (!TextUtils.isEmpty(str) && !str.startsWith("#")) {
            str = "#" + str;
        }
        urlCell.type = 9;
        urlCell.setClickable(false);
        try {
            urlCell.setTextColor(Color.parseColor(str));
        } catch (Exception unused) {
        }
        arrayList.add(urlCell);
        return arrayList;
    }
}
