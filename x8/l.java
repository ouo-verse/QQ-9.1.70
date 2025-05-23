package x8;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.util.am;
import com.qzone.widget.x;
import com.qzonex.utils.richtext.element.CustomUrlElement;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class l extends j {

    /* renamed from: h, reason: collision with root package name */
    private static String f447415h;

    /* renamed from: i, reason: collision with root package name */
    private static String f447416i;

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f447417j = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9\u00a0-\ud7ff\uf900-\ufdcf\ufdf0-\uffef][a-zA-Z0-9\u00a0-\ud7ff\uf900-\ufdcf\ufdf0-\uffef\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:\u03b4\u03bf\u03ba\u03b9\u03bc\u03ae|\u0438\u0441\u043f\u044b\u0442\u0430\u043d\u0438\u0435|\u0440\u0444|\u0441\u0440\u0431|\u05d8\u05e2\u05e1\u05d8|\u0622\u0632\u0645\u0627\u06cc\u0634\u06cc|\u0625\u062e\u062a\u0628\u0627\u0631|\u0627\u0644\u0627\u0631\u062f\u0646|\u0627\u0644\u062c\u0632\u0627\u0626\u0631|\u0627\u0644\u0633\u0639\u0648\u062f\u064a\u0629|\u0627\u0644\u0645\u063a\u0631\u0628|\u0627\u0645\u0627\u0631\u0627\u062a|\u0628\u06be\u0627\u0631\u062a|\u062a\u0648\u0646\u0633|\u0633\u0648\u0631\u064a\u0629|\u0641\u0644\u0633\u0637\u064a\u0646|\u0642\u0637\u0631|\u0645\u0635\u0631|\u092a\u0930\u0940\u0915\u094d\u0937\u093e|\u092d\u093e\u0930\u0924|\u09ad\u09be\u09b0\u09a4|\u0a2d\u0a3e\u0a30\u0a24|\u0aad\u0abe\u0ab0\u0aa4|\u0b87\u0ba8\u0bcd\u0ba4\u0bbf\u0baf\u0bbe|\u0b87\u0bb2\u0b99\u0bcd\u0b95\u0bc8|\u0b9a\u0bbf\u0b99\u0bcd\u0b95\u0baa\u0bcd\u0baa\u0bc2\u0bb0\u0bcd|\u0baa\u0bb0\u0bbf\u0b9f\u0bcd\u0b9a\u0bc8|\u0c2d\u0c3e\u0c30\u0c24\u0c4d|\u0dbd\u0d82\u0d9a\u0dcf|\u0e44\u0e17\u0e22|\u30c6\u30b9\u30c8|\u4e2d\u56fd|\u4e2d\u570b|\u53f0\u6e7e|\u53f0\u7063|\u65b0\u52a0\u5761|\u6d4b\u8bd5|\u6e2c\u8a66|\u9999\u6e2f|\ud14c\uc2a4\ud2b8|\ud55c\uad6d|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\u00a0-\ud7ff\uf900-\ufdcf\ufdf0-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");

    public l(Pattern pattern) {
        super(pattern);
    }

    @Override // x8.j
    public ArrayList<TextCell> c(int i3, boolean z16, TextLayoutBase textLayoutBase, CharSequence charSequence, ArrayList<TextCell> arrayList) {
        CustomUrlElement f16 = x.f(this.f447411e);
        f447415h = f16.url;
        f447416i = f16.post;
        if (TextUtils.isEmpty(f16.text)) {
            f16.text = com.qzone.util.l.a(R.string.f172865uv3);
        }
        if (!z16) {
            arrayList.add(new TextCell(0, f16.text));
            return arrayList;
        }
        UrlCell urlCell = new UrlCell(f16.text, f16.url, f16.post);
        if (z16) {
            urlCell.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.f157907a83));
        }
        String str = f16.text;
        if (str != null && str.contains(QzoneEmotionUtils.EMO_PREFIX)) {
            return f(textLayoutBase, f16.text, i3, z16, arrayList);
        }
        arrayList.add(urlCell);
        return arrayList;
    }

    private static ArrayList<TextCell> f(TextLayoutBase textLayoutBase, CharSequence charSequence, int i3, boolean z16, ArrayList<TextCell> arrayList) {
        boolean z17;
        ArrayList arrayList2 = new ArrayList(5);
        ArrayList<TextCell> arrayList3 = new ArrayList<>();
        arrayList2.add(new e(textLayoutBase, am.f59788c));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((j) it.next()).e(charSequence.toString());
        }
        int length = charSequence.length();
        StringBuilder sb5 = new StringBuilder(length);
        new TextCell();
        new TextCell();
        new TextCell();
        ArrayList<TextCell> arrayList4 = arrayList3;
        int i16 = 0;
        boolean z18 = false;
        while (true) {
            boolean z19 = true;
            if (i16 >= length) {
                break;
            }
            Iterator it5 = arrayList2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    z19 = false;
                    break;
                }
                j jVar = (j) it5.next();
                if (jVar.d(i16)) {
                    if (sb5.length() > 0) {
                        UrlCell urlCell = new UrlCell(sb5.toString(), f447415h, f447416i);
                        if (z18) {
                            urlCell.cellIndex++;
                        }
                        arrayList.add(urlCell);
                        sb5.delete(0, sb5.length());
                        z17 = true;
                    } else {
                        z17 = z18;
                    }
                    arrayList4.clear();
                    ArrayList<TextCell> c16 = jVar.c(i3, z16, textLayoutBase, charSequence, arrayList4);
                    for (int i17 = 0; i17 < c16.size(); i17++) {
                        TextCell textCell = c16.get(i17);
                        if (textCell != null) {
                            if (z17) {
                                textCell.cellIndex++;
                            }
                            arrayList.add(textCell);
                            z17 = true;
                        }
                    }
                    arrayList4 = c16;
                    z18 = z17;
                    i16 = jVar.b() - 1;
                }
            }
            if (!z19) {
                sb5.append(charSequence.charAt(i16));
            }
            i16++;
        }
        if (sb5.length() > 0) {
            UrlCell urlCell2 = new UrlCell(sb5.toString(), f447415h, f447416i);
            urlCell2.cellIndex++;
            arrayList.add(urlCell2);
        }
        return arrayList;
    }
}
