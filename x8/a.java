package x8;

import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextLayoutBase;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.widget.x;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends j {
    public a(Pattern pattern) {
        super(pattern);
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
        UserNameCell userNameCell = new UserNameCell(this.f447411e.indexOf(",superLike:") > 0 ? 19 : 3, str, i16.nameSeperate);
        userNameCell.setUin(Long.valueOf(i16.uin));
        if (i16.uin < 1000) {
            userNameCell.setTextColor(-16777216);
        }
        userNameCell.useDefaultFont = z17;
        userNameCell.useSuperFont = !z17;
        arrayList.add(userNameCell);
        return arrayList;
    }
}
